public class Word {
  public static String high(String s) {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    int highScore = 0;
    String highestWord = "";

    // For every word
    for (String word: s.split(" "))
    {
      int score = 0;

      // For every character in a word
      for (char c: word.toCharArray())
      {
        score += alphabet.indexOf(c);
      }

      // Assign new HS if relevant
      if (score > highScore)
      {
        highScore = score;
        highestWord = word;
      }
    }
    return highestWord;
  }
}