/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package it.redhat.demo.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.slf4j.Logger;

import it.redhat.demo.domain.job.JobPosition;
import it.redhat.demo.domain.person.Person;
import it.redhat.demo.domain.job.JobRepo;
import it.redhat.demo.domain.person.PersonRepo;

/**
 * @author Fabio Massimo Ercoli (C) 2017 Red Hat Inc.
 */
@Path("/")
public class HRResource {

	@Inject
	private Logger log;

	@Inject
	private PersonRepo personRepo;

	@Inject
	private JobRepo jobRepo;

	@GET
	public String hello() {
		return "hello";
	}

	@POST
	public void insertValues() {

		Person person = personRepo.add( "Fabio Massimo", "Ercoli" );
		JobPosition jobPosition = jobRepo.add( "Domain Designer", "HR Evaluation" );

		log.info( "Created new Person: {}", person );
		log.info( "Created new Job Position: {}", jobPosition );

	}

}
