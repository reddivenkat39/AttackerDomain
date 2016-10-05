package security;

import org.mongodb.morphia.query.Query;

import models.UsersInMongo;
import utils.MongodbConnection;

public class RehashingServiceInSecurity {
	/*
	 * Find the user by using the accesstoken - And match it with the username.
	 */
	MongodbConnection mongocon = new MongodbConnection();
	public String getUsernameByToken(String accesstoken){
	Query<UsersInMongo> query = mongocon.mongodatastore().createQuery(UsersInMongo.class).filter("token",accesstoken);
	UsersInMongo user = query.get();
	return user.getUsername();
	}
	
	public String findroleByUsername(String username){
		
	}
}
