package serviceCRUD.validator;

import lombok.extern.slf4j.Slf4j;
import serviceCRUD.enams.Action;
import serviceCRUD.enams.ColumnName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static serviceCRUD.enams.Action.*;
import static serviceCRUD.enams.ColumnName.*;


@Slf4j
public class InputValue {
    static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static int inputValidateInt() {
        try {
            int number = Integer.parseInt(READER.readLine());
            if (number > 0) {
                return number;
            }
            log.info("Incorrect value: " + number);
            System.out.println("Enter value again: ");
            throw new Exception();

        } catch (Exception exception) {
            log.info("Incorrect value: " + exception.getMessage());
            System.out.println("Enter value again: ");
            return inputValidateInt();
        }
    }


    public static String inputValidateStr() {
        try {
            String str = READER.readLine().trim();
            while (str.isEmpty()) {
                log.info("Empty.");
                System.out.println("Enter value again: ");
                str = READER.readLine();
            }
            return str;

        } catch (IOException e) {
            log.info("Error! " + e);
            return inputValidateStr();
        }
    }

    public static ColumnName inputItem() {
        try {
            System.out.println("Input the item from the list: " +
                    MODEL + ", " +
                    NUMBER + ", " +
                    VIN + ", " +
                    MILEAGE + ", " +
                    YEAR + ", " +
                    CUSTOMER + ", " +
                    BREAKING + ", " +
                    SERVICE + " ");
            ColumnName item = ColumnName.valueOf(READER.readLine());
            System.out.println("Item is valid");
            return item;
        } catch (Exception exception) {
            log.info("Incorrect value type. ");
            System.out.println("Enter value again: ");
            return inputItem();
        }
    }
    public static Action inputAction() {
        try {
            System.out.println("Input the item from the list: " +
                    PRINT + ", " +
                    REMOVE + ", " +
                    INSERT + ", " +
                    UPDATE + ", ");
            Action item = Action.valueOf(READER.readLine());
            System.out.println("Item is valid");
            return item;
        } catch (Exception exception) {
            log.info("Incorrect value type. ");
            System.out.println("Enter value again: ");
            return inputAction();
        }
    }

    public static int inputYear() {
        try {
            int number = Integer.parseInt(READER.readLine());
            if (number > 2000 && number < 2023) {
                return number;
            }
            log.info("Incorrect value: " + number);
            System.out.println("Enter value again: ");
            throw new Exception();

        } catch (Exception exception) {
            log.info("Incorrect value: " + exception.getMessage());
            System.out.println("Enter value again: ");
            return inputValidateInt();
        }
    }
}


