package com.sivaji;

public class StandardRules implements Rules {

	@Override
	public boolean isValidMove(Board board, int row, int col) {
		
		 int n = board.getSize();
	        return row >= 0 && row < n && col >= 0 && col < n 
	                && board.isCellEmpty(row, col);
	}

	@Override
	public boolean checkWin(Board board, int row, int col, Symbol symbol) {
		int n=board.getSize();
	    
		boolean rowCheck=true;
		for(int c=0;c<n;c++)
		{
			if(board.getCell(row, c)!=symbol)
			{
				  rowCheck=false;
				  break;
			}
		}
		
		boolean colCheck=true;
		for(int r=0;r<n;r++)
		{
			if(board.getCell(r,col)!=symbol)
			{
				colCheck=false;
				break;
			}
		}
		// ✅ Check Main Diagonal
        boolean diagWin = true;
        if (row == col) {
            for (int i = 0; i < n; i++) {
                if (board.getCell(i, i) != symbol) {
                    diagWin = false;
                    break;
                }
            }
        } else {
            diagWin = false;
        }

        // ✅ Check Anti-Diagonal
        boolean antiDiagWin = true;
        if (row + col == n - 1) {
            for (int i = 0; i < n; i++) {
                if (board.getCell(i, n - 1 - i) != symbol) {
                    antiDiagWin = false;
                    break;
                }
            }
        } else {
            antiDiagWin = false;
        }
		return rowCheck || colCheck || antiDiagWin || diagWin;
	}

	@Override
	public boolean checkDraw(Board board) {
		 int n = board.getSize();

	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                if (board.isCellEmpty(i, j)) {
	                    return false;
	                }
	            }
	        }
	        return true;
	}

}
