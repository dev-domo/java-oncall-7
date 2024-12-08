package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.application.EmergencyWorkersDto;
import oncall.application.StartMonthAndDayOfWeekDto;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private InputView() {
    }

    public static StartMonthAndDayOfWeekDto readStartMonthAndDayOfWeek() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        List<String> input = Arrays.stream(Console.readLine().split(",")).toList();

        return new StartMonthAndDayOfWeekDto(Integer.parseInt(input.getFirst()), input.getLast());
    }

    public static EmergencyWorkersDto readEmergencyWorkers() {
        String format = " 비상 근무 순번대로 사원 닉네임을 입력하세요> ";
        System.out.print("평일" + format);
        List<String> weekdaysWorkers = Arrays.stream(Console.readLine().split(",")).toList();
        System.out.print("휴일" + format);
        List<String> weekendWorkers = Arrays.stream(Console.readLine().split(",")).toList();

        return new EmergencyWorkersDto(weekdaysWorkers, weekendWorkers);
    }
}
