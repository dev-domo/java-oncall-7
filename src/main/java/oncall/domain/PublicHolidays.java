package oncall.domain;

import java.time.LocalDate;
import java.util.Arrays;

public enum PublicHolidays {
    NEW_DAY(LocalDate.of(2024, 1, 1)),
    MARCH_FIRST_DAY(LocalDate.of(2024, 3, 1)),
    CHILDREN_DAY(LocalDate.of(2024, 3, 1)),
    MEMORIAL_DAY(LocalDate.of(2024, 3, 1)),
    LIBERATION_DAY(LocalDate.of(2024, 3, 1)),
    NATIONAL_FOUNDATION_DAY(LocalDate.of(2024, 3, 1)),
    HANGUL_DAY(LocalDate.of(2024, 3, 1)),
    CHRISTMAS(LocalDate.of(2024, 3, 1));

    private static final int WEEKDAYS_STANDARD = 6;
    private final LocalDate holiday;

    PublicHolidays(final LocalDate holiday) {
        this.holiday = holiday;
    }

    public static boolean isDayOff(LocalDate date) {
        boolean isPublicHoliday = Arrays.stream(PublicHolidays.values())
                .anyMatch(publicHolidays -> publicHolidays.holiday.equals(date));
        boolean isWeekDay = date.getDayOfWeek().getValue() < WEEKDAYS_STANDARD;

        return isPublicHoliday && isWeekDay;
    }
}
