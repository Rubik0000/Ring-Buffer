
import java.util.Scanner;

public class TestIntCliInterface {
  
  private static final String PUSH = "push";
  private static final String POP = "pop";
  private static final String EXIT = "exit";
  private static final String ALL = "all";
  private static final String CAP = "cap";
  
  private IRingBuffer<Integer> _buf;
  private Scanner _scan = new Scanner(System.in);
  
  public TestIntCliInterface(IRingBuffer<Integer> buf) {
    _buf = buf;
  }
  
  public void start() {
    for(;;) {
      System.out.print(">> ");
      String command = _scan.nextLine().toLowerCase().trim(); 
      switch (command) {
        case EXIT:
          return;
          
        case PUSH:
          System.out.print("Input integer elements: ");
          Scanner s = new Scanner(_scan.nextLine());
          while (s.hasNextInt()) {
            _buf.push(s.nextInt());
          }
          break;
          
        case POP:
          System.out.print("The count: ");
          try {
            if (_scan.hasNextInt()) {
              int n = _scan.nextInt();
              for (int i = 0; i < n; ++i) {
                System.out.print(_buf.pop().toString() + " ");
              }
              System.out.println();
              _scan.nextLine();
            }
            else if (_scan.nextLine().equals(ALL)) {
              do {
                System.out.print(_buf.pop().toString() + " ");
              } while (!_buf.isEmpty());
              System.out.println();
            }
          }
          catch (Exception ex) {
            System.out.println(ex.getMessage());
            _scan.nextLine();
          }
          break;
          
        case CAP:
          System.out.println(_buf.capacity());
          break;
          
        default:
          System.out.println("\nUnknown command");
          break;
      }    
    }// for
  }
  
}
