/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package it.redhat.demo.domain.job;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

/**
 * Uses {@link TableGenerator}
 *
 * @author Fabio Massimo Ercoli (C) 2017 Red Hat Inc.
 */
@Entity
public class JobPosition {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "jobGen")
	@TableGenerator(name = "jobGen", initialValue = 1, pkColumnValue = "jobSeq")
	private Long id;

	private String title;

	private String status;

	public JobPosition() {
	}

	public JobPosition(String title, String status) {
		this.title = title;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( o == null || getClass() != o.getClass() ) {
			return false;
		}

		JobPosition that = (JobPosition) o;

		if ( id != null ? !id.equals( that.id ) : that.id != null ) {
			return false;
		}
		if ( title != null ? !title.equals( that.title ) : that.title != null ) {
			return false;
		}
		return status != null ? status.equals( that.status ) : that.status == null;

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + ( title != null ? title.hashCode() : 0 );
		result = 31 * result + ( status != null ? status.hashCode() : 0 );
		return result;
	}

	@Override
	public String toString() {
		return "JobPosition{" +
				"id=" + id +
				", title='" + title + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}
