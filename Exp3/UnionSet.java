interface SetADT {
    boolean add(int item);
    boolean remove(int item);
    boolean contains(int item);
    SetADT union(SetADT otherSet);
}

class IntSet implements SetADT {
    int item;
    public boolean add(int item) { return true; }
    public boolean remove(int item) { return true; }
    public boolean contains(int item) { return true; }
    public SetADT union(SetADT otherSet) { return null; }
}

class OrderedIntSet implements SetADT {
    SetADT orderedSet;
    public boolean add(int item) { return true; }
    public boolean remove(int item) { return true; }
    public boolean contains(int item) { return true; }
    public SetADT union(SetADT otherSet) { return null; }
}

public class UnionSet implements SetADT {
    private IntSet set;

    public UnionSet() {
        set = new IntSet();
    }

    public boolean add(int item) {
        return set.add(item);
    }

    public boolean remove(int item) {
        return set.remove(item);
    }

    public boolean contains(int item) {
        return set.contains(item);
    }

    public SetADT union(SetADT otherSet) {
        UnionSet result = new UnionSet();
        for (int item : ((IntSet) set).getItems()) {
            result.add(item);
        }
        for (int item : ((IntSet) otherSet).getItems()) {
            result.add(item);
        }
        return result;
    }
}

class IntSet implements SetADT {
    private int[] items;
    private int size;
    private static final int MAX_SIZE = 100;

    public IntSet() {
        items = new int[MAX_SIZE];
        size = 0;
    }

    public boolean add(int item) {
        if (!contains(item) && size < MAX_SIZE) {
            items[size++] = item;
            return true;
        }
        return false;
    }

    public boolean remove(int item) {
        for (int i = 0; i < size; i++) {
            if (items[i] == item) {
                for (int j = i; j < size - 1; j++) {
                    items[j] = items[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean contains(int item) {
        for (int i = 0; i < size; i++) {
            if (items[i] == item) {
                return true;
            }
        }
        return false;
    }

    public SetADT union(SetADT otherSet) {
        UnionSet result = new UnionSet();
        for (int item : getItems()) {
            result.add(item);
        }
        for (int item : ((IntSet) otherSet).getItems()) {
            result.add(item);
        }
        return result;
    }

    public int[] getItems() {
        int[] result = new int[size];
        System.arraycopy(items, 0, result, 0, size);
        return result;
    }
}