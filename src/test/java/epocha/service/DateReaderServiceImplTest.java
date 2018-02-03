package epocha.service;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class DateReaderServiceImplTest
{
    @Test(expected = FileNotFoundException.class)
    public void shouldThrowExceptionWhenGivenFileIsNotFound() throws IOException {
        // given
        DateReaderService dateReaderService = new DateReaderServiceImpl();

        // when
        dateReaderService.getDatesFromInputFile("src/test/resources/doesnotexist.txt");

        // then
    }

    @Test
    public void shouldReturnAnEmptyListWhenNoDataInFile() throws IOException {
        // given
        DateReaderService dateReaderService = new DateReaderServiceImpl();
        
        // when
        List<String> actual = dateReaderService.getDatesFromInputFile("src/test/resources/empty.txt");

        // then
        assertTrue(actual.isEmpty());
    }

    @Test
    public void shouldReturnAListOfDatesWhenInputFileContainsData() throws IOException {
        // given
        DateReaderService dateReaderService = new DateReaderServiceImpl();
        
        // when
        List<String> actual = dateReaderService.getDatesFromInputFile("src/test/resources/dates.txt");

        // then
        assertTrue(actual.size() == 3);
    }
}
