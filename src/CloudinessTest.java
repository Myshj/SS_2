import static org.junit.Assert.*;

/**
 * Created by alexey on 01.03.16.
 */
public class CloudinessTest {

    private Cloudiness cloudiness1;

    private Cloudiness cloudiness2;

    private Cloudiness cloudiness3;

    @org.junit.Before
    public void setUp() throws Exception {
        cloudiness1 = new Cloudiness();

        cloudiness2 = new Cloudiness((byte)1);

        cloudiness3 = new Cloudiness(cloudiness2);
    }

    @org.junit.Test
    public void testDefaultConstructor() throws Exception {
        assertEquals(Cloudiness.MIN_SCALE_IN_OKTAS, cloudiness1.getScaleInOktas());
    }

    @org.junit.Test
    public void testParametrizedConstructor() throws Exception{
        assertEquals(1, cloudiness2.getScaleInOktas());
    }

    @org.junit.Test
    public void testCopyConstructor() throws Exception{
        assertEquals(cloudiness2.getScaleInOktas(), cloudiness3.getScaleInOktas());
    }

    @org.junit.Test
    public void testSetScaleInOktasCorrect() throws Exception {
        cloudiness1.setScaleInOktas((byte)3);
        assertEquals(3, cloudiness1.getScaleInOktas());
    }

    @org.junit.Test
    public void testSetScaleInOktasIncorrect() throws Exception {

        try {
            cloudiness1.setScaleInOktas((byte) (Cloudiness.MAX_SCALE_IN_OKTAS + (byte) 1));

            throw new Exception();
        }catch (Exception ex){}
    }

    @org.junit.Test
    public void testClone() throws Exception {
        assertEquals(cloudiness1.getScaleInOktas(), cloudiness1.clone().getScaleInOktas());
    }

    @org.junit.Test
    public void testToString() throws Exception {
        assertEquals("ScaleInOktas: " + cloudiness1.getScaleInOktas(), cloudiness1.toString());
    }

    @org.junit.Test
    public void testHashCodeClones() throws Exception {
        assertEquals(cloudiness1.hashCode(), cloudiness1.clone().hashCode());
    }

    @org.junit.Test
    public void testHashCodeDifferentObjects() throws Exception {
        assertNotEquals(cloudiness1.hashCode(), cloudiness2.hashCode());
    }

    @org.junit.Test
    public void testEqualsClones() throws Exception {
        assertEquals(true, cloudiness1.equals(cloudiness1.clone()));
    }

    @org.junit.Test
    public void testEqualsDifferentObjects() throws Exception {
        assertEquals(false, cloudiness1.equals(cloudiness2));
    }

    @org.junit.Test
    public void testEqualsDifferentClasses() throws Exception {
        assertEquals(false, cloudiness1.equals(new Object()));
    }

    @org.junit.Test
    public void testEqualsNull() throws Exception {
        assertEquals(false, cloudiness1.equals(null));
    }

    @org.junit.Test
    public void testIsCorrectScaleMax() throws Exception {
        assertEquals(true, Cloudiness.isCorrectScale(Cloudiness.MAX_SCALE_IN_OKTAS));
    }

    @org.junit.Test
    public void testIsCorrectScaleMin() throws Exception {
        assertEquals(true, Cloudiness.isCorrectScale(Cloudiness.MIN_SCALE_IN_OKTAS));
    }

    @org.junit.Test
    public void testIsCorrectScaleAverage() throws Exception {
        assertEquals(true, Cloudiness.isCorrectScale((Cloudiness.MIN_SCALE_IN_OKTAS + Cloudiness.MAX_SCALE_IN_OKTAS) / (byte)2));
    }

    @org.junit.Test
    public void testIsCorrectScaleNotCorrect() throws Exception {
        assertEquals(false, Cloudiness.isCorrectScale(Cloudiness.MAX_SCALE_IN_OKTAS + 1));
    }
}