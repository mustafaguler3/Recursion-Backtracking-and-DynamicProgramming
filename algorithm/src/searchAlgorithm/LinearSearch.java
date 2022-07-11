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

    public int linear_search_recursion(int[] array,int item,int index){

        // search miss
        if(index >= array.length) return -1;

        // base case when we find the item
        if(array[index] == item) return index;

        return linear_search_recursion(array,item,index + 1);
    }
}
