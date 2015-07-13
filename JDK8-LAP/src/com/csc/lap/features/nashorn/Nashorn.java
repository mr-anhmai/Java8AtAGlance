package com.csc.lap.features.nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Nashorn {

	public static void main(String[] args) {
		//Read *.js file and execute it
		System.out.println("====Read *.js file and execute it");
		ScriptEngineManager engineManager = new ScriptEngineManager();
		ScriptEngine engine = engineManager.getEngineByName("nashorn");
		try {
			engine.eval(new FileReader("js/js.js"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Execute JavaScript directly
		System.out.println("====Execute JavaScript directly");
		try {
			engine.eval("function p(s) { print(s) }");
			engine.eval("p('David')");
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Import classes from java
		System.out.println("====Import classes from java");
		try {
			engine.eval(new FileReader("js/js1.js"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Extends interface from java
		System.out.println("====Extends interface from java");
		try {
			engine.eval(new FileReader("js/js3.js"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Extends concrete classes from java
		System.out.println("====Extends concrete classes from java");
		try {
			engine.eval(new FileReader("js/js2.js"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Invoke JavaScript functions directly from Java
		System.out.println("====Invoke JavaScript functions directly from Java");
		Invocable inv = (Invocable)engine;
		inv.getInterface(SamplePrinter.class);
		try {
			inv.invokeFunction("p", "Hello");
		} catch (NoSuchMethodException | ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
