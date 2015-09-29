package src.Objects;
public class Student {
    private double percentage[];
    private String name;
    private int marks[]=new int[3];
    public Student()
    {
        percentage=new double[3];
        for(double i:percentage)
        {
            percentage[(int)i]=0;
        }
        name="Not set";
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public int getNumberOfMarks()
    {
        return percentage.length;
    }
    public void setMarks(double a,double b,double c)
    {
        if(a>100)percentage[0]=100;
        else if(a<0)percentage[0]=0;
        else percentage[0]=a;
        if(b>100)percentage[1]=100;
        else if(b<0)percentage[1]=0;
        else percentage[1]=b;
        if(c>100)percentage[2]=100;
        else if(c<0)percentage[2]=0;
        else percentage[2]=c;
    }
    public double getPercent(int i)
    {
        if(i>=0 && i<3)
        return percentage[i];
        else return -1;
    }
    public double getPercent()
    {
        double out;
        out=Math.round(((percentage[0]+percentage[1]+percentage[2])/3)*100);
        out=out/100;
        return out;
    }
}
