package com.backend.testing;

public class Mehtodchaining {

	public static Mehtodchaining a()
	{
		System.out.println("execute method a");
		return new Mehtodchaining();
	}
	public static Mehtodchaining b()
	{
		System.out.println("execute method b");
		return new Mehtodchaining();
	}
	public static Mehodchaining2 c()
	{
		System.out.println("execute method c");
		return new Mehodchaining2();
	}
}
