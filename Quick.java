import java.util.Random;
import java.util.Arrays;

public class Quick {
  public static int partition(int[] data, int start, int end) {

    //Hardcoded case
    if (start == end)
      return start;

    //In range between start and end, inclusive
    Random randgen = new Random();
    int pivotIdx = randgen.nextInt(end - start + 1) + start;

    //Median optimization
    int[] medianCalc = {start, pivotIdx, end};
    Arrays.sort(medianCalc); //am I allowed  to do this?
    pivotIdx = medianCalc[1]; //the median, 0 <1> 2

    int pivot = data[pivotIdx];
    swap(data, start, pivotIdx); //swap to 0 index
    int i = start; //since start and end change
    int j = end;
    ++i; //start is now 1 since 0 is the pivot

    while (i != j) {
      if (data[i] < pivot) //count up without swapping, all is normal
        ++i;

      else if (data[i] >= pivot) {
        swap(data, i, j);
        --j;
      }
    }

    //Pivot randomly lands, this picks the correct one
    if (data[i] < pivot) {
      swap(data, start, i);
      return i;
    }

    swap(data, start, i - 1);
    return i - 1;
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

  public static void quicksort(int[] data) {
    //Hardcoded case
    if (data.length == 1)
      return;

    quicksortH(data, 0, data.length - 1);
  }

  private static void quicksortH(int[] data, int lo, int hi) {
    if (lo >= hi)
      return;

    int pivot = partition(data, lo, hi);
    quicksortH(data, lo, pivot - 1);
    quicksortH(data, pivot + 1, hi);
  }
}
