package GamesCompanySystem;

import java.util.*;

public class GuestInterface {
	//attribute
	static public ArrayList<Games> games = new ArrayList<Games>();
	static public int numberOfGames;
	
	//constructor
	public GuestInterface() {}
	public GuestInterface(ArrayList<Games> g) {games = g;}
	
	//setters and getters
	public void setGames(ArrayList<Games> games) {this.games = games;}
	public ArrayList<Games> getGames(){return games;}
	
	@Override //toString
    public String toString() {
        return  "The game: " + games + "\nThe discount amount: " + Discounts.discountAmount();
    }

    @Override //equals
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GuestInterface other = (GuestInterface) obj;
        if (!Objects.equals(this.games, other.games)) {
        	return false;
        }
        
        return true;
    }
		
	//this method search for a specific game
	public int searchForAGame(String n) {
		int index = 0;
		Iterator<Games> itr = games.iterator();
		while (itr.hasNext()) {
			Games search = (Games) itr.next();
			if (search.getName().equals(n)) {
				return index;
			}
			index++;
		}
		return -1;
	}
}