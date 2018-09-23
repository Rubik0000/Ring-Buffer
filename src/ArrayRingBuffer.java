
import java.lang.reflect.Array;

/**
 * Implements a ring buffer on array base
 */
public class ArrayRingBuffer<T> implements IRingBuffer<T> {

  /** The default capacity */
  private static int _defaulCap = 10;
  
  
  /** The data structure provides a buffer */
  private T[] _buffer = null;
  
  /** The current capacity */
  private int _capacity;
  
  /** The index to read an element */
  private int _readInd = 0;
  
  /** The index to write an elements */
  private int _writeInd = 0;
  
  /** The count of elements */
  private int _count = 0;
  
  /**
   * Constructs the buffer with given capacity
   * 
   * @param capacity
   * @throws NegativeRingBufferCapacityException 
   */
  public ArrayRingBuffer(int capacity) throws NegativeRingBufferCapacityException {
    if (capacity <= 0) {
      throw new NegativeRingBufferCapacityException("Not valid capacity");
    }
    _capacity = capacity;
  }
  
  /**
   * Constructs the buffer with default capacity
   * 
   * @throws NegativeRingBufferCapacityException 
   */
  public ArrayRingBuffer() throws NegativeRingBufferCapacityException {
    this(_defaulCap);
  }
  
  /**
   * Shifts a given index
   * if the index stays on the last element of the buffer
   * it is set to 0 else increased
   * 
   * @param ind index
   * @return the next value of the index
   */
  private int shiftIndex(int ind) {
    return ind == _capacity - 1 ? 0 : ind + 1;
  }
  
  @Override
  public T pop() throws EmptyRingBufferException {
    if (isEmpty()) {
      throw new EmptyRingBufferException("The buffer is empty");
    }
    T el = _buffer[_readInd];
    --_count;
    // shift the index
    _readInd = shiftIndex(_readInd);
    return el;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void push(T elem) {
    // lazy initialization
    if (_buffer == null) {
      _buffer = (T[])Array.newInstance(elem.getClass(), _capacity);
    }
    // if the write index have intersected the read index
    // shift read index
    // it means that the count is max therefore is is not increased
    if (_writeInd == _readInd && _count != 0) { 
      _readInd = shiftIndex(_readInd);
    }
    else {
      ++_count;
    }
    _buffer[_writeInd] = elem;
   // shift the index
    _writeInd = shiftIndex(_writeInd);
  }

  @Override
  public int capacity() {
    return _capacity;
  }

  @Override
  public boolean isEmpty() {
    return _count == 0;
  }

}
