import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alexey on 01.03.16.
 */
public class SpeedTest {

    private Speed speed1;

    private Speed speed2;

    private Speed speed3;

    @Before
    public void setUp() throws Exception {
        speed1 = new Speed();

        speed2 = new Speed(10.0);

        speed3 = new Speed(speed2);
    }

    @Test
    public void testDefaultConstructor() throws Exception{
        assertEquals(0.0, speed1.getAsKilometersPerHour(), 0.01);
    }

    @Test
    public void testParametrizedConstructor() throws Exception{
        assertEquals(10.0, speed2.getAsMetersPerSecond(), 0.01);
    }

    @Test
    public void testCopyConstructor() throws Exception{
        assertEquals(speed2.getAsMetersPerSecond(), speed3.getAsMetersPerSecond(), 0.01);
    }

    @Test
    public void testMetersPerSecondToKilometersPerHour() throws Exception {
        assertEquals(3.6, Speed.metersPerSecondToKilometersPerHour(1.0), 0.01);
    }

    @Test
    public void testKilometersPerHourToMetersPerSecond() throws Exception {
        assertEquals(1.0, Speed.kilometersPerHourToMetersPerSecond(3.6), 0.01);
    }

    @Test
    public void testIsCorrectSpeedCorrect() throws Exception {
        assertEquals(true, Speed.isCorrectSpeed(0.0));
    }

    @Test
    public void testIsCorrectSpeedIncorrect() throws Exception{
        assertEquals(false, Speed.isCorrectSpeed(-1.0));
    }

    @Test
    public void testClone() throws Exception {
        assertEquals(speed1.getAsMetersPerSecond(), speed1.clone().getAsMetersPerSecond(), 0.01);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("MetersPerSecond: " + speed1.getAsMetersPerSecond() + "\n" +
        "KilometersPerHour: " + speed1.getAsKilometersPerHour(), speed1.toString());
    }

    @Test
    public void testHashCodeClones() throws Exception {
        assertEquals(speed1.hashCode(), speed1.clone().hashCode());
    }

    @Test
    public void testHashCodeDifferentObjects() throws Exception{
        assertNotEquals(speed1.hashCode(), speed2.hashCode());
    }

    @Test
    public void testEqualsClones() throws Exception {
        assertEquals(true, speed1.equals(speed1.clone()));
    }

    @Test
    public void testEqualsDifferentObjects() throws Exception{
        assertEquals(false, speed1.equals(speed2));
    }

    @Test
    public void testEqualsDifferentClasses() throws Exception{
        assertEquals(false, speed1.equals(new Object()));
    }

    @Test
    public void testEqualsNull() throws Exception{
        assertEquals(false, speed1.equals(null));
    }

    @Test
    public void testGetAsMetersPerSecond() throws Exception {
        assertEquals(0.0, speed1.getAsMetersPerSecond(), 0.01);
    }

    @Test
    public void testSetAsMetersPerSecond() throws Exception {
        speed1.setAsMetersPerSecond(1.0);
        assertEquals(1.0, speed1.getAsMetersPerSecond(), 0.01);
    }

    @Test
    public void testGetAsKilometersPerHour() throws Exception {
        assertEquals(0.0, speed1.getAsKilometersPerHour(), 0.01);
    }

    @Test
    public void testSetAsKilometersPerHour() throws Exception {
        speed1.setAsKilometersPerHour(1.0);
        assertEquals(1.0, speed1.getAsKilometersPerHour(), 0.01);
    }
}