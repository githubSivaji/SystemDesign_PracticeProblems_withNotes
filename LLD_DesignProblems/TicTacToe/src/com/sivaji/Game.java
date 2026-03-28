package com.sivaji;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Game {

	private Board board;

	// used for player turning
	private Deque<Player> players;

	private Rules rules;

	private List<IObserver> observers;

	private boolean gameOver;

	public Game(int size, Rules rules) {
		this.board = new Board(size);
		this.players = new ArrayDeque<>();
		this.rules = rules;
		this.observers = new ArrayList<>();
		this.gameOver = false;
	}
	 // ✅ Add player
    public void addPlayer(Player player) {
        players.offer(player);
    }
    // ✅ Add observer
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }
    
    // ✅ Notify observers
    private void notifyObservers(String message) {
        for (IObserver obs : observers) {
            obs.update(message);
        }
    }
    
    public void play() {
        Scanner sc = new Scanner(System.in);

        notifyObservers("Game Started!");

        while (!gameOver) {
            Player currentPlayer = players.poll(); // take turn

            board.display();
            notifyObservers(currentPlayer.getName() + "'s turn");

            System.out.println("Enter row ");
            int row = sc.nextInt();
            System.out.println("Enter col");
            int col = sc.nextInt();

            // ✅ Validate move
            if (!rules.isValidMove(board, row, col)) {
                notifyObservers("Invalid move! Try again.");
                players.offerFirst(currentPlayer); // same player retry
                continue;
            }

            // ✅ Place move
            board.placeMark(row, col, currentPlayer.getSymbol());

            // ✅ Check win
            if (rules.checkWin(board, row, col, currentPlayer.getSymbol())) {
                board.display();
                notifyObservers("🎉 " + currentPlayer.getName() + " wins!");
                gameOver = true;
                return;
            }

            // ✅ Check draw
            if (rules.checkDraw(board)) {
                board.display();
                notifyObservers("Game is a draw!");
                gameOver = true;
                return;
            }

            // ✅ Next turn
            players.offer(currentPlayer);
        }
    }

}
