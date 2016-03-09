import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alexey on 01.03.16.
 */
public class DirectionTest {

    private Direction direction1;

    private Direction direction2;

    private Direction direction3;

    @Before
    public void setUp() throws Exception {
        direction1 = new Direction();

        direction2 = new Direction(60.0);

        direction3 = new Direction(direction2);
    }

    @Test
    public void testDefaultConstructor() throws Exception{
        assertEquals(0.0, direction1.getDoubleDirectionInDegrees(), 0.01);
    }

    @Test
    public void testParametrizedConstructor() throws Exception{
        assertEquals(60.0, direction2.getDoubleDirectionInDegrees(), 0.01);
    }

    @Test
    public void testCopyConstructor() throws Exception{
        assertEquals(direction2.getDoubleDirectionInDegrees(), direction3.getDoubleDirectionInDegrees(), 0.01);
    }

    @Test
    public void testClone() throws Exception {
        assertEquals(direction1.getDoubleDirectionInDegrees(), direction1.clone().getDoubleDirectionInDegrees(), 0.01);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("InDegrees: " + direction1.getDoubleDirectionInDegrees(), direction1.toString());
    }

    @Test
    public void testHashCodeClones() throws Exception {
        assertEquals(direction1.hashCode(), direction1.clone().hashCode());
    }

    @Test
    public void testHashCodeDifferentObjects() throws Exception {
        assertNotEquals(direction1.hashCode(), direction2.hashCode());
    }

    @Test
    public void testEqualsClones() throws Exception {
        assertEquals(true, direction1.equals(direction1.clone()));
    }

    @Test
    public void testEqualsDifferentObjects() throws Exception {
        assertEquals(false, direction1.equals(direction2));
    }

    @Test
    public void testEqualsDifferentClasses() throws Exception {
        assertEquals(false, direction1.equals(new Object()));
    }

    @Test
    public void testEqualsNull() throws Exception {
        assertEquals(false, direction1.equals(null));
    }

    @Test
    public void testGetDoubleDirectionInDegrees() throws Exception {
        assertEquals(0.0, direction1.getDoubleDirectionInDegrees(), 0.01);
    }

    @Test
    public void testGetIntDirectionInDegrees() throws Exception {
        assertEquals(0, direction1.getIntDirectionInDegrees());
    }

    @Test
    public void testGetAsPredefinedDirection() throws Exception {
        assertEquals(PredefinedDirection.NORTH, direction1.getAsPredefinedDirection());
    }

    @Test
    public void testSetInDegreesDouble() throws Exception {
        direction1.setInDegrees(10.0);
        assertEquals(10.0, direction1.getDoubleDirectionInDegrees(), 0.0);
    }

    @Test
    public void testSetInDegreesInt() throws Exception {
        direction1.setInDegrees(16);
        assertEquals(16, direction1.getIntDirectionInDegrees());
    }

    @Test
    public void testSetInDegreesBig() throws Exception {
        direction1.setInDegrees(361.0);
        assertEquals(1.0, direction1.getDoubleDirectionInDegrees(), 0.0);
    }
}