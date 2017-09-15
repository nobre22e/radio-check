import java.util.HashMap;

public class SongTable {
	protected HashMap<String, Boolean> songMap = new HashMap<>();

	public SongTable() {
	}

	// all instances of song use .toLowerCase() so that weird case uses won't interfere with application use
	
	public void addSong(String song, boolean isClean) {
		songMap.put(song.toLowerCase(), isClean);
	}

	public boolean getSong(String title, String artist) {
		// concat title and artist
		String song = title + " - " + artist;
		return songMap.get(song.toLowerCase());
	}
	
	public boolean hasSong(String title, String artist){
		// concat title and artist
		String song = title + " - " + artist;
		return songMap.containsKey(song.toLowerCase());
	}

}
