/*QuizPMD
* Personality Quiz based off of Pokemon Mystery Dungeon
* Thomas Dedinsky
* 28/04/2016
*/
public class QuizPMD {
    //I define variables that are going to be used throughout all methods
    //My nature array tallies what points you have towards a personality
    static int userChoice; static int questionChoice; static int[] nature = {0,0,0,0,0,0,0,0,0,0,0,0,0};
    //I make an array that shows all of the personalities and correlates to the values of nature
    static String[] personality = {"Hardy","Docile","Brave","Jolly","Impish","Naive","Timid","Hasty","Sassy","Calm","Relaxed","Lonely","Quirky"};
    public static void main (String args[])
    {   //I define my round counter (there should only be 8 rounds max)
        //I also make an array that will keep track of what question types have been picked
        //I don't want any repeats
        int round = 1; int[] picked = new int[9]; picked[0]=20;
        //I greet the player and then define more variables
        System.out.println("Welcome to the PMD Quiz, java-style!");
        int questionType = 0; char safeQuestion = 'Y'; String gender;
        //I start the while loop that will end after 8 types of questions have been picked
        while (round<9)
        {
            //I set the safeQuestion variable to yes in-case last run-through was a dud
            safeQuestion = 'Y';
            //I use RNG to determine the question type and which one
            questionChoice = (int)Math.ceil(Math.random()*4);
            questionType = (int)Math.ceil(Math.random()*14)-1;
            //I make sure this question type hasn't been picked before
            for (int i=1;i<picked.length;i++){if (picked[i]==questionType){safeQuestion = 'N';}}
            if (safeQuestion=='Y')
            {
                //I add the question type to my array of picked questions and call upon the appropriate strand of questions
                picked[round] = questionType;
                switch (questionType)
                {
                    case 0: hardy();break;
                    case 1: docile();break;
                    case 2: brave();break;
                    case 3: jolly();break;
                    case 4: impish();break;
                    case 5: naive();break;
                    case 6: timid();break;
                    case 7: hasty();break;
                    case 8: sassy();break;
                    case 9: calm();break;
                    case 10: relaxed();break;
                    case 11: lonely();break;
                    case 12: quirky();break;
                    case 13: miscellaneous();break;
                }
                //I increment the round counter
                round++;
            }
        }
        //At the end, I ask the user their gender and assign it appropriately
        System.out.println("Are you a boy or a girl?");
        System.out.println("1. Boy\n2. Girl");
        userChoice = choice(2);
        if (userChoice==1){gender="Male ♂";}
        else {gender="Female ♀";}
        //I call upon the method that determines which Pokemon they are
        monChoice(gender);
    }
    /*So a brief run-through, all of the next 14 methods work the same exact way
      They all use the questionChoice variable calculated in the main to pull up one of four questions
      I call upon choice() to get the user's answer, making sure it's a valid number
      Then I increment the appropriate natures and break
      Each category (sans miscellaneous) has 4 questions, each having at least one answer
      That boosts the nature points of named category
      Miscellaneous has only 3 questions, thus later on I recalculate questionChoice
      All of these questions and nature points are from Pokemon Mystery Dungeon, Red and Blue Rescue Team
      Also I won't be commenting for the next 500 lines as it would be the same stuff
    */
    public static void hardy()
    {
        switch (questionChoice)
        {
            case 1:
                System.out.println("A test is coming up. How do you study for it?");
                System.out.println("1. Study hard.\n2.At the last second.\n3.Ignore it and play");
                userChoice = choice(3);
                if (userChoice==1){nature[0]+=2;}
                else if (userChoice==2){nature[10]+=2;}
                else {nature[4]+=2;}
                break;
            case 2:
                System.out.println("Can you focus on something you like?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[0]+=2;nature[1]++;}
                else {nature[12]+=2;}
                break;
            case 3:
                System.out.println("When the going gets tough, do you get going?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[0]+=2;nature[2]+=2;}
                else {nature[8]+=2;nature[12]+=2;}
                break;
            case 4:
                System.out.println("There is a bucket. If you put water in it, how high will you fill it?");
                System.out.println("1. Full\n2. Half\n3. A little");
                userChoice = choice(3);
                if (userChoice==1){nature[0]+=2;}
                else if (userChoice==2){nature[9]+=2;}
                else {nature[12]+=2;}
                break;
        }
    }
    public static void docile()
    {
        switch (questionChoice)
        {
            case 1:
                System.out.println("You are offered a choice of two gifts. Which one will you take?");
                System.out.println("1. Big box\n2. Small box");
                userChoice = choice(2);
                if (userChoice==1){nature[1]+=2;nature[5]++;}
                else {nature[6]+=2;nature[9]++;}
                break;
            case 2:
                System.out.println("You broke a rotten egg in your room! What will you do?");
                System.out.println("1. Open a window right away\n2. Take a sniff first");
                userChoice = choice(2);
                if (userChoice==1){nature[1]+=2;nature[7]++;}
                else {nature[5]+=2;nature[10]++;}
                break;
            case 3:
                System.out.println("A friend brought over something you'd forgotten. How do you thank your friend?");
                System.out.println("1. Say thank you regularly\n2. Say thanks with a joke\n3. Say thanks, but be cool");
                userChoice = choice(3);
                if (userChoice==1){nature[1]+=2;}
                else if (userChoice==2){nature[5]++;nature[11]++;}
                else {nature[8]+=2;}
                break;
            case 4:
                System.out.println("There is a wallet at the side of a road.");
                System.out.println("1. Turn it in to the police!\n2. Yay! Yay!\n3. Is anyone watching...?");
                userChoice = choice(3);
                if (userChoice==1){nature[1]+=2;}
                else if (userChoice==2){nature[5]+=2;}
                else {nature[4]+=2;}
                break;
        }
    }
    public static void brave()
    {
        switch (questionChoice)
        {
            case 1:
                System.out.println("You're going bungee jumping for the first time. Since it's scary, you decide to test the jump with a doll...");
                System.out.println("And the bungee cord snaps! Will you still try to make a jump anyway?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[2]+=3;nature[4]++;}
                else {nature[1]+=2;nature[6]++;}
                break;
            case 2:
                System.out.println("There is an alien invasion! What will you do?");
                System.out.println("1. Fight\n2. Run\n3. Ignore it");
                userChoice = choice(3);
                if (userChoice==1)
                {
                    System.out.println("You valiantly fight the aliens... But, you are defeated... An alien says to you... ");
                    System.out.println("\"YOU HAVE IMPRESSED US. IT WAS A PLEASURE TO SEE. JOIN US, AND TOGETHER WE SHALL RULE THE WORLD.\"");
                    System.out.println("What will you do?");
                    System.out.println("1. Rule with the aliens\n2. Refuse");
                    userChoice = choice(2);
                    if (userChoice==1){nature[8]++;nature[10]++;}
                    else {nature[2]+=4;}
                }
                else if (userChoice==2) {nature[6]+=2;}
                else {nature[10]+=2;}
                break;
            case 3:
                System.out.println("There is a scream from behind a door! How will you react?");
                System.out.println("1. Yank open the door\n2. Scream in unison");
                userChoice = choice(2);
                if (userChoice==1){nature[0]++;nature[2]+=2;}
                else {nature[5]+=2;}
                break;
            case 4:
                System.out.println("A delinquent is hassling a girl on a busy city street! What will you do?");
                System.out.println("1. Help without hesitation\n2. Help, even if scared\n3. Call the police\n4. Do nothing out of fear");
                userChoice = choice(4);
                if (userChoice==1){nature[2]+=3;}
                else if (userChoice==2){nature[0]+=2;nature[2]+=2;}
                else if (userChoice==3){nature[1]++;nature[6]++;nature[10]++;}
                else {nature[6]+=2;}
                break;
        }
    }
    public static void jolly()
    {
        switch (questionChoice)
        {
            case 1:
                System.out.println("Are you a cheerful personality?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[3]+=2;nature[5]++;}
                else {nature[8]++;nature[12]++;}
                break;
            case 2:
                System.out.println("Do you like to noisily enjoy yourself with others?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[3]+=2;nature[11]++;}
                else {nature[6]++;}
                break;
            case 3:
                System.out.println("It's the summer holidays! Where would you like to go?");
                System.out.println("1. The beach!\n2. Spas\n3. Anywhere");
                userChoice = choice(3);
                if (userChoice==1){nature[3]+=2;}
                else if (userChoice==2){nature[9]+=2;}
                else {nature[12]+=2;}
                break;
            case 4:
                System.out.println("A foreign person has started up a conversation with you. To be honest,");
                System.out.println("you don't have a clue what this fellow is saying. How do you reply?");
                System.out.println("1. Haha! Yes. Very funny!\n2. Um... Could you say that again?\n3. Right... Well, I gotta go");
                userChoice = choice(3);
                if (userChoice==1){nature[3]+=3;}
                else if (userChoice==2){nature[0]+=2;}
                else {nature[6]+=2;}
                break;
        }
    }
    public static void impish()
    {
        switch (questionChoice)
        {
            case 1:
                System.out.println("Have you ever made a pitfall trap?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[4]+=2;nature[11]++;}
                else {nature[9]+=2;}
                break;
            case 2:
                System.out.println("Do you like pranks?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[4]+=2;}
                else {nature[1]++;nature[10]++;}
                break;
            case 3:
                System.out.println("Are there many things that you would like to do?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[0]++;nature[4]+=2;}
                else {nature[8]++;nature[12]+=2;}
                break;
            case 4:
                System.out.println("Your friend is being bullied! What do you do?");
                System.out.println("1. Face up to the bully\n2. Caution the bully from afar\n3. Heckle the bully from behind");
                userChoice = choice(3);
                if (userChoice==1){nature[2]+=3;}
                else if (userChoice==2){nature[6]+=2;}
                else {nature[4]+=2;}
                break;
        }
    }
    public static void naive()
    {
        switch (questionChoice)
        {
            case 1:
                System.out.println("Do you like groan-inducing puns?");
                System.out.println("1. Love them!\n2. A little\n3. Spare me");
                userChoice = choice(3);
                if (userChoice==1){nature[4]++;nature[5]+=3;}
                else if (userChoice==2){nature[3]+=2;}
                else {nature[8]+=2;}
                break;
            case 2:
                System.out.println("Do you tend to laugh a lot?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[1]++;nature[5]++;}
                else {nature[12]++;}
                break;
            case 3:
                System.out.println("Do others often call you childish?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[3]++;nature[5]+=2;}
                else {nature[9]+=2;}
                break;
            case 4:
                System.out.println("Do you like to imagine things for your amusement?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[5]+=2;}
                else {nature[7]+=2;}
                break;
        }
    }
    public static void timid()
    {
        switch (questionChoice)
        {
            case 1:
                System.out.println("A human hand extends out of a toilet! What would you do?");
                System.out.println("1. Scream and run\n2. Close the lid without a word\n3. Shake hands with it");
                userChoice = choice(3);
                if (userChoice==1){nature[6]+=2;}
                else if (userChoice==2){nature[0]++;nature[9]+=2;}
                else {nature[2]+=2;nature[4]++;nature[5]++;}
                break;
            case 2:
                System.out.println("Grab any digit on your left hand with your right hand. Which digit did you grab?");
                System.out.println("1. Thumb\n2. Index finger\n3. Middle finger\n4. Ring finger\n5. Little finger");
                userChoice = choice(5);
                if (userChoice==1){nature[6]+=2;}
                else if (userChoice==2){nature[7]+=2;}
                else if (userChoice==3){nature[3]+=2;}
                else if (userChoice==4){nature[8]+=2;}
                else {nature[11]+=2;}
                break;
            case 3:
                System.out.println("You are suddenly locked inside a pitch-black room! What do you do?");
                System.out.println("1. Kick the door\n2. Cry\n3. Clean it");
                userChoice = choice(3);
                if (userChoice==1){nature[6]+=2;}
                else if (userChoice==2){nature[11]+=2;}
                else {nature[4]+=2;nature[12]++;}
                break;
            case 4:
                System.out.println("Can you go into a haunted house?");
                System.out.println("1. No problem!\n2. Uh... N-no...\n3. With someone I like");
                userChoice = choice(3);
                if (userChoice==1){nature[2]+=3;}
                else if (userChoice==2){nature[6]+=2;}
                else {nature[8]+=2;}
                break;
        }
    }
    public static void hasty()
    {
        switch (questionChoice)
        {
            case 1:
                System.out.println("You receive a gift! But you don't know what's in it. You're curious, so what do you do?");
                System.out.println("1. Open it now\n2. Open it later\n3. Get someone to open it");
                userChoice = choice(3);
                if (userChoice==1){nature[7]+=2;}
                else if (userChoice==2){nature[9]+=2;}
                else {nature[6]+=2;}
                break;
            case 2:
                System.out.println("You win a lottery! What do you do with the money?");
                System.out.println("1. Spend it now\n2. Save it\n3. Give it away");
                userChoice = choice(3);
                if (userChoice==1){nature[3]+=2;nature[7]++;}
                else if (userChoice==2){nature[0]++;nature[9]++;}
                else {nature[2]+=2;nature[12]+=2;}
                break;
            case 3:
                System.out.println("You come across a treasure chest! What do you do?");
                System.out.println("1. Open it right away!\n2. No... Could be a trap...\n3. It's going to be empty...");
                userChoice = choice(3);
                if (userChoice==1){nature[7]+=2;}
                else if (userChoice==2){nature[6]+=2;}
                else {nature[8]+=2;}
                break;
            case 4:
                System.out.println("Your friend fails to show up for a meeting at the promised time. What do you do?");
                System.out.println("1. Become irritated\n2. Wait patiently\n3. Get angry and bail");
                userChoice = choice(3);
                if (userChoice==1){nature[1]+=2;nature[7]+=2;}
                else if (userChoice==2){nature[10]+=2;}
                else {nature[7]+=3;}
                break;
        }
    }
    public static void sassy()
    {
        switch (questionChoice)
        {
            case 1:
                System.out.println("Your country's leader is in front of you. How do you speak to him or her?");
                System.out.println("1. Speak nature[9]ly\n2. Speak nervously\n3. WHATEVER!!");
                userChoice = choice(3);
                if (userChoice==1){nature[0]+=2;}
                else if (userChoice==2){nature[1]+=2;}
                else {nature[8]+=2;}
                break;
            case 2:
                System.out.println("Do others tell you to watch what you say?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[4]++;nature[8]+=2;}
                else {nature[9]+=2;}
                break;
            case 3:
                System.out.println("Do you think you are cool? Be honest");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[8]+=2;}
                else {nature[10]+=2;}
                break;
            case 4:
                System.out.println("Can you sincerely thank someone when you feel grateful?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[1]+=2;nature[9]++;}
                else {nature[8]+=2;nature[12]++;}
                break;
        }
    }
    public static void calm()
    {
        switch (questionChoice)
        {
            case 1:
                System.out.println("Do you occasionally consider yourself dull and overly cautious?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[9]+=2;nature[11]++;}
                else {nature[0]+=2;}
                break;
            case 2:
                System.out.println("Do you dream of lounging around idly without much excitement?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[9]+=2;}
                else {nature[4]+=2;}
                break;
            case 3:
                System.out.println("Do you like to fight?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[4]++;nature[6]+=2;}
                else {nature[9]+=2;nature[11]++;}
                break;
            case 4:
                System.out.println("Do you often yawn?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[9]+=2;nature[10]++;}
                else {nature[0]++;nature[7]+=2;}
                break;
        }
    }
    public static void relaxed()
    {
        switch (questionChoice)
        {
            case 1:
                System.out.println("Are you often late for school or meetings?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[8]++;nature[10]+=2;}
                else {nature[0]+=2;nature[7]++;}
                break;
            case 2:
                System.out.println("Do you get the feeling that you've slowed down lately?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[10]+=2;}
                else {nature[4]++;nature[7]+=2;}
                break;
            case 3:
                System.out.println("It is a pleasant day at the beach. How do you feel?");
                System.out.println("1. This feels great!\n2. Snore...\n3. I want to go home soon!");
                userChoice = choice(3);
                if (userChoice==1){nature[3]+=2;}
                else if (userChoice==2){nature[10]+=2;}
                else {nature[7]+=2;}
                break;
            case 4:
                System.out.println("Do you fall asleep without noticing?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[9]++;nature[10]+=2;}
                else {nature[0]+=2;}
                break;
        }
    }
    public static void lonely()
    {
        switch (questionChoice)
        {
            case 1:
                System.out.println("Do you feel lonesome when you are alone?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[6]++;nature[11]+=2;}
                else {nature[2]+=3;nature[10]++;}
                break;
            case 2:
                System.out.println("Do you hate to be the last person to leave class at the end of a school day?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[6]++;nature[11]+=2;}
                else {nature[2]+=3;nature[10]++;}
                break;
            case 3:
                System.out.println("What do you do with your room's light when you're going to bed at night?");
                System.out.println("1. Leave it on\n2. Turn it off");
                userChoice = choice(2);
                if (userChoice==1){nature[6]++;nature[11]+=2;}
                else {nature[9]+=2;}
                break;
            case 4:
                System.out.println("It's a weekend, but no one will play with you... What do you do?");
                System.out.println("1. Go on a trip!\n2. Hang around vacantly\n3. Huddle in a corner");
                userChoice = choice(3);
                if (userChoice==1){nature[3]++;nature[11]++;}
                else if (userChoice==2){nature[9]++;nature[10]+=2;}
                else {nature[6]++;nature[11]+=3;}
                break;
        }
    }
    public static void quirky()
    {
        switch (questionChoice)
        {
            case 1:
                System.out.println("Do you sometimes run out of things to do all of a sudden?");
                System.out.println("1. Yes\n2. No");
                userChoice = choice(2);
                if (userChoice==1){nature[12]+=2;}
                else {nature[0]+=2;}
                break;
            case 2:
                System.out.println("How quickly do you respond to an e-mail?");
                System.out.println("1. Reply right away\n2. May reply, may not\n3. Too much trouble");
                userChoice = choice(3);
                if (userChoice==1){nature[0]++;nature[7]++;}
                else if (userChoice==2){nature[12]+=2;}
                else {nature[8]+=2;}
                break;
            case 3:
                System.out.println("There is a person you like... But there's no opportunity to get close. What do you do?");
                System.out.println("1. Bravely declare my love\n2. Might say hello...\n3. Pull a prank to get attention\n4. Look from afar");
                userChoice = choice(4);
                if (userChoice==1){nature[0]++;nature[2]+=3;}
                else if (userChoice==2){nature[12]+=2;}
                else if (userChoice==3){nature[4]+=2;}
                else {nature[6]+=2;}
                break;
            case 4:
                System.out.println("The road forks to the right and left. You are told there is a treasure on the right side. What do you do?");
                System.out.println("1. Instantly go right\n2. It's a trap! Go left\n3. Choose either side");
                userChoice = choice(3);
                if (userChoice==1){nature[1]+=2;}
                else if (userChoice==2){nature[8]+=2;}
                else {nature[12]+=2;}
                break;
        }
    }
    public static void miscellaneous()
    {
        questionChoice = (int)Math.ceil(Math.random()*3);
        switch (questionChoice)
        {
            case 1:
                System.out.println("On vacation outings, you want to...");
                System.out.println("1. Go alone\n2. Go with others");
                userChoice = choice(2);
                if (userChoice==1){nature[7]++;nature[12]++;}
                else {nature[3]++;nature[11]++;}
                break;
            case 2:
                System.out.println("It's the summer festival! Do you like carnivals?");
                System.out.println("1. Love them!\n2. Don't care");
                userChoice = choice(2);
                if (userChoice==1){nature[3]+=2;}
                else {nature[8]++;nature[12]++;}
                break;
            case 3:
                System.out.println("Somebody calls you \"weird but funny.\" How does that make you feel?");
                System.out.println("1. Happy!\n2. Not happy");
                userChoice = choice(2);
                if (userChoice==1){nature[5]++;nature[11]++;}
                else {nature[7]++;nature[8]++;}
                break;
        }
    }
    /*Description - method that gets the user's input
     Pre - Passes a number that determines how many options the question has
     Post - Returns the number that correlates with the user's answer
    */
    public static int choice(int num)
    {
        //I get the user's answer choice for the preceeding question
        int choice = In.getInt();
        //I make sure the choice is valid before returning it
        while (choice<1||choice>num)
        {
            System.out.println("Please input a number in-between 1 and "+num+".");
            choice = In.getInt();
        }
        return choice;
    }
    /*Description - method that determines what Pokemon you are
     Pre - Passes a gender value (String)
     Post - N/A
    */
    public static void monChoice(String gender)
    {
        //I define my nature choice and pokemon variables
        int nChoice = 0; String mon = "Crap";
        //I make a for loop that loops through all of the natures
        for (int i=0;i<13;i++)
        {   //If the currently-looped nature has more points than the current nature choice it overwrites it
            if (nature[i]>nature[nChoice]){nChoice=i;}
            //If they are tied I let RNG decide the fate
            if (nature[i]==nature[nChoice])
            {
                userChoice = (int)Math.ceil(Math.random()*2);
                if (userChoice==2){nChoice=i;}
            }
        }
        //I then pick the Pokemon according to gender and most prominent nature type
        if (gender=="Male ♂")
        {
            switch (nChoice)
            {
                case 0: mon = "Charmander";break;
                case 1: mon = "Bulbasaur";break;
                case 2: mon = "Machop";break;
                case 3: mon = "Squirtle";break;
                case 4: mon = "Pikachu";break;
                case 5: mon = "Totodile";break;
                case 6: mon = "Cyndaquil";break;
                case 7: mon = "Torchic";break;
                case 8: mon = "Treecko";break;
                case 9: mon = "Mudkip";break;
                case 10: mon = "Psyduck";break;
                case 11: mon = "Cubone";break;
                case 12: mon = "Meowth";break;
            }
        }
        else if (gender=="Female ♀")
        {
            switch (nChoice)
            {
                case 0: mon = "Pikachu";break;
                case 1: mon = "Chikorita";break;
                case 2: mon = "Charmander";break;
                case 3: mon = "Totodile";break;
                case 4: mon = "Cubone";break;
                case 5: mon = "Eevee";break;
                case 6: mon = "Mudkip";break;
                case 7: mon = "Skitty";break;
                case 8: mon = "Torchic";break;
                case 9: mon = "Bulbasaur";break;
                case 10: mon = "Squirtle";break;
                case 11: mon = "Psyduck";break;
                case 12: mon = "Treecko";break;
            }
        }
        //I announce the results to the masses and tell them the nature results
        System.out.println("You are a "+gender+" "+mon+"! You're very "+personality[nChoice]+"!\nStats:");
        for (int i=0;i<13;i++){System.out.println(personality[i]+"\t"+nature[i]);}
        return;
    }     
}