public interface GenericMethodsInterface {
	
	public <T extends Comparable<T>> int binarySearch(T[] a, T x);
	public <T extends Comparable<T>> int linearSearch(T[] a, T x);
}
