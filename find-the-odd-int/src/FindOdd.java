import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FindOdd {
  public static int findIt(int[] a) {

    Map<Integer, Long> collect = Arrays.stream(a)
        .boxed()
        .collect(Collectors.groupingBy(Integer::new, Collectors.counting()));

    for (Map.Entry<Integer, Long> entry : collect.entrySet()) {
      if (entry.getValue() % 2 != 0) {
        return entry.getKey();
      }
    }

    return 0;
  }
}