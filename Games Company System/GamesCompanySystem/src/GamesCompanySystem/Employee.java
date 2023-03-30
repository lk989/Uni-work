package GamesCompanySystem;

public abstract class Employee {
	//attributes
    protected String name; 
    protected int ID; 
    protected String department; 
    protected double salary;
    protected Date birth;  
    
    //constructors
    public Employee() {name = "unknown"; ID = 0; department = "unknown"; salary = 0; }
    public Employee(String name, int ID, String department, double salary, Date birth) {
        this.name = name;
        this.ID = ID;
        this.department = department;
        this.salary = salary;
        this.birth = birth;
    }
    
    //setters and getters 
    public void setName(String name) {this.name = name;}
    public void setID(int ID) {this.ID = ID;}
    public void setDepartment(String department) {this.department = department;}
    public void setSalary(double salary) {this.salary = salary;}
    public void setBirth(Date birth) {this.birth = birth;}

    public String getName() {return name;}
    public int getID() {return ID;}
    public String getDepartment() {return department;}
    public double getSalary() {return salary;}
    public Date getBirth() {return birth;}
    
    @Override //toString
    public String toString() {
        return ("name=" + name + ", ID=" + ID + ", Department=" + department + ", Salary=" + salary + ", Birth=" + birth);
    }
    
    //abstract method that will be initialized on Marketer and Developers classes 
    public abstract double computeSalary();
    
    @Override //equals
    public boolean equals(Object obj) {
    	if (((Employee) obj).getBirth().equals(birth) &&
    		((Employee) obj).getDepartment().equals(department) &&
    		((Employee) obj).getID() == ID &&
    		((Employee) obj).getName().equals(name) &&
    		((Employee) obj).getSalary() == salary)
    			return true;
    	return false;
    }
    
}