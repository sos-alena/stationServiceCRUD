package serviceCRUD;

import serviceCRUD.editor.editorCar;

import java.sql.SQLException;

import static serviceCRUD.validator.InputValue.inputAction;
import static serviceCRUD.validator.RegexValidation.inputYesOrNot;

public class ControllerCRUD {

    public static void dataBaseWorker() throws SQLException {
        String str;
        do {
            chooseAction();
            System.out.println("Select Y to continue working with Cars or N for to stop");
            str = inputYesOrNot();
        }
        while (!str.equals("N"));
    }

    private static void chooseAction() throws SQLException {
        String action = String.valueOf(inputAction());
        editorCar editorCar = new editorCar();
        DBWorker worker = new DBWorker();
        switch (action) {
            case ("PRINT") -> editorCar.printAllCars(worker);
            case ("REMOVE") -> editorCar.removeCar(worker);
            case ("INSERT") -> editorCar.insertNewCar(worker);
            case ("UPDATE") -> editorCar.updateDateCars(worker);
        }
    }
}
