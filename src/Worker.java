public class Worker extends Employee {
    private int shift;
    private double rate;
    private double hours;

    // NO ARGUMENT CONSTRUCTOR
    // SETS ALL FIELDS TO EMPTY VALUES INITIALLY
    public Worker() {
        super("", "", "", "", "");
        setFieldDefaultValues();
    }

    // ARGUMENT CONSTRUCTOR
    public Worker(String level, String firstName, String lastName, String hireDate, String birthdate,
            int shift, double rate, double hours) {
        super(level, firstName, lastName, hireDate, birthdate);
        setShift(shift);
        setRate(rate);
        setHours(hours);
    }

    // METHOD FOR SETTING DEFAULT VALUES TO 0
    private void setFieldDefaultValues() {
        setShift(0);
        setRate(0.0);
        setHours(0.0);
    }

    // GETTERS AND SETTERS FOR WORKER CLASS
    public int getShift() {
        return shift;
    }

    public String getShiftText() {
        switch (getShift()) {
            case 1:

                return "Day (No Premium)";

            case 2:
                return "Night (Shift Premium)";

            default:
                return "I don't know";
        }
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    // OVERRIDE THE METHOD AND WRITE OWN IMPLEMENTTAITON
    @Override
    public double calculatePay() {
        double pay = getRate() * getHours();

        // SHIFT IS EITHER 1 OR 2
        // CALCULATE PAY BASED ON WHAT SHIFT IT IS
        if (getShift() == 2) {
            pay *= 1.03;
        }

        return pay;
    }

    // USING PARENT PLUS OWN IMPLEMENTATION
    @Override
    public String toString() {
        return super.toString() +
                "Shift:           " + getShiftText() + "\n" +
                "Hourly Pay Rate:  $" + getRate() + "\n" +
                "Hours Worked:     " + getHours() + "\n" +
                "Gross Pay:        " + calculatePay() + "\n";

    }
}
