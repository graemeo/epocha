package epocha;

import epocha.types.MonthType;

public class Date
{
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getYearInNumberOfDays() {
        int numberOfLeapYears = year / 4;
        int numberOfNonLeapYears = year - numberOfLeapYears;
        
        return (numberOfLeapYears * 366) + (numberOfNonLeapYears * 365);
    }

    public int getMonthInNumberOfDays() {
        int numberOfDays = 0;
        boolean isLeapYear = year % 4 == 0;

        for (int i = month; i > 0; i--) {
            if (isLeapYear && MonthType.FEBRUARY.getMonth() == i) {
                numberOfDays += 29;
                continue;
            }
            numberOfDays += MonthType.getMonthInDays(i);
        }

        return numberOfDays;
    }

    public int getTotalNumberOfDaysForDate() {
        return day + getMonthInNumberOfDays() + getYearInNumberOfDays();
    }
}
