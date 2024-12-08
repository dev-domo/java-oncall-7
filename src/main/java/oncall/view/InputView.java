package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String answer() {
        String input = Console.readLine();
        Console.close();
        return input;
    }
}
