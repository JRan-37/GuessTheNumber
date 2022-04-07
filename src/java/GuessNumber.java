import java.util.Locale;
import java.util.Scanner;

public class GuessNumber {

    String name;
    Scanner inputReader;
    int randomNum;
    int guessCount;

    //Constructor insantiates scanner object, sets new random number with range of 1-20
    //and initializes guess counter with value of 0
    public GuessNumber(){

        inputReader = new Scanner(System.in);
        randomNum = (int)Math.floor(Math.random()*(20) + 1);
        guessCount = 0;
    }

    //Prompts user input to set name var as String
    public void setName(){
        System.out.println("Hello! What is your name?");
        name = getInput();
        System.out.println(String.format("Well, %s, I am thinking of a number between 1 and 20.", name));
    }

    //Prompts user input for a valid integer
    //increments guess counter and returns true if guess is correct, false if not
    public boolean guess(){
        System.out.println("Take a guess.");
        boolean invalid = true;
        int result = 0;
        //Input validation, keeps prompting until user enters valid integer
        while(invalid)
        {
            try{
                result = Integer.parseInt(getInput());
                invalid = false;
            }catch (NumberFormatException e)
            {
                System.out.println("Invalid input, please try again! (1-20)");
            }
        }

        if(compareGuess(result) > 0)
        {
            System.out.println("Your guess is too high.");
            guessCount++;
            return false;
        }
        else if(compareGuess(result) < 0)
        {
            System.out.println("Your guess is too low.");
            guessCount++;
            return false;
        }
        else
        {
            guessCount++;
            System.out.println(String.format("Good job, %s! You guessed my number in %d guesses!", name, guessCount));
            return true;
        }
    }

    //Prompts user input for yes/no response
    //Resets random guess and guess counter vars and returns true if met with yes response
    //Does nothing and returns false if no response is given
    public boolean replay(){
        System.out.println("Would you like to play again? (y or n)");
        if(getInput().toLowerCase().startsWith("y")){
            reset();
            return true;
        }
        else
            return false;
    }
    //Resets necessary values to allow game to be replayed
    private void reset(){
        randomNum = (int)Math.floor(Math.random()*(20) + 1);
        guessCount = 0;
    }
    //Returns comparison of guessed number and randomly generated number
    private int compareGuess(int number){
        return number - randomNum;
    }
    //Returns user input
    private String getInput(){
        String userInput;
        try{
            userInput = inputReader.nextLine();
        }
        catch(Exception e){
            userInput = "invalid";
        }

        return userInput;
    }

}
