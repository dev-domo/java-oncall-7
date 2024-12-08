package oncall.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayOfWeekMod {
    private final Map<DayOfWeek, Integer> dayOfWeeks;

    public DayOfWeekMod(String startDayOfWeek) {
        this.dayOfWeeks = createDayMode(startDayOfWeek);
    }

    private Map<DayOfWeek, Integer> createDayMode(String startDayOfWeek) {
        Map<DayOfWeek, Integer> dayOfWeeks = new HashMap<>();
        List<Integer> mods = new java.util.ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        Collections.rotate(mods, (DayOfWeek.valueOf(startDayOfWeek).getRotateTime()));

        int index = 0;
        for(DayOfWeek dayOfWeek : DayOfWeek.values()){
            dayOfWeeks.put(dayOfWeek, mods.get(index++));
        }

        return dayOfWeeks;
    }

    public DayOfWeek calculateModValues(int mod){
        for (Map.Entry<DayOfWeek, Integer> dayOfWeekMod3 : dayOfWeeks.entrySet()) {
            if (mod == dayOfWeekMod3.getValue()) {
                return dayOfWeekMod3.getKey();
            }
        }

        throw new IllegalArgumentException("[ERROR] 모드에 맞는 값이 없음");
    }

    public boolean isHoliday(int month, DayOfWeekMod dayOfWeekMod, int day, int mod) {
        DayOfWeek dayOfWeek = dayOfWeekMod.calculateModValues(mod);
        if(dayOfWeek.equals(DayOfWeek.토) || dayOfWeek.equals(DayOfWeek.일) || MonthInformation.isHoliday(month, day)){
            return true;
        }
        return false;
    }

    public Map<DayOfWeek, Integer> getDayOfWeeks() {
        return dayOfWeeks;
    }
}
