
import java.util.Scanner;

/**
 *
 */
public class ManualRingBuffTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      System.out.print("Input buffer capacity: ");
      int cap = (new Scanner(System.in)).nextInt();
      IRingBuffer<Integer> b = new ArrayRingBuffer<Integer>(cap);
      TestIntCliInterface t = new TestIntCliInterface(b);
      t.start();
    }
    catch (Exception ex) {
      System.out.println(ex.getMessage());
      System.out.println(ex.toString());
    }
  }

}
