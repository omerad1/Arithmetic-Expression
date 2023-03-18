
public class SubtractOp extends BinaryOp{

	public double operate(double left, double right) {
		return left-right;
	}
	
	public double getPrecedence() {
		double x = 1.0;
		return x;	
		}

	public String toString() {
		return "-";
	}
	}

