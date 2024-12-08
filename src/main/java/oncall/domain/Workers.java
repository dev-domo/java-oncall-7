package oncall.domain;

import java.util.List;
import oncall.constants.ExceptionMessage;

public abstract class Workers {
    private static final int MINIMUM_WORKERS_SIZE = 5;
    private static final int MAXIMUM_WORKERS_SIZE = 35;

    private final List<Worker> workers;

    public Workers(List<Worker> workers) {
        checkNumberOfWorkers(workers);
        this.workers = workers;
    }

    private void checkNumberOfWorkers(List<Worker> workers) {
        if (workers.size() < MINIMUM_WORKERS_SIZE || workers.size() > MAXIMUM_WORKERS_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }
}
