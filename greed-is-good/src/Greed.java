import java.util.Arrays;

public class Greed{
  public static int greedy(int[] dice){
    int[] diceCounts = new int[6];
    Arrays.stream(dice).forEach(die -> diceCounts[die - 1]++);

    int sum = 0;
    for (int i=0; i < diceCounts.length; i++) {
      if (i==0) {
        sum += diceCounts[i] * 100;
        if (diceCounts[i] >= 3) {
          sum += 700;
        }
      }
      else if (i==4) {
        sum += diceCounts[i] * 50;
        if (diceCounts[i] >= 3) {
          sum += 350;
        }
      }
      else {
        if (diceCounts[i] >= 3) {
          sum += (i+1) * 100;
        }
      }
    }

    return sum;
  }
}