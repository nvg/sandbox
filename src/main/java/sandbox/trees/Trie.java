package sandbox.trees;

import java.util.HashMap;
import java.util.Map;

/*
 * Useful for finding specific words in a text
 * spell check.
 */
public class Trie {

}

class Node {
	
	private Map<Character, Node> children = new HashMap<>();
	boolean isCompleteWord;
	
}