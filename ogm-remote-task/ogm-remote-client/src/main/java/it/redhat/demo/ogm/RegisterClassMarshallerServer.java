package it.redhat.demo.ogm;

import java.util.Collections;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;

/**
 * @author Fabio Massimo Ercoli
 */
@ApplicationScoped
public class RegisterClassMarshallerServer {

	private static final String DEFAULT_HOTROD_BIND_ADDRESS = "127.0.0.1";
	private static final int DEFAULT_HOTROD_PORT = 11372;

	public void execute() {

		Configuration config = new ConfigurationBuilder()
			.addServer()
			.host(DEFAULT_HOTROD_BIND_ADDRESS).port(DEFAULT_HOTROD_PORT)
			.build();

		RemoteCacheManager remoteCacheManager = new RemoteCacheManager( config, true );

		try {
			remoteCacheManager.getCache().execute( "AddProtobufTask", Collections.emptyMap() );
		} finally {
			remoteCacheManager.stop();
		}
	}

}
