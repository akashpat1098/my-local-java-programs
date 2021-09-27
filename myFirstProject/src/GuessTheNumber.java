

import java.util.Random;
import java.util.Scanner;
//Game Class is created
class Game {
    int inputNumber, randomNumber,noOfGuess=0;
    //Game constructor is created to take random number
    Game(){     // Random number is automatically created while Game object is created
        Random rd=new Random();
        randomNumber=rd.nextInt(100);
    }
//    method to take input number is created
    void takeInputNumber() {
        Scanner sc = new Scanner(System.in);
        inputNumber = sc.nextInt();
        sc.close();
    }
    //method for checking the number
    boolean isCorrectNumber() {
        noOfGuess++;  //value is updated everytime this method is called
        if (inputNumber == randomNumber) {
            System.out.format("%d number is Correct.You guessed in %d attempts",inputNumber,noOfGuess);
            return true;
        }
        else if (inputNumber < randomNumber){
            System.out.println("The number is too low");
        }
        else if (inputNumber > randomNumber){
            System.out.println("The number is too high");
        }
        return false;
    }
}
public class GuessTheNumber {
    public static void main(String[] args) {
        Game g1=new Game();
        boolean b=false;
        // the loop is active until correct number is found
       while (!b) {
           System.out.println("Guess the number");
           g1.takeInputNumber();
           b = g1.isCorrectNumber();
       }
    }

}
