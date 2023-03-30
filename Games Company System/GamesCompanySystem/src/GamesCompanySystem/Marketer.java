package GamesCompanySystem;

public class Marketer extends Employee{
    //attributes
    private double grossSales;
    
    //constructors
    public Marketer() { super(); grossSales = 0;}
    public Marketer(String name, int ID, String department, double salary, Date birth, double grossSales) {
        super(name, ID, department, salary, birth);
        this.grossSales = grossSales;
    }

    //setters and getters
    public void setGrossSales(double grossSales) {this.grossSales = grossSales;}
    public double getGrossSales() {return grossSales;}
   
    @Override //abstract method from superclass
    public double computeSalary() {
    	if (grossSales >= 20) return salary * 1.3;  
    		return salary ;
    }

    @Override //toString
    public String toString() {
    	return (super.toString() + ", Gross Sales= " + grossSales);
    }
    
    @Override //equals
    public boolean equals (Object obj) {
    	if (((Marketer) obj).getBirth().equals(birth) &&
        	((Marketer) obj).getDepartment().equals(department) &&
        	((Marketer) obj).getID() == ID &&
        	((Marketer) obj).getName().equals(name) &&
        	((Marketer) obj).getSalary() == salary &&
        	((Marketer) obj).getGrossSales() == grossSales)
    			return true;
    	return false;
    }
    
   
}
