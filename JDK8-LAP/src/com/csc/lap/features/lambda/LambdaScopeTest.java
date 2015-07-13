package com.csc.lap.features.lambda;

public class LambdaScopeTest {

	public int x = 0;

	interface MyConsumer {
		int x = 1;

		void accept();
	}

	class FirstLevel {

		public int x = 2;

		void methodInFirstLevel() {
			MyConsumer myConsumer = () -> {
				System.out.println("this.x = " + this.x);
			};

			myConsumer.accept();
		}
	}

	public static void main(String... args) {
		LambdaScopeTest st = new LambdaScopeTest();
		LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
		fl.methodInFirstLevel();
	}
}
