package com.chess.entities;

public class King extends Piece {

	@Override
	public boolean validateForPiece(int srcX, int srcY, int destX, int destY) {
		if(Math.abs(srcX-destX)==1 || Math.abs(srcY-destY)==1)
			return true;
		return false;
	}

}
