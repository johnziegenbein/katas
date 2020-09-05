public class KataLetter
{
  public static char findMissingLetter(char[] array) {
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    int amountOfCharsAfterStart = 1;
    int i = 0;

    for (; i < alphabet.length; i++) {
      if (Character.toLowerCase(array[0]) == alphabet[i]) {
        while (Character.toLowerCase(array[amountOfCharsAfterStart]) == alphabet[i + amountOfCharsAfterStart]) {
          amountOfCharsAfterStart++;
        }
        break;
      }
    }

    // if input is written with lower case return lower case, else return upper case
    if (Character.isLowerCase(array[0])) {
      return alphabet[i + amountOfCharsAfterStart];
    } else {
      return Character.toUpperCase(alphabet[i + amountOfCharsAfterStart]);
    }
  }
}