package com.sivaji;

public class Player {
	private int id;
	private String name;
	private Symbol symbol;
	private int score;
	
	public Player(int id, String name, Symbol symbol)
	{
		this.id=id;
		this.name=name;
		this.symbol=symbol;
		this.score=0;
	}
	public Symbol getSymbol()
	{
		return symbol;
	}
	public String getName()
	{
		return name;
	}

}
