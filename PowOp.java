
public class PowOp extends BinaryOp{

	public double operate(double left, double right) {
		return Math.pow(left, right); 
	}
	public double getPrecedence() {
		double x = 3.0;
		return x;	
		}

	@Override
	public String toString() {
		return "^";
	}
	

}
