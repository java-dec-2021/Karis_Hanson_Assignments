public class BasicJavaTest {
    public static void main(String[] args) {
        BasicJava tester = new BasicJava();

        // tester.printNums();
        // System.out.println(tester.printSum()); //32640
        // tester.printArray();
        // int[] array = {3,5,8,20,9,4};
        // tester.maxValue(array);
        //System.out.println(tester.oddArray());
        // int[] array = {2,10,3,8,20};
        // tester.getAvg(array);
        // int[] array = {1,3,5,7,9,2};
        // tester.greaterY(array, 3);
        int[] array = {1,5,10,-2};
        // tester.squareArray(array);
        tester.elimNeg(array);
    }
}