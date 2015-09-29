package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import src.Objects.Student;

public class StudentProg extends Main{
    private JButton set,setName;
    private JComboBox selection;
    private JTextField marks[]=new JTextField[3];
    private JTextField average,name;
    private Student students[]=new Student[3];
    public StudentProg()
    {
        selection=new JComboBox();
        for(int i=0;i<3;i++)
            students[i]=new Student();
        students[0].setName("Student 1");
        students[1].setName("Student 2");
        students[2].setName("Student 3");
        selection.setBounds(160,5,150,30);
        selection.setVisible(false);
        setName=new JButton();
        setName.setText("Set Name");
        setName.setBounds(315,110,150,30);
        setName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                students[selection.getSelectedIndex()].setName(name.getText());
                name.setText(students[selection.getSelectedIndex()].getName());
                selection.removeAllItems();;
                for(int i=0;i<3;i++)
                {
                    selection.addItem(students[i].getName());
                }
            }
        });
        setName.setVisible(false);
        name=new JTextField();
        name.setBounds(160,110,150,30);
        name.setVisible(false);
        set=new JButton();
        set.setText("Set");
        set.setBounds(315,5,150,30);
        set.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try
                {
                    students[selection.getSelectedIndex()].setMarks(Double.parseDouble(marks[0].getText()), Double.parseDouble(marks[1].getText()), Double.parseDouble(marks[2].getText()));
                    average.setText("" + students[selection.getSelectedIndex()].getPercent());
                    for(int i=0;i<3;i++)
                    {
                        marks[i].setText("" + students[selection.getSelectedIndex()].getPercent(i));
                    }
                }
                catch(Exception ex){}
            }
        });
        set.setVisible(false);
        average=new JTextField();
        average.setEditable(false);
        average.setVisible(false);
        for(int i=0;i<3;i++)
        {
            marks[i]=new JTextField();
            marks[i].setVisible(false);
            marks[i].setBounds(5+(5*i)+(150*i),40,150,30);
            selection.addItem(students[i].getName());
            frame.add(marks[i]);
        }
        average.setBounds(marks[1].getX(),marks[1].getY()+35,150,30);
        average.setText("" + students[selection.getSelectedIndex()].getPercent());
        for(int i=0;i<3;i++)
        {
            marks[i].setText("" + students[selection.getSelectedIndex()].getPercent(i));
        }
        selection.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try
                {
                    average.setText("" + students[selection.getSelectedIndex()].getPercent());
                    for(int i=0;i<3;i++)
                    {
                        marks[i].setText("" + students[selection.getSelectedIndex()].getPercent(i));
                    }
                    name.setText(students[selection.getSelectedIndex()].getName());
                }
                catch(Exception ex){}
            }
        });
        name.setText(students[selection.getSelectedIndex()].getName());
        frame.add(average);
        frame.add(set);
        frame.add(selection);
        frame.add(setName);
        frame.add(name);
        Thread updateThread=new Thread(new Runnable() {
            public void run() {
                while(true)
                {
                    average.setText("" + students[selection.getSelectedIndex()].getPercent());
                    for(int p=0;p<3;p++)
                    for(int i=0;i<3;i++)
                    {
                        marks[i].setText("" + students[p].getPercent(i));
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {}
                }
            }
        });
    }
    public void visible(boolean tf)
    {
        if(tf)frame.setTitle("Lesson 5 - Student");
        selection.setVisible(tf);
        set.setVisible(tf);
        average.setVisible(tf);
        setName.setVisible(tf);
        name.setVisible(tf);
        for(int i=0;i<3;i++)marks[i].setVisible(tf);
    }
}
