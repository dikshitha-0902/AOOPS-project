package customcollection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomCollection implements Iterable<Integer> {
    private int[] items;
    private int size;

    public CustomCollection(int capacity) {
        items = new int[capacity];
        size = 0;
    }

    public void add(int item) {
        if (size < items.length) {
            items[size++] = item;
        } else {
            throw new IllegalStateException("Collection is full");
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<Integer> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements to iterate");
            }
            return items[currentIndex++];
        }
    }

    public static void main(String[] args) {
        // Create a CustomCollection with a capacity of 5
        CustomCollection collection = new CustomCollection(5);

        // Add elements to the collection
        collection.add(10);
        collection.add(20);
        collection.add(30);
        collection.add(40);
        collection.add(50);

        // Iterate over the elements using the custom iterator
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Output the size of the collection
        System.out.println("Size of the collection: " + collection.getSize());

        // Demonstrating the exception when adding beyond capacity
        try {
            collection.add(60);
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Demonstrating the exception when calling next() beyond the last element
        try {
            iterator.next(); // This should throw an exception
        } catch (NoSuchElementException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

