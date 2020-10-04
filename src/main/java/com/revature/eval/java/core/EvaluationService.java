package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;







public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		
		
		String acronym = "";
		
		for(int i = 0; i < phrase.length(); i++)
		{
			if(i == 0)
			{
				acronym += phrase.charAt(i);
			}
			
			if(phrase.charAt(i) == ' ' || phrase.charAt(i) == '-')
			{
				acronym += phrase.charAt(i + 1);
			}
			
			acronym = acronym.toUpperCase();
		}
		
		return acronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() 
		{
			int matches = 0;
		
			if(sideOne == sideTwo)
			{
				matches++;
			}
			
			if(sideOne == sideThree)
			{
				matches++;
			}
			
			if(sideTwo == sideThree)
			{
				matches++;
			}
			
			if(matches == 3)
			{
			return true;
			}
			else
				return false;
		}

		public boolean isIsosceles() 
		{
			int matches = 0;
			
			if(sideOne == sideTwo)
			{
				matches++;
			}
			else if(sideOne == sideThree)
			{
				matches++;
			}
			else if(sideTwo == sideThree)
			{
				matches++;
			}
			
			if(matches == 1)
			{
			return true;
			}
			else
				return false;
		}

		public boolean isScalene() 
		{
	int matches = 0;
			
			if(sideOne == sideTwo)
			{
				matches++;
			}
			else if(sideOne == sideThree)
			{
				matches++;
			}
			else if(sideTwo == sideThree)
			{
				matches++;
			}
			
			if(matches == 0)
			{
			return true;
			}
			else
				return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) 
	{
		int score = 0;
		int i;

		
		char[] onePointers = {'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T', 'a', 'e', 'i', 'o', 'u', 'l', 'n', 'r', 's', 't'};
		char[] twoPointers = {'D', 'd', 'G', 'g'};
		char[] threePointers = {'B', 'b', 'C', 'c', 'M', 'm', 'P', 'p'};
		char[] fourPointers = {'F', 'f', 'H', 'h', 'V', 'v', 'W', 'w', 'Y', 'y'};
		char[] fivePointers = {'K', 'k'};
		char[] eightPointers = {'J', 'j', 'X', 'x'};
		char[] tenPointers = {'Q', 'q', 'Z', 'z'};
		
		for(i = 0; i < string.length(); i++)
		{
			for(char element: onePointers)
			{
				if(element == string.charAt(i))
				{
					score++;
					break;
				}	
			}
		}
		for(i = 0; i < string.length(); i++)
		{
			for(char element: twoPointers)
			{
				if(element == string.charAt(i))
				{
					score += 2;
					break;
				}	
			}
		}
		for(i = 0; i < string.length(); i++)
		{
			for(char element: threePointers)
			{
				if(element == string.charAt(i))
				{
					score += 3;
					break;
				}	
			}
		}
		for(i = 0; i < string.length(); i++)
		{
			for(char element: fourPointers)
			{
				if(element == string.charAt(i))
				{
					score += 4;
					break;
				}	
			}
		}
		for(i = 0; i < string.length(); i++)
		{
			for(char element: fivePointers)
			{
				if(element == string.charAt(i))
				{
					score += 5;
					break;
				}	
			}
		}
		for(i = 0; i < string.length(); i++)
		{
			for(char element: eightPointers)
			{
				if(element == string.charAt(i))
				{
					score += 8;
					break;
				}	
			}
		}
		for(i = 0; i < string.length(); i++)
		{
			for(char element: tenPointers)
			{
				if(element == string.charAt(i))
				{
					score += 10;
					break;
				}	
			}
		}
		
		
		
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) 
	{
		int numCount = 0;
		
		
		String correctNumber = "";
		
		String numbers = "123456789";
		
		boolean numberFound = false;
		
		int numberStringSize = string.length();
		
		char[] pNumber = string.toCharArray();
		
			for(int i = 0; i < numberStringSize; i++)
			{
				
				
				if(string.charAt(i) >= 48 && string.charAt(i) <= 57 && numberFound == false)
				{
					if(string.charAt(i) != 49)
					{
						numCount++;
						correctNumber = correctNumber + string.charAt(i);
						
					}
					if(string.charAt(i) == 49)
					{
						numberFound = true;
						continue;
					}
					
							numberFound = true;
							continue;
				}
				if(string.charAt(i) >= 48 && string.charAt(i) <= 57 && numberFound == true)
				{	
						numCount++;	
						correctNumber = correctNumber + string.charAt(i);
				}
				
				
				
			}
			
			if(numCount != 10)
			{
				throw new IllegalArgumentException();
			}
			
			return correctNumber;
			
		
		
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) 
	{

		
		String word = "";
		
		int phraseLength = string.length();
		int wordLength;

		ArrayList <String> words = new ArrayList <String>();
		Map<String, Integer> myMap= new TreeMap <String, Integer>();
		
		
			int i = 0;
		for(int count = 0; count < phraseLength; count += 0)
		{
			
			for(i = 0; i < phraseLength; i++)
			{
				if(string.charAt(count) == ' ' || count == phraseLength - 1 || (string.charAt(count) < 65) || (string.charAt(count) > 90 && string.charAt(count) < 97) || (string.charAt(count) > 122)) 
				{
					if(count > 1) 
					{
						if((string.charAt(count - 1) >= 65 && string.charAt(count -1) <= 90) || (string.charAt(count - 1) >= 97 && string.charAt(count - 1) <= 122))
						{
							words.add(word);
							word = "";
							break;
						}
					}
				}
				
				if((string.charAt(count) >= 65 && string.charAt(count) <= 90) || (string.charAt(count) >= 97 && string.charAt(count) <= 122))
				{
					word += string.charAt(count);
				}
				if(count == phraseLength - 2)
				{
					word += string.charAt(count + 1);
				}
				count++;
				
				if(count >= phraseLength)
				{
					break;
				}
			}
			
			count++;
		}
		System.out.println(words);
	
		
		for(i = 0; i < words.size(); i += 0)
		{
			int occurrences = 0;
			String wordInLine = words.get(i);
			for(int j = 0; j < words.size(); j+= 0)
			{
				if(wordInLine.equals(words.get(j)))
				{
					occurrences++;
					words.remove(j);
				}
				if(words.size() != 0 && words.size() > j)
				{
					if(wordInLine.equals(words.get(j)))
					{
						continue;
					}
					else
						j++;
				}
			}
			
			
			myMap.put(wordInLine, occurrences);
		}
				
		return myMap;
	
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) 
		{
			int listSize = ((ArrayList<String>) t).size();
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}	

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) 
	{
		String finalResult = "";
		String word = "";
		boolean startsWithVowel = true;
		String nonVowels = "";
		boolean wentIn = false;
		int indexOfFirstVowel = 0;
		int indexofFirstLetter = 0;
		int e = 0;
		int indexofLastWord;
		String lastWord = "";
		StringBuffer text = new StringBuffer(string);
		int wordSize= 0;
		boolean moreThanOneWord = string.contains(" ");
		
		if(string.contains(" "))
		{
			indexofLastWord = string.lastIndexOf(" ") + 1;
			
			lastWord += string.substring(indexofLastWord);		
		}
		
		System.out.println(lastWord);
		
		for(indexofFirstLetter = 0; indexofFirstLetter < text.length(); indexofFirstLetter++)
		{
				System.out.println(text.length());
				System.out.println(text.charAt(0));
				System.out.println(finalResult);
				wentIn = false;
				nonVowels = "";
			for(e = 0;  e < text.length() && text.charAt(e) != ' '; e++)
			{
				String vowels = "aeio";
					
					if(vowels.contains(String.valueOf(text.charAt(0))))
					{
						startsWithVowel = true;
						wentIn = true;
					}
					else
					{
						startsWithVowel = false;
					}
					
					if(startsWithVowel == true)
					{
						word += text.substring(e, e + 1);	
					}
					
											
					int i;
					System.out.println(text);
					System.out.println(lastWord);
					System.out.println(lastWord.contentEquals(text));
					System.out.println(text.length());
					System.out.println(lastWord.length());
					
					if(wentIn == false && lastWord.contentEquals(text) == false)
					{
						for(i = 0; vowels.contains(String.valueOf(text.charAt(i))) == false; i++)
						{
							nonVowels += String.valueOf(text.charAt(i));
						}
						indexOfFirstVowel = i;	
						
						for(i = indexOfFirstVowel; i < text.length() && text.charAt(i) != ' '; i++)
						{
							word += text.substring(i, i + 1);
						}
					}
					
					if(wentIn == false && lastWord.contentEquals(text))
					{
						for(i = 0; vowels.contains(String.valueOf(text.charAt(i))) == false && text.charAt(i) != 'u'; i++)
						{
							nonVowels += String.valueOf(text.charAt(i));
						}
						indexOfFirstVowel = i;	
						
						for(i = indexOfFirstVowel; i < text.length() && text.charAt(i) != ' '; i++)
						{
							word += text.substring(i, i + 1);
						}
					}
					
					
					wentIn = true;
			continue;
			}
		
			if(startsWithVowel == false)
			{
				word += nonVowels;
				word += "ay";
			}
			
			if(startsWithVowel == true)
			{
				word += "ay";
			}
			
/*
			if(startsWithVowel == false && (e == indexOfFirstVowel || e > indexOfFirstVowel && e < text.length()))
			{
				word += text.substring(e, e + 1);
			}
*/		
			
			if(text.replace(0, e + 1, "").equals(lastWord) && moreThanOneWord == true)
			{
				finalResult += word;
			}		
			else if(moreThanOneWord == false)
			{
				finalResult += word;
			}
			else if(moreThanOneWord == true && lastWord.contentEquals(text) == true && text.length() > 0)
			{
				finalResult += word + " ";
			}
			else if(moreThanOneWord == true && lastWord.contentEquals(text) == true && text.length() == 0)
			{
				finalResult += word;
			}
			else
			{
				finalResult += word + " ";
			}
			
		System.out.println(word);
			
			indexofFirstLetter = -1;
			word = "";
		}
		
		if(moreThanOneWord == true)
		{
		finalResult = finalResult.substring(0, finalResult.length() - 1);
		}
		return finalResult;
	}
	

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) 
	{
		String numberString = Integer.toString(input);
		char[] numStringSize = new char[numberString.length()];
		
		for(int i = 0; i < numberString.length(); i++)
		{
			numStringSize[i] = numberString.charAt(i);
		}
		
		int exponent = numberString.length();
		
		int [] numbersBack = new int[numberString.length()];
		
		double[] squaredValues = new double[numberString.length()];
		
		double lastValue = 0;
		
		for(int i = 0; i < numberString.length(); i++)
		{
			numbersBack[i] = numStringSize[i] - '0';
			
			double squaredResultElement = Math.pow((double) numbersBack[i], (double) numberString.length());
			
			squaredValues[i] = squaredResultElement;
			
			lastValue += squaredValues[i];
		}
		
		if(lastValue == input)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
		
		
		
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) 
	{
		List <Long> primeNumbers = new ArrayList <Long>();
		
		int [] oneThroughNine = {1,2,3,4,5,6,7,8,9};
		
		long testcase = l;
		
		boolean Iwanttorepeat;
		
		
	
		for(long i = 2; i <= testcase; i++)
		{
			if(testcase % i == 0)
			{
				testcase = testcase/ i;
				primeNumbers.add(i);
				Iwanttorepeat = true;
				if(Iwanttorepeat)
				{
					i--;
					continue;
				}
			}
			continue;						
		}
		
		return primeNumbers;
			
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) 
		{
			RotationalCipher keyValue = RotationalCipher.this;
			
			int keyValue1 = keyValue.key;
			
			String finalString = "";
			
			char capitalLetter = ' ';
			char lowercaseLetter = ' ';
			
			for(int i = 0; i < string.length(); i++)
			{
				if(string.charAt(i) >= 65 && string.charAt(i) <= 90)
				{
					
					for(int ascii = 0; ascii <= keyValue1; ascii++)
					{
						capitalLetter = string.charAt(i);
						if((capitalLetter + ascii) > 90)
						{
							capitalLetter -= 26;
						}
						if(ascii == keyValue1)
						{
							capitalLetter += ascii ;
						}
					}
					finalString += capitalLetter;
				}
				
				else if(string.charAt(i) >= 97 && string.charAt(i) <= 122)
				{
					for(int ascii = 0; ascii <= keyValue1; ascii++)
					{
						lowercaseLetter = string.charAt(i);
						if((lowercaseLetter + ascii) > 122)
						{
							lowercaseLetter -= 26;
						}
						if(ascii == keyValue1)
						{
							lowercaseLetter += ascii;
						}
					}
					finalString += lowercaseLetter;
				}
				else
				{
					finalString += string.charAt(i);
				}
				
			}
			return finalString;
		}
	}
		
	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) 
	{
		if(i < 1)
		{
			throw new IllegalArgumentException();
		}
		
		int primeCount = 0;
		
		boolean divisibleNumHit = false;
		
		int p = 2;
		
		for(p = 2; primeCount < i; p++)
		{
			divisibleNumHit = false;
			for(int q = 2; q <= p; q++)
			{
				if(p % q == 0 && (p != q && q != 1))
				{
					divisibleNumHit = true;
				}
				if(p == q && divisibleNumHit == false)
				{
					primeCount++;
				}	
				
			}
			
		}
		
		
		
		return p - 1;
		
		
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) 
		{
			
			String result = "";
			String finalAnswer = "";
			
			String firstHalfABC = "abcdefghijklm";
			String secondHalfABC = "zyxwvutsrqpon";
			String numbers = "0123456789";
			
			
			Map <String, String> FHcorrespondingLetterValue = new HashMap <String, String>();
			Map <String, String> SHcorrespondingLetterValue = new HashMap <String, String>();
			Map <String, String> NumberscorrespondingLetterValue = new HashMap <String, String>();
			
		
			
			for(int i = 0; i < firstHalfABC.length(); i++)
			{
				FHcorrespondingLetterValue.put(String.valueOf(firstHalfABC.charAt(i)), String.valueOf(secondHalfABC.charAt(i)));
				SHcorrespondingLetterValue.put(String.valueOf(secondHalfABC.charAt(i)), String.valueOf(firstHalfABC.charAt(i)));
			}
			for(int i = 0; i < 10; i++)
			{
				NumberscorrespondingLetterValue.put(String.valueOf(numbers.charAt(i)), String.valueOf(numbers.charAt(i)));
			}
			
			
			int letterSameWord = 1;
			
			
			for(int i = 0; i < string.length(); i++)
			{
				char letter = string.charAt(i);
				
				if((letter >= 48 && letter <= 57) || (letter >= 65 && letter <= 90) || (letter >= 97 && letter <= 122))
				{
					letterSameWord++;
					result += letter;
				}
				if(letterSameWord > 5)
				{
					letterSameWord = 1;
					result += " ";
				}
			
			}
			
			for(int i = 0; i < result.length(); i++)
			{
				if(FHcorrespondingLetterValue.containsKey(String.valueOf(result.charAt(i)).toLowerCase()))
				{
					finalAnswer += FHcorrespondingLetterValue.get(String.valueOf(result.charAt(i)).toLowerCase());
				}		
				else if(SHcorrespondingLetterValue.containsKey(String.valueOf(result.charAt(i)).toLowerCase()))
				{
					finalAnswer += SHcorrespondingLetterValue.get(String.valueOf(result.charAt(i)).toLowerCase());
				}
				else if(NumberscorrespondingLetterValue.containsKey(String.valueOf(result.charAt(i))))
				{
					finalAnswer += NumberscorrespondingLetterValue.get(String.valueOf(result.charAt(i)));
				}
				else
				{
					finalAnswer += " ";
				}
			}
			
			return finalAnswer;
		}
	

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) 
		{
			String result = "";
			String finalAnswer = "";
			
			String firstHalfABC = "abcdefghijklm";
			String secondHalfABC = "zyxwvutsrqpon";
			String numbers = "0123456789";
			
			
			Map <String, String> FHcorrespondingLetterValue = new HashMap <String, String>();
			Map <String, String> SHcorrespondingLetterValue = new HashMap <String, String>();
			Map <String, String> NumberscorrespondingLetterValue = new HashMap <String, String>();
			

			
			for(int i = 0; i < firstHalfABC.length(); i++)
			{
				FHcorrespondingLetterValue.put(String.valueOf(firstHalfABC.charAt(i)), String.valueOf(secondHalfABC.charAt(i)));
				SHcorrespondingLetterValue.put(String.valueOf(secondHalfABC.charAt(i)), String.valueOf(firstHalfABC.charAt(i)));
			}
			for(int i = 0; i < 10; i++)
			{
				NumberscorrespondingLetterValue.put(String.valueOf(numbers.charAt(i)), String.valueOf(numbers.charAt(i)));
			}
			
			
			int letterSameWord = 1;
			
			
			for(int i = 0; i < string.length(); i++)
			{
				char letter = string.charAt(i);
				
				if((letter >= 48 && letter <= 57) || (letter >= 65 && letter <= 90) || (letter >= 97 && letter <= 122))
				{
					letterSameWord++;
					result += letter;
				}
				if(letter == ' ')
				{
					continue;
				}
			
			}
			System.out.println(result);
			
			for(int i = 0; i < result.length(); i++)
			{
				if(FHcorrespondingLetterValue.containsKey(String.valueOf(result.charAt(i)).toLowerCase()))
				{
					finalAnswer += FHcorrespondingLetterValue.get(String.valueOf(result.charAt(i)).toLowerCase());
				}		
				else if(SHcorrespondingLetterValue.containsKey(String.valueOf(result.charAt(i)).toLowerCase()))
				{
					finalAnswer += SHcorrespondingLetterValue.get(String.valueOf(result.charAt(i)).toLowerCase());
				}
				else if(NumberscorrespondingLetterValue.containsKey(String.valueOf(result.charAt(i))))
				{
					finalAnswer += NumberscorrespondingLetterValue.get(String.valueOf(result.charAt(i)));
				}
				else
				{
					finalAnswer += " ";
				}
			}
			
			return finalAnswer;
		}
		
		}
	
	
	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) 
	{
		String nums = "0123456789";
		
		String digits = "";
		
		int [] finalNumbers = new int[10];
		
		for(int i = 0; i < string.length() - 1; i++)
		{
			if(string.charAt(i) >= 48 && string.charAt(i) <= 57)
			{
				digits += string.charAt(i);
			}
		}
		if(digits.length() != 9)
		{
			return false;
		}
		int checkedValue;
		int lastElement = string.length() - 1;
		if(string.charAt(lastElement) < 48 || (string.charAt(lastElement) > 57 && (string.charAt(lastElement) != 88)))
		{
			return false;
		}
		else
		{
			if(string.charAt(lastElement) == 88)
			{
				checkedValue = 10;
			}
			else
			{
				checkedValue = Character.getNumericValue(string.charAt(lastElement));
			}
		}
		int j = 0;
		int a = 10;
		int sumOfTenDigits = 0;
		for(int i = 0; i < 10; i++)
		{
			if(i < 9)
			{
				finalNumbers[i] = Character.getNumericValue(digits.charAt(j)) * a;
				j++;
				a--;
			}
			else
			{
				finalNumbers[i] = checkedValue * a; 
			}
			
			sumOfTenDigits += finalNumbers[i];
		}
		
		if(sumOfTenDigits % 11 == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) 
	{
	String letters = "abcdefghijklmnopqrstuvwxyz";
		
		int j;
		for(int i = 0; i < letters.length(); i++)
		{
			int match = 0;
			for(j = 0; j < string.length(); j++)
				{		
				if(string.charAt(j) == letters.charAt(i))
				{
					match++;
				}
			}
			
			if(match == 0)
			{
				return false;
			}
		}
		
		return true;
		
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) 
	{
		int setSize = set.length;
		
		Set <Integer> multiples = new HashSet <Integer>();
		
		for(int p = 0; p < setSize; p++)
		{
			multiples.add(set[p]);
			int firstNumber = set[p];
			while(set[p] + firstNumber < i)
			{
				set[p] += firstNumber;
				multiples.add(set[p]);
			}
		}
		
		int sum = 0;
		Iterator <Integer> iter = multiples.iterator();
		
		for(int d = 0; d < multiples.size(); d++)
		{
			while(iter.hasNext())
			{
				sum += iter.next();
			}
		}
		
		
		return sum;
		
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) 
	{
		String numsAfterDoubles = "";
		int seq = 1;
		for(int i = string.length() - 1; i >= 0 ; i--)
		{
			
			if((string.charAt(i) >= 48 && string.charAt(i) <= 57) || string.charAt(i) == ' ')
			{
				int backOfTheLine = i;
					
					int currentNumber = 0;
					
					if(string.charAt(backOfTheLine) != ' ' && seq != 2)
					{	
					currentNumber = Character.getNumericValue(string.charAt(backOfTheLine));
					numsAfterDoubles += String.valueOf(currentNumber);
					seq++;
					continue;
					}
					if(seq == 2 && string.charAt(backOfTheLine) != ' ')
					{
						currentNumber = Character.getNumericValue(string.charAt(backOfTheLine));
						
						currentNumber *= 2;
						
						if(currentNumber > 9)
						{
							currentNumber -= 9;
						}
						
						numsAfterDoubles += String.valueOf(currentNumber);
						seq = 1;
					} 
					
				
			}
			else
			{
				return false;
			}
			
		}
		
		int sum = 0;
		
		for(int p = 0; p < numsAfterDoubles.length(); p++)
		{
			sum += Character.getNumericValue(numsAfterDoubles.charAt(p));
		}
		
		if(sum % 10 == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
	String sign = "";
		
		for(int i = 0; i < string.length(); i++)
		{
			if(string.charAt(i) == 'm' && string.charAt(i + 1) == 'i')
			{
				sign += "minus";
				break;
			}
			
			if(string.charAt(i) == 'm' && string.charAt(i + 1) == 'u')
			{
				sign += "multiplied";
				break;
			}
			
			if(string.charAt(i) == 'd')
			{
				sign += "divided";
				break;
			}
			
			if(string.charAt(i) == 'p')
			{
				sign += "plus";
				break;
			}
		}
		
		int num1, num2;
		num1 = 0;
		num2 = 0;
		
		String num1sign = "";
		String num2sign = "";
		
		
		
		for(int i = 0; i < string.length(); i++)
		{
			if(string.charAt(i) == '-' && i < 12)
			{
				num1sign += "negative";
			}
			
			if(string.charAt(i) == '-' && i >= 12)
			{
				num2sign += "negative";
			}
		}
		
		if(num1sign == "")
		{
			num1sign += "positive";
		}
		
		if(num2sign == "")
		{
			num2sign += "positive";
		}
		
		boolean firstNumberComplete = false;
		String num1str = "";
		String num2str = "";
		
		for(int i = 0; i < string.length(); i++)
		{		
			if((string.charAt(i) >= 48 && string.charAt(i) <= 57) && firstNumberComplete == false)
			{
				while(string.charAt(i) != ' ')
				{
					num1str += string.charAt(i);
					i++;
				}
				i--;
				firstNumberComplete = true;
				continue;	
			}
			
			if((string.charAt(i) >= 48 && string.charAt(i) <= 57) && firstNumberComplete == true)
			{
				while(string.charAt(i) != '?')
				{
					num2str += string.charAt(i);
					i++;
				}
				i--;
				continue;
			}
			
		}
		
		
		if(num1sign.equals("negative"))
		{
			num1 = Integer.parseInt(num1str);
			num1 = num1 - (num1 * 2);
		}
		if(num1sign.equals("positive"))
		{
			num1 = Integer.parseInt(num1str);
		}
		
		if(num2sign.equals("negative"))
		{
			num2 = Integer.parseInt(num2str);
			num2 = num2 - (num2 * 2);
		}
		
		if(num2sign.equals("positive"))
		{
			num2 = Integer.parseInt(num2str);
		}
		
		
		
		if(sign.equals("plus"))
		{
			return num1 + num2;
		}
		else if(sign.equals("minus"))
		{
			return num1 - num2;
		}
		
		else if(sign.equals("multiplied"))
		{
			return num1 * num2;
		}
		
		else if(sign.equals("divided"))
		{
			return num1 / num2;
		}
		else
		{
			return 1;
		}
		
		
	}

}
