import java.util.Random;

//DEFINING EMPLOYEE ABSTRACT CLASS AND DEFINING METHODS AND PROPERTIES BASED ON UML DIAGRAM
public abstract class Employee {
    private String level;
    private String firstName;
    private String lastName;
    private String hireDate;
    private String birthdate;
    private String employeeNumber;

    public Employee(String level, String firstName, String lastName, String hireDate, String birthdate) {
        this.level = level;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.birthdate = birthdate;
        setEmployeeNumber();
    }

    // DEFINING GETTERS AND SETTERS
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getBirthDate() {
        return birthdate;
    }

    public void setBirthDate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    // THIS METHOD IS PRIVATE
    // RESPONSIBLE FOR GENERATING RANDOM EMPLOYEE CODE
    private void setEmployeeNumber() {
        this.employeeNumber = generateLevelCode() + "-" +
                lastName.toUpperCase().substring(0, 2) +
                firstName.toUpperCase().substring(0, 2) + "-" +
                generateRandomNumber(10000, 99999);
    }

    // HELPER METHOD WHICH CHECKS THE LEVEL OF THE EMPLOYEES AND ASSIGNS 3-LETTER
    // UNIQUE CODE BASED ON THE LEVEL
    private String generateLevelCode() {
        switch (level.toLowerCase()) {
            case "supervisor":
                return "SPR";
            case "worker":
                return "WKR";
            case "team leader":
                return "LDR";
            default:
                return "UNKNOWN";
        }
    }

    // THIS IS AN ABSTRACT METHOD AND WILL BE IMPLEMENTATED BY EVERY CALSS THAT
    // EXTENDS EMPLOYEE CLASS
    public abstract double calculatePay();

    // OVERRIDING TOSTRING METHOD WITH ALL THE FIELDS AND VALUES FOR OUTPUT
    @Override
    public String toString() {

        return String.format(
                "%-15s%-2s%s\n" +
                        "%-15s%-2s%s\n" +
                        "%-15s%-2s%s\n" +
                        "%-15s%-2s%s\n" +
                        "%-15s%-2s%s\n" +
                        "%-15s%-2s%s\n",
                "Employee Level:", "", level,
                "First Name:", "", firstName,
                "Last Name:", "", lastName,
                "Hire Date:", "", hireDate,
                "Birth Date:", "", birthdate,
                "Employee Number:", "", employeeNumber);
    }

    // SUB-FUNCTION TO HELP WITH RANDOM NUMBER GENERATION FOR EMPLOYEE CODE
    // WE MAKE USE OF RANDOM() CLASS
    private int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
