package models;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
@Entity
public class PropreitaryData {
@Id
public String id;
public String drugname;
public String drugcomposition;
public String drugmakingprice;
public String drugsellingprice;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getDrugname() {
	return drugname;
}
public void setDrugname(String drugname) {
	this.drugname = drugname;
}
public String getDrugcomposition() {
	return drugcomposition;
}
public void setDrugcomposition(String drugcomposition) {
	this.drugcomposition = drugcomposition;
}
public String getDrugmakingprice() {
	return drugmakingprice;
}
public void setDrugmakingprice(String drugmakingprice) {
	this.drugmakingprice = drugmakingprice;
}
public String getDrugsellingprice() {
	return drugsellingprice;
}
public void setDrugsellingprice(String drugsellingprice) {
	this.drugsellingprice = drugsellingprice;
}

}
