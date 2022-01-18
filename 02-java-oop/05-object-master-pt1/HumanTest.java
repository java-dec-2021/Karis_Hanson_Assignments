public class HumanTest {
    public static void main(String[] args) {
        Human firstHuman = new Human();
        Human secondHuman = new Human();
        firstHuman.getHealth();
        firstHuman.setStrength(10);
        secondHuman.getHealth();

        firstHuman.attack(secondHuman);
        firstHuman.getHealth();
        secondHuman.getHealth();
    }
}