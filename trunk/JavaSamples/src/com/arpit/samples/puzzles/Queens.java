//package com.arpit.samples.puzzles;

public class Queens
{
	public static void main(String[] args)
	{
		int N = 8;
		if(args.length > 0)
		{
			N = Integer.parseInt(args[0]);
		}
		enumerate(N);
	}

	public static void enumerate(int N)
	{
		int[] board = new int[N];
		enumerate(board, 0);
	}

	private static void enumerate(int[] board, int row)
	{
		int N = board.length;
		if(row == N)
		{
			printQueens(board);
		}
		else
		{
			for(int col = 0; col < N; col++)
			{
				board[row] = col;
				if(isConsistent(board, row))
				{
					enumerate(board, row + 1);
				}
			}
		}
	}
	
	private static boolean isConsistent(int[] board, int row)
	{
		for(int prvsRows = 0; prvsRows < row; prvsRows++)
		{
			if(board[prvsRows] == board[row]) return false;
			if(board[prvsRows] - board[row] == prvsRows - row) return false;
			if(board[row] - board[prvsRows] == prvsRows - row) return false;
		}
		return true;
	}

	private static void printQueens(int[] board)
	{
		int N = board.length;
		for(int row = 0; row < N; row++)
		{
			for(int col = 0; col < N; col++)
			{
				if(board[row] == col)
					System.out.print("Q ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
