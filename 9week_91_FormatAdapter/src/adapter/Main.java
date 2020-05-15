package adapter;

public class Main {
	public static void main(String[] args) {
		
		MediaPlayer player = new MP3();
	    player.play("file.mp3");
	    
	    VideoPlayer vPlayer = new MP4();
	    player = new FormatAdapter(vPlayer);
	    player.play("file.mp4");
	    
	    vPlayer = new MKV();
	    player = new FormatAdapter(vPlayer);
	    player.play("file.mkv");
		
	}
}
