import java.util.Iterator;

public interface ListInterface<E> extends Iterable<E>{

	boolean add(E arg0);

	void add(int arg0, E arg1);

	boolean addAll(ListInterface<? extends E> arg0);

	boolean addAll(int arg0, ListInterface<? extends E> arg1);

	void clear();

	boolean contains(Object arg0);

	boolean containsAll(ListInterface<?> arg0);

	E get(int arg0);

	int indexOf(Object arg0);

	boolean isEmpty();

	Iterator<E> iterator();

	int lastIndexOf(Object arg0);

	boolean remove(E arg0);

	E remove(int arg0);

	boolean removeAll(ListInterface<?> arg0);

	boolean retainAll(ListInterface<?> arg0);

	E set(int arg0, E arg1);

	int size();

	ListInterface<E> subList(int arg0, int arg1);

	Object[] toArray();


}
