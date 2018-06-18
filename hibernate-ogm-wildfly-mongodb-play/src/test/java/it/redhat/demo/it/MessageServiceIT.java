/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package it.redhat.demo.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import it.redhat.demo.entity.Message;
import it.redhat.demo.service.MessageService;

/**
 * @author Fabio Massimo Ercoli
 */
@RunWith(Arquillian.class)
public class MessageServiceIT {

	@Deployment
	public static WebArchive create() {
		return ShrinkWrap
			.create(WebArchive.class, "demo.war")
				.addPackages(true, "it.redhat.demo")
				.addAsResource("META-INF/persistence.xml")
				.addAsWebInfResource(new File( "src/main/webapp/WEB-INF/jboss-deployment-structure.xml"));
	}

	@Inject
	private MessageService testSubject;

	@Test
	public void test() throws Exception {

		String messageId = testSubject.insertMessage( "favio", "I'm favio!" );
		Message message = testSubject.getMessage( messageId );

		assertNotNull( message );
		assertEquals( "favio", message.getUser() );
		assertEquals( "I'm favio!", message.getBody() );
	}
}
