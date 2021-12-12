package customString;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;
import java.util.regex.Pattern;

/**
 * In this assignment, you will implement a simple class called CustomString.  This class represents a more customizable version 
 * of a String, with additional attributes and methods.  
 * For example, the CustomString class has a “reverse” method which returns a new string version of the current string where the 
 * capitalization is reversed (i.e., lowercase to uppercase and uppercase to lowercase) for the alphabetical characters specified 
 * in the given arg.  For CustomString “abc, XYZ; 123.”, calling reverse("bcdxyz@3210.") will return "aBC, xyz; 123.".  
 * 
 * The CustomString class also has a “remove” method which returns a new string version of the current string where the alphabetical 
 * characters specified in the given arg, are removed.  For CustomString "my lucky numbers are 6, 8, and 19.", calling remove("ra6") 
 * will return "my lucky numbes e 6, 8, nd 19.".
 * 
 */
public class CustomString {
	
	//instance variables
	
	/**
	 * Current string.
	 */
	String myString;
	
	/**
	 * Indicates if the current string myString has been set (not null).
	 */
	boolean isSet;
	
	//constructor
	
	/**
	 * Initializes current string myString to null.
	 * Initializes isSet to false.
	 */
	public CustomString() {
		this.myString = null;
		this.isSet = false;
	}

	// methods 
	
    /**
     * Returns the current string.
     * If the current string is null, or has not been set to a value with setString, it should return null.
     * @return current string
     */
	public String getString() {
		if (this.myString == null || this.isSet == false) {
			return null;
		}
		else {
			return this.myString;
		}
		
	}

	/**
     * Sets the value of the current string and sets this.isSet to true.
     * If the given string is null, sets this.isSet to false.
     * @param string value to be set
     */
	public void setString(String string) {
		if (string == null) {
			this.isSet = false;
		}
		else {
			this.myString = string;
			this.isSet = true;
		}
	}

    /**
     * Returns a new string version of the current string where the alphabetical characters specified in the given arg, are removed.
     *   
     * The alphabetical characters to be removed are case insensitive.  
     * All non-alphabetical characters are unaffected.
     * If the current string is null, empty, or has not been set to a value, this method should return an empty string.
     *
     * Example(s):
     * - For a current string "my lucky numbers are 6, 8, and 19.", calling remove("ra6") would return "my lucky numbes e 6, 8, nd 19."
     * - For a current string "my lucky numbers are 6, 8, and 19.", calling remove("6,.") would return "my lucky numbers are 6, 8, and 19."
     * - For a current string "my lucky numbers are 6, 8, and 19.", calling remove("") would return "my lucky numbers are 6, 8, and 19."
     * 
     * Remember: This method builds and returns a new string, and does not directly modify the myString field.
     * 
     * @param arg the string containing the alphabetical characters to be removed from the current string
     * @return new string in which the alphabetical characters specified in the arg are removed
     */
	public String remove(String arg) {
		
		// Get a string of the alphabetical characters in arg, converted to lowercase
		String removeString = "";
		for (int i = 0; i < arg.length(); i++) {
			char ch = arg.charAt(i);
			if (Character.isLetter(ch)) {
				removeString += Character.toLowerCase(ch);
			}
		}
		
		// Convert removeString to an array of characters
		char[] removeChars = removeString.toCharArray();
		
		// If the current string is null, empty, or has not been set to a value
		if (this.myString == null || this.myString.length() == 0 || this.isSet == false) {
			return "";
		}
		else {
			// Create a new string using the string value
			String newString = this.myString;
			// Loop through the lowercase alpahbetical characters to remove
			for (char removeChar: removeChars) {
				// Convert character to remove to String
				String stringLower = Character.toString(removeChar);
				// Create a regex pattern with the character to remove, ignoring cases
				Pattern p = Pattern.compile(stringLower, Pattern.CASE_INSENSITIVE);
				// Remove all instances of the character to remove from the newString
				newString = p.matcher(newString).replaceAll("");
			}
			return newString;
		}
	}	
	
	/**
	 * Returns a new string version of the current string where the capitalization is reversed (i.e., lowercase to uppercase, 
	 * and uppercase to lowercase) for the alphabetical characters specified in the given arg.
	 *   
	 * All non-alphabetical characters are unaffected.
	 * If the current string is null, empty, or has not been set to a value, this method should return an empty string.
	 *
	 * Example(s):
	 * - For a current string "abc, XYZ; 123.", calling reverse("bcdxyz@3210.") would return "aBC, xyz; 123."
	 * - For a current string "abc, XYZ; 123.", calling reverse("6,.") would return "abc, XYZ; 123."
	 * - For a current string "abc, XYZ; 123.", calling reverse("") would return "abc, XYZ; 123."
	 * - For a current string "", calling reverse("") would return ""
	 * 
	 * Remember: This method builds and returns a new string, and does not directly modify the myString field.
	 * 
	 * @param arg the string containing the alphabetical characters to have their capitalization reversed in the current string
	 * @return new string in which the alphabetical characters specified in the arg are reversed
	 */
	public String reverse(String arg) {

		// If the current string is null, empty, or has not been set to a value
		if (this.myString == null || this.myString.length() == 0 || this.isSet == false) {
			return "";
		}
		else {
			
			// Get an array of all characters in the current string
			char[] currentChars = this.myString.toCharArray();
			
			// Get a string of the alphabetical characters in arg, converted to lowercase
			String reverseString = "";
			for (int i = 0; i < arg.length(); i++) {
				char ch = arg.charAt(i);
				if (Character.isLetter(ch)) {
					reverseString += Character.toLowerCase(ch);
				}
			}
			// Create a blank string
			String newString = "";
			// Loop through all characters in the current string
			for (char currentChar : currentChars) {
				// If the lowercase version of the character is a character that needs to be reversed
				if (reverseString.contains("" + Character.toLowerCase(currentChar))) {
					// If the original character is in upper case
					if (Character.isUpperCase(currentChar)) {
						// Reverse the case to lower case and add to newString
						newString += Character.toLowerCase(currentChar);
					}
					// If the original character is in lower case
					else {
						// Reverse the case to upper case and add to new String
						newString += Character.toUpperCase(currentChar);
					}
				}
				// If the original character does not need to be reversed
				else {
					// Add the original character to newString
					newString += currentChar;
				}
			}
			return newString;
		}
	}

    /**
     * Returns a new string version of the current string where all the letters either >= or <= the given char n, are removed.  
     * 
     * The given letter may be a-z or A-Z, inclusive.
     * The letters to be removed are case insensitive.
     *
     * If 'more' is false, all letters less than or equal to n will be removed in the returned string.
     * If 'more' is true, all letters greater than or equal to n will be removed in the returned string.
     *
     * If the current string is null, the method should return an empty string.
     * If n is not a letter (and the current string is not null), the method should return an empty string.
     *
     * Example(s):
     * - For a current string "Hello 90, bye 2", calling filterLetters('h', false) would return "llo 90, y 2"
     * - For a current string "Abcdefg", calling filterLetters('c', false) would return "defg"
     * - For a current string "Hello 90, bye 2", calling filterLetters('h', true) would return "e 90, be 2"
     * - For a current string "Abcdefg", calling filterLetters('c', true) would return "Ab"
     * 
     * Remember: This method builds and returns a new string, and does not directly modify the myString field.
     *
     * @param n char to compare to
     * @param more indicates whether letters <= or >= n will be removed
     * @return new string with letters removed 
     */
	public String filterLetters(char n, boolean more) {
		
		// If the current string is null or n is not a letter
		if (this.myString == null || !Character.isLetter(n)) {
			return "";
		} 
		// If myString is not null and n is a letter
		else {
			
			// Create an array of the characters in myString, converted to lowercase
			char[] currChars = this.myString.toCharArray();
			// Create a blank string
			String newString = "";
			// If removing characters greater than n
			if (more) {
				// Loop through all characters in the current string
				for (char currChar: currChars) {
					// If the current character is a letter
					if (Character.isLetter(currChar)) {
						// And if the current character is less than n
						if (Character.toLowerCase(currChar) < Character.toLowerCase(n)) {
							// Add current character to newString
							newString += currChar;
						}
					}
					// If the current character is not a letter
					else {
						// Add current character to newString
						newString += currChar;
					}
				}
			}
			// If removing characters less than n
			else {
				// Loop through all characters in the current string
				for (char currChar: currChars) {
					// If the current character is a letter
					if (Character.isLetter(currChar)) {
						// And if the current character is less than n
						if (Character.toLowerCase(currChar) > Character.toLowerCase(n)) {
							// Add current character to newString
							newString += currChar;
						}
					}
					// If the current character is not a letter
					else {
						// Add current character to newString
						newString += currChar;
					}
				}
			}
			return newString;
		}
	}
	
}
