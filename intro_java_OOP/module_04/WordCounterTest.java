import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordCounterTest {

	MyFileReader fr1;
	MyFileReader fr2;
			
	@BeforeEach
	void setUp() throws Exception {
	
		// original war_and_peace.txt file
		fr1 = new MyFileReader("war_and_peace.txt");
				
		// test file containing some text from war_and_peace.txt, with different characters and info
		fr2 = new MyFileReader("test1.txt");
	}
	
	@Test
	void testWordCounter() {
		
		// Get clean lines from test1.txt
		ArrayList<String> linesSol = fr2.getCleanContent();
		
		// Create new Word Counter
		WordCounter wc = new WordCounter(linesSol);
		
		// Get map of words and counts 
		Map<String, Integer> counters = wc.getWordCounter();

		// Test the count of different words in map
		assertEquals(1, (int) counters.get("Gutenberg"));
		assertEquals(3, (int) counters.get("and"));
		
				
		// Get clean lines from war_and_peace.txt
		linesSol = fr1.getCleanContent();
		
		// Create new Word Counter
		wc = new WordCounter(linesSol);
		
		// Get map of words and counts 
		counters = wc.getWordCounter();

		// Test the count of different words in map
		int atCount = counters.get("at");
		System.out.println("atCount: " + atCount);
		assertTrue(atCount >= 3700 & atCount <= 4700);
		
		int inCount = counters.get("in");
		System.out.println("inCount: " + inCount);
		assertTrue(inCount >= 7700 & inCount <= 8700);
		
		assertEquals((int) counters.getOrDefault("adasdada", 0), 0);
		assertEquals((int) counters.getOrDefault(" ", 0), 0);
		
		
		// 3 additional test cases
		assertEquals((int) counters.getOrDefault("ROAH LEE", 0), 0);
		assertEquals((int) counters.getOrDefault("verhuizen", 0), 0);
		assertEquals((int) counters.get("Tolstoy"), 2);


	}
	
	@Test
	void testGetWordsOccuringMoreThan() {
		
		// Create new FileReader
		MyFileReader fr = new MyFileReader("war_and_peace.txt");
		
		// Get clean lines from the File
		ArrayList<String> linesSol = fr.getCleanContent();
		
		// Create new Word Counter
		WordCounter wc = new WordCounter(linesSol);
		
		// Get words occurring more than 0 times
		ArrayList<String> ls1 = wc.getWordsOccuringMoreThan(0);
		System.out.println("ls1: " + ls1.size());
		assertTrue(ls1.size() >= 41400 & ls1.size() <= 42400);
		
		// Get words occurring more than 1000 times
		ArrayList<String> ls2 = wc.getWordsOccuringMoreThan(1000);
		System.out.println("ls2: " + ls2.size());
		assertTrue(ls2.size() >= 50 & ls2.size() <= 60);
		
		// Get words occurring more than 10000 times
		ArrayList<String> ls3 = wc.getWordsOccuringMoreThan(10000);
		System.out.println("ls3: " + ls3.size());
		assertTrue(ls3.size() >= 4 & ls3.size() <= 6);
		assertEquals(ls3.get(0), "a");
		assertEquals(ls3.get(1), "of");
		
		
		// 3 additional test cases 
		ArrayList<String> ls4 = wc.getWordsOccuringMoreThan(-100);
		System.out.println("ls4: " + ls4.size());
		assertTrue(ls4.size() >= 41000);

		ArrayList<String> ls5 = wc.getWordsOccuringMoreThan(9999999);
		assertEquals(ls5.size(), 0);
		
		ArrayList<String> ls6 = wc.getWordsOccuringMoreThan(500);
		System.out.println("ls6: " + ls6.size());
		assertTrue(ls6.size() >= 120);
		
		
	}
	
	@Test
	void testGenerateWordCounts() {
		// lines to count words
		ArrayList<String> lines = new ArrayList<String>();
		lines.add("war and the");
		lines.add("war the peace peace");
		lines.add("the war the");
		
		Map<String, Integer> expectedCounts = new HashMap<String, Integer>();
		expectedCounts.put("war", 3);
		expectedCounts.put("and", 1);
		expectedCounts.put("the", 4);
		expectedCounts.put("peace", 2);
		
		// Create new Word Counter
		WordCounter wc = new WordCounter(lines);
		
		// Get and test map of words and counts
		assertEquals(expectedCounts, wc.getWordCounter());
		
		
		// TODO write at least 3 additional test cases
		// liens to count words
		ArrayList<String> lines2 = new ArrayList<String>();
		lines2.add("Never gonna give you up");
		lines2.add("Never gonna let you down");
		
		Map<String, Integer> expectedCounts2 = new HashMap<String, Integer>();
		expectedCounts2.put("Never", 2);
		expectedCounts2.put("gonna", 2);
		expectedCounts2.put("you", 2);
		expectedCounts2.put("give", 1);
		expectedCounts2.put("let", 1);
		expectedCounts2.put("up", 1);
		expectedCounts2.put("down", 1);
		
		// Create new Word Counter
		WordCounter wc2 = new WordCounter(lines2);
		
		assertEquals(expectedCounts2, wc2.getWordCounter());
		assertTrue(expectedCounts2.get("Never") > 1);
		assertTrue(expectedCounts2.get("gonna") > 0);
		
	}

}