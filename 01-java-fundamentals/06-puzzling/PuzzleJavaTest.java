import java.util.ArrayList;
import java.util.Random;
public class PuzzleJavaTest {
    public static void main(String[] args) {
        PuzzleJava generator = new PuzzleJava();
        ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println(randomRolls);

        char randomLetter = generator.getRandomLetter();
        System.out.println(randomLetter);

        String password = generator.generatePassword();
        System.out.println(password);

        ArrayList<String> passwordSet = generator.getNewPasswordSet(6);
        System.out.println(passwordSet);
    }
}