
public class StackCalculator extends Calculator {

	@Override
	public double evaluate(String expr) {
		StackAsArray stack = new StackAsArray();
		ExpTokenizer tokens = new ExpTokenizer(expr);
		double res=0.0;
		while(tokens.hasMoreElements()) {
			Object next_element = tokens.nextElement();
			if(next_element instanceof BinaryOp) {
				double a = (double) stack.pop();
				double b = (double) stack.pop();
				double c = ((BinaryOp) next_element).operate(b, a);
				stack.push(c);
			}
			else {
				stack.push(((ValueToken)next_element).getValue());
			}
		}
		res= (double)stack.pop();
		return res;
	}
	public static String infixToPostfix(String expr) {
		String str ="";
		StackAsArray stack = new StackAsArray();
		ExpTokenizer tokens = new ExpTokenizer(expr);
		while(tokens.hasMoreElements()) {
			Object next_element = tokens.nextElement(); // number / operation
			if (next_element instanceof OpenBracket) { // open
				stack.push(next_element);
			}
			else if(next_element instanceof CloseBracket) { // close 
				Object p = new CloseBracket();
				while(!stack.isEmpty()&& !(p instanceof OpenBracket)) {
					p = stack.pop();
					//String p = stack.pop().toString();
					if (!(p instanceof OpenBracket)) {
						str+=p.toString() + " ";
						p = null;
					}
				}
			}
			else if(next_element instanceof BinaryOp){
				if (stack.isEmpty()) {
					stack.push(next_element);				}
				else {
				Object p = stack.pop(); // -
				if (p instanceof OpenBracket) {
					stack.push(p);
					//stack.push(next_element);
					
			}
				else {
					while(p!= null && (((BinaryOp) next_element).getPrecedence() <= ((BinaryOp) p).getPrecedence())) {
						if((p instanceof PowOp)&& (next_element instanceof PowOp)) {
							stack.push(p);
							p = null;
						}
						else if(p instanceof PowOp) {
							str += p.toString() + " ";
							p = null;
						}
						else {
							str += p.toString() + " ";
							if(!stack.isEmpty()) {
								p = stack.pop();
								
							}
							else {
								p = null;
							}
							
						}
					}
					if (p!=null) {
						stack.push(p);
					}

			}
				stack.push(next_element);}}
				
			else if(next_element instanceof CloseBracket) {
				Object p = stack.pop();
				while(!(p instanceof OpenBracket)) {
					str += p.toString()+ " ";
					p = stack.pop();
				}
			}
			else if(next_element instanceof ValueToken) {
				str += (Double.parseDouble(next_element.toString()))+ " ";
				
			}
		}
		while(!stack.isEmpty()) {
			Object p = stack.pop();
			if(!(p instanceof OpenBracket)) {
				str+=p.toString()+ " ";
			}
		}
		String ans = str.substring(0, str.length()-1);
		return ans;

		
	}
	
}
