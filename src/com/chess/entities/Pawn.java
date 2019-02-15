package com.chess.entities;

public class Pawn extends Piece {

	@Override
	public boolean validateForPiece(int srcX, int srcY, int destX, int destY) {
		if(Board.TOP_WHITE) {
			if(this.getColor()=='W' && destX-srcX<0)
				return false;
			if(this.getColor()=='B' && destX-srcX>0)
				return false;
		}
		else {
			if(this.getColor()=='B' && destX-srcX<0)
				return false;
			if(this.getColor()=='W' && destX-srcX>0)
				return false;
		}
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
//			if(Board.CHESS_BOARD[destX][destY]=="--")
			return true;
		}
		return false;
	}

}
