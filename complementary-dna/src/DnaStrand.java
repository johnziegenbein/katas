import java.util.stream.Collectors;

public class DnaStrand {

  public static String makeComplement(String dna) {
    return dna.toUpperCase()
        .chars()
        .mapToObj(i -> (char) i)
        .map(DnaStrand::getComplement)
        .collect(Collectors.joining());
  }

  public static String getComplement(char c) {
    switch (c) {
      case 'A':
        return "T";
      case 'T':
        return "A";
      case 'G':
        return "C";
      case 'C':
        return "G";
    }
    return " ";
  }
}