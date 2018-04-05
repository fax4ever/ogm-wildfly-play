package it.redhat.demo.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.redhat.demo.entity.Message;

@Stateless
public class MessageService {

	@PersistenceContext
	private EntityManager em;

	public String insertMessage(String user, String body) {
		Message message = new Message( user, body );
		em.persist( message );
		return message.getId();
	}

	public Message getMessage(String id) {
		return em.find( Message.class, id );
	}

}
