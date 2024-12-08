package oncall.domain;

import java.util.Objects;
import oncall.constants.ExceptionMessage;

public class Worker {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Worker(final String name) {
        checkLength(name);
        this.name = name;
    }

    private void checkLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Worker worker)) {
            return false;
        }
        return Objects.equals(name, worker.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
