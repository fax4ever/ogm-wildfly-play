package it.redhat.demo.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import org.infinispan.protostream.annotations.ProtoDoc;
import org.infinispan.protostream.annotations.ProtoField;

/**
 * @author Fabio Massimo Ercoli
 */
@Entity
@Indexed
public class Project implements Serializable {

	@Id
	private String id;

	@Field(analyze = Analyze.NO)
	private Integer code;

	@Field(analyze = Analyze.NO)
	private String name;

	@Field(analyze = Analyze.YES)
	private String description;

	public Project() {
	}

	public Project(Integer code, String name, String description) {
		this.code = code;
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if ( this == o ) return true;
		if ( o == null || getClass() != o.getClass() ) return false;
		Project project = (Project) o;
		return Objects.equals( code, project.code ) &&
				Objects.equals( name, project.name ) &&
				Objects.equals( description, project.description );
	}

	@Override
	public int hashCode() {
		return Objects.hash( code, name, description );
	}

	@Override
	public String toString() {
		return "Project{" +
				"code=" + code +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				'}';
	}

}
