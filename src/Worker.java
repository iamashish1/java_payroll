public class Worker extends Employee {
    private int shift;
    private double rate;
    private double hours;

    // Constructors
    public Worker() {
        super("", "", "", "", "");
        setFieldDefaultValues();
    }

    public Worker(String level, String firstName, String lastName, String hireDate, String birthdate,
            int shift, double rate, double hours) {
        super(level, firstName, lastName, hireDate, birthdate);
        setShift(shift);
        setRate(rate);
        setHours(hours);
    }

    // Set field default values
    private void setFieldDefaultValues() {
        setShift(0);
        setRate(0.0);
        setHours(0.0);
    }

    // Getter and setter methods
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

    // Override calculatePay method
    @Override
    public double calculatePay() {
        double pay = getRate() * getHours();

        // Apply shift premium for evening shift
        if (getShift() == 2) {
            pay *= 1.03;
        }

        return pay;
    }

    // Override toString method
    @Override
    public String toString() {
        return super.toString() +
                "Shift: " + getShiftText() + "\n" +
                "Hourly Pay Rate: $" + getRate() + "\n" +
                "Hours Worked: " + getHours() + "\n" +
                "Gross Pay:" + calculatePay() + "\n";

    }
}
