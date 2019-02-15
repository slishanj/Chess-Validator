package com.chess.entities;

public class Queen extends Piece {

	@Override
	public boolean validateForPiece(int srcX, int srcY, int destX, int destY) {
		if((srcX==destX && srcY!=destY)
				|| (srcY==destY && srcX!=destX)
				|| Math.abs(srcX-destX)==Math.abs(srcY-destY)) {
			return checkMiddlePieces(srcX, srcY, destX, destY);
		}
		return false;
	}

}
