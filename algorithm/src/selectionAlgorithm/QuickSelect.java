package selectionAlgorithm;

import java.util.Random;

public class QuickSelect {

    private int[] nums;

    public QuickSelect(int[] nums) {
        this.nums = nums;
    }

    public int select(int k){
        return quickSelect(0,nums.length - 1,k-1);
    }

    public int partition(int firstIndex,int lastIndex){

        //index of the random pivot
        int pivot = new Random().nextInt(lastIndex - firstIndex + 1) + firstIndex;

        swap(pivot,lastIndex);

        for (int i=firstIndex;i<lastIndex;i++){
            if (nums[i] < nums[pivot]){
                swap(i,firstIndex);
                firstIndex++;
            }
        }
        swap(lastIndex,firstIndex);

        return firstIndex;
    }

    public void swap(int pivot,int lastIndex){
        int temp = nums[pivot];
        nums[pivot] = nums[lastIndex];
        nums[lastIndex] = temp;
    }

    //this is the selection phase
    public int quickSelect(int firstIndex,int lastIndex,int k){

        int pivotIndex = partition(firstIndex,lastIndex);

        if (pivotIndex < k){
            //we can discard the left sub-array so we have to consider the items on the right
            quickSelect(pivotIndex+1,lastIndex,k);
        }else if (pivotIndex > k){
            return quickSelect(firstIndex,pivotIndex-1,k);
        }
        return nums[pivotIndex];
    }
}
