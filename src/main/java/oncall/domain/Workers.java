package oncall.domain;

import java.util.HashSet;
import java.util.List;
import oncall.constants.ExceptionMessage;

public abstract class Workers {
    private static final int MINIMUM_WORKERS_SIZE = 5;
    private static final int MAXIMUM_WORKERS_SIZE = 35;

    protected final List<Worker> workers;

    public Workers(List<Worker> workers) {
        checkNumberOfWorkers(workers);
        checkDuplicateWorker(workers);
        this.workers = workers;
    }

    private void checkNumberOfWorkers(List<Worker> workers) {
        if (workers.size() < MINIMUM_WORKERS_SIZE || workers.size() > MAXIMUM_WORKERS_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }

    private void checkDuplicateWorker(List<Worker> workers) {
        if (new HashSet<>(workers).size() < workers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }

    public void validate(List<Worker> holidayWorkers) {
        if (this.workers.size() != holidayWorkers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }

    public Worker findNextWorker(int index, Worker beforeWorker) {
        Worker nextWorker = workers.get(index);
        if (nextWorker.equals(beforeWorker)) {
            List<Worker> originalWorkers = workers;
            originalWorkers.set(index, originalWorkers.set(index + 1, originalWorkers.get(index)));
        }
        return workers.get(index);
    }
}
