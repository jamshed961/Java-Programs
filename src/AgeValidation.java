

public class AgeValidation {
	
	public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Invalid age: " + age + ". Age must be greater then 18.");
        } else {
            System.out.println("Age is valid for voting : " + age);
        }
	}
        
        public static void main(String[] args) {
				int ages[] = {20,25,5,-10};
				for(int age : ages)
				try{
				validateAge(age);					
                }
         catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        }
}


	
