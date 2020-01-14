package ctci.graphs;

import java.util.LinkedList;

import ctci.graphs.Node.State;

public class GraphUtils {

	/**
	 * Gives shortest path.
	 */
	public static boolean searchBreadthFirst(Graph g, Node start, Node end) {
		if (start == end) {
			return true;
		}

		LinkedList<Node> q = new LinkedList<>();
		g.getNodes().forEach(n -> n.setState(State.UNVISITED));

		start.setState(State.VISITING);
		q.add(start);

		while (!q.isEmpty()) {
			Node u = q.removeFirst();

			for (Node v : u.getAdjacent()) {
				if (v.getState() != State.UNVISITED) {
					continue;
				}

				if (v == end) {
					return true;
				}

				v.setState(State.VISITING);
				q.add(v);
			}
			u.setState(State.VISITED);
		}

		return false;
	}

}
