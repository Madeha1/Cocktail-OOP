package cocktail;

public class Ingredients  implements GetInfo {
    private String name;
    private int calory;
     Color color;
 private int volume;
     
      public Ingredients (){}
      
    public Ingredients(int volume ,String name ,  int calory, Color color) {
        this.name = name;
        this.volume = volume;
        this.calory = calory;
        this.color = color;
    }

     public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalory() {
        return calory;
    }

    public void setCalory(int calory) {
        this.calory = calory;
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
        return this.getName() + " " + this.getCalory() ;
    }
}
