
public class MultiplyOp extends BinaryOp{

	public double operate(double left, double right) {
		return left*right;
	}
	
	public double getPrecedence() {
		double x = 2.0;
		return x;	
		}

	@Override
	public String toString() {
		return "*";
	}
	}

