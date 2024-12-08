package oncall.domain;

import java.util.List;

public enum MonthInformation {
    JAN(1, 31, List.of(1)),
    FRE(2, 28, List.of()),
    MARCH(3, 31, List.of()),
    APRIL(4, 30, List.of()),
    MAY(5, 31, List.of(5)),
    JUNE(6, 30, List.of(6)),
    JULY(7, 31, List.of()),
    AUGUST(8, 31, List.of(15)),
    SEPTEMBER(9, 30, List.of()),
    OCTOBER(10, 31, List.of(3, 9)),
    NOVEMBER(11, 3, List.of()),
    DECEMBER(12, 31, List.of(25));

    private final int monthNumber;
    private final int endDate;

    private final List<Integer> holidays;

    MonthInformation(int monthNumber, int endDate, List<Integer> holidays) {
        this.monthNumber = monthNumber;
        this.endDate = endDate;
        this.holidays = holidays;
    }

    public static int calculateEndDay(int monthNumber) {
        for (MonthInformation monthInformation : MonthInformation.values()) {
            if (monthInformation.monthNumber == monthNumber) {
                return monthInformation.endDate;
            }
        }
        throw new IllegalArgumentException("[ERROR] 달 숫자 잘 입력하세요");
    }

    public static boolean isHoliday(int month, int day) {
        for (MonthInformation monthInformation : MonthInformation.values()) {
            if (isSameMonth(month, day, monthInformation)) return true;
        }
        return false;
    }

    private static boolean isSameMonth(int month, int day, MonthInformation monthInformation) {
        if (monthInformation.monthNumber == month && isHolidayDate(day, monthInformation)) {
            return true;
        }

        return false;
    }

    private static boolean isHolidayDate(int day, MonthInformation monthInformation) {
        for (int holiday : monthInformation.holidays) {
            if (holiday == day) {
                return true;
            }
        }
        return false;
    }
}
