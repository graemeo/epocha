package epocha.types;

import java.util.Map;
import java.util.HashMap;

public enum MonthType
{
    JANUARY(1, 31),
    FEBRUARY(2, 28),
    MARCH(3, 31),
    APRIL(4, 30),
    MAY(5, 31),
    JUNE(6, 30),
    JULY(7, 31),
    AUGUST(8, 31),
    SEPTEMBER(9, 30),
    OCTOBER(10, 31),
    NOVEMBER(11, 30),
    DECEMBER(12, 31);

    private int month;
    private int monthInDays;
    private static Map<Integer, MonthType> monthTypes = new HashMap<Integer, MonthType>();

    static {
        for (MonthType monthType : MonthType.values()) {
            monthTypes.put(monthType.getMonth(), monthType);
        }
    }

    MonthType(int month, int monthInDays) {
        this.month = month;
        this.monthInDays = monthInDays;
    }

    public int getMonth() {
        return month;
    }
   
    public int getMonthInDays() {
        return monthInDays;
    }

    public static int getMonthInDays(int month) {
        return monthTypes.get(month).getMonthInDays();
    }
}
