package com.csc.lap.features.lambda;

public class AnonymousInnerTester {
	interface MathOperation {
		int operation(int a, int b);
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	public static void main(String[] args) {
		AnonymousInnerTester t = new AnonymousInnerTester();
		MathOperation addition = new MathOperation() {
			public int operation(int a, int b) {
				return a + b;
			}
		};

		MathOperation subtraction = new MathOperation() {
			public int operation(int a, int b) {
				return a - b;
			}
		};

		System.out.println("10 + 5 = " + t.operate(10, 5, addition));
		System.out.println("10 - 5 = " + t.operate(10, 5, subtraction));
	}

}



