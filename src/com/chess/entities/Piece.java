package com.chess.entities;

public abstract class Piece {

	private char color;
	
	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}

	
	public abstract boolean validateForPiece(int srcX, int srcY, int destX, int destY);
	
	public void move(int srcX, int srcY, int destX, int destY, String piece) {
		Board.CHESS_BOARD[destX][destY]=piece;
		Board.CHESS_BOARD[srcX][srcY]="--";
	}
	
	public boolean checkMiddlePieces(int srcX, int srcY, int destX, int destY) {
		if(srcX==destX && srcY!=destY) {
			for(int i=srcY+1;i<destY;i++) {
				if(Board.CHESS_BOARD[destX][i]!="--")
					return false;
			}
		}
		else if(srcX!=destX && srcY==destY) {
			for(int i=srcX+1;i<destX;i++) {
				if(Board.CHESS_BOARD[i][destY]!="--")
					return false;
			}
		}
		else if(Math.abs(srcX-destX)==Math.abs(srcY-destY)) {
			for(int i=srcX+1,j=srcY+1;i<destX && j<destY;i++,j++) {
				if(Board.CHESS_BOARD[i][destY]!="--")
					return false;
			}
		}
		return true;
	}
	
	public boolean validateFirst(int srcX, int srcY, int destX, int destY, String piece) {
		char color = piece.charAt(0);
		if(srcX>=8 || destX>=8 || srcY>=8 || destY>=8) {
			System.out.println("Exception handled");
			return false;
		}
		if(Board.CHESS_BOARD[srcX][srcY].equals("--")) {
			System.out.println("Invalid move: No piece in this place");
			return false;
		}
		if(!Board.CHESS_BOARD[srcX][srcY].equals(piece)) {
			System.out.println("Invalid move: Different piece at given source");
			return false;
		}
		if(Board.CHESS_BOARD[destX][destY]!="--") {
			if(Board.CHESS_BOARD[destX][destY].charAt(0)==color) {
				System.out.println("Invalid move: Your color piece at that place");
				return false;
			}
		}
		return true;
	}
}
