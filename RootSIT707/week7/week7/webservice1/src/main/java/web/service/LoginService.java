package web.service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

public class LoginService {

    private static class User {
        String password;
        String dob;

        User(String password, String dob) {
            this.password = password;
            this.dob = dob;
        }
    }

    // In-memory user store
    private static final Map<String, User> userStore = new HashMap<>();

    static {
        // Add test users
        userStore.put("nikhil", new User("nikhil_pass", "1998-11-19"));
        userStore.put("test", new User("test_pass", "2000-12-31"));
    }

    public static boolean login(String username, String password, String dob) {
        // Null checks
        if (username == null || password == null || dob == null) {
            return false; // If any field is null, return false
        }

        // Validate the DoB format
        try {
            LocalDate parsedDob = LocalDate.parse(dob); // Ensure it's a valid date
            if (parsedDob.isAfter(LocalDate.now())) {
                return false; // Date is in the future
            }
        } catch (DateTimeParseException e) {
            return false; // Invalid date format
        }

        // Retrieve the user from the in-memory store
        User user = userStore.get(username);
        if (user == null) {
            return false; // Username not found
        }

        // Validate the password and dob
        return user.password.equals(password) && user.dob.equals(dob);
    }
}