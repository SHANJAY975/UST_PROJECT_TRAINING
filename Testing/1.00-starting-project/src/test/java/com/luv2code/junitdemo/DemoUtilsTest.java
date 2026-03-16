package com.luv2code.junitdemo;


import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoUtilsTest {
    DemoUtils demoUtils;

    @BeforeEach
    void setUpBeforeEach(){
        demoUtils = new DemoUtils();
        // System.out.println("@BeforeEach executes before the execution of each test method");
    }

    @Test
    @DisplayName("Equals And Not Equals")
    @Order(1)
    void test_Equals_And_Not_Equals(){

        assertEquals(6, demoUtils.add(2,4),"4+2 should be 6");
        assertNotEquals(8, demoUtils.add(1,9),"1+9 should not be 8");
    }

    @Test
    void testMultiply(){
        assertEquals(12, demoUtils.multiply(4,3), "4 * 3 should be 12");
    }

    @Test
    @DisplayName("Null And Not Null")
    @Order(0)
    void testNullAndNotNull(){
        String str1 = null;
        String str2 = "shan";
        assertNull(demoUtils.checkNull(str1),"Object should be null");
        assertNotNull(demoUtils.checkNull(str2),"Object should not be null");
    }

    @Test
    @DisplayName("Same And Not Same")
    void testSameAndNotSame(){
        String str = "luv2code";
        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(),"Objects should refer to the same object");
        assertNotSame(str, demoUtils.getAcademyDuplicate(),"Objects should not refer to the same object");
    }

    @DisplayName("True or False")
    @Test
    @Order(30)
    void testTrueOrFalse(){
        int gradeOne = 8;
        int gradeTwo = 2;
        assertTrue(demoUtils.isGreater(gradeOne,gradeTwo),"8 is greater than 2");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "2 is not greater than 8");
    }

    @DisplayName("Array Equals")
    @Test
    void testArrayEquals(){
        String[] stringArray = {"A","B", "C"};

        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays should be same");
    }

    @DisplayName("Iterable Equals")
    @Test
    void testIterableEquals(){
        List<String> theList = List.of("luv", "2", "code");

        assertIterableEquals(theList, demoUtils.getAcademyInList(), "Expected List should be same as the list");
    }

    @DisplayName("Lines Match")
    @Test
    void testLinesMatch(){
        List<String> theList = List.of("luv", "2", "code");
        assertLinesMatch(theList, demoUtils.getAcademyInList(), "Lines should match");
    }

    @DisplayName("Throws And Not Throws")
    @Test
    void testThrowsAndNotThrows(){
        assertThrows(Exception.class, ()-> demoUtils.throwException(-1), "Should throw an Exception");
        assertDoesNotThrow(()-> demoUtils.throwException(9),"Should not throw exception");
    }

    @DisplayName("Time out")
    @Test
    void testTimeOut(){
        assertTimeoutPreemptively(Duration.ofSeconds(3),()-> demoUtils.checkTimeout(),"should not exceed time limit");
    }










    /*
    @AfterEach
    void tearDownAfterEach(){
        System.out.println("Running @AfterEach");
        System.out.println();
    }

    @BeforeAll
    static void setUpBeforeEachClass(){
        System.out.println("@BeforeAll executes only once before all test methods execution in the class");
    }

    @AfterAll
    static void tearDownAfterAll(){
        System.out.println("@AfterAll executes only once after all test methods execution in the class");

    }

     */

}
