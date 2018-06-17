package com.germes.web.validators;

import com.germes.exceptions.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthValidator.class);

    public static boolean isValid(String login, String password) throws DataException {
        if (!isValidLogin(login)) {
            throw new DataException("Login is incorrect");
        } else if (!isValidPassword(password)) {
            throw new DataException("Password is incorrect");
        } else {
            return true;
        }
    }

    public static boolean isValidLogin(String word) throws DataException {
        return validTextField(word, "[A-Za-z]+[A-Za-z0-9]", 56);
    }

    public static boolean isValidPassword(String word) throws DataException {
        return validTextField(word, "", 56);
    }

    private static boolean validTextField(String word, String pattern, int length) throws DataException {
        try {
            if (!Objects.equals(word, "") && !Objects.isNull(word) && word.length() < length) {
                Pattern pattern1 = Pattern.compile(pattern);
                Matcher matcher = pattern1.matcher(word);
                matcher.find();
                String found = matcher.group();
                if (!Objects.equals(found, "") && !Objects.isNull(found) && Objects.equals(found, word)) {
                    return true;
                }
            }
        } catch (Exception e) {
            LOGGER.error("DataValidator.Text (EnterDataValidator.validTextField()) exception : Text Data is incorrect, error!");
            throw new DataException("Text data is illegal");
        }
        return false;
    }
}
