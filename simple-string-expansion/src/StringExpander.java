import java.util.stream.IntStream;

class StringExpander{
  public static String solve(String s) {
    s = s.replace("(", "")
         .replace(")", "");

    int indexOfFirstNumber = findIndexOfFirstNumber(s);
    if (indexOfFirstNumber == -1) {
      return s;
    }

    return s.substring(0, indexOfFirstNumber) +
           repeatString(s, indexOfFirstNumber);
  }

  private static String repeatString(String s, int indexOfFirstNumber) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < Character.getNumericValue(s.charAt(indexOfFirstNumber)); i++) {
      stringBuilder.append(solve(getStringToBeRepeated(s, indexOfFirstNumber)));
    }
    return stringBuilder.toString();
  }

  private static String getStringToBeRepeated(String s, int i) {
    return s.substring(i + 1);
  }

  static int findIndexOfFirstNumber(String string) {
    char[] charArray = string.toCharArray();
    return IntStream.range(0, charArray.length)
                    .filter(i -> Character.isDigit(charArray[i]))
                    .findFirst()
                    .orElse(-1);
  }
}