import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Class to write list of words to a file.
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
	 * Opens the file specified by filename and writes each String in the given list of Strings to the file.
	 * Each String is written to a new line.
	 *
	 * Example:
	 * - Calling writeToFile(ArrayList<String> words) will open the file, then write each String in the 
	 * given list of Strings to the file.  
	 * Writing the course info and the additional personal info to the file will be in this format.
	 * 
	 * CourseName: MCIT_590
	 * CourseID: 590
	 * StudentID: 101
	 * Name: Tianshi
	 * FavoriteColor: White
	 * FavoriteNumber: 7
	 * 
	 * (For an example of the format of the output file, reference "example_output.txt")
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
