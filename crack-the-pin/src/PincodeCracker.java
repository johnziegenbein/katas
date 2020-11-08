import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PincodeCracker {
  MessageDigest messageDigest = getMD5Digester();

  public String crack(String hash) {

    int i = 0;
    while (i < 100000) {
      String number = leftPadWithZeros(i);
      if (hash.equals(hashMD5(number))) {
        return number;
      }
      i++;
    }

    throw new IllegalArgumentException("Not a solvable hash: " + hash);
  }

  private String leftPadWithZeros(int i) {
    return String.format("%1$5s", i).replace(' ', '0');
  }

  private String hashMD5(String number) {
    byte[] digest = messageDigest.digest(number.getBytes());
    BigInteger bigInt = new BigInteger(1, digest);
    return bigInt.toString(16);
  }

  private MessageDigest getMD5Digester() {
    try {
      return MessageDigest.getInstance("MD5");
    }
    catch (NoSuchAlgorithmException e)  {
      throw new IllegalStateException("Could not find MD5 Digester");
    }
  }
}