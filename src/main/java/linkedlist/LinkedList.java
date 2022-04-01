package linkedlist;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LinkedList {

    public static <E> void removeDuplicate(List<E> list) {
        if (list == null || list.isEmpty())
            return;
        Set<E> tempSet = new HashSet<>();
        Iterator<E> iterator = list.iterator();
        while (iterator.hasNext()) {
            E next = iterator.next();
            if (tempSet.contains(next))
                iterator.remove();
            tempSet.add(next);
        }
    }
}