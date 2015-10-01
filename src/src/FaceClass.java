package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;
import javax.swing.JTextField;
import src.Objects.B;
import src.Objects.Face;

public class FaceClass extends Main{
    private JPanel panel;
    private JTextField x,y,m;
    private int mx,my;
    private boolean md,mdT;
    private B b;
    private Face f;
    public FaceClass()
    {
        x=new JTextField();
        x.setBounds(160,5,30,30);
        x.setText("X");
        x.setVisible(false);
        y=new JTextField();
        y.setBounds(195,5,30,30);
        y.setText("Y");
        y.setVisible(false);
        m=new JTextField();
        m.setBounds(230,5,30,30);
        m.setVisible(false);
        m.setText("1");
        b=new B();
        b.setText("Set");
        b.setPos(5,5,150,30);
        f=new Face();
        f.setLocation(50,50);
        panel=new JPanel()
        {
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.clearRect(0,0,panel.getWidth(),panel.getHeight());
                g.setColor(Color.WHITE);
                g.fillRect(0,0,panel.getWidth(),panel.getHeight());
                f.draw(g);
                b.draw(g, mx, my, md,mdT);
                repaint();
            }
        };
        panel.setBounds(5,40,535,525);
        panel.setVisible(false);
        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                md=true;
                mdT=true;
            }
            public void mouseReleased(MouseEvent e) {
                md=false;
                mdT=false;
            }
        });
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                mx=e.getX();
                my=e.getY();
            }
        });
        frame.add(panel);
        frame.add(x);
        frame.add(y);
        frame.add(m);
    }
    public void button(B b)
    {
        System.out.println(b);
        md=false;
        if(b==this.b)
        {
            try
            {
                f.setLocation(Integer.parseInt(x.getText()),Integer.parseInt(y.getText()));
            }
            catch(Exception ex){x.setText("0");y.setText("0");} 
            try
            {
                f.setMultiplyer(Integer.parseInt(m.getText()));
            }
            catch(Exception ex){m.setText("1");}
        }
        
    }
    public void visible(boolean tf)
    {
        frame.setTitle("Lesson 5 - Face");
        frame.setSize(550,600);
        panel.setVisible(tf);
        x.setVisible(tf);
        y.setVisible(tf);
        m.setVisible(tf);
    }
}
