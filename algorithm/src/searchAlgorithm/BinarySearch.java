package searchAlgorithm;

public class BinarySearch {

    public int find(int[] array,int item,int left,int right){

        if (right < left) return -1;

        int middle = (left + right) / 2;

        if (array[middle] == item){
            return middle;
        }
        //we have to check that the item we are looking for is smaller or
        //greater than the middle item
        if (array[middle] < item){
            return find(array,item,middle + 1,right);
        }else{
            //item is smaller than the middle item
            return find(array,item,left,middle - 1);
        }
    }
}



















