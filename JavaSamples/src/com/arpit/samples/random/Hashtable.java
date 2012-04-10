import java.util.*;

public class Hashtable<K, V>
{
    private class Cell
    {
        K key;
        V value;
        int hashcode;
        Cell next;

        public Cell(K key, V value, int hash)
        {
            this.key = key;
            this.value = value;
            this.hashcode = hash;
        }
    }

    private static final int DEFAULT_SIZE = 32;
    private float loadFactor = 0;
    private int load = 0;
    private int size = DEFAULT_SIZE;
    private List<Cell> table;

    public Hashtable(int size)
    {
        if(size != 0 && ((size & (size -1)) == 0))    //not zero and power of 2
        {
            this.table = new ArrayList<Cell>(size);
            this.size = size;
        }
        else
        {
            this.table = new ArrayList<Cell>(DEFAULT_SIZE);
        }
        for(int i = 0; i < size; i++)
        {
            table.add(null);
        }
    }

    public Hashtable()
    {
        this(DEFAULT_SIZE);
    }

    public void put(K key, V value)
    {
        int hash = getHash(key);
        Cell newCell = new Cell(key, value, hash);
        if(table.get(hash) != null)
        {
            newCell.next = table.get(hash); //insert at front
        }
        table.set(hash, newCell);
    }

    public int getHash(K key)
    {
        return (key.hashCode() >>> 1) % size;
    }

    public V get(K key)
    {
        int hash = getHash(key);
        Cell copy = table.get(hash);
        if(copy == null) return null;
        while(copy != null)
        {
            if(copy.hashcode == hash)
            {
                return copy.value;
            }
            copy = copy.next;
        }
        return null;
    }

    public void print()
    {
        System.out.println(" key : value ");
        for(Cell c : table)
        {
            if( c == null)
            {
                System.out.println(" null : null ");
            }
            else
            {
                System.out.println(c.key + " : " + c.value);
            }
        }
    }
}
