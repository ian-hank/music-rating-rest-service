
public class WorkBench {
	public static void main(String[] args) {
		
		Song song = new Song("Hello World");
		Album album = new Album("New Heights");
		Author author = new Author("Ian C Hank");
		Genre genre = new Genre("Dance");
		Length length = new Length(143);
		double creativity = 8;
		double harmonics = 6;
		double lyrics = 5;
		double production = 9;
		double originality = 10;
		Rating rating = new Rating(creativity, harmonics, lyrics, production, originality);
		
		//Getting new tune
		Tune setTune = new Tune();
		Tune tune = new Tune();
		
		//PrintStream for results
		setTune.tuneToString();
		tune.tuneToString();
		
		//Creating TuneArray
		TuneArray data = new TuneArray();
		
		//Managing Array Testing
		data.add(tune);
		data.add(setTune);
		
	}
}
