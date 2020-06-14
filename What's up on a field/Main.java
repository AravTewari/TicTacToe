package tictactoe;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        text.trim();

        char[][] symbols =
                {
                        {text.charAt(0), text.charAt(1), text.charAt(2)},
                        {text.charAt(3), text.charAt(4), text.charAt(5)},
                        {text.charAt(6), text.charAt(7), text.charAt(8)}
                };

        printDash();
        printGameLine(text.charAt(0), text.charAt(1), text.charAt(2));
        printGameLine(text.charAt(3), text.charAt(4), text.charAt(5));
        printGameLine(text.charAt(6), text.charAt(7), text.charAt(8));
        printDash();
        checkGame(symbols);
    }

    private static void printDash()
    {
        for (int i=0; i<9; i++)
        {
            System.out.print("-");
        }
        System.out.println("-");
    }

    private static void printGameLine(char... symbols)
    {
        System.out.print("| ");

        for (int i = 0; i < symbols.length; i++)
        {
            System.out.print(symbols[i] + " ");
        }

        System.out.println("|");
    }

    private static void checkGame(char[][] symbols)
    {
        boolean threeInRow = false;
        boolean threeX = false;
        boolean threeO = false;
        //USE FOR EACH TO DO blank, xCount, oCount!!
        boolean blank = false;
        int xCount = 0;
        int oCount = 0;
        String result = "";

        for (char[] arr: symbols)
        {
            for (char ch: arr)
            {
                if(ch == '_')
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


        for (int i = 0; i < 3; i++)
        {
            if (symbols[i][0] == symbols[i][1] && symbols[i][1] == symbols[i][2])
            {
                threeInRow = true;
                if (symbols[i][0] == 'X')
                {
                    threeX = true;
                }
                if (symbols[i][0] == 'O')
                {
                    threeO = true;
                }
            }
            else if (symbols[0][i] == symbols[1][i] && symbols[1][i] == symbols[2][i])
            {
                threeInRow = true;
                if (symbols[0][i] == 'X')
                {
                    threeX = true;
                }
                if (symbols[0][i] == 'O')
                {
                    threeO = true;
                }
            }
        }
        if ((symbols[0][0] == symbols[1][1] && symbols[1][1] == symbols[2][2]) || (symbols[0][2] == symbols[1][1] && symbols[1][1] == symbols[2][0]))
        {
            threeInRow = true;
            if (symbols[1][1] == 'X')
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
        }
        else if (threeX && !threeO)
        {
            result = "X wins";
        }
        else if (threeO && !threeX)
        {
            result = "O wins";
        }
        else if ((threeO && threeX) || (Math.abs(xCount - oCount) >= 2))
        {
            result = "Impossible";
        }
        else
        {
            result = "Game not finished";
        }
        System.out.println(result);
    }
}
