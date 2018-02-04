package epocha.service;

import java.util.List;
import java.io.IOException;

import epocha.Date;
import epocha.validator.DateValidator;

public class DateServiceImpl implements DateService
{
    public void calculateDifferencesBetweenTwoDates() throws IOException {
        DateReaderService dateReaderService = new DateReaderServiceImpl();
        List<String> listOfDates = dateReaderService.getDatesFromInputFile("src/main/resources/dates.txt");

        for(String dates : listOfDates) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(dates + ", ");

            String[] splitFirstDate = dates.split(",")[0].trim().split(" ");
            String[] splitSecondDate = dates.split(",")[1].trim().split(" ");
            
            Date firstDate = new Date(Integer.parseInt(splitFirstDate[0]), Integer.parseInt(splitFirstDate[1]), Integer.parseInt(splitFirstDate[2])); 
            Date secondDate = new Date(Integer.parseInt(splitSecondDate[0]), Integer.parseInt(splitSecondDate[1]), Integer.parseInt(splitSecondDate[2])); 

            if(isValidDate(firstDate, secondDate)) {
                stringBuffer.append(secondDate.getTotalNumberOfDaysForDate() - firstDate.getTotalNumberOfDaysForDate());
            } else {
                stringBuffer.append("invalid date(s)!");
            }
            
            System.out.println(stringBuffer.toString());
        }
    }

    public boolean isValidDate(Date firstDate, Date secondDate) {
        return DateValidator.isFirstDateEarlierThanSecondDate(firstDate.getTotalNumberOfDaysForDate(), secondDate.getTotalNumberOfDaysForDate()) 
                 && DateValidator.isValidDate(firstDate.getDay(), firstDate.getMonth(), firstDate.getYear()) 
                 && DateValidator.isValidDate(secondDate.getDay(), secondDate.getMonth(), secondDate.getYear());
    }
}
