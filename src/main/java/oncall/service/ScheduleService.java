package oncall.service;

import oncall.application.CalendarDto;
import oncall.application.EmergencyWorkersDto;
import oncall.application.StartMonthAndDayOfWeekDto;
import oncall.domain.DayOfWeek;
import oncall.domain.DayOfWeekMod;
import oncall.domain.MonthInformation;

import java.util.List;
import java.util.Map;

public class ScheduleService {
    public CalendarDto createEmergencyDocument(StartMonthAndDayOfWeekDto startMonthAndDayOfWeekDto, EmergencyWorkersDto emergencyWorkersDto) {
        List<String> weekdaysWorkers = emergencyWorkersDto.getWeekdaysWorkers();
        List<String> weekendWorkers = emergencyWorkersDto.getWeekendWorkers();

        int endOfDate = MonthInformation.calculateEndDay(startMonthAndDayOfWeekDto.getMonth());
        DayOfWeekMod dayOfWeekMod = new DayOfWeekMod(startMonthAndDayOfWeekDto.getDayOfWeek());
        for (int day = 1; day <= endOfDate; day++) {
            int mod = day % 7;
//            dayOfWeekMod.isHoliday(startMonthAndDayOfWeekDto.getMonth(), dayOfWeekMod, day, mod);
        }

        return new CalendarDto();
    }
}
