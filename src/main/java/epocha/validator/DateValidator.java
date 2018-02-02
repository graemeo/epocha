package epocha.validator;

public class DateValidator
{
    private static final int MAX_ALLOWABLE_YEAR = 2011;
    private static final int MIN_ALLOWABLE_YEAR = 1899;

    public static boolean isValidYear(int year) {
        return year > MIN_ALLOWABLE_YEAR  && year < MAX_ALLOWABLE_YEAR;
    }
}
