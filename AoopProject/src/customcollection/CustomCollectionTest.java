package customcollection;
import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;

public class CustomCollectionTest {
    private CustomCollection collection;

    @Before
    public void setUp() {
        collection = new CustomCollection(5);
    }

   
    public void testAddAndSize() {
        collection.add(1);
        collection.add(2);
       
    }
    public void testAddBeyondCapacity() {
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);
        collection.add(6);  // This should throw an exception
    }

    @Test
    public void testIteratorTraversal() {
        collection.add(1);
        collection.add(2);
        collection.add(3);

        Iterator<Integer> iterator = collection.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(1), iterator.next());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertEquals(Integer.valueOf(3), iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNextBeyondEnd() {
        collection.add(1);
        Iterator<Integer> iterator = collection.iterator();
        iterator.next();  // Valid
        iterator.next();  // This should throw an exception
    }

    @Test
    public void testEmptyCollectionIterator() {
        Iterator<Integer> iterator = collection.iterator();
        assertFalse(iterator.hasNext());
    }
}

