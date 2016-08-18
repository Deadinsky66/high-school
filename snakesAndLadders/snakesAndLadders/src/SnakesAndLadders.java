/*SnakesAndLadders
* Snakes and Ladders; you against the computer
* Thomas Dedinsky
* 25/04/2016
*/
import java.io.*;
public class SnakesAndLadders
{
    public static void main (String args[]) throws IOException
    {   //I print the welcome screen and instructions
        System.out.println("Welcome To Snakes And Ladders\n\nInstructions:\nThis program will simulate a regular snakes and ladders game, where you will be");
        System.out.println("facing the computer. You and the computer start at square 1, and the first one to\nsquare 100 wins, however, there will be preset squares which will be the snakes or ladders.");
        System.out.println("Once you land on top of a snake you go down a few squares, and move up if you land\non the bottom of a ladder. Good Luck and Have FUN!!!");
        //I print the game board using a for loop
        System.out.println("--------------------------------Game Board--------------------------------");
        for (int i=100;i>0;i--)
        {
            System.out.print(i+"\t");
            if (i%10==1) {System.out.println();}
        }
        System.out.println ("--------------------------------------------------------------------------");
        //I ask the user if they want to play and call upon confirmation();
        System.out.println("Do you want to play? (Y/N)");
        char sGame = confirmation();
        while (sGame=='Y'||sGame=='y')
        {
           //I start the game
           startGame();
           //When they're done, I ask them if they want to play again and trap them until they don't
           System.out.println("Do you want to play again? (Y/N)");
           sGame = confirmation();
        }
        //I wish them goodbye
        System.out.println ("Bye!");
    }
    /*Description - char method that asks the user a yes/no question
     Pre - Passes a character
     Post - Returns a Y/N response
    */
    public static char confirmation()
    {   //I ask for user input for a Y or N char
        char confirmation=In.getChar();
        //I loop a response if the inputted character isn't valid
        while (confirmation!='Y'&&confirmation!='y'&&confirmation!='N'&&confirmation!='n')
        {
            System.out.println("Please input a Y/N response.");
            confirmation=In.getChar();
        }
        //I return the response
        return confirmation;
    }
    /*Description - method that starts the game
     Pre - N/A
     Post - N/A
    */
    public static void startGame() throws IOException // Recieves data from the main method
    {   //I define a bunch of variables
        long tStart;long tEnd;
        int userPosition=1;int compPosition=1;int userRoll;int compRoll;int count=0;
        //I define my arrays, which act as the snakes and ladders' start and end points
        int snakesLaddersArray[] = {54,90,99,9,40,67,99};
        int newPosition[] = {19,48,77,34,64,86,91};
        //I loop the game until someone wins
        while (userPosition!=100&&compPosition!=100)
        {
            //I get the current time and add 1 to the round counter
            tStart=System.currentTimeMillis();
            count++;
            //I calculate the user's and computer's dice roll and show the user it
            userRoll = (int)Math.ceil(Math.random()*6)+(int)Math.ceil(Math.random()*6);
            compRoll = (int)Math.ceil(Math.random()*6)+(int)Math.ceil(Math.random()*6);
            System.out.println ("Round "+count+". You Rolled a "+userRoll+". The Computer Rolled a "+compRoll+".");
            //I add the roll to the players' positions
            userPosition+=userRoll;
            compPosition+=compRoll;
            //I call upon my userP() and compP() to determine if any additional moves are happening
            userPosition = userP(userPosition, userRoll, snakesLaddersArray, newPosition);
            compPosition = compP(compPosition, compRoll, snakesLaddersArray, userPosition, newPosition);
            //I tell the user where everyone is and I end the method after 2.3 seconds
            System.out.println ("You are currently on square "+userPosition+". The Computer is currently on square "+compPosition+".");
            do{tEnd=System.currentTimeMillis();}while (tEnd-tStart<2300);
        }
        return;
    }
    /*Description - int method that further calculates the user's roll
     Pre - Passes the user's position, roll, and snake/ladder start/stop arrays
     Post - Returns the user's position
    */
    public static int userP (int userPosition, int userRoll, int snakesLaddersArray[], int newPosition[])
    {   //I make a for loop that checks if the user is on a snake or ladder and moves them accordingly
        for (int i=0;i<snakesLaddersArray.length&&i<newPosition.length;i++)
        if(userPosition == snakesLaddersArray[i])
        {
            userPosition = newPosition[i];
            if (snakesLaddersArray[i]>newPosition[i]){System.out.println ("A snake bit you, you tripped and fell down the board.");}
            else {System.out.println ("You found a ladder. Climb it with pride!");}
        }
        //I make sure the user didn't jump over 100 and if they won I congratulate them before returning their position
        if (userPosition > 100)
        {
            userPosition -= userRoll;
            System.out.println ("You can't jump, you must land on a 100.");
        }
        else if (userPosition == 100){System.out.println ("You won, congrats!");}
        return userPosition;
    }
    /*Description - int method that further calculates the computer's roll
     Pre - Passes the computer's position, roll, and snake/ladder start/stop arrays
     Post - Returns the computer's position
    */
    public static int compP (int compPosition, int compRoll, int snakesLaddersArray[], int userPosition, int newPosition[])
    {   //I make a for loop that checks if the computer is on a snake or ladder and moves them accordingly
        for (int i=0;i<snakesLaddersArray.length&&i<newPosition.length;i++)
        if(compPosition == snakesLaddersArray[i])
        {
            compPosition = newPosition[i];
            if (snakesLaddersArray[i]>newPosition[i]){System.out.println ("A snake bit the computer, then tackled it down the board.");}
            else {System.out.println ("The computer found a ladder and hovered up it.");}
        }
        //I make sure the computer didn't jump over 100 and if they won I bash you before returning their position
        else if (compPosition>100)
        {
            compPosition -= compRoll;
            System.out.println ("The computer can't jump, he must land on a 100");
        }
        else if (compPosition == 100 && userPosition != 100){System.out.println ("The computer won, try harder next time.");}
        return compPosition;
    }
}