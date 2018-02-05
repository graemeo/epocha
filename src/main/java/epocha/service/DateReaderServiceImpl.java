package epocha.service;

import java.util.List;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;

import epocha.Date;
import epocha.mapper.DateMapper;

@Component
public class DateReaderServiceImpl implements DateReaderService
{
    public List<List<Date>> getDates(String path) throws IOException {
        List<List<Date>> listOfDates = new ArrayList<List<Date>>();       
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)));
        String line = "";

        while ((line = bufferedReader.readLine()) != null) {
            List<Date> pairOfDates = new ArrayList<Date>();
            String[] splitDates = line.split(",");

            pairOfDates.add(DateMapper.mapStringDateToDate(splitDates[0]));
            pairOfDates.add(DateMapper.mapStringDateToDate(splitDates[1]));

            listOfDates.add(pairOfDates);
        }

        return listOfDates;
    } 
}
