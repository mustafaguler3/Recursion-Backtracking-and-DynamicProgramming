package bitManipulationProblems;

public class main {
    public static void main(String[] args) {

        System.out.println(countBits(164));

    }

    public static int countBits(int n){

        int counter = 0;

        while (n > 0){
            counter++;

            n = n >> 1;
        }
        return counter;
    }


    // 1010 = (10)
    //0001 = 1


    //O(1)
    //usually the % module operator is used
    public static boolean isEven(int n){

        if (n % 2 == 0) return true;

        //XOR operator with 1 decrements the value for odd numbers
        //XOR operator with 1 increment the value for even numbers
        if ((n ^ 1) == n + 1){
            return true;
        }
        return false;
    }
}
