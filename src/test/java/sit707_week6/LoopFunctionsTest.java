package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class LoopFunctionsTest {
    @Test
    public void testSumToN_withZero() {
        Assert.assertEquals(0, LoopFunctions.sumToN(0));
    }

    @Test
    public void testSumToN_withSmallNumber() {
        Assert.assertEquals(6, LoopFunctions.sumToN(3));
    }

    @Test
    public void testSumToN_withLargerNumber() {
        Assert.assertEquals(55, LoopFunctions.sumToN(10));
    }

    @Test
    public void testCountEvens_withNoEvens() {
        int[] input = {1, 3, 5, 7};
        Assert.assertEquals(0, LoopFunctions.countEvens(input));
    }

    @Test
    public void testCountEvens_withAllEvens() {
        int[] input = {2, 4, 6, 8};
        Assert.assertEquals(4, LoopFunctions.countEvens(input));
    }

    @Test
    public void testCountEvens_withMixedNumbers() {
        int[] input = {1, 2, 3, 4, 5};
        Assert.assertEquals(2, LoopFunctions.countEvens(input));
    }

    @Test
    public void testCountEvens_withEmptyArray() {
        int[] input = {};
        Assert.assertEquals(0, LoopFunctions.countEvens(input));
    }
}
