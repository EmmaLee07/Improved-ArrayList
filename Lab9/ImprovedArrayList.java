public class ImprovedArrayList implements MyList
{
    private int size;
    private Object[] data;

    public ImprovedArrayList()
    {
        // Let the other constructor do the work!
        this(0);
    }

    public ImprovedArrayList(int x)
    {
        size = 0;
        data = new Object[x];
    }

    /**
     *    Add obj to the end of the list.
     *    This method always returns true
     */
    public boolean add(Object obj)
    {
        if(data.length == size)
        {
            Object[] temp = new Object[data.length +1];
            for(int i = 0; i < size; i++)
            {
                temp[i] = data[i];
            }
            this.data = temp;
        }
        data[size] = obj;
        size++;
        return true;
    }

    /**
     *    Add obj to the specified index of the list.
     *    If index is too big, then add obj to the end of the list
     *    If index is too small, then add obj to the start of the list
     */
    public void add(int index, Object obj)
    {
        if (index == size)
        {
            add(obj);
            return;
        }
        if(outOfBounds(index))
        {
            return;
        }
        if(size == 0)
        {
            data = new Object[1];
        }
        else if(size == data.length)
        {
            Object[] newData = new Object[data.length *2];

            for(int i = 0; i < size; i++)
            {
                newData[i] = data[i];
            }
            data = newData;
        }
            for(int i = size; i >index; i--) {
                data[i] = data[i -1];
            }
            data[index] = obj;
            size++;
        
        // if(index >= size)
        // {
        // add(obj); 
        // }
        // else
        // {
        // size++;
        // if (index < 0){
        // index = 0;
        // }
        // for (int i = size-1; i > index; i--)
        // {
        // data[i] = data[i-1];
        // }
        // data[index] = obj;
        // }
    }

    /**
     *    Return true is this list contains something that is .equals() to obj
     */
    public boolean contains(Object obj)
    {
        for(Object o: data)
        {
            if(o != null && o.equals(obj))
            {
                return true;
            }
        }
        return false;
        
    }

    /**
     *    Return the Object located at the specified index
     *    If index is too big or too small, return null
     */
    public Object get(int index)
    {
        if(index < 0 || index >= size )
        {
            return null; 
        }
        else if(data.length <= 0)
        {
            return null;
        }
        else {
            return data[index]; }
    }

    /**
     *    Return true if there are no elements in the list
     */
    public boolean isEmpty()
    {
        return size ==0;
    }

    /**
     *    Remove the Object at the specified index from the list
     *    Return the Object that was removed
     *    If index is too big or to small, do not remove anything from the list and return null
     */
    public Object remove(int index)
    {
        Object obj = null;
        if(index < 0 || index >= size)
        {
            return null;
        }
        else
        {
            obj = data[index];
            for(int i = index; i < size-1; i++)
            {
                data[i] = data[i+1];
            }
            size--;
        }
        return obj;
    }

    /**
     *    Remove the first Object that is .equals() to obj
     *    Return true if an object was removed
     */
    public boolean remove(Object obj)
    {
        //HINT:  Find the index of obj and then call remove(int index)
        for(int i = 0; i < size; i++)
        {
            Object cur = data[i];
            if(data[i].equals(obj))
            {
                remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     *    Change the value stored at index to obj
     *    Return the value that was replaced
     *    If index is too big or too smalll, do not change and values and return null
     */
    public Object set(int index, Object obj)
    {
        if (index < 0 || index >= size) {
            return null; 
        }
        else if(data.length <=0)
        {
            return null;
        }
        else {
            Object returnValue = data[index]; 
            data[index] = obj; 
            return returnValue; }
    }

    /**
     *    Return the number of elements that are in the list
     */
    public int size()
    {
        // HINT:  Do you have a variable that holds the size?
        return size;
    }

    public boolean outOfBounds(int index)
    {
        return index < 0 || index >= size;
    }
}