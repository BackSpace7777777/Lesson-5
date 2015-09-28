package src.Objects;
public class Die {
    public Die()
    {
        
    }
    public byte roll()
    {
        byte out;
        out=(byte)(Math.random()*6+1);
        return out;
    }
}
