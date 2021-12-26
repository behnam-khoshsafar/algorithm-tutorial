package sort;

public interface Sort<T extends Comparable<T>> {

    T[] sort(T[] items);

}
