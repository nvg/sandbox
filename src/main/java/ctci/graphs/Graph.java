package ctci.graphs;

import java.util.LinkedList;
import java.util.List;

import lombok.Data;

@Data
public class Graph {
	
	// keeps copies of all nodes, as some are not necessarily can be reached
	// from other nodes
	private List<Node> nodes = new LinkedList<>();

}
