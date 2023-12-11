public class Supervisor extends Employee {
    private double salary;
    private int productionRate;

    // NO ARGUMENT CONSTRUCTOR WHICH CALL THE PARENT CONSTRUCTOR WITH VALUES SET
    // EMPTY FOE EACH ARGUMENT
    public Supervisor() {
        super("", "", "", "", "");
        setFieldDefaultValues();
    }

    public Supervisor(String level, String firstName, String lastName, String hireDate, String birthdate,
            double salary, int productionRate) {
        super(level, firstName, lastName, hireDate, birthdate);
        setSalary(salary);
        setProductionRate(productionRate);
    }

    // SET THE FIELD DEFAULT VALUES
    private void setFieldDefaultValues() {
        setSalary(0.0);
        setProductionRate(0);
    }

    // DEFINING GETTERS AND SETTERS
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getProductionRate() {
        return productionRate;
    }

    public void setProductionRate(int productionRate) {
        this.productionRate = productionRate;
    }

    // THE PRIVATE METHOD FOR CALCULATING BONUS
    // BONUS IS CALCULATED BASED ON THE RPODUCTION RATE
    private double calculateBonus() {

        if (productionRate < 75) {
            return 0.0;
        } else if (productionRate <= 100) {
            return 0.05 * getSalary();
        } else {
            return 0.15 * getSalary();
        }
    }

    // OVERRIDE CALCULATE PAY AND DEFINE IMPLEMENTATION
    @Override
    public double calculatePay() {
        return (getSalary() + calculateBonus()) / 50;
    }

    // OVERRIDE TOSTRING METHOD CALL SUPER.TOSTRING() AND CONCAT WITH SOME OTHER
    // VALUES
    @Override
    public String toString() {
        return super.toString() +
                "Salary:          $" + getSalary() + "\n" +
                "Production Rate: " + getProductionRate() + "%" + "\n" +
                "Gross Pay:       " + (calculatePay()) + "\n";
    }
}
