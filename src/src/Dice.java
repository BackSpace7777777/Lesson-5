package src;

import javax.swing.JButton;
import javax.swing.JTextArea;
import src.Objects.Die;

public class Dice extends Main{
    private JButton roll;
    private JTextArea ta;
    private Die d1,d2;
    public Dice()
    {
        d1=new Die();
        d2=new Die();
        ta=new JTextArea();
        ta.setBounds(5,40,460,125);
        ta.setEditable(false);
        ta.setVisible(false);
        roll=new JButton();
        roll.setText("Roll");
        roll.setBounds(160,5,150,30);
        roll.setVisible(false);
        frame.add(roll);
        frame.add(ta);
    }
    public void visible(boolean tf)
    {
        ta.setVisible(tf);
        roll.setVisible(tf);
        frame.setTitle("Lesson 5 - Dice");
    }
}
