package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)

public class JobTest {

    @Before
    public void createJobObjects() {
        Job emptyJob1 = new Job();
        Job emptyJob2 = new Job();
    }

    @Test
    public void testSettingJobId() {
        Job emptyJob1 = new Job();
        Job emptyJob2 = new Job();
//assertNotEquals to verify that the IDs of the two objects are distinct
        assertNotEquals(emptyJob1, emptyJob2);
        // id values are not the same
        //assertFalse(emptyJob1.equals(emptyJob2));

        // id values differ by one
      //  assertTrue((emptyJob2.getId() - 1) == emptyJob1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob instanceof Job);

        assertEquals(testJob.getName(),"Product tester");

        //assertTrue(testJob.getEmployer() instanceof Employer);
        assertEquals(testJob.getEmployer().getValue(), "ACME");

       // assertTrue(testJob.getLocation() instanceof Location);
        assertEquals(testJob.getLocation().getValue(),"Desert");

       // assertTrue(testJob.getPositionType() instanceof PositionType);
        assertEquals(testJob.getPositionType().getValue(),"Quality control");

       // assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job Job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job Job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // id values are not the same
        assertFalse(Job1.equals(Job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;
        int lastIndex = (testJob.toString().length() - 1);

        assertEquals(testJob.toString().charAt(0), '\n');
        assertEquals(testJob.toString().charAt(lastIndex) ,'\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String[] lines = testJob.toString().trim().split("\n");

        System.out.println(testJob.toString());

        assertTrue(lines.length == 6);

        assertTrue(lines[0].startsWith("ID:"));
        assertTrue(lines[1].startsWith("Name:"));
        assertTrue(lines[2].startsWith("Employer:"));
        assertTrue(lines[3].startsWith("Location:"));
        assertTrue(lines[4].startsWith("Position Type:"));
        assertTrue(lines[5].startsWith("Core Competency:"));

        assertTrue(lines[0].endsWith(Integer.toString(testJob.getId())));
        assertTrue(lines[1].endsWith(testJob.getName()));
        assertTrue(lines[2].endsWith(testJob.getEmployer().toString()));
        assertTrue(lines[3].endsWith(testJob.getLocation().toString()));
        assertTrue(lines[4].endsWith(testJob.getPositionType().toString()));
        assertTrue(lines[5].endsWith(testJob.getCoreCompetency().toString()));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob5 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency(""));
        assertEquals("\nID: " + testJob5.getId() + "\nName: Product tester\nEmployer: Data not available\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Data not available\n" , testJob5.toString());
        Job testJob6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency(""));
        assertEquals("\nID: " + testJob6.getId() + "\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Data not available\n" , testJob6.toString());

    }

}