package oncall.constants;

public enum OutputMessage {
    INPUT_MONTH_AND_DAY("비상 근무를 배정할 월과 시작 요일을 입력하세요> "),
    INPUT_WORKERS_BY_WEEKDAYS_TURN("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
    INPUT_WORKERS_BY_HOLIDAY_TURN("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
