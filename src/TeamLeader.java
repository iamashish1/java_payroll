//TEAMLEADER CLASS EXTENDS WORKER 
public class TeamLeader extends Worker {
    private static final int REQUIRED_TRAINING = 150;
    private static final double MONTHLY_BONUS = 100.0;
    private int completedTraining;

    // THIS IS THE CONSTRUCTION THAT SET THE DEFAULT VALUES
    public TeamLeader() {
        super();
        setFieldDefaultValues();
    }

    public TeamLeader(String level, String firstName, String lastName, String hireDate, String birthdate,
            int shift, double rate, double hours, int completedTraining) {
        super(level, firstName, lastName, hireDate, birthdate, shift, rate, hours);
        setCompletedTraining(completedTraining);
    }

    private void setFieldDefaultValues() {
        completedTraining = 0;
    }

    // DEFINING GETTERS AND SETTERS
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

    // METHOD FOR CALCULATING TRAINING LEFT
    public int calculateTrainingLeft() {
        return Math.max(0, REQUIRED_TRAINING - completedTraining);
    }

    // VERRIDING CALCULATEPAY METHOD FOR TEAMLEADER AND DEFINING ITS OWN
    // IMPLEMENTATION
    @Override
    public double calculatePay() {
        // CAULCULATE PAY WITH MONTHY BINUS DIVIDED BY 4 YIELDS WEEKLY BONUS

        return (super.calculatePay() + (MONTHLY_BONUS / 4));
    }

    // OVERRIDE TOSTRING METHOD
    // CALL PARENT TOSTRING IMPLEMENTATION
    // ADD ITS OWN IMPLEMENTATION

    @Override
    public String toString() {
        return super.toString() +
                "Training Left:    " + calculateTrainingLeft() + "\n";
    }
}
