import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Order {
  public static String order(String words) {
    return Stream.of(words.split(" "))
        .sorted(Comparator.comparing(
            Order::getNumber))
        .collect(Collectors.joining(" "));
  }

  public static String getNumber(String word) {
    return word.chars()
        .mapToObj(c -> (char) c)
        .filter(Character::isDigit)
        .map(Object::toString)
        .collect(Collectors.joining());
  }
}