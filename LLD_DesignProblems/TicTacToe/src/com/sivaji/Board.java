package com.sivaji;

import java.util.Arrays;

public class Board {
	
	private Symbol[][] grid;
	private int size;
	private Symbol empty;
	
	public Board(int size)
	{
		this.size=size;
		this.grid=new Symbol[size][size];
		empty=new Symbol('-');
		for(int i=0;i<size;i++)
		{
			Arrays.fill(grid[i], empty);
		}		
	}
	
	public boolean isCellEmpty(int row, int col)
	{
		return grid[row][col]==empty;
	}
	
	public void placeMark(int row, int col,Symbol symbol)
	{
		this.grid[row][col]=symbol;
	}
	
	public Symbol getCell(int row, int col)
	{
		return grid[row][col];
	}
	public int getSize()
	{
		return size;
	}
	public void display()
	{
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				System.out.print(getCell(i,j).getMark()+" ");
			}
			System.out.println();
		}
	}
	

}
