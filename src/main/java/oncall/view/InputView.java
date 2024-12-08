package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String answer() {
        return Console.readLine();
    }

    public void closeAnswer() {
        Console.close();
    }
}
