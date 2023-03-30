package GamesCompanySystem;

public class Online extends CustomerInformation {
	//attributes
	private String email;
	private String cardNumber;
	private boolean validEmail;
	private boolean validCardNumber;
    
    //constructors
    public Online() {super(); email = "Unknown";}
    public Online(String name, String number, String email) {
    	super(name, number);
    	this.email = email;
    }
    
    //setters and getters
    public void setEmail(String e) {email = e;}
    public void setCardNumber(String c) {cardNumber = c;}
	public String getEmail() {return email;}
	public String getCardNumber() {return cardNumber;}
	
	public boolean checkEmail(String email) {
		validEmail = email.contains("@") && email.contains(".com");
		return validEmail;
	}
	public boolean checkCardNumber(String cardNumber) {
		validCardNumber = cardNumber.length() == 16;
		return validCardNumber;
	}
	
	@Override //toString
	public String toString() {
		return (super.toString() + ", Email: " + email);
	}
	
	@Override //equals
	public boolean equals(Object obj) {
		if (((Online) obj).getEmail().equals(email) &&
			((Online) obj).getName().equals(name) &&
			((Online) obj).getPhoneNumber().equals(phoneNumber))
				return true;
		return false;
	}
	
	//declaring the abstract method from Shopping interface
	public String delivery() {
		return ("We will send the games' installation link to your email:");
	}
}
