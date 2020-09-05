import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class DescendingOrder {
  public static int sortDesc(final int num) {
    int[] sortedArray = IntStream.of(String.valueOf(num).chars().map(i -> i - '0').toArray())
        .boxed()
        .sorted(Comparator.reverseOrder())
        .mapToInt(i -> i)
        .toArray();

    StringBuilder sb = new StringBuilder();
    Arrays.stream(sortedArray).forEach(sb::append);
    return Integer.valueOf(sb.toString());
  }
}