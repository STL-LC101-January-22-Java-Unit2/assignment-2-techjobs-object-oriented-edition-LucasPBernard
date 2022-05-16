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

        assertTrue(test_job_02.getId()== test_job_01.getId()+1);


        assertFalse(test_job_01.getId()==(test_job_02.getId()) );
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(aJob.getName(),"Product tester");
        assertEquals(aJob.getEmployer().getValue(),"ACME");
        assertEquals(aJob.getLocation().getValue(),"Desert");
        assertEquals(aJob.getPositionType().getValue(),"Quality control");
        assertEquals(aJob.getCoreCompetency().getValue(),"Persistence");
        assert aJob instanceof Job;

    }
    
}

