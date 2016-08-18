/*TextPanelTypeThomas
* Software that uses GUI and text files to create a chat client to chat with other people on the same computer
* Thomas Dedinsky
* 13/04/2016
*/
//Note that there are two other near duplicate files to this that won't be commented
//Also I use a ghost file that is equivalent to what is on the chat client's screen
//And constantly try to sync it up with the text file everyone is writing into
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TextPanelTypeThomas
{
    //I define way too many variables
    private static String ENTER = "Enter";
    static JButton enterButton;
    public static JTextArea output;
    public static JTextField input;
    static JFrame frame;
    static JPanel panel;
    public static String testString = "!";
    public static String fileName = "temp.txt";
    public static String ghostName = "ghostThomas.txt";

    public static void main(String... args)
    {
        //I prep to create the client's frame then I call upon createFrame()
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        createFrame();
    }
    
    /*Description - method that refreshes the chat client's text on command
     Pre - N/A
     Post - N/A
    */
    public static void refresh()
    {
            //I define both of my texts' lines as null
            String line = null;
            String gLine = null;
            try {
            //I open up a fileWriter and fileReader, and ghost versions of them
            //The ghost version is to compare what is currently on the screen
            //With what is actually in the text file, as it can be modified by others
            FileWriter fileWriter =
                new FileWriter(fileName, true);
            FileWriter ghostWriter =
                new FileWriter(ghostName, true);
            
            FileReader fileReader = 
                new FileReader(fileName);
            FileReader ghostReader = 
                new FileReader(ghostName);

            // Always wrap FileWriter in BufferedWriter, same with the ghost
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            BufferedWriter ghostBWriter =
                new BufferedWriter(ghostWriter);

            // Always wrap FileReader in BufferedReader, same with the ghost
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            BufferedReader ghostBReader = 
                new BufferedReader(ghostReader);
            
            //I loop both the regular and ghost text files to go through each line
            while((line = bufferedReader.readLine()) != null){
                if ((gLine = ghostBReader.readLine()) != null){}
                if (gLine==null)
                {
                    //If the ghost line becomes null, I add each of the remaining text's lines
                    //Onto both the client's text and the ghost text file
                    output.append(line);
                    output.append("\n");
                    ghostBWriter.write(line);
                    ghostBWriter.newLine();
                }
            }
            //I close everything and declare bankruptcy 
            bufferedWriter.close();  
            fileWriter.close();
            ghostBWriter.close();  
            ghostWriter.close();  
            bufferedReader.close();  
            fileReader.close();  
            ghostBReader.close();  
            ghostReader.close();  
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
        input.requestFocus();
    }

    /*Description - method that creates the chat client's frame with text
     Pre - N/A
     Post - N/A
    */
    public static void createFrame()
    {
        //I make the title and set up to have the X button close the client
        frame = new JFrame("Thomas - State of the art chat client");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //I create a JPanel and a ButtonListener
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(true);
        ButtonListener buttonListener = new ButtonListener();
        //I define the output that can add lines of text onto the frame
        output = new JTextArea(25, 66);
        output.setWrapStyleWord(true);
        output.setEditable(false);
        //I define the scroll bars
        JScrollPane scroller = new JScrollPane(output);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        //I create the input field
        JPanel inputpanel = new JPanel();
        inputpanel.setLayout(new FlowLayout());
        input = new JTextField(20);
        //I create the enter button
        enterButton = new JButton("Enter");
        enterButton.setActionCommand(ENTER);
        enterButton.addActionListener(buttonListener);
        input.setActionCommand(ENTER);
        input.addActionListener(buttonListener);
        //I make a refresh button
        JButton refresh = new JButton("Refresh");
        refresh.setActionCommand("Refresh");
        enterButton.addActionListener(buttonListener);
        input.setActionCommand("Refresh");
        refresh.addActionListener(buttonListener);
        //I add the scroll bars
        panel.add(scroller);
        //I add the input field, enter and refresh buttons
        inputpanel.add(input);
        inputpanel.add(enterButton);
        inputpanel.add(refresh);
        panel.add(inputpanel);
        //I define a bunch of frame stuff
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.pack();
        frame.setLocationByPlatform(true);
        //I set the frame to the center of the screen, 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        input.requestFocus();
        //I make my text's line null
        String line = null;
        try {
            //I make a file reader and a ghost writer
            FileReader fileReader = 
                new FileReader(fileName);
            FileWriter ghostWriter =
                new FileWriter(ghostName, false);

            //I make buffered wraps
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            BufferedWriter ghostBWriter =
                new BufferedWriter(ghostWriter);
            
            //For every line of the text file I append it to my client
            //And I write it into my ghost file
            while((line = bufferedReader.readLine()) != null) {
                output.append(line);
                output.append("\n");
                ghostBWriter.write(line);
                ghostBWriter.newLine();
            }   

            //Less bankruptcy
            ghostBWriter.close(); 
            bufferedReader.close(); 
            ghostWriter.close();
            fileReader.close(); 
        }
        //At this point I'm a professional ball player with all of these catches
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }

    /*Description - method that watches for user input (buttons)
     Pre - N/A
     Post - N/A
    */
    public static class ButtonListener implements ActionListener 
    {
        //This activates if a button is clicked
        public void actionPerformed(final ActionEvent ev)
        {
            //I define my text's line null
            String line = null;
            try {
            //I define a fileWriter and ghostWriter
            FileWriter fileWriter =
                new FileWriter(fileName, true);
            FileWriter ghostWriter =
                new FileWriter(ghostName, true);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            BufferedWriter ghostBWriter =
                new BufferedWriter(ghostWriter);
            //I define the button command as a String
            String cmd = ev.getActionCommand();
            //I make sure the text box isn't empty
            if (!input.getText().trim().equals(""))
            {
                if (ENTER.equals(cmd))
                {
                    //If the person clicked "Enter" I call upon refresh() to sync the two files
                    refresh();
                    //I write the new text message on the ghost, regular files, and the client
                    output.append("Thomas: "+input.getText());
                    bufferedWriter.write("Thomas: "+input.getText());
                    bufferedWriter.newLine();
                    ghostBWriter.write("Thomas: "+input.getText());
                    ghostBWriter.newLine();
                    output.append("\n");
                    input.setText("");
                }
            }
            //If the person clicked refresh I call upon refresh()
            else if (cmd.equals("Refresh")){refresh();}
            //https://www.youtube.com/watch?v=XgJFqVvb2Ws
            ghostBWriter.close();
            bufferedWriter.close();  
            ghostWriter.close();  
            fileWriter.close();  
            }
            //http://static.rcgroups.net/forums/attachments/2/8/1/4/7/a1684616-91-baseball-catch.jpg
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
            input.requestFocus();
        }
    }
}