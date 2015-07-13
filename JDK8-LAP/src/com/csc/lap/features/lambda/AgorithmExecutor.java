package com.csc.lap.features.lambda;

import com.csc.lap.domain.Agorithm;

public class AgorithmExecutor {

	private static final int DOTS_PER_LINE = 100;
	private static final int BATCH_ZISE = 10000000;
	private static final long LOOP_NUMBER = 1000000000L;
	private static final double aInput = 10;
	private static final double bInput = 30;

	public static double operate(double a, double b, Agorithm ag) {
		return ag.calculate(a, b);
	}

	public static void usingAnonymous() {

		for (long i = 1; i <= LOOP_NUMBER; i++) {
			operate(aInput, bInput, new Agorithm() {
				public double calculate(double a, double b) {
					double t1 = a + b;
					double t2 = (a + b) * t1;
					double t3 = (t1 + t2) * t2;
					double t4 = (t1 + t2 + t3) * t3;
					double t5 = (t1 + t2 + t3 + t4) * t4;
					double t6 = (t1 + t2 + t3 + t4 + t5) * t5;
					double t7 = (t1 + t2 + t3 + t4 + t5 + t6) * t6;
					double t8 = (t1 + t2 + t3 + t4 + t5 + t6 + t7) * t7;
					double t9 = (t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8) * t8;
					double t10 = (t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9) * t9;
					double t11 = t10;
					double t12 = (t10 + t11)* t11;
					double t13 = (t10 + t11 + t12)* t12;
					double t14 = (t10 + t11 + t12 + t13)* t13;
					double t15 = (t10 + t11 + t12 + t13 + t14)* t14;
					double t16 = (t10 + t11 + t12 + t13 + t14 + t15)* t15;
					double t17 = (t10 + t11 + t12 + t13 + t14 + t15 + t16)* t16;
					double t18 = (t10 + t11 + t12 + t13 + t14 + t15 + t16 + t17)* t17;
					double t19 = (t10 + t11 + t12 + t13 + t14 + t15 + t16 + t17 + t18)* t18;
					double t20 = (t10 + t11 + t12 + t13 + t14 + t15 + t16 + t17 + t18 + t19)* t19;
					double t21 = t20;
					double t22 = (t20 + t21)* t21;
					double t23 = (t20 + t21 + t22)* t22;
					double t24 = (t20 + t21 + t22 + t23)* t23;
					double t25 = (t20 + t21 + t22 + t23 + t24)* t24;
					double t26 = (t20 + t21 + t22 + t23 + t24 + t25)* t25;
					double t27 = (t20 + t21 + t22 + t23 + t24 + t25 + t26)* t26;
					double t28 = (t20 + t21 + t22 + t23 + t24 + t25 + t26 + t27)* t27;
					double t29 = (t20 + t21 + t22 + t23 + t24 + t25 + t26 + t27 + t28)* t28;
					double t30 = (t20 + t21 + t22 + t23 + t24 + t25 + t26 + t27 + t28 + t29)* t29;
				
					double t31 = t30;
					double t32 = (t30 + t31)* t31;
					double t33 = (t30 + t31 + t32)* t32;
					double t34 = (t30 + t31 + t32 + t33)* t33;
					double t35 = (t30 + t31 + t32 + t33 + t34)* t34;
					double t36 = (t30 + t31 + t32 + t33 + t34 + t35)* t35;
					double t37 = (t30 + t31 + t32 + t33 + t34 + t35 + t36)* t36;
					double t38 = (t30 + t31 + t32 + t33 + t34 + t35 + t36 + t37)* t37;
					double t39 = (t30 + t31 + t32 + t33 + t34 + t35 + t36 + t37 + t38)* t38;
					double t40 = (t30 + t31 + t32 + t33 + t34 + t35 + t36 + t37 + t38 + t39)* t39;
				
					double t41 = t40;
					double t42 = (t40 + t41)* t41;
					double t43 = (t40 + t41 + t42)* t42;
					double t44 = (t40 + t41 + t42 + t43)* t43;
					double t45 = (t40 + t41 + t42 + t43 + t44)* t44;
					double t46 = (t40 + t41 + t42 + t43 + t44 + t45)* t45;
					double t47 = (t40 + t41 + t42 + t43 + t44 + t45 + t46)* t46;
					double t48 = (t40 + t41 + t42 + t43 + t44 + t45 + t46 + t47)* t47;
					double t49 = (t40 + t41 + t42 + t43 + t44 + t45 + t46 + t47 + t48)* t48;
					double t50 = (t40 + t41 + t42 + t43 + t44 + t45 + t46 + t47 + t48 + t49)* t49;
					return t50;
				}
			});
			if (i % (BATCH_ZISE) == 0) {
				System.out.print(".");
			}
			if (i % (DOTS_PER_LINE * BATCH_ZISE) == 0) {
				System.out.println("");
			}
		}

	}

	public static void usingLambdaExpression() {

		for (long i = 1; i <= LOOP_NUMBER; i++) {
			operate(aInput, bInput, (double a, double b) -> {
				double t1 = a + b;
				double t2 = (a + b) * t1;
				double t3 = (t1 + t2) * t2;
				double t4 = (t1 + t2 + t3) * t3;
				double t5 = (t1 + t2 + t3 + t4) * t4;
				double t6 = (t1 + t2 + t3 + t4 + t5) * t5;
				double t7 = (t1 + t2 + t3 + t4 + t5 + t6) * t6;
				double t8 = (t1 + t2 + t3 + t4 + t5 + t6 + t7) * t7;
				double t9 = (t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8) * t8;
				double t10 = (t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9) * t9;
				double t11 = t10;
				double t12 = (t10 + t11)* t11;
				double t13 = (t10 + t11 + t12)* t12;
				double t14 = (t10 + t11 + t12 + t13)* t13;
				double t15 = (t10 + t11 + t12 + t13 + t14)* t14;
				double t16 = (t10 + t11 + t12 + t13 + t14 + t15)* t15;
				double t17 = (t10 + t11 + t12 + t13 + t14 + t15 + t16)* t16;
				double t18 = (t10 + t11 + t12 + t13 + t14 + t15 + t16 + t17)* t17;
				double t19 = (t10 + t11 + t12 + t13 + t14 + t15 + t16 + t17 + t18)* t18;
				double t20 = (t10 + t11 + t12 + t13 + t14 + t15 + t16 + t17 + t18 + t19)* t19;
				double t21 = t20;
				double t22 = (t20 + t21)* t21;
				double t23 = (t20 + t21 + t22)* t22;
				double t24 = (t20 + t21 + t22 + t23)* t23;
				double t25 = (t20 + t21 + t22 + t23 + t24)* t24;
				double t26 = (t20 + t21 + t22 + t23 + t24 + t25)* t25;
				double t27 = (t20 + t21 + t22 + t23 + t24 + t25 + t26)* t26;
				double t28 = (t20 + t21 + t22 + t23 + t24 + t25 + t26 + t27)* t27;
				double t29 = (t20 + t21 + t22 + t23 + t24 + t25 + t26 + t27 + t28)* t28;
				double t30 = (t20 + t21 + t22 + t23 + t24 + t25 + t26 + t27 + t28 + t29)* t29;
			
				double t31 = t30;
				double t32 = (t30 + t31)* t31;
				double t33 = (t30 + t31 + t32)* t32;
				double t34 = (t30 + t31 + t32 + t33)* t33;
				double t35 = (t30 + t31 + t32 + t33 + t34)* t34;
				double t36 = (t30 + t31 + t32 + t33 + t34 + t35)* t35;
				double t37 = (t30 + t31 + t32 + t33 + t34 + t35 + t36)* t36;
				double t38 = (t30 + t31 + t32 + t33 + t34 + t35 + t36 + t37)* t37;
				double t39 = (t30 + t31 + t32 + t33 + t34 + t35 + t36 + t37 + t38)* t38;
				double t40 = (t30 + t31 + t32 + t33 + t34 + t35 + t36 + t37 + t38 + t39)* t39;
			
				double t41 = t40;
				double t42 = (t40 + t41)* t41;
				double t43 = (t40 + t41 + t42)* t42;
				double t44 = (t40 + t41 + t42 + t43)* t43;
				double t45 = (t40 + t41 + t42 + t43 + t44)* t44;
				double t46 = (t40 + t41 + t42 + t43 + t44 + t45)* t45;
				double t47 = (t40 + t41 + t42 + t43 + t44 + t45 + t46)* t46;
				double t48 = (t40 + t41 + t42 + t43 + t44 + t45 + t46 + t47)* t47;
				double t49 = (t40 + t41 + t42 + t43 + t44 + t45 + t46 + t47 + t48)* t48;
				double t50 = (t40 + t41 + t42 + t43 + t44 + t45 + t46 + t47 + t48 + t49)* t49;
				return t50;
			});
			if (i % (BATCH_ZISE) == 0) {
				System.out.print(".");
			}
			if (i % (DOTS_PER_LINE * BATCH_ZISE) == 0) {
				System.out.println("");
			}
		}

	}

	public static void main(String[] args) {
		long startTime = 0;
		long stopTime = 0;
		long elapsedTime = 0;

		
		System.out.println("1.8 Version - Using Lambda Expression");
		startTime = System.currentTimeMillis();
		usingLambdaExpression();
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nExcecution Time: " + elapsedTime
				+ " (miliseconds)");
		
		/*
		System.out.println("1.7 Version - Using Anonymous Inner Class");
		startTime = System.currentTimeMillis();
		usingAnonymous();
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nExcecution Time: " + elapsedTime
				+ " (miliseconds)");
		*/
	}
}
