/**
 * Created by alexey on 26.02.16.
 */

/**
 * Represents precipitation.
 */
public class Precipitation implements Cloneable {

    /**
     * Default constructor.
     * Performs initialization of scale with minimal value.
     */
    public Precipitation() {
        setScale(MIN_SCALE);
    }

    /**
     * Parametrized constructor.
     * Performs initialization of scale with provided value.
     * @param scale New value for scale.
     * @throws NumberFormatException if scale is incorrect.
     */
    public Precipitation(final byte scale) throws NumberFormatException {
        setScale(scale);
    }

    /**
     * Deep copies provided object.
     * @param other Other object to be copied.
     * @throws NullPointerException if nothing provided.
     */
    public Precipitation(final Precipitation other) throws NullPointerException{
        scale = other.scale;
    }

    /**
     * Returns deep copy of this object.
     * @return Deep copy of this object.
     * @throws CloneNotSupportedException
     */
    @Override
    public Precipitation clone() throws CloneNotSupportedException {
        Precipitation newPrecipitation = (Precipitation) super.clone();

        newPrecipitation.scale = scale;

        return newPrecipitation;
    }

    /**
     * Returns string representation of this object.
     * @return String representation of this object.
     */
    @Override
    public String toString() {
        return "Scale: " + Byte.toString(scale);
    }

    /**
     * Calculates hash code for this object.
     * @return Hash code of this object.
     */
    @Override
    public int hashCode() {
        return new Byte(scale).hashCode();
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

        Precipitation other = (Precipitation) obj;

        return scale == other.scale;
    }

    /**
     * Returns current scale of precipitation.
     * @return Current scale of precipitation.
     */
    public byte getScale() {
        return scale;
    }

    /**
     * Sets new value for current scale of precipitation.
     * @param newValue New value for current scale of precipitation.
     * @throws NumberFormatException if new value is incorrect.
     */
    public void setScale(final byte newValue) throws NumberFormatException {
        if (!isCorrectScale(newValue)) {
            throw new NumberFormatException();
        }

        scale = newValue;
    }

    /**
     * Checks if value can safely be used as a scale of precipitation.
     * @param value Value to be checked.
     * @return True if value can safely be used as a scale of precipitation.
     */
    public static boolean isCorrectScale(final byte value){
        return (MIN_SCALE <= value) && (value <= MAX_SCALE);
    }


    /**
     * Minimal value for scale.
     */
    public static final byte MIN_SCALE = 0;

    /**
     * Maximal value for scale.
     */
    public static final byte MAX_SCALE = 10;

    /**
     * Current scale of precipitation.
     */
    private byte scale;
}
