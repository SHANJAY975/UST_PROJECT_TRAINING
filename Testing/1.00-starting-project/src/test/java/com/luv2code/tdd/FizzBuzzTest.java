package com.luv2code.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    @DisplayName("Divisible By Three")
    @Order(1)
    @Test
    void testForDivisibleByThree(){
        String expected = "Fizz";
        assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
    }


    @DisplayName("Divisible By Five")
    @Order(2)
    @Test
    void testForDivisibleByFive(){
        String expected = "Buzz";
        assertEquals(expected, FizzBuzz.compute(5), "Should return Buzz");
    }

    @DisplayName("Divisible By Three and Five")
    @Order(3)
    @Test
    void testForDivisibleByThreeAndFive(){
        String expected = "FizzBuzz";
        assertEquals(expected, FizzBuzz.compute(30), "Should return FizzBuzz");
    }

    @DisplayName("Not Divisible By Three and Five")
    @Order(4)
    @Test
    void testForNotDivisibleByThreeAndFive(){
        String expected = "1";
        assertEquals(expected, FizzBuzz.compute(1), "Should return 1");
    }

    @DisplayName("Testing with small data file")
    @Order(5)
    @ParameterizedTest(name = "Values={0}, expected={1}")
    @CsvFileSource(resources = "/small-test-data.csv")
    void testSmallDataFile(int value, String expected){
        assertEquals(expected, FizzBuzz.compute(value), "Should return {expected}");
    }

    @DisplayName("Testing with medium data file")
    @Order(6)
    @ParameterizedTest(name = "Values={0}, expected={1}")
    @CsvFileSource(resources = "/medium-test-data.csv")
    void testMediumDataFile(int value, String expected){
        assertEquals(expected, FizzBuzz.compute(value), "Should return {expected}");
    }

    @DisplayName("Testing with Large data file")
    @Order(7)
    @ParameterizedTest(name = "Values={0}, expected={1}")
    @CsvFileSource(resources = "/large-test-data.csv")
    void testLargeDataFile(int value, String expected){
        assertEquals(expected, FizzBuzz.compute(value), "Should return {expected}");
    }
}
