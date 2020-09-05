import java.util.Map;
import java.util.stream.Collectors;

public class CountingDuplicates {
  public static int duplicateCount(String text) {
    int count = 0;
    text = text.toLowerCase();
    Map<String, Long> collect = text.chars()
        .mapToObj(i -> (char) i)
        .collect(Collectors.groupingBy(Object::toString, Collectors.counting()));

    for (Long value : collect.values()) {
      if (value > 1) {
        count++;
      }
    }
    return count;
  }
}