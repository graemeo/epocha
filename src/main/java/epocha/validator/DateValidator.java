package epocha.validator;

import epocha.types.MonthType;

public class DateValidator
{
    private static final int MAX_ALLOWABLE_YEAR = 2010;
    private static final int MIN_ALLOWABLE_YEAR = 1900;
    private static final int MAX_ALLOWABLE_MONTH = 12;
    private static final int MIN_ALLOWABLE_MONTH = 1;
    private static final int MIN_ALLOWABLE_DAY = 1;
    private static final int NUMBER_OF_DAYS_IN_FEBRUARY_WITH_LEAP_YEAR = 29;

    public static boolean isValidYear(int year) {
        return year >= MIN_ALLOWABLE_YEAR  && year <= MAX_ALLOWABLE_YEAR;
    }

    public static boolean isValidMonth(int month) {
        return month >= MIN_ALLOWABLE_MONTH && month <= MAX_ALLOWABLE_MONTH;
    }

    public static boolean isValidDay(int day, int month, int year) {
        boolean isLeapYear = year % 4 == 0;

        return day >= MIN_ALLOWABLE_DAY 
                  && day <= (isLeapYear && MonthType.FEBRUARY.getMonth() == month 
                      ? NUMBER_OF_DAYS_IN_FEBRUARY_WITH_LEAP_YEAR : MonthType.getMonthInDays(month));
    }

    public static boolean isFirstDateEarlierThanSecondDate(int firstDateTotalNumberOfDays, int secondDateTotalNumberOfDays) {
        return firstDateTotalNumberOfDays <= secondDateTotalNumberOfDays;
    }

    public static boolean isValidDate(int day, int month, int year) {
        return isValidYear(year) && isValidMonth(month) && isValidDay(day, month, year);
    }
}
