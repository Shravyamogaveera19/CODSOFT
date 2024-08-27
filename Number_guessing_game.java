import java.util.Scanner;
class Game
{
    int HARD_TURNS;
    int EASY_TURNS;
    int turns;
    Game()
    {
        HARD_TURNS = 5;
        EASY_TURNS = 10;
        turns = 0;
    }
    Scanner sc= new Scanner(System.in);
    public void set_difficulty()
    {
        System.out.println("Choose a level : Type 'e' for easy or 'h' for hard");
        char level = sc.next().charAt(0);
        if (level == 'e')
            turns = EASY_TURNS;
        else
            turns = HARD_TURNS;      
    }
    public void games()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\nWelcome to number guessing game");
        System.out.println ("The number is in between 1 - 100");

        set_difficulty();
        int num = (int)(Math.random()*(100 - 1 +1)+1);
        int guess = 0;
        while(turns > 0)
        {
            System.out.println("You have " +(turns) +" attempts left...What is your guess?");
            guess = sc.nextInt();
            if(guess == num)
            {
                System.out.println("You got it! The number is:"+num);
                break;
            }
            else if(guess < num)
            {
                System.out.println("Too Low!");
            }
            else{
                System.out.println("Too High!");
            }
            turns -= 1;
            if(turns == 0)
            {
                System.out.println("You ran out of attemps, You lose!");
                System.out.println("The number is:"+num);
            }
            else
               System.out.println("Try again");
        }
    }
}
class Number_guessing_game
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Game A = new Game();
        Boolean program_continue = true;
        while(program_continue)
        {
            A.games();
            System.out.println("Do you want to continue playing ? Type 'y' for YES or 'n' for 'NO'");
            char should_continue = sc.next().charAt(0);
            if(should_continue == 'y')
                program_continue = true;
            else
                program_continue = false; 
        }
    }  
}