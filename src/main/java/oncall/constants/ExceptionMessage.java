package oncall.constants;

public enum ExceptionMessage {
    EXAMPLE("");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
