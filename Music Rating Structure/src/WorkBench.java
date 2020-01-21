
public class WorkBench {
	public static void main(String[] args) {
		
		//Getting new tune
		Tune tune = new Tune();
		
		//Creating TuneArray
		TuneArray data = new TuneArray();
		
		//Managing Array Testing
		data.add(tune);
		
		//PrintStream for results
		tune.tuneToString();
	}
}
