public class WorkBench {
	public static void main(String[] args) {
		
		//Getting new tune
		Tune tune = new Tune();
		tune.setSong("Hello Song");
		tune.setAuthor("Ian Hank");
		tune.setAlbum("BIG BOI");
		tune.setGenre("Dubstep");
		tune.setLength(2345);
		tune.setFinalRating(7, 5, 3, 8, 2);
		
		Tune tune2 = new Tune();
		tune2.setSong("Well Look");
		tune2.setAuthor("I fixed");
		tune2.setAlbum("the problem");
		tune2.setGenre("in the code");
		tune2.setLength(222);
		tune2.setFinalRating(10, 10, 10, 10, 10);
		
		
		//PrintStream for results
		System.out.println(tune.tuneToString() + "\n" + tune2.tuneToString());
		
		//Creating TuneArray
		TuneArray data = new TuneArray();
		
		//Managing Array Testing
		data.add(tune);
		data.add(tune2);
		data.toString();
		data.printTunes();
		
	}
}
