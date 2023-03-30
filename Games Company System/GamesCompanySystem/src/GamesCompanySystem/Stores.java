package GamesCompanySystem;

import java.util.ArrayList;

public class Stores extends CustomerInformation{
	//class fields
	public static String[] stores = {"Makkah", "Alriyadh", "Alkhubar", "Jeddah", "Aldammam"};
	
	//attributes
	private String city;
	private String delivery;
	
	//constructors
	public Stores() {super(); city = "Unknown"; delivery = "Unknown";}
	public Stores(String name, String number, String city, String delivery) {
		super(name, number);
		this.city = city; this.delivery = delivery;
	}
	
	//setters and getters
	public void setCity(String c) {city = c;}
	public void setDelivery(String d) {delivery = d;}
	
	public String getCity() {return city;}
	public String getDelivry() {return delivery;}
	
	@Override //toString
	public String toString() {
		String storeLocations = "";
		for (int i = 0; i < stores.length; i++) {
			storeLocations += stores[i] + " ";
		}
		return storeLocations;
	}
	
	@Override //equals
	public boolean equals(Object obj) {
		if (((Stores) obj).getName().equals(name) &&
	    	((Stores) obj).getPhoneNumber().equals(phoneNumber) &&
	    	((Stores) obj).getCity().equals(city) &&
	    	((Stores) obj).getDelivry().equals(delivery))
	    		return true;
	    return false;
	}
	
	//declare the abstract method from Shopping interface
	public String delivery() {
		//decide the delivery type then update the quantity in the store
		switch(delivery) {
			case "Pick Up": return ("Your games are waiting for you in " + city + "'s store (;");
			case "Home Delivery": return ("We will contact you on  " + phoneNumber + "  soon to arrange delivery"); 
		}
		return("");
	}
	
	//check if we have a store in the customer's city
	public int checkStore(String s) {
		int index = 0;
		for (int i = 0; i < stores.length; i++) {
			if (s.equals(stores[i])) {
				index = i; return index;
			}
		}
		return -1;
	}
}
