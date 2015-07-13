package com.csc.lap.features.metaspace;

public class ClassLoader {

	static javassist.ClassPool cp = javassist.ClassPool.getDefault();

	public static void main(String[] args) {
		try {
			for (int i = 0; i < 100000; i++) {
				Class c = cp.makeClass("testclass" + i).toClass();
			}
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
