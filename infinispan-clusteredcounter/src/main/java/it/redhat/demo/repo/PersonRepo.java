/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package it.redhat.demo.repo;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import it.redhat.demo.entity.Person;

/**
 * @author Fabio Massimo Ercoli (C) 2017 Red Hat Inc.
 */

@Stateless
public class PersonRepo {

	@Inject
	private EntityManager em;

	public Person add(String name, String surname) {

		Person person = new Person(name, surname);

		em.persist( person );

		return person;

	}


}
