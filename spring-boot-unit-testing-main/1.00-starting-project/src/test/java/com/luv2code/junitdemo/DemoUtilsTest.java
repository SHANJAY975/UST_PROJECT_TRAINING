package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DemoUtilsTest {
    DemoUtils demoUtils;

    @Test
    @DisplayName("Test Equals And not Equals")
    @Order(3)
    void TestEqualsAndNotEquals(){
        System.out.println("Running Test: Test Equals And Not Equals");

        assertEquals(6, demoUtils.add(4,2), "2+4 must be 6");
        assertNotEquals(8, demoUtils.add(2,4), "2+4 should not be 8");
    }

    @Test
    @Order(0)
    void Test_Null_And_Not_Null(){
        System.out.println("Running Test: TestNullAndNotNull");

        String s1 = null;
        String s2 = "hello";
        assertNull( demoUtils.checkNull(s1), "String should be null");
        assertNotNull(demoUtils.checkNull(s2), "String should not be null");
    }

     @BeforeEach
    void setUpBeforEach(){
        demoUtils = new DemoUtils();
        System.out.println("@BeforeEach executed before the execution of each testcase");
    }

    @Test
    @DisplayName("Array Equals")
    @Order(2)
    void test_Array_Equals(){
        String []arr = {"A","B","C"};
        assertArrayEquals(arr, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays Should be the same");
    }

    @Test
    @DisplayName("Iterable Equals")
    @Order(1)
    void testIterableEquals(){
        List<String> lst = List.of("luv", "2", "code");
        assertIterableEquals(lst, demoUtils.getAcademyInList(), "Iterables should be same");
    }

    @Test
    void testThrowsAndDoesNotThrows(){
        assertThrows(Exception.class, ()->demoUtils.throwException(-1), "Should throw an Exception");
        assertDoesNotThrow(()->demoUtils.throwException(3), "Should not throw Exception");
    }

    @Test
    void testTimeDuration(){
        assertTimeoutPreemptively(Duration.ofSeconds(3),()->{demoUtils.checkTimeout();}, "Should Execute in 3Sec");
    }
    /*

    @AfterEach
    void tearDownAfterEach(){
        System.out.println("@AfterEach executed");
        System.out.println();
    }

    @BeforeAll
    static void setUpBeforeAll(){
        System.out.println("@BeforeAll is executed only once before all testcases");
    }

    @AfterAll
    static void tearDownAfterAll(){
        System.out.println("@AfterAll is executed only once before after test methods are executed");
    }
     */
}
