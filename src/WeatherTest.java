import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alexey on 02.03.16.
 */
public class WeatherTest {

    private Weather weather1;

    private Weather weather2;

    private Weather weather3;

    @Before
    public void setUp() throws Exception {
        weather1 = new Weather();

        weather2 = new Weather(new Speed(), new Direction(), new Temperature(), new Cloudiness(), new Precipitation());

        weather3 = new Weather(weather2);
    }

    @Test
    public void testDefaultConstructor() throws Exception{
        assertEquals(true, weather1.getWindSpeed().equals(new Speed()));
        assertEquals(true, weather1.getWindDirection().equals(new Direction()));
        assertEquals(true, weather1.getTemperature().equals(new Temperature()));
        assertEquals(true, weather1.getCloudiness().equals(new Cloudiness()));
        assertEquals(true, weather1.getPrecipitation().equals(new Precipitation()));
    }

    @Test
    public void testParametrizedConstructor() throws Exception{
        assertEquals(true, weather2.getWindSpeed().equals(new Speed()));
        assertEquals(true, weather2.getWindDirection().equals(new Direction()));
        assertEquals(true, weather2.getTemperature().equals(new Temperature()));
        assertEquals(true, weather2.getCloudiness().equals(new Cloudiness()));
        assertEquals(true, weather2.getPrecipitation().equals(new Precipitation()));
    }

    @Test
    public void testCopyConstructor() throws Exception{
        assertEquals(true, weather2.getWindSpeed().equals(weather3.getWindSpeed()));
        assertEquals(true, weather2.getWindDirection().equals(weather3.getWindDirection()));
        assertEquals(true, weather2.getTemperature().equals(weather3.getTemperature()));
        assertEquals(true, weather2.getCloudiness().equals(weather3.getCloudiness()));
        assertEquals(true, weather2.getPrecipitation().equals(weather3.getPrecipitation()));
    }

    @Test
    public void testClone() throws Exception {
        Weather clone = weather1.clone();
        assertEquals(true, weather1.getWindSpeed().equals(clone.getWindSpeed()));
        assertEquals(true, weather1.getWindDirection().equals(clone.getWindDirection()));
        assertEquals(true, weather1.getTemperature().equals(clone.getTemperature()));
        assertEquals(true, weather1.getCloudiness().equals(clone.getCloudiness()));
        assertEquals(true, weather1.getPrecipitation().equals(clone.getPrecipitation()));
    }

    @Test
    public void testHashCodeClones() throws Exception {
        assertEquals(weather1.hashCode(), weather1.clone().hashCode());
    }

    @Test
    public void testHashCodeDifferentObjects() throws Exception{
        weather2.getWindSpeed().setAsKilometersPerHour(100.0);
        assertNotEquals(weather1.hashCode(), weather2.hashCode());
    }

    @Test
    public void testEqualsClones() throws Exception {
        assertEquals(true, weather1.equals(weather1.clone()));
    }

    @Test
    public void testEqualsDifferentObjects() throws Exception{
        weather1.setCloudiness(null);

        assertEquals(false, weather1.equals(weather2));
    }
}