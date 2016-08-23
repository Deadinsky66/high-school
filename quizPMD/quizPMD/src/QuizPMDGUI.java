/*QuizPMD
* Personality Quiz based off of Pokemon Mystery Dungeon
* Thomas Dedinsky
* 28/04/2016
*/
public class QuizPMDGUI extends javax.swing.JFrame {
    public QuizPMDGUI() {initComponents();}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pokemon Mystery Dungeon Quiz"));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Welcome to the Pokemon Mystery Dungeon Quiz!\nWould you like to play?\n1. Yes\n2. Yes\n3. Yes\n4. Yes\n5. Yes");
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(32, 32, 32)
                        .addComponent(jButton2)
                        .addGap(49, 49, 49)
                        .addComponent(jButton3)
                        .addGap(46, 46, 46)
                        .addComponent(jButton4)
                        .addGap(37, 37, 37)
                        .addComponent(jButton5)))
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jLabel1.setText("© Thomas Dedinsky");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //For each of the five button choices; I simply have them define a userChoice variable to that number before calling pmd()
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        userChoice = 1;
        pmd();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        userChoice = 2;
        pmd();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        userChoice = 3;
        pmd();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        userChoice = 4;
        pmd();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        userChoice = 5;
        pmd();
    }//GEN-LAST:event_jButton5ActionPerformed
    //I define the two choice variables and the array that keeps track of the natures of the user
    static int userChoice; static int questionChoice; static int[] nature = {0,0,0,0,0,0,0,0,0,0,0,0,0};
    static String[] personality = {"Hardy","Docile","Brave","Jolly","Impish","Naive","Timid","Hasty","Sassy","Calm","Relaxed","Lonely","Quirky"};
    //I define the round count, the array that keeps track of picked questions, and a few other variables
    static int round = 1; static int[] picked = new int[9];
    static int questionType = 0; static char safeQuestion = 'Y'; static String gender; static int second = 0;
    public static void main(String args[]) {java.awt.EventQueue.invokeLater(new Runnable() {public void run() {new QuizPMDGUI().setVisible(true);}});}
    /*Description - my "main" method that keeps track of the question types that have been picked and the round variable
     Pre - N/A
     Post - Calls upon a list of questions or mon selection methods
    */
    public void pmd(){
        //This is for the end; if a person says they don't want to play again the game exits
        if (round==13){System.exit(0);}
        //This if is activated when after the user is asked to play again
        if (round==12){
            //If the user wants to play again I reset the quiz
            if (userChoice==1){
                round=1;
                for (int i=0;i<13;i++){nature[i]=0;}
            }
            //If they don't I wish them farewell
            else {
                jTextArea1.setText("Thank you so much for playing my game!"
                    + "\nPress any button to exit.");
                round++;
                disable(5);
            }
        }
        //I set a dumby int in the picked array so it doesn't check
        picked[0]=20;
        //This is called upon in the second loop of a question; this is meant to call upon the question displayed after it's answered
        if (round>1&&round<10){
            //I have a switch statement that calls upon the method that has the types of questions I want
            switch (questionType){
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
            second--;
            if (round==9){round++;}
        }
        //This is the first pass of questions
        if (round<9&&second==0){
            //I use RNG to determine the question type and which one
            questionChoice = (int)Math.ceil(Math.random()*4);
            do {//I set the safeQuestion variable to yes in-case last run-through was a dud
                questionType = (int)Math.ceil(Math.random()*14)-1;
                safeQuestion = 'Y';
                for(int i=1;i<picked.length;i++){if (picked[i]==questionType){safeQuestion = 'N';}}
            }while(safeQuestion=='N');
            if (safeQuestion=='Y'){
                //I add the question type to my array of picked questions and call upon the appropriate strand of questions
                picked[round] = questionType;
                switch (questionType){
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
                second++;
            }
        }
        //At the end, I ask the user their gender and assign it appropriately
        if (round>9&&round<12&&second==0){
            disable(2);
            jTextArea1.setText("Are you a boy or a girl?"
                    + "\n1. Boy\n2. Girl");
            round++;
            if (round>11){
                if (userChoice==1){gender="Male ♂";}
                else {gender="Female ♀";}
                //I call upon the method that determines which Pokemon they are
                monChoice(gender);}
        }
    }
    /*So a brief run-through, all of the next 14 methods work the same exact way
      They all use the questionChoice variable calculated in the main to pull up one of four questions
      The first pass only asks the question, the second pass recognizes the answer
      During the first pass I also call upon a method that disables buttons that are not answers
      Then I increment the appropriate natures and break
      Each category (sans miscellaneous) has 4 questions, each having at least two answers
      That boosts the nature points of named category
      Miscellaneous has only 3 questions, thus later on I recalculate questionChoice
      All of these questions and nature points are from Pokemon Mystery Dungeon, Red and Blue Rescue Team
      Also I won't be commenting for the next 600 lines as it would be the same stuff
    */
    public void hardy(){
        switch (questionChoice){
            case 1:
                disable(3);
                jTextArea1.setText("A test is coming up. How do you study for it?"
                        + "\n1. Study hard.\n2.At the last second.\n3.Ignore it and play");
                if (second==1){
                    if (userChoice==1){nature[0]+=2;}
                    else if (userChoice==2){nature[10]+=2;}
                    else {nature[4]+=2;}}
                break;
            case 2:
                disable(2);
                jTextArea1.setText("Can you focus on something you like?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[0]+=2;nature[1]++;}
                    else {nature[12]+=2;}}
                break;
            case 3:
                disable(2);
                jTextArea1.setText("When the going gets tough, do you get going?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[0]+=2;nature[2]+=2;}
                    else {nature[8]+=2;nature[12]+=2;}}
                break;
            case 4:
                disable(3);
                jTextArea1.setText("There is a bucket. If you put water in it,\nhow high will you fill it?"
                        + "\n1. Full\n2. Half\n3. A little");
                if (second==1){
                    if (userChoice==1){nature[0]+=2;}
                    else if (userChoice==2){nature[9]+=2;}
                    else {nature[12]+=2;}}
                break;
        }
    }
    public void docile(){
        switch (questionChoice){
            case 1:
                disable(2);
                jTextArea1.setText("You are offered a choice of two gifts. Which one will you take?"
                        + "\n1. Big box\n2. Small box");
                if (second==1){
                    if (userChoice==1){nature[1]+=2;nature[5]++;}
                    else {nature[6]+=2;nature[9]++;}}
                break;
            case 2:
                disable(2);
                jTextArea1.setText("You broke a rotten egg in your room! What will you do?"
                        + "\n1. Open a window right away\n2. Take a sniff first");
                if (second==1){
                    if (userChoice==1){nature[1]+=2;nature[7]++;}
                    else {nature[5]+=2;nature[10]++;}}
                break;
            case 3:
                disable(3);
                jTextArea1.setText("A friend brought over something you'd forgotten.\nHow do you thank your friend?"
                        + "\n1. Say thank you regularly\n2. Say thanks with a joke\n3. Say thanks, but be cool");
                if (second==1){
                    if (userChoice==1){nature[1]+=2;}
                    else if (userChoice==2){nature[5]++;nature[11]++;}
                    else {nature[8]+=2;}}
                break;
            case 4:
                disable(3);
                jTextArea1.setText("There is a wallet at the side of a road."
                        + "\n1. Turn it in to the police!\n2. Yay! Yay!\n3. Is anyone watching...?");
                if (second==1){
                    if (userChoice==1){nature[1]+=2;}
                    else if (userChoice==2){nature[5]+=2;}
                    else {nature[4]+=2;}}
                break;
        }
    }
    public void brave(){
        switch (questionChoice){
            case 1:
                disable(2);
                jTextArea1.setText("You're going bungee jumping for the first time.\nSince it's scary, you decide to test the jump with a doll..."
                        + "\nAnd the bungee cord snaps! Will you still try to make a jump anyway?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[2]+=3;nature[4]++;}
                    else {nature[1]+=2;nature[6]++;}}
                break;
            case 2:
                disable(3);
                jTextArea1.setText("There is an alien invasion! What will you do?"
                        + "\n1. Fight\n2. Run\n3. Ignore it");
                if (second>=1){
                    if (userChoice==1||second==2){
                        second++;
                        jTextArea1.setText("You valiantly fight the aliens... But, you are defeated...\nAn alien says to you..."
                                + "\"YOU HAVE IMPRESSED US. IT WAS A PLEASURE TO SEE.\nJOIN US, AND TOGETHER WE SHALL RULE THE WORLD.\""
                                + "\nWhat will you do?\n1. Rule with the aliens\n2. Refuse");
                        if (second==2){
                            second=1;
                            if (userChoice==1){nature[8]++;nature[10]++;}
                            else {nature[2]+=4;userChoice=1;}}}
                    else if (userChoice==2) {nature[6]+=2;}
                    else {nature[10]+=2;}}
                break;
            case 3:
                disable(2);
                jTextArea1.setText("There is a scream from behind a door! How will you react?"
                        + "\n1. Yank open the door\n2. Scream in unison");
                if (second==1){
                    if (userChoice==1){nature[0]++;nature[2]+=2;}
                    else {nature[5]+=2;}}
                break;
            case 4:
                disable(4);
                jTextArea1.setText("A delinquent is hassling a girl on a busy city street!\nWhat will you do?"
                        + "\n1. Help without hesitation\n2. Help, even if scared\n3. Call the police\n4. Do nothing out of fear");
                if (second==1){
                    if (userChoice==1){nature[2]+=3;}
                    else if (userChoice==2){nature[0]+=2;nature[2]+=2;}
                    else if (userChoice==3){nature[1]++;nature[6]++;nature[10]++;}
                    else {nature[6]+=2;}}
                break;
        }
    }
    public void jolly(){
        switch (questionChoice){
            case 1:
                disable(2);
                jTextArea1.setText("Are you a cheerful personality?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[3]+=2;nature[5]++;}
                    else {nature[8]++;nature[12]++;}}
                break;
            case 2:
                disable(2);
                jTextArea1.setText("Do you like to noisily enjoy yourself with others?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[3]+=2;nature[11]++;}
                    else {nature[6]++;}}
                break;
            case 3:
                disable(3);
                jTextArea1.setText("It's the summer holidays! Where would you like to go?"
                        + "\n1. The beach!\n2. Spas\n3. Anywhere");
                if (second==1){
                    if (userChoice==1){nature[3]+=2;}
                    else if (userChoice==2){nature[9]+=2;}
                    else {nature[12]+=2;}}
                break;
            case 4:
                disable(3);
                jTextArea1.setText("A foreign person has started up a conversation with you.\nTo be honest, "
                        + "you don't have a clue what this fellow is saying.\nHow do you reply?"
                        + "\n1. Haha! Yes. Very funny!\n2. Um... Could you say that again?\n3. Right... Well, I gotta go");
                if (second==1){
                    if (userChoice==1){nature[3]+=3;}
                    else if (userChoice==2){nature[0]+=2;}
                    else {nature[6]+=2;}}
                break;
        }
    }
    public void impish(){
        switch (questionChoice){
            case 1:
                disable(2);
                jTextArea1.setText("Have you ever made a pitfall trap?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[4]+=2;nature[11]++;}
                    else {nature[9]+=2;}}
                break;
            case 2:
                disable(2);
                jTextArea1.setText("Do you like pranks?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[4]+=2;}
                    else {nature[1]++;nature[10]++;}}
                break;
            case 3:
                disable(2);
                jTextArea1.setText("Are there many things that you would like to do?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[0]++;nature[4]+=2;}
                    else {nature[8]++;nature[12]+=2;}}
                break;
            case 4:
                disable(3);
                jTextArea1.setText("Your friend is being bullied! What do you do?"
                        + "\n1. Face up to the bully\n2. Caution the bully from afar\n3. Heckle the bully from behind");
                if (second==1){
                    if (userChoice==1){nature[2]+=3;}
                    else if (userChoice==2){nature[6]+=2;}
                    else {nature[4]+=2;}}
                break;
        }
    }
    public void naive(){
        switch (questionChoice){
            case 1:
                disable(3);
                jTextArea1.setText("Do you like groan-inducing puns?"
                        + "\n1. Love them!\n2. A little\n3. Spare me");
                if (second==1){
                    if (userChoice==1){nature[4]++;nature[5]+=3;}
                    else if (userChoice==2){nature[3]+=2;}
                    else {nature[8]+=2;}}
                break;
            case 2:
                disable(2);
                jTextArea1.setText("Do you tend to laugh a lot?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[1]++;nature[5]++;}
                    else {nature[12]++;}}
                break;
            case 3:
                disable(2);
                jTextArea1.setText("Do others often call you childish?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[3]++;nature[5]+=2;}
                    else {nature[9]+=2;}}
                break;
            case 4:
                disable(2);
                jTextArea1.setText("Do you like to imagine things for your amusement?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[5]+=2;}
                    else {nature[7]+=2;}}
                break;
        }
    }
    public void timid(){
        switch (questionChoice){
            case 1:
                disable(3);
                jTextArea1.setText("A human hand extends out of a toilet! What would you do?"
                        + "\n1. Scream and run\n2. Close the lid without a word\n3. Shake hands with it");
                if (second==1){
                    if (userChoice==1){nature[6]+=2;}
                    else if (userChoice==2){nature[0]++;nature[9]+=2;}
                    else {nature[2]+=2;nature[4]++;nature[5]++;}}
                break;
            case 2:
                disable(5);
                jTextArea1.setText("Grab any digit on your left hand with your right hand.\nWhich digit did you grab?"
                        + "\n1. Thumb\n2. Index finger\n3. Middle finger\n4. Ring finger\n5. Little finger");
                if (second==1){
                    if (userChoice==1){nature[6]+=2;}
                    else if (userChoice==2){nature[7]+=2;}
                    else if (userChoice==3){nature[3]+=2;}
                    else if (userChoice==4){nature[8]+=2;}
                    else {nature[11]+=2;}}
                break;
            case 3:
                disable(3);
                jTextArea1.setText("You are suddenly locked inside a pitch-black room! What do you do?"
                        + "\n1. Kick the door\n2. Cry\n3. Clean it");
                if (second==1){
                    if (userChoice==1){nature[6]+=2;}
                    else if (userChoice==2){nature[11]+=2;}
                    else {nature[4]+=2;nature[12]++;}}
                break;
            case 4:
                disable(3);
                jTextArea1.setText("Can you go into a haunted house?"
                        + "\n1. No problem!\n2. Uh... N-no...\n3. With someone I like");
                if (second==1){
                    if (userChoice==1){nature[2]+=3;}
                    else if (userChoice==2){nature[6]+=2;}
                    else {nature[8]+=2;}}
                break;
        }
    }
    public void hasty(){
        switch (questionChoice){
            case 1:
                disable(3);
                jTextArea1.setText("You receive a gift! But you don't know what's in it.\nYou're curious, so what do you do?"
                        + "\n1. Open it now\n2. Open it later\n3. Get someone to open it");
                if (second==1){
                    if (userChoice==1){nature[7]+=2;}
                    else if (userChoice==2){nature[9]+=2;}
                    else {nature[6]+=2;}}
                break;
            case 2:
                disable(3);
                jTextArea1.setText("You win a lottery! What do you do with the money?"
                        + "\n1. Spend it now\n2. Save it\n3. Give it away");
                if (second==1){
                    if (userChoice==1){nature[3]+=2;nature[7]++;}
                    else if (userChoice==2){nature[0]++;nature[9]++;}
                    else {nature[2]+=2;nature[12]+=2;}}
                break;
            case 3:
                disable(3);
                jTextArea1.setText("You come across a treasure chest! What do you do?"
                        + "\n1. Open it right away!\n2. No... Could be a trap...\n3. It's going to be empty...");
                if (second==1){
                    if (userChoice==1){nature[7]+=2;}
                    else if (userChoice==2){nature[6]+=2;}
                    else {nature[8]+=2;}}
                break;
            case 4:
                disable(3);
                jTextArea1.setText("Your friend fails to show up for a meeting at the promised time.\nWhat do you do?"
                        + "\n1. Become irritated\n2. Wait patiently\n3. Get angry and bail");
                if (second==1){
                    if (userChoice==1){nature[1]+=2;nature[7]+=2;}
                    else if (userChoice==2){nature[10]+=2;}
                    else {nature[7]+=3;}}
                break;
        }
    }
    public void sassy(){
        switch (questionChoice){
            case 1:
                disable(3);
                jTextArea1.setText("Your country's leader is in front of you.\nHow do you speak to him or her?"
                        + "\n1. Speak nature[9]ly\n2. Speak nervously\n3. WHATEVER!!");
                if (second==1){
                    if (userChoice==1){nature[0]+=2;}
                    else if (userChoice==2){nature[1]+=2;}
                    else {nature[8]+=2;}}
                break;
            case 2:
                disable(2);
                jTextArea1.setText("Do others tell you to watch what you say?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[4]++;nature[8]+=2;}
                    else {nature[9]+=2;}}
                break;
            case 3:
                disable(2);
                jTextArea1.setText("Do you think you are cool? Be honest"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[8]+=2;}
                    else {nature[10]+=2;}}
                break;
            case 4:
                disable(2);
                jTextArea1.setText("Can you sincerely thank someone when you feel grateful?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[1]+=2;nature[9]++;}
                    else {nature[8]+=2;nature[12]++;}}
                break;
        }
    }
    public void calm(){
        switch (questionChoice){
            case 1:
                disable(2);
                jTextArea1.setText("Do you occasionally consider yourself dull and overly cautious?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[9]+=2;nature[11]++;}
                    else {nature[0]+=2;}}
                break;
            case 2:
                disable(2);
                jTextArea1.setText("Do you dream of lounging around idly without much excitement?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[9]+=2;}
                    else {nature[4]+=2;}}
                break;
            case 3:
                disable(2);
                jTextArea1.setText("Do you like to fight?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[4]++;nature[6]+=2;}
                    else {nature[9]+=2;nature[11]++;}}
                break;
            case 4:
                disable(2);
                jTextArea1.setText("Do you often yawn?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[9]+=2;nature[10]++;}
                    else {nature[0]++;nature[7]+=2;}}
                break;
        }
    }
    public void relaxed(){
        switch (questionChoice){
            case 1:
                disable(2);
                jTextArea1.setText("Are you often late for school or meetings?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[8]++;nature[10]+=2;}
                    else {nature[0]+=2;nature[7]++;}}
                break;
            case 2:
                disable(2);
                jTextArea1.setText("Do you get the feeling that you've slowed down lately?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[10]+=2;}
                    else {nature[4]++;nature[7]+=2;}}
                break;
            case 3:
                disable(3);
                jTextArea1.setText("It is a pleasant day at the beach. How do you feel?"
                        + "\n1. This feels great!\n2. Snore...\n3. I want to go home soon!");
                if (second==1){
                    if (userChoice==1){nature[3]+=2;}
                    else if (userChoice==2){nature[10]+=2;}
                    else {nature[7]+=2;}}
                break;
            case 4:
                disable(2);
                jTextArea1.setText("Do you fall asleep without noticing?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[9]++;nature[10]+=2;}
                    else {nature[0]+=2;}}
                break;
        }
    }
    public void lonely(){
        switch (questionChoice){
            case 1:
                disable(2);
                jTextArea1.setText("Do you feel lonesome when you are alone?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[6]++;nature[11]+=2;}
                    else {nature[2]+=3;nature[10]++;}}
                break;
            case 2:
                disable(2);
                jTextArea1.setText("Do you hate to be the last person to leave class at\nthe end of a school day?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[6]++;nature[11]+=2;}
                    else {nature[2]+=3;nature[10]++;}}
                break;
            case 3:
                disable(2);
                jTextArea1.setText("What do you do with your room's light when you're\ngoing to bed at night?"
                        + "\n1. Leave it on\n2. Turn it off");
                if (second==1){
                    if (userChoice==1){nature[6]++;nature[11]+=2;}
                    else {nature[9]+=2;}}
                break;
            case 4:
                disable(3);
                jTextArea1.setText("It's a weekend, but no one will play with you... What do you do?"
                        + "\n1. Go on a trip!\n2. Hang around vacantly\n3. Huddle in a corner");
                if (second==1){
                    if (userChoice==1){nature[3]++;nature[11]++;}
                    else if (userChoice==2){nature[9]++;nature[10]+=2;}
                    else {nature[6]++;nature[11]+=3;}}
                break;
        }
    }
    public void quirky(){
        switch (questionChoice){
            case 1:
                disable(2);
                jTextArea1.setText("Do you sometimes run out of things to do all of a sudden?"
                        + "\n1. Yes\n2. No");
                if (second==1){
                    if (userChoice==1){nature[12]+=2;}
                    else {nature[0]+=2;}}
                break;
            case 2:
                disable(3);
                jTextArea1.setText("How quickly do you respond to an e-mail?"
                        + "\n1. Reply right away\n2. May reply, may not\n3. Too much trouble");
                if (second==1){
                    if (userChoice==1){nature[0]++;nature[7]++;}
                    else if (userChoice==2){nature[12]+=2;}
                    else {nature[8]+=2;}}
                break;
            case 3:
                disable(4);
                jTextArea1.setText("There is a person you like... But there's no opportunity\nto get close. What do you do?"
                        + "\n1. Bravely declare my love\n2. Might say hello...\n3. Pull a prank to get attention\n4. Look from afar");
                if (second==1){
                    if (userChoice==1){nature[0]++;nature[2]+=3;}
                    else if (userChoice==2){nature[12]+=2;}
                    else if (userChoice==3){nature[4]+=2;}
                    else {nature[6]+=2;}}
                break;
            case 4:
                disable(3);
                jTextArea1.setText("The road forks to the right and left. You are told there\nis a treasure on the right side. What do you do?"
                        + "\n1. Instantly go right\n2. It's a trap! Go left\n3. Choose either side");
                if (second==1){
                    if (userChoice==1){nature[1]+=2;}
                    else if (userChoice==2){nature[8]+=2;}
                    else {nature[12]+=2;}}
                break;
        }
    }
    public void miscellaneous(){
        questionChoice = (int)Math.ceil(Math.random()*3);
        switch (questionChoice){
            case 1:
                disable(2);
                jTextArea1.setText("On vacation outings, you want to..."
                        + "\n1. Go alone\n2. Go with others");
                if (second==1){
                    if (userChoice==1){nature[7]++;nature[12]++;}
                    else {nature[3]++;nature[11]++;}}
                break;
            case 2:
                disable(2);
                jTextArea1.setText("It's the summer festival! Do you like carnivals?"
                        + "\n1. Love them!\n2. Don't care");
                if (second==1){
                    if (userChoice==1){nature[3]+=2;}
                    else {nature[8]++;nature[12]++;}}
                break;
            case 3:
                disable(2);
                jTextArea1.setText("Somebody calls you \"weird but funny.\" How does that make you feel?"
                        + "\n1. Happy!\n2. Not happy");
                if (second==1){
                    if (userChoice==1){nature[5]++;nature[11]++;}
                    else {nature[7]++;nature[8]++;}}
                break;
        }
    }
    /*Description - method that disables certain buttons from being selected
     Pre - Passes an int
     Post - N/A
    */
    public void disable(int num){
        //I disable buttons 3,4 and 5 and enable them if the num is high enough
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        if (num>2){jButton3.setEnabled(true);}
        if (num>3){jButton4.setEnabled(true);}
        if (num>4){jButton5.setEnabled(true);}
    }
    /*Description - method that determines what Pokemon you are
     Pre - Passes a gender value (String)
     Post - N/A
    */
    public void monChoice(String gender){
        disable(2);
        //I define my nature choice and pokemon variables
        int nChoice = 0; String mon = "Crap";
        //I make a for loop that loops through all of the natures
        for (int i=0;i<13;i++){
            //If the currently-looped nature has more points than the current nature choice it overwrites it
            if (nature[i]>nature[nChoice]){nChoice=i;}
            //If they are tied I let RNG decide the fate
            if (nature[i]==nature[nChoice]){
                userChoice = (int)Math.ceil(Math.random()*2);
                if (userChoice==2){nChoice=i;}
            }
        }
        //I then pick the Pokemon according to gender and most prominent nature type
        if (gender=="Male ♂"){
            switch (nChoice){
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
        else if (gender=="Female ♀"){
            switch (nChoice){
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
        jTextArea1.setText("You are a "+gender+" "+mon+"! You're very "+personality[nChoice]+"!\nStats:"
                + "\t"+personality[0]+" - "+nature[0]+"\n"
                + personality[1]+" - "+nature[1]+"\t"+personality[2]+" - "+nature[2]+"\t"+personality[3]+" - "+nature[3]+"\n"
                + personality[4]+" - "+nature[4]+"\t"+personality[5]+" - "+nature[5]+"\t"+personality[6]+" - "+nature[6]+"\n"
                + personality[7]+" - "+nature[7]+"\t"+personality[8]+" - "+nature[8]+"\t"+personality[9]+" - "+nature[9]+"\n"
                + personality[10]+" - "+nature[10]+"\t"+personality[11]+" - "+nature[11]+"\t"+personality[12]+" - "+nature[12]+"\n\n"
                + "Play again?\n1. Yes\n2. No");
    }   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}