import java.util.ArrayList;

public class Payroll {
    // Constants
    private static final double EI_RATE = 0.0188;
    private static final double CPP_RATE = 0.0495;
    private static final double TAX_RATE = 0.2;
    private static final double RSP_RATE = 0.04;
    private static final int CURRENT_YEAR = 2023;

    // Fields
    private Employee emp;

    // Constructors
    public Payroll() {
        setDefaultValues();
    }

    public Payroll(Employee emp) {
        setEmp(emp);
    }

    // Getter and setter methods
    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    // Calculate net pay method
    public double calculateNetPay() {
        double grossPay = emp.calculatePay();
        double deductions = ei() + cpp() + tax() + rsp();
        return grossPay - deductions;
    }

    // Private methods for calculating deductions
    private double ei() {
        return EI_RATE * emp.calculatePay();
    }

    private double cpp() {
        if (parseYear(emp.getBirthDate()) < (CURRENT_YEAR - 18)) {
            return CPP_RATE * emp.calculatePay();
        }
        return 0.0;
    }

    private double tax() {
        return TAX_RATE * (emp.calculatePay() - ei() - cpp());
    }

    private double rsp() {
        if ((CURRENT_YEAR) - (parseYear(emp.getHireDate())) > 2) {
            return RSP_RATE * (emp.calculatePay() - ei() - cpp() - tax());
        }
        return 0.0;
    }

    // Helper method to parse the year from the date string
    private int parseYear(String date) {
        String[] dateParts = date.split(" ");
        return Integer.parseInt(dateParts[0]);
    }

    // Static method to print the payroll report
    public static void printReport(ArrayList<Payroll> list) {
        System.out.println("for the week ending December 2, 2022");
        System.out.printf("%-10s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "Level", "First", "Last", "Gross Pay", "EI", "CPP", "Tax", "RSP", "Net Pay");
        double totalGrossPay = 0.0, totalEI = 0.0, totalCPP = 0.0, totalTax = 0.0, totalRSP = 0.0, totalNetPay = 0.0;

        for (Payroll payroll : list) {
            Employee employee = payroll.getEmp();
            double grossPay = employee.calculatePay();
            double ei = payroll.ei();
            double cpp = payroll.cpp();
            double tax = payroll.tax();
            double rsp = payroll.rsp();
            double netPay = payroll.calculateNetPay();

            System.out.printf("%-10s%-15s%-15s$%-14.2f$%-14.2f$%-14.2f$%-14.2f$%-14.2f$%-14.2f\n",
                    employee.getLevel(), employee.getFirstName(), employee.getLastName(),
                    grossPay, ei, cpp, tax, rsp, netPay);

            // Update totals
            totalGrossPay += grossPay;
            totalEI += ei;
            totalCPP += cpp;
            totalTax += tax;
            totalRSP += rsp;
            totalNetPay += netPay;
        }

        // Print totals
        System.out.printf("\n%-40s$%-14.2f$%-14.2f$%-14.2f$%-14.2f$%-14.2f$%-14.2f\n",
                "Total", totalGrossPay, totalEI, totalCPP, totalTax, totalRSP, totalNetPay);
    }

    // Set default values method
    private void setDefaultValues() {
        emp.setBirthDate(null);
        emp.setFirstName(null);
        emp.setLastName(null);
        emp.setHireDate(null);
        emp.setLevel(null);

    }
}
