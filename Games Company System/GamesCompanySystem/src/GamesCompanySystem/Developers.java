package GamesCompanySystem;

public class Developers extends Employee{
	//attributes
    private double hours ; 
    
    //constructors
    public Developers() { super(); hours = 0;}
    public Developers(String name, int ID, String department, double salary, Date birth, double hours) {
    	super(name, ID, department, salary, birth); this.hours = hours;
    }
    
    //setters and getters
    public void setHours(double hours) {this.hours = hours;}
    public double getHours() {return hours;}
    
    @Override //abstract method from superclass
    public double computeSalary() {
    	if (hours >=35) return salary * 1.5;
        return salary;
    }

    @Override //toString
    public String toString() {return (super.toString() + ", Hours= " + hours);}
    
    @Override //equals
    public boolean equals(Object obj) {
    	if (((Developers) obj).getBirth().equals(birth) &&
    		((Developers) obj).getDepartment().equals(department) &&
    		((Developers) obj).getHours() == hours &&
    		((Developers) obj).getID() == ID &&
    		((Developers) obj).getName().equals(name) &&
    		((Developers) obj).getSalary() == salary)
    			return true;
    	return false;
    }
}