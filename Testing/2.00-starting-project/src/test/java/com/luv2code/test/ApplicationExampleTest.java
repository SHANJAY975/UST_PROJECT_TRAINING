package com.luv2code.test;

import com.luv2code.component.MvcTestingExampleApplication;
import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class ApplicationExampleTest {

    private static int count = 0;

    @Value("${info.app.name}")
    private String appInfo;

    @Value("${info.app.description}")
    private String appDescription;

    @Value("${info.app.version}")
    private String appVersion;

    @Value("${info.school.name}")
    private String schoolName;

    @Autowired
    private CollegeStudent student;

    @Autowired
    private StudentGrades studentGrades;

    @Autowired
    ApplicationContext context;

    @BeforeEach
    public void beforeEach(){
        count += 1;
        System.out.println("Testing: "+appInfo+" which is "+appDescription+
                " Version: " + appVersion +". Execution of testMethod: "+count);
        student.setFirstname("Eric");
        student.setLastname("Roby");
        student.setEmailAddress("eric@ust.com");
        studentGrades.setMathGradeResults(new ArrayList<Double>(Arrays.asList(100.0, 85.0, 76.50, 91.75)));
        student.setStudentGrades(studentGrades);
    }

    @Test
    void basicTest(){

    }

    @Test
    @DisplayName("Add grade results for student grades")
    public void addGradeResultsForStudentGrades(){
        assertEquals(353.25,
                studentGrades.addGradeResultsForSingleClass(
                        student.getStudentGrades()
                                .getMathGradeResults()
                ));
    }

    @DisplayName("Add grade result for Student grade not equals")
    @Test
    public void addGradeResultsForStudentGradesAssertNotEquals(){
        assertNotEquals(340, studentGrades.addGradeResultsForSingleClass(
                student.getStudentGrades().getMathGradeResults()
        ));
    }

    @DisplayName("Is grade greater")
    @Test
    public void isGradeGreaterStudentGrades(){
        assertTrue(studentGrades.isGradeGreater(90, 75), "Should be True");
    }

    @DisplayName("Is grade greater false")
    @Test
    public void isGradeGreaterStudentGradesAssertFals(){
        assertFalse(studentGrades.isGradeGreater(75, 89), "Should be False");
    }

    @DisplayName("Check Null for Student grades")
    @Test
    public void checkNullForStudentGrades(){
        assertNotNull(
                studentGrades.checkNull(student.getStudentGrades().getMathGradeResults()),
                "Object should not be null"
        );
    }

    @DisplayName("Create Student without grade init")
    @Test
    public void createStudentWithoutGradeInit(){
        CollegeStudent studentTwo = context.getBean("collegeStudent", CollegeStudent.class);
        studentTwo.setFirstname("Chad");
        studentTwo.setLastname("Darby");
        studentTwo.setEmailAddress("chad.darby@ust.com");
        assertNotNull(studentTwo.getFirstname());
        assertNotNull(studentTwo.getLastname());
        assertNotNull(studentTwo.getEmailAddress());
        assertNull(studentGrades.checkNull(studentTwo.getStudentGrades()));
    }

    @DisplayName("verify Students are Prototypes")
    @Test
    public void verifyStudentsArePrototype(){
        CollegeStudent studentTwo = context.getBean("collegeStudent", CollegeStudent.class);
        assertNotSame(student, studentTwo);
    }

    @DisplayName("Find Grade points average")
    @Test
    void findGradePointsAverage(){
        assertAll("Testing all AssertEquals",
        ()-> assertEquals(353.25,
                studentGrades.addGradeResultsForSingleClass(
                        student.getStudentGrades().getMathGradeResults())),
        ()-> assertEquals(88.31,
                        studentGrades.findGradePointAverage(student.getStudentGrades().getMathGradeResults()))
        );
    }
}
