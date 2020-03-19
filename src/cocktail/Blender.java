package cocktail;

public class Blender implements GetInfo {
     
    private int capacity;
    private int volume;
    Ingredients ingredient;
    Cups cup ;
    Color color ;

    public Blender(int capacity, int volume, Ingredients ingredient, Cups cup, Color color) {
        this.capacity = capacity;
        this.volume = volume;
        this.ingredient = ingredient;
        this.cup = cup;
        this.color = color;
    }

    
    public Blender(int capacity, int volume, Ingredients ingredient) {
        this.capacity = capacity;
        this.volume = volume;
        this.ingredient = ingredient;
    }

    public Blender() {
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Ingredients getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredients ingredient) {
        this.ingredient = ingredient;
    }

    public void add(Ingredients ingredient){}
    public void blend()
    {

    }
    public void pour(Cups cup)
    {

    }
//calory , what contains , color.

    @Override
    public String getInfo()
    {
        return this.capacity + " " + this.volume + " "+ this.ingredient.getInfo();
    }
}
