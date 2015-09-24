package src.SObj;
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
        percentage[0]=a;
        percentage[1]=b;
        percentage[2]=c;
    }
    public double getPercent(int i)
    {
        if(i>=0 && i<3)
        return percentage[i];
        else return -1;
    }
    public double getPercent()
    {
        return ((percentage[0]+percentage[1]+percentage[2])/3);
    }
}
