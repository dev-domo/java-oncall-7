package oncall.constants;

public enum KoreanDate {
    MONTH("월 "),
    DAY("일 "),
    DAY_OFF("(휴일) ");

    private final String text;

    KoreanDate(final String text) {
        this.text = text;
    }

    public String getMessage() {
        return text;
    }
}
