package sandbox.graphs;

import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node {

	public enum State {
		UNVISITED, VISITED, VISITING;
	}

	public Node(int value) {
		this.value = value;
	}

	private State state;
	private int value;
	private List<Node> adjacent = new LinkedList<>();

}
