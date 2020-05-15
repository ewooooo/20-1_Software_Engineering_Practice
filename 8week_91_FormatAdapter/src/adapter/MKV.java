package adapter;

public class MKV implements VideoPlayer{
	
	@Override
	public void playFile(String filename) {
		System.out.println("Playing MKV File " + filename);
	}
}
