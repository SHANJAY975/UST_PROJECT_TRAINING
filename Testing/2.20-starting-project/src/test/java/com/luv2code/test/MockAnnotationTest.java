package com.luv2code.test;

import com.luv2code.component.MvcTestingExampleApplication;
import com.luv2code.component.dao.ApplicationDao;
import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import com.luv2code.component.service.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class MockAnnotationTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent studentOne;

    @Autowired
    StudentGrades studentGrades;

    // @Mock
    @MockitoBean
    private ApplicationDao applicationDao;

    // @InjectMocks
    @Autowired
    private ApplicationService applicationService;

    @BeforeEach
    void beforeEach(){
        studentOne.setFirstname("Eric");
        studentOne.setLastname("roby");
        studentOne.setEmailAddress("eric.roby@ust.com");
        studentOne.setStudentGrades(studentGrades);
    }

    @DisplayName("When & verify")
    @Test
    void assertEqualsTestAddGrades(){
        when(applicationDao.addGradeResultsForSingleClass(
                studentGrades.getMathGradeResults())).thenReturn(100.00);

        assertEquals(100.00,
                applicationService.addGradeResultsForSingleClass(
                        studentOne.getStudentGrades().getMathGradeResults())
                );

        verify(applicationDao).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());
        verify(applicationDao, times(1)).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());

    }

    @DisplayName("Find Gpa")
    @Test
    void assertEqualsTestFindGpa(){
        when(applicationDao.findGradePointAverage(studentGrades.getMathGradeResults()))
                .thenReturn(88.39);

        assertEquals(88.39, applicationService
                .findGradePointAverage(studentOne.getStudentGrades().getMathGradeResults()));

        verify(applicationDao).findGradePointAverage(studentGrades.getMathGradeResults());
    }

    @DisplayName("Not Null")
    @Test
    void testAssertNotNull(){
        when(applicationDao.checkNull(studentGrades.getMathGradeResults())).thenReturn(true);

        assertNotNull(applicationService.checkNull(
                studentOne.getStudentGrades().getMathGradeResults()),
                "Object should not be null");
    }

    @DisplayName("Throw runtime error")
    @Test
    void throwRuntimeError(){
        CollegeStudent nullstudent = (CollegeStudent) context.getBean("collegeStudent");

        doThrow(new RuntimeException()).when(applicationDao).checkNull(nullstudent);

        assertThrows(RuntimeException.class, ()-> applicationService.checkNull(nullstudent));

        verify(applicationDao, times(1)).checkNull(nullstudent);
    }

    @DisplayName("Multiple Stubbing")
    @Test
    public void stubbingConsecutiveCalls(){
        CollegeStudent nullstudent = (CollegeStudent) context.getBean("collegeStudent");
        when(applicationDao.checkNull(nullstudent))
                .thenThrow(new RuntimeException())
                .thenReturn("Don't throw exception second time");
        assertThrows(RuntimeException.class, ()-> applicationService.checkNull(nullstudent));
        assertEquals("Don't throw exception second time", applicationService.checkNull(nullstudent));
    }
}
