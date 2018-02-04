package epocha.mapper;

import epocha.Date;
import epocha.response.DateResponse;

public class DateMapper
{
    public static Date mapStringDateToDate(String dateString) {
        Date date = new Date();
        String[] splitDate = dateString.trim().split(" ");

        date.setDay(Integer.parseInt(splitDate[0]));
        date.setMonth(Integer.parseInt(splitDate[1]));
        date.setYear(Integer.parseInt(splitDate[2]));

        return date;
    }

    public static DateResponse mapDatesToDateResponse(Date firstDate, Date secondDate, int differencesInDays) {
        DateResponse dateResponse = new DateResponse();

        dateResponse.setFirstDate(firstDate.toString());
        dateResponse.setSecondDate(secondDate.toString());
        if (differencesInDays > -1) {
            dateResponse.setDifferencesInDays(Integer.toString(differencesInDays));
        } else {
            dateResponse.setDifferencesInDays("Invalid date(s) supplied!");
        }

        return dateResponse;
    }
}
