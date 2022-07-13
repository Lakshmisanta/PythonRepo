package utilities;

import java.lang.StringBuilder;
import java.util.Random;

public class StringUtils {

  /**
   *
   * @param candidateChars
   *            the candidate chars
   * @param length
   *            the number of random chars to be generated
   *
   * @return
   */
  public static String generateRandomChars(String candidateChars, int length) {
      StringBuilder sb = new StringBuilder();
      Random random = new Random();
      for (int i = 0; i < length; i++) {
          sb.append(candidateChars.charAt(random.nextInt(candidateChars
                  .length())));
      }

      return sb.toString();
  }
}
