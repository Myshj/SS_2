/**
 * Created by alexey on 26.02.16.
 */

/**
 * Represents weather.
 */
public class Weather implements Cloneable {

    /**
     * Default constructor.
     * Initializes all field with default values.
     */
    public Weather() {
        windSpeed = new Speed();

        windDirection = new Direction();

        temperature = new Temperature();

        cloudiness = new Cloudiness();

        precipitation = new Precipitation();
    }

    /**
     * Parametrized constructor.
     * Initializes all field with provided values.
     * @param windSpeed New wind speed.
     * @param windDirection New wind direction.
     * @param temperature New temperature.
     * @param cloudiness New cloudiness.
     * @param precipitation New precipitation.
     */
    public Weather(Speed windSpeed,
                   Direction windDirection,
                   Temperature temperature,
                   Cloudiness cloudiness,
                   Precipitation precipitation) {
        this.windSpeed = windSpeed;

        this.windDirection = windDirection;

        this.temperature = temperature;

        this.cloudiness = cloudiness;

        this.precipitation = precipitation;
    }

    /**
     * Deep copies other object.
     * @param other Source object to be copied.
     * @throws NullPointerException if nothing provided.
     * @throws CloneNotSupportedException
     */
    public Weather(Weather other) throws NullPointerException, CloneNotSupportedException {
        windSpeed = null != other.windSpeed ? other.windSpeed.clone() : null;

        windDirection = null != other.windSpeed ? other.windDirection.clone() : null;

        temperature = null != other.temperature ? other.temperature.clone() : null;

        cloudiness = null != other.cloudiness ? other.cloudiness.clone() : null;

        precipitation = null != other.precipitation ? other.precipitation.clone() : null;
    }

    /**
     * Returns deep copy of this object.
     * @return Deep copy of this object.
     * @throws CloneNotSupportedException
     */
    @Override
    public Weather clone() throws CloneNotSupportedException {
        Weather newWeather = (Weather) super.clone();


        newWeather.windSpeed = null != windSpeed ? this.windSpeed.clone() : null;

        newWeather.windDirection = null != windDirection ? this.windDirection.clone() : null;

        newWeather.temperature = null != temperature ? this.temperature.clone() : null;

        newWeather.cloudiness = null != cloudiness ? this.cloudiness.clone() : null;

        newWeather.precipitation = null != precipitation ? this.precipitation.clone() : null;

        return newWeather;
    }

    /**
     * Calculates hash code for this object.
     * @return Hash code of this object.
     */
    @Override
    public int hashCode() {
        final int prime = 23;

        int hash = 1;

        hash = null != windSpeed ? prime * hash + windSpeed.hashCode() : prime * hash;

        hash = null != windDirection ? prime * hash + windDirection.hashCode() : prime * hash;

        hash = null != temperature ? prime * hash + temperature.hashCode() : prime * hash;

        hash = null != cloudiness ? prime * hash + cloudiness.hashCode() : prime * hash;

        hash = null != precipitation ? prime * hash + precipitation.hashCode() : prime * hash;

        return hash;
    }

    /**
     * Returns string representation of this object.
     * @return String representation of this object.
     */
    @Override
    public String toString() {
        return "WindSpeed: " + (null != windSpeed ? windSpeed.toString() : "null")  + "\n" +
                "WindDirection: " + (null != windDirection ? windDirection.toString() : "null") + "\n" +
                "Temperature: " + (null != temperature ? temperature.toString() : "null") + "\n" +
                "Cloudiness: " + (null != cloudiness ? cloudiness.toString() : "null") + "\n" +
                "Precipitation: " + (null != precipitation ? precipitation.toString() : "null");
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

        Weather other = (Weather) obj;

        return (windSpeed == other.windSpeed || windSpeed != null && windSpeed.equals(other.windSpeed)) &&
                (windDirection == other.windDirection || windDirection != null && windDirection.equals(other.windDirection)) &&
                (temperature == other.temperature || temperature != null && temperature.equals(other.temperature)) &&
                (cloudiness == other.cloudiness || cloudiness != null && cloudiness.equals(other.cloudiness)) &&
                (precipitation == other.precipitation || precipitation != null && precipitation.equals(other.precipitation));
    }

    /**
     * Returns current speed of wind.
     * @return Current speed of wind.
     */
    public Speed getWindSpeed() {
        return windSpeed;
    }

    /**
     * Sets new value for speed of wind.
     * @param windSpeed New value for speed of wind.
     */
    public void setWindSpeed(Speed windSpeed) {
        this.windSpeed = windSpeed;
    }

    /**
     * Returns direction of wind.
     * @return Direction of wind.
     */
    public Direction getWindDirection() {
        return windDirection;
    }

    /**
     * Sets new value for direction of wind.
     * @param windDirection New value for direction of wind.
     */
    public void setWindDirection(Direction windDirection) {
        this.windDirection = windDirection;
    }

    /**
     * Returns temperature.
     * @return Temperature.
     */
    public Temperature getTemperature() {
        return temperature;
    }

    /**
     * Sets new value for temperature.
     * @param temperature New value for temperature.
     */
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    /**
     * Returns cloudiness.
     * @return Cloudiness.
     */
    public Cloudiness getCloudiness() {
        return cloudiness;
    }

    /**
     * Sets new value for cloudiness.
     * @param cloudiness New value for cloudiness.
     */
    public void setCloudiness(Cloudiness cloudiness) {
        this.cloudiness = cloudiness;
    }

    /**
     * Returns precipitation.
     * @return Precipitation.
     */
    public Precipitation getPrecipitation() {
        return precipitation;
    }

    /**
     * Sets new value for precipitation.
     * @param precipitation New value for precipitation.
     */
    public void setPrecipitation(Precipitation precipitation) {
        this.precipitation = precipitation;
    }

    /**
     * Current speed of wind.
     */
    private Speed windSpeed;

    /**
     * Current direction of wind.
     */
    private Direction windDirection;

    /**
     * Current temperature.
     */
    private Temperature temperature;

    /**
     * Current cloudiness.
     */
    private Cloudiness cloudiness;

    /**
     * Current precipitation.
     */
    private Precipitation precipitation;
}
