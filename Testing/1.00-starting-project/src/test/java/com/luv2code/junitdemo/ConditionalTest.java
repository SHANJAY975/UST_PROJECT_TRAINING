package com.luv2code.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class ConditionalTest {

    @Test
    @Disabled("Don't run until Jira #123 is resolved")
    void basicTest(){
        //execute method and perform asserts
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForWindowsOnly(){
        //execute method and perform asserts
    }
    @Test
    @EnabledOnOs(OS.MAC)
    void testForMacOnly(){
        //execute method and perform asserts
    }
    @Test
    @EnabledOnOs({OS.WINDOWS, OS.MAC})
    void testForMacAndWindowsOnly(){
        //execute method and perform asserts
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "UST_ENV", matches = "DEV")
    void testOnlyForDevEnvironment(){
        //execute method and perform asserts
    }

    @Test
    @EnabledIfSystemProperty(named = "UST_SYS_PROP", matches = "CI_CD_DEPLOY")
    void testOnlyForSystemProperty(){
        //execute method and perform asserts
    }
}
