package controllers;

import models.UsersInMongo;
import play.mvc.Controller;
import play.mvc.Result;
import utils.MongodbConnection;

public class SignUpController extends Controller {
	MongodbConnection mongocon = new MongodbConnection();
	
	
	public Result signuppage(){
		return ok(views.html.signupPage.render());
	}
	public Result SignupUser(){
		String username = request().body().asFormUrlEncoded().get("username")[0];
		String password = request().body().asFormUrlEncoded().get("password")[0];
		saveuserInMongo(username,password);
		return redirect("/");
	}
	
	public boolean saveuserInMongo(String username , String password){
		UsersInMongo user = new UsersInMongo();
		user.setUsername(username);
		user.setPassword(password);
		mongocon.mongodatastore().save(user);
		/*
		 * we have to write the boolean such that if the user is saved then we have to write
		 * true or if the user already exists then we have to write false
		 * For now we can go with true 
		 */
		return true;
	}
}
