package com.chess.entities;

public class Rook extends Piece {

	@Override
	public boolean validateForPiece(int srcX, int srcY, int destX, int destY) {
		if(srcX==destX || srcY==destY)
			return checkMiddlePieces(srcX, srcY, destX, destY);
		return false;
	}
}