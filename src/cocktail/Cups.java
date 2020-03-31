package cocktail;

public class Cups implements GetInfo {
    
   private  int capacity;
    private int calories;

    public Cups(int capacity) {
        this.capacity = capacity;
      this.calories = 0;
    }

    public Cups() {
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calory) {
        this.calories = calory;
    }


    @Override
    public String getInfo()
    {
     return "the capacity of the cup is(gm): " + this.capacity + "the total calories of the contenant of the blender is : " + this.calories;
    }
}
