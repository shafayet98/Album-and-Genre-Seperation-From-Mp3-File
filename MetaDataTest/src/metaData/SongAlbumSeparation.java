package metaData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SongAlbumSeparation  {

	public List<String> songPath = new ArrayList<String>();

	public SongAlbumSeparation() {
		addSong();
	}

	public void addSong() {

		songPath.add("A://song//Daughter//Albums//2013 - If You Leave (Japanese Edition)//02. Smother.mp3");
		songPath.add("A://song//Daughter//Albums//2013 - If You Leave (Japanese Edition)//01. Winter.mp3");
		songPath.add("A://song//Daughter//Albums//2013 - If You Leave (Japanese Edition)//05. Lifeforms.mp3");

	}

	public void addSongTest() {
		
		
		for(String path: songPath )
		try {

			InputStream input = new FileInputStream(new File(path));
			ContentHandler handler = new DefaultHandler();
			Metadata metadata = new Metadata();
			Mp3Parser parser = new Mp3Parser();
			ParseContext parseCtx = new ParseContext();
			try {
				parser.parse(input, handler, metadata, parseCtx);
			} catch (TikaException e) {
				
				e.printStackTrace();
			}
			input.close();

			System.out.println("Title: " + metadata.get("title"));
			System.out.println("Artist: " + metadata.get("xmpDM:artist"));
			System.out.println("Composer: " + metadata.get("xmpDM:composer"));
			System.out.println("Genre: " + metadata.get("xmpDM:genre"));
			System.out.println("Album: " + metadata.get("xmpDM:album"));
			System.out.println();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

	}

}
