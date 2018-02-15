/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package it.redhat.demo.it;

import java.io.File;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.TargetsContainer;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

import it.redhat.demo.entity.Project;

/**
 * @author Fabio Massimo Ercoli
 */
@RunWith(Arquillian.class)
public class StandardOGMIT {

	@Deployment
	public static WebArchive create() {
		return ShrinkWrap
			.create(WebArchive.class, "ogm-remote-client.war")
				.addPackages(true, "it.redhat.demo")
				.addAsResource("META-INF/persistence.xml")
				.addAsResource("hotrodclient.properties")
				.addAsWebInfResource(new File( "src/main/webapp/WEB-INF/jboss-deployment-structure.xml"));
	}

	@Deployment(name = "infinispan", testable = false)
	@TargetsContainer("infinispan")
	public static JavaArchive getInfinispanDeployment() {

		File file = Maven.resolver()
				.resolve( "it.redhat.demo:ogm-remote-server:jar:1.0-SNAPSHOT" )
				.withoutTransitivity().asSingleFile();

		return ShrinkWrap.createFromZipFile( JavaArchive.class, file );

	}

	@Inject
	private EntityManager em;

	@Inject
	private UserTransaction utx;

	@Test
	public void test() throws Exception {

		utx.begin();

		try {
			Project entity = new Project();

			entity.setName( "Hibernate OGM" );
			entity.setCode( 777 );
			entity.setDescription( "Your NoSQL datastores. One API. - Hibernate OGM" );

			em.persist( entity );

			utx.commit();
		} catch (RuntimeException ex) {
			utx.rollback();
			throw ex;
		}


	}

}
