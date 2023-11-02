package collections.arraylist;

import java.util.Arrays;

public class SimpleArrayList<V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_LIST = {};
    private Object[] elements;
    private int size;
    private static final int MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8;

    public SimpleArrayList() {
        this.elements = EMPTY_LIST;
    }

    public SimpleArrayList(int capacity) {
        if (capacity > 0) {
            this.elements = new Object[capacity];
        } else if (capacity == 0) {
            this.elements = EMPTY_LIST;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
    }

    public void add(V v) {
        add(v, elements, size);
    }

    public void add(int index, V value) {
        rangeCheckForAdd(index);
        final int size;
        Object[] elementData;
        if ((size = this.size) == (elementData = this.elements).length) {
            elementData = resize();
        }
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = value;
        this.size = size + 1;
    }

    public V get(int index) {
        if (index >= elements.length) {
            return null;
        }
        //noinspection unchecked
        return (V) elements[index];
    }


    public void remove(Object value) {
        final Object[] data = elements;
        final int size = this.size;
        int index = 0;
        found: {
            if (value == null) {
                for (; index < size; index++) {
                    if (data[index] == null) {
                        break found;
                    }
                }
            } else {
                for (; index < size; index++) {
                    if (value.equals(data[index])) {
                        break found;
                    }
                }
            }
        }
        fastRemove(data, index);
    }

    public void remove(int index) {
        if (index >= elements.length) {
            return;
        }
        final Object[] data = elements;
        fastRemove(data, index);
    }

    public boolean contains(Object value) {
        return indexOf(value, size) >= 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        for (Object value : elements) {
            if (value != null) {
                System.out.println(value);
            }
        }
        System.out.println();
    }

    private void add(V value, Object[] elementData, int size) {
        if (size == elementData.length) {
            elementData = resize();
        }
        elementData[size] = value;
        this.size = size + 1;
    }

    private void fastRemove(Object[] data, int index) {
        final int newSize;
        if ((newSize = size - 1) > index) {
            System.arraycopy(data, index + 1, data, index, newSize - index);
        }
        data[size = newSize] = null;
    }

    int indexOf(Object value, int end) {
        Object[] data = elements;
        if (value == null) {
            for (int i = 0; i < end; i++) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < end; i++) {
                if (value.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    private Object[] resize() {
        return resize(size + 1);
    }

    private Object[] resize(int minCapacity) {
        int oldCapacity = elements.length;
        if (oldCapacity > 0 || elements != EMPTY_LIST) {
            int newCapacity = newLength(oldCapacity, minCapacity - oldCapacity, oldCapacity >> 1);
            return elements = Arrays.copyOf(elements, newCapacity);
        } else {
            return elements = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private int newLength(int oldLength, int minGrowth, int prefGrowth) {
        int prefLength = oldLength + Math.max(minGrowth, prefGrowth);
        if (0 < prefLength && prefLength <= MAX_ARRAY_LENGTH) {
            return prefLength;
        } else {
            return hugeLength(oldLength, minGrowth);
        }
    }

    private static int hugeLength(int oldLength, int minGrowth) {
        int minLength = oldLength + minGrowth;
        if (minLength < 0) {
            throw new OutOfMemoryError("Required array length " + oldLength + " + " + minGrowth + " is too large");
        } else {
            return Math.max(minLength, MAX_ARRAY_LENGTH);
        }
    }
}
