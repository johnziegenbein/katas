class Persist {
  public static int persistence(long n) {

    char[] numbers = String.valueOf(n).toCharArray();
    if (numbers.length == 1) {
      return 0;
    }

    int multSum = 1;
    for (char number : numbers) {
      multSum *= Character.getNumericValue(number);
    }

    if (String.valueOf(multSum).toCharArray().length != 1) {
      return persistence(multSum) + 1;
    }
    return 1;
  }
}