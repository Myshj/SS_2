/**
 * Created by alexey on 25.02.16.
 */

/**
 * Represents speed.
 */
public class Speed implements Cloneable {

    /**
     * Default constructor.
     * Performs initialization of speed with minimal value.
     */
    public Speed() {
        setAsMetersPerSecond(MIN_SPEED);
    }

    /**
     * Parametrized constructor.
     * Performs initialization of speed with provided value.
     * @param metersPerSecond New value for speed in meters per second.
     * @throws NumberFormatException if new value is incorrect.
     */
    public Speed(final double metersPerSecond) throws NumberFormatException {
        setAsMetersPerSecond(metersPerSecond);
    }

    /**
     * Deep copies other object.
     * @param other Source object to be copied.
     * @throws NullPointerException if nothing provided.
     */
    public Speed(final Speed other) throws NullPointerException{
        metersPerSecond = other.metersPerSecond;

        kilometersPerHour = other.kilometersPerHour;
    }

    /**
     * Converts speed in meters per second to speed in kilometers per hour.
     * @param metersPerSecond Value to be converted.
     * @return Speed in kilometers per hour.
     * @throws NumberFormatException if provided value is not correct speed.
     */
    public static double metersPerSecondToKilometersPerHour(final double metersPerSecond) throws NumberFormatException {
        if (!isCorrectSpeed(metersPerSecond)) {
            throw new NumberFormatException();
        }

        return 3.6 * metersPerSecond;
    }

    /**
     * Converts speed in kilometers per hour to speed in meters per second.
     * @param kilometersPerHour Value to be converted.
     * @return Speed in meters per second.
     * @throws NumberFormatException if provided value is not correct speed.
     */
    public static double kilometersPerHourToMetersPerSecond(final double kilometersPerHour) throws NumberFormatException {
        if (!isCorrectSpeed(kilometersPerHour)) {
            throw new NumberFormatException();
        }

        return kilometersPerHour / 3.6;
    }

    /**
     * Checks if provided value can safely be used as speed value.
     * @param value Value to be checked.
     * @return True if value can safely be used as speed value.
     */
    public static boolean isCorrectSpeed(final double value){
        return MIN_SPEED <= value;
    }

    /**
     * Returns deepcopy of this object.
     * @return Deep copy of this object.
     * @throws CloneNotSupportedException
     */
    @Override
    public Speed clone() throws CloneNotSupportedException {
        Speed newSpeed = (Speed) super.clone();

        newSpeed.metersPerSecond = metersPerSecond;

        newSpeed.kilometersPerHour = kilometersPerHour;

        return newSpeed;
    }

    /**
     * Returns string representation of this object.
     * @return String representation of this object.
     */
    @Override
    public String toString() {
        return "MetersPerSecond: " + Double.toString(metersPerSecond) + "\n" +
                "KilometersPerHour: " + Double.toString(kilometersPerHour);
    }

    /**
     * Calculates hash code for this object.
     * @return Hash code of this object.
     */
    @Override
    public int hashCode() {
        return new Double(metersPerSecond).hashCode();
    }

    /**
     * Compares two objects.
     * @param obj Other object to be compared with.
     * @return True if objects are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if ((null == obj) || (getClass() != obj.getClass())) {
            return false;
        }

        Speed other = (Speed) obj;

        return (metersPerSecond == other.metersPerSecond) && (kilometersPerHour == other.kilometersPerHour);
    }

    /**
     * Returns current speed in meters per second.
     * @return Current speed in meters per second.
     */
    public double getAsMetersPerSecond() {
        return metersPerSecond;
    }

    /**
     * Sets new value for speed in meters per second.
     * @param newValue New value for speed.
     * @throws NumberFormatException if newValue is not correct speed.
     */
    public void setAsMetersPerSecond(final double newValue) throws NumberFormatException {
        if (!isCorrectSpeed(newValue)) {
            throw new NumberFormatException();
        }

        metersPerSecond = newValue;

        kilometersPerHour = metersPerSecondToKilometersPerHour(metersPerSecond);
    }

    /**
     * Returns current speed in kilometers per hour.
     * @return Current speed in kilometers per hour.
     */
    public double getAsKilometersPerHour() {
        return kilometersPerHour;
    }

    /**
     * Sets new value for speed in kilometers per hour.
     * @param newValue New value for speed.
     * @throws NumberFormatException if newValue is not correct speed.
     */
    public void setAsKilometersPerHour(final double newValue) throws NumberFormatException {
        if (!isCorrectSpeed(newValue)) {
            throw new NumberFormatException();
        }

        kilometersPerHour = newValue;

        metersPerSecond = kilometersPerHourToMetersPerSecond(kilometersPerHour);
    }

    /**
     * Current speed in meters per second.
     */
    private double metersPerSecond;

    /**
     * Current speed in kilometers per hour.
     */
    private double kilometersPerHour;

    /**
     * Minimal value for speed.
     */
    public static int MIN_SPEED = 0;
}
