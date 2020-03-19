package cocktail;

public class Milk extends Ingredients{
  
    private int volume;

    public Milk(int volume, String name, int calory, Color color) {
        super(name, calory, color);
        this.volume = volume;
    }
    

   
    public Milk(){}

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String getInfo()
    {
        return super.getInfo() + " "+ this.getColor() + " "+ this.getVolume();
    }
}
