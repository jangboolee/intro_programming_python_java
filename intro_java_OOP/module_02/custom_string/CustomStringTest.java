package customString;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomStringTest {

	//declare custom string for testing
	CustomString myCustomString;

	@BeforeEach
	public void setUp() throws Exception {
		//initialize custom string for testing
		this.myCustomString = new CustomString();
	}

	@Test
	void testGetString() {
		
		//string should be null to start, before setting it
		assertNull(this.myCustomString.getString());
		
		this.myCustomString.setString("hello");
		assertEquals("hello", this.myCustomString.getString());
		
		// 3 additional test cases
		this.myCustomString.setString(null);
		assertNull(this.myCustomString.getString());
		
		this.myCustomString.setString("");
		assertEquals("", this.myCustomString.getString());
		
		this.myCustomString.setString("Java is complicated, coming from Python");
		assertEquals("Java is complicated, coming from Python", this.myCustomString.getString());

	}
	
	@Test
	void testSetString() {
		
		//string should be null to start, before setting it
		assertNull(this.myCustomString.getString());
		
		this.myCustomString.setString("Good-bye!");
		assertEquals("Good-bye!", this.myCustomString.getString());
		
		// 3 additional test cases 
		this.myCustomString.setString(null);
		assertFalse(this.myCustomString.isSet);
		assertNull(this.myCustomString.getString());
		
		this.myCustomString.setString("Java is complicated, coming from Python");
		assertEquals("Java is complicated, coming from Python", this.myCustomString.getString());
	}
	
	@Test
	void testRemove() {
		assertEquals("", this.myCustomString.remove(""));
		
		this.myCustomString.setString(null);
		assertEquals("", this.myCustomString.remove(""));
		
		this.myCustomString.setString("my lucky numbers are 6, 8, and 19.");
		assertEquals("my lucky numbes e 6, 8, nd 19.", this.myCustomString.remove("ra6"));
		
		// 3 additional test cases 
		assertEquals("my lucky numbers are 6, 8, and 19.", this.myCustomString.remove("6.,"));
		
		this.myCustomString.setString("Python is much simpler than Java, don't you think?");
		assertEquals("ython s much smler than Java, don't you thnk?", this.myCustomString.remove("PI"));
		assertEquals("ython s much smler than Java, don't you thnk?", this.myCustomString.remove("pi"));
		
	}

	@Test
	void testReverse() {
		
		assertEquals("", this.myCustomString.reverse(""));
		
		this.myCustomString.setString(null);
		assertEquals("", this.myCustomString.reverse(""));
		
		this.myCustomString.setString("abc, XYZ; 123.");
		assertEquals("aBC, xyz; 123.", this.myCustomString.reverse("bcdxyz@3210."));
		
		// 3 additional test cases
		assertEquals("abc, XYZ; 123.", this.myCustomString.reverse("6,."));
		assertEquals("abc, XYZ; 123.", this.myCustomString.reverse(""));
		assertEquals("ABC, xyz; 123.", this.myCustomString.reverse("abcXYZ"));
	}

	@Test
	void testFilterLetters() {
		assertEquals("", this.myCustomString.filterLetters('E', false));
		
		this.myCustomString.setString(null);
		assertEquals("", this.myCustomString.filterLetters('E', false));
		
		// 3 additional test cases 
		this.myCustomString.setString("Hello 90, bye 2");
		assertEquals("llo 90, y 2", this.myCustomString.filterLetters('h', false));
		assertEquals("e 90, be 2", this.myCustomString.filterLetters('h', true));
		
		this.myCustomString.setString("Abcdefg");
		assertEquals("Ab", this.myCustomString.filterLetters('c', true));
	}

}
