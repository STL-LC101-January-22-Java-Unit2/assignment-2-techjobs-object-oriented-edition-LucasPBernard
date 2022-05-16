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

//        assertEquals(test_job_01.getId(),1);
//        assertEquals(test_job_02.getId(),2);
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
        //object is correct class
        assert aJob instanceof Job;
    }

    @Test
    public void testJobsForEquality() {
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job anotherJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(aJob==anotherJob);
        System.out.println(aJob);
        System.out.println(anotherJob);

    }

}

