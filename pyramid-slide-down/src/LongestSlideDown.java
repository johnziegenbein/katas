public class LongestSlideDown {

  public static int longestSlideDown(int[][] pyramid) {
    int[] previousPyramid = new int[pyramid.length + 1];
    int[] currentPyramid = new int[pyramid.length + 1];

    // iterate from bottom
    for (int row = pyramid.length - 1; row >= 0; row--) {
      storeMaxValuesForEachColumn(previousPyramid, currentPyramid, row, pyramid[row]);

      int[] prev = previousPyramid;
      previousPyramid = currentPyramid;
      currentPyramid = prev;
    }
    return previousPyramid[0];
  }

  private static void storeMaxValuesForEachColumn(int[] previousPyramid, int[] currentPyramid, int row, int[] ints) {
    for (int column = 0; column <= row; column++) {
      currentPyramid[column] =
          Math.max(previousPyramid[column], previousPyramid[column + 1]) +
              ints[column];
    }
  }
}