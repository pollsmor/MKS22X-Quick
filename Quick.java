import java.util.Random;
import java.util.Arrays;

public class Quick {
  public static int partition(int[] data, int start, int end) {
    //In range between start and end, inclusive
    Random randgen = new Random();
    int pivotIdx = Math.abs(randgen.nextInt() % (end - start + 1)) + start;

    //Median optimization
    int[] medianCalc = {start, pivotIdx, end};
    Arrays.sort(medianCalc); //am I allowed  to do this?
    pivotIdx = medianCalc[1]; //the median, 0 <1> 2

    int pivot = data[pivotIdx];
    swap(data, start, pivotIdx); //swap to 0 index
    int i = start; //since start and end change
    int j = end;
    ++i; //start is now 1 since 0 is the pivot

    while (i <= j) {
      if (data[i] > pivot) {
        swap(data, i, j);
        ++i;
      }

      if (data[j] < pivot) {
        swap(data, j, i);
        --j;
      }

      swap(data, 0, j);

    return end;
  }

  private static int[] swap(int[] data, int idx, int idx2) {
    int temp = data[idx];
    data[idx] = data[idx2];
    data[idx2] = temp;

    return data;
  }

  public static int quickselect(int[] data, int k) {
    //start and end will be changed according  to the pivot
    int start = 0;
    int end = data.length - 1;
    int pivot = partition(data, start, end);

    while (pivot != k) {
      if (pivot > k)
        end = pivot - 1; //should be on the left, rightmost bounds is pivot - 1

      else if (pivot < k)
        start = pivot + 1; //vice versa, on the right

      pivot = partition(data, start, end);
    }

    return data[pivot];
  }
}
