import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyFileWriterTest {
	
	MyFileWriter myFileWriter1; 
	
	@BeforeEach
	void setUp() throws Exception {
		this.myFileWriter1 = new MyFileWriter("output_test.txt");  // test output file
	}
	
	@Test
	public void testWriteToFile() {
		
		// 1 test case using myFileWriter1
		ArrayList<String> writeArray = new ArrayList<String>();
		writeArray.add("Hello");
		writeArray.add("world");
		writeArray.add("Python");
		writeArray.add("Java");
		
		myFileWriter1.writeToFile(writeArray);
		
		ArrayList<String> readArray = this.readWrittenFile("output_test.txt");
		
		assertEquals(writeArray, readArray);
		
	}
	
	/**
	 * Helper method for reading in the written file to check its contents.
	 * @param writtenFilename 
	 * @return an ArrayList of the lines from the written file
	 */
	public ArrayList<String> readWrittenFile(String writtenFilename) {
		ArrayList<String> expectedLines = new ArrayList<String>();
		try {
			BufferedReader file = new BufferedReader(new FileReader(writtenFilename));
			String line = file.readLine();
			while (line != null) {
				expectedLines.add(line);
				line = file.readLine();
			}
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return expectedLines;
	}
}