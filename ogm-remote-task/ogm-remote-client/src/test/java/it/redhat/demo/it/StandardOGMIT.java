/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package it.redhat.demo.it;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

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

	@Test
	public void test() {


	}

}
