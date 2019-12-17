package sandbox.trees;

import java.util.LinkedList;
import java.util.Queue;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TreeNode {

	public TreeNode(int value) {
		this.value = value;
	}

	private int value;
	private TreeNode left;
	private TreeNode right;

	public void processBreadthFirst(TreeNodeOperation o) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(this);

		while (!q.isEmpty()) {
			TreeNode n = q.remove();
			if (n == null) {
				continue;
			}
			
			o.perform(n);
			
			q.add(n.getLeft());
			q.add(n.getRight());
		}
	}
	
	public void depthFirst(TreeNodeOperation o) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(this);
		
		while (!q.isEmpty()) {
			TreeNode n = q.remove();
			if (n == null) {
				continue;
			}
			
			o.perform(n);
			
			q.add(n.getLeft());
			q.add(n.getRight());
		}
	}
	
	public interface TreeNodeOperation {
		public void perform(TreeNode n);
	}
}