import java.util.Random;
import java.util.Arrays;

public class Quick {
  public static int partition(int[] data, int start, int end) {
    //In range between start and end, inclusive
    Random randgen = new Random();
    int pivotIdx = Math.abs(randgen.nextInt() % (end - start + 1)) + start;
    int[] nums = {start, pivotIdx, end};
    Arrays.sort(nums);
    pivotIdx = nums[1]; //the median
    int pivot = data[pivotIdx];
    swap(data, start, pivotIdx); //swap to 0 index
    int i = start; //since start and end change
    int j = end;
    ++start; //start is now 1 since 0 is the pivot

    while (start < end) {
      if (data[start] == pivot) { //prevent duplicates breaking the algorithm
        if (Math.random() < 0.5)
          swap(data, start, end);

        ++start;
      }

      while (data[start] < pivot) {
        //For the case where you get the maximum number which will cause an index exception for the while above
        if (start == end) {
          swap(data, i, j); //just swap the pivot right to the end
          return end;
        }

        ++start;
      }

      while (data[end] > pivot) --end;
      swap(data, start, end);
    }

    swap(data, start, end); //for some reason I need to do this, otherwise it doesn't work
    swap(data, i, end); //swap the pivot at idx 0 to the correct index

    return end;
  }

  private static int[] swap(int[] data, int idx, int idx2) {
    int temp = data[idx];
    data[idx] = data[idx2];
    data[idx2] = temp;

    return data;
  }

  public static int quickselect(int[] data, int k) {
    int pivotIdx = partition(data, 0, data.length - 1);
    //lowest value is guaranteed to be in the 0th index, for some reason this breaks for k = 0 otherwise
    if (k == 0)
      return data[0];

    return quickselectH(data, pivotIdx, k);
  }

  private static int quickselectH(int[] data, int pivotIdx, int k) {
    if (pivotIdx == k)
      return data[pivotIdx];

    if (pivotIdx < k)
      return quickselectH(data, partition(data, pivotIdx + 1, data.length - 1), k);

    return quickselectH(data, partition(data, 0, pivotIdx - 1), k);
  }
}
