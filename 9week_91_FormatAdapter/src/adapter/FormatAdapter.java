package adapter;

public class FormatAdapter implements MediaPlayer {

	private VideoPlayer media;
	
	public FormatAdapter(VideoPlayer m) {
		media = m;
	}
	
	@Override
	public void play(String filename) {
		System.out.print("Using Adapter --> ");
		media.playFile(filename);
	}

}
