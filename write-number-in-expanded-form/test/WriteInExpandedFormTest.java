import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WriteInExpandedFormTest {
  @Test
  public void testSomething() {
    assertEquals("10 + 2", WriteInExpandedForm.expandedForm(12));
    assertEquals("40 + 2", WriteInExpandedForm.expandedForm(42));
    assertEquals("70000 + 300 + 4", WriteInExpandedForm.expandedForm(70304));
  }
}