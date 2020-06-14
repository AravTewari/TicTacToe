package tictactoe;

import java.util.*;

public class Main
{
    static Scanner scanner = new Scanner(System.in);

    static char[][] board = new char[3][3];
    static int xCord, yCord;
    static boolean gameDone = false;
    static boolean playerOne = true;

    public static void main(String[] args)
    {
        fillTable(board);
        drawTable(board);

        while (!gameDone)
        {
            getCoordinates(playerOne);
            drawTable(board);
            checkGame(board);
            playerOne = !playerOne;
        }
    }

//   private static void getInput() /** gets matrix input from user as String **/
//    {
//        System.out.println("Enter cells: ");
//        String cells = scanner.next();
//        fillTable(board, cells);
//    }

    private static char[][] fillTable(char[][] arr) /** fills the whole matrix by the String put by the user **/
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                arr[i][j] = ' ';
            }
        }
        return arr;
    }

    private static void drawTable(char[][] arr) /** draws matrix as a table **/
    {
        System.out.println("---------");
        for(int i = 0; i < 3; i++)
        {
            System.out.print("| ");
            for(int j = 0; j < 3; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private static void getCoordinates(boolean playerOne) /** gets coordinates and checks whether it satisfies specific conditions **/
    {
        System.out.print((playerOne ? "Player X, " : "Player O, ") + "enter coordinates: ");
        while(true)
        {
            while(!(scanner.hasNextInt()))
            {
                System.out.println("You should enter numbers!");
            }

            xCord = scanner.nextInt();
            yCord = scanner.nextInt();

            if(xCord > 3 || xCord < 1 || yCord > 3 || yCord < 1)
            {
                System.out.println("Coordinates should be from 1 to 3!");
            }
            else
            {
                ninetyRight(board);
                if(isEmpty(board, xCord, yCord))
                {
                    fillValue(board, playerOne ? 'X' : 'O', xCord, yCord);
                    ninetyLeft(board);
                    break;
                }
                else
                {
                    System.out.println("This cell is occupied! Choose another one!");
                    ninetyLeft(board);
                }
            }
        }
    }

    private static boolean isEmpty(char[][] arr, int X, int Y) /** checks whether the chosen coordinates are empty **/
    {
        return (arr[X-1][Y-1] == ' ' || arr[X-1][Y-1] == '_');
    }

    private static boolean checkGame(char[][] board) /** checks game condition **/
    {
        boolean threeInRow = false;
        boolean threeX = false;
        boolean threeO = false;
        boolean blank = false;
        int xCount = 0;
        int oCount = 0;
        String result = "";

        for (char[] arr: board)
        {
            for (char ch: arr)
            {
                if(ch == ' ' || ch == '_')
                {
                    blank = true;
                }
                else if (ch == 'X')
                {
                    xCount++;
                }
                else
                {
                    oCount++;
                }
            }
        }
        if (!blank || xCount > 2 || oCount > 2)
        {
            for (int i = 0; i < 3; i++)
            {
                if (board[i][0] == board[i][1] && board[i][1] == board[i][2])
                {
                    threeInRow = true;
                    if (board[i][0] == 'X')
                    {
                        threeX = true;
                    }
                    if (board[i][0] == 'O')
                    {
                        threeO = true;
                    }
                }
                else if (board[0][i] == board[1][i] && board[1][i] == board[2][i])
                {
                    threeInRow = true;
                    if (board[0][i] == 'X')
                    {
                        threeX = true;
                    }
                    if (board[0][i] == 'O')
                    {
                        threeO = true;
                    }
                }
            }
            if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) || (board[0][2] == board[1][1] && board[1][1] == board[2][0]))
            {
                threeInRow = true;
                if (board[1][1] == 'X')
                {
                    threeX = true;
                }
                else
                {
                    threeO = true;
                }
            }

            if (!threeInRow && !blank)
            {
                result = "Draw";
                gameDone = true;
            }
            else if (threeX && !threeO)
            {
                result = "X wins";
                gameDone = true;
            }
            else if (threeO && !threeX)
            {
                result = "O wins";
                gameDone = true;
            }
            else if ((threeO && threeX) || (Math.abs(xCount - oCount) >= 2))
            {
                result = "Impossible";
                gameDone = true;
            }
            System.out.println(result);
        }
        else
        {
            gameDone = false;
        }

        return gameDone;
    }

    private static char[][] fillValue(char[][] arr, char value, int X, int Y) /** fills matrix with a specific value **/
    {
        arr[X-1][Y-1] = value;
        return arr;
    }

    private static char[][] ninetyRight(char[][] arr) /** rotates matrix to 90 degrees right **/
    {
        char[][] carr = new char[3][3];
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                carr[i][j] = arr[i][j];
            }
        }

        int k = 2;
        for(int i = 0; i < 3; i++)
        {
            arr[0][i] = carr[k][0];
            arr[1][i] = carr[k][1];
            arr[2][i] = carr[k][2];
            k--;
        }
        return arr;
    }

    private static char[][] ninetyLeft(char[][] arr) /** rotates matrix to 90 degrees left **/
    {
        for(int i = 0; i < 3; i++){
            ninetyRight(arr);
        }
        return arr;
    }
}
