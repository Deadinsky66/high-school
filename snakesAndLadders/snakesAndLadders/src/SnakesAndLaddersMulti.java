/*SnakesAndLaddersMulti
* Snakes and Ladders; up to 8 people can play and there are duels!
* Thomas Dedinsky
* 26/04/2016
*/
import java.io.*;
public class SnakesAndLaddersMulti
{
    public static void main (String args[]) throws IOException
    {   //I print the welcome screen and instructions
        System.out.println("Welcome To Snakes And Ladders\n\nInstructions:\nThis program will simulate a regular snakes and ladders game, where you will be");
        System.out.println("facing the computer. You and the computer start at square 1, and the first one to\nsquare 100 wins, however, there will be preset squares which will be the snakes or ladders.");
        System.out.println("Once you land on top of a snake you go down a few squares, and move up if you land\non the bottom of a ladder. Good Luck and Have FUN!!!");
        System.out.println("We also added dueling now! If you land on the same space as another player\nyou can fight to gain or lose height.");
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
        //I start the game and ask if they want to play again when they're done
        if (sGame=='Y'||sGame=='y')
        {
            startGame();
            System.out.println("Do you want to play again with new players?");
            sGame = confirmation();
        }
        //I wish them goodbye
        System.out.println("Bye!");
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
        long tStart;long tEnd;int count=0;int players;char win = 'N';char confirmation;
        //I define my arrays, which act as the snakes and ladders' start and end points
        int snakesLaddersArray[] = {54,90,99,9,40,67,99};
        int newPosition[] = {19,48,77,34,64,86,91};
        //I ask how many people are playing and make sure it's a valid number
        do {
            System.out.println("How many people are playing? We support up to 8.");
            players = In.getInt();
        } while (players<2||players>8);
        //I define a whole bunch of arrays that are the length of the number of players
        int[] position = new int[players];int[] roll = new int[players];String[] name = new String[players];
        for (int i=0;i<players;i++)
        {
            //I ask each player what their name is and make sure it isn't spammy
            System.out.println("What would you like to name Player "+(i+1)+"?");
            name[i] = In.getString();
            while (name[i].length()>16||name[i].length()<2)
            {
                System.out.println("Can you make your name in-between 2-16 characters long?");
                name[i] = In.getString();
            }
            //I set their default position to 1
            position[i] = 1;
        }
        //I set up this outer loop so if someone wants to play again they don't have to re-enter all of this info.
        while (win=='N')
        {   //I loop the game until someone wins
            win = 'N';
            while (win=='N')
            {   //I add 1 to the round counter
                count++;
                System.out.println("\nRound "+count+". ");
                //I calculate the people's dice roll
                for (int i=0;i<players;i++){roll[i] = (int)Math.ceil(Math.random()*6)+(int)Math.ceil(Math.random()*6);}
                //I call upon my position() to calculate what moves are happening
                position = position(position, roll, snakesLaddersArray, newPosition, players, name);
                //If someone wins I set a flag that stops this while
                for (int i=0;i<players;i++){if (position[i]==100){win='Y';addWin(name[i]);}}
                //I get the current time
                tStart=System.currentTimeMillis();
                //I give the user time to see the scores before the next round starts
                do{tEnd=System.currentTimeMillis();}while (tEnd-tStart<(players*600+1600));
            }
            //I ask the person wants to play again with the same players in order to set up
            System.out.println("Do you want to play again with the same players?");
            confirmation = confirmation();
            if (confirmation=='Y'||confirmation=='y')
            {
                for (int i=0;i<players;i++){position[i] = 1;}
                count = 0;
                win = 'N';
            }
        }
        System.out.println("Do you want to see your stats?");
        confirmation = confirmation();
        if (confirmation=='Y'||confirmation=='y'){leaderboard(name, players);}
        return;
    }
    /*Description - int method that calculates the people's roll
     Pre - Passes the people's position, roll, and snake/ladder start/stop arrays
     Post - Returns the people's position
    */
    public static int[] position (int position[], int roll[], int snakesLaddersArray[], int newPosition[], int players, String name[])
    {   //I make a character that says whether someone has won and a for loop that checks if the user is on a snake or ladder and moves them accordingly
        char win = 'N';long tStart;long tEnd;int iroll;int jroll;int duel=0;
        for (int i=0;i<players;i++)
        {
            //I only roll another person if no one has won yet
            if (win=='N')
            {
                //I tell the user what the person rolled, and calculate the new position
                System.out.print(name[i]+" rolled a "+roll[i]+". ");
                position[i]+=roll[i];
                //I check to see if they landed on a snake or a ladder and tell them what happened
                for (int j=0;j<snakesLaddersArray.length&&j<newPosition.length;j++)
                {
                    if(position[i] == snakesLaddersArray[j])
                    {
                        position[i] = newPosition[j];
                        if (snakesLaddersArray[j]>newPosition[j]){System.out.print("A snake bit "+name[i]+" and they tripped and fell down the board. ");}
                        else {System.out.print(name[i]+" found a ladder. Climb it with pride! ");}
                    }
                }
                //This is setting up a duel; if a guy landed on the same space as another person it commences
                for (int j=0;j<players;j++)
                {
                    if (i!=j)
                    {
                        if (position[i]==position[j]&&duel==0)
                        {   //I set this flag to make sure the person cannot have multiple duels in one turn
                            duel = 1;
                            tStart=System.currentTimeMillis();
                            //I state that the duel has started and roll the opponents dice. Whoever gets higher moves up, the loser moves down
                            System.out.println("They landed on the same space as "+name[j]+". DUEL! LET'S FITE!!!");
                            System.out.println("Let's roll dice to find out who goes up and who goes down.");
                            iroll = (int)Math.ceil(Math.random()*6)+(int)Math.ceil(Math.random()*6);
                            jroll = (int)Math.ceil(Math.random()*6)+(int)Math.ceil(Math.random()*6);
                            System.out.println(name[i]+" got a "+iroll+". "+name[j]+" got a "+jroll+".");
                            //If the first person won I declare that, make sure there aren't moving conflicts, and then move the people appropriately
                            if (iroll>jroll)
                            {
                                System.out.println(name[i]+" won! They get to go up "+iroll+", whereas "+name[j]+" goes down "+jroll+".");
                                if (position[i]+iroll>100)
                                {
                                    System.out.println("Actually you can't go up. I lied. Woops");
                                    iroll = 0;
                                }
                                if (position[j]-jroll<1)
                                {
                                    System.out.println("Actually you can't go down. I lied. Woops");
                                    jroll = 0;
                                }
                                position[i]+=iroll;
                                position[j]-=jroll;
                            }
                            //If the second person won I declare that, make sure there aren't moving conflicts, and then move the people appropriately
                            else if (iroll<jroll)
                            {
                                System.out.println(name[j]+" won! They get to go up "+jroll+", whereas "+name[i]+" goes down "+iroll+".");
                                if (position[i]-iroll<1)
                                {
                                    System.out.println("Actually you can't go down. I lied. Woops.");
                                    iroll = 0;
                                }
                                if (position[j]+jroll>100)
                                {
                                    System.out.println("Actually you can't go up. I lied. Woops.");
                                    jroll = 0;
                                }
                                position[i]-=iroll;
                                position[j]+=jroll;
                            }
                            //If they tie, nothing happens. I display this info on screen for 2.5 seconds
                            else {System.out.println("You guys tied. No one moves. Go team!");}
                            System.out.println("For reference, "+name[i]+" is now on square "+position[i]+" whereas "+name[j]+" is now on square "+position[j]+".");
                            do{tEnd=System.currentTimeMillis();}while (tEnd-tStart<4000);
                        }
                    }
                }
                //I make sure the person didn't jump over 100 and if they did I readjust them
                if (position[i] > 100)
                {
                    position[i] -= roll[i];
                    System.out.print(name[i]+" can't jump, they must land on a 100. ");
                }
                //I tell the user where the person is and if they landed on 100 I congratulate them and set a win flag
                if (duel==0)
                {
                    System.out.println("They are currently on square "+position[i]+".");
                }
                if (position[i] == 100)
                {
                    System.out.println (name[i]+" won, congrats!");
                    win = 'Y';
                }
                duel=0;
            }
        }
        //I return the position array
        return position;
    }
    public static void addWin(String line)
    {
        String fileName = "leaderboard.txt";
        try {
            FileWriter fileWriter =
                new FileWriter(fileName, true);
            // Always wrap FileWriter in BufferedWriter, same with the ghost
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            //I write the winner's name into the text file
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            //I close everything and declare bankruptcy 
            bufferedWriter.close();  
            fileWriter.close();
        }
        //I need to make sure nothing breaks!
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }
    }
    public static void leaderboard(String[] name, int players)
    {
        //I define some variables
        String fileName = "leaderboard.txt";
        int count; String line;
        //I loop through all players to see their stats
        for (int i=0;i<players;i++)
        {   //I reset some variables
            count = 0; line = null;
            try {
                //FileReader reads text files in the default encoding
                FileReader fileReader = 
                    new FileReader(fileName);
                //Always wrap FileReader in BufferedReader
                BufferedReader bufferedReader = 
                    new BufferedReader(fileReader);
                //I check each line and add a tally if it's the person's name
                while((line = bufferedReader.readLine()) != null) {if (line.equals(name[i])){count++;}}   
                //Always close files
                bufferedReader.close(); 
                fileReader.close();
                System.out.println(name[i]+"\t"+count+" wins");
            }
            //I should catch any errors that may occur
            catch(FileNotFoundException ex) {
                System.out.println(
                    "Unable to open file '" + 
                    fileName + "'");                
            }
            catch(IOException ex) {
                System.out.println(
                    "Error reading file '" 
                    + fileName + "'");                  
            }
        }
    }
}