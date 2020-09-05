import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataLetterTest {
  @Test
  public void exampleTests() {
    assertEquals('e', KataLetter.findMissingLetter(new char[]{'a', 'b', 'c', 'd', 'f'}));
    assertEquals('P', KataLetter.findMissingLetter(new char[]{'O', 'Q', 'R', 'S'}));
  }
}