package epocha.mapper;

import static org.junit.Assert.*;

import org.junit.Test;

import epocha.Date;
import epocha.response.DateResponse;

public class DateMapperTest
{
    @Test
    public void shouldMapFromDateStringToDateObject() {
        // given
        String dateString = "01 02 2000";

        // when
        Date date = DateMapper.mapStringDateToDate(dateString);

        // then
        assertEquals(date.getDay(), 1);
        assertEquals(date.getMonth(), 2);
        assertEquals(date.getYear(), 2000);
    }

    @Test
    public void shouldMapDatesToDateResponse() {
        // given
        Date firstDate = new Date();;
        Date secondDate = new Date();
        int differencesInDays = 1;

        firstDate.setDay(1);
        firstDate.setMonth(1);
        firstDate.setYear(2000);

        secondDate.setDay(2);
        secondDate.setMonth(1);
        secondDate.setYear(2000);

        // when
        DateResponse actual = DateMapper.mapDatesToDateResponse(firstDate, secondDate, differencesInDays);

        // then
        assertEquals(actual.getFirstDate(), "1 1 2000");
        assertEquals(actual.getSecondDate(), "2 1 2000");
        assertEquals(actual.getDifferencesInDays(), "1");
    }
}
