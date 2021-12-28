import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Class to write a list of words to a file.
 */
public class MyFileWriter {
	
	/**
	 * Name of file being written to.
	 */
	private String filename;
	
	/**
	 * Creates MyFileWriter with given filename to write to.
	 * @param filename to write to
	 */
	public MyFileWriter(String filename) {
		this.filename = filename;
	}
	
	/**
	 * Opens the file specified by filename and writes each word in the given list of words to the file.
	 * Each word is written to a new line in the file.
	 *
	 * Example(s):
	 * - If the given list of words contains: "a", "he", "in", "of", "to"
	 * Calling writeToFile(ArrayList<String> words) will open the file, then write each word in the 
	 * given list of words to the file, in the following format:
	 * a
	 * he
	 * in
	 * of
	 * to
	 * 
	 * @param list of words to write to the file
	 */
	public void writeToFile(ArrayList<String> words) {
		
		//create file object
		File file = new File(filename);
		
		//define file writer
		FileWriter fileWriter = null;
		
		//define print writer
		PrintWriter printWriter = null;
		
		try {
			fileWriter = new FileWriter(file, false);
			printWriter =  new PrintWriter(fileWriter);
			
			//iterate over arraylist of values and write each one to file
			for (String word : words) {
				printWriter.println(word);
			}
			
			//flush memory
			printWriter.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//regardless of what happens, close file objects
			try {
				fileWriter.close();
				printWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}