public class Supervisor extends Employee {
    private double salary;
    private int productionRate;

    // Constructors
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

    // Set field default values
    private void setFieldDefaultValues() {
        setSalary(0.0);
        setProductionRate(0);
    }

    // Getter and setter methods
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

    // Calculate bonus method
    private double calculateBonus() {
        // Implementation of bonus calculation based on productionRate
        // You may need to adjust this based on the project specifications
        if (productionRate < 75) {
            return 0.0;
        } else if (productionRate <= 100) {
            return 0.05 * getSalary();
        } else {
            return 0.15 * getSalary();
        }
    }

    // Override calculatePay method
    @Override
    public double calculatePay() {
        return (getSalary() + calculateBonus()) / 50;
    }

    // Override toString method
    @Override
    public String toString() {
        return super.toString() +
                "Salary: $" + getSalary() +
                "\nProduction Rate: " + getProductionRate() + "%" +
                "\n Gross Pay:" + (calculatePay()) + "\n";
    }
}
