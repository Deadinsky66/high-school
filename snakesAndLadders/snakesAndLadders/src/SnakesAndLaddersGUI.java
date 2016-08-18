/*SnakesAndLaddersGUI
* Snakes and Ladders; but with visuals!
* Thomas Dedinsky
* 15/05/2016
*/
//I import my necessary tools
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;
//I implement action listener; I'll explain at the bottom how the system works
public class SnakesAndLaddersGUI extends javax.swing.JFrame implements ActionListener {
    //I define timer start/stop variables, round variable, win variable, player variables
    long tStart;long tEnd;int round=0;char win='N';int players=4;
    Timer timer;int count=200;int focus=0;int dueler=0;
    //I define roll variables for the duels, as well as a duel-check variable
    int iroll;int jroll;int duel=0;int move=0;int jump=0;int loop=0;
    //I define co-ordinate variables, as well an array of everyone's last position
    int x[]= {18,58,18,58}; int y[]= {734,734,774,774};
    int oldx[] = {18,58,18,58}; int oldy[] = {734,734,774,774};
    //I define my arrays which act as the snakes and ladders' start and end points
    int oldPosition[] = {1,4,9,16,21,28,36,47,49,51,56,64,71,80,87,93,95,98};
    int newPosition[] = {38,14,31,6,42,84,44,26,11,67,53,60,91,100,24,73,75,78};
    //I define the position array (space on the board) and a roll array
    int[] position = {1,1,1,1};int[] roll = new int[4];
    //These are all of the co-ordinates on the board that the red piece can safely be on a space
    int redx[] = {14,96,177,258,337,418,499,577,652,730};
    int redy[] = {734,655,575,494,416,337,259,177,96,11};
    String name[] = {"Adam","Justin","Thomas","Stefanie"};
    public SnakesAndLaddersGUI() {
        //I make the background a chutes and ladders board
        setContentPane(new JLabel(new ImageIcon("resources/snakes.png")));
        //All of the gui shit from the design slate
        initComponents();
        //I start a timer that calls upon action listener every 50 milliseconds
        timer = new Timer(50, this);
        timer.start();
        jTextArea1.setLineWrap(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Snakes And Ladders");
        setAutoRequestFocus(false);
        setMaximumSize(new java.awt.Dimension(939, 839));
        setMinimumSize(new java.awt.Dimension(938, 838));
        setPreferredSize(new java.awt.Dimension(938, 838));
        setResizable(false);

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(816, 836));

        jLabel1.setIcon(new javax.swing.ImageIcon("H:\\ICS4U\\snakesAndLadders\\snakesAndLadders\\resources\\red.png")); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon("H:\\ICS4U\\snakesAndLadders\\snakesAndLadders\\resources\\blue.png")); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon("H:\\ICS4U\\snakesAndLadders\\snakesAndLadders\\resources\\green.png")); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon("H:\\ICS4U\\snakesAndLadders\\snakesAndLadders\\resources\\purple.png")); // NOI18N

        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addContainerGap(724, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(734, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(44, 44, 44))
        );

        jLabel6.setIcon(new javax.swing.ImageIcon("H:\\ICS4U\\snakesAndLadders\\snakesAndLadders\\resources\\two.png")); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon("H:\\ICS4U\\snakesAndLadders\\snakesAndLadders\\resources\\four.png")); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon("H:\\ICS4U\\snakesAndLadders\\snakesAndLadders\\resources\\five.png")); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon("H:\\ICS4U\\snakesAndLadders\\snakesAndLadders\\resources\\six.png")); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon("H:\\ICS4U\\snakesAndLadders\\snakesAndLadders\\resources\\three.png")); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon("H:\\ICS4U\\snakesAndLadders\\snakesAndLadders\\resources\\one.png")); // NOI18N

        jTextField3.setText("Hello!");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Welcome to\nSnakes and\nLadders!\nHave fun!");
        jScrollPane1.setViewportView(jTextArea1);

        jButton4.setText("2");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("3");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("4");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("0");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton1.setText("GO!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("1-100");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.setText("x-value");

        jTextField2.setText("y-value");

        jButton2.setText("Enter x,y");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton8.setText("Reset");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("AutoLoop");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel11.setText("© Thomas Dedinsky");

        jButton10.setText("►►");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("►");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("❚►");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("❚❚");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("SANIC");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton13))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jButton1))
                                    .addComponent(jButton9)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jButton8))
                                    .addComponent(jButton2)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel7)
                                .addComponent(jLabel10)))
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton11)
                            .addComponent(jButton10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton12)
                            .addComponent(jButton13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //This button runs the game
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //I set the count variable 15 cycles below the main game, so the round screen can show
        count = -15;
        //I start the game
        game();
        //I disable any hazardous buttons
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
        jButton7.setEnabled(false);
        jButton8.setEnabled(false);
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed
    //This button tests co-ordinates
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //First we define float variables.
        float num1, num2;
        //We have to parse the text to a type float.
        num1 = Float.parseFloat(jTextField1.getText());
        num2 = Float.parseFloat(jTextField2.getText());
        jLabel1.setLocation((int)num1, (int)num2);
    }//GEN-LAST:event_jButton2ActionPerformed
    //This button loops the red piece from 1-100 every time I press it.
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int xtest=10; int ytest=10;
        for (int h=0;h<4;h++){
            position[h]++;
            for (int i=0;i<10;i++){
                if ((position[h]-1)%10==i){
                    if (((position[h]-1)/10)%2==0){xtest = redx[i];}
                    else {xtest = redx[9-i];}
                }
            }
            for (int i=0;i<10;i++){if ((position[h]-1)/10==i){ytest = redy[i];}}
            switch (h){
                case 0:jLabel1.setLocation(xtest,ytest);break;
                case 1:jLabel2.setLocation(xtest+40,ytest);break;
                case 2:jLabel3.setLocation(xtest,ytest+40);break;
                case 3:jLabel4.setLocation(xtest+40,ytest+40);break;
            }
        }
       
    }//GEN-LAST:event_jButton3ActionPerformed
    //This button sets the players to 2 and removes pieces 3 and 4
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        players = 2;
        x[2]=1000;x[3]=1000;y[2]=1000;y[3]=1000;
    }//GEN-LAST:event_jButton4ActionPerformed
    //This button sets the players to 3 and removes pieces 4
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        players = 3;
        x[3]=1000;y[3]=1000;
    }//GEN-LAST:event_jButton5ActionPerformed
    //This button sets the players to 4
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        players = 4;
    }//GEN-LAST:event_jButton6ActionPerformed
    //This button exits the game
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton7ActionPerformed
    //This button calls upon the reset function
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        reset();
    }//GEN-LAST:event_jButton8ActionPerformed
    //This button is an on/off switch for the looping feature
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (loop==0){loop=1;}
        else if (loop==1){loop=0;}
    }//GEN-LAST:event_jButton9ActionPerformed
    //This button activates fast forward
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        timer.stop();
        timer = new Timer(15, this);
        timer.start();
    }//GEN-LAST:event_jButton10ActionPerformed
    //This button plays the game at the normal pace
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        timer.stop();
        timer = new Timer(50, this);
        timer.start();
    }//GEN-LAST:event_jButton11ActionPerformed
    //This button activates slow motion
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        timer.stop();
        timer = new Timer(160, this);
        timer.start();
    }//GEN-LAST:event_jButton12ActionPerformed
    //This button activates pause
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        timer.stop();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        timer.stop();
        timer = new Timer(1, this);
        timer.start();
    }//GEN-LAST:event_jButton14ActionPerformed
    //Main method; it starts the gui
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SnakesAndLaddersGUI().setVisible(true);
            }
        });
    }
    //I set all of the dice locations off-screen, and depending on the inputed roll, I display a die
    public void die(int roll) {
        jLabel5.setLocation(1000, 1000);
        jLabel6.setLocation(1000, 1000);
        jLabel7.setLocation(1000, 1000);
        jLabel8.setLocation(1000, 1000);
        jLabel9.setLocation(1000, 1000);
        jLabel10.setLocation(1000, 1000);
        if (roll==1){jLabel5.setLocation(819, 50);}
        if (roll==2){jLabel6.setLocation(819, 50);}
        if (roll==3){jLabel7.setLocation(819, 50);}
        if (roll==4){jLabel8.setLocation(819, 50);}
        if (roll==5){jLabel9.setLocation(819, 50);}
        if (roll==6){jLabel10.setLocation(819, 50);}
    }
    //This controls how the pieces are displayed on the board; I take in the piece number and which 20th of the slide to display
    public void display(int j, int k) {
        //I calculate the new x and y co-ordinates of the player
        //Now my arrays come in handy :D
        if (k==0){
            for (int i=0;i<10;i++){
                if ((position[j]-1)%10==i){
                    if (((position[j]-1)/10)%2==0){x[j]=redx[i];}
                    else {x[j]=redx[9-i];}
                }
            }
            for (int i=0;i<10;i++){if ((position[j]-1)/10==i){y[j]=redy[i];}}
            //Depending on what piece I'm moving
            if (j==1||j==3){x[j]+=40;}
            if (j==2||j==3){y[j]+=40;}
        }
        /*For each of the cases, I have a loop that runs 20 times; I first define my timer-start as my current time.
          Then I set the position of the piece to a spot in-between its old position and its new position.
          It goes 1/20th of the way every loop. Finally I call upon this every 40 milliseconds until its over.
        */
        if (k==20){oldx[j]=x[j];oldy[j]=y[j];win();}
        switch (j){
            case 0:jLabel1.setLocation((int)(oldx[j]+(((double)(x[j]-oldx[j])/20*k))), (int)(oldy[j]+((double)(y[j]-oldy[j])/20*k)));break;
            case 1:jLabel2.setLocation((int)(oldx[j]+(((double)(x[j]-oldx[j])/20*k))), (int)(oldy[j]+((double)(y[j]-oldy[j])/20*k)));break;
            case 2:jLabel3.setLocation((int)(oldx[j]+(((double)(x[j]-oldx[j])/20*k))), (int)(oldy[j]+((double)(y[j]-oldy[j])/20*k)));break;
            case 3:jLabel4.setLocation((int)(oldx[j]+(((double)(x[j]-oldx[j])/20*k))), (int)(oldy[j]+((double)(y[j]-oldy[j])/20*k)));break;
        }
    }
    //This starts a new round, incrementing the round count and calculating dice rolls
    public void newRound(){
        if (count==-15){
            //I increment the round counter
            round++;
            jTextField3.setText("\nRound "+round+". ");
            //I calculate the people's dice roll
            for (int i=0;i<players;i++){roll[i] = (int)Math.ceil(Math.random()*6);}
        }
    } 
    //This checks to see if anyone is at position 100, and thus won
    public void win(){
        for (int i=0;i<players;i++){
            if (position[i]==100){
                if (players==4){jTextArea1.setText(name[i]+" won,\ncongrats!\n"+name[0]+" - "+position[0]+"\n"+name[1]+" - "+position[1]+"\n"+name[2]+" - "+position[2]+"\n"+name[3]+" - "+position[3]);}
                if (players==3){jTextArea1.setText(name[i]+" won,\ncongrats!\n"+name[0]+" - "+position[0]+"\n"+name[1]+" - "+position[1]+"\n"+name[2]+" - "+position[2]);}
                if (players==2){jTextArea1.setText(name[i]+" won,\ncongrats!\n"+name[0]+" - "+position[0]+"\n"+name[1]+" - "+position[1]);}
                win = 'Y';loop = 0;
            }
        }
    }
    //This function resets the game
    public void reset(){
        //I set the co-ordinates of the spaces to position 1 and their tile number on the board
        x[0]=x[2]=18;x[1]=x[3]=58; y[0]=y[1]=734;y[2]=y[3]=774;
        oldx[0]=oldx[2]=18;oldx[1]=oldx[3]=58; oldy[0]=oldy[1]=734;oldy[2]=oldy[3]=774;
        position[0]=position[1]=position[2]=position[3]=1;
        //I enable a bunch of buttons
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
        jButton7.setEnabled(true);
        jTextField1.setEnabled(true);
        jTextField2.setEnabled(true);
        //I reset a bunch of variables
        round=0;focus=0;duel=0;jump=0;win='N';players=4;
    }
    //This is the game; I activate different steps depending on how far into the round we are
    public void game(){
        //Before the round I activate the newRound() method
        if (count<0){newRound();}
        //Next I call upon position();
        if (count>-1&&count<21){position();}
        //Now I check to see if the piece is on a snake or ladder
        if (count>20&&count<42){
            for (int j=0;j<oldPosition.length&&j<newPosition.length;j++){
                if(position[focus] == oldPosition[j]){
                    position[focus] = newPosition[j];
                    //I see whether or not it was a snake or a ladder and set the appropriate text
                    if (oldPosition[j]>newPosition[j]){jTextArea1.setText("A snake bit\n"+(name[focus])+" and\nthey tripped and\nfell down the\nboard. Now \nthey're at space\n"+position[focus]+".");}
                    else {jTextArea1.setText(name[focus]+" found a\nladder. Climb it \nwith pride!  Now\nthey're at space\n"+position[focus]+".");}
                    //I indicate that the piece did jump
                    jump = 1;
                }
            }
            //If the piece didn't jump then I skip to the next step
            if (jump==0){count=41;}
            display(focus, count-21);
        }
        //I call upon the duel() method
        if (count>41&&count<103){duel();}
        //At the end of a player's turn...
        if (count==111&&win!='Y'){
            //If there are more players I reset the variables for the turn
            if (focus+1<players){focus++;count=-1;duel=0;jump=0;}
            //If all players have gone I display a recap screen and reset some variables
            else {
                if (players==4){jTextArea1.setText("Recap!\n"+name[0]+" - "+position[0]+"\n"+name[1]+" - "+position[1]+"\n"+name[2]+" - "+position[2]+"\n"+name[3]+" - "+position[3]);}
                if (players==3){jTextArea1.setText("Recap!\n"+name[0]+" - "+position[0]+"\n"+name[1]+" - "+position[1]+"\n"+name[2]+" - "+position[2]);}
                if (players==2){jTextArea1.setText("Recap!\n"+name[0]+" - "+position[0]+"\n"+name[1]+" - "+position[1]);}
                focus=0;duel=0;jump=0;
                //Activates if auto-loop isn't activated
                if (loop==0){
                    jButton1.setEnabled(true);
                    jButton8.setEnabled(true);
                }
            }
        }
        //I properly set the pieces in-case they are slightly off of their space
        if (count>111&&win!='Y'){
            jLabel1.setLocation(x[0],y[0]);
            jLabel2.setLocation(x[1],y[1]);
            jLabel3.setLocation(x[2],y[2]);
            jLabel4.setLocation(x[3],y[3]);
        }
        //If auto-loop is activated I move to the next round
        if (count==150&&loop==1){count=-16;}
        //If someone did win I call upon reset()
        if (count>161&&win=='Y'){reset();}
        //I make sure that there isn't an integer overload
        if (count>999){count=199;}
        count++;
    }
    //This is the dueling method
    public void duel(){
        //This is setting up a duel; if a player lands on the same space as another player it commences
        if (count>41&&count<61){
            for (int j=focus-1;j!=focus;j--){
                //To explain this weird set-up, if there are multiple people on that square I want it to duel the person who has been there the least amount of time
                if (j==-1){j=players-1;}
                if (position[focus]==position[j]&&duel==0){
                    //I state that the duel has started and roll the opponents dice. Whoever gets higher moves up, the loser moves down
                    jTextArea1.setText("They landed on \nthe same space\nas "+name[j]+".\nDUEL! LET'S\nFITE!!!");
                    duel = -1;dueler = j;
                }
                if (j==0){j=players;}
            }
            if (duel==0){count+=8;}
        }
        //This activates when the duel commences
        if (count==60&&duel==-1){
            //I set this flag to make sure the person cannot have multiple duels in one turn
            duel = 1;
            //I calculate the rolls of both players
            iroll = (int)Math.ceil(Math.random()*6);
            jroll = (int)Math.ceil(Math.random()*6);
            //If the first person won I declare that, make sure there aren't moving conflicts, and then move the people appropriately
            if (iroll>jroll){
                jTextArea1.setText(name[focus]+" got a "+iroll+".\n"+name[dueler]+" got a "+jroll+".\n"+name[focus]+" won\nThey get to go\nup "+iroll+",\nwhereas "+name[dueler]+"\ngoes down "+jroll+".");
                if (position[focus]+iroll>100){
                    jTextArea1.setText(name[focus]+" got a "+iroll+".\n"+name[dueler]+" got a "+jroll+".\n"+name[focus]+" won!\nUnfortunately,\nthey can't move,\nwhereas "+name[dueler]+"\ngoes down "+jroll+".");
                    iroll = 0;
                }
                if (position[dueler]-jroll<1){
                    jTextArea1.setText(name[focus]+" got a "+iroll+".\n"+name[dueler]+" got a "+jroll+".\n"+name[focus]+" won!\nThey get to go\nup "+iroll+", but\n"+name[dueler]+" can't go\ndown.");
                    jroll = 0;
                }
                position[focus]+=iroll;position[dueler]-=jroll;
            }
            //If the second person won I declare that, make sure there aren't moving conflicts, and then move the people appropriately
            else if (iroll<jroll){
                jTextArea1.setText(name[focus]+" got a "+iroll+".\n"+name[dueler]+" got a "+jroll+".\n"+name[dueler]+" won!\nThey get to go\nup "+jroll+",\nwhereas "+name[focus]+"\ngoes down "+iroll+".");
                if (position[focus]-iroll<1){
                    jTextArea1.setText(name[focus]+" got a "+iroll+".\n"+name[dueler]+" got a "+jroll+".\n"+name[dueler]+" won!\nUnfortunately,\nthey can't move,\nwhereas "+name[focus]+"\ngoes down "+iroll+".");
                    iroll = 0;
                }
                if (position[dueler]+jroll>100){
                    jTextArea1.setText(name[focus]+" got a "+iroll+".\n"+name[dueler]+" got a "+jroll+".\n"+name[dueler]+" won!\nThey get to go\nup "+jroll+", but\n"+name[focus]+" can't go\ndown.");
                    jroll = 0;
                }
                position[focus]-=iroll;position[dueler]+=jroll;
            }
            //If they tie, nothing happens. I let them know where they are now
            else {jTextArea1.setText(name[focus]+" got a "+iroll+".\n"+name[dueler]+" got a "+jroll+".\nYou guys tied.\nNo one moves.\nGo team!");}
        }
        //If there isn't a duel, I skip the step
        if(count>60&&duel==0){count=102;}
        //If there is a duel I activate the display for the pieces and then tell the people what happened
        if(duel==1&&count>80&&count<103){display(focus,count-81);display(dueler,count-81);}
        if(duel==1&&count==88){jTextArea1.setText("For reference,\n"+name[focus]+" is now\non square "+position[focus]+"\nwhereas\n"+name[dueler]+" is now\non square "+position[dueler]+".");}
    }
    //This calculates the position of each player
    public void position(){  
        //I tell the user what the person rolled, and calculate the new position
        if (count==0){
            die(roll[focus]);
            position[focus]+=roll[focus];
            jTextArea1.setText(name[focus]+" rolled a\n"+roll[focus]+". They are\ngoing to space\n"+position[focus]+".");
        }
        //If the person hasn't over-rolled, I call upon my display method
        if (position[focus]<101){display(focus, count);}
        else {
            jTextArea1.setText(name[focus]+" rolled a\n"+roll[focus]+". They can't\njump,they must\nland on 100.");
            if (count==0){position[focus] -= roll[focus];}
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
    @Override
    //I have my action performed activate the game so that something will be happening once every 40 milliseconds
    public void actionPerformed(ActionEvent ae) {game();}
}
