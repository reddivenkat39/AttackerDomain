package security;
import org.mindrot.jbcrypt.BCrypt;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import models.UsersInMongo;
import play.mvc.Http.Cookie;
import utils.MongodbConnection;

public class CookieAssigner {
	MongodbConnection mongo = new MongodbConnection();
/*
 * The Http Cookie has the following parameters Name,Value,time,path,domain,secure,httponly
 */
	public Cookie setdefaultdomainCookie(){
		Cookie ck = new Cookie("domaincookie","localhost:9000", null, null, null, false, false);
		return ck;
	}
	
	/*
	 * This cookie will say the context of the request - for example if the user rquest a page 
	 * Then if he is not authenticated he has to be redirected to login page and then he has to 
	 * be redirected to his requested page. for this the page is attached with a redirect cookie
	 */
//	public Cookie setRedirectingCookie(Http.Request request){
//		
//	}
	
	
	/*
	 * This is a cookie for a authenticated user.
	 */
	public Cookie setAuthenticatedCookie(String username){
		String authcookie = authorizedCookieValueGenerator(username);
		/*
		 * set the same authcookie in the user database. So the cookie is same as the users
		 * Token
		 */
		String accesstoken = null;
		/*
		 *  for time being I am giving the authorization roles depending upon the username. And
		 *  The roles are hadcoded for now In future I have to chose some other vector to decide 
		 *  on the role of the user
		 */
		String role=null;
		Query<UsersInMongo> query= mongo.mongodatastore().find(UsersInMongo.class).filter("username",username);
		accesstoken = authcookie;
		UpdateOperations<UsersInMongo>	updateoperation = mongo.mongodatastore().createUpdateOperations(UsersInMongo.class).set("accesstoken",accesstoken);
		if(username.equals("venkat")||username.equals("harsha")||username.equals("jagan")||username.equals("prudvee")){
			role =  "admin";
		}
		else{
			role = "user";
		}
		UpdateOperations<UsersInMongo> updaterole = mongo.mongodatastore().createUpdateOperations(UsersInMongo.class).set("role", role);
		mongo.mongodatastore().update(query,updateoperation);
		mongo.mongodatastore().update(query,updaterole);
		Cookie ck = new Cookie("authenticatedcookie",authcookie,null,null,null,false,true);
		return ck;
	}
	
	public String authorizedCookieValueGenerator(String username){
		String cookievalue = BCrypt.hashpw(username,BCrypt.gensalt());
		System.out.println(BCrypt.hashpw(cookievalue,BCrypt.gensalt()));
		return cookievalue;
	}
	
}
