package src.SObj;
public class Student {
    private double percentage[];
    private String name;
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
    public double getPercent(int i)
    {
        if(i>=0 && i<3)
        return percentage[i];
        else return -1;
    }
}
