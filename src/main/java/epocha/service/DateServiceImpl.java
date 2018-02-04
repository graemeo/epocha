package epocha.service;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import epocha.Date;
import epocha.response.DateResponse;
import epocha.validator.DateValidator;
import epocha.mapper.DateMapper;

@Component
public class DateServiceImpl implements DateService
{
    private static final String FILENAME = "src/main/resources/dates.txt";

    @Autowired
    private DateReaderService dateReaderService;

    public List<DateResponse> calculateDifferencesBetweenTwoDates() throws IOException {
        List<List<Date>> listOfDates = dateReaderService.getDates(FILENAME);
        List<DateResponse> listOfDateResponse = new ArrayList<DateResponse>();

        for(List<Date> pairOfDates : listOfDates) {
            int differencesInDays = -1;
            Date firstDate = pairOfDates.get(0);
            Date secondDate = pairOfDates.get(1);

            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(firstDate.toString()).append(", ").append(secondDate.toString());

            if(isValidDate(firstDate, secondDate)) {
                differencesInDays = secondDate.getTotalNumberOfDaysForDate() - firstDate.getTotalNumberOfDaysForDate();
            } 
            
            listOfDateResponse.add(DateMapper.mapDatesToDateResponse(firstDate, secondDate, differencesInDays));

            stringBuffer.append(differencesInDays);
            System.out.println(stringBuffer.toString());
        }
        return listOfDateResponse;
    }

    public boolean isValidDate(Date firstDate, Date secondDate) {
        return DateValidator.isFirstDateEarlierThanSecondDate(firstDate.getTotalNumberOfDaysForDate(), secondDate.getTotalNumberOfDaysForDate()) 
                 && DateValidator.isValidDate(firstDate.getDay(), firstDate.getMonth(), firstDate.getYear()) 
                 && DateValidator.isValidDate(secondDate.getDay(), secondDate.getMonth(), secondDate.getYear());
    }
}
