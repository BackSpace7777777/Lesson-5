package src.Objects;

import java.awt.Color;
import java.awt.Graphics;

public class Face {
    private Color face;
    private int x,y,multiplyer;
    public Face()
    {
        face=Color.RED;
        multiplyer=1;
    }
    public void setLocation(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    public void setMultiplyer(int m)
    {
        multiplyer=m;
    }
    public void draw(Graphics g)
    {
        g.setColor(face);
        g.fillOval(x,y,50*multiplyer,50*multiplyer);
        g.setColor(Color.BLACK);
                //x1y1x2y2
    }
    public void moveTo(int x,int y)
    {
        
    }
    public void setColor(Color c)
    {
        
    }
}
