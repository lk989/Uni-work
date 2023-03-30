package GamesCompanySystem;

public abstract class CustomerInformation implements Shopping {
	//attributes
	protected String name;
	protected String phoneNumber;
	
	//constructors
	public CustomerInformation() {name = "Unknown"; phoneNumber = "0";}
	public CustomerInformation(String name, String number) {
		this.name = name; phoneNumber = number;
	}
	
	//setters and getters
	public void setName(String n) {name = n;}
	public void setPhoneNumber(String p) {phoneNumber = p;}
	
	public String getName() {return name;}
	public String getPhoneNumber() {return phoneNumber;}
	
    @Override //toString
	public String toString() {
		return ("Name: " + name + ", Phone Number: " + phoneNumber);
	}
    
    @Override //equals
    public boolean equals(Object obj) {
    	if (((CustomerInformation)obj).getName().equals(name) &&
    		((CustomerInformation)obj).getPhoneNumber().equals(phoneNumber))
    		return true;
    	return false;
    }
}
