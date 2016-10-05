package models;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
@Entity
public class UsersInMongo {
// the id in the mongo db has to be set by the developer
@Id
public String id;
public String username;
public String password;
public String accesstoken;
public String role;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAccesstoken() {
	return accesstoken;
}
public void setAccesstoken(String accesstoken) {
	this.accesstoken = accesstoken;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

}
