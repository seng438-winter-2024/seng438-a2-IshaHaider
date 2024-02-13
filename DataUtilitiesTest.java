/**
 * 
 */
package org.jfree.data.test;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import java.security.InvalidParameterException;

/**
 * @author group17
 *
 */

public class DataUtilitiesTest extends DataUtilities {
	@Rule
    public ExpectedException exceptionRule = ExpectedException.none();
	
// ---------------- METHOD BEING TESTED: calculateColumnTotal() ---------------- //

    /**
     * Purpose: Verifies the calculation of column total for a 2D array with two rows and one column.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCalculateColumnTotalTwoValues() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(2));
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                one(values).getValue(1, 0);
                will(returnValue(2.5));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        // verify
        assertEquals(result, 10.0, .000000001d);
    }

    /**
     * Purpose: Verifies the calculation of column total for a 2D array with multiple values in each row.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCalculateColumnTotalValidInput() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(2.5));
                one(values).getValue(1, 0);
                will(returnValue(3.5));
                one(values).getValue(2, 0);
                will(returnValue(4.5));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        // verify
        assertEquals(result, 10.5, .000000001d);
    }

    /**
     * Purpose: Verifies the calculation of column total for an empty data table.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCalculateColumnTotalEmptyDataTable() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(0));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        // verify
        assertEquals(result, 0.0, .000000001d);
    }

    /**
     * Purpose: Verifies the calculation of column total for a data table with a single value.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCalculateColumnTotalSingleValue() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(1));
                one(values).getValue(0, 0);
                will(returnValue(5.5));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        // verify
        assertEquals(result, 5.5, .000000001d);
    }

    /**
     * Purpose: Verifies the calculation of column total for a data table with an invalid value.
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testCalculateColumnTotaltestInvalidColumnIndex() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(2));
                allowing(values).getValue(with(any(int.class)), with(any(int.class)));
                will(returnValue(0.0));
            }
        });
        // exercise and verify
        try {
            DataUtilities.calculateColumnTotal(values, -1);
            fail("Expected InvalidParameterException for negative index");
        } catch (InvalidParameterException e) {
            assertEquals("Invalid column index: -1", e.getMessage());
        }
    }



    /**
     * Purpose: Verifies that invoking calculateColumnTotal() with a null data table throws a NullPointerException.
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testCalculateColumnTotalNullDataTable() {
        // exercise and verify
        try {
            DataUtilities.calculateColumnTotal(null, 0); // Pass null as the data table
            fail("Expected NullPointerException for null data table");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }


	
// ---------------- METHOD BEING TESTED: calculateRowTotal() ---------------- //
    /**
     * Purpose: Verifies the calculation of row total for a 2D array with three values in a single row.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCalculateRowTotalThreeValues() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3)); // Number of columns
                one(values).getValue(0, 0);
                will(returnValue(2.5)); // Value in row 0, column 0
                one(values).getValue(0, 1);
                will(returnValue(3.5)); // Value in row 0, column 1
                one(values).getValue(0, 2);
                will(returnValue(4.5)); // Value in row 0, column 2
            }
        });
        // exercise
        double result = DataUtilities.calculateRowTotal(values, 0);
        // verify
        assertEquals(result, 10.5, .000000001d); // Expected sum: 2.5 + 3.5 + 4.5 = 10.5
    }

    /**
     * Purpose: Verifies the calculation of row total for an empty data table.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCalculateRowTotalEmptyDataTable() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(0)); // Zero columns
            }
        });
        // exercise
        double result = DataUtilities.calculateRowTotal(values, 0);
        // verify
        assertEquals(result, 0.0, .000000001d); // Expected sum: 0 (empty data table)
    }

    /**
     * Purpose: Verifies the calculation of row total for a data table with a single value.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCalculateRowTotalSingleValueInDataTable() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(1)); // One column
                one(values).getValue(0, 0);
                will(returnValue(5.5)); // Value in row 0, column 0
            }
        });
        // exercise
        double result = DataUtilities.calculateRowTotal(values, 0);
        // verify
        assertEquals(result, 5.5, .000000001d); // Expected sum: single value in the row
    }

    /**
     * Purpose: Verifies that an InvalidParameterException is thrown for negative row index.
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testCalculateRowTotalInvalidRowIndex() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(2)); // Two columns
                
                // Add expectations for getValue method
                allowing(values).getValue(with(any(int.class)), with(any(int.class)));
                will(returnValue(0.0)); // Mocking the return value of getValue
            }
        });
        // exercise and verify
        try {
            DataUtilities.calculateRowTotal(values, -1); // Negative index
            fail("Expected InvalidParameterException for negative index");
        } catch (InvalidParameterException e) {
            // Expected exception
        }
        try {
            DataUtilities.calculateRowTotal(values, 2); // Index exceeds number of rows
            fail("Expected InvalidParameterException for index exceeding number of rows");
        } catch (InvalidParameterException e) {
            // Expected exception
        }
    }

    /**
     * Purpose: Verifies that invoking calculateRowTotal() with a null data table throws a NullPointerException.
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testCalculateRowTotalNullDataTable() {
        // exercise and verify
        try {
            DataUtilities.calculateRowTotal(null, 0); // Pass null as the data table
            fail("Expected NullPointerException for null data table");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

	
// ---------------- METHOD BEING TESTED: createNumberArray() ---------------- //	

    /**
     * Purpose: Verifies the creation of a Number array with valid input data.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCreateNumberArrayValidInput() {
        // Input data
        double[] input = {1.5, 2, 0};
        
        // Exercise
        Number[] result = DataUtilities.createNumberArray(input);
        
        // Verify
        assertEquals(input.length, result.length);
        for (int i = 0; i < input.length; i++) {
            assertNotNull("Element at index " + i + " is null", result[i]);
            assertEquals(input[i], result[i].doubleValue(), 0.000001);
        }
    }

    /**
     * Purpose: Verifies the creation of an empty Number array from an empty data array.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCreateNumberArrayEmptyDataArray() {
        // Input data
        double[] input = {};
        
        // Exercise
        Number[] result = DataUtilities.createNumberArray(input);
        
        // Verify
        assertEquals(0, result.length);
    }

    /**
     * Purpose: Verifies that invoking createNumberArray() with a null data array throws a NullPointerException.
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testCreateNumberArrayNullDataArray() {
        // exercise and verify
        try {
            DataUtilities.createNumberArray(null); // Pass null as the data array
            fail("Expected NullPointerException for null data array");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }



// ---------------- METHOD BEING TESTED: createNumberArray2D() ---------------- //	

    /**
     * Purpose: Verifies that invoking createNumberArray2D() with a null data array throws an InvalidParameterException.
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testCreateNumberArray2DNullData() {
        exceptionRule.expect(InvalidParameterException.class);
        DataUtilities.createNumberArray2D(null);
    }
    
    /**
     * Purpose: Verifies that invoking createNumberArray2D() with a null data array throws an IllegalArgumentException.
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testCreateNumberArray2DNullData2() {
        // Specify the expected exception and the code that should throw it
        exceptionRule.expect(IllegalArgumentException.class);

        // the code that should throw the specified exception
        DataUtilities.createNumberArray2D(null);
    }

    /**
     * Purpose: Verifies the creation of an empty Number 2D array from an empty data array.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCreateNumberArray2DEmptyData() {
        double[][] data = new double[0][0];
        Number[][] result = DataUtilities.createNumberArray2D(data);

        assertEquals(0, result.length);
    }

    /**
     * Purpose: Verifies the creation of a Number 2D array with a single row and a single column.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCreateNumberArray2DSingleRowSingleColumn() {
        try {
            double[][] data = {{10.0}};
            Number[][] result = DataUtilities.createNumberArray2D(data);

            assertEquals("Number of rows", 1, result.length);
            assertEquals("Number of columns in row 0", 1, result[0].length);
            assertEquals(10.0, result[0][0].doubleValue(), 0.0001);
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    /**
     * Purpose: Verifies the creation of a Number 2D array with multiple rows and columns.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCreateNumberArray2DMultipleRowsAndColumns() {
        try {
            double[][] data = {{10.0, 20.0}, {30.0, 40.0}};
            Number[][] result = DataUtilities.createNumberArray2D(data);

            assertEquals("Number of rows", 2, result.length);
            assertEquals("Number of columns in row 0", 2, result[0].length);
            assertEquals(10.0, result[0][0].doubleValue(), 0.0001);
            assertEquals(20.0, result[0][1].doubleValue(), 0.0001);
            assertEquals(30.0, result[1][0].doubleValue(), 0.0001);
            assertEquals(40.0, result[1][1].doubleValue(), 0.0001);
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    /**
     * Purpose: Verifies the creation of a Number 2D array with negative values.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCreateNumberArray2DNegativeValues() {
        try {
            double[][] data = {{-10.0, -20.0}, {-30.0, -40.0}};
            Number[][] result = DataUtilities.createNumberArray2D(data);

            assertEquals("Number of rows", 2, result.length);
            assertEquals("Number of columns in row 0", 2, result[0].length);
            assertEquals(-10.0, result[0][0].doubleValue(), 0.0001);
            assertEquals(-20.0, result[0][1].doubleValue(), 0.0001);
            assertEquals(-30.0, result[1][0].doubleValue(), 0.0001);
            assertEquals(-40.0, result[1][1].doubleValue(), 0.0001);
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }


	
// ---------------- METHOD BEING TESTED: GetCumulativePercentages() ---------------- //	

    /**
     * Purpose: Verifies that invoking getCumulativePercentages() with a null KeyedValues object throws an InvalidParameterException.
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testGetCumulativePercentagesNullData() {
        // Specify the expected exception and the code that should throw it
        exceptionRule.expect(InvalidParameterException.class);

        // the code that should throw the specified exception
        DataUtilities.getCumulativePercentages(null);
    }

    /**
     * Purpose: Verifies the handling of an empty KeyedValues object, resulting in an empty KeyedValues object.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testGetCumulativePercentagesEmptyData() {
        // setup
        Mockery mockery = new Mockery();
        final KeyedValues data = mockery.mock(KeyedValues.class);

        mockery.checking(new Expectations() {
            {
                allowing(data).getItemCount();
                will(returnValue(0)); // Empty data has nothing to offer
            }
        });

        // exercise
        KeyedValues result = DataUtilities.getCumulativePercentages(data);
        assertEquals(0, result.getItemCount());
        // clean up
        mockery.assertIsSatisfied();
    }

    /**
     * Purpose: Verifies the handling of a KeyedValues object with a single value, resulting in a cumulative percentage of 1.0.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testGetCumulativePercentagesSingleValue() {
        // setup
        Mockery mockery = new Mockery();
        final KeyedValues data = mockery.mock(KeyedValues.class);

        mockery.checking(new Expectations() {
            {
                allowing(data).getItemCount();
                will(returnValue(1)); // Single value data
                allowing(data).getValue(0);
                will(returnValue(5.0)); // The only value in the dataset
                allowing(data).getKey(0);
                will(returnValue("someKey")); // Add this line to handle getKey(<0>)
            }
        });

        // exercise
        KeyedValues result = DataUtilities.getCumulativePercentages(data);

        // verify
        assertEquals("Just one value, so cumulative percentage is 1.0", 1, result.getItemCount());
        assertEquals("Expected cumulative percentage is 1.0", 1.0, result.getValue(0).doubleValue(), 0.000001);

        // clean up
        mockery.assertIsSatisfied();
    }

    /**
     * Purpose: Verifies the handling of a KeyedValues object with multiple values, resulting in cumulative percentages.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testGetCumulativePercentagesMultipleValues() {
        // setup
        Mockery mockery = new Mockery();
        final KeyedValues data = mockery.mock(KeyedValues.class);

        mockery.checking(new Expectations() {
            {
                allowing(data).getItemCount();
                will(returnValue(3)); // Multiple values data
                allowing(data).getValue(0);
                will(returnValue(5.0)); // Value at index 0
                allowing(data).getValue(1);
                will(returnValue(9.0)); // Value at index 1
                allowing(data).getValue(2);
                will(returnValue(2.0)); // Value at index 2
                allowing(data).getKey(0);
                will(returnValue("someKey0"));
                allowing(data).getKey(1);
                will(returnValue("someKey1"));
                allowing(data).getKey(2);
                will(returnValue("someKey2"));
            }
        });

        // exercise
        KeyedValues result = DataUtilities.getCumulativePercentages(data);

        // verify
        assertEquals("Cumulative percentage at index 0", 0.3125, result.getValue(0).doubleValue(), 0.0001);
        assertEquals("Cumulative percentage at index 1", 0.875, result.getValue(1).doubleValue(), 0.0001);
        assertEquals("Cumulative percentage at index 2", 1.0, result.getValue(2).doubleValue(), 0.0001);

        // clean up
        mockery.assertIsSatisfied();
    }

    /**
     * Purpose: Verifies the handling of a KeyedValues object with negative values, resulting in cumulative percentages.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testGetCumulativePercentagesNegativeValues() {
        // setup
        Mockery mockery = new Mockery();
        final KeyedValues data = mockery.mock(KeyedValues.class);

        mockery.checking(new Expectations() {
            {
                allowing(data).getItemCount();
                will(returnValue(3)); // Multiple values data
                allowing(data).getValue(0);
                will(returnValue(-5.0)); // Negative value at index 0
                allowing(data).getValue(1);
                will(returnValue(9.0)); // Value at index 1
                allowing(data).getValue(2);
                will(returnValue(2.0)); // Value at index 2
                allowing(data).getKey(0);
                will(returnValue("someKey0"));
                allowing(data).getKey(1);
                will(returnValue("someKey1"));
                allowing(data).getKey(2);
                will(returnValue("someKey2"));
            }
        });

        // exercise
        KeyedValues result = DataUtilities.getCumulativePercentages(data);

        // verify
        assertEquals("Cumulative percentage at index 0", -0.83333, result.getValue(0).doubleValue(), 0.0001);
        assertEquals("Cumulative percentage at index 1", 0.666666, result.getValue(1).doubleValue(), 0.0001);
        assertEquals("Cumulative percentage at index 2", 1.0, result.getValue(2).doubleValue(), 0.0001);

        // clean up
        mockery.assertIsSatisfied();
    }


}
