
public class AddOp extends BinaryOp{

	public double operate(double left,double right) {
		return left+right;
		
	}
	
	public double getPrecedence() {
		double x = 1.0;
		return x;	
		}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "+";
	}


	}	

