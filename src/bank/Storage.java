package bank;

/**
 * A generic storage class that can hold an item of any type.
 * @param <T> the type of the item to be stored
 */
public class Storage<T> {

    private T item;

    /**
     * Returns the stored item.
     * @return the stored item, or null if no item is stored
     */
    public T getItem() {
        return item;
    }

    /**
     * Stores the given item. There is no validation for null values.
     * @param item the item to be stored
     */
    public void setItem(T item) {
        this.item = item;
    }
}
