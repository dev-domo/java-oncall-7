package oncall;

import oncall.controller.EmergencyWorkController;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Application {
    public static void main(String[] args) {
        EmergencyWorkController controller = new EmergencyWorkController(new InputView(), new OutputView());
        controller.start();
    }
}
