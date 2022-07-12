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
}
