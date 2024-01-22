import java.util.*;
public class NumberGuesser {
    //to take input of number anywhere
    public static int scan(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    } 

    //check the randomly generated number is equal to the user entered number and suggest if not 
    public static int game(int score, int r){
        System.out.println("Enter a number between 1 to 100");
        int g = scan();
        while(true){
            if(score == 0){
                System.out.println("you lost try again the actual number is "+r);
                return 0;
            }
            if(r == g){
                System.out.println("Right guess");
                System.out.println("your score is "+score);
                return score;
            }
            else if(r<g){
                System.out.println("number is smaller than guessed one, try again");
                score--;
                g = scan();
            }
            else if(r>g){
                System.out.println("number is greater than the guessed one, try again");
                score--;
                g = scan();
            }
        }
    }

    //To generate random number and setup no of chances to 10
    public static void runGame(){
        Random rand = new Random();
        int r = rand.nextInt(1,100);
        int score = 10;
        // int hscore = highScore(game(score,r),hscore);
        game(score,r);
    }

    //after completion of game check wether the user want to play again or not
    public static void checkPlayAgain(){
        while (true){
            System.out.println("enter 1 if you wanna play again 0 to exit");
            int k = scan();
            if(k == 1){
                System.out.println("Lets start again");
                runGame();
            }
            else{
                System.out.println("THANK YOU ...........\n\n\nEXIT");
                return;
            }
        }
    }
    public static void main(String[]args){
        runGame();
        checkPlayAgain();    
    }
    
}
