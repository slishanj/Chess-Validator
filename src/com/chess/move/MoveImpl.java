package com.chess.move;

import com.chess.entities.Piece;
import com.chess.factory.PieceFactory;

public class MoveImpl implements Move {

	String piece;
	int srcX;
	int srcY;
	int destX;
	int destY;
	char color;
	char pieceType;
	
	private void initializeValues(String inputMove[]) {
		piece = inputMove[0];
		srcX = Integer.parseInt(""+inputMove[1].charAt(0));
		srcY = Integer.parseInt(""+inputMove[1].charAt(1));
		destX = Integer.parseInt(""+inputMove[2].charAt(0));
		destY = Integer.parseInt(""+inputMove[2].charAt(1));
		color = piece.charAt(0);
		pieceType = piece.charAt(1);
		
	}
	//alternate movement, check mate, winning logic, castling, pawn to queen conversion
	//camel movement
	
	@Override
	public void move(String inputMove[]) {
		initializeValues(inputMove);
		Piece pieceObj = PieceFactory.getPiece(piece);
		boolean check1=pieceObj.validateFirst(srcX, srcY, destX, destY, piece);
		boolean check2=pieceObj.validateForPiece(srcX, srcY, destX, destY);
		if(!check1 || !check2)
			System.out.println("Invalid move");
		if(check1 && check2)
			pieceObj.move(srcX, srcY, destX, destY, piece);
	}
	
	/*public void move(String inputMove[]) {
		initializeValues(inputMove);
		Board.CHESS_BOARD[destX][destY]=piece;
		Board.CHESS_BOARD[srcX][srcY]="--";
		
//		BoardInitializer.displayBoardState();

	}
	
	public boolean validate(String inputMove[]) {
		initializeValues(inputMove);
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
			else {
				if(pieceType=='H') {
					if(Math.abs(srcX-destX)==2 && Math.abs(srcY-destY)==1) {
						return true;
					}
					else if(Math.abs(srcY-destY)==2 && Math.abs(srcX-destX)==1) {
						return true;
					}
				}
				else if(pieceType=='P') {
					if(((srcX==1 || srcX==6) && (Math.abs(destX-srcX)==2)) 
							|| ((srcX!=1 || srcX!=6) && (Math.abs(destX-srcX)==1)) 
							&& srcY==destY) {
						return true;
					}
					if(Math.abs(srcY-destY)==1) {
						if(Board.CHESS_BOARD[destX][destY]=="--")
						return true;
					}
					if(Math.abs(srcX-destX)==1 && Math.abs(srcY-destY)==1) {
//						if(Board.CHESS_BOARD[destX][destY]=="--")
						return true;
					}
				}
				else if(pieceType=='Q') {
					if((srcX==destX && srcY!=destY)
							|| (srcY==destY && srcX!=destX)
							|| Math.abs(srcX-destX)==Math.abs(srcY-destY)) {
						return checkMiddlePieces(inputMove);
					}
					
					
				}
				else if(pieceType=='K') {
					if(Math.abs(srcX-destX)==1 || Math.abs(srcY-destY)==1)
						return true;
				}
				else if(pieceType=='R') {
					if(srcX==destX || srcY==destY)
						return checkMiddlePieces(inputMove);
				}
			}
		}
		System.out.println("Invalid move");
		return false;
	}

	private boolean checkMiddlePieces(String[] inputMove) {
		
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
	}*/
}
