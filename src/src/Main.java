package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
    public static JFrame frame=new JFrame("Lesson 5 - Menu");
    public static JButton students;
    public static StudentProg sp;
    public static void main(String[] args) {
        frame.setSize(475,200);
        frame.setDefaultCloseOperation(3);
        frame.setLayout(null);
        frame.setResizable(false);
        students=new JButton();
        students.setBounds(5,5,150,30);
        students.setText("Students");
        students.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        frame.add(students);
        sp=new StudentProg();
        frame.setVisible(true);
    }
    
}
