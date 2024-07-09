import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        scanner.close();

        checkPasswordStrength(password);
    }

    public static void checkPasswordStrength(String password) {
        boolean lengthCriteria = password.length() >= 8;
        boolean uppercaseCriteria = Pattern.compile("[A-Z]").matcher(password).find();
        boolean lowercaseCriteria = Pattern.compile("[a-z]").matcher(password).find();
        boolean numberCriteria = Pattern.compile("[0-9]").matcher(password).find();
        boolean specialCharCriteria = Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();

        int strengthPoints = 0;
        if (lengthCriteria) strengthPoints++;
        if (uppercaseCriteria) strengthPoints++;
        if (lowercaseCriteria) strengthPoints++;
        if (numberCriteria) strengthPoints++;
        if (specialCharCriteria) strengthPoints++;

        StringBuilder feedback = new StringBuilder();
        feedback.append("Password strength analysis:\n");
        feedback.append("Length (>= 8): ").append(lengthCriteria ? "✔" : "✘").append("\n");
        feedback.append("Uppercase letter: ").append(uppercaseCriteria ? "✔" : "✘").append("\n");
        feedback.append("Lowercase letter: ").append(lowercaseCriteria ? "✔" : "✘").append("\n");
        feedback.append("Number: ").append(numberCriteria ? "✔" : "✘").append("\n");
        feedback.append("Special character: ").append(specialCharCriteria ? "✔" : "✘").append("\n");

        String strengthMessage;
        switch (strengthPoints) {
            case 5:
                strengthMessage = "Password strength: ★★★★★ (Very Strong)";
                break;
            case 4:
                strengthMessage = "Password strength: ★★★★☆ (Strong)";
                break;
            case 3:
                strengthMessage = "Password strength: ★★★☆☆ (Moderate)";
                break;
            case 2:
                strengthMessage = "Password strength: ★★☆☆☆ (Weak)";
                break;
            default:
                strengthMessage = "Password strength: ★☆☆☆☆ (Very Weak)";
                break;
        }

        feedback.append(strengthMessage);

        System.out.println(feedback.toString());
    }
}
