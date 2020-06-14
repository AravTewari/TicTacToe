package tictactoe;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        printDash();
        printGameLine(text.charAt(0), text.charAt(1), text.charAt(2));
        printGameLine(text.charAt(3), text.charAt(4), text.charAt(5));
        printGameLine(text.charAt(6), text.charAt(7), text.charAt(8));
        printDash();
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
        Scanner sc = new Scanner(System.in);

        System.out.print("| ");

        for (int i = 0; i < symbols.length; i++)
        {
            System.out.print(symbols[i] + " ");
        }

        System.out.println("|");
    }
}
