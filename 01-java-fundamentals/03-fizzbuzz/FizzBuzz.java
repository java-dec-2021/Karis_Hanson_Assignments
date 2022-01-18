public class FizzBuzz {
    // public String fizzBuzz(int number){
    //     String answer = "";
        
    //     if (number%3 == 0 & number%5 ==0) {
    //         answer = String.format("%d, FizzBuzz", number);
            
    //     }else if (number%3 ==0) {
    //         answer = String.format("%d, Fizz", number);

    //     }else if (number%5 ==0){
    //         answer = String.format("%d, Buzz", number);
    //     } else{
    //         answer = String.format("%d", number);
    //     }
    //     return answer;
    //}
    public String fizzBuzz(int num){
        if (num % 3 ==0 && num % 5 == 0){
            return "FizzBuzz";
        }
        if (num % 3 ==0){
            return "Fizz";
        }
        if (num % 5 == 0){
            return "Buzz";
        }
        return String.valueOf(num);
    }
}