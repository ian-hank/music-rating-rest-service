public class WorkBench {
	public static void main(String[] args) {
		
		//Getting new tune
		Tune tune = new Tune();
		tune.setSong("Song Number 1");
		tune.setAuthor("Ian Hank");
		tune.setAlbum("BIG BOI");
		tune.setGenre("Dubstep");
		tune.setLength(2345);
		tune.setFinalRating(7, 5, 3, 8, 2);
		
		Tune tune2 = new Tune();
		tune2.setSong("Song Number 2");
		tune2.setAuthor("I fixed");
		tune2.setAlbum("the problem");
		tune2.setGenre("in the code");
		tune2.setLength(222);
		tune2.setFinalRating(10, 10, 10, 10, 10);
		
		Tune tune3 = new Tune();
		tune3.setSong("Song Number 3");
		
		Tune tune4 = new Tune();
		tune4.setSong("Song Number 4");

		Tune tune5 = new Tune();
		tune5.setSong("Song Number 5");
		
		Tune tune6 = new Tune();
		tune6.setSong("Song Number 6");
		
		Tune tune7 = new Tune();
		tune7.setSong("Song Number 7");
		
		//Creating TuneArray
		TuneArray data = new TuneArray();
		
		//Managing Array Testing
		data.add(tune);
		data.add(tune2);
		data.add(tune3);
		data.add(tune4);
		data.add(tune5);
		data.add(tune6);
		data.add(tune7);
		
		data.remove(tune2);
		data.remove(tune6);
		
		data.add(tune2);
		data.add(tune6);
		
		
		
		//PrintStream for results
		//System.out.println(tune.tuneToString() + "\n" + tune2.tuneToString());
		//data.toString();
		System.out.println(data.size());
		data.printQuickTunes();
		
	}
}
