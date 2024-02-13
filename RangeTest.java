/**
 * 
 */
package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;

/**
 * @author group17
 *
 */

public class RangeTest {

// ---------------- METHOD BEING TESTED: combine() ---------------- //
	
	/**
     * Purpose: Checking if the combine() method results in null if two null ranges are combined
     * Type of tests involved: equivalence class testing
     */
	@Test 
	public void testCombineBothNullRanges(){
		assertNull("Combining both null ranges should result in null",Range.combine(null, null));
	}
	
	/**
     * Purpose: Checking if the combine() method results in null if the first argument is a null range
     * Type of tests involved: equivalence class testing
     */
	@Test
	public void testCombineFirstRangeIsNull(){
		Range range1 = new Range(5, 10);
		assertNull("Combining with the first range being null should result in the return of the other range",Range.combine(range1, null));
	}
	
	/**
     * Purpose: Checking if the combine() method results in null if the second argument is a null range
     * Type of tests involved: equivalence class testing
     */
	@Test 
	public void testCombineSecondRangeIsNull(){
		Range range2 = new Range(4, 6);
		assertNull("Combining with the second range being null should result in the return of the other range",Range.combine(null, range2));
			
	}
	
	/**
     * Purpose: Checking if the combine() method returns an exception if the two ranges being combined overlap
     * Type of tests involved: exception testing, boundary value testing
     */
    @Test
    public void testCombineBothRangesAreNotNullOverlapping() {
        Range range1 = new Range(1, 5);
        Range range2 = new Range(4, 8);

        try {
            Range combinedRange = Range.combine(range1, range2);
            fail("Expected IllegalArgumentException, but got combined range: " + combinedRange);
        } catch (IllegalArgumentException e) {
            // Expected IllegalArgumentException
            assertEquals("Incorrect exception message for combining overlapping ranges", "Invalid range combination: ranges must not overlap", e.getMessage());
        }
    }

    /**
     * Purpose: Checking if the combine() method returns the expected value if two non-null and non-overlapping ranges are combined
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCombineBothRangesAreNotNullNonOverlapping() {
        Range range1 = new Range(3, 5);
        Range range2 = new Range(1, 15);
        Range expectedResult = new Range(1, 15);
        assertEquals("Combining non-null non-overlapping ranges should result in the expected range", expectedResult, Range.combine(range1, range2));
    }

    /**
     * Purpose: Checking if the combine() method returns an exception if the two ranges being combined are the same
     * Type of tests involved: exception testing, boundary value testing
     */
    @Test
    public void testCombineSameRanges() {
        Range emptyRange1 = new Range(7, 7);
        Range emptyRange2 = new Range(10, 10);

        try {
            Range combinedRange = Range.combine(emptyRange1, emptyRange2);
            assertNull("Expected IllegalArgumentException, but got combined range: " + combinedRange, combinedRange);
        } catch (IllegalArgumentException e) {
            // Expected IllegalArgumentException
            assertEquals("Incorrect exception message for combining same ranges", "Invalid range combination: ranges must not be empty", e.getMessage());
        }
    }
    
 
// ---------------- METHOD BEING TESTED: getCentralValue() ---------------- //
    
    /**
     * Purpose: Checking if the getCentralValue() method returns the correct result for the minimum possible range value
     * Type of tests involved: boundary value testing (LB)
     */
    @Test
    public void testGetCentralValueMinimumValidRange() {
        Range range = new Range(Double.MIN_VALUE, Double.MIN_VALUE + 1);
        assertEquals("Incorrect central value for minimum valid range", Double.MIN_VALUE + 0.5, range.getCentralValue(), 0);
    }

    /**
     * Purpose: Checking if the getCentralValue() method returns the correct result for the maximum possible range value
     * Type of tests involved: boundary value testing (UB)
     */
    @Test
    public void testGetCentralValueMaximumValidRange() {
        Range range = new Range(Double.MAX_VALUE - 1, Double.MAX_VALUE);
        assertEquals("Incorrect central value for maximum valid range", Double.MAX_VALUE - 0.5, range.getCentralValue(), 0);
    }

    /**
     * Purpose: Checking if the getCentralValue() method returns the correct result for an arbitrary valid range
     * Type of tests involved: equivalent class testing, boundary value testing (NOM)
     */
    @Test
    public void testGetCentralValueValidRange() {
        Range range = new Range(1, 5);
        assertEquals("Incorrect central value for valid range", 3, range.getCentralValue(), 0);
    }

    /**
     * Purpose: Checking if the getCentralValue() method returns an exception if tested with an invalid range
     * Type of tests involved: exception testing
     */
    @Test
    public void testGetCentralValueInvalidRange() {
        try {
        	Range range = new Range(5, 1);
            double centralValue = range.getCentralValue();
            fail("Expected IllegalArgumentException, but got central value: " + centralValue);
        } catch (IllegalArgumentException e) {
            // Expected IllegalArgumentException
            assertEquals("Incorrect central value for invalid range", "Invalid range: end value must be greater than or equal to start value", e.getMessage());
        }
    }
    
    /**
     * Purpose: Checking if the getCentralValue() method returns the same value as the single point for a single point range
     * Type of tests involved: equivalent class testing
     */
    @Test
    public void testGetCentralValueSinglePointRange() {
        Range range = new Range(3, 3);
        assertEquals("Incorrect central value for single-point range", 3, range.getCentralValue(), 0);
    }

    /**
     * Purpose: Checking if the getCentralValue() method returns a null double value if an empty range is given
     * Type of tests involved: equivalent class testing, boundary value testing (BLB)
     */
    @Test
    public void testGetCentralValueEmptyRange() {
        Range range = new Range(5, 5);
        assertEquals("Incorrect central value for empty range", Double.NaN, range.getCentralValue(), 0);
    }

    /**
     * Purpose: Checking if the getCentralValue() method returns a null double value if an entire range of doubles is given
     * Type of tests involved: equivalent class testing, boundary value testing (BLB)
     */
    @Test
    public void testGetCentralValueEntireRangeOfDoubles() {
        Range range = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
        assertEquals("Incorrect central value for entire range of doubles", 0, range.getCentralValue(), 0);
    }

    @Test
    public void testGetCentralValueTwoRangesWithDifferentWidths() {
        Range range1 = new Range(1, 5);
        Range range2 = new Range(10, 15);

        try {
            double centralValue = Range.combine(range1, range2).getCentralValue();
            fail("Expected IllegalArgumentException, but got central value: " + centralValue);
        } catch (IllegalArgumentException e) {
            // Expected IllegalArgumentException
            assertEquals("Incorrect central value for two ranges with different widths", "Invalid ranges for combining", e.getMessage());
        }
    }
   
    
// ---------------- METHOD BEING TESTED: getLength() ---------------- //

    /**
     * Purpose: Checking if the getLength() method returns the correct length for a valid positive range
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testGetLengthValidPositiveRange() {
        Range range = new Range(3, 8);
        assertEquals("Incorrect length for valid positive range", 5, range.getLength(), 0);
    }

    /**
     * Purpose: Checking if the getLength() method returns the correct length for a valid negative range
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testGetLengthValidNegativeRange() {
        Range range = new Range(-5, -2);
        assertEquals("Incorrect length for valid negative range", 3, range.getLength(), 0);
    }

    /**
     * Purpose: Checking if the getLength() method returns the correct length for a valid mixed range
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testGetLengthValidMixedRange() {
        Range range = new Range(-3, 4);
        assertEquals("Incorrect length for valid mixed range", 7, range.getLength(), 0);
    }

    /**
     * Purpose: Checking if the getLength() method returns the correct length for a single-point range
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testGetLengthSinglePointRange() {
        Range range = new Range(5, 5);
        assertEquals("Incorrect length for single-point range", 0, range.getLength(), 0);
    }


    /**
     * Purpose: Checking if the getLength() method returns the correct length for the minimum valid range
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testGetLengthMinimumValidRange() {
        Range range = new Range(0, 1);
        assertEquals("Incorrect length for minimum valid range", 1, range.getLength(), 0);
    }

    /**
     * Purpose: Checking if the getLength() method returns the correct length for the maximum valid range
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testGetLengthMaximumValidRange() {
        Range range = new Range(Double.MAX_VALUE - 1, Double.MAX_VALUE);
        assertEquals("Incorrect length for maximum valid range", 1, range.getLength(), 0);
    }

    /**
     * Purpose: Checking if the getLength() method returns the correct length for an empty range
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testGetLengthEmptyRange() {
        Range range = new Range(7, 7);
        assertEquals("Incorrect length for empty range", 0, range.getLength(), 0);
    }

    /**
     * Purpose: Checking if the getLength() method returns the correct length for a range with large positive difference
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testGetLengthLargePositiveDifference() {
        Range range = new Range(10, 1000);
        assertEquals("Incorrect length for range with large positive difference", 990, range.getLength(), 0);
    }

    /**
     * Purpose: Checking if the getLength() method returns the correct length for a range with large negative difference
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testGetLengthLargeNegativeDifference() {
        Range range = new Range(-1000, -10);
        assertEquals("Incorrect length for range with large negative difference", 990, range.getLength(), 0);
    }

    /**
     * Purpose: Checking if the getLength() method returns the correct length for a range with decimal values
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testGetLengthDecimalValues() {
        Range range = new Range(2.5, 7.5);
        assertEquals("Incorrect length for range with decimal values", 5, range.getLength(), 0);
    }

    /**
     * Purpose: Checking if the getLength() method throws the expected exception for an invalid range
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testGetLengthInvalidRange() {
        
        try {
            Range range = new Range(5, 1);

            range.getLength();
            fail("Expected IllegalArgumentException, but got length");
        } catch (IllegalArgumentException e) {
            // Expected IllegalArgumentException
            assertEquals("Incorrect exception message for invalid range", "Invalid range: end value must be greater than or equal to start value", e.getMessage());
        }
    }

    
// ---------------- METHOD BEING TESTED: constrain() ---------------- //

    /**
     * Purpose: Checking if the constrain() method returns the correct value for a value within the range
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testConstrainWithinRange() {
        Range range = new Range(3, 8);
        assertEquals("Incorrect constrained value for value within the range", 5, range.constrain(5), 0);
    }

    /**
     * Purpose: Checking if the constrain() method returns the correct value for a value at the lower bound
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testConstrainAtLowerBound() {
        Range range = new Range(3, 8);
        assertEquals("Incorrect constrained value for value at the lower bound", 3, range.constrain(3), 0);
    }

    /**
     * Purpose: Checking if the constrain() method returns the correct value for a value at the upper bound
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testConstrainAtUpperBound() {
        Range range = new Range(3, 8);
        assertEquals("Incorrect constrained value for value at the upper bound", 8, range.constrain(8), 0);
    }

    /**
     * Purpose: Checking if the constrain() method returns the correct value for a value below the lower bound
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testConstrainBelowLowerBound() {
        Range range = new Range(3, 8);
        assertEquals("Incorrect constrained value for value below the lower bound", 3, range.constrain(1), 0);
    }

    /**
     * Purpose: Checking if the constrain() method returns the correct value for a value above the upper bound
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testConstrainAboveUpperBound() {
        Range range = new Range(3, 8);
        assertEquals("Incorrect constrained value for value above the upper bound", 8, range.constrain(10), 0);
    }

    /**
     * Purpose: Checking if the constrain() method returns the correct value for the minimum valid range value
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testConstrainMinimumValidRangeValue() {
        Range range = new Range(0, 1);
        assertEquals("Incorrect constrained value for minimum valid range value", 0, range.constrain(Double.MIN_VALUE), 0);
    }

    /**
     * Purpose: Checking if the constrain() method returns the correct value for the maximum valid range value
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testConstrainMaximumValidRangeValue() {
        Range range = new Range(Double.MAX_VALUE - 1, Double.MAX_VALUE);
        assertEquals("Incorrect constrained value for maximum valid range value", Double.MAX_VALUE - 1, range.constrain(Double.MAX_VALUE - 1), 0);
    }

    /**
     * Purpose: Checking if the constrain() method returns the correct value for the minimum double value
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testConstrainMinimumDoubleValue() {
        Range range = new Range(-100, 100);
        assertEquals("Incorrect constrained value for minimum double value", -100, range.constrain(Double.MIN_VALUE), 0);
    }

    /**
     * Purpose: Checking if the constrain() method returns the correct value for the maximum double value
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testConstrainMaximumDoubleValue() {
        Range range = new Range(-100, 100);
        assertEquals("Incorrect constrained value for maximum double value", 100, range.constrain(Double.MAX_VALUE), 0);
    }

    /**
     * Purpose: Checking if the constrain() method returns the correct value for NaN
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testConstrainNaN() {
        Range range = new Range(0, 10);
        assertEquals("Incorrect constrained value for NaN", 0, range.constrain(Double.NaN), 0);
    }

    /**
     * Purpose: Checking if the constrain() method returns the correct value for positive infinity
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testConstrainPositiveInfinity() {
        Range range = new Range(0, 10);
        assertEquals("Incorrect constrained value for positive infinity", 10, range.constrain(Double.POSITIVE_INFINITY), 0);
    }

    /**
     * Purpose: Checking if the constrain() method returns the correct value for negative infinity
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testConstrainNegativeInfinity() {
        Range range = new Range(0, 10);
        assertEquals("Incorrect constrained value for negative infinity", 0, range.constrain(Double.NEGATIVE_INFINITY), 0);
    }

    /**
     * Purpose: Checking if the constrain() method returns the correct value for a range with negative values
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testConstrainWithNegativeRange() {
        Range range = new Range(-5, 5);
        assertEquals("Incorrect constrained value for range with negative values", 0, range.constrain(0), 0);
    }

    /**
     * Purpose: Checking if the constrain() method returns the correct value for a decimal value
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testConstrainDecimalValue() {
        Range range = new Range(1, 5);
        assertEquals("Incorrect constrained value for decimal value", 3.5, range.constrain(3.5), 0);
    }

    /**
     * Purpose: Checking if the constrain() method returns the correct value for the minimum valid range
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testConstrainMinimumValidRange() {
        Range range = new Range(0, 1);
        assertEquals("Incorrect constrained value for minimum valid range", 0.5, range.constrain(0.5), 0);
    }

    /**
     * Purpose: Checking if the constrain() method returns the correct value for the maximum valid range
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testConstrainMaximumValidRange() {
        Range range = new Range(Double.MAX_VALUE - 1, Double.MAX_VALUE);
        assertEquals("Incorrect constrained value for maximum valid range", Double.MAX_VALUE - 0.5, range.constrain(Double.MAX_VALUE - 0.5), 0);
    }


 // ---------------- METHOD BEING TESTED: contains() ---------------- //   
    ```java
    /**
     * Purpose: Checking if the contains() method correctly identifies a value inside the range
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testContainsValueInsideRange() {
        Range range = new Range(5.0, 10.0);
        assertTrue(range.contains(7.5));
    }

    /**
     * Purpose: Checking if the contains() method correctly identifies a value at the lower bound
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testContainsValueAtLowerBound() {
        Range range = new Range(5.0, 10.0);
        assertTrue(range.contains(5.0));
    }

    /**
     * Purpose: Checking if the contains() method correctly identifies a value at the upper bound
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testContainsValueAtUpperBound() {
        Range range = new Range(5.0, 10.0);
        assertTrue(range.contains(10.0));
    }

    /**
     * Purpose: Checking if the contains() method correctly identifies a value outside the range
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testContainsValueOutsideRange() {
        Range range = new Range(5.0, 10.0);
        assertFalse(range.contains(2.5));
    }

    /**
     * Purpose: Checking if the contains() method correctly identifies a value equal to the lower bound as outside the range
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testContainsValueEqualToLowerBound() {
        Range range = new Range(5.0, 10.0);
        assertFalse(range.contains(4.999));
    }

    /**
     * Purpose: Checking if the contains() method correctly identifies a value equal to the upper bound as outside the range
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testContainsValueEqualToUpperBound() {
        Range range = new Range(5.0, 10.0);
        assertFalse(range.contains(10.0001));
    }
    ```
    
    

}
