package src;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class StudentProg extends Main{
    private JButton set;
    private JComboBox selection;
    private int studentMarks[][]=new int[3][3];
    public StudentProg()
    {
        selection=new JComboBox();
        for(int i=0;i<3;i++)
            selection.addItem("Student " + (i+1));
        selection.setBounds(160,5,150,30);
        selection.setVisible(false);
        frame.add(selection);
        
    }
    public void visible(boolean tf)
    {
        if(tf)frame.setTitle("Lesson 5 - Student");
        selection.setVisible(tf);
    }
}
