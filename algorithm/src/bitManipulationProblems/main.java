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

    //if 'b' is even
    // a x b = (2a) x (b/2)

    // if 'b' is not even (odd)
    // a x b = (2a) x (b/2) + a

    // 5 x 7 = 10 x 3 + 5

    public static int multiply(int a, int b){

        int result = 0;

        while (b > 0){
            // if 'b' becomes odd (XOR operator decrements the value by 1 for odd numbers)
            // we want to skip when 'b' is even
            if ((b ^ 1) == b - 1){
                result = result + a;
            }
            // double the first number
            a = a << 1;
            // halve the second number
            b = b >> 1;

        }
        return result;
    }

}

























