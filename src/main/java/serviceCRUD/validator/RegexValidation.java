package serviceCRUD.validator;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static serviceCRUD.validator.InputValue.READER;

@Slf4j
public class RegexValidation {
    static Pattern patternNumber = Pattern.compile("^\\d{1,4}$");
    static Pattern patternYesOrNot = Pattern.compile("[YN]");

    public static String inputYesOrNot(){
        String str;
        try {
            str = READER.readLine();
            if (validateData(str, patternYesOrNot)) {
                System.out.println("Character is valid");
                return str;
            }
            log.info("Character is invalid. Try again");
            return inputYesOrNot();

        } catch (IOException e) {
            log.info("Error! incorrect number");
            return inputYesOrNot();
        }
    }
    public static String inputNumberValue() {
        System.out.println("Input number.");
        String number;
        try {
            number = READER.readLine();
            if (validateData(number, patternNumber)) {
                System.out.println("Number is valid");
                return number;
            }
            log.info("Number is invalid. " +
                    "Check the number.\nTry again");
            return inputNumberValue();

        } catch (IOException | NullPointerException e) {
            log.info("error! incorrect number" + e);
            return inputNumberValue();
        }
    }
    public static boolean validateData(String name, Pattern pattern) {
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}

