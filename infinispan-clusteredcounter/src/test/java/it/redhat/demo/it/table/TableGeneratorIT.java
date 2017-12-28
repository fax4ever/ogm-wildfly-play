package it.redhat.demo.it.table;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import org.slf4j.Logger;

import it.redhat.demo.domain.job.JobPosition;
import it.redhat.demo.domain.job.JobRepo;

import static org.junit.Assert.assertEquals;

/**
 * @author Fabio Massimo Ercoli (C) 2017 Red Hat Inc.
 */
@RunWith(Arquillian.class)
public class TableGeneratorIT {

	@Deployment
	public static WebArchive create() {
		return ShrinkWrap
			.create(WebArchive.class, "clusteredcounter-demo.war")
			.addPackages(false, "it.redhat.demo.cdi")
			.addPackages(false, "it.redhat.demo.domain.job")
			.addAsResource("META-INF/persistence.xml")
			.addAsManifestResource("MANIFEST.MF");
	}

	@Inject
	private Logger log;

	@Inject
	private JobRepo repo;

	@Test
	public void test() {

		JobPosition job = repo.add( "Domain Designer", "HR Evaluation" );
		log.info( "New Job created: {}", job );
		assertEquals(new Long( 2 ), job.getId());

	}

}
