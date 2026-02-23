package com.luv2code.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    @Test
    @Order(1)
    @DisplayName("Divisible By Three")
    void testForDivisibleByThree(){
        String expected = "Fizz";
        assertEquals(expected, FizzBuzz.compute(3),"Should be Fizz");
    }

    @Test
    @Order(2)
    @DisplayName("Divisible By Five")
    void testForDivisibleByFive(){
        String expected = "Buzz";
        assertEquals(expected, FizzBuzz.compute(5),"Should be Buzz");
    }

    @Test
    @Order(3)
    @DisplayName("Divisible By Three and Five")
    void testForDivisibleByThreeAndFive(){
        String expected = "FizzBuzz";
        assertEquals(expected, FizzBuzz.compute(30),"Should be FizzBuzz");
    }

    @Test
    @Order(4)
    @DisplayName("Not Divisible By Three and Five")
    void testForNotDivisibleByThreeAndFive(){
        String expected = "1";
        assertEquals(expected, FizzBuzz.compute(1),"Should be 1");
    }


    @Order(0)
    @DisplayName("FizzBuzz Test using CSV")
    @ParameterizedTest(name="value{0}, expected{1}")
    @CsvFileSource(resources = "/small-test-data.csv")
    void testSmallDataFile(int value, String expected){

        assertEquals(expected, FizzBuzz.compute(value));
    }
}
