//Class containing highest object "Tune"

public class Tune {
	
	private String song;				//Name of the Song
	private String album;			//Name of the Album
	private String author;			//Name of the Author
	private String genre;			//Name of the Genre
	private int length;				//Length of the Song
	private Rating rating;			//Overall rating of the Song
	
	//Creating new Tune through all of the objects
	public Tune() {
		this.song = "" ;					//Initializing the Song name
		this.album = "" ;				//Initializing the Album name
		this.author = "" ;				//Initializing the Author name
		this.genre = "" ;				//Initializing the Genre
		this.length = 0;					//Initializing the Song length
		this.rating = new Rating();		//Initializing the Song rating
	}
	
	//Creating new Tune through a painful initialization process
	public Tune(String song, String album, String author, String genre, int length, Rating rating,
			double creativity, double harmonics, double lyrics, double production, double originality) {
		this.song = song;
		this.album = album;
		this.author = author;
		this.genre = genre;
		this.length = length;
		this.rating = new Rating(creativity, harmonics, lyrics, production, originality);
	}
	
	//Gets the Tunes Song name
	public String getSong() {
		return this.song;
	}
	
	//Gets the Tunes Album name
	public String getAlbum() {
		return this.album;
	}
	
	//Gets the Tunes Authors name
	public String getAuthor() {
		return this.author;
	}
	
	//Gets the Tunes Genre
	public String getGenre() {
		return this.genre;
	}
	
	//Gets the Tunes Length in seconds
	public int getLength() {
		return this.length;
	}
	
	//Gets the final rating of the song out of 40
	public double getFinalRating() {
		return rating.getRating();
	}
	
	//Sets the Tunes Song name
	public boolean setSong(String name) {
		this.song = name;
		return this.song == name;
	}
	//Sets the Tunes Album name
	public boolean setAlbum(String name) {
		this.album = name;
		return this.album == name;
	}
	
	//Sets the Tunes Authors name
	public boolean setAuthor(String name) {
		this.author = name;
		return this.author == name;
	}
	
	//Sets the Tunes Genre
	public boolean setGenre(String name) {
		this.genre = name;
		return this.genre == name;
	}
	
	
	//Sets the Tunes Length in seconds
	public boolean setLength(int time) {
		this.length = time;
		return this.length == time;
	}
	
	//Sets the final rating of the Tune
	public String setFinalRating(double creativity, double harmonics, double lyrics, double production, double originality) {
		rating = new Rating(creativity, harmonics, lyrics, production, originality);
		return rating.toString();
	}
	
	//Converts Tune to a readable string
	public String tuneToString() {
		String finalName = ("Song: " + this.song + "--"
				+ "\nAlbum: " + this.album + "--"
				+ "\nAuthor: " + this.author + "--"
				+ "\nGenre: " + this.genre + "--"
				+ "\nLength: " + this.length + "--"
				+ "\nRating: " + rating.getRating() + "--");
		return finalName;
	}	
}
