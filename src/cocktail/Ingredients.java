package cocktail;

import java.io.Serializable;

public abstract  class Ingredients  implements GetInfo  ,Serializable{
   private String name;

    private int calories;

    public Ingredients() {
    }

    public Ingredients(String name, int calories) {
        this.name = name;
        this.calories = calories;  
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return this.calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
    public abstract int getVolume();


    public abstract Color getColor();
    
    @Override
    public String getInfo()
    {
        return getName() + " contains\n" + getCalories() + " calories\n"; 
    }
}
