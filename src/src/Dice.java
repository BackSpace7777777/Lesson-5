package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import src.Objects.Die;

public class Dice extends Main{
    private JButton roll;
    private JTextArea ta;
    private JTextField monies;
    private Die d1,d2;
    private Thread rollThread;
    private int money,rollsI;
    private byte[] rolls;
    private int[] moneyL;
    public Dice()
    {
        rolls=new byte[1];
        moneyL=new int[1];
        d1=new Die();
        d2=new Die();
        monies=new JTextField();
        monies.setBounds(315,5,150,30);
        monies.setVisible(false);
        ta=new JTextArea();
        ta.setBounds(5,40,460,125);
        ta.setEditable(false);
        ta.setVisible(false);
        roll=new JButton();
        roll.setText("Roll");
        roll.setBounds(160,5,150,30);
        roll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(Integer.parseInt(monies.getText())>0)
                    {
                        money=Integer.parseInt(monies.getText());
                        rolls=new byte[1];
                        rollThread=new Thread(new Runnable() {
                            public void run() {
                                rollsI=0;
                                while(true)
                                {
                                    try
                                    {
                                        rolls[rollsI]=(byte)(d1.roll()+d2.roll());
                                    }
                                    catch(ArrayIndexOutOfBoundsException ex){
                                        addArray();
                                        rolls[rollsI]=(byte)(d1.roll()+d2.roll());
                                    }
                                    if(money<1)break;
                                    if(rolls[rollsI]==7)
                                    {
                                        money+=4;
                                    }
                                    else
                                    {
                                        money-=1;
                                    }
                                    try
                                    {
                                        moneyL[rollsI]=money;
                                    }
                                    catch(ArrayIndexOutOfBoundsException ex){
                                        addArrayInt();
                                        moneyL[rollsI]=money;
                                    }
                                    System.out.println("On roll " + rolls.length + " money: " + money);
                                    rollsI++;
                                }
                                String out="It took " + rolls.length + " rolls\n";
                                int heighest=0,whatRoll=0;
                                for(int i=0;i<moneyL.length;i++)
                                {
                                    if(moneyL[i]>heighest)
                                    {
                                        heighest=moneyL[i];
                                        whatRoll=i;
                                    }
                                }
                                out+="You should have stoped at your peak, which was $" + heighest + " at roll " + (whatRoll+1);
                                ta.setText(out);
                                moneyL=new int[1];
                                rolls=new byte[1];
                            }
                        });
                        rollThread.start();
                    }
                    else
                    {
                        monies.setText("0");
                    }
                }
                catch(NumberFormatException ex){monies.setText("0");}
            }
        });
        roll.setVisible(false);
        frame.add(monies);
        frame.add(roll);
        frame.add(ta);
    }
    private void addArrayInt()
    {
        int temp[]=new int[moneyL.length+1];
        for(int i=0;i<moneyL.length;i++)
        {
            temp[i]=moneyL[i];
        }
        moneyL=new int[temp.length];
        for(int i=0;i<temp.length;i++)
        {
            moneyL[i]=temp[i];
        }
    }
    private void addArray()
    {
        byte temp[]=new byte[rolls.length+1];
        for(int i=0;i<rolls.length;i++)
        {
            temp[i]=rolls[i];
        }
        rolls=new byte[temp.length];
        for(int i=0;i<temp.length;i++)
        {
            rolls[i]=temp[i];
        }
    }
    public void visible(boolean tf)
    {
        ta.setVisible(tf);
        monies.setVisible(tf);
        roll.setVisible(tf);
        frame.setTitle("Lesson 5 - Dice");
    }
}
