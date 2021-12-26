package search;

import java.util.Optional;

public interface Search<T extends Comparable<T>> {

    Optional<Integer> find(T[] items, T item);

}
