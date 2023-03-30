package GamesCompanySystem;

public class Discounts {
	//class fields
	static final double JANUARY_DISCOUNT = 0.5; //new year discount
	static final double FEBRUARY_DISCOUNT = 0.2; //valentines discount
	static final double APRIL_DISCOUNT = 0.1; //spring discount
	static final double MAY_DISCOUNT = 0.15; //EID discount
	static final double SEPTEMBER_DISCOUNT = 0.65; //national day discount
	static final double NOVEMBER_DISCOUNT = 0.8; //black Friday discount
	
	//attribute
	private double newPrice;
	
	//constructors
	public Discounts() {newPrice = 0.0;}
	public Discounts(double p) {newPrice = p;}
	
	//setter and getter
	public void setNewPrice(double p) {newPrice = p;}
	public double getNewPrice() {return newPrice;}
	
	//this method compute the discount based on the current month
	public double computeDiscount(double price) {
		switch(Date.CURRENT_MONTH) {
			case 1: newPrice = (price - price * JANUARY_DISCOUNT); break;
			case 2: newPrice = (price - price * FEBRUARY_DISCOUNT); break;
			case 4: newPrice = (price - price * APRIL_DISCOUNT); break;
			case 5: newPrice = (price - price * MAY_DISCOUNT); break;
			case 9: newPrice = (price - price * SEPTEMBER_DISCOUNT); break;
			case 11: newPrice = (price - price * NOVEMBER_DISCOUNT); break;
			default: newPrice = price;
		}
		return newPrice;
	}
	
	public static double discountAmount(){
        if(Date.CURRENT_MONTH == 1) return JANUARY_DISCOUNT;
        else if(Date.CURRENT_MONTH == 2) return FEBRUARY_DISCOUNT;
        else if(Date.CURRENT_MONTH == 4) return APRIL_DISCOUNT;
        else if(Date.CURRENT_MONTH == 5) return MAY_DISCOUNT;
        else if(Date.CURRENT_MONTH == 9) return SEPTEMBER_DISCOUNT;
        else if(Date.CURRENT_MONTH == 11) return NOVEMBER_DISCOUNT;
        else return 0;
    }
	
	public static String discountMessage(){
        if (Date.CURRENT_MONTH == 1)
        	return "Yaaay! you got the (%" + (int) (JANUARY_DISCOUNT * 100) + ") NEW YEAR DISCOUNT ;)";
        else if (Date.CURRENT_MONTH == 2)
        	return "Yaaay! you got the (%" + (int) (FEBRUARY_DISCOUNT * 100) + ") VALENTINES DAY DISCOUNT ;)";
        else if(Date.CURRENT_MONTH == 4)
        	return "Yaaay! you got the (%" + (int) (APRIL_DISCOUNT * 100) + ") SPRING DISCOUNT ;)";
        else if(Date.CURRENT_MONTH == 5)
        	return "Yaaay! you got the (%" + (int) (MAY_DISCOUNT * 100) + ") EID DISCOUNT ;)";
        else if(Date.CURRENT_MONTH == 9)
        	return "Yaaay! you got the (%" + (int) (SEPTEMBER_DISCOUNT * 100) + ") NATIONAL DAY DISCOUNT ;)";
        else if(Date.CURRENT_MONTH == 11)
        	return "Yaaay! you got the (%" + (int) (NOVEMBER_DISCOUNT * 100) + ") BLACK FRIDAY DISCOUNT ;)";
        else
        	return "SORRY ); there is no discount at the moment";
    }
	
	@Override //toString
	public String toString() { return ("The new price after discount = " + newPrice);}
	
	@Override //equals
	public boolean equals(Object obj) {
		if (((Discounts) obj).getNewPrice()  == newPrice) return true;
		return false;
	}
}