import java.util.Random;
import java.util.Arrays;

public class Quick {
  public static int partition(int[] data, int start, int end) {
    //In range between start and end, inclusive
    Random randgen = new Random();
    int pivotIdx = Math.abs(randgen.nextInt() % (end - start + 1)) + start;
    System.out.println(pivotIdx);
    int pivot = data[pivotIdx];
    swap(data, start, pivotIdx);
    int i = start;
    int j = end;
    ++start;

    while (start < end) {
      if (data[start] == pivot)
        ++start;

      while (data[start] < pivot) {
        if (start == end) {
          swap(data, i, j);
          return end;
        }

        ++start;
      }
      
      while (data[end] > pivot) --end;
      swap(data, start, end);
    }

    swap(data, start, end);
    swap(data, i, end);

    System.out.println(Arrays.toString(data));
    System.out.println(end);
    return 1;
  }

  private static int[] swap(int[] data, int idx, int idx2) {
    int temp = data[idx];
    data[idx] = data[idx2];
    data[idx2] = temp;

    return data;
  }

  public static int quickselect(int[] data, int k) {


    return 1;
  }
}
