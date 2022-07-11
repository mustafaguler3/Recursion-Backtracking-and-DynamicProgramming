package recursion;

public class Factorial {

    public int head(int n){

        if (n == 1) return 1;

        int res = head(n - 1);

        int result = n * res;

        return result;
    }

    public int tail(int n,int accumulator){

        if (n == 1) return accumulator;

        return tail(n-1, n * accumulator);
    }

}























