import java.io.*;
import java.util.Arrays;

public class SongFileReader {
	protected SongTable table;

	public SongFileReader(SongTable table) {
		String fileName = "TaggedSongs.txt";
		this.table = table;
		try {
			FileReader reader = new FileReader(fileName);
			BufferedReader buffReader = new BufferedReader(reader);
			parseFile(buffReader);
			buffReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void parseFile(BufferedReader reader) {
		String line = null;
		String[] splitLine = new String[2];
		int i = 0;
		boolean isClean = false;
		try {
			while ((line = reader.readLine()) != null) {
				// use a regex to parse song info
				splitLine = line.split(", ");
				if (splitLine[1].equals("Clean")) {
					isClean = true;
				} else {
					isClean = false;
				}
				table.addSong(splitLine[0], isClean);
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
