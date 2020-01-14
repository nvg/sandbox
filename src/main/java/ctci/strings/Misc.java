package ctci.strings;

import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Misc {

	/*
	 * Get duplicate characters from a string
	 */
	public static Set<Character> getDuplicates(String s) {
		Set<Character> result = new HashSet<>();
		Set<Integer> dups = new HashSet<Integer>();
		CharBuffer.wrap(s.toCharArray()).chars().forEach(i -> {
			if (dups.contains(i)) {
				result.add((char) i);
			}
			dups.add(i);
		});
		return result;
	}

	/*
	 * Check if one string is a reverse of another?
	 */
	public static boolean isReverse(String s1, String s2) {
		int c1 = 0, c2 = s2.length() - 1;

		while (true) {
			char ch1 = s1.charAt(c1);
			char ch2 = s2.charAt(c2);

			if (ch1 != ch2) {
				return false; // not anagram
			}

			c1++;
			c2--;

			if (c2 < 0) {
				return c1 >= s2.length();
			}

			if (c1 > s2.length() - 1) {
				return c2 >= 0;
			}
		}
	}

	/*
	 * Check if two Strings are anagrams of each other? (solution)
	 */
	public static boolean isAnagram(String s1, String s2) {
		/*-
		Can compare strings this way - would fail for spaces
		StringBuilder buf = new StringBuilder(s2);
		for(char ch : s1.toCharArray()) {
			int index = buf.indexOf(String.valueOf(ch));
			if (index == -1) {
				return false;
			}
			buf.deleteCharAt(index);
		}
		return buf.length() == 0;
		
		- OR - 
		
		Sort char arrays and compare
		
		*/

		Map<Character, Integer> m1 = getCharacterCounts(s1);
		Map<Character, Integer> m2 = getCharacterCounts(s2);
		return m1.equals(m2);
	}

	private static Map<Character, Integer> getCharacterCounts(String s1) {
		Map<Character, Integer> result = new HashMap<Character, Integer>();
		CharBuffer.wrap(s1.toCharArray()).chars().forEach(i -> {
			char ch = (char) i;
			if (!Character.isLetter(ch)) {
				return;
			}
			ch = Character.toLowerCase(ch);

			int count = 0;
			if (result.containsKey(ch)) {
				count = result.get(ch);
			}
			count++;
			result.put(ch, count);
		});
		return result;
	}

	/*
	 * Print first non repeated character from String? (solution)
	 */
	public static Character getFirstNonRepeatingCharacter(String s1) {
		Map<Character, Integer> counts = new LinkedHashMap<Character, Integer>();
		for (char ch : s1.toCharArray()) {
			counts.put(ch, counts.containsKey(ch) ? counts.get(ch) + 1 : 1);
		}

		return counts.entrySet().stream().filter(e -> e.getValue() == 1).findFirst().map(e -> {
			return e.getKey();
		}).orElse(null);
	}

	/*
	 * Reverse a given String using recursion? (solution)
	 */
	public static String reverse(String s) {
		if (s.length() == 0) {
			return "";
		}
		return reverse(s.substring(1)) + s.charAt(0);
	}

	/*
	 * Find all permutations of String
	 */
	public static List<String> getPermutations(String s) {
		List<String> result = new LinkedList<String>();
		getPermutations(s, "", result);
		return result;
	}

	private static void getPermutations(String str, String prefix, List<String> ss) {
		if (str.length() == 0) {
			ss.add(prefix);
		} else {
			for (int i = 0; i < str.length(); i++) {
				String rem = str.substring(0, i) + str.substring(i + 1);
				getPermutations(rem, prefix + str.charAt(i), ss);
			}
		}
	}

	/*
	 * Reverse words in a given sentence without using any library method?
	 */
	public static String reverseWords(String s) {
		int wordStart = s.length() - 1;
		int wordEnd = wordStart;

		boolean isFirst = true;
		StringBuilder result = new StringBuilder();
		while (wordStart >= 0) {
			if (s.charAt(wordStart) == ' ') {
				if (!isFirst) {
					result.append(" ");
				} else {
					isFirst = false;
				}
				result.append(s.substring(wordStart + 1, wordEnd + 1));
				wordStart--;
				wordEnd = wordStart;
				continue;
			}

			wordStart--;
		}

		if (!isFirst) {
			result.append(" ");
		}
		result.append(s.substring(0, wordEnd + 1));

		return result.toString();
	}

	/*
	 * Check if a String contains only digits? (solution)
	 * 
	 * Find duplicate characters in a String? (solution)
	 * 
	 * Count a number of vowels and consonants in a given String? (solution)
	 * 
	 * Count the occurrence of a given character in String? (solution)
	 * 
	 * Check if two String is a rotation of each other? (solution)
	 * 
	 * Check if given String is Palindrome? (solution)
	 */

}
