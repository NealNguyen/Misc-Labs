import java.util.*;

/*
 * code authored by Maria & Gary Litvan
 */

public class SetWithArray
{
    private int[] x;

    public SetWithArray(int[] num)
    {
        x = num;
    }

    /*
     * returns an Set (array) containing all elements in x OR y
     */
    public int[] union(int[] y)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int a = 0; a < x.length; a++)
        {
            list.add(x[a]);
        }
        for(int a = 0; a < y.length; a++)
        {
            if(!list.contains(y[a]))
            {
                list.add(y[a]);
            }
        }
        int[] ans = new int[list.size()];
        for(int a = 0; a < list.size(); a++)
        {
            ans[a] = list.get(a).intValue();
        }
        return ans;
    }

    /*
     * returns an Set (array) containing all elements in x AND y
     */
    public int[] intersection(int[] y)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int a = 0; a < x.length; a++)
        {
            for(int b = 0; b < y.length; b++)
            {
                if(x[a] == y[b])
                {
                    list.add(x[a]);
                    break;
                }
            }
        }
        int[] ans = new int[list.size()];
        for(int a = 0; a < list.size(); a++)
        {
            ans[a] = list.get(a).intValue();
        }
        return ans;
    }

    /*
     * returns an Set (array) containing all elements in x that are not in y
     */
    public int[] difference(int[] y)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int a = 0; a < x.length; a++)
        {
            list.add(x[a]);
        }
        for(int a = 0; a < y.length; a++)
        {
            if(list.contains(y[a]))
            {
                list.remove(new Integer(y[a]));
            }
        }
        int[] ans = new int[list.size()];
        for(int a = 0; a < list.size(); a++)
        {
            ans[a] = list.get(a).intValue();
        }
        return ans;
    }

    /*
     * returns true if all elements of x are contained in y
     */
    public boolean isSubSetOf(int[] y)
    {
        if(x.length > y.length)
        {
            return false;
        }
        for(int a = 0; a < x.length; a++)
        {
            boolean flag = false;
            for(int b = 0; b < y.length; b++)
            {
                if(x[a] == y[b])
                {
                    flag = true;
                    break;
                }
            }
            if(!flag)
            {
                return false;
            }
        }
        return true;
    }

    /*
     * returns true if all elements in y are contained in x
     *              and if all elements in x are contained in y
     */
    public boolean isEqualTo(int[] y)
    {
        if(x.length != y.length)
        {
            return false;
        }
        for(int a = 0; a < x.length; a++)
        {
            boolean flag = false;
            for(int b = 0; b < y.length; b++)
            {
                if(x[a] == y[b])
                {
                    flag = true;
                    break;
                }
            }
            if(!flag)
            {
                return false;
            }
        }
        return true;
    }

    /*
     * returns the set of elements which are in one of the set
     *         that is:  (x - y) union (y - x)
     */
    public int[] symmetricDifference(int[] y)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int a = 0; a < x.length; a++)
        {
            list.add(x[a]);
        }
        for(int a = 0; a < y.length; a++)
        {
            if(list.contains(y[a]))
            {
                list.remove(new Integer(y[a]));
            }
            else
            {
                list.add(y[a]);
            }
        }
        int[] ans = new int[list.size()];
        for(int a = 0; a < list.size(); a++)
        {
            ans[a] = list.get(a).intValue();
        }
        return ans;
    }

    /*
     * returns true if all the collection sets in s form a partition of x
     *         you may assume that x is a universal set.
     *         
     *         You might have to look up the definition of a partition and 
     *            use the Set API to figure out how to use a Set
     */
    public boolean isPartition(Set<int[]> s)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Iterator<int[]> iterator = s.iterator();
        while(iterator.hasNext())
        {
            int[] set = iterator.next();
            if(set.length == 0)
            {
                return false;
            }
            for(int a = 0; a < set.length; a++)
            {
                if(list.contains(set[a]))
                {
                    return false;
                }
                boolean flag = false;
                for(int b = 0; b < x.length; b++)
                {
                    if(x[b] == set[a])
                    {
                        flag = true;
                        break;
                    }
                }
                if(!flag)
                {
                    return false;
                }
                list.add(set[a]);
            }
        }
        return list.size() == x.length;
    }
}