package GamesCompanySystem;

public class Games {
	//attributes
	private String name;
	private double price;
	private int minimumAge;
	private double rate;
	private String type;
    private int rateTimes;
	
    //constructors
	public Games() {
		name = "Unknown"; price = 0.0; minimumAge = 0; rate = 0.0; type = "Unknown"; rateTimes = 0;
	}
	public Games(String n, double p, int a, double r, String t, int i) {
		name = n; price = p; minimumAge = a; rate = r; type = t; rateTimes = i;
		GuestInterface.games.add(this);
		GuestInterface.numberOfGames++;
	}
	
	//setters and getters
	public void setName(String n) {name = n;}
	public void setPrice(double p) {price = p;}
	public void setMinimunAge(int a) {minimumAge = a;}
	public void setRate(double r) {rate = r; rateTimes++;}
	public void setType(String t) {type = t;}
	public void setRateTimes(int i) {rateTimes = i;}
	
	public String getName() {return name;}
	public double getPrice() {return price;}
	public int getMinimumAge() {return minimumAge;}
	public double getRate() {return rate;}
	public String getType() {return type;}
	public int getRateTimes() {return rateTimes;}
	
	@Override //toString
	public String toString() {
		return ("\nGame Name: " + name + "\nMinimum Age: " + minimumAge + "\nRate: "
				+ rate + "\nType: " + type + "\nRate Times: " + rateTimes + "\n");
	}
	
	@Override //equals
	public boolean equals(Object obj) {
		if (((Games)obj).getName().equals(name) &&
			((Games)obj).getPrice() == price &&
			((Games)obj).getMinimumAge() == minimumAge &&
			((Games)obj).getRate() == rate &&
			((Games)obj).getType().equals(type) &&
			((Games)obj).getRateTimes() == rateTimes)
				return true;
		return false;
	}
	
	//This method updates the rate of the game after any new customer rates it
	public void updateRate(double addedRate) {
		if(rateTimes == 0) rate = addedRate;
        else rate = (addedRate + rateTimes * rate) / (rateTimes + 1);
        rateTimes++;
	}
}