import java.lang.Comparable;

public class GenericMethods implements GenericMethodsInterface {

    public <AnyType extends Comparable<AnyType>> int linearSearch(
            AnyType[] a, AnyType x) 
    {
        for (int i = 0; i < a.length; i++) {
            if (a[i].compareTo(x) == 0)
                return i;
        }
        return -1;
    }
    
    public <AnyType extends Comparable<AnyType>> int binarySearch(
            AnyType[] a, AnyType x) 
    {
        return binarySearchHelper(a, x, 0, a.length-1);
    }

    private <AnyType extends Comparable<AnyType>> int binarySearchHelper(
            AnyType[] a, AnyType x, int min, int max) 
    {
        // base
        if (min > max)
            return -1;

        int mid = (min + max) / 2;

        if (a[mid].compareTo(x) < 0)
            return binarySearchHelper(a, x, mid+1, max);
        else if (a[mid].compareTo(x) > 0)
            return binarySearchHelper(a, x, min, mid-1);
        return mid;
    }
}
