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
}
