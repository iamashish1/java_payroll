import java.util.Random;

public abstract class Employee {
    private String level;
    private String firstName;
    private String lastName;
    private String hireDate;
    private String birthdate;
    private String employeeNumber;

    // Constructor
    public Employee(String level, String firstName, String lastName, String hireDate, String birthdate) {
        this.level = level;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.birthdate = birthdate;
        setEmployeeNumber();
    }

    // Getters and Setters
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

    // Private method to generate a unique employee number
    private void setEmployeeNumber() {
        this.employeeNumber = generateLevelCode() + "-" +
                lastName.toUpperCase().substring(0, 2) +
                firstName.toUpperCase().substring(0, 2) + "-" +
                generateRandomNumber(10000, 99999);
    }

    // Private method to generate the level code
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

    // Abstract method to calculate pay
    public abstract double calculatePay();

    // toString method to represent Employee fields
    @Override
    public String toString() {
        int labelWidth = 15;
        int spaceWidth = 10;

        return String.format(
                "%-" + labelWidth + "s%" + spaceWidth + "s%s\n" +
                        "%-" + labelWidth + "s%" + spaceWidth + "s%s\n" +
                        "%-" + labelWidth + "s%" + spaceWidth + "s%s\n" +
                        "%-" + labelWidth + "s%" + spaceWidth + "s%s\n" +
                        "%-" + labelWidth + "s%" + spaceWidth + "s%s\n" +
                        "%-" + labelWidth + "s%" + spaceWidth + "s%s\n",
                "Employee Level:", "", level,
                "First Name:", "", firstName,
                "Last Name:", "", lastName,
                "Hire Date:", "", hireDate,
                "Birth Date:", "", birthdate,
                "Employee Number:", "", employeeNumber);
    }

    // Helper method to generate a random number between min and max (inclusive)
    private int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
