package com.csc.lap.features.lambda;

public class AnonymousInnerScopeTest {

	public int x = 0;

	interface MyConsumer {
		int x = 1;

		void accept();
	}

	class FirstLevel {

		public int x = 2;

		void methodInFirstLevel() {
			MyConsumer myConsumer = (new MyConsumer() {
				public void accept() {
					System.out.println("this.x = " + this.x);
				}
			});

			myConsumer.accept();
		}
	}

	public static void main(String... args) {
		AnonymousInnerScopeTest st = new AnonymousInnerScopeTest();
		AnonymousInnerScopeTest.FirstLevel fl = st.new FirstLevel();
		fl.methodInFirstLevel();
	}
}