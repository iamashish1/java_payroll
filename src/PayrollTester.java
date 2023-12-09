import java.util.ArrayList;

public class PayrollTester {
    public static void main(String[] args) {
        // Step 1: Write a brief message to the screen
        System.out.println("Welcome to the Payroll tester");
        System.out.println("--------------------------------------------------");

        // Step 2: Create six Employee objects
        Supervisor supervisor1 = new Supervisor("Supervisor", "D'arcy", "French", "2001 10 31", "1976 09 08", 176000,
                105);
        Worker worker1 = new Worker("Worker", "Daniel", "Van Patter", "2021 04 30", "2005 01 20", 2, 25.50, 41);
        TeamLeader teamLeader1 = new TeamLeader("Team Leader", "Judy", "Campbell", "2003 02 25", "1983 11 23", 1, 65.50,
                41, 54);

        Supervisor supervisor2 = new Supervisor("Supervisor", "Janelle", "Birch", "2010 09 14", "1971 10 14", 96000,
                70);
        Worker worker2 = new Worker("Worker", "Thomas", "O'Neil", "1999 06 31", "1970 05 29", 1, 45.50, 40);
        TeamLeader teamLeader2 = new TeamLeader("Team Leader", "John", "Greene", "2021 02 28", "1985 03 05", 2, 45.50,
                45, 75);

        // Step 3: Print each object using toString()
        System.out.println(supervisor1.toString());
        System.out.println(worker1.toString());
        System.out.println(teamLeader1.toString());
        System.out.println(supervisor2.toString());
        System.out.println(worker2.toString());
        System.out.println(teamLeader2.toString());

        // Step 4: Create an ArrayList of Payroll objects
        ArrayList<Payroll> payrollList = new ArrayList<>();
        payrollList.add(new Payroll(supervisor1));
        payrollList.add(new Payroll(worker1));
        payrollList.add(new Payroll(teamLeader1));
        payrollList.add(new Payroll(supervisor2));
        payrollList.add(new Payroll(worker2));
        payrollList.add(new Payroll(teamLeader2));

        // Step 5: Print the list calling the static method printReport()
        Payroll.printReport(payrollList);

        // Step 6: Update the Employee objects for the next pay period
        // a. D’arcy French’s production rate this week is 115%
        supervisor1.setProductionRate(115);

        // b. Janelle Birch’s production rate is 110%
        supervisor2.setProductionRate(110);

        // c. Daniel Van Patter worked 44 hours and received an increase in his hourly
        // rate of $1.50
        worker1.setHours(44);
        worker1.setRate(worker1.getRate() + 1.50);

        // d. Thomas O’Neil worked 37 hours
        worker2.setHours(37);

        // e. Judy Campbell worked 42.75 hours and completed an additional 10 hours of
        // training
        teamLeader1.setHours(42.75);
        teamLeader1.setCompletedTraining(teamLeader1.getCompletedTraining() + 10);

        // f. John Greene worked 44 hours and completed an additional 6 hours of
        // training
        // John was switched to the day shift this week
        teamLeader2.setHours(44);
        teamLeader2.setCompletedTraining(teamLeader2.getCompletedTraining() + 6);
        teamLeader2.setShift(1);

        // Step 7: Update the Payroll ArrayList with the updated Employee objects
        payrollList.set(0, new Payroll(supervisor1));
        payrollList.set(1, new Payroll(worker1));
        payrollList.set(2, new Payroll(teamLeader1));
        payrollList.set(3, new Payroll(supervisor2));
        payrollList.set(4, new Payroll(worker2));
        payrollList.set(5, new Payroll(teamLeader2));

        // Step 8: Print the updated list calling the static method printReport()
        Payroll.printReport(payrollList);
    }
}
