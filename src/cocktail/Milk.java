package cocktail;

public class Milk extends Ingredients{
  
    private int volume;

   
    public Milk( int volume ,String name, int calory, Color color) {
        super(volume, name ,calory, color);
    }
    public Milk(){}

    @Override
    public String getInfo()
    {
        return super.getInfo() + " "+ this.getColor() + " "+ this.getVolume();
    }
}
