// Name: Omar Waleed Zenhom     ID: 20206130
// Name: Mohamed Alaa El-Din    ID: 20206068

package org.jfree.data.test;

import org.jfree.data.time.Quarter;
import org.junit.Test;

import static org.junit.Assert.*;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class QuarterClassTest {
    Quarter quarter;

    private void arrange(Integer quart, Integer year) {
        quarter = new Quarter(quart, year);
    }

    private void arrange() {
        quarter = new Quarter();
    }
    // Constractors Testing
    // Test 1: Test the Quarter() constructor - Default constructor
    @Test
    public void testQuarterDefaultCtor() {
        arrange();
        assertEquals(2023, quarter.getYear().getYear());
        assertEquals(2, quarter.getQuarter());
    }

    // Test 2: Test the Quarter(int quarter,int year) constructor
    @Test
    public void testQuarterIntInt() {
        arrange(2, 2002);
        assertEquals(2002, quarter.getYear().getYear());
        assertEquals(2, quarter.getQuarter());
    }
    @Test
    public void testQuarterIntIntConstructorInvalidQuarter() {
        arrange(-5, 2023);
        assertEquals(2023, quarter.getYear().getYear());
        assertEquals("Quarter outside valid range.", quarter.getQuarter());
    }
    @Test
    public void testQuarterIntIntConstructorInvalidYear() {
        arrange(1, 1800);
        assertEquals("Year outside valid range.", quarter.getYear().getYear());
        assertEquals(1, quarter.getQuarter());
    }

    // Test 3: Test the Quarter(int quarter, Year year) constructor
    @Test
    public void testQuarterIntYear() {
        Year year = Year.of(2023);
        Quarter quarter = new Quarter(2, year.getValue());
        assertEquals(2023, quarter.getYear().getYear());
        assertEquals(2, quarter.getQuarter());
    }
    @Test
    public void testQuarterIntYearWithInvalidQuarter() {
        Year year = Year.of(2023);
        Quarter quarter = new Quarter(0, year.getValue());
        assertEquals(2023, quarter.getYear().getYear());
        assertEquals("Quarter outside valid range.", quarter.getQuarter());
    }
    @Test
    public void testQuarterIntYearWithInvalidYear() {
        Year year = Year.of(1800);
        Quarter quarter = new Quarter(2, year.getValue());
        assertEquals("Year outside valid range.", quarter.getYear().getYear());
        assertEquals(2, quarter.getQuarter());
    }

    // Test 4: Test the Quarter(java.util.Date time) constructor
    @Test
    public void testQuarterConstructorWithDate() {
        Date date = new Date();
        Quarter quarter = new Quarter(date);
        assertEquals(2023, quarter.getYear().getYear());
        assertEquals(2, quarter.getQuarter());
    }

    // Test 5: Test the Quarter(java.util.Date time, java.util.TimeZone zone)
    // constructor
    @Test
    public void testDateAndTimeZoneConstructor() {
        Date date = new Date();
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        Quarter quarter = new Quarter(date, timeZone);
        assertNotNull(quarter);
        assertEquals(2023, quarter.getYear().getYear());
        assertEquals(2, quarter.getQuarter());
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    // Methods Testing
    // Test 6: Test the getQuarter() method
    @Test
    public void testGetQuarter() {
        arrange();
        assertEquals(2, quarter.getQuarter());
    }

    // Test 7: Test the getYear() method
    @Test
    public void testGetYear() {
        arrange();
        assertEquals(2023, quarter.getYear().getYear());
    }

    // Test 8: Test the public RegularTimePeriod previous() method
    @Test
    public void testPrevious() {
        Quarter quarter = new Quarter(2, 2023);
        Quarter previousQuarter = (Quarter) quarter.previous();
        assertEquals(1, previousQuarter.getQuarter());
    }
    @Test
    public void testPreviousQ1_1900() {
        Quarter quarter = new Quarter(1, 1900);
        Quarter previousQuarter = (Quarter) quarter.previous();
        assertNull(null, previousQuarter);
    }
    @Test
    public void testPreviouswithInvalidQuarter() {
        Quarter quarter = new Quarter(0, 2023);
        Quarter previousQuarter = (Quarter) quarter.previous();
        assertEquals("Quarter outside valid range.", previousQuarter.getQuarter());
    }

    // Test 9: Test the public RegularTimePeriod next() method
    @Test
    public void testNext() {
        Quarter quarter = new Quarter(2, 2023);
        Quarter nextQuarter = (Quarter) quarter.next();
        assertEquals(3, nextQuarter.getQuarter());
    }
    @Test
    public void testNextQ4_9999() {
        Quarter quarter = new Quarter(4, 9999);
        Quarter nextQuarter = (Quarter) quarter.next();
        assertNull(null, nextQuarter);
    }
    @Test
    public void testNextwithInvalidQuarter() {
        Quarter quarter = new Quarter(0, 2023);
        Quarter nextQuarter = (Quarter) quarter.next();
        assertEquals("Quarter outside valid range.", nextQuarter.getQuarter());
    }

    // Test 10: Test the public long getSerialIndex() method
    @Test
    public void testGetSerialIndex() {
        Quarter q1 = new Quarter(1, 2000);
        Quarter q2 = new Quarter(2, 2000);
        assertTrue(q1.getSerialIndex() < q2.getSerialIndex());
    }

    // Test 11: Test the public boolean equals(java.lang.Object obj) method
    @Test
    public void testEquals() {
        Quarter quarter1 = new Quarter(1, 2023);
        Quarter quarter2 = new Quarter(1, 2023);
        Quarter quarter3 = new Quarter(2, 2023);
        Quarter quarter4 = new Quarter(1, 2022);
        String notAQuarter = "Not a Quarter object";
    
        assertTrue(quarter1.equals(quarter2));
        assertFalse(quarter1.equals(quarter3));
        assertFalse(quarter1.equals(quarter4));
        assertFalse(quarter1.equals(notAQuarter));
    }
    

    // Test 12: Test the public int hashCode() method
    @Test
    public void testHashCode() {
        Quarter quarter1 = new Quarter(1, 2023);
        Quarter quarter2 = new Quarter(1, 2023);
        Quarter quarter3 = new Quarter(2, 2023);
        Quarter quarter4 = new Quarter(1, 2022);

        // Test 1: Same object, same hash code
        int hash1 = quarter1.hashCode();
        int hash2 = quarter1.hashCode();
        assertEquals(hash1, hash2);

        // Test 2: Different object but same quarter and year, same hash code
        int hash3 = quarter1.hashCode();
        int hash4 = quarter2.hashCode();
        assertEquals(hash3, hash4);

        // Test 3: Different object and different quarter, different hash code
        int hash5 = quarter1.hashCode();
        int hash6 = quarter3.hashCode();
        assertNotEquals(hash5, hash6);

        // Test 4: Different object and different year, different hash code
        int hash7 = quarter1.hashCode();
        int hash8 = quarter4.hashCode();
        assertNotEquals(hash7, hash8);
    }

    // Test 13: Test the public int compareTo(java.lang.Object o1) method
    @Test
    public void testCompareTo() {
        Quarter q1 = new Quarter(2, 2021);
        Quarter q2 = new Quarter(3, 2021);
        Quarter q3 = new Quarter(2, 2022);
        Quarter q4 = new Quarter(1, 2021);

        // q1 is before q2
        assertEquals(-1, q1.compareTo(q2));

        // q2 is after q1
        assertEquals(1, q2.compareTo(q1));

        // q1 and q4 are in the same year but q4 is before q1
        assertEquals(1, q1.compareTo(q4));

        // q1 is before q3 even though the years are different
        assertEquals(-1, q1.compareTo(q3));

        // q1 is the same as q1
        assertEquals(0, q1.compareTo(q1));
    }

    // Test 14: Test the public String toString() method
    @Test
    public void testToString() {
        Quarter q1 = new Quarter(2, 2021);
        Quarter q2 = new Quarter(3, 2021);
        Quarter q3 = new Quarter(2, 2022);
        Quarter q4 = new Quarter(1, 2021);
        Quarter q5 = new Quarter(0, 2021);

        assertEquals("Q2/2021", q1.toString());
        assertEquals("Q3/2021", q2.toString());
        assertEquals("Q2/2022", q3.toString());
        assertEquals("Q1/2021", q4.toString());
        assertEquals("Quarter not valid", q5.toString());    
    }

    // Test 15: Test the public long getFirstMillisecond() method
    @Test
    public void testGetFirstMillisecond() {
        // Create a Quarter for Q3 2021
        Quarter q = new Quarter(3, 2021);

        // Create a calendar with the default time zone
        Calendar cal = Calendar.getInstance();

        // Set the calendar to the start of the quarter
        cal.set(Calendar.YEAR, 2021);
        cal.set(Calendar.MONTH, Calendar.JULY);
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        // Get the first millisecond of the quarter using the calendar
        long firstMillisecond = q.getFirstMillisecond(cal);

        // Verify that the first millisecond is correct
        assertNotNull(firstMillisecond);
        assertEquals(cal.getTimeInMillis(), firstMillisecond);
    }

    // Test 16: Test the public long getLastMillisecond() method
    @Test
    public void testGetLastMillisecond() {
        arrange(1, 2022);
        // Create a Quarter for Q3 2021
        Quarter q = new Quarter(3, 2021);
        // Create a calendar with the default time zone
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2022);
        cal.set(Calendar.MONTH, Calendar.JULY);
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        long lastMillisecond = q.getLastMillisecond(cal);
        // Verify that the last millisecond is correct
        assertNotNull(lastMillisecond);
        assertEquals(cal.getTimeInMillis(), lastMillisecond);
    }

    // Test 17: Test the public static Quarter parseQuarter(java.lang.String str)
    // method
    @Test
    public void testParseQuarter() {
        String input1 = "2023-Q3";
        Quarter expectedOutput1 = new Quarter(3, 2023);
        Quarter actualOutput1 = Quarter.parseQuarter(input1);
        assertEquals(expectedOutput1, actualOutput1);

        String input2 = "Q2 2022";
        Quarter expectedOutput2 = new Quarter(2, 2022);
        Quarter actualOutput2 = Quarter.parseQuarter(input2);
        assertEquals(expectedOutput2, actualOutput2);

        String input3 = "Q1/2000";
        Quarter expectedOutput3 = new Quarter(1, 2000);
        Quarter actualOutput3 = Quarter.parseQuarter(input3);
        assertEquals(expectedOutput3, actualOutput3);

        String input4 = "2001-Q4";
        Quarter expectedOutput4 = new Quarter(4, 2001);
        Quarter actualOutput4 = Quarter.parseQuarter(input4);
        assertEquals(expectedOutput4, actualOutput4);

        String input5 = "Q3-1999";
        Quarter expectedOutput5 = new Quarter(3, 1999);
        Quarter actualOutput5 = Quarter.parseQuarter(input5);
        assertEquals(expectedOutput5, actualOutput5);
    }
}
