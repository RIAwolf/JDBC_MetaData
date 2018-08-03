package lt.kaunascoding.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import lt.kaunascoding.model.DBSingleton;

public class Controller {
    public Button button1;
    public TextArea isvedimoLaukas;

    public void handleButton1(ActionEvent actionEvent) {

        String uzklausa = "SELECT * FROM `Students` ORDER BY `name` ASC;";
        String atsakymas = DBSingleton.getInstance().printQueryResult(uzklausa);
        isvedimoLaukas.appendText(atsakymas + "\n");
    }
}
