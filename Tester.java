/**
 * This is a testing framework. Use it extensively to verify that your code is working
 * properly.
 */
public class Tester { 

	private static boolean testPassed = true;
	private static int testNum = 0;
	
	/**
	 * This entry function will test all classes created in this assignment.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
	
	/* TODO - write a function for each class */
	// Each function here should test a different class. You should test ExpTokenizer as well
		
	//BinaryOp
		testOpenBracket();
		testCloseBracket();
		testAddOp();
		testPowOp();
		testDivideOp();
		testMultiplyOp();
		testSubtractOp();
		testExpTokenizer1();
		testExpTokenizer2();
		//...
	//Calculators
		testStackCalculator();
		testStackC2alculator();
		testStackC3alculator();
		//...
		testTree();
		testTreeCalculator();
		
		// Notifying the user that the code have passed all tests. 
		if (testPassed) {
			System.out.println("Shalom alahem, All " + testNum + " tests passed!!!!");
		}
	}

	/**
	 * This utility function will count the number of times it was invoked. 
	 * In addition, if a test fails the function will print the error message.  
	 * @param exp The actual test condition
	 * @param msg An error message, will be printed to the screen in case the test fails.
	 */

	private static void test(boolean exp, String msg) {
		testNum++;
		
		if (!exp) {
			testPassed = false;
			System.out.println("Test " + testNum + " failed: "  + msg);
		}
	}

	/**
	 * Checks the AddOp class.
	 */
	private static void testAddOp() {
		AddOp op = new AddOp();
		test((op.toString().equals("+")), "The string + should be printed.");
		test((op.operate(1.0 , 2.5) == 3.5), "The answer should be 3.5 .");
		test((op.getPrecedence() == 1.0), "The answer should be 3 .");
		test((op.operate(-1.0 , 2.5) == 1.5), "The answer should be 3.5 .");

	}
	private static void testOpenBracket() {
		OpenBracket op = new OpenBracket();
		test((op.toString().equals("(")), "The string ( should be printed.");

	}
	private static void testCloseBracket() {
		CloseBracket op = new CloseBracket();
		test((op.toString().equals(")")), "The string ) should be printed.");

	}
	private static void testPowOp() {
		PowOp op = new PowOp();
		test((op.toString().equals("^")), "The string ^ should be printed.");
		test((op.operate(4 , -1) == 0.25),"The answer should be 0.25 .");
		test((op.getPrecedence() == 3.0), "The answer should be 1 .");
	}
	private static void testSubtractOp() {
		SubtractOp op = new SubtractOp();
		test((op.toString().equals("-")), "The string - should be printed.");
		test((op.operate(5555.55 , 3333.51) == 2222.04), "The answer should be 2222.04 .");
		test((op.getPrecedence() == 1.0), "The answer should be 3 .");
	}
	private static void testMultiplyOp() {
		MultiplyOp op = new MultiplyOp();
		test((op.toString().equals("*")), "The string * should be printed.");
		test((op.operate(77 , 2) == 154), "The answer should be 154 .");
		test((op.getPrecedence() == 2.0), "The answer should be 2 .");
	}
	private static void testDivideOp() {
		DivideOp op = new DivideOp();
		test((op.toString().equals("/")), "The string / should be printed.");
		test((op.operate(16 , 8) == 2.0), "The answer should be 2 .");
		test((op.getPrecedence() == 2.0), "The answer should be 2 .");
	}
	private static void testExpTokenizer1() {
		CalcToken res = new SubtractOp();
		ExpTokenizer exp = new ExpTokenizer("-2 + 4 * 1"); // [2,+,4,*,1]
		String [] st = {"-2","+","4","*","1"};
		String x;
		int i = 0;
		String y;
		while(exp.hasMoreElements()) {
			x = exp.nextToken();
			y = st[i];
			i++;
			test((x.equals(y)),x);
		}
	}
	private static void testExpTokenizer2() {
		Object res = new SubtractOp();
		ExpTokenizer exp = new ExpTokenizer("2 + 4 * 1 / 5 ^ 9 - 12"); // [2,+,4,*,1]
		test(exp.countTokens()==(11),"counting failed");
		String [] st = {"2.0","+","4.0","*","1.0","/","5.0","^","9.0","-","12.0"};
		String x;
		int i = 0;
		String y;
		while(exp.hasMoreElements()) {
			res = exp.nextElement();
			y = st[i];
			i++;
			if(res.getClass() == ValueToken.class) {
				test(res.toString().equals(y),y);
			}
			else 
			test((res.toString().equals(y)),"Failed");
		
	}
		test(exp.countTokens()==(0),"counting failed");
	}
		private static void testStackC3alculator() {
			String ex = "6 2 3 + - 3 8 2 / + * 2 ^ 3 +";
			String exw = "2 3 3 ^ * 1 + 2 3 * 8 / -";
			String exq = "2 2 + 5 3 / 4 3 ^ * -";
			String exa = "2 3 ^ 2 ^";
			StackCalculator pc = new StackCalculator();
			double result1 = pc.evaluate(ex);
			test(result1 ==  52.0, "failed");
			double result2 = pc.evaluate(exw);
			test(result2 ==  54.25, "failed");
			double result3 = pc.evaluate(exq);
			test(result3 ==  -102.66666666666667, "failed");
			double result4 = pc.evaluate(exa);
			test(result4 ==  64.0, String.valueOf(result4));

		}
		private static void testStackC2alculator() {
			String ex = "( 7 + 3 ) * ( 18 - 2 )";
			StackCalculator stack = new StackCalculator();
			test(StackCalculator.infixToPostfix(ex).equalsIgnoreCase("7.0 3.0 + 18.0 2.0 - *"),"noa");
			test(StackCalculator.infixToPostfix("2 - 4 + 5").equals("2.0 4.0 - 5.0 +"),"failed");
			test(StackCalculator.infixToPostfix("2 ^ 3 + 4 - 5 * 6").equals("2.0 3.0 ^ 4.0 + 5.0 6.0 * -"),"failed noa");
			test(StackCalculator.infixToPostfix("2 - 4 + 5").equals("2.0 4.0 - 5.0 +"),"failed");

		}

	
		private static void testTree() {
			String ex = "2.0 3.0 +";
			String ax = "4.0 3.0 7.0 * + 5.0 3.0 5.0 + / - 6.0 +";
			TreeCalculator tree = new TreeCalculator();
			test(tree.evaluate(ex) == (5.0),"the answer should be 5.0");
			test(tree.getPostfix().equals(ex),"failed");
			test(tree.getPrefix().equals("+ 2.0 3.0"),"failed");
			test(tree.getInfix().equals("( 2.0 + 3.0 )"),tree.getInfix());
			tree.evaluate(ax);
			test(tree.getInfix().equals("( ( ( 4.0 + ( 3.0 * 7.0 ) ) - ( 5.0 / ( 3.0 + 5.0 ) ) ) + 6.0 )"),tree.getInfix());
			}
		private static void testTreeCalculator() {
			
			TreeCalculator TreeCalculator1 = new TreeCalculator();
			TreeCalculator TreeCalculator2 = new TreeCalculator();
			TreeCalculator TreeCalculator3 = new TreeCalculator();
			TreeCalculator TreeCalculator4 = new TreeCalculator();
			TreeCalculator TreeCalculator5 = new TreeCalculator();
			////////////////////////////////////////////////////////////////////////////////////////////////////////////

			String stra = "111.0";
			String strb = "-5 12 +";
			String strc = "3 5 2 ^ * 6 +";
			String strd = "5 7 + 2 *";
			////////////////////////////////////////////////////////////////////////////////////////////////////////////

			TreeCalculator1.evaluate(stra);
			TreeCalculator2.evaluate(strb);
			TreeCalculator3.evaluate(strc);
			TreeCalculator4.evaluate(strd);
			////////////////////////////////////////////////////////////////////////////////////////////////////////////

			test((TreeCalculator1.getPostfix().equals("111.0")) , "The answer should be: 111.0 ");
			test((TreeCalculator2.getPostfix().equals("-5.0 12.0 +")) , "The answer should be: -5.0 12.0 +");
			test((TreeCalculator3.getPostfix().equals("3.0 5.0 2.0 ^ * 6.0 +")) , "The answer should be: 3.0 5.0 2.0 ^ * 6.0 +");
			test((TreeCalculator4.getPostfix().equals("5.0 7.0 + 2.0 *")) , "The answer should be: 5.0 7.0 + 2.0 *");
			////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			test((TreeCalculator1.getInfix().equals("111.0")) , "The answer should be: 111.0 ");
			test((TreeCalculator2.getInfix().equals("( -5.0 + 12.0 )")) , "The answer should be: -5.0 + 12.0");
			test((TreeCalculator3.getInfix().equals("( ( 3.0 * ( 5.0 ^ 2.0 ) ) + 6.0 )")) ,"your answer is: " + TreeCalculator3.getInfix()  + "The answer should be: ( ( 3.0 * ( 5.0 ^ 2.0 ) ) + 6.0 )");
			test((TreeCalculator4.getInfix().equals("( ( 5.0 + 7.0 ) * 2.0 )")) , "The answer should be: 5.0 + 7.0 * 2.0");
			////////////////////////////////////////////////////////////////////////////////////////////////////////////

			test((TreeCalculator1.getPrefix().equals("111.0")) , "The answer should be: 111.0 ");
			test((TreeCalculator2.getPrefix().equals("+ -5.0 12.0")) , "The answer should be: + -5.0 12.0");
			test((TreeCalculator3.getPrefix().equals("+ * 3.0 ^ 5.0 2.0 6.0")) , "your answer is: " + TreeCalculator3.getPrefix()+ "The answer should be: + * 3.0 ^ 5.0 2.0 6.0");
			test((TreeCalculator4.getPrefix().equals("* + 5.0 7.0 2.0")) ,TreeCalculator4.getPrefix() +"The answer should be: * + 5.0 7.0 2.0");
			////////////////////////////////////////////////////////////////////////////////////////////////////////////

			test((TreeCalculator1.evaluate(stra)) == 111.0 ,"the output is: "+ TreeCalculator1.evaluate(stra));
			test((TreeCalculator2.evaluate(strb)) == 7.0 , "The answer should be: 7.0 ");
			test((TreeCalculator3.evaluate(strc)) == 81.0 , "The answer should be: 81.0 ");
			test((TreeCalculator4.evaluate(strd)) == 24.0 , "The answer should be: 24.0 ");
		}
	/**
	 */
	private static void testStackCalculator() {
		
		StackCalculator pc = new StackCalculator();
		
		String postExp = pc.infixToPostfix("2 + 3");
		test(postExp.equals("2.0 3.0 +") , "The output of \"2 3 -\" should be  2.0 3.0 +");
		double result1 = pc.evaluate(postExp);
		test(result1 ==  5.0, "The output of \"2 3 -\" should be 5.0");
		
	}}
		