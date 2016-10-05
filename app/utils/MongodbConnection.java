package utils;

import java.net.UnknownHostException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class MongodbConnection {

	public Datastore mongodatastore(){
		Morphia morphia = new Morphia();
		Datastore mongodatastore = null;
		try {
			MongoClient client = new MongoClient("localhost",27017);
			mongodatastore = morphia.createDatastore(client,"users");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mongodatastore;
	}
}
