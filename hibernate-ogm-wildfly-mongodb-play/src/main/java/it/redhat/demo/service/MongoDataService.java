package it.redhat.demo.service;

import javax.annotation.Resource;
import javax.ejb.Stateless;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

@Stateless
public class MongoDataService {

	private static final String COLLECTION_NAME = "myCollection";

	@Resource(lookup = "java:jboss/mongodb/client")
	private MongoDatabase database;

	public void createDropCollection() {
		MongoCollection<Document> collection = database.getCollection( COLLECTION_NAME );
		if ( collection == null ) {
			database.createCollection( COLLECTION_NAME );
			collection = database.getCollection( COLLECTION_NAME );
		}

		collection.drop();
	}
}
