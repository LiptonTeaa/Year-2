import java.util.ArrayList;
import java.util.List;

class Heap {

  // Q3
//  public static int memWrites1;
//  public static int memWrites2;

  public ArrayList<Integer> array;
  public int heap_size;

  public Heap(int size) {
    array = new ArrayList<Integer>(size);
    heap_size = size;
  }

  public Heap(List<Integer> source) {
    this(source, false);
  }

  public Heap(List<Integer> source, boolean incremental) {
    heap_size = 0;
    if (incremental) {
      array = new ArrayList<Integer>();
      int size = source.size();
      for (int i = 0; i < size; i++) {
        insert(source.get(i));
      }
    } else {
      array = new ArrayList<Integer>(source);
      buildMaxHeap();
    }
  }

  public static int parent(int index) {
    return (index - 1) / 2;
  }

  public static int left(int index) {
    return 2 * index + 1;
  }

  public static int right(int index) {
    return 2 * index + 2;
  }

  public void maxHeapify(int i) {
    //int count = 0; //Q3
    int largest = i;
    int temp;
    if (left(i) < heap_size && array.get(left(i)) > array.get(largest)) {
      largest = left(i);
    }
    if (right(i) < heap_size && array.get(right(i)) > array.get(largest)) {
      largest = right(i);
    }
    if (largest != i) {
      temp = array.get(largest);

      array.set(largest, array.get(i));

      array.set(i, temp);

      //memWrites2 = memWrites2 +2; //Q3

      maxHeapify(largest);
    }
  }

  public void buildMaxHeap() {
    heap_size = array.size();
    for (int i = array.size() / 2 - 1; i >= 0; i--) {
      maxHeapify(i);
    }
  }

  public void insert(Integer k) {
    //int count = 0;
    int pos = heap_size++;
    array.add(k);
    //count = count + 1; //Q3
    while (pos > 0 && array.get(parent(pos)) < array.get(pos))
    {
      Integer temp = array.get(parent(pos));
      array.set(parent(pos), array.get(pos));
      array.set(pos, temp);
      pos = parent(pos);
      //count = count + 1; //Q3
    }
    //System.out.println( "The counter is: " + count);
    //memWrites1 += count;
  }

  public Integer maximum() {
    return array.get(0);
  }

  public Integer extractMax() {
    Integer max = maximum();
    array.set(0, array.get(--heap_size));
    maxHeapify(0);
    return max;
  }

  public ArrayList <Integer> sort()
  {
    while (heap_size > 0)
    {
      Integer max = maximum();
      array.set(0, array.get(--heap_size));
      maxHeapify(0);
      array.set(heap_size, max);
    }
    return array;
  }

//  public static void main(String[] args) {
//
//    ArrayList<Integer> test = new ArrayList<>(84063);
//    for (int i = 0; i < 11342; i++) {
//      test.add(i);
//    }
//    //Heap heap = new Heap(test, true);
//    Heap heap = new Heap(test);
//    //System.out.println(memWrites1);
//    System.out.println(memWrites2);
////    ArrayList<Integer> test = new ArrayList<>();
//
////        System.out.println(heap);
//
//  }
//
//  @Override
//  public String toString() {
//    return "Heap{" +
//            "array=" + array +
//            ", heap_size=" + heap_size +
//            '}';
//  }

}

// Moodle ID:  84064
// Numbers up to 84063