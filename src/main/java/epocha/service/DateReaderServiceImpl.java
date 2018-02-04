package epocha.service;

import java.util.List;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class DateReaderServiceImpl implements DateReaderService
{
    public List<String> getDatesFromInputFile(String path) throws IOException {
        List<String> listOfDates = new ArrayList<String>();       
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)));
        String line = "";

        while ((line = bufferedReader.readLine()) != null) {
            listOfDates.add(line);
        }

        return listOfDates;
    }
}
