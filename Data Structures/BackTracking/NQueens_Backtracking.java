package BackTracking;

import java.util.Scanner;

public class NQueens_Backtracking {

    public static void printBoard(char[][]board){
        System.out.println("---------CHESS BOARD-----------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char[][] board, int row, int column){
        // for vertically up
        for (int i = row-1; i >=0 ; i--) {
            if(board[i][column]=='Q') return false;
        }

        //for left diagonal
        for (int i = row-1,j=column-1; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q') return false;
        }

        //for right diagonal
        for (int i = row-1 , j=column+1; i>=0 && j<board.length ; i--,j++) {
            if(board[i][j]=='Q') return false;
        }
        return true;
    }

    public static void nQueens(char [][] board,int row){
        // base case
        if(row==board.length){
            printBoard(board);
            return;
        }
        // recursion
        for (int j = 0; j < board.length; j++) {
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                nQueens(board,row+1); // function call
                board[row][j]='x'; // backtracking
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        char [][] board = new char[n][n];

        // initialise
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j]='x';
        nQueens(board,0);
    }
}