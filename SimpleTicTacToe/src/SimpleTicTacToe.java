import java.util.Arrays;
import java.util.Scanner;

public class SimpleTicTacToe {
    public static boolean draw = false;
    public static boolean impossible = false;
    public static boolean notFinished = false;
    public static boolean xWins = false;
    public static boolean oWins = false;

    public static void main(String[] args) {
        char[][] field = new char[3][3];
        for (char[] chars : field) {
            Arrays.fill(chars, ' ');
        }
        System.out.println("---------");
        System.out.printf("| %s %s %s |\n", field[0][0], field[0][1], field[0][2]);
        System.out.printf("| %s %s %s |\n", field[1][0], field[1][1], field[1][2]);
        System.out.printf("| %s %s %s |\n", field[2][0], field[2][1], field[2][2]);
        System.out.println("---------");

        Scanner s = new Scanner(System.in);

        while (true) {
            while (true) {
                System.out.println("Enter the coordinates: ");
                int x1, x2;
                x1 = s.nextInt();
                x2 = s.nextInt();
                if (x1 < 1 || x1 > 3 || x2 < 1 || x2 > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    if (field[x1 - 1][x2 - 1] != ' ') {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        field[x1 - 1][x2 - 1] = 'X';
                        break;
                    }
                }
            }
            print(field);
            check(field);
            if (!notFinished || xWins || oWins || draw) {
                break;
            }
            while (true) {
                System.out.println("Enter the coordinates: ");
                int x1, x2;
                x1 = s.nextInt();
                x2 = s.nextInt();
                if (x1 < 1 || x1 > 3 || x2 < 1 || x2 > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    if (field[x1 - 1][x2 - 1] != ' ') {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        field[x1 - 1][x2 - 1] = 'O';
                        break;
                    }
                }
            }
            print(field);
            check(field);
            if (!notFinished || xWins || oWins || draw) {
                break;
            }
        }
    }

    public static void check(char[][] field) {

        int xTotal = 0;
        int oTotal = 0;
        for (char[] chars : field) {
            for (char aChar : chars) {
                if (aChar == 'X') {
                    xTotal += 1;
                }
                if (aChar == 'O') {
                    oTotal += 1;
                }
            }
        }

        xWins =
                field[0][0] + field[0][1] + field[0][2] == 264 ||
                        field[1][0] + field[1][1] + field[1][2] == 264 ||
                        field[2][0] + field[2][1] + field[2][2] == 264 ||
                        field[0][0] + field[1][0] + field[2][0] == 264 ||
                        field[0][1] + field[1][1] + field[2][1] == 264 ||
                        field[0][2] + field[1][2] + field[2][2] == 264 ||
                        field[0][0] + field[1][1] + field[2][2] == 264 ||
                        field[2][0] + field[1][1] + field[0][2] == 264;
        oWins =
                field[0][0] + field[0][1] + field[0][2] == 237 ||
                        field[1][0] + field[1][1] + field[1][2] == 237 ||
                        field[2][0] + field[2][1] + field[2][2] == 237 ||
                        field[0][0] + field[1][0] + field[2][0] == 237 ||
                        field[0][1] + field[1][1] + field[2][1] == 237 ||
                        field[0][2] + field[1][2] + field[2][2] == 237 ||
                        field[0][0] + field[1][1] + field[2][2] == 237 ||
                        field[2][0] + field[1][1] + field[0][2] == 237;

        // Calculating if the match is impossible or drawn and printing it to console
        if (Math.abs(xTotal - oTotal) > 1 || oWins && xWins) {
            impossible = true;
            System.out.println("Impossible");

        } else if (Math.abs(xTotal + oTotal) == 9 && !oWins && !xWins) {
            draw = true;
            System.out.println("Draw");
        }

        // If game is neither drawn nor impossible, checking if it is won and printing it to console
        if (!draw && !impossible) {
            if (xWins) {
                System.out.println("X wins");
            }
            if (oWins) {
                System.out.println("O wins");
            }
        }

        // If nothing happened yet, checking if the game is not finished and printing it to console
        if (!draw && !impossible && !xWins && !oWins) {
            for (char[] chars : field) {
                for (char aChar : chars) {
                    if (aChar == ' ') {
                        notFinished = true;
                        break;
                    }
                }
            }
        }

        if (!notFinished) {
            System.out.println("Game not finished");
        }
    }

    public static void print(char[][] field) {
        System.out.println("---------");
        for (int i = 0; i < 3; ++i) {
            System.out.print("| ");
            for (int j = 0; j < 3; ++j) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
