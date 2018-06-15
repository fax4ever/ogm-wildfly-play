package it.redhat.demo.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Message {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
	private String id;

	private String user;
	private String body;

	@Temporal( TemporalType.DATE )
	private Date moment = new Date();

	public Message() {
	}

	public Message(String user, String body) {
		this.user = user;
		this.body = body;
	}

	public String getId() {
		return id;
	}

	public String getUser() {
		return user;
	}

	public String getBody() {
		return body;
	}

	public Date getMoment() {
		return moment;
	}
}
