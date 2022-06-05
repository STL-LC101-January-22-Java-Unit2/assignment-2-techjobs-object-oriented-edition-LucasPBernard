package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import javax.swing.text.Position;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job test_job_01 = new Job();
        Job test_job_02 = new Job();

        //Use assertNotEquals to verify that the IDs of the two objects are distinct.
        assertNotEquals(test_job_01.getId(),test_job_02.getId());

        //job increments by 1 each new job
        assertTrue(test_job_02.getId()== test_job_01.getId()+1);
        //2 new jobs are not equal
        assertFalse(test_job_01.getId()==(test_job_02.getId()) );
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //nothing is blank
        //assertTrue((aJob.getId())==1);
        assertTrue((!aJob.getName().isBlank()));
        assertTrue((!aJob.getEmployer().getValue().isBlank()));
        assertTrue((!aJob.getLocation().getValue().isBlank()));
        assertTrue((!aJob.getPositionType().getValue().isBlank()));
        assertTrue((!aJob.getCoreCompetency().getValue().isBlank()));

        //constructor is constructing properly
        assertEquals(aJob.getName(),"Product tester");
        assertEquals(aJob.getEmployer().getValue(),"ACME");
        assertEquals(aJob.getLocation().getValue(),"Desert");
        assertEquals(aJob.getPositionType().getValue(),"Quality control");
        assertEquals(aJob.getCoreCompetency().getValue(),"Persistence");

        //job object is correct class
        assert aJob instanceof Job;

    }

    @Test
    public void testJobsForEquality() {
        //Generate two Job objects that have identical field values EXCEPT for id. Test that equals returns false
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job anotherJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(aJob==anotherJob);

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char firstChar = aJob.toString().charAt(0);
        char lastChar = aJob.toString().charAt(aJob.toString().length()-1);
        assertEquals(Character.toString(firstChar), "\n");
        assertEquals(Character.toString(lastChar), "\n");

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testLetter = "N";
        String testLetter2 = "P";
        assertTrue(aJob.toString().contains("Product tester"));
        assertEquals(testLetter.charAt(0), aJob.toString().charAt(7));
        assertEquals(testLetter2.charAt(0), aJob.toString().charAt(13));
        assertEquals(testLetter2.charAt(0), aJob.toString().charAt(108));
//        System.out.println(aJob.toString().charAt(108));
//        System.out.println(aJob.toString());

    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job();
        Job job2 = new Job(null, null, null, new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(!job.toString().contains("Data not available"));
        assertEquals(job.toString(),"OOPS! This job does not seem to exist.");
        assertEquals(job2.getPositionType().toString(),"Quality control");
        assertTrue(job2.toString().contains("Data not available"));

//        System.out.println(job.toString());
//        System.out.println(job2.toString());

    }


}

