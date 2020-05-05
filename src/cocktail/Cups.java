package cocktail;

import java.io.Serializable;

public class Cups implements GetInfo{
    
 private  int capacity;
 private int calories;
  private int volume;
  
    public Cups(int capacity) {
        this.capacity = capacity;
        this.calories = 0;
        this.volume = 0;
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

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }


    @Override
    public String getInfo()
    {
        return "the capacity of the cup(gm) : " + this.capacity +"\nthe volume of the cup(gm) : "+ this.volume +"\nthe total calories of the contenant of the cup : " + this.calories;
    }
}
