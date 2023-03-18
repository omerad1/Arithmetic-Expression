
public class ValueToken extends CalcToken{
	double val;
	ValueToken(double val){
		this.val=val;
	}

	public double getValue() {
		return this.val;
	}
	public String toString() {
		double x = this.getValue();
		String s = String.valueOf(x);
		return s;
	}
}