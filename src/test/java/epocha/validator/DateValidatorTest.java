package epocha.validator;

import static org.junit.Assert.*;

import org.junit.Test;
import epocha.Date;

public class DateValidatorTest
{
    @Test
    public void shouldReturnFalseWhenTheGivenYearIsLaterThanTheMaximumAllowableYear() {
        // given
        Date date = new Date(14, 2, 2020);

        // when
        // then
        assertFalse(DateValidator.isValidYear(date.getYear()));
    }

    @Test
    public void shouldReturnFalseWhenTheGivenYearIsEarlierThanTheMinimumAllowableYear() {
        // given
        Date date = new Date(14, 2, 1800);
        
        // when
        // then
        assertFalse(DateValidator.isValidYear(date.getYear()));
    }

    @Test
    public void shouldReturnTrueWhenTheGivenYearIsWithinTheAllowableYearRange() {
        // given
        Date date = new Date(14, 2, 1983);

        // when
        // then
        assertTrue(DateValidator.isValidYear(date.getYear()));
    }

    @Test
    public void shouldReturnFalseWhenTheGivenMonthIsLaterThanTheMaximumAllowableMonth() {
        // given
        Date date = new Date(7, 15, 2001);

        // when
        // then
        assertFalse(DateValidator.isValidMonth(date.getMonth()));
    }

    @Test
    public void shouldReturnFalseWhenTheGivenMonthIsLaterThanTheMinimumAllowableMonth() {
        // given
        Date date = new Date(5, 0, 2008);

        // when
        // then
        assertFalse(DateValidator.isValidMonth(date.getMonth()));
    }

    @Test
    public void shouldReturnTrueWhenTheGivenMonthIsWithinTheAllowableMonthRange() {
        // given
        Date date = new Date(10, 10, 2004);

        // when
        // then
        assertTrue(DateValidator.isValidMonth(date.getMonth()));
    }

    @Test
    public void shouldReturnFalseWhenTheGivenDayIsEarlierThanTheMinimumAllowableDay() {
        // given
        Date date = new Date(0, 10, 2010);

        // when
        // then
        assertFalse(DateValidator.isValidDay(date.getDay(), date.getMonth(), date.getYear()));
    }

    @Test
    public void shouldReturnFalseWhenTheGivenDayIsLaterThanTheMaximumAllowableDayBasedOnTheGivenMonth() {
        // given
        Date date = new Date(31, 4, 2010);

        // when
        // then
        assertFalse(DateValidator.isValidDay(date.getDay(), date.getMonth(), date.getYear()));
    }

    @Test
    public void shouldReturnTrueWhenTheGivenDayIsWithinTheAllowableDayBasedOnTheGivenMonth() {
        // given
        Date date = new Date(30, 4, 2010);

        // when
        // then
        assertTrue(DateValidator.isValidDay(date.getDay(), date.getMonth(), date.getYear()));
    }

    @Test
    public void shouldReturnFalseWhenTheGivenDayIsLaterThanTheMaximumAllowableDayForFebruaryInNonLeapYear() {
        // given
        Date date = new Date(29, 2, 2009);

        // when
        // then
        assertFalse(DateValidator.isValidDay(date.getDay(), date.getMonth(), date.getYear()));
    }

    @Test
    public void shouldReturnTrueWhenTheGivenDayIsNoLaterThanTheMaximumAllowableDayForFebruaryInLeapYear() {
        // given
        Date date = new Date(29, 2, 2000);

        // when
        // then
        assertTrue(DateValidator.isValidDay(date.getDay(), date.getMonth(), date.getYear()));
    }

}
