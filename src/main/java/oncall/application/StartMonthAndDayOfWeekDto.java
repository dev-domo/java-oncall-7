package oncall.application;

public class StartMonthAndDayOfWeekDto {
    private final int Month;
    private final String DayOfWeek;

    public StartMonthAndDayOfWeekDto(int month, String dayOfWeek) {
        Month = month;
        DayOfWeek = dayOfWeek;
    }

    public int getMonth() {
        return Month;
    }

    public String getDayOfWeek() {
        return DayOfWeek;
    }
}
