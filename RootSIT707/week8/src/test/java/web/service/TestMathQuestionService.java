package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

    // Test for valid addition
    @Test
    public void testTrueAdd() {
        Assert.assertEquals(3, MathQuestionService.q1Addition("1", "2"), 0);
    }

    // Test for addition with the first number empty
    @Test
    public void testAddNumber1Empty() {
        try {
            MathQuestionService.q1Addition("", "2");
            Assert.fail("Expected NumberFormatException for empty input.");
        } catch (NumberFormatException e) {
            // Expected exception
        }
    }

    // Test for addition with the second number empty
    @Test
    public void testAddNumber2Empty() {
        try {
            MathQuestionService.q1Addition("1", "");
            Assert.fail("Expected NumberFormatException for empty input.");
        } catch (NumberFormatException e) {
            // Expected exception
        }
    }

    // Test for addition with both numbers empty
    @Test
    public void testAddBothNumbersEmpty() {
        try {
            MathQuestionService.q1Addition("", "");
            Assert.fail("Expected NumberFormatException for empty input.");
        } catch (NumberFormatException e) {
            // Expected exception
        }
    }

    // Test for addition with invalid number format
    @Test
    public void testAddInvalidNumberFormat() {
        try {
            MathQuestionService.q1Addition("abc", "2");
            Assert.fail("Expected NumberFormatException for invalid input.");
        } catch (NumberFormatException e) {
            // Expected exception
        }
    }

    // Test for valid subtraction
    @Test
    public void testTrueSubtraction() {
        Assert.assertEquals(3, MathQuestionService.q2Subtraction("5", "2"), 0);
    }

    // Test for subtraction with the first number empty
    @Test
    public void testSubtractionNumber1Empty() {
        try {
            MathQuestionService.q2Subtraction("", "2");
            Assert.fail("Expected NumberFormatException for empty input.");
        } catch (NumberFormatException e) {
            // Expected exception
        }
    }

    // Test for subtraction with the second number empty
    @Test
    public void testSubtractionNumber2Empty() {
        try {
            MathQuestionService.q2Subtraction("5", "");
            Assert.fail("Expected NumberFormatException for empty input.");
        } catch (NumberFormatException e) {
            // Expected exception
        }
    }

    // Test for subtraction with both numbers empty
    @Test
    public void testSubtractionBothNumbersEmpty() {
        try {
            MathQuestionService.q2Subtraction("", "");
            Assert.fail("Expected NumberFormatException for empty input.");
        } catch (NumberFormatException e) {
            // Expected exception
        }
    }

    // Test for subtraction with invalid number format
    @Test
    public void testSubtractionInvalidNumberFormat() {
        try {
            MathQuestionService.q2Subtraction("abc", "2");
            Assert.fail("Expected NumberFormatException for invalid input.");
        } catch (NumberFormatException e) {
            // Expected exception
        }
    }

    // Test for addition with zero input
    @Test
    public void testAddZeroInput() {
        Assert.assertEquals(0, MathQuestionService.q1Addition("0", "0"), 0);
    }

    // Test for addition with negative input
    @Test
    public void testAddNegativeInput() {
        Assert.assertEquals(-1, MathQuestionService.q1Addition("-3", "2"), 0);
    }

    // Test for subtraction with negative result
    @Test
    public void testSubtractionNegativeResult() {
        Assert.assertEquals(-5, MathQuestionService.q2Subtraction("-3", "2"), 0);
    }

    // Test for subtraction where result is zero
    @Test
    public void testSubtractionZeroResult() {
        Assert.assertEquals(0, MathQuestionService.q2Subtraction("5", "5"), 0);
    }

    // Test for subtraction with negative numbers resulting in a positive result
    @Test
    public void testSubtractionNegativeInputs() {
        // Expecting the result of "-5 - (-3)" to be -2
        Assert.assertEquals(-2, MathQuestionService.q2Subtraction("-5", "-3"), 0);
    }

    // -------------------------
    // Q3: Multiplication Tests
    // -------------------------

    // Test for valid multiplication
    @Test
    public void testTrueMultiplication() {
        Assert.assertEquals(10, MathQuestionService.q3Multiplication("2", "5"), 0);
    }

    // Test for multiplication with the first number empty
    @Test
    public void testMultiplicationNumber1Empty() {
        try {
            MathQuestionService.q3Multiplication("", "3");
            Assert.fail("Expected NumberFormatException for empty input.");
        } catch (NumberFormatException e) {
            // Expected exception
        }
    }

    // Test for multiplication with the second number empty
    @Test
    public void testMultiplicationNumber2Empty() {
        try {
            MathQuestionService.q3Multiplication("3", "");
            Assert.fail("Expected NumberFormatException for empty input.");
        } catch (NumberFormatException e) {
            // Expected exception
        }
    }

    // Test for multiplication with both numbers empty
    @Test
    public void testMultiplicationBothNumbersEmpty() {
        try {
            MathQuestionService.q3Multiplication("", "");
            Assert.fail("Expected NumberFormatException for empty input.");
        } catch (NumberFormatException e) {
            // Expected exception
        }
    }

    // Test for multiplication with invalid number format
    @Test
    public void testMultiplicationInvalidNumberFormat() {
        try {
            MathQuestionService.q3Multiplication("abc", "2");
            Assert.fail("Expected NumberFormatException for invalid input.");
        } catch (NumberFormatException e) {
            // Expected exception
        }
    }

    // Test for multiplication with zero input
    @Test
    public void testMultiplicationZeroInput() {
        Assert.assertEquals(0, MathQuestionService.q3Multiplication("0", "10"), 0);
    }

    // Test for multiplication with negative numbers
    @Test
    public void testMultiplicationNegativeInputs() {
        Assert.assertEquals(-6, MathQuestionService.q3Multiplication("-2", "3"), 0);
    }

    // Test for multiplication with two negative numbers
    @Test
    public void testMultiplicationTwoNegativeInputs() {
        Assert.assertEquals(6, MathQuestionService.q3Multiplication("-2", "-3"), 0);
    }
}
