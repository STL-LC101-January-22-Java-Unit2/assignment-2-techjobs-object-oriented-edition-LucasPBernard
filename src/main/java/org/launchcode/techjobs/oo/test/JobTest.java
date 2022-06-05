package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

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
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');
        System.out.println(firstChar);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char n = 'N';
        char p = 'P';
        assertTrue(aJob.toString().contains("Product tester"));
        assertEquals(n, aJob.toString().charAt(7));
        assertEquals(p, aJob.toString().charAt(13));
        assertEquals(p, aJob.toString().charAt(108));
        assertEquals(aJob.getEmployer().toString(),"ACME");
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job2 = new Job(null, new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNull(job2.getName());
        assertEquals(job2.toString().charAt(13),'D');
        assertEquals(job2.getPositionType().toString(),"Quality control");
        assertEquals(job2.getEmployer().toString(),"ACME");
        assertTrue(job2.toString().contains("Data not available"));

    }


}

