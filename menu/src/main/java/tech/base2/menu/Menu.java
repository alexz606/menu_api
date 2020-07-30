package tech.base2.menu;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Menu {
	@Id
private String day;
private String protein;
private String carb;


public Menu(String day, String protein, String carb) {
	super();
	this.day = day;
	this.protein = protein;
	this.carb = carb;
}

public Menu() {

}

public String getDay() {
	return day;
}
public void setDay(String day) {
	this.day = day;
}
public String getProtein() {
	return protein;
}
public void setProtein(String protein) {
	this.protein = protein;
}
public String getCarb() {
	return carb;
}
public void setCarb(String carb) {
	this.carb = carb;
}



}
