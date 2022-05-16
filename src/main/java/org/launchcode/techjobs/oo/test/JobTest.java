package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.Job;

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

        assertEquals(test_job_01.getId(),1);
        assertEquals(test_job_02.getId(),2);

        assertTrue(test_job_02.getId()== test_job_01.getId()+1);


        assertFalse(test_job_01.getId()==(test_job_02.getId()) );
    }



}

