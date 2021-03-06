package epocha.service;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import epocha.Date;
import epocha.response.DateResponse;
import epocha.response.Response;
import epocha.validator.DateValidator;
import epocha.mapper.DateMapper;

@Component
public class DateServiceImpl implements DateService
{
    private static final String FILENAME = "src/main/resources/dates.txt";

    @Autowired
    private DateReaderService dateReaderService;

    public Response calculateDifferencesBetweenTwoDates() throws IOException {
        List<List<Date>> listOfDates = dateReaderService.getDates(FILENAME);
        List<DateResponse> listOfDateResponse = new ArrayList<DateResponse>();
        Response response = new Response();

        for(List<Date> pairOfDates : listOfDates) {
            int differencesInDays = -1;
            Date firstDate = pairOfDates.get(0);
            Date secondDate = pairOfDates.get(1);

            if(DateValidator.validateTwoDates(firstDate, secondDate)) {
                differencesInDays = secondDate.getTotalNumberOfDaysForDate() - firstDate.getTotalNumberOfDaysForDate();
            } 
            
            listOfDateResponse.add(DateMapper.mapDatesToDateResponse(firstDate, secondDate, differencesInDays));
            print(firstDate, secondDate, differencesInDays);
        }

        response.setDates(listOfDateResponse);

        return response;
    }

    private void print(Date firstDate, Date secondDate, int differencesInDays) {
        StringBuffer stringBuffer  = new StringBuffer();
        stringBuffer.append(firstDate.toString());
        stringBuffer.append(", ");
        stringBuffer.append(secondDate.toString());
        stringBuffer.append(", ");
        if (differencesInDays > -1) {
             stringBuffer.append(Integer.toString(differencesInDays));
        } else { 
             stringBuffer.append("Invalid date(s) supplied!");
        }

        System.out.println(stringBuffer.toString());
    }
}
