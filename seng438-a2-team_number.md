**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#:      |   17  |
| -------------- | --- |
| Student Names: | Zahwa Fatima    |
|                | Isha Haider    |
|                | Saba sadoughi   |
|                |     |

# 1 Introduction

This assignment is structured to provide students with a thorough exploration of automated unit testing in Java using the JUnit framework, with a breakdown into three key sections: 

- familiarization with the testing environment. 
- development of unit tests code based on Javadocs. 
- execution of test suites on multiple versions of the System Under Test.

In the familiarization stage, participants are required to grasp the foundational concepts of setting up the software system under test (SUT) using Eclipse, configuring necessary Java libraries, and creating a basic JUnit test suite for subsequent testing activities. In the unit test development phase, participants are tasked with creating comprehensive test cases for two specific classes, org.jfree.data.Range and org.jfree.data.DataUtilities. The focus includes understanding API specifications, employing mocking objects for testing methods, creating a test plan, applying black-box test-case design techniques, and ultimately coding JUnit and JMock test methods based on the devised test-case design. The final phase involves executing test suites on various versions of the System Under Test (SUT), identifying discrepancies in system behavior as part of the ongoing testing process.


# 2 Detailed description of unit test strategy

# Test Objective
The test objectives are to verify the functionality of various methods within the classes of org.jfree.data package: org.jfree.data.Range and org.jfree.data.DataUtilities. The unit testing should primarily focus on black-box testing to cover the input space as only the requirements of the methods have been provided, suggesting a criteria-based testing approach.



# Features to be Tested

(https://github.com/seng438-winter-2024/seng438-a2-Sabayara82/assets/113862210/275fa64c-e4f2-4b7b-a1f7-d00bb99169ca)

(https://github.com/seng438-winter-2024/seng438-a2-Sabayara82/assets/113862210/5442d46e-d272-4b71-a5a1-529d51366054)


# Testing Strategy and Test-case Design

In the org.jfree.data.Range and org.jfree.data.utilities classes, there is one type of testing primarily conducted.
Black-box testing: Since only the requirements of each method are given, strategies such as equivalence partitioning and boundary value analysis are used 
To begin testing methods, the steps to complete each strategy of black-box testing must first be outlined in order to create streamlined tests for scalable debugging. The following steps are to be used as reference guides in test-case design and determining the scope of the functions/inputs/outputs to be covered.

# Equivalence Classes/Partitioning:
Equivalence Partitioning is a systematic technique used in black-box testing to divide the input domain into equivalence classes. Here are the steps to follow when applying Equivalence Partitioning in tests for the org.jfree.data.Range and org.jfree.data.DataUtilities:

1. Understand the Requirements: Carefully review the requirements or specifications for the software component under test. Identify the input variables and their expected behavior based on these requirements.

2. Identify Input Variables: Determine the input variables or parameters of the method or component being tested. These are the values that the software will accept and process.

3. Derive Input Domains: For each input variable, determine the range of valid and invalid values. This forms the input domain, which includes all possible values that the input variable can take.

4. Divide into Equivalence Classes: Divide the input domain into equivalence classes. An equivalence class is a subset of the input domain where all the values in that subset are considered equivalent in terms of the system's behavior.

5. Identify Boundary Values: For each equivalence class, identify the boundary values. These are the values at the edges of each equivalence class, where the behavior of the system might change.

6. Select Representative Values: Choose one or more representative values from each equivalence class, including boundary values, to design test cases. These values will be used as inputs for testing.

7. Design Test Cases: Create test cases that cover each equivalence class and include both valid and invalid inputs. Each test case should represent a different equivalence class and should exercise the behavior specified in the requirements.

8. Execute Test Cases: Execute the designed test cases against the software component under test. Observe the behavior of the system and compare the actual results with the expected results.

9. Analyze Results: Analyze the test results to determine if the software behaves as expected for each equivalence class. Identify any discrepancies or failures and investigate the root causes.

10. Iterate if Necessary: If any defects are found or if test coverage is insufficient, refine the test cases or identify additional equivalence classes and repeat the testing process as needed.

Following these steps ensures thorough testing of the software component while efficiently covering the input space and verifying compliance with the requirements.


# Boundary Value Analysis:
Boundary Value Analysis (BVA) is a testing technique used in black-box testing to identify test cases at the boundaries of input domains. Here are the steps to follow when applying Boundary Value Analysis in tests for the org.jfree.data.Range and org.jfree.data.DataUtilities:

1. Understand the Requirements: Carefully review the requirements or specifications for the software component under test. Identify the input variables and their expected behavior based on these requirements.

2. Identify Input Variables: Determine the input variables or parameters of the method or component being tested. These are the values that the software will accept and process.

3. Derive Input Domains: For each input variable, determine the range of valid and invalid values. This forms the input domain, which includes all possible values that the input variable can take.

4. Identify Boundary Values: For each input variable, identify the boundary values. These are the values at the edges of the input domain where the behavior of the system might change. Boundary values include the minimum, maximum, and values just inside and outside the valid range.

5. Determine Test Cases: Generate test cases based on the identified boundary values. Each test case should cover one or more boundary values for each input variable. Consider both the valid and invalid boundaries.

6. Consider Equivalence Classes: While BVA focuses on testing boundary values, it's important to also include test cases for the equivalence classes within the valid and invalid ranges. This ensures comprehensive coverage of the input domain.

7. Design Test Cases: Create test cases based on the identified boundary values and equivalence classes. Ensure that each test case represents a specific boundary condition and exercises the behavior specified in the requirements.

8. Execute Test Cases: Execute the designed test cases against the software component under test. Observe the behavior of the system and compare the actual results with the expected results.

9. Analyze Results: Analyze the test results to determine if the software behaves as expected at the boundaries of the input domain. Identify any discrepancies or failures and investigate the root causes.

10. Iterate if Necessary: If any defects are found or if test coverage is insufficient, refine the test cases or identify additional boundary values and repeat the testing process as needed.

Following these steps ensures thorough testing of the software component while focusing on critical boundary conditions that are more likely to lead to errors or unexpected behavior.


# 3 Test cases developed
# Class RangeTest

## Combine Method

- **testCombineBothNullRanges:**
  - *Description:* Combining both null ranges in the Range class should result in null.
  - *Expected Outcome:* Null.
  - *Testing Type:* Equivalence Class Testing.

- **testCombineFirstRangeIsNull:**
  - *Description:* Combining with the first range being null should result in the return of the other range.
  - *Expected Outcome:* Range.
  - *Testing Type:* Equivalence Class Testing.

- **testCombineSecondRangeIsNull:**
  - *Description:* Combining with the first range being null in the Range class should result in the return of the other range.
  - *Expected Outcome:* Range.
  - *Testing Type:* Equivalence Class Testing.

- **testCombineBothRangesAreNotNullOverlapping:**
  - *Description:* Combining overlapping non-null ranges in the Range class should throw an IllegalArgumentException with an appropriate error message.
  - *Expected Outcome:* IllegalArgumentException with "Invalid range combination: ranges must not overlap" message. Or appropriate Range calculation.
  - *Testing Type:* Boundary Testing.

- **testCombineBothRangesAreNotNullNonOverlapping:**
  - *Description:* Combining non-null non-overlapping ranges  in the Range class should result in the expected range.
  - *Expected Outcome:* Expected non-overlapping range.
  - *Testing Type:* Equivalence Testing.

- **testCombineSameRanges:**
  - *Description:* Combining identical ranges  in the Range class should throw an IllegalArgumentException with an appropriate error message.
  - *Expected Outcome:* IllegalArgumentException with "Invalid range combination: ranges must not be empty" message.
  - *Testing Type:* Boundary Testing.

## getCentralValue Method

- **testGetCentralValueMinimumValidRange:**
  - *Description:* Verify that the central value is correctly calculated for the minimum valid range in class Range.
  - *Expected Outcome:* Central value should be Double.MIN_VALUE + 0.5.
  - *Testing Type:* Boundary Value Testing (LB).

- **testGetCentralValueMaximumValidRange:**
  - *Description:* Verify that the central value is correctly calculated for the maximum valid range in class Range.
  - *Expected Outcome:* Central value should be Double.MAX_VALUE - 0.5.
  - *Testing Type:* Boundary Value Testing (UB).

- **testGetCentralValueValidRange:**
  - *Description:* Verify that the central value is correctly calculated for a valid range in class Range.
  - *Expected Outcome:* Central value should be 3.
  - *Testing Type:* Equivalence Testing.

- **testGetCentralValueInvalidRange:**
  - *Description:* Verify that an IllegalArgumentException is thrown for an invalid range.
  - *Expected Outcome:* Exception message should be "Invalid range: end value must be greater than or equal to start value".
  - *Testing Type:* Boundary Testing.

- **testGetCentralValueSinglePointRange:**
  - *Description:* Verify that the central value is correctly calculated for a single-point range in class Range.
  - *Expected Outcome:* Central value should be 3.
  - *Testing Type:* Equivalence Testing.

- **testGetCentralValueEmptyRange:**
  - *Description:* Verify that Double.NaN is returned for an empty range in class Range.
  - *Expected Outcome:* Central value should be Double.NaN.
  - *Testing Type:* Boundary Testing.

- **testGetCentralValueEntireRangeOfDoubles:**
  - *Description:* Verify that the central value is correctly calculated for the entire range of doubles in class Range.
  - *Expected Outcome:* Central value should be 0.
  - *Testing Type:* Equivalence Testing.

- **testGetCentralValueTwoRangesWithDifferentWidths:**
  - *Description:* Verify that an IllegalArgumentException is thrown when trying to get the central value of combined ranges with different widths in class Range.
  - *Expected Outcome:* Exception message should be "Invalid ranges for combining".
  - *Testing Type:* Boundary Testing.

## getLength Method

- **testGetLengthValidPositiveRange:**
  - *Description:* Verify that the length is correctly calculated for a valid positive range.
  - *Expected Outcome:* Length should be 5.
  - *Testing Type:* Equivalence Testing.

- **testGetLengthValidNegativeRange:**
  - *Description:* Verify that the length is correctly calculated for a valid negative range.
  - *Expected Outcome:* Length should be 3.
  - *Testing Type:* Equivalence Testing.

- **testGetLengthValidMixedRange:**
  - *Description:* Verify that the length is correctly calculated for a valid mixed range.
  - *Expected Outcome:* Length should be 7.
  - *Testing Type:* Equivalence Testing.

- **testGetLengthSinglePointRange:**
  - *Description:* Verify that the length is correctly calculated for a single-point range.
  - *Expected Outcome:* Length should be 0.
  - *Testing Type:* Equivalence Testing.

- **testGetLengthMinimumValidRange:**
  - *Description:* Verify that the length is correctly calculated for the minimum valid range.
  - *Expected Outcome:* Length should be 1.
  - *Testing Type:* Boundary Testing.

- **testGetLengthMaximumValidRange:**
  - *Description:* Verify that the length is correctly calculated for the maximum valid range.
  - *Expected Outcome:* Length should be 1.
  - *Testing Type:* Boundary Testing.

- **testGetLengthEmptyRange:**
  - *Description:* Verify that the length is correctly calculated for an empty range.
  - *Expected Outcome:* Length should be 0.
  - *Testing Type:* Boundary Testing.

- **testGetLengthLargePositiveDifference:**
  - *Description:* Verify that the length is correctly calculated for a range with a large positive difference.
  - *Expected Outcome:* Length should be 990.
  - *Testing Type:* Equivalence Testing.

- **testGetLengthLargeNegativeDifference:**
  - *Description:* Verify that the length is correctly calculated for a range with a large negative difference.
  - *Expected Outcome:* Length should be 990.
  - *Testing Type:* Equivalence Testing.

- **testGetLengthDecimalValues:**
  - *Description:* Verify that the length is correctly calculated for a range with decimal values.
  - *Expected Outcome:* Length should be 5.
  - *Testing Type:* Equivalence Testing.

- **testGetLengthInvalidRange:**
  - *Description:* Verify that an IllegalArgumentException is thrown for an invalid range.
  - *Expected Outcome:* Exception message should be "Invalid range: end value must be greater than or equal to start value".
  - *Testing Type:* Boundary Testing.

## Constrain Method

- **testConstrainWithinRange:**
  - *Description:* Verify that the constrained value is correct for a value within the range.
  - *Expected Outcome:* Constrained value should be 5.
  - *Testing Type:* Equivalence Testing.

- **testConstrainAtLowerBound:**
  - *Description:* Verify that the constrained value is correct for a value at the lower bound.
  - *Expected Outcome:* Constrained value should be 3.
  - *Testing Type:* Equivalence Testing.

- **testConstrainAtUpperBound:**
  - *Description:* Verify that the constrained value is correct for a value at the upper bound.
  - *Expected Outcome:* Constrained value should be 8.
  - *Testing Type:* Equivalence Testing.

- **testConstrainBelowLowerBound:**
  - *Description:* Verify that the constrained value is correct for a value below the lower bound.
  - *Expected Outcome:* Constrained value should be 3.
  - *Testing Type:* Equivalence Testing.

- **testConstrainAboveUpperBound:**
  - *Description:* Verify that the constrained value is correct for a value above the upper bound.
  - *Expected Outcome:* Constrained value should be 8.
  - *Testing Type:* Equivalence Testing.

- **testConstrainMinimumValidRangeValue:**
  - *Description:* Verify that the constrained value is correct for the minimum valid range value.
  - *Expected Outcome:* Constrained value should be 0.
  - *Testing Type:* Boundary Testing.

- **testConstrainMaximumValidRangeValue:**
  - *Description:* Verify that the constrained value is correct for the maximum valid range value.
  - *Expected Outcome:* Constrained value should be Double.MAX_VALUE - 1.
  - *Testing Type:* Boundary Testing.

- **testConstrainMinimumDoubleValue:**
  - *Description:* Verify that the constrained value is correct for the minimum double value.
  - *Expected Outcome:* Constrained value should be -100.
  - *Testing Type:* Boundary Testing.

- **testConstrainMaximumDoubleValue:**
  - *Description:* Verify that the constrained value is correct for the maximum double value.
  - *Expected Outcome:* Constrained value should be 100.
  - *Testing Type:* Boundary Testing.

- **testConstrainNaN:**
  - *Description:* Verify that the constrained value is correct for NaN.
  - *Expected Outcome:* Constrained value should be 0.
  - *Testing Type:* Boundary Testing.

- **testConstrainPositiveInfinity:**
  - *Description:* Verify that the constrained value is correct for positive infinity.
  - *Expected Outcome:* Constrained value should be 10.
  - *Testing Type:* Boundary Testing.

- **testConstrainNegativeInfinity:**
  - *Description:* Verify that the constrained value is correct for negative infinity.
  - *Expected Outcome:* Constrained value should be 0.
  - *Testing Type:* Boundary Testing.

## Contains Method

- **testContainsValueInsideRange:**
  - *Description:* Verify that the method correctly identifies a value inside the range.
  - *Expected Outcome:* The range should contain the value 7.5.
  - *Testing Type:* Equivalence Testing.

- **testContainsValueAtLowerBound:**
  - *Description:* Verify that the method correctly identifies a value at the lower bound of the range.
  - *Expected Outcome:* The range should contain the value 5.0.
  - *Testing Type:* Equivalence Testing.

- **testContainsValueAtUpperBound:**
  - *Description:* Verify that the method correctly identifies a value at the upper bound of the range.
  - *Expected Outcome:* The range should contain the value 10.0.
  - *Testing Type:* Equivalence Testing.

- **testContainsValueOutsideRange:**
  - *Description:* Verify that the method correctly identifies a value outside the range.
  - *Expected Outcome:* The range should not contain the value 2.5.
  - *Testing Type:* Equivalence Testing.

- **testContainsValueEqualToLowerBound:**
  - *Description:* Verify that the method correctly identifies a value equal to the lower bound as not within the range.
  - *Expected Outcome:* The range should not contain the value 4.999.
  - *Testing Type:* Equivalence Testing.

- **testContainsValueEqualToUpperBound:**
  - *Description:* Verify that the method correctly identifies a value equal to the upper bound as not within the range.
  - *Expected Outcome:* The range should not contain the value 10.0001.
  - *Testing Type:* Equivalence Testing.

# Class DataUtilitiesTest

## CalculateColumnTotal Method

- **testCalculateColumnTotalTwoValues:**
  - *Description:* Verifies the calculation of the column total for a Values2D object with two values.
  - *Expected Outcome:* The sum of values (7.5 and 2.5) should be 10.0.
  - *Testing Type:* Equivalence Testing.

- **testCalculateColumnTotalValidInput:**
  - *Description:* Verifies the calculation of the column total for a Values2D object with multiple values in each row.
  - *Expected Outcome:* The sum of values (2.5 + 3.5 + 4.5) should be 10.5.
  - *Testing Type:* Equivalence Testing.

- **testCalculateColumnTotalEmptyDataTable:**
  - *Description:* Verifies the calculation of the column total for an empty data table.
  - *Expected Outcome:* The sum should be 0.0 (empty data table).
  - *Testing Type:* Equivalence Testing.

- **testCalculateColumnTotalSingleValue:**
  - *Description:* Verifies the calculation of the column total for a data table with a single value.
  - *Expected Outcome:* The sum should be the single value (5.5).
  - *Testing Type:* Equivalence Testing.

- **testCalculateColumnTotaltestInvalidColumnIndex:**
  - *Description:* Verifies the calculation of the column total for a data table with an invalid column index (boundary value testing).
  - *Expected Outcome:* Expects an InvalidParameterException with the message "Invalid column index: -1".
  - *Testing Type:* Boundary Value Testing.

- **testCalculateColumnTotalNullDataTable:**
  - *Description:* Verifies the handling of a null data table input.
  - *Expected Outcome:* Expects a NullPointerException for a null data table.
  - *Testing Type:* Boundary Value Testing.

## CalculateRowTotal Method

- **testCalculateRowTotalThreeValues:**
  - *Description:* Verifies the calculation of the row total for a Values2D object with three values in a row.
  - *Expected Outcome:* The sum of values (2.5 + 3.5 + 4.5) should be 10.5.
  - *Testing Type:* Equivalence Testing.

- **testCalculateRowTotalEmptyDataTable:**
  - *Description:* Verifies the calculation of the row total for an empty data table.
  - *Expected Outcome:* The sum should be 0.0 (empty data table).
  - *Testing Type:* Equivalence Testing.

- **testCalculateRowTotalSingleValueInDataTable:**
  - *Description:* Verifies the calculation of the row total for a data table with a single value.
  - *Expected Outcome:* The sum should be the single value (5.5).
  - *Testing Type:* Equivalence Testing.

- **testCalculateRowTotalInvalidRowIndex:**
  - *Description:* Verifies the calculation of the row total for a data table with invalid row indices (boundary value testing).
  - *Expected Outcome:* Expects InvalidParameterException for negative index and index exceeding the number of rows.
  - *Testing Type:* Boundary Value Testing.

- **testCalculateRowTotalNullDataTable:**
  - *Description:* Verifies the handling of a null data table input.
  - *Expected Outcome:* Expects NullPointerException for a null data table.
  - *Testing Type:* Boundary Value Testing.

## CreateNumberArray Method

- **testCreateNumberArrayValidInput:**
  - *Description:* Verifies the creation of a Number array from a valid input data array.
  - *Expected Outcome:* The resulting Number array should have the same length as the input, and each element should match the corresponding element in the input array.
  - *Testing Type:* Equivalence Testing.

- **testCreateNumberArrayEmptyDataArray:**
  - *Description:* Verifies the creation of a Number array from an empty input data array.
  - *Expected Outcome:* The resulting Number array should be empty.
  - *Testing Type:* Equivalence Testing.

- **testCreateNumberArrayNullDataArray:**
  - *Description:* Verifies the handling of a null input data array.
  - *Expected Outcome:* Expects NullPointerException for a null data array.
  - *Testing Type:* Boundary Value Testing.

## CreateNumberArray2D Method

- **testCreateNumberArray2DNullData:**
  - *Description:* Verifies if the 2D array receives null data, it should throw an InvalidParameterException.
  - *Expected Outcome:* Expects InvalidParameterException for null data.
  - *Testing Type:* Boundary Value Testing.

- **testCreateNumberArray2DNullData2:**
  - *Description:* Verifies if the 2D array receives null data, it should throw an IllegalArgumentException.
  - *Expected Outcome:* Expects IllegalArgumentException for null data.
  - *Testing Type:* Boundary Value Testing.

- **testCreateNumberArray2DEmptyData:**
  - *Description:* Verifies the creation of a Number 2D array from an empty input data array.
  - *Expected Outcome:* The resulting Number 2D array should be empty.
  - *Testing Type:* Equivalence Testing.

- **testCreateNumberArray2DSingleRowSingleColumn:**
  - *Description:* Verifies the creation of a Number 2D array from a single-row single-column input data array.
  - *Expected Outcome:* The resulting Number 2D array should have the expected values.
  - *Testing Type:* Equivalence Testing.

- **testCreateNumberArray2DMultipleRowsAndColumns:**
  - *Description:* Verifies the creation of a Number 2D array from a multiple-row multiple-column input data array.
  - *Expected Outcome:* The resulting Number 2D array should have the expected values.
  - *Testing Type:* Equivalence Testing.

- **testCreateNumberArray2DNegativeValues:**
  - *Description:* Verifies the creation of a Number 2D array from an input data array containing negative values.
  - *Expected Outcome:* The resulting Number 2D array should have the expected negative values.
  - *Testing Type:* Equivalence Testing.

## GetCalculatedPrecentages Method

- **testGetCumulativePercentagesNullData:**
  - *Description:* Verifies if the method throws an InvalidParameterException when provided with null data.
  - *Expected Outcome:* Expects InvalidParameterException for null data.
  - *Testing Type:* Boundary Value Testing.

- **testGetCumulativePercentagesEmptyData:**
  - *Description:* Verifies the computation of cumulative percentages for an empty data set.
  - *Expected Outcome:* The resulting KeyedValues should be empty.
  - *Testing Type:* Equivalence Testing.

- **testGetCumulativePercentagesSingleValue:**
  - *Description:* Verifies the computation of cumulative percentages for a data set with a single value.
  - *Expected Outcome:* The resulting KeyedValues should have a single entry with a cumulative percentage of 1.0.
  - *Testing Type:* Equivalence Testing.

- **testGetCumulativePercentagesMultipleValues:**
  - *Description:* Verifies the computation of cumulative percentages for a data set with multiple values.
  - *Expected Outcome:* The resulting KeyedValues should have cumulative percentages calculated correctly.
  - *Testing Type:* Equivalence Testing.

- **testGetCumulativePercentagesNegativeValues:**
  - *Description:* Verifies the computation of cumulative percentages for a data set with negative values.
  - *Expected Outcome:* The resulting KeyedValues should have cumulative percentages calculated correctly, considering negative values.
  - *Testing Type:* Equivalence Testing.


#Benefits and Drawbacks of Mocking

For methods utilizing interfaces, mocking is required as the specified unit of code depends upon an external object. Essentially, these mock objects mimic the real object being replaced, but do not actually perform any real functions. Testers can specifically set values, errors, etc. to simulate the behavior of an object in a controlled environment, without having to worry about other dependencies. This dummy implementation for an interface or class is made in a Mock framework, namely jMock for the purposes of this test suite. A mock object is created to return a descriptor that can be used to call methods on. 

@Test
public void test_calculateColumnTotalEmptyDataTable() {
    // setup
    Mockery mockingContext = new Mockery();
    final Values2D values = mockingContext.mock(Values2D.class);
    mockingContext.checking(new Expectations() {
        {
            one(values).getRowCount();
            will(returnValue(0)); // Zero rows
        }
    });
    // exercise
    double result = DataUtilities.calculateColumnTotal(values, 0);
    // verify
    assertEquals(result, 0.0, .000000001d); // Expected sum: 0 (empty data table)

As the method calculateColumnTotal requires a Values2D parameter, it is an indication that the code depends on an external object. In the above example, mocking is used to create a Values2D object and set data for it by calling methods such as getRow() and specifying what it will return (lines 8-9). 

The drawbacks of mocking mostly revolve around excessive and careless use. Over-mocking and under-testing are a major concern that our group faced in that mocking could unknowingly become a workaround for bad code design. In over utilizing the benefits of mocking, testing the actual interaction of the method with fully-functional objects can be overlooked, resulting in a lack of coverage.

# 4 How the team work/effort was divided and managed

Members of the group each read through the introduction and completed exercises 2.1.1-2.1.4 independently. The development of unit test code (2.2) was split amongst three members, 1 person on design and two on writing the test code based on the design. Once the design component was complete, the other two members were briefed on the approach to testing and what kind of constraints existed in development. They reviewed the test plan and determined the testing strategy, the methods to be tested, and their respective details (parameters, return).

# 5 Difficulties encountered, challenges overcome, and lessons learned

A difficulty faced was setting up the testing environment in Eclipse for one of our team members. Initially we came up with a system where she would use our computer resources for her part of the project. To fully overcome this challenge however we restarted the entire set up on her end multiple times and downloaded various files until she was able to complete the lab with her own laptop. 


# 6 Comments/feedback on the lab itself

Text…
