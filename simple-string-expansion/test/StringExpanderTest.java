import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringExpanderTest{
  @Test
  public void basicTests(){
    assertEquals("ababab",StringExpander.solve("3(ab)"));
    assertEquals("abbbabbb",StringExpander.solve("2(a3(b))"));
    assertEquals("bccbccbcc",StringExpander.solve("3(b(2(c)))"));
    assertEquals("kabaccbaccbacc",StringExpander.solve("k(a3(b(a2(c))))"));
  }

  @Test
  public void findIndexOfFirstNumber(){
    assertEquals(0,StringExpander.findIndexOfFirstNumber("3(ab)"));
    assertEquals(3,StringExpander.findIndexOfFirstNumber("k(a3(b(a2(c))))"));
  }
}