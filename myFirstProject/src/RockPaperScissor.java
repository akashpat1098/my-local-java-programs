
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissor {
    public static void main(String[] args) {

        System.out.println("Welcome to Rock Paper Scissor Game!");
        int i=0;
        int playerScore = 0, compScore = 0;

        while (i<3) {
            System.out.println("Enter 0 for Rock,1 for paper,2 for scissor");

            Scanner sc = new Scanner(System.in);
            int player1 = sc.nextInt();
            switch (player1) {
                case 0 -> System.out.printf("You entered %d i.e Rock\n", player1);
                case 1 -> System.out.printf("You entered %d i.e Paper\n", player1);
                case 2 -> System.out.printf("You entered %d i.e Scissor\n", player1);
                default -> {
                    System.out.println("You entered wrong input\n");
                    System.exit(0);
                }
            }

            Random rdm = new Random();
            int comp = rdm.nextInt(3);
            switch (comp) {
                case 0 -> System.out.printf("Computer chose %d i.e Rock\n", comp);
                case 1 -> System.out.printf("Computer chose %d i.e Paper\n", comp);
                case 2 -> System.out.printf("Computer chose %d i.e Scissor\n", comp);
            }


            if (player1 == comp) {
                System.out.println("*******Game is Tied*******");
                playerScore += 1;
                compScore += 1;
            } else if (player1 == 0 && comp == 2 || player1 == 1 && comp == 0 || player1 == 2 && comp == 1) {
                System.out.println("*******You won!*******");
                playerScore += 1;
            } else  {
                System.out.println("*******Computer won!*******");
                compScore += 1;
            }

            System.out.printf("playerScore=%d,CompScore=%d\n", playerScore, compScore);

            i++;
        }



    }
}
