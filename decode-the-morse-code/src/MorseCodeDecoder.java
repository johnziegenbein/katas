import java.util.Arrays;

public class MorseCodeDecoder {
  public static String decode(String morseCode) {
    StringBuilder sb = new StringBuilder();

    String[] codes = morseCode.trim().split(" {3}");
    for (String code : codes) {
      Arrays.stream(code.split(" ")).forEach(str -> sb.append(MorseCode.get(str)));
      sb.append(" ");
    }
    return sb.toString().trim();
  }

  // MorseCode only available in codewars kata.
  static class MorseCode {
    public static char[] get(String str) {
      return new char[]{};
    }
  }
}