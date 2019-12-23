package sandbox.trees;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;

import lombok.Data;

/*
 * Useful for finding specific words in a text
 * spell check.
 */
public class Trie {

	private static final int ALL_WORDS = Integer.MAX_VALUE;

	private Node root = new Node();

	public boolean contains(String word) {
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!node.contains(ch)) {
				return false;
			}

			node = node.getNode(ch);
			if (node == null) {
				return false;
			}
		}
		return node.isCompleteWord();
	}

	public void addAll(Collection<String> words) {
		words.forEach(s -> add(s));
	}

	public void addAll(String... words) {
		for (String word : words) {
			add(word);
		}
	}

	public void add(String word) {
		Node node = root;
		Node nextNode = null;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			nextNode = node.getNode(ch);
			if (nextNode == null) {
				nextNode = node.add(ch);
			}
			node = nextNode;
		}

		if (nextNode != null) {
			nextNode.setCompleteWord(true);
		}
	}

	public List<String> listMatching(String prefix) {
		return listMatching(prefix, ALL_WORDS);
	}

	public List<String> listMatching(String prefix, int maxDepth) {
		Node n = root;
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);

			if (!n.contains(ch)) {
				return new LinkedList<String>();
			}

			n = n.getNode(ch);
		}

		List<String> result = new LinkedList<String>();
		n.list(new StringBuilder(prefix), result, maxDepth);
		return result;
	}

	public List<String> list() {
		return list(ALL_WORDS);
	}

	public List<String> list(int maxDepth) {
		List<String> result = new LinkedList<String>();
		root.list(new StringBuilder(), result, maxDepth);
		return result;
	}

}

@Data
class Node {

	private Map<Character, Node> children = new TreeMap<>();
	boolean isCompleteWord;

	public boolean contains(Character ch) {
		return children.containsKey(ch);
	}

	public void list(StringBuilder prefix, List<String> result, int maxDepth) {
		if (result.size() >= maxDepth) {
			return;
		}

		if (isCompleteWord()) {
			result.add(prefix.toString());
		}

		children.entrySet().stream().forEach((e) -> {
			prefix.append(e.getKey());
			e.getValue().list(prefix, result, maxDepth);
			prefix.setLength(prefix.length() - 1);
		});
	}

	public Node add(char ch) {
		children.put(ch, new Node());
		return getNode(ch);
	}

	public Node getNode(Character ch) {
		return children.get(ch);
	}

}