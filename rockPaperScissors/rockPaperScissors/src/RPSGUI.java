/*RPSGUI
* GUI software that will play a rock-paper-scissors game with the computer to 10.
* Thomas Dedinsky
* 09/04/2016
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class RPSGUI extends JPanel implements ActionListener{
    //I define a bunch of variables
    protected JButton b1, b2, b3, b4, b5;
    private JLabel label = new JLabel("© Thomas Dedinsky");
    final JTextField aTextField = new JTextField("Welcome to Rock Paper Scissors! Let's start! Choose a move! Game is to 10, have fun, and don't fail!!!");
    public int userScore = 0; public int compScore = 0; public int round = 0; public int winner; public int boom = 0; public long tStart; public long tEnd; public long count;
    /*Description - method that creates the jFrame
     Pre - N/A
     Post - Returns jFrame with 3 boxes and a text field
    */
    public RPSGUI(){
        //I assign the button icons to saved images
        ImageIcon leftButtonIcon = createImageIcon("/rock.png");
        ImageIcon middleButtonIcon = createImageIcon("/paper.png");
        ImageIcon rightButtonIcon = createImageIcon("/scissors.png");
        //I define my rock button ans set its position and whatnot
        b1 = new JButton("Rock", leftButtonIcon);
        b1.setVerticalTextPosition(AbstractButton.BOTTOM);
        b1.setHorizontalTextPosition(AbstractButton.CENTER);
        b1.setMnemonic(KeyEvent.VK_R);
        b1.setActionCommand("Rock");
        //I define my paper button ans set its position and whatnot
        b2 = new JButton("Paper", middleButtonIcon);
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setMnemonic(KeyEvent.VK_P);
        b2.setActionCommand("Paper");
        //I define my scissors button ans set its position and whatnot
        b3 = new JButton("Scissors", rightButtonIcon);
        b3.setVerticalTextPosition(AbstractButton.BOTTOM);
        b3.setHorizontalTextPosition(AbstractButton.CENTER);
        b3.setMnemonic(KeyEvent.VK_S);
        b3.setActionCommand("Scissors");
        //I listen for actions on buttons 1, 2 and 3.
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        //I set hover text
        b1.setToolTipText("Select rock!");
        b2.setToolTipText("Select paper!");
        b3.setToolTipText("Select scissors!");
        //I add the components to the container.
        add(b1);add(b2);add(b3);add(aTextField);add(label);
    }
    public Dimension getPreferredSize() {return new Dimension(720, 260);}
    /*Description - void method that calculates the computer's response and determines a winner
     Pre - Passes an ActionEvent (when a user clicks on a button it runs)
     Post - Calls on the winner method based on the button pressed
    */
    public void actionPerformed(ActionEvent e){
        if ("Rock".equals(e.getActionCommand())){winner(1);}
        else if ("Paper".equals(e.getActionCommand())){winner(2);}
        else {winner(3);}
    }
    /*Description - method that checks whether or not I have valid images
     Pre - N/A
     Post - N/A
    */
    protected static ImageIcon createImageIcon(String path){
        java.net.URL imgURL = RPSGUI.class.getResource(path);
        if (imgURL != null) {return new ImageIcon(imgURL);}
        else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    /*Description - int method that calculates the computer's response and determines a winner
     Pre - Passes an int; the user's input
     Post - Returns a 0/1/2 response
    */
    public void winner(int userInput){
        if (boom==2) {System.exit(0);}
        //I define my variable that I will return to determine the winner
        int winner=0; String compChoice; String winLose = "";
        //I create the computer input and tell the user what that means to them
        int compInput = (int)Math.ceil(Math.random()*3);
        if (compInput==1) {compChoice = "rock! ";}
        else if (compInput==2) {compChoice = "paper! ";}
        else {compChoice = "scissors! ";}
        //I determine if the user won, computer won, or if they tied, and tell the user the results
        if (compInput==1&&userInput==2||compInput==2&&userInput==3||compInput==3&&userInput==1){
            winLose = "You win.";
            userScore++;
        }
        else if (compInput==2&&userInput==1||compInput==3&&userInput==2||compInput==1&&userInput==3){
            winLose = "You lost.";
            compScore++;
        }
        else{winLose = "You tied.";}
        round++;
        aTextField.setText("The computer picked "+compChoice+winLose+" Round "+round+": You - "+userScore+" Computer - "+compScore+". What move do you choose?");
        //This is basically my doomsday timer initiation
        if ((userScore==10||compScore==10)&&boom==0){
            tStart = System.currentTimeMillis();
            tEnd = System.currentTimeMillis();
            boom++;
        }
        //This safety text eases stubborn users
        if (userScore>10&&compScore>10){
            aTextField.setText("Click a button in 3 seconds to blow up the game.");
            tEnd = System.currentTimeMillis();
            count = tEnd - tStart;
        }
        //I tell the user if they've won the game or not
        if (userScore==10){
            aTextField.setText("You won the whole game! Click a button in 3 seconds to blow up the game.");
            userScore=11;
            compScore=11;
        }
        else if (compScore==10){
            aTextField.setText("You lost the whole game! Click a button in 3 seconds to blow up the game.");
            userScore=11;
            compScore=11;
        }
        //This checks, when the user next inputs after a game, if it's been 3 seconds
        if (count>3000){System.exit(0);}
    }
    /*Description - void method that sets up the container of the gui
     Pre - N/A
     Post - N/A
    */
    private static void createAndShowGUI(){
        //Create and set up the window.
        JFrame frame = new JFrame("Rock Paper Scissors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Create and set up the content pane.
        RPSGUI newContentPane = new RPSGUI();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
    //I run the GUI
    public static void main(String[] args) {javax.swing.SwingUtilities.invokeLater(new Runnable() {public void run() {createAndShowGUI();}});}
}