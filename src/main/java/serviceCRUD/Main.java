package serviceCRUD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        DBWorker worker = new DBWorker();
        String query = "select * from cars where id = 4";

        querySelectAll(worker, query);

    }

    private static void querySelectAll(DBWorker worker, String query) {

        try (Statement statement = worker.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(query)){

            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setCar_model(resultSet.getString("car_model"));
                car.setCar_number(resultSet.getString("car_number"));
                car.setVin(resultSet.getString("vin"));
                car.setProduction_year(resultSet.getInt("production_year"));
                car.setCar_mileage(resultSet.getInt("car_mileage"));
                car.setCustomer(resultSet.getString("customer"));
                car.setBreaking(resultSet.getString("breaking"));
                car.setService_id(resultSet.getInt("services_id"));
                System.out.println(car);

            }

        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
    }
}
