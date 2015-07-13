package com.csc.lap.features.lambda;

public class LambdaExpressionTester {
	@FunctionalInterface
	interface MathOperation {
		int operation(int a, int b);
	}

	@FunctionalInterface
	interface ConcreteMatOperation extends MathOperation{
		int factor = 5;
	}
	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	public static void main(String[] args) {
		LambdaExpressionTester l = new LambdaExpressionTester();

		// WITH TYPE DECLARATION
		MathOperation addition = (a, b) -> a + b;

		// WITHOUT TYPE DECLARATION
		MathOperation subtraction = (a, b) -> a - b;

		System.out.println("10 + 5 = " + l.operate(10, 5, addition));
		System.out.println("10 - 5 = " + l.operate(10, 5, subtraction));
		
		//ConcreteMatOperation additionwithfactor = (a, b) -> a + b + factor; //COMPILE ERROR - CAN NOT REFER TO factor
	}

}
