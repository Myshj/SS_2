import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alexey on 01.03.16.
 */
public class TemperatureTest {

    private Temperature temperature1;

    private Temperature temperature2;

    private Temperature temperature3;

    @Before
    public void setUp() throws Exception {
        temperature1 = new Temperature();

        temperature2 = new Temperature(1.0);

        temperature3 = new Temperature(temperature2);
    }

    @Test
    public void testDefaultConstructor() throws Exception{
        assertEquals(0.0, temperature1.getAsCelsius(), 0.01);
    }

    @Test
    public void testParametrizedConstructor() throws Exception{
        assertEquals(1.0, temperature2.getAsCelsius(), 0.01);
    }

    @Test
    public void testCopyConstructor() throws Exception{
        assertEquals(temperature2.getAsCelsius(), temperature3.getAsCelsius(), 0.01);
    }

    @Test
    public void testFahrenheitToCelsius() throws Exception {
        assertEquals(-17.777, Temperature.fahrenheitToCelsius(0.0), 0.01);
    }

    @Test
    public void testCelsiusToFahrenheit() throws Exception {
        assertEquals(32.0, Temperature.celsiusToFahrenheit(0.0), 0.01);
    }

    @Test
    public void testClone() throws Exception {
        assertEquals(temperature1.getAsCelsius(), temperature1.clone().getAsCelsius(), 0.01);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("ByCelsius: " + temperature1.getAsCelsius() + "\n" +
                "ByFahrenheit: " + temperature1.getAsFahrenheit(), temperature1.toString());
    }

    @Test
    public void testHashCodeClones() throws Exception {
        assertEquals(temperature1.hashCode(), temperature1.clone().hashCode());
    }

    @Test
    public void testHashCodeDifferentObjects() throws Exception{
        assertNotEquals(temperature1.hashCode(), temperature3.hashCode());
    }

    @Test
    public void testEqualsClones() throws Exception {
        assertEquals(true, temperature1.equals(temperature1.clone()));
    }

    @Test
    public void testEqualsDifferentObjects() throws Exception{
        assertEquals(false, temperature1.equals(temperature2));
    }

    @Test
    public void testEqualsDifferentClasses() throws Exception{
        assertEquals(false, temperature1.equals(new Object()));
    }

    @Test
    public void testEqualsNull() throws Exception{
        assertEquals(false, temperature1.equals(null));
    }

    @Test
    public void testGetAsFahrenheit() throws Exception {
        assertEquals(32.0, temperature1.getAsFahrenheit(), 0.01);
    }

    @Test
    public void testSetAsFahrenheit() throws Exception {
        temperature1.setAsFahrenheit(0.0);
        assertEquals(0.0, temperature1.getAsFahrenheit(), 0.01);
    }

    @Test
    public void testGetAsCelsius() throws Exception {
        assertEquals(0.0, temperature1.getAsCelsius(), 0.01);
    }

    @Test
    public void testSetAsCelsius() throws Exception {
        temperature1.setAsCelsius(2.0);
        assertEquals(2.0, temperature1.getAsCelsius(), 0.01);
    }
}