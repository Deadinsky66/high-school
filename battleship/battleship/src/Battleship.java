/*Battleship
* GUI software that plays battleship, made in a week to show other grade 11/12 peeps how to start a basic project
* Thomas Dedinsky
* 07/06/2016
*/
//Import all of my necessary stuff
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.lang.Float.isNaN;
public class Battleship extends JPanel {
    //I define my 3 main buttons plus two button panels
    private JButton startButton, exitButton, resetButton, shipButton;
    private JPanel buttonPanel, buttonPanel2;
    private JLabel label = new JLabel("© Thomas Dedinsky");
    private JTextField jTextField = new JTextField("# of ships");
    //I define arrays keeping track of where the ships are, which buttons are pressed, and which are hits
    public int[] p1ship = new int[100];public int[] p2ship = new int[100];
    public int[] p1pressed = new int[100];public int[] p2pressed = new int[100];public int[] p1hit = new int[100];public int[] p2hit = new int[100];
    //These are counting variables to make sure I'm placing values in my array properly
    public int p1count=5;public int p2count=5;public int turn=0;public int p1num=0;public int p2num=0;public int ships=5;public float num;
    //I make two arrays of buttons; one for each player
    JButton[] b  = new JButton[100];JButton[] c  = new JButton[100];
    public Battleship() {
        //I make a buttonlistener, and then a button panel with a 10x10 grid layout
        ButtonListener listener = new ButtonListener();
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(300, 300));
        GridLayout buttonLayout = new GridLayout(10, 10, 0, 0);
        buttonPanel.setLayout(buttonLayout);
        //This for loop defines each of these characteristics to all of my buttons for player 1
        for(int i=0;i<100;i++){
            //I add a non-reachable value in each spot of my pressed array; this helps formatting later
            p1pressed[i]=100;p2pressed[i]=100;p1hit[i]=100;p2hit[i]=100;p1ship[i]=100;p2ship[i]=100;
            //I set the button's text as (Letter)(Number), based on which column and row it's in
            b[i] = new JButton((char)(((i)/10)+65)+String.valueOf(((i)%10)+1));
            //I give it some characteristics, add an action listener to it, then add it to the button panel
            b[i].setPreferredSize(new Dimension(30, 30));
            b[i].setBorder(null);
            b[i].setBorderPainted(false);
            b[i].addActionListener(listener);
            b[i].setBackground(Color.white); 
            buttonPanel.add(b[i]);
        }
        //I add the button panel to the gui
        add(buttonPanel);
        //I repeat the same exact steps for player 2
        buttonPanel2 = new JPanel();
        buttonPanel2.setPreferredSize(new Dimension(300, 300));
        GridLayout buttonLayout2 = new GridLayout(10, 10, 0, 0);
        buttonPanel2.setLayout(buttonLayout2);
        for(int i=0;i<100;i++){
            c[i] = new JButton((char)(((i)/10)+65)+String.valueOf(((i)%10)+1));
            c[i].setPreferredSize(new Dimension(30, 30));
            c[i].setBorder(null);
            c[i].setBorderPainted(false);
            c[i].addActionListener(listener);
            c[i].setBackground(Color.white); 
            buttonPanel2.add(c[i]);
        }
        add(buttonPanel2);
        //I define/add my start button, exit button, reset button, ship number text field/button, and copyright
        startButton = new JButton();
        startButton.setText("Start");
        startButton.addActionListener(listener);
        startButton.setEnabled(false);
        add(startButton);
        exitButton = new JButton();
        exitButton.setText("Exit");
        exitButton.addActionListener(listener);
        add(exitButton);
        resetButton = new JButton();
        resetButton.setText("Reset");
        resetButton.addActionListener(listener);
        resetButton.setEnabled(false);
        add(resetButton);
        shipButton = new JButton();
        shipButton.setText("Set");
        shipButton.addActionListener(listener);
        shipButton.setEnabled(true);
        add(jTextField);
        add(shipButton);
        add(label);
    }
    //This sets the dimensions of the gui
    public Dimension getPreferredSize() {return new Dimension(610, 330);}
    //This class processes which button was pressed and decides how to handle it
    private class ButtonListener implements ActionListener {
        @Override
        // Overriding the ActionPerformed method of ActionListener
        public void actionPerformed(ActionEvent action) {
            //This is from the ship planning stage, before the game starts
            if (p1count>-1||p2count>-1){
                /*I check all of my ship buttons, and repeat the same steps for either player
                  I disable the button that was pressed, disable the ability to change # of ships
                  Add that ship's number to an array, and lower that player's ship count
                */
                for (int i=0;i<100;i++){
                    if (action.getSource() == b[i]){
                        shipButton.setEnabled(false);
                        jTextField.setEnabled(false);
                        p1ship[(ships-p1count)]=i;
                        p1count--;
                        b[i].setEnabled(false);
                    }
                    if (action.getSource() == c[i]){
                        shipButton.setEnabled(false);
                        jTextField.setEnabled(false);
                        p2ship[(ships-p2count)]=i;
                        p2count--;
                        c[i].setEnabled(false);
                    }
                }
            }
            //Once the ships are done being placed for either player, I disable their buttons
            //One, to not glitch the game, and two, to make screen peeking hard
            if (p1count==0){for (int i=0;i<100;i++){b[i].setEnabled(false);}}
            if (p2count==0){for (int i=0;i<100;i++){c[i].setEnabled(false);}}
            //If both players are ready, I enable the start button
            if (p2count==0&&p1count==0){startButton.setEnabled(true);}
            //This activates when the game is actually happening
            if (p1count<-1&&p2count<-1&&p1count>-ships-2&&p2count>-ships-2){
                for (int i=0;i<100;i++){
                    //If a button was pressed, I determine if it was a hit or a miss
                    if (action.getSource() == b[i]){
                        b[i].setText("Y");
                        for (int j=0;j<p2ship.length;j++){
                            if (p2ship[j]==i){
                                //If it was a hit, I add it to my array of hit ships, and then lower the hit count
                                b[i].setText("Z");
                                p1hit[(-2-p1count)]=i;
                                p1count--;
                            }
                        }
                        //I add that button to the array of pressed, increment the pressed count, then switch the turn
                        p1pressed[p1num]=i;
                        p1num++;
                        turn=0;
                    }
                    //Same exact steps for the other player
                    if (action.getSource() == c[i]){
                        c[i].setText("Y");
                        for (int j=0;j<p1ship.length;j++){
                            if (p1ship[j]==i){
                                c[i].setText("Z");
                                p2hit[(-2-p2count)]=i;
                                p2count--;
                            }
                        }
                        p2pressed[p2num]=i;
                        p2num++;
                        turn=1;
                    }
                }
                //Depending on whose turn it is...
                if (turn==0){
                    for (int i=0;i<100;i++){
                        //I disable all of p1's buttons, make them black, enable p2's and white
                        b[i].setEnabled(false);
                        b[i].setBackground(Color.black); 
                        c[i].setEnabled(true);
                        c[i].setBackground(Color.white); 
                    }
                    //The pressed buttons I make gray and disable
                    for (int i=0;i<100;i++){
                        if (p2pressed[i]<100){
                            c[p2pressed[i]].setEnabled(false);
                            c[p2pressed[i]].setBackground(Color.gray);
                        }
                    }
                    //The hit buttons I make red
                    for (int i=0;i<100;i++){if (p2hit[i]<100){c[p2hit[i]].setBackground(Color.red);}}
                }
                //Same steps for the other player
                if (turn==1){
                    for (int i=0;i<100;i++){
                        b[i].setEnabled(true);
                        b[i].setBackground(Color.white); 
                        c[i].setEnabled(false);
                        c[i].setBackground(Color.black); 
                    }
                    for (int i=0;i<100;i++){
                        if (p1pressed[i]<100){
                            b[p1pressed[i]].setEnabled(false);
                            b[p1pressed[i]].setBackground(Color.gray);
                        }
                    }
                    for (int i=0;i<100;i++){if (p1hit[i]<100){ b[p1hit[i]].setBackground(Color.red);}}
                }
            }
            //When one of the players is defeated this activates
            if (p1count==-ships-2||p2count==-ships-2){
                for (int i=0;i<100;i++){
                    //I reset the text of all of the buttons, disable them, and set their appropriate colours
                    b[i].setText((char)(((i)/10)+65)+String.valueOf(((i)%10)+1));
                    b[i].setEnabled(false);
                    b[i].setBackground(Color.white);
                    c[i].setText((char)(((i)/10)+65)+String.valueOf(((i)%10)+1));
                    c[i].setEnabled(false);
                    c[i].setBackground(Color.white); 
                }
                for (int i=0;i<100;i++){
                    if (p2pressed[i]<100){c[p2pressed[i]].setBackground(Color.gray);}
                    if (p1pressed[i]<100){b[p1pressed[i]].setBackground(Color.gray);}
                }
                for (int i=0;i<100;i++){
                    if (p2ship[i]<100){b[p2ship[i]].setBackground(Color.blue);}
                    if (p1ship[i]<100){c[p1ship[i]].setBackground(Color.blue);}
                }
                for (int i=0;i<100;i++){
                    if (p2hit[i]<100){c[p2hit[i]].setBackground(Color.red);}
                    if (p1hit[i]<100){b[p1hit[i]].setBackground(Color.red);}
                }
                //I enable the reset button
                resetButton.setEnabled(true);
            }
            //Start Button - I set up the count/turn variables, player 2 to start, and disable the Start Button
            if (action.getSource() == startButton){
                p1count=-2;p2count=-2;turn=0;
                for (int i=0;i<100;i++){
                    b[i].setBackground(Color.black); 
                    c[i].setEnabled(true);
                }
                startButton.setEnabled(false);
            }
            //Reset Button - Reset all of the variables, arrays, buttons, disable the button and enable # of ships selection
            if (action.getSource() == resetButton){
                p1count=ships;p2count=ships;turn=0;p1num=0;p2num=0;
                for(int i=0;i<100;i++){
                    p1pressed[i]=100;p2pressed[i]=100;p1hit[i]=100;p2hit[i]=100;p1ship[i]=100;p2ship[i]=100;
                    b[i].setBackground(Color.white);b[i].setEnabled(true);
                    c[i].setBackground(Color.white);c[i].setEnabled(true);
                }
                resetButton.setEnabled(false);
                shipButton.setEnabled(true);
                jTextField.setEnabled(true);
            }
            //Exit Button - Closes the program
            if (action.getSource() == exitButton){System.exit(0);}
            //Ship Button - Check to see if the number inputted in the text field is a number, sets the ship/player counts to that
            if (action.getSource() == shipButton){
                try {num = Float.parseFloat(jTextField.getText());}
                catch(NumberFormatException ex) {num = 5;}
                if (num<100&&num>0){ships=(int)num;}
                p1count=ships;p2count=ships;
            }
        }
    }
    //I set up Battleship
    public static void main(String[] args) {
        JFrame frame = new JFrame("Battleship");
        frame.setBackground(Color.white);
        frame.getContentPane().add(new Battleship());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }                  
}