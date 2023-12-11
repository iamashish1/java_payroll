import java.util.ArrayList;

public class Payroll {
    // CONSTANTS FOR LATER CALCULATIONS
    private static final double EI_RATE = 0.0188;
    private static final double CPP_RATE = 0.0495;
    private static final double TAX_RATE = 0.2;
    private static final double RSP_RATE = 0.04;
    private static final int CURRENT_YEAR = 2023;

    // PRIVATE EMPLOYEE FIELD
    private Employee emp;

    // 0-ARGUMENT CONSTRUCTOR
    public Payroll() {
        setDefaultValues();
    }

    // 1-ARGUMENT CONSTRUCTOR
    public Payroll(Employee emp) {
        setEmp(emp);
    }

    // GETTER AND SETTERS
    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    // CALCULATE NETPAY BASED ON VARIOUS DEDUCTIONS
    public double calculateNetPay() {
        double grossPay = emp.calculatePay();
        double deductions = ei() + cpp() + tax() + rsp();
        return grossPay - deductions;
    }

    // DEFINING EI,CPP,TAX,RSP AND CALCULATING DEDUCTIONS
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

    // THIS IS A HELPER METHOD FOR PARSING DARE INTO INTEGER
    private int parseYear(String date) {
        String[] dateParts = date.split(" ");
        return Integer.parseInt(dateParts[0]);
    }

    // FORMAT THE REPORT OUPUT IN TABULAR FORM
    public static void printReport(ArrayList<Payroll> list) {

        System.out.println("\n***** Payroll Report *****");

        System.out.println("For the week ending December 2, 2022");
        System.out.println(
                "---------------- -------------  --------------------------    -------------- ------------- --------------- ------------ --------------");

        System.out.printf("%-18s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "Level", "First", "Last", "Gross Pay", "EI", "CPP", "Tax", "RSP", "Net Pay");
        System.out.println(
                "---------------- -------------  --------------------------    -------------- ------------- --------------- ------------ --------------");

        double totalGrossPay = 0.0, totalEI = 0.0, totalCPP = 0.0, totalTax = 0.0, totalRSP = 0.0, totalNetPay = 0.0;

        for (Payroll payroll : list) {
            Employee employee = payroll.getEmp();
            double grossPay = employee.calculatePay();
            double ei = payroll.ei();
            double cpp = payroll.cpp();
            double tax = payroll.tax();
            double rsp = payroll.rsp();
            double netPay = payroll.calculateNetPay();

            System.out.printf("%-18s%-15s%-15s$%-14.2f$%-14.2f$%-14.2f$%-14.2f$%-14.2f$%-14.2f\n",
                    employee.getLevel(), employee.getFirstName(), employee.getLastName(),
                    grossPay, ei, cpp, tax, rsp, netPay);

            // PLUS TOTAL
            totalGrossPay += grossPay;
            totalEI += ei;
            totalCPP += cpp;
            totalTax += tax;
            totalRSP += rsp;
            totalNetPay += netPay;
        }

        System.out.println(
                "---------------- -------------  --------------------------    -------------- ------------- --------------- ------------ --------------");

        // PRINT TOTAL WITH FORMAT IN TABULAR FORM
        System.out.printf("\n%-20s%-15s%-13s$%-14.2f$%-14.2f$%-14.2f$%-14.2f$%-14.2f$%-14.2f\n",
                "Total", "", "",
                totalGrossPay, totalEI, totalCPP, totalTax, totalRSP, totalNetPay);
        System.out.println(
                "---------------- -------------  --------------------------    -------------- ------------- --------------- ------------ --------------");

    }

    // SETTING DEFAULT VALUES METHODS
    private void setDefaultValues() {
        emp.setBirthDate(null);
        emp.setFirstName(null);
        emp.setLastName(null);
        emp.setHireDate(null);
        emp.setLevel(null);

    }
}
