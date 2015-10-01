package src.Objects;

import java.awt.Color;
import java.awt.Graphics;
import src.FaceClass;
import src.Main;

public class B {
    private String text;
    private int x,y,w,h;
    public B()
    {
        
    }
    public void setText(String t)
    {
        text=t;
    }
    public void setPos(int x,int y,int w,int h)
    {
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
    }
    public void draw(Graphics g,int mx,int my,boolean md,boolean mdT)
    {
        if(mx<(x+w) && mx>x && my<(y+h) && my>y && mdT)
        {
            g.setColor(Color.BLUE);
            g.fillRect(x,y,w,h);
            g.setColor(Color.GRAY);
            g.drawRect(x,y,w,h);
            if(md)
            Main.fc.button(this);
        }
        else if(mx<(x+w) && mx>x && my<(y+h) && my>y)
        {
            g.setColor(Color.CYAN);
            g.fillRect(x,y,w,h);
            g.setColor(Color.DARK_GRAY);
            g.drawRect(x,y,w,h);
        }
        else
        {
            g.setColor(Color.GREEN);
            g.fillRect(x,y,w,h);
            g.setColor(Color.BLACK);
            g.drawRect(x,y,w,h);
        }
        g.setColor(Color.BLACK);
        g.drawString(text,((x+w)/2)-text.length()*2,(y+h)-((h/2)-y/2));
    }
}
