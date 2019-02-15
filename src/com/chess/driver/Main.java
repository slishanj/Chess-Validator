package com.chess.driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.chess.move.Move;
import com.chess.move.MoveImpl;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Move move = new MoveImpl();
		System.out.println("Input:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inp = br.readLine();
		if(inp.equals("Board")) {
			String board[][] = new String[8][8];
			for(int i=0;i<8;i++) {
				String row = br.readLine();
				String rowArr[]=row.split(" ");
				if(row.trim()!="")
				for(int j=0;j<8;j++) {
					board[i][j] = rowArr[j];
				}
			}
			BoardInitializer.initialize(board);
			System.out.println();
			System.out.println("INITIAL STATE:");
			BoardInitializer.displayBoardState();
		}
		else if(inp.equals("Display")) {
			BoardInitializer.initialize();
			System.out.println();
			System.out.println("INITIAL STATE:");
			BoardInitializer.displayBoardState();
		}
		inp=br.readLine();
		if(inp.equals("Moves")){
			while(inp!=null && inp.trim()!="") {
				if(inp.trim().equals(""))
					break;
				inp = br.readLine();
				if(inp.trim().equals(""))
					break;
				String inputMove[]=inp.split(" ");
//				if(move.validate(inputMove)) {
					move.move(inputMove);
//				}
				BoardInitializer.displayBoardState();
			}
		}
	}
}
