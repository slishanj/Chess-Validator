package com.chess.entities;

public class Horse extends Piece {

	@Override
	public boolean validateForPiece(int srcX, int srcY, int destX, int destY) {
		if(Math.abs(srcX-destX)==2 && Math.abs(srcY-destY)==1) {
			return true;
		}
		else if(Math.abs(srcY-destY)==2 && Math.abs(srcX-destX)==1) {
			return true;
		}
		return false;
	}

}
