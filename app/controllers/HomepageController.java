package controllers;

import play.mvc.Controller;
import play.mvc.Http.Cookie;
import play.mvc.Result;
import security.CookieAssigner;

public class HomepageController extends Controller{
	CookieAssigner cookieassigner = new CookieAssigner();

	/*
	 * Let us Write a login page with all the possible return types of Result
	 */
	public Result loginpage(){
		Cookie ck = cookieassigner.setdefaultdomainCookie();
		
		return ok(views.html.signinhome.render("")).withCookies(ck);
	}
}
