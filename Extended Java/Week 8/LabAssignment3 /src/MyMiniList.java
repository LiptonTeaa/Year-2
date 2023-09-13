import java.util.Arrays;
import java.util.Objects;

public class MyMiniList <T> implements MiniList<T> {

    int size = 0;
    T[] objectStore = (T[]) new Object[10];

    @Override
    public void add(T element) {

        //        int count = 0;
//        if (objectStore[objectStore.length - 1] == null)
//        {
//            objectStore[objectStore.length - 1] = element;
//            size++;
//            System.out.println("First if");
//            System.out.println("this is size " + size);
//            System.out.println("Length of index " + objectStore.length);
//            return;
//        }
//        else {
//            //while (objectStore[(objectStore.length - 1) - count] != null) {
//                for (int i = objectStore.length - 1; i >= 0; i--) {
//                    System.out.println("While loop");
//                    if (objectStore[i] == null) {
//                        objectStore[i] = element;
//                        size++;
//                        System.out.println("the loop executes");
//                        System.out.println("this is size " + size);
//                        System.out.println("Length of index " + objectStore.length);
//                        //System.out.println(objectStore[10]);
//                        return;
//                    }
//                }
//        }
//            // New array of double the size
//            T[] tempStore = (T[]) new Object[objectStore.length * 2];
//        System.out.println("list exapnded");
//            // Copying over the content at the end of the new array that's twice the size
//            //System.arraycopy(source_arr, sourcePos, dest_arr, destPos, len);
//            System.arraycopy(objectStore, 0, tempStore, objectStore.length, objectStore.length);
//            // Adding element into expanded array
//        for (int i = tempStore.length - 1; i >= 0; i--) {
//            System.out.println("The EXTRA after expansion While loop");
//            if (tempStore[i] == null) {
//                System.out.println("the loop executes");
//                tempStore[i] = element;
//                objectStore = tempStore;
//                size++;
//                System.out.println("this is size " + size);
//                System.out.println("Length of index " + tempStore.length);
//                System.out.println(objectStore[10]);
//                return;
//            }
//        }
// --------------------   This entire implementation above adds things in reverse  ^^^

        T[] tempStore;

        if (objectStore[objectStore.length - 1] != null) // Make sure the array is Not empty by checking first position
        {
            //int tempStore = objectStore.length;
            int tempSize = size();
            tempStore = Arrays.copyOf(objectStore, objectStore.length * 2);   // Doubling array size &
            tempStore[tempSize] = element;                                              // keeping element sequence
            objectStore = tempStore;
            //size++;
        }
        else // If the first position (at the end of the array) is empty, add it there
        {
            objectStore[size()] = element;
            //size++;
        }
    }

    @Override
    public T get(int index) {

        // catch and try block to handle out of bound errors
        try
        {
            Objects.checkIndex(index, objectStore.length);
            return (T) objectStore[index];
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Index is out of bounds");
            return null;
        }
    }

    @Override
    public int getIndex(T element) {

        // Linear search for item in the list. Once found; return.
        for (int i = 0; i < objectStore.length - 1; i++)
        {
            if (objectStore[i] == element)
            {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void set(int index, T element) {

        // Gets element from get, gets index of element from getIndex, uses index to overwrite with new element
        // We can check if the index is out of bounds this way by getting index twice
        objectStore[getIndex(get(index))] = element;
    }

    @Override
    public int size() {

        // I was forced to use this as a method because manually adding and subtracting during add and
        // remove methods kept throwing the array out of bounds
        // Counts every non-null element in the list and returns the number

        int count = 0;
        for (int i = 0; i < objectStore.length; i++)
        {
            if (objectStore[i] != null)
            {
                count++;
            }
        }
        size = count;
        return size;
    }

    @Override
    public T remove(int index) {

        T temp;
        // Should also check if the index is a valid value
        temp = get(index);
        T[] copyArray = (T[]) new Object[objectStore.length];
        //System.arraycopy(source_arr, sourcePos, dest_arr, destPos, len);
        System.arraycopy(objectStore, 0, copyArray, 0, index);
        System.arraycopy(objectStore, index + 1, copyArray, index, objectStore.length - index - 1);

        // Could not make this work with a single line by copying over itself
        //System.arraycopy(objectStore, 0, objectStore, index, (objectStore.length - 1) - index);

        objectStore = copyArray;

        size--;

        return temp;
        }

    @Override
    public boolean remove(T element) {

            for (int i = getIndex(element); i < objectStore.length; i++)
            {
                // Just copy next index value onto current index value
                objectStore[i] = objectStore[i + 1];
                if (objectStore[i] == null)
                {
                    break;
                }
            }
            return true;
    }

    @Override
    public void clear() {

        // Will fill the entire array with null but, will retain the current array size
        Arrays.fill(objectStore, null);
        size = 0;
    }

    @Override
    public String toString() {
        return "MyMiniList{" +
                "size=" + size +
                ", objectStore=" + Arrays.toString(objectStore) +
                '}';
    }
}
