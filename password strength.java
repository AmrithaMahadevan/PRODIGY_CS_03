import java.util.regex.*;

public class PasswordStrengthChecker {

    public static String checkPasswordStrength(String password) {
        // Criteria
        boolean lengthCriteria = password.length() >= 8;
        boolean uppercaseCriteria = Pattern.compile("[A-Z]").matcher(password).find();
        boolean lowercaseCriteria = Pattern.compile("[a-z]").matcher(password).find();
        boolean numberCriteria = Pattern.compile("\\d").matcher(password).find();
        boolean specialCriteria = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(password).find();

        // Strength assessment
        int criteriaMet = 0;
        if (lengthCriteria) criteriaMet++;
        if (uppercaseCriteria) criteriaMet++;
        if (lowercaseCriteria) criteriaMet++;
        if (numberCriteria) criteriaMet++;
        if (specialCriteria) criteriaMet++;

        // Feedback
        StringBuilder feedback = new StringBuilder("Password strength: ");
        switch (criteriaMet) {
            case 5:
                feedback.append("Very Strong");
                break;
            case 4:
                feedback.append("Strong");
                break;
            case 3:
                feedback.append("Moderate");
                break;
            case 2:
                feedback.append("Weak");
                break;
            default:
feedback.append("Very Weak");
                break;
        }

        feedback.append("\nCriteria met: ");
        feedback.append("\n- Length (>= 8 characters): ").append(lengthCriteria ? "Yes" : "No");
        feedback.append("\n- Uppercase Letter: ").append(uppercaseCriteria ? "Yes" : "No");
        feedback.append("\n- Lowercase Letter: ").append(lowercaseCriteria ? "Yes" : "No");
        feedback.append("\n- Number: ").append(numberCriteria ? "Yes" : "No");
        feedback.append("\n- Special Character: ").append(specialCriteria ? "Yes" : "No");

        return feedback.toString();
    }

    public static void main(String[] args) {
        String password = "YourPasswordHere123!";
        String feedback = checkPasswordStrength(password);
        System.out.println(feedback);
    }
}
