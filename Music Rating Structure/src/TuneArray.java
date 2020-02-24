import java.util.Iterator;

public class TuneArray {
	
	//Constants
	private final int DEFAULT_CAPACITY = 1;			//Starting capacity of the array
	private final int ELEMENTS_TO_ADD = 1;			//How many elements to add when full
	
	//Instance Variable
	private static Tune[] data;
	private static int size;
	
	//Creating a new array for the Tunes
	public TuneArray() {
		clear();
	}
	
	//Adding to the end of the array in time O(1)
	public boolean add(Tune tune) {
		ensureCapacity();
		data[size()] = tune;
		size++;
		
		return (data[size() - 1] == tune);
	}

	//Add in order of rating
	public boolean addInPlace(Tune tune) {
		//TODO Organized add method by rating
		size++;
		return false;
	}

	//Removing specific Song in time O(n)
	public boolean remove(Tune tune) {
		if (contains(tune)) {
			int removed = indexOf(tune);
			data[removed] = null;
			//Shifting elements to leave no blank space
			for (int j = removed; j != size() - 1; j++) {
				data[j] = data[j + 1];
			}
			return true;
		} else {
			size--;
			return false;
		}
	}

	//Clearing the SongArray
	public void clear() {
		size = 0;
		data = (new Tune[DEFAULT_CAPACITY]);
	}

	//Checks to see if the SongArray contains Song in time O(n)
	public boolean contains(Tune tune) {
		return indexOf(tune) != -1;
	}

	//Gets Song in time O(1)
	public Tune get(int index) {
		checkBounds(index);
		return data[index];
	}

	//Finds the index of a specific Song in time O(n)
	public int indexOf(Tune tune) {
		for (int i = 0; i <= size() - 1; i++) {
			if (data[i] == tune) {
				return i;
			}
		}
		return -1;
	}

	//Checks to see if the SongArray is empty
	public boolean isEmpty() {
		return size() == 0;
	}

	//Iterator to iterate through the SongArray
	public Iterator<Tune> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	//Sets a specific song in the specified index in time O(1)
	public Tune set(int index, Tune tune) {
		checkBounds(index);
		data[index] = tune;
		return tune;
	}

	//Returns the size of the SongArray
	public int size() {
		return size;
	}

	//Converts into readable strings
	public void printQuickTunes() {
		System.out.print("---> ");
		for (int i = 0; i != size(); i++) {
			if (data[i] != null) {
				System.out.print("[" + data[i].getSong() + "] " );
			}
		}
	}

	//Ensures the array is not full and has room
	public void ensureCapacity() {
		if (size() >= data.length) {
			//Creating new array and copying old elements into the new one
			Tune[] newData = new Tune[size() + ELEMENTS_TO_ADD];
			for (int i = 0; i < size(); i++) {
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
}