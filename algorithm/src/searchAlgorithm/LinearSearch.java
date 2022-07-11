package searchAlgorithm;

public class LinearSearch {

    public int linear_search(int[] array,int item){

        for (int i =0;i < array.length; i++){
            if (array[i] == item){
                return i;
            }
        }
        return -1;
    }

}
