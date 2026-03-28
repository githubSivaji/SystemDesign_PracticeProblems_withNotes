package com.sivaji;

public interface Rules {
	
	public boolean isValidMove(Board board, int row, int col);
	
	public boolean checkWin(Board board , int row, int col, Symbol symbol);
	
	public boolean checkDraw(Board board);

}
