package util;

import org.junit.Assert;
import org.junit.Test;

public class NumbersTest {
    @Test
    public void testPandigital() {
        Assert.assertTrue(Numbers.isPandigital_0_to_N(0));
        Assert.assertTrue(Numbers.isPandigital_0_to_N(10));
        Assert.assertTrue(Numbers.isPandigital_0_to_N(102));
        Assert.assertTrue(Numbers.isPandigital_0_to_N(1230));
        Assert.assertTrue(Numbers.isPandigital_0_to_N(12340));
        Assert.assertTrue(Numbers.isPandigital_0_to_N(123450));
        Assert.assertTrue(Numbers.isPandigital_0_to_N(1234560));
        Assert.assertTrue(Numbers.isPandigital_0_to_N(12345670));
        Assert.assertTrue(Numbers.isPandigital_0_to_N(123456780));
        Assert.assertTrue(Numbers.isPandigital_0_to_N(1234567890));
        Assert.assertTrue(Numbers.isPandigital_0_to_9(1234567890));

        Assert.assertFalse(Numbers.isPandigital_0_to_N(1));
        Assert.assertFalse(Numbers.isPandigital_0_to_N(12));
        Assert.assertFalse(Numbers.isPandigital_0_to_N(32));
        Assert.assertFalse(Numbers.isPandigital_0_to_N(130));
        Assert.assertFalse(Numbers.isPandigital_0_to_N(1234));
        Assert.assertFalse(Numbers.isPandigital_0_to_N(111));
        Assert.assertFalse(Numbers.isPandigital_0_to_N(123456789));
        Assert.assertFalse(Numbers.isPandigital_0_to_9(102));
        Assert.assertFalse(Numbers.isPandigital_0_to_9(123456789));

        Assert.assertTrue(Numbers.isPandigital_1_to_N(1));
        Assert.assertTrue(Numbers.isPandigital_1_to_N(12));
        Assert.assertTrue(Numbers.isPandigital_1_to_N(123));
        Assert.assertTrue(Numbers.isPandigital_1_to_N(1234));
        Assert.assertTrue(Numbers.isPandigital_1_to_N(12345));
        Assert.assertTrue(Numbers.isPandigital_1_to_N(123456));
        Assert.assertTrue(Numbers.isPandigital_1_to_N(1234567));
        Assert.assertTrue(Numbers.isPandigital_1_to_N(12345678));
        Assert.assertTrue(Numbers.isPandigital_1_to_N(123456789));
        Assert.assertTrue(Numbers.isPandigital_1_to_9(123456789));

        Assert.assertFalse(Numbers.isPandigital_1_to_N(0));
        Assert.assertFalse(Numbers.isPandigital_1_to_N(2));
        Assert.assertFalse(Numbers.isPandigital_1_to_N(3));
        Assert.assertFalse(Numbers.isPandigital_1_to_N(102));
        Assert.assertFalse(Numbers.isPandigital_1_to_N(1112234567890L));
        Assert.assertFalse(Numbers.isPandigital_1_to_9(123));
        Assert.assertFalse(Numbers.isPandigital_1_to_9(1112234567890L));
    }

    @Test
    public void testConcat() {
        Assert.assertEquals(12, Numbers.concat(1, 2));
        Assert.assertEquals(1234567890, Numbers.concat(123456789, 0));
        Assert.assertEquals(12, Numbers.concat(0, 12));
    }

    @Test
    public void testNaturalRoots() {
        Assert.assertTrue(Numbers.hasIntegerRoot(1, 0, 0));
        Assert.assertFalse(Numbers.hasNaturalRoot(1, 0, 0));
        Assert.assertTrue(Numbers.hasIntegerRoot(1, 0, -1));
        Assert.assertTrue(Numbers.hasNaturalRoot(1, 0, -1));
    }
}
