
public class ExpressionTree {
	String postfix;
	public TreeNode root;
	ExpressionTree(String postfix){
		this.root = null;
		BuildExpressionTree(postfix);	
	}
	
	void BuildExpressionTree(String postfix){
		StackAsArray stack = new StackAsArray();
		ExpTokenizer tokens = new ExpTokenizer(postfix);
		while(tokens.hasMoreElements()) {
			Object next_element = tokens.nextElement();
			if (!(next_element instanceof BinaryOp)) {
				TreeNode node = new TreeNode(((ValueToken) next_element).getValue());
				stack.push(node);
				}			
			else {
				TreeNode right = (TreeNode) stack.pop();
				TreeNode left = (TreeNode) stack.pop();
				TreeNode node_b = new TreeNode(next_element);
				node_b.left = left;
				node_b.right = right;
				stack.push(node_b);
			}
		}
		TreeNode root1 = (TreeNode) stack.pop();
		this.root =  root1;
	}
	

	 
}


