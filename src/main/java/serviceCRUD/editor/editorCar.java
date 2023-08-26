package serviceCRUD.editor;

import serviceCRUD.DBWorker;
import serviceCRUD.validator.InputValue;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static serviceCRUD.validator.InputValue.inputValidateStr;
import static serviceCRUD.validator.InputValue.inputYear;
import static serviceCRUD.validator.RegexValidation.inputYesOrNot;

public class editorCar {

    private static final String INSERT_NEW = "INSERT INTO cars VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM cars";
    private static final String DELETE = "DELETE FROM cars WHERE id = ?";

    PreparedStatement preparedStatement;


    public void removeCar(DBWorker worker) {
        printAllCars(worker);
        try {
            preparedStatement = worker.getConnection().prepareStatement(DELETE);
            System.out.println("Input number id which you want delete");
            int id = InputValue.inputValidateInt();
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        printAllCars(worker);
    }

    public void printAllCars(DBWorker worker) {
        try {
            preparedStatement = worker.getConnection().prepareStatement(GET_ALL);
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                int id = res.getInt("id");
                String car_model = res.getString("car_model");
                String car_number = res.getString("car_number");
                String vin = res.getString("vin");
                int production_year = res.getInt("production_year");
                int car_mileage = res.getInt("car_mileage");
                String customer = res.getString("customer");
                String breaking = res.getString("breaking");
                int services_id = res.getInt("services_id");

                System.out.println(id + " "
                        + " " + car_model + " "
                        + " " + car_number + " "
                        + " " + vin + " "
                        + " " + production_year + " "
                        + " " + car_mileage + " "
                        + " " + customer + " "
                        + " " + breaking + " "
                        + " " + services_id);
                System.out.println("____________________________________________");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertNewCar(DBWorker worker) {
        try {
            preparedStatement = worker.getConnection().prepareStatement(INSERT_NEW);
            System.out.println("Input data about car: ");

            System.out.println("Input id");
            int id = InputValue.inputValidateInt();
            preparedStatement.setInt(1, id);

            System.out.println("Input car model");
            String model = InputValue.inputValidateStr();
            preparedStatement.setString(2, model);

            System.out.println("Input car number");
            String number = InputValue.inputValidateStr();
            preparedStatement.setString(3, number);

            System.out.println("Input number vin");
            String vin = InputValue.inputValidateStr();
            preparedStatement.setString(4, vin);

            System.out.println("Input production year");
            int year = inputYear();
            preparedStatement.setInt(5, year);

            System.out.println("Input mileage");
            int mileage = InputValue.inputValidateInt();
            preparedStatement.setInt(6, mileage);

            System.out.println("Input name of customer");
            String customer = InputValue.inputValidateStr();
            preparedStatement.setString(7, customer);

            System.out.println("Input breaking");
            String breaking = InputValue.inputValidateStr();
            preparedStatement.setString(8, breaking);

            System.out.println("Input services number");
            int services = InputValue.inputValidateInt();
            preparedStatement.setInt(9, services);

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        printAllCars(worker);
    }

    public void updateDateCars(DBWorker worker) throws SQLException {
        UpdateCar updateCar = new UpdateCar();
        System.out.println("Input number id which you want update");
        int id = InputValue.inputValidateInt();
        String model;
        do {
            updateCar.getPreparedStatement(worker, id);
            System.out.println("Enter the letter Y to continue updating date or N for to stop ");
            model = inputYesOrNot();
        }
        while (!model.equals("N"));
    }
}
