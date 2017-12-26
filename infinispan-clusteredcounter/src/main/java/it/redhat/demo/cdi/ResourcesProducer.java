package it.redhat.demo.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Simple resource producer for default {@link EntityManager}
 */
@ApplicationScoped
public class ResourcesProducer {

    @Produces
    @PersistenceContext
    private EntityManager em;

}
