
public class TreeCalculator extends Calculator{
ExpressionTree tree;
	@Override
	public double evaluate(String expr) {
		ExpressionTree tree = new ExpressionTree(expr);
		this.tree = tree;
		double res = 0.0; 
		res = evaluateExpression(tree.root,res);
		return res;
	}
	
	public static double evaluateExpression(TreeNode node,  double res) {
		if (node.data instanceof BinaryOp) {
			double a = evaluateExpression(node.left, res);
			double b = evaluateExpression(node.right, res);
			res +=  ((BinaryOp) node.data).operate(a,b);
		}
		else {
			res = res + (double)node.data;
		}
		return res;	
	}
	
	public String getPostfix() {
		String postfix= "";
		postfix = postorder(this.tree.root,postfix);
		return postfix.substring(0,postfix.length()-1);

	}
	public String postorder(TreeNode node,String postfix) {
		if (node == null) {return "";}
		return postorder(node.left, postfix)+ postorder(node.right, postfix)+node.data+" ";
	}
	public String getPrefix() {
		String prefix= "";
		prefix = preorder(this.tree.root,prefix);
		return prefix.substring(0,prefix.length()-1);

	}
	public String preorder(TreeNode node,String postfix) {
		if (node == null) {return "";}
		return node.data+" "+preorder(node.left, postfix)+ preorder(node.right, postfix);}
	public String getInfix() {
		String infix= "";
		infix = inorder(this.tree.root);
		return infix.substring(0,infix.length());

	}
	public String inorder(TreeNode node) {
		if( node == null) {
			return "";
		}
		else if( node.isLeaf() ) {
			return "" + node.getData().toString();
		}
		return "( " + inorder(node.getLeft()) + " " + node.getData().toString() + " " + inorder(node.getRight()) + " )";
	}
		
	}

	



