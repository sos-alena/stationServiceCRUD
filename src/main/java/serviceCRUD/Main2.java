package serviceCRUD;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main2 {

    private static final String INSERT_NEW = "INSERT INTO cars VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM cars";

    public static void main(String[] args) {



        DBWorker worker = new DBWorker();

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = worker.getConnection().prepareStatement(INSERT_NEW);
            preparedStatement.setInt(1, 7);
            preparedStatement.setString(2,"Audi");
            preparedStatement.setString(3, "AT12354");
            preparedStatement.setString(4, "AS545645645AS");
            preparedStatement.setInt(5, 1923);
            preparedStatement.setInt(6, 20000);
            preparedStatement.setString(7, "Ivanov");
            preparedStatement.setString(8, "fffffffff");
            preparedStatement.setInt(9, 4);

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
