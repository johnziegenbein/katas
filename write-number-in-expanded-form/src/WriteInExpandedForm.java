public class WriteInExpandedForm
{
  public static String expandedForm(int num)
  {
    StringBuilder str = new StringBuilder();
    String number = String.valueOf(num);
    for (int i = 0; i < number.length(); i++)
    {
      if (number.charAt(i) != '0')
      {
        if (i != 0)
        {
          str.append(" + ");
        }
        str.append(number.charAt(i));
        for (int x = 0; x < number.length() - i - 1 ; x++)
        {
          str.append("0");
        }
      }
    }
    return str.toString();
  }
}