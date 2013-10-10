import java.util.Random;
import java.util.Scanner;
public class PickACard69fuckyoumike{
    private static int totalpoints;
    public static void main(String[] args){
        game();
    }

    public static void game(){
        System.out.println("Press Enter to Begin!");
        for(int x = 0; x<5; x++){
            Random generator = new Random();
            int card = generator.nextInt(4);
            int die = generator.nextInt(6) + 1;
            totalpoints = pickACard(die, card) + totalpoints;
        }
        System.out.println("You ended up with " + totalpoints + " points.");
    }

    public static int pickACard(int die, int card){
        int points = 0;
        Scanner user_input = new Scanner(System.in);
        String turn = user_input.nextLine();
        if(turn.equals("")){

            if(card == 0){
                System.out.println("You rolled a " + die + " and your card was " + card + ".");
                points--;
                System.out.println("You lost one point.");
            }
            else if(card == 1){
                System.out.println("You rolled a " + die + " and your card was " + card + ".");
                System.out.println("Nothing happened.");
            }
            else if(card == 2){
                System.out.println("You rolled a " + die + " and your card was " + card + ".");
                points++;
                System.out.println("You got one point.");
            }

            else{
                System.out.println("You rolled a " + die + " and your card was " + card + ".");
                points = die;
                System.out.println("Your lucky day! You got " + die + " points!");
            }
        }
        System.out.println("Press enter to roll again!");
        return points;
    }
}