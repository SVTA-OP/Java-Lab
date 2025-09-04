interface SetADT{
    boolean add(int item);
    boolean remove(int item);
    boolean contains (int item);
    SetADT union(SetADT otherSet);
}

class IntSet implements SetADT {
    int[] elements;
    int size = 0;
    
    public boolean add(int e){
        elements[size++] = e;
        return true;
    }
    
    public boolean remove(int item){
        boolean flag = false;
        if (size == 0)
            return false;
        else{
            for (int i = 0; i<size; i++){
                if (elements[i] == item){
                    flag = true;
                }
                if (flag == true){
                    elements[i] = elements[i+1];
                }
            }
            if (flag == true)
                return true;
            else
            return false;
        }
    }

    public boolean contains(int item){
        for (int i=0; i<size; i++){
            if (elements[i] == item)
                return true;
        }
        return false;
    }

    SetADT union(SetADT otherSet){
    }
}