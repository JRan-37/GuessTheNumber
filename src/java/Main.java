
public class Main {

    public static void main(String[] args) {
        GuessNumber gn = new GuessNumber();
        gn.setName();

        boolean run = true;

        while(run) {
            boolean correctGuess;
            do {
                correctGuess = gn.guess();
            } while (!correctGuess);
            run = gn.replay();
        }

    }
}
