import java.util.ArrayList;

public class MexicanWave {

  public static String[] wave(String str) {
    ArrayList<String> waves = new ArrayList<>();

    int amountOfWaves = str.replaceAll(" ", "").length();
    int spaces = str.replaceAll("[^ ]", "").length();
    amountOfWaves = amountOfWaves + spaces;

    for (int i = 0; i < amountOfWaves; i++) {
      if (str.charAt(i) != ' ') {
        char[] chars = str.toCharArray();
        chars[i] = Character.toUpperCase(chars[i]);
        waves.add(String.valueOf(chars));
      }
    }
    return waves.toArray(new String[0]);
  }
}