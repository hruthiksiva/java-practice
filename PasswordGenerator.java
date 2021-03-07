import java.util.Random;
import java.util.Scanner;

class PasswordGenerator{
    public static void main(String[] args) {
        System.out.println("Enter the Number of characters you want in the password");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(passwordGenerator(i));
        scanner.close();
    }
    private static char[] passwordGenerator(int length) {
        Random random = new Random();
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        char[] password = new char[length];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        for(int i = 4; i< length ; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
         }

        return password;
        
    }
}