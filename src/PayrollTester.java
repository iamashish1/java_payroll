import java.util.ArrayList;

/*
 * Project-2
 * Prog. Mobile Application Development
 * Group Members: Ashish Koirala, Anup Rayamajhi, Nazmul Nayeem
 * Purpose: To calculate the payroll report based on different factors.
 */

public class PayrollTester {
        public static void main(String[] args) {
                // STEP 1: WELCOME MESSAGE
                System.out.println("Welcome to the Payroll tester");
                System.out.println("--------------------------------------------------");

                // CREATING EMPLOYEE OBJECTS
                Supervisor supervisor1 = new Supervisor("Supervisor", "D'arcy", "French", "2001 10 31", "1976 09 08",
                                176000,
                                105);
                Worker worker1 = new Worker("Worker", "Daniel", "Van Patter", "2021 04 30", "2005 01 20", 2, 25.50, 41);
                TeamLeader teamLeader1 = new TeamLeader("Team Leader", "Judy", "Campbell", "2003 02 25", "1983 11 23",
                                1, 65.50,
                                41, 54);

                Supervisor supervisor2 = new Supervisor("Supervisor", "Janelle", "Birch", "2010 09 14", "1971 10 14",
                                96000,
                                70);
                Worker worker2 = new Worker("Worker", "Thomas", "O'Neil", "1999 06 31", "1970 05 29", 1, 45.50, 40);
                TeamLeader teamLeader2 = new TeamLeader("Team Leader", "John", "Greene", "2021 02 28", "1985 03 05", 2,
                                45.50,
                                45, 75);

                // PRINTING OBJECTS USING OVERRIDDEN TOSTRING
                System.out.println(supervisor1.toString());
                System.out.println(worker1.toString());
                System.out.println(teamLeader1.toString());
                System.out.println(supervisor2.toString());
                System.out.println(worker2.toString());
                System.out.println(teamLeader2.toString());

                // CREATING AN ARRAYLIST WITH CREATED OBJECTS
                ArrayList<Payroll> payrollList = new ArrayList<>();
                payrollList.add(new Payroll(supervisor1));
                payrollList.add(new Payroll(worker1));
                payrollList.add(new Payroll(teamLeader1));
                payrollList.add(new Payroll(supervisor2));
                payrollList.add(new Payroll(worker2));
                payrollList.add(new Payroll(teamLeader2));

                // EXECUTUNG PRINTREPORT METHOD INSIDE PAYROLL CLASS
                Payroll.printReport(payrollList, "December 2, 2022");

                // SETTING DIFFERENT REQUIREMENTS AND INSTRUCTED

                supervisor1.setProductionRate(115);

                supervisor2.setProductionRate(110);

                worker1.setHours(44);
                worker1.setRate(worker1.getRate() + 1.50);

                worker2.setHours(37);

                teamLeader1.setHours(42.75);
                teamLeader1.setCompletedTraining(teamLeader1.getCompletedTraining() + 10);

                teamLeader2.setHours(44);
                teamLeader2.setCompletedTraining(teamLeader2.getCompletedTraining() + 6);
                teamLeader2.setShift(1);

                // UPDATING CREATED ARRAYLIST WTIH UPDATED OBJECTS
                payrollList.set(0, new Payroll(supervisor1));
                payrollList.set(1, new Payroll(worker1));
                payrollList.set(2, new Payroll(teamLeader1));
                payrollList.set(3, new Payroll(supervisor2));
                payrollList.set(4, new Payroll(worker2));
                payrollList.set(5, new Payroll(teamLeader2));

                // PRINT REPORT WITH UPDATED OBJECTS
                Payroll.printReport(payrollList, "December 9, 2022");
        }
}
