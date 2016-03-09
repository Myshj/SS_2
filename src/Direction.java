/**
 * Created by alexey on 25.02.16.
 */

/**
 * Represents direction in real world coordinates.
 */
public class Direction implements Cloneable {

    /**
     * Default constructor.
     * Performs initialization of inDegrees with zero value.
     */
    public Direction() {
        setInDegrees(0.0);
    }

    /**
     * Parametrized constructor.
     * Performs initialization of inDegrees with provided value.
     * @param inDegrees New value for inDegrees.
     */
    public Direction(final double inDegrees) {
        setInDegrees(inDegrees);
    }

    /**
     * Deep copies provided object.
     * @param other Source object to be copied.
     * @throws NullPointerException If nothing provided.
     */
    public Direction(final Direction other) throws NullPointerException{
        inDegrees = other.inDegrees;
    }

    /**
     * Performs deep copying of this object.
     * @return Deep copy of this object.
     * @throws CloneNotSupportedException
     */
    @Override
    public Direction clone() throws CloneNotSupportedException {
        Direction newDirection = (Direction) super.clone();

        newDirection.inDegrees = inDegrees;

        return newDirection;
    }

    /**
     * Returns string representation of this object.
     * @return String representation of this object.
     */
    @Override
    public String toString() {
        return "InDegrees: " + Double.toString(inDegrees);
    }

    /**
     * Calculates hash code for this object.
     * @return Hash code of this object.
     */
    @Override
    public int hashCode() {
        return new Double(inDegrees).hashCode();
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

        Direction other = (Direction) obj;

        return inDegrees == other.inDegrees;
    }

    /**
     * Returns double representation of this object.
     * @return Double representation of this object.
     */
    public double getDoubleDirectionInDegrees() {
        return inDegrees;
    }

    /**
     * Returns int representation of this object.
     * @return Int representation of this object.
     */
    public int getIntDirectionInDegrees() {
        return (int) inDegrees;
    }

    /**
     * Returns current direction as predefined value.
     * @return Current direction as predefined value.
     */
    public PredefinedDirection getAsPredefinedDirection() {
        if(inDegrees < 22.5){
            return PredefinedDirection.NORTH;
        }

        if(inDegrees < 67.5){
            return PredefinedDirection.NORTHEAST;
        }

        if(inDegrees < 112.5){
            return PredefinedDirection.EAST;
        }

        if(inDegrees < 157.5){
            return PredefinedDirection.SOUTHEAST;
        }

        if(inDegrees < 202.5){
            return PredefinedDirection.SOUTH;
        }

        if(inDegrees < 247.5){
            return PredefinedDirection.SOUTHWEST;
        }

        if(inDegrees < 292.5){
            return PredefinedDirection.WEST;
        }

        if(inDegrees < 337.5){
            return PredefinedDirection.NORTHWEST;
        }

        return PredefinedDirection.NORTH;
    }

    /**
     * Sets new value for inDegrees as newValue % DEGREES_MAX.
     * @param newValue New value for inDegrees.
     */
    public void setInDegrees(final double newValue) {
        inDegrees = newValue % DEGREES_MAX;
    }

    /**
     * Sets new value for inDegrees as newValue % DEGREES_MAX.
     * @param newValue New value for inDegrees.
     */
    public void setInDegrees(final int newValue) {
        inDegrees = (double) newValue % DEGREES_MAX;
    }

    /**
     * Maximal value for degrees values.
     */
    private static final int DEGREES_MAX = 360;

    /**
     * Represents direction in degrees.
     */
    private double inDegrees;
}
