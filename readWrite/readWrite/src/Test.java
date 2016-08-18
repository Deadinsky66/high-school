/*Test
* Software that can read or write to a text file.
* Thomas Dedinsky
* 11/04/2016
*/
import java.io.*;
public class Test {
    public static void main(String [] args) {
        //The name of the file.
        String fileName = "temp.txt";
        char input = '!';
        do{ //I ask them to read or write.
            System.out.println("Do you want to read or write? (R/W)");
            input = In.getChar();
        } while (input!='R'&&input!='r'&&input!='W'&&input!='w');
        
        if (input=='R'||input=='r'){
        //This will reference one line at a time
        String line = null;
        try {
            //FileReader reads text files in the default encoding
            FileReader fileReader = 
                new FileReader(fileName);
            //Always wrap FileReader in BufferedReader
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   
            //Always close files
            bufferedReader.close(); 
            fileReader.close(); 
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
        else{
        try {
            //Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);
            //Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            //I ask the user to type messages
            System.out.println("What do you want to write?\nType in one character to stop.");
            String text;
            //I have this loop until the user enters a one character line. This also tracks how many bytes and lines they used.
            byte[] buffer;
            int length = 0,lines = 0;
            do{
                //I get the user's text and how many bytes it is
                text = In.getString();
                buffer = text.getBytes();
                //I check to see if it's a one-character input
                if (buffer.length!=1){
                    //I add to the length count and write the line, then add a new line
                    length += buffer.length;
                    lines++;
                    bufferedWriter.write(text);
                    bufferedWriter.newLine();
                }
            } while (buffer.length!=1);
            //Always close files.
            bufferedWriter.close();  
            fileWriter.close();  
            //Tell the user how long the text was
            System.out.println("Wrote " + length + 
                " bytes. "+lines+" lines long.");
        }
        //Always catch the exception
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
        }
        }
    }
}