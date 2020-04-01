package cocktail;

public class Sugar extends Ingredients {

   private final int volume;
    private final Color color;
    
    public Sugar(int calories){
        super("Sugar", calories);
        this.volume = 0;
        this.color = new Color(255,255,255);
    }
    //No setters because they are fixed
     @Override
    public Color getColor()
    {
        return color;
    }
    
     @Override
    public int getVolume ()
    {
        return volume;
    }
    @Override
    public String getInfo()
    {
        return super.getInfo();
    }
    
}
