package cocktail;

import java.util.ArrayList;


public class Blender implements GetInfo {
     
    private final int capacity;
    private int volume;
    ArrayList<Ingredients> ingredients;
    Cups cup ;
    Color color ;
    int calory;

    
    public Blender() {
        this.capacity = 2000;//2L always
        this.volume = 0;
        this.color = new Color(0 , 0 , 0);
        this.calory = 0;
        ingredients = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }
    //No setters for capacity because it's fixed
    
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


    public ArrayList<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public Cups getCup() {
        return cup;
    }

    public void setCup(Cups cup) {
        this.cup = cup;
    }
    public int getCalory() {
        return calory;
    }
    public void setCalory(int calory) {
        this.calory = calory;
    }

    public void add(Ingredients ingredient)throws BlenderOverFlowException { 

    if(this.volume + ingredient.getVolume() > capacity){
        throw new BlenderOverFlowException();
               } 

        else //(this.volume + ingredient.getVolume() <= capacity)
        {
         this.volume+= ingredient.getVolume();
         this.ingredients.add(ingredient);
        }
         
        
        
        
    }
    public void blend() throws EmptyBlenderException {
        if (this.volume == 0) {
            throw new EmptyBlenderException();
        } else {
            int totalRed = 0, totalBlue = 0, totalGreen = 0;
            for (Ingredients ing : ingredients) {
                totalRed += ing.getVolume() * ing.getColor().getR();
                totalGreen += ing.getVolume() * ing.getColor().getG();
                totalBlue += ing.getVolume() * ing.getColor().getB();
                calory += ing.getVolume() * ing.getCalories();
            }

            color.setR(totalRed / volume);
            color.setG(totalGreen / volume);
            color.setB(totalBlue / volume);
        }
    }
   public void pour(Cups cup) throws EmptyBlenderException {
        if (this.volume == 0) {
            throw new EmptyBlenderException();
        } else if (this.volume < cup.getCapacity()) {
            cup.setCalories(calory);
            this.volume = 0;
            this.calory = 0;
            ingredients.clear();
        } else {
            cup.setCalories(calory * cup.getCapacity() / this.volume);
            this.calory -= (this.calory - cup.getCalories());
            this.volume -= cup.getCapacity();
        }
    }

    public String containsInfo() {
        String component = "The ingredients used in the cocktail :\n";
        for (Ingredients ing : ingredients) {
            component += (" " + ing.getInfo() + "\n");
        }

        return component;
    }
            
   @Override
    public String getInfo() {

        String info = "The capacity of the blender(gm): " + this.capacity + "\nThe volume of the blender contents(gm) :" + this.volume;
        info += "\nThe calories in the cocktail is : " + this.calory + " " + color.getInfo();
        return info;
    }
}
