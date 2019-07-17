package sandbox.trees;

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
	
}
