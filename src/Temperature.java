/**
 * Created by alexey on 26.02.16.
 */

/**
 * Represents temperature.
 */
public class Temperature implements Cloneable {

    /**
     * Default constructor.
     * Performs initialization of temperature with 0.0 by Celsius.
     */
    public Temperature() {
        setAsCelsius(0.0);
    }

    /**
     * Parametrized constructor.
     * Performs initialization of temperature with provided value (by Celsius).
     * @param byCelsius Temperature by Celsius.
     */
    public Temperature(final double byCelsius) {
        setAsCelsius(byCelsius);
    }

    /**
     * Deep copies other object.
     * @param other Source object to be copied.
     * @throws NullPointerException if nothing provided.
     */
    public Temperature(final Temperature other) throws NullPointerException{
        byCelsius = other.byCelsius;

        byFahrenheit = other.byFahrenheit;
    }

    /**
     * Converts temperature by Fahrenheit to temperature by Celsius.
     * @param fahrenheit Temperature to be converted.
     * @return Temperature by Celsius.
     */
    public static double fahrenheitToCelsius(final double fahrenheit) {
        return ((double)5 / 9) * (fahrenheit - 32);
    }

    /**
     * Converts temperature by Fahrenheit to temperature by Celsius.
     * @param celsius Temperature by Celsius.
     * @return Temperature by Fahrenheit.
     */
    public static double celsiusToFahrenheit(final double celsius) {
        return ((double)9 / 5) * celsius + 32;
    }

    /**
     * Returns deep copy of this object.
     * @return Deep copy of this object.
     * @throws CloneNotSupportedException
     */
    @Override
    public Temperature clone() throws CloneNotSupportedException {
        Temperature newTemperature = (Temperature) super.clone();

        newTemperature.byCelsius = byCelsius;

        newTemperature.byFahrenheit = byFahrenheit;

        return newTemperature;
    }

    /**
     * Returns string representation of this object.
     * @return String representation of this object.
     */
    @Override
    public String toString() {
        return "ByCelsius: " + Double.toString(byCelsius) + "\n" +
                "ByFahrenheit: " + Double.toString(byFahrenheit);
    }

    /**
     * Calculates hash code for this object.
     * @return Hash code of this object.
     */
    @Override
    public int hashCode() {
        return new Double(byCelsius).hashCode();
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

        Temperature other = (Temperature) obj;

        return (byCelsius == other.byCelsius) && (byFahrenheit == other.byFahrenheit);
    }

    /**
     * Returns current temperature by Fahrenheit.
     * @return Current temperature by Fahrenheit.
     */
    public double getAsFahrenheit() {
        return byFahrenheit;
    }

    /**
     * Sets new value for temperature by Fahrenheit.
     * @param newValue New value for temperature by Fahrenheit.
     */
    public void setAsFahrenheit(final double newValue) {
        byFahrenheit = newValue;

        byCelsius = fahrenheitToCelsius(byFahrenheit);
    }

    /**
     * Returns current temperature by Celsius.
     * @return Current temperature by Celsius.
     */
    public double getAsCelsius() {
        return byCelsius;
    }

    /**
     * Sets new value for temperature by Celsius.
     * @param newValue New value for temperature by Celsius.
     */
    public void setAsCelsius(final double newValue) {
        byCelsius = newValue;

        byFahrenheit = celsiusToFahrenheit(byCelsius);
    }

    /**
     * Current temperature by Celsius.
     */
    private double byCelsius;

    /**
     * Current temperature by Fahrenheit.
     */
    private double byFahrenheit;
}
