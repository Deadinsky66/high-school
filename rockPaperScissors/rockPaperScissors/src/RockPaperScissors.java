/*RockPaperScissors
* Software that will play a rock-paper-scissors game with the computer to 10.
* Thomas Dedinsky
* 08/04/2016
*/
class RockPaperScissors
{
    /*Description - int method that asks the user a rock/paper/scissors question
     Pre - N/A
     Post - Returns a 1/2/3 response
    */
    public static int userInput()
    {
        //I define important variables
        char confirmation; int userInput;
        //I ask the user for character response correlating to one of three moves
        confirmation = In.getChar();
        //If they don't do it right I harass them for a better answer
        while (confirmation!='R'&&confirmation!='r'&&confirmation!='P'&&confirmation!='p'&&confirmation!='S'&&confirmation!='s') {
            System.out.println("Input R, S, or P.");
            confirmation = In.getChar();
        }
        //I set each response to a numerical value before returning it
        if (confirmation=='R'||confirmation=='r') {userInput=1;}
        else if (confirmation=='P'||confirmation=='p') {userInput=2;}
        else {userInput=3;}
        return userInput;
    }
    
    /*Description - int method that calculates the computer's response and determines a winner
     Pre - Passes an int; the user's input
     Post - Returns a 0/1/2 response
    */
    public static int winner(int userInput)
    {
        //I define my variable that I will return to determine the winner
        int winner=0;
        System.out.print("The computer picked ");
        //I create the computer input and tell the user what that means to them
        int compInput = (int)Math.ceil(Math.random()*3);
        if (compInput==1) {System.out.println("rock!");}
        else if (compInput==2) {System.out.println("paper!");}
        else {System.out.println("scissors!");}
        //I determine if the user won, computer won, or if they tied, and return an int value correlating to that
        if (compInput==1&&userInput==2||compInput==2&&userInput==3||compInput==3&&userInput==1) {
            System.out.println("You win a match! Congrats!");
            winner=1;
        }
        else if (compInput==2&&userInput==1||compInput==3&&userInput==2||compInput==1&&userInput==3) {
            System.out.println("You lost a match! Better luck next time!");
            winner=2;
        }
        else {System.out.println("You guys tied! Rematch!");}
        return winner;
    }
    
    public static void main (String args[])
    {
        //I define a plethora of variables to be used in the near future.
        int userScore = 0; int compScore = 0; int round = 0; int winner;
        //I welcome the user and explain how the game works
        System.out.println("Welcome to Rock Paper Scissors Land (circa 1995). This is a game to 10.");
        System.out.println("R for Rock, S for Scissors, P for Paper.");
        //I create a while loop that only ends when the user reaches 10
        while (userScore!=10&&compScore!=10)
        {
            //I increment the round counter and show the user where they are standing
            round++;
            System.out.println("Round "+round+": You - "+userScore+" Computer - "+compScore+". What move do you choose?");
            //I determine the winner by determining the user input by passing a method in a method
            //It's meta as hell and I love it
            winner = winner(userInput());
            //I increment the user's or the computer's score depending on who wins
            if (winner==1) {userScore++;}
            else if (winner==2) {compScore++;}
        }
        //I tell the user if they won or lost
        if (userScore==10) {System.out.println("You won the whole game! Woot woot!");}
        else {System.out.println("You lost the whole game! How do you sleep at night man?");}
        //I display some stats
        System.out.println("Stats! Rounds - "+round+": You - "+userScore+" Computer - "+compScore+" Ties - "+(round-userScore-compScore));
    }
}