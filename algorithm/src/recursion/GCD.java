package recursion;

public class GCD {

    public int gcd_recursion(int a,int b){

        if (a % b == 0){
            return b;
        }

        return gcd_recursion(b,a % b);
    }

    public int gcd_iteration(int a,int b){

        int temp = 0;

        while (b != 0){
            temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

}
