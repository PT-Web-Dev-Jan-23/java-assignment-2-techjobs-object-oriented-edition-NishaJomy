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
        Job jobObj1 = new Job();
        Job jobObj2 = new Job();
        assertNotEquals(jobObj1.getId(),jobObj2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobObj3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(jobObj3.getName(),"Product tester");
        assertTrue(jobObj3.getEmployer() instanceof Employer);
        assertTrue(jobObj3.getLocation() instanceof Location);
        assertTrue(jobObj3.getPositionType() instanceof PositionType);
        assertTrue(jobObj3.getCoreCompetency() instanceof CoreCompetency);

    }
    @Test
    public void testJobsForEquality() {
        Job jobObj4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobObj5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(jobObj4,jobObj5);
    }

}
