package labs_examples.datastructures.hashmap.labs;



/**
 *      HashMaps Exercise_02
 *
 *      Rewrite the CustomHashMap class to meet the following requirements:
 *      ✓1) no method has the same name as any in CustomHashMap
 *          (do not use refactor - do it manually)
 *      ✓2) no variable has the same name as any in CustomHashMap
 *          (do not use refactor - do it manually)
 *      ✓3) resize the HashMap when the underlying array is more than half full
 *      ✓4) triple the size of the underlying array on resize()
 *      ✓5) instead of checking the number of keys to resize, check the number of values
 *      ✓6) on collisions, add new elements to the front of the LinkedList, not the end
 *      ✓7) anytime someone tries to get/update/remove an element that does not exist, print
 *          out a message indicating that the element does not exist
 *      ✓8) add at least one more method that you think could be useful to the HashMap
 *          review Java's built-in HashMap for inspiration
 */
public class Exercise_02{
	public static void main(String[] args) {
		
		CustomHashMapRewrite<String, Integer> map = new CustomHashMapRewrite<>();
		map.add("a", 1);
		map.add("b", 2);
		map.add("c", 3);
	}
}

class CustomHashMapRewrite<K, V> {

    // create the underlying Entry array with the initial size of 10
    private EntryRewrite<K, V>[] array = new EntryRewrite[10];

    // track the current number of elements in the hashmap
    private int numValues = 0;

    private int getHashNum(K k) {
        // get the hashCode for the key and mod that hashCode by the length of the array
        int elementPlace = Math.abs(k.hashCode() % array.length);
        // the result will be the index where we can find and/or place entries
        return elementPlace;
    }

    public void add(K k, V val) {
        // call the hash() method to get the index to place the element
        int elementPlace = getHashNum(k);

        // create the Entry object containing the key and value that we will store in the underlying array
        EntryRewrite<K,V> entryElement = new EntryRewrite<K, V>(k, val);

        // no element at the given index, means no collision
        // go ahead and simply add the value to the array
        if (array[elementPlace] == null) {

        	array[elementPlace] = entryElement;
        	numValues++;
        }
        else {
            // get the first Entry (in the linked list) at the given index
        	EntryRewrite<K, V> CurrentElement = array[elementPlace];
        	entryElement.succeeding = CurrentElement;
        	array[elementPlace] = entryElement;
            numValues++;
        }

        // check for resize
        if (numValues > array.length * .5) {
        	changeSize();
        }
    }

    private void changeSize() {
        // make a copy of the existing table and call it "old"
    	EntryRewrite<K, V>[] oldEntryElement = array;
        // create a new Entry[] that is twice the size of the old one
    	array = new EntryRewrite[oldEntryElement.length * 3];

        // iterate over the length of the old array
        for (int i = 0; i < oldEntryElement.length; i++) {
            try {
                // get the Entry at the index of "i" from the "old" table
            	EntryRewrite<K, V> entryElement = oldEntryElement[i];
                // call the put() method passing the key and value to add this element to the new table
                add((K) entryElement.getK(), (V) entryElement.getV());

                // check to see if this entry is actually the start of a linked list
                while (entryElement.succeeding != null) {
                    // if it is, traverse to the next node
                	entryElement = entryElement.succeeding;
                    // and call the put() method to add this element
                    add((K) entryElement.getK(), (V) entryElement.getV());
                    // loop
                }
            } catch (Exception e) {
            }
        }
    }

    public void delete(K k) {

        // ensure key exists by calling the get() method
        if (retrieve(k) == null) {
            // if the get() method returns null, there's nothing to delete
        	System.out.println("Element does not exist");
            return;
        }

        // otherwise, get the index for the key by calling the hash() method
        int elementPlace = getHashNum(k);

        // get the Entry at the index
        EntryRewrite<K, V> entryElement = array[elementPlace];

        // if this entry has the matching key, remove the element at this index
        if (entryElement.getK().equals(k)){
        	array[elementPlace] = null;
        	numValues--;
            return;
        }

        // otherwise, if the next element in the linked list is not null
        while (entryElement.succeeding != null ) {
            // if the key of the next element in the linked list is not the key we're looking for
            if (entryElement.succeeding.getK() != k) {
                // traverse the linked list to the next node
            	entryElement = entryElement.succeeding;
            }
        }
        if(entryElement.succeeding.succeeding != null){
        	entryElement.succeeding = entryElement.succeeding.succeeding;
        	numValues--;
            return;
        }
        // otherwise, entry.next is the end of the list so we can just chop it off
        else {
        	entryElement.succeeding = null;
        	numValues--;
            return;
        }
    }

    public V retrieve(K k) {
        // call the hash() method to get the index for the key
        int elementPlace = getHashNum(k);

        // nothing at key - return null
        if (array[elementPlace] == null) {
        	System.out.println("Element does not exist");
            return null;
        }

        // otherwise, get the Entry at the index
        EntryRewrite<K, V> entryElement = array[elementPlace];

        while (entryElement.getK() != k) {

            if (entryElement.succeeding == null) {
                return null;
            }
            entryElement = entryElement.succeeding;
        }
        return entryElement.getV();
    }

    public int getArrayLength() {
        return array.length;
    }
    //8) Adding an additional method
    public void clear() {
    	array = new EntryRewrite[10];
    }
}

 class EntryRewrite<K, V> {
    private K k;
    private V val;
    // it means this is a LinkedList
    EntryRewrite succeeding = null;

    EntryRewrite(K k, V val) {
        this.k = k;
        this.val = val;
    }

    public K getK() {
        return k;
    }

    public V getV() {
        return val;
    }

    public void setV(V val) {
        this.val = val;
    }
}
