package it.redhat.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Uses {@link SequenceGenerator}
 *
 * @author Fabio Massimo Ercoli (C) 2017 Red Hat Inc.
 */
@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personGen")
	@SequenceGenerator( name = "personGen", sequenceName = "personSeq", initialValue = 1 )
	private Long id;

	private String name;

	private String surname;

	public Person() {
	}

	public Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( o == null || getClass() != o.getClass() ) {
			return false;
		}

		Person person = (Person) o;

		if ( id != null ? !id.equals( person.id ) : person.id != null ) {
			return false;
		}
		if ( name != null ? !name.equals( person.name ) : person.name != null ) {
			return false;
		}
		return surname != null ? surname.equals( person.surname ) : person.surname == null;

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + ( name != null ? name.hashCode() : 0 );
		result = 31 * result + ( surname != null ? surname.hashCode() : 0 );
		return result;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				'}';
	}
}
