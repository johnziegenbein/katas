public class Solution {

  public int solution(int number) {
    int sum = 0;
    // check and add multiples of 3
    for (int i = 0; i < (number - 1) / 3; i++) {
      sum += 3 * (i + 1);
    }

    // check and add multiples of 5
    for (int i = 0; i < (number - 1) / 5; i++) {
      // ignore every 3rd value as this is a multiple of 3 as well
      if ((i + 1)  % 3 != 0) {
        sum += 5 * (i + 1);
      }
    }
    return sum;
  }
}