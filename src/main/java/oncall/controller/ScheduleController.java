package oncall.controller;

import oncall.application.CalendarDto;
import oncall.application.EmergencyWorkersDto;
import oncall.application.StartMonthAndDayOfWeekDto;
import oncall.service.ScheduleService;

import static oncall.view.InputView.readEmergencyWorkers;
import static oncall.view.InputView.readStartMonthAndDayOfWeek;

public class ScheduleController {
    private final ScheduleService scheduleService = new ScheduleService();

    public CalendarDto createEmergencyDocument(){
        StartMonthAndDayOfWeekDto startMonthAndDayOfWeek = readStartMonthAndDayOfWeek();
        EmergencyWorkersDto emergencyWorkers = readEmergencyWorkers();
        return scheduleService.createEmergencyDocument(startMonthAndDayOfWeek, emergencyWorkers);
    }
}
