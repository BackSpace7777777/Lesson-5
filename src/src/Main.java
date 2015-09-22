package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
    public static JFrame frame=new JFrame("Lesson 5 - Menu");
    public static JButton mainMenu,students;
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
                menu(false);
                sp.visible(true);
            }
        });
        frame.add(students);
        mainMenu=new JButton();
        mainMenu.setText("Main Menu");
        mainMenu.setBounds(5,5,150,30);
        mainMenu.setVisible(false);
        mainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu(true);
            }
        });
        frame.add(mainMenu);
        sp=new StudentProg();
        frame.setVisible(true);
    }
    public static void menu(boolean tf)
    {
        frame.setSize(475,200);
        frame.setTitle("Lesson 5 - Menu");
        students.setVisible(tf);
        if(tf)
        {
            mainMenu.setVisible(false);
            sp.visible(false);
        }
        else mainMenu.setVisible(true);
    }
}
