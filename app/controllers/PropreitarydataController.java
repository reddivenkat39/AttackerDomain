package controllers;

import org.mongodb.morphia.query.Query;

import models.PropreitaryData;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http.Cookie;
import play.mvc.Result;
import security.RehashingServiceInSecurity;
import utils.MongodbConnection;

public class PropreitarydataController extends Controller {
	MongodbConnection mongocon = new MongodbConnection();
	RehashingServiceInSecurity rehashservice = new RehashingServiceInSecurity();
	public Result DataEndPoint(String drugname){
		Cookie authenticatedcookie = request().cookie("authenticatedcookie");
		String authcookie= authenticatedcookie.value();
		System.out.println(authcookie);
		String username = rehashservice.getUsernameByToken(authcookie);
		String role
		Query<PropreitaryData> query = mongocon.mongodatastore().find(PropreitaryData.class).filter("drugname",drugname);
		PropreitaryData data = query.get();
		return ok(Json.toJson(data));
	}
}
