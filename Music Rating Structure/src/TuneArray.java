import java.util.Iterator;

public class TuneArray implements ListInterface<Tune>{
	
	//Constants
	private final int DEFAULT_CAPACITY = 5;
	private final int ELEMENTS_TO_ADD = 30;
	
	//Instance Variable
	private static Tune[] data;
	private static int size;
	
	//Creating a new array for the Tunes
	public TuneArray() {
		clear();
	}
	
	@Override //Adding to the end of the array in time O(1)
	public boolean add(Tune tune) {
		add(size(), tune);
		return true;
	}


	@Override //Adding at specific index in array in time O(n)
	public void add(int index, Tune tune) {
		checkBounds(index);
		ensureCapacity();

		for (int i = size(); i > index; i--) {
			data[i] = data[i-1];
		}
		
		data[index] = tune;
		size++;
	}

	@Override //Removing specific Song in time O(n)
	public boolean remove(Tune tune) {
		int location = indexOf(tune);

		if (location == -1) {
			return false;
		} else {
			remove(location);
			return true;
		}
	}

	@Override //Removing at specific index in time O(n)
	public Tune remove(int index) {
		checkBounds(index);
		Tune removed = data[index];

		for (int i = index; i <= size() - 1; i++) {
			data[i] = data[i + 1];
		}
		
		size--;
		data[size()] = null;
		return removed;
	}

	@Override //Clearing the SongArray
	public void clear() {
		size = 0;
		data = (new Tune[DEFAULT_CAPACITY]);
	}

	@Override //Checks to see if the SongArray contains Song in time O(n)
	public boolean contains(Object tune) {
		if(indexOf(tune) == -1) {
			return false;
		} else {
			return true;
		}
	}

	@Override //Gets Song in time O(1)
	public Tune get(int index) {
		checkBounds(index);
		return data[index];
	}

	@Override //Finds the index of a specific Song in time O(n)
	public int indexOf(Object tune) {
		for (int i = 0; i <= size(); i++) {
			if (data[i] == tune) {
				return i;
			}
		}
		return -1;
	}

	@Override //Checks to see if the SongArray is empty
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override //Iterator to iterate through the SongArray
	public Iterator<Tune> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override //Sets a specific song in the specified index in time O(1)
	public Tune set(int index, Tune tune) {
		checkBounds(index);
		data[index] = tune;
		return tune;
	}

	@Override //Returns the size of the SongArray
	public int size() {
		return size;
	}

	//Converts into readable strings
	public String toString() {
		System.out.println("Song: " + data[0].tuneToString() + "--"
				+ "\nAlbum: " + album.getName() + "--"
				+ "\nAuthor: " + author.getName() + "--"
				+ "\nGenre: " + genre.getName() + "--"
				+ "\nLength: " + length.getTime() + "--"
				+ "\nRating: " + rating.getRating() + "--");
			}	
		}
	}

	//Ensures the array is not full and has room
	public void ensureCapacity() {
		if (size() >= data.length) {
			Tune[] newData = new Tune[data.length + ELEMENTS_TO_ADD];

			for(int i = 0; i <= size(); i++) {
				newData[i] = data[i];
			}
			data = newData;
		}
	}

	//Checks to see if the index is out of bounds
	public void checkBounds(int index) throws IndexOutOfBoundsException {
		if (index > size()) {
			throw new IndexOutOfBoundsException("The specified index " + index + " is undefined within this structure.");
		}	
	}

	@Override
	public boolean addAll(ListInterface<? extends Tune> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int arg0, ListInterface<? extends Tune> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(ListInterface<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean removeAll(ListInterface<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(ListInterface<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ListInterface<Tune> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
}