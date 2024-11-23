

	class Employee {
	    private String name;
	    private double salary;

	    public Employee(String name, double salary) throws InvalidSalaryException {
	        if (salary < 0) {
	            throw new InvalidSalaryException("Salary cannot be negative for employee: " + name);
	        }
	        this.name = name;
	        this.salary = salary;
	    }
	        

	    
	    public void displayInfo() {
	        System.out.println("Employee: " + name + " | Salary:" + salary);
	         }

	    
	    public double calculateAnnualSalary() {
	        return salary * 12;
	    }
	}
	
	public class EmployeeSalary {

		public static void main(String[] args) {
			try {
	        Employee emp1 = new Employee("Jamshed", 5000);
	        Employee emp2 = new Employee("Sayed", 10000);
	        Employee emp3 = new Employee("Ali", 15000);
	        emp1.displayInfo();
	        emp2.displayInfo();
	        emp3.displayInfo();
	        System.out.println("Jamshed Annual Salary: " + emp1.calculateAnnualSalary());
	        System.out.println("Sayed Annual Salary: " + emp2.calculateAnnualSalary());
	        System.out.println("Ali Annual Salary: " + emp3.calculateAnnualSalary());
	    }catch (InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        }
		
		}
	}




