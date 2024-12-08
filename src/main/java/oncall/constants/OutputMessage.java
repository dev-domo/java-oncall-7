package oncall.constants;

public enum OutputMessage {
    EXAMPLE("");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
