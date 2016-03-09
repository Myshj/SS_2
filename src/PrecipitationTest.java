import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alexey on 01.03.16.
 */
public class PrecipitationTest {

    private Precipitation precipitation1;

    private Precipitation precipitation2;

    private Precipitation precipitation3;

    @Before
    public void setUp() throws Exception {
        precipitation1 = new Precipitation();

        precipitation2 = new Precipitation((byte)1);

        precipitation3 = new Precipitation(precipitation2);
    }

    @Test
    public void testDefaultConstructor() throws Exception{
        assertEquals(0, precipitation1.getScale());
    }

    @Test
    public void testParametrizedConstructor() throws Exception{
        assertEquals(1, precipitation2.getScale());
    }

    @Test
    public void testCopyConstructor() throws Exception{
        assertEquals(precipitation2.getScale(), precipitation3.getScale());
    }

    @Test
    public void testClone() throws Exception {
        assertEquals(precipitation1.getScale(), precipitation1.clone().getScale());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Scale: " + precipitation1.getScale(), precipitation1.toString());
    }

    @Test
    public void testHashCodeClones() throws Exception {
        assertEquals(precipitation1.hashCode(), precipitation1.clone().hashCode());
    }

    @Test
    public void testHashCodeDifferentObjects() throws Exception{
        assertNotEquals(precipitation1.hashCode(), precipitation2.hashCode());
    }

    @Test
    public void testEqualsClones() throws Exception {
        assertEquals(true, precipitation1.equals(precipitation1.clone()));
    }

    @Test
    public void testEqualsDifferentObjects() throws Exception {
        assertEquals(false, precipitation1.equals(precipitation2));
    }

    @Test
    public void testEqualsDifferentClasses() throws Exception {
        assertEquals(false, precipitation1.equals(new Object()));
    }

    @Test
    public void testEqualsNull() throws Exception {
        assertEquals(false, precipitation1.equals(null));
    }

    @Test
    public void testGetScale() throws Exception {
        assertEquals((byte)0, precipitation1.getScale());
    }

    @Test
    public void testSetScale() throws Exception {
        precipitation1.setScale((byte)1);
        assertEquals(1, precipitation1.getScale());
    }

    @Test
    public void testIsCorrectScaleMax() throws Exception {
        assertEquals(true, Precipitation.isCorrectScale(Precipitation.MAX_SCALE));
    }

    @Test
    public void testIsCorrectScaleMin() throws Exception {
        assertEquals(true, Precipitation.isCorrectScale(Precipitation.MIN_SCALE));
    }

    @Test
    public void testIsCorrectScaleAverage() throws Exception {
        assertEquals(true, Precipitation.isCorrectScale((byte)(Precipitation.MAX_SCALE / (byte)2)));
    }

    @Test
    public void testIsCorrectScaleNotCorrect() throws Exception {
        assertEquals(false, Precipitation.isCorrectScale((byte)(Precipitation.MAX_SCALE + (byte)1)));
    }
}