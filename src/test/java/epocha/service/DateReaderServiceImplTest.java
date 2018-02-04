package epocha.service;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import epocha.Date;

public class DateReaderServiceImplTest
{
    @Test(expected = FileNotFoundException.class)
    public void shouldThrowExceptionWhenGivenFileIsNotFound() throws IOException {
        // given
        DateReaderService dateReaderService = new DateReaderServiceImpl();

        // when
        dateReaderService.getDates("src/test/resources/doesnotexist.txt");

        // then
    }

    @Test
    public void shouldReturnAnEmptyListWhenNoDataInFile() throws IOException {
        // given
        DateReaderService dateReaderService = new DateReaderServiceImpl();
        
        // when
        List<List<Date>> actual = dateReaderService.getDates("src/test/resources/empty.txt");

        // then
        assertTrue(actual.isEmpty());
    }

    @Test
    public void shouldReturnAListOfDatesWhenInputFileContainsData() throws IOException {
        // given
        DateReaderService dateReaderService = new DateReaderServiceImpl();
        
        // when
        List<List<Date>> actual = dateReaderService.getDates("src/test/resources/dates.txt");

        // then
        assertTrue(actual.size() == 3);
        assertTrue(actual.get(0).size() == 2);
    }
}
