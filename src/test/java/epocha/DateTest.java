package epocha;

import static org.junit.Assert.*;

import org.junit.Test;
import epocha.types.MonthType;

public class DateTest
{
    @Test
    public void shouldReturnYearInNumberOfDays() {
        // given
        Date date = new Date(1, 1, 2000);
        int expected = 730500;

        // when
        int actual = date.getYearInNumberOfDays();

        // then
        assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnMonthInNumberOfDaysWhenCurrentYearIsALeapYear() {
        // given
        Date date = new Date(1, 4, 2000);
        int expected = 121;

        // when
        int actual = date.getMonthInNumberOfDays();

        // then
        assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnMonthInNumberOfDaysWhenCurrentYearIsNotALeapYear() {
        // given
        Date date = new Date(1, 4, 2001);
        int expected = 120;

        // when
        int actual = date.getMonthInNumberOfDays();

        // then
        assertEquals(actual, expected);
    }
}
