//Class containing highest object "Tune"

public class Tune {
	
	private static Song song;				//Name of the Song
	private static Album album;				//Name of the Album
	private static Author author;			//Name of the Author
	private static Genre genre;				//Name of the Genre
	private static Length length;			//Length of the Song
	private static Rating rating;			//Overall rating of the Song
	
	//Creating new Tune through all of the objects
	public Tune() {
		song = new Song();					//Initializing the Song name
		album = new Album();				//Initializing the Album name
		author = new Author();				//Initializing the Author name
		genre = new Genre();				//Initializing the Genre
		length = new Length();				//Initializing the Song length
		rating = new Rating();				//Initializing the Song rating
	}
	
	//Creating new Tune through a painful initialization process
	public Tune(Song song, Album album, Author author, Genre genre, Length length, Rating rating, double creativity, double harmonics, double lyrics, double production, double originality) {
		Tune.song = song;
		Tune.album = album;
		Tune.author = author;
		Tune.genre = genre;
		Tune.length = length;
		Tune.rating = new Rating(creativity, harmonics, lyrics, production, originality);
	}
	
	//Gets the Tunes Song name
	public String getSong() {
		return song.getName();
	}
	
	//Gets the Tunes Album name
	public String getAlbum() {
		return album.getName();
	}
	
	//Gets the Tunes Authors name
	public String getAuthor() {
		return author.getName();
	}
	
	//Gets the Tunes Genre
	public String getGenre() {
		return genre.getName();
	}
	
	//Gets the Tunes Length in seconds
	public int getLength() {
		return length.getTime();
	}
	
	//Gets the final rating of the song out of 40
	public double getFinalRating() {
		return rating.getRating();
	}
	
	//Sets the Tunes Song name
	public boolean setSong(String name) {
		song.setName(name);
		return song.getName() == name;
	}
	//Sets the Tunes Album name
	public boolean setAlbum(String name) {
		album.setName(name);
		return album.getName() == name;
	}
	
	//Sets the Tunes Authors name
	public boolean setAuthor(String name) {
		author.setName(name);
		return author.getName() == name;
	}
	
	//Sets the Tunes Genre
	public boolean setGenre(String name) {
		genre.setName(name);
		return genre.getName() == name;
	}
	
	
	//Sets the Tunes Length in seconds
	public boolean setLength(int time) {
		length.setTime(time);
		return length.getTime() == time;
	}
	
	//Sets the Tunes length in seconds and minutes
	public boolean setLength(int seconds, int minutes) {
		length.setTime(seconds, minutes);
		return length.getTime() == (minutes * 60 + seconds);
	}
	
	//Sets the final rating of the Tune
	public String setFinalRating(double creativity, double harmonics, double lyrics, double production, double originality) {
		rating = new Rating(creativity, harmonics, lyrics, production, originality);
		return rating.toString();
	}

}
