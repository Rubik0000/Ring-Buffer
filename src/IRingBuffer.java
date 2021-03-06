
/**
 * An interface provides a ring buffer data structure
 */
public interface IRingBuffer<T> extends Iterable<T> {
  
  /**
   * Retrieves an element form the buffer and removes it
   * 
   * @return the element
   * @throws EmptyRingBufferException if the buffer is empty
   */
  T pop() throws EmptyRingBufferException;

  /**
   * Retrieves an element form the buffer but doesn't remove it
   * 
   * @return the element
   * @throws EmptyRingBufferException if the buffer is empty
   */
  T peek() throws EmptyRingBufferException;
  
  /**
   * Puts an element to the buffer
   * 
   * @param elem the element need to push
   */
  void push(T elem);
  
  /**
   * Gets the capacity of the buffer
   * 
   * @return the capacity
   */
  int capacity();
  
  /**
   * Checks whether the buffer is empty
   * 
   * @return true if it is empty else false
   */
  boolean isEmpty();
}
