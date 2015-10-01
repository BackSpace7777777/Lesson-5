package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
    public static JFrame frame=new JFrame("Lesson 5 - Menu");
    public static JButton mainMenu,students,dice,face;
    public static StudentProg sp;
    public static Dice d;
    public static FaceClass fc;
    public static void main(String[] args) {
        frame.setSize(475,200);
        frame.setDefaultCloseOperation(3);
        frame.setLayout(null);
        frame.setResizable(false);
        face=new JButton();
        face.setText("Face");
        face.setBounds(315,5,150,30);
        face.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu(false);
                fc.visible(true);
            }
        });
        dice=new JButton();
        dice.setText("Dice");
        dice.setBounds(160,5,150,30);
        dice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu(false);
                d.visible(true);
            }
        });
        students=new JButton();
        students.setBounds(5,5,150,30);
        students.setText("Students");
        students.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu(false);
                sp.visible(true);
            }
        });
        frame.add(face);
        frame.add(dice);
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
        d=new Dice();
        fc=new FaceClass();
        frame.setVisible(true);
    }
    public static void menu(boolean tf)
    {
        frame.setSize(475,200);
        students.setVisible(tf);
        dice.setVisible(tf);
        face.setVisible(tf);
        if(tf)
        {
            mainMenu.setVisible(false);
            sp.visible(false);
            d.visible(false);
            fc.visible(false);
        }
        else mainMenu.setVisible(true);
        frame.setTitle("Lesson 5 - Menu");
        frame.setSize(475,200);
    }
}
