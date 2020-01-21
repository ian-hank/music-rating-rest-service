import java.util.Iterator;

public class ArrayList implements ListInterface<Tune>{
	
	//Constants
	private final int DEFAULT_CAPACITY = 5;
	private final int ELEMENTS_TO_ADD = 30;
	
	//Instance Variable
	private static Song[] data;
	private static int size;
	
	//Creating a new array for the Tunes
	public ArrayList() {
		clear();
	}
	
	@Override	//Adding a tune to the end of the array
	public boolean add(Tune tune) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(int index, Tune tune) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(ListInterface FILL_IN) {
		// TODO Finish Method
		return false;
	}

	@Override
	public boolean addAll(int index, ListInterface FILL_IN) {
		// TODO Finish Method
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Create proper contains(Tune tune) and naming
		return false;
	}

	@Override
	public boolean containsAll(ListInterface FILL_IN) {
		// TODO Finish Method
		return false;
	}

	@Override
	public Tune get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object arg0) {
		// Create proper contains(Tune tune) and naming
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Finish Method
		return null;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Create proper contains(Tune tune) and naming
		return 0;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Create proper contains(Tune tune) and naming
		return false;
	}

	@Override
	public Tune remove(int index) {
		// TODO Create proper contains(Tune tune) and naming
		return null;
	}

	@Override
	public boolean removeAll(ListInterface FILL_IN) {
		// TODO Finish Method
		return false;
	}

	@Override
	public boolean retainAll(ListInterface FILL_IN) {
		// TODO Finish Method
		return false;
	}

	@Override
	public Tune set(int index, Tune tune) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListInterface subList(int arg0, int arg1) {
		// TODO Finish Method
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Finish Method
		return null;
	}
	
}
