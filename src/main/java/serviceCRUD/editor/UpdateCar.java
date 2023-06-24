package serviceCRUD.editor;

import serviceCRUD.DBWorker;
import serviceCRUD.validator.InputValue;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static serviceCRUD.validator.InputValue.inputItem;
import static serviceCRUD.validator.InputValue.inputValidateStr;

public class UpdateCar {

    private static final String UPDATE_MODEL = "UPDATE cars SET car_model = ? WHERE id = ?";
    private static final String UPDATE_NUMBER = "UPDATE cars SET car_number = ? WHERE id = ?";
    private static final String UPDATE_VIN = "UPDATE cars SET vin = ? WHERE id = ?";
    private static final String UPDATE_YEAR = "UPDATE cars SET production_year = ? WHERE id = ?";
    private static final String UPDATE_MILEAGE = "UPDATE cars SET car_mileage = ? WHERE id = ?";
    private static final String UPDATE_CUSTOMER = "UPDATE cars SET customer = ? WHERE id = ?";
    private static final String UPDATE_BREAKING = "UPDATE cars SET breaking = ? WHERE id = ?";
    private static final String UPDATE_SERVICE = "UPDATE cars SET services_id = ? WHERE id = ?";

    PreparedStatement preparedStatement;

    public void getPreparedStatement(DBWorker worker, int id) throws SQLException {
        String item = String.valueOf(inputItem());
        switch (item) {
            case ("MODEL") -> {
                preparedStatement = worker.getConnection().prepareStatement(UPDATE_MODEL);
                runQueryStr(id);
            }
            case ("NUMBER") -> {
                preparedStatement = worker.getConnection().prepareStatement(UPDATE_NUMBER);
                runQueryStr(id);
            }
            case ("VIN") -> {
                preparedStatement = worker.getConnection().prepareStatement(UPDATE_VIN);
                runQueryStr(id);
            }
            case ("MILEAGE") -> {
                preparedStatement = worker.getConnection().prepareStatement(UPDATE_MILEAGE);
                runQueryInt(id);
            }
            case ("CUSTOMER") -> {
                preparedStatement = worker.getConnection().prepareStatement(UPDATE_CUSTOMER);
                runQueryStr(id);
            }
            case ("BREAKING") -> {
                preparedStatement = worker.getConnection().prepareStatement(UPDATE_BREAKING);
                runQueryStr(id);
            }
            case ("SERVICE") -> {
                preparedStatement = worker.getConnection().prepareStatement(UPDATE_SERVICE);
                runQueryInt(id);
            }
            case ("YEAR") -> {
                preparedStatement = worker.getConnection().prepareStatement(UPDATE_YEAR);
                runQueryInt(id);
            }
        }
    }
    private void runQueryInt(int id) throws SQLException {
        System.out.println("Input date which you want update");
        int date = InputValue.inputValidateInt();
        getResult(id, String.valueOf(date));
    }

    private void runQueryStr(int id) throws SQLException {
        System.out.println("Input date which you want update");
        String date = inputValidateStr();
        getResult(id, date);
    }

    private void getResult(int id, String date) throws SQLException {
        preparedStatement.setString(1, date);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
    }
}
