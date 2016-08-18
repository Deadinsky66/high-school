/*ConcreteCosting
* Software that will help a concrete company calculate the cost of materials for their jobs
* Thomas Dedinsky
* 21/03/2016
*/
class ConcreteCosting
{
    /*Description - char method that asks the user a yes/no question
     Pre - Passes a character
     Post - Returns a Y/N response
    */
    public static char confirmation ()
    {
        char confirmation = In.getChar();
        //I loop a response if the inputted character isn't valid
        while (confirmation!='Y'&&confirmation!='y'&&confirmation!='N'&&confirmation!='n')
        {
            System.out.println("Please input a Y/N response.");
            confirmation = In.getChar();
        }
        return confirmation;
    }
    
    /*Description - int method that asks the user a yes/no question
     Pre - Passes a integer
     Post - Returns an integer that is equivalent to the area of a section
    */
    public static int sideLength ()
    {
        System.out.print("Feet:\t");
        int feet = In.getInt();
        //I make sure they enter a positive number
        while (feet<0) {
            System.out.println("Please enter a positive number.");
            feet = In.getInt();
        }
        System.out.print("Inches:\t");
        int inches = In.getInt();
        //I make sure they enter a positive number
        while (inches<0) {
            System.out.println("Please enter a positive number.");
            inches = In.getInt();
        }
        //If the user entered in 12 or more inches I question them on their conversion abilities
        if (inches>=12)
        {
            System.out.print("\nWhy didn't you convert the extra inches into more feet?");
        }
        int side = inches + (feet*12);
        return side;
    }
    
    /*Description - int method that asks the user a yes/no question
     Pre - Passes a integer
     Post - Returns an integer that is equivalent to the area of a section
    */
    public static double[] areaVolume (int i)
    {
        System.out.println("\nSection "+i);
        //I ask the user for the length of the surface they want to pave
        System.out.println("Length? (ft. and in.)");
        int length = sideLength();
        //I ask the user for the width of the surface they want to pave
        System.out.println("Width? (ft. and in.)");
        int width = sideLength();
        //I calculate the area of the surface
        int imperialArea = length*width;
        //I declare the variable surface and I ask the user what type of surface they are paving
        char surface = '!';
        while (surface!='S'&&surface!='s'&&surface!='D'&&surface!='d') {
            System.out.println("\nIs this a sidewalk (S) or a driveway? (D)?");
            surface = In.getChar();
        }
        //I assign the correct depth based on the surface inputted
        int imperialDepth;
        if (surface=='S'||surface=='s')
        {
            imperialDepth = 4;
        }
        else
        {
            imperialDepth = 6;
        }
        //I calculate the volume and then convert into feet
        int imperialVolume = imperialArea * imperialDepth;
        double feetArea = ((double)imperialArea)/12/12;
        double feetVolume = ((double)imperialVolume)/12/12/12;
        //I show the user the area and volume and then return the values
        System.out.println("Area: "+feetArea+"\nVolume: "+feetVolume);
        return new double[] {feetArea, feetVolume};
    }
    
    public static void main (String args[])
    {
        //First I ask the person how many areas they want to pave
        int section = 0;
        while (section<1)
        {
            System.out.println("How many areas do you want to pour?");
            section = In.getInt();
        }
        double imperialArea=0,imperialVolume=0;
        for (int i=1;i<=section;i++)
        {
            double imperialAreaVolume[] = areaVolume(i);
            imperialArea += imperialAreaVolume[0];
            imperialVolume += imperialAreaVolume[1];
        }
        double volume = imperialVolume*0.3048*0.3048*0.3048;
        //I round the measurements to the nearest quarter and calculate the current cost
        volume = Math.ceil(volume*4)/4;
        double cost = 165*volume;
        //I ask the user if they want reinforcement and charge them accordingly
        char confirmation;
        System.out.println("Would you like fiber mesh reinforcment? (Y/N)");
        confirmation = confirmation();
        if (confirmation=='Y'||confirmation=='y') {cost += volume*15;}
        //I ask the user if they want colour and charge them accordingly
        System.out.println("Do you want your concrete coloured? (Y/N)");
        confirmation = confirmation();
        if (confirmation=='Y'||confirmation=='y') {cost += volume*73;}
        //I ask the user if they want an expansion and charge them accordingly
        System.out.println("Do you want expansion? (Y/N)");
        confirmation = confirmation();
        if (confirmation=='Y'||confirmation=='y') 
        {
            //I ask for the perimeter and charge them accordingly
            System.out.print("What is the perimeter of the area that touches the wall? (ft.)\nFeet:\t");
            double feet = In.getDouble();
            cost += Math.ceil(feet/10)*5;
        }
        //I ask the user if they want stamp rental
        System.out.println("Do you want it stamped? (Y/N)");
        confirmation = confirmation();
        if (confirmation=='Y'||confirmation=='y') {cost += Math.ceil(imperialArea/500)*150;}
        //I ask the user if they want release
        System.out.println("Do you want it released? (Y/N)");
        confirmation = confirmation();
        if (confirmation=='Y'||confirmation=='y') {cost += Math.ceil(imperialArea/300)*90;}
        //I ask the user if they want sealer
        System.out.println("Do you want it sealed? (Y/N)");
        confirmation = confirmation();
        if (confirmation=='Y'||confirmation=='y') {cost += Math.ceil(imperialArea/1500)*160;}
        //I add tax and markup the price
        cost *= 1.13;
        cost *= 1.15;
        System.out.printf("This will cost $%.2f", cost);
        System.out.println(". Have a nice day!");
    }
}