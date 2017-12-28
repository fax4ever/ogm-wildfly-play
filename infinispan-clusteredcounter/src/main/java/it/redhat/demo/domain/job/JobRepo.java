/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package it.redhat.demo.domain.job;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import it.redhat.demo.domain.job.JobPosition;

/**
 * @author Fabio Massimo Ercoli (C) 2017 Red Hat Inc.
 */

@Stateless
public class JobRepo {

	@Inject
	private EntityManager em;

	public JobPosition add(String name, String surname) {

		JobPosition jobPosition = new JobPosition( name, surname );

		em.persist( jobPosition );

		return jobPosition;

	}


}
