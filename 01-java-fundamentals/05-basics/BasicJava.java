import java.util.ArrayList;
import java.util.Arrays;

class BasicJava {
    public void printNums() {
        for (int i=1; i<256; i++){
            System.out.println(i);
        }
    }
    public int printSum() {
        int sum =0;
        for (int i=1; i<256; i++){
            sum = sum +i;
        }
        return sum;
    }
    public void printArray(){
        int[] myArray = {1,3,5,7,9,13};
        for (int i =0; i < myArray.length; i++){
            System.out.println(myArray[i]);
        } 
        System.out.println(Arrays.toString(myArray)); //another way to print array
    }
    public void maxValue(int[] array){
        int max = array[0];
        for (int i =0; i<array.length; i++){
            if(array[i]>max){
                max = array[i];
            }
        }
        System.out.println("max is " + max);
    }
    public ArrayList<Integer> oddArray(){
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        for (int i=1; i<256; i+=2){
            myArray.add(i);
        }
        return myArray;

    }
    public void getAvg(int[] array){
        double average = 0;
        double sum =0;
        for (int i =0; i < array.length; i++){
            sum = sum + array[i];
        } 
        average = sum/array.length;
        System.out.println("average is " + average);
    }

    public void greaterY(int[] array, int y){
        int greater =0;
        for (int i=0; i < array.length; i++){
            if (array[i] > y) {
                greater = greater +1;
            }
        }
        System.out.println("values greater than y: " + greater);
    }

    public void squareArray(int[] array){
        for (int i=0; i < array.length; i++){
            array[i] = array[i]*array[i];
        }
        System.out.println(Arrays.toString(array));
    }

    public void elimNeg(int[] array){
        for (int i=0; i < array.length; i++){
            if (array[i]<0){
                array[i] =0;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}