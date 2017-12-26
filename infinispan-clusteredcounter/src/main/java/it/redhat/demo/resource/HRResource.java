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

import it.redhat.demo.repo.JobRepo;
import it.redhat.demo.repo.PersonRepo;

/**
 * @author Fabio Massimo Ercoli (C) 2017 Red Hat Inc.
 */
@Path("/")
public class HRResource {

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

		personRepo.add( "Fabio Massimo", "Ercoli" );
		jobRepo.add( "Domain Designer", "HR Evaluation" );

	}

}
