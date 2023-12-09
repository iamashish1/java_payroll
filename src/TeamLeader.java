public class TeamLeader extends Worker {
    private static final int REQUIRED_TRAINING = 150;
    private static final double MONTHLY_BONUS = 100.0;
    private int completedTraining;

    // Constructors
    public TeamLeader() {
        super();
        setFieldDefaultValues();
    }

    public TeamLeader(String level, String firstName, String lastName, String hireDate, String birthdate,
            int shift, double rate, double hours, int completedTraining) {
        super(level, firstName, lastName, hireDate, birthdate, shift, rate, hours);
        setCompletedTraining(completedTraining);
    }

    // Set field default values
    private void setFieldDefaultValues() {
        completedTraining = 0;
    }

    // Getter and setter methods
    public int getRequiredTraining() {
        return REQUIRED_TRAINING;
    }

    public double getMonthlyBonus() {
        return MONTHLY_BONUS;
    }

    public int getCompletedTraining() {
        return completedTraining;
    }

    public void setCompletedTraining(int completedTraining) {
        this.completedTraining = completedTraining;
    }

    // Calculate training left method
    public int calculateTrainingLeft() {
        return Math.max(0, REQUIRED_TRAINING - completedTraining);
    }

    // Override calculatePay method
    @Override
    public double calculatePay() {
        // Calculate pay based on Worker's calculatePay() plus the monthly bonus

        return (super.calculatePay() + MONTHLY_BONUS);
    }

    // Override toString method

    @Override
    public String toString() {
        return super.toString() +
                "\nTraining Left: " + calculateTrainingLeft();
    }
}
