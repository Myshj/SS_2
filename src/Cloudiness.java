/**
 * Created by alexey on 26.02.16.
 */

/**
 * Represents cloudiness data.
 */
public class Cloudiness implements Cloneable {

    /**
     * Default constructor.
     * Performs initialization of scale with minimal value.
     */
    public Cloudiness() {
        setScaleInOktas(MIN_SCALE_IN_OKTAS);
    }

    /**
     * Parametrized constructor.
     * Performs initialization of scale with provided value.
     * Throws NumberFormatException if scaleInOktas is incorrect value for scale.
     * @param scaleInOktas New value for scale.
     * @throws NumberFormatException if scaleInOktas is incorrect value for scale.
     */
    public Cloudiness(final byte scaleInOktas) throws NumberFormatException {
        setScaleInOktas(scaleInOktas);
    }

    /**
     * Deep copies provided object.
     * @param other Source object to be copied.
     * @throws NullPointerException if nothing provided.
     */
    public Cloudiness(final Cloudiness other) throws NullPointerException{
        scaleInOktas = other.scaleInOktas;
    }

    /**
     * Returns current scale of cloudiness.
     * @return Current value of scale.
     */
    public byte getScaleInOktas() {
        return scaleInOktas;
    }

    /**
     * Sets new value for cloudiness scale.
     * Throws NumberFormatException if newValue is incorrect value for scale.
     * @param newValue New value for scale.
     * @throws NumberFormatException if newValue is incorrect value for scale.
     */
    public void setScaleInOktas(final byte newValue) throws NumberFormatException {
        if (!isCorrectScale(newValue)) {
            throw new NumberFormatException();
        }

        scaleInOktas = newValue;
    }

    /**
     * Performs deep copying of this object.
     * @return Deep copy of this object.
     * @throws CloneNotSupportedException
     */
    @Override
    public Cloudiness clone() throws CloneNotSupportedException {
        Cloudiness newCloudiness = (Cloudiness) super.clone();

        newCloudiness.scaleInOktas = scaleInOktas;

        return newCloudiness;
    }

    /**
     * Returns string representation of this object.
     * @return String representation of this object.
     */
    @Override
    public String toString() {
        return "ScaleInOktas: " + Byte.toString(scaleInOktas);
    }

    /**
     * Calculates hash code for this object.
     * @return Hash code of this object.
     */
    @Override
    public int hashCode() {
        return new Byte(scaleInOktas).hashCode();
    }

    /**
     * Compares two objects.
     * @param obj Other object to be compared with.
     * @return True objects are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if ((null == obj) || (getClass() != obj.getClass())) {
            return false;
        }

        Cloudiness other = (Cloudiness) obj;

        return scaleInOktas == other.scaleInOktas;
    }

    /**
     * Checks if value can safely be used as scale value.
     * @param value Value to be checked.
     * @return True if value can safely be used as scale value.
     */
    public static boolean isCorrectScale(final double value){
        return (MIN_SCALE_IN_OKTAS <= value) && (value <= MAX_SCALE_IN_OKTAS);
    }

    /**
     * Represents strength of cloudiness.
     * Can be not less than MIN_SCALE_IN_OKTAS and not greater than MAX_SCALE_IN_OKTAS.
     */
    private byte scaleInOktas;

    /**
     * Minimal value for scale of cloudiness.
     */
    public static final byte MIN_SCALE_IN_OKTAS = 0;

    /**
     * Maximal value for scale of cloudiness.
     */
    public static final byte MAX_SCALE_IN_OKTAS = 9;
}
