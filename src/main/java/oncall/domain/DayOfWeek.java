package oncall.domain;

public enum DayOfWeek {
    월(0),
    화(1),
    수(2),
    목(3),
    금(4),
    토(5),
    일(6);
    private final int rotateTime;

    DayOfWeek(int rotateTime) {
        this.rotateTime = rotateTime;
    }

    public int getRotateTime() {
        return rotateTime;
    }
}
