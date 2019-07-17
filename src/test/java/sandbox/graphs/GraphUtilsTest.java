package sandbox.graphs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphUtilsTest {

	private Graph g;
	private Node n1 = new Node(1);
	private Node n2 = new Node(2);
	private Node n3 = new Node(3);
	private Node n4 = new Node(4);
	private Node n5 = new Node(5);
	private Node n6 = new Node(6);
	private Node n7 = new Node(7);
	private Node n8 = new Node(8);
	private Node n9 = new Node(9);

	@BeforeEach
	void initGraph() {
		n1 = new Node(1);
		n2 = new Node(2);
		n3 = new Node(3);
		n4 = new Node(4);
		n5 = new Node(5);
		n6 = new Node(6);
		n7 = new Node(7);
		n8 = new Node(8);
		n9 = new Node(9);

		n1.getAdjacent().add(n2);
		n2.getAdjacent().add(n3);
		n3.getAdjacent().add(n4);
		n4.getAdjacent().add(n5);
		n5.getAdjacent().add(n6);
		n6.getAdjacent().add(n7);
		n6.getAdjacent().add(n8);
		n8.getAdjacent().add(n9);

		g = new Graph();
		g.getNodes().add(n1);
		g.getNodes().add(n2);
		g.getNodes().add(n3);
		g.getNodes().add(n4);
		g.getNodes().add(n5);
		g.getNodes().add(n6);
		g.getNodes().add(n7);
		g.getNodes().add(n8);
		g.getNodes().add(n9);
	}

	@Test
	void shouldFindPath() {
		assertTrue(GraphUtils.searchBreadthFirst(g, n1, n9));
	}
	
	@Test
	void shouldNotFindPath() {
		assertFalse(GraphUtils.searchBreadthFirst(g, n8, n5));
	}

}
