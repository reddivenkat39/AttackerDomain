package controllers;

import models.UsersInMongo;
import play.mvc.Controller;
import play.mvc.Http.Cookie;
import play.mvc.Result;
import security.CookieAssigner;
import utils.MongodbConnection;

public class SigninValidateController extends Controller{
	MongodbConnection mongocon = new MongodbConnection();
	CookieAssigner cookieassigner = new CookieAssigner();
	
	
	public Result validateUsernamePassword(){
		String username=request().body().asFormUrlEncoded().get("username")[0];
		String password =request().body().asFormUrlEncoded().get("password")[0];
		if(validateUser(username,password)){
			Cookie ck = cookieassigner.setAuthenticatedCookie(username);
		return ok(views.html.validated.render()).withCookies(ck);
		}
		else
			return ok(views.html.signinhome.render("user not present"));
	}
	
	public boolean validateUser(String username , String password){
		UsersInMongo user = mongocon.mongodatastore().find(UsersInMongo.class).filter("username",username).filter("password",password).get();
		if(user!=null){
			return true;
		}
		else
		{
			return false;
		}
	}
}
