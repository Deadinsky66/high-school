package applet;

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

public class TextPanelTypeJustin
{
    private static String ENTER = "Enter";
    static JButton enterButton;
    public static JTextArea output;
    public static JTextField input;
    static JFrame frame;
    static JPanel panel;
    public static String testString = "!";
    public static String fileName = "temp.txt";
    public static String ghostName = "ghostJustin.txt";

    public static void main(String... args)
    {
        
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
    
    public static void refresh()
    {
            //I ask them to read or write.
            String line = null;
            String gLine = null;
            try {
            FileWriter fileWriter =
                new FileWriter(fileName, true);
            FileWriter ghostWriter =
                new FileWriter(ghostName, true);
            
            FileReader fileReader = 
                new FileReader(fileName);
            FileReader ghostReader = 
                new FileReader(ghostName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            BufferedWriter ghostBWriter =
                new BufferedWriter(ghostWriter);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            BufferedReader ghostBReader = 
                new BufferedReader(ghostReader);
            
            while((line = bufferedReader.readLine()) != null){
                if ((gLine = ghostBReader.readLine()) != null){
                }
                if (gLine==null)
                {
                    output.append(line);
                    output.append("\n");
                    ghostBWriter.write(line);
                    ghostBWriter.newLine();
                }
            }  
            bufferedWriter.close();  
            fileWriter.close();
            ghostBWriter.close();  
            ghostWriter.close();  
            bufferedReader.close();  
            fileReader.close();  
            ghostBReader.close();  
            ghostReader.close();  
        }
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
            input.requestFocus();
    }

    public static void createFrame()
    {
        frame = new JFrame("Justin - State of the art chat client");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(true);
        ButtonListener buttonListener = new ButtonListener();
        output = new JTextArea(25, 66);
        output.setWrapStyleWord(true);
        output.setEditable(false);
        JScrollPane scroller = new JScrollPane(output);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        JPanel inputpanel = new JPanel();
        inputpanel.setLayout(new FlowLayout());
        input = new JTextField(20);
        enterButton = new JButton("Enter");
        enterButton.setActionCommand(ENTER);
        enterButton.addActionListener(buttonListener);
        // enterButton.setEnabled(false);
        input.setActionCommand(ENTER);
        input.addActionListener(buttonListener);
        JButton refresh = new JButton("Refresh");
        refresh.setActionCommand("Refresh");
        enterButton.addActionListener(buttonListener);
        // enterButton.setEnabled(false);
        input.setActionCommand("Refresh");
        refresh.addActionListener(buttonListener);
        DefaultCaret caret = (DefaultCaret) output.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        panel.add(scroller);
        inputpanel.add(input);
        inputpanel.add(enterButton);
        inputpanel.add(refresh);
        panel.add(inputpanel);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.pack();
        frame.setLocationByPlatform(true);
        // Center of screen
        // frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        input.requestFocus();
        // The name of the file.
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);
            FileWriter ghostWriter =
                new FileWriter(ghostName, false);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter ghostBWriter =
                new BufferedWriter(ghostWriter);

            while((line = bufferedReader.readLine()) != null) {
                output.append(line);
                output.append("\n");
                ghostBWriter.write(line);
                ghostBWriter.newLine();
            }   

            // Always close files.
            ghostBWriter.close(); 
            bufferedReader.close(); 
            ghostWriter.close();
            fileReader.close(); 
        }
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

    public static class ButtonListener implements ActionListener 
    {

        public void actionPerformed(final ActionEvent ev)
        {
            // The name of the file.
            //I ask them to read or write.
            String line = null;
            try {
            FileWriter fileWriter =
                new FileWriter(fileName, true);
            FileWriter ghostWriter =
                new FileWriter(ghostName, true);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            BufferedWriter ghostBWriter =
                new BufferedWriter(ghostWriter);
            String cmd = ev.getActionCommand();
            if (!input.getText().trim().equals(""))
            {
                if (ENTER.equals(cmd))
                {
                    refresh();
                    output.append("Justin: "+input.getText());
                    bufferedWriter.write("Justin: "+input.getText());
                    bufferedWriter.newLine();
                    ghostBWriter.write("Justin: "+input.getText());
                    ghostBWriter.newLine();
                    output.append("\n");
                    input.setText("");
                }
            }
            else if (cmd.equals("Refresh")){refresh();}
            ghostBWriter.close();
            bufferedWriter.close();  
            ghostWriter.close();  
            fileWriter.close();  
            }
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
            input.requestFocus();
        }
    }
}