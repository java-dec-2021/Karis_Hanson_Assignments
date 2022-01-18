public class FizzBuzzTest {
    public static void main(String[] args) {
        FizzBuzz tester = new FizzBuzz();

        System.out.println(tester.fizzBuzz(9)); //Fizz
        System.out.println(tester.fizzBuzz(10)); //Buzz
        System.out.println(tester.fizzBuzz(15)); //FizzBuzz
        System.out.println(tester.fizzBuzz(16)); //16
        System.out.println(tester.fizzBuzz(2)); //2
    }
}