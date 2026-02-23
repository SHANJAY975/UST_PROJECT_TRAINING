package com.luv2code.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class ConditionalTest {

    @Test
    @Disabled("Test is disabled until #Jira 1424 is resolved")
    void basicTest(){
        // executed for Learning
        System.out.println("Executed");
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForWindows(){
        System.out.println("This will run only on Windows");
    }

}
