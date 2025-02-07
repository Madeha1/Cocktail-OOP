package cocktail;

import java.io.Serializable;
import java.util.ArrayList;

public class Blender implements GetInfo , Serializable {

    private final int capacity;
    private int volume;//this is the acutal volume of the blender
    private ArrayList<Ingredients> ingredients;
    private Color color;
    private int calory;
    private int tempVolume;//this volume is to make calculating the color work , it has no relation to the volume of the blender!
    
    public Blender() {
        this.capacity = 2000;//2L always
        this.volume = 0;
        this.color = new Color(0, 0, 0);
        this.calory = 0;
        ingredients = new ArrayList<>();
    }

    public int getTempVolume() {
        return tempVolume;
    }

    public void setTempVolume(int tempVolume) {
        this.tempVolume = tempVolume;
    }
     public Blender (int capacity , int volume ,ArrayList ingredients ,int calory , int r , int g , int b ,int tempVolume)
    {
         this.capacity = capacity;
        this.volume = volume;
        this.color = new Color(r, g, b);
        this.calory = calory;
        this.ingredients = ingredients;
        this.tempVolume = tempVolume;
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

    public int getCalory() {
        return calory;
    }

    public void setCalory(int calory) {
        this.calory = calory;
    }

    public void add(Ingredients ingredient) throws BlenderOverFlowException {

        if (this.volume + ingredient.getVolume() > capacity) {
            throw new BlenderOverFlowException();
        } else //(this.volume + ingredient.getVolume() <= capacity)
        {
            this.volume += ingredient.getVolume();
            this.tempVolume+= ingredient.getVolume();
            this.ingredients.add(ingredient);
        }
        this.calory = 0;  //If a new ingredient where added after blending or pouring I have to start from 0 
    }
    
    public void blend() throws EmptyBlenderException {
        if (this.volume == 0) {
            throw new EmptyBlenderException();
        } else {
            int totalRed = 0, totalBlue = 0, totalGreen = 0 ;
           
            for (Ingredients ing : ingredients) {
                totalRed += ing.getVolume() * ing.getColor().getR();
                totalGreen += ing.getVolume() * ing.getColor().getG();
                totalBlue += ing.getVolume() * ing.getColor().getB();
                this.calory += ing.getCalories();
            }

            this.color.setR(totalRed / this.tempVolume);
            this.color.setG(totalGreen / this.tempVolume);
            this.color.setB(totalBlue / this.tempVolume);
        }
    }

    public void pour(Cups cup) throws EmptyBlenderException, NotBlendedException {
        if (this.volume == 0) //empty
        {
            throw new EmptyBlenderException();
        } else if (calory ==0)//not blended
        {
            throw new NotBlendedException();
        } else if (this.volume < cup.getCapacity()) {
            cup.setCalories(calory);
            cup.setVolume(volume);
            this.volume = 0;
            this.calory = 0;
            cup.setColor(this.color);
            ingredients.clear();
        } else {
            cup.setCalories(calory * cup.getCapacity() / this.volume);
            cup.setVolume(cup.getCapacity());
            this.calory = (this.calory - cup.getCalories());
            this.volume -= cup.getCapacity();
            cup.setColor(this.color);
        }
    }
    public int emptyVolume()
    {
        return this.capacity - this.volume;
    }
    void clear()
    {
        this.ingredients.clear();
        this.calory = 0;
        this.volume = 0;
        this.color.setB(0);
        this.color.setR(0);
        this.color.setG(0);
        this.tempVolume = 0;
    }
    @Override
    public String getInfo() {

        String info = "The capacity of the blender(gm): " + this.capacity + "\nThe volume of the blender contents(gm) :" + this.volume + "\nThe empty space in the blender :"+ (emptyVolume());
        if (calory != 0)
        info += "\nThe calories in the cocktail is : " + this.calory + "\n" + color.getInfo();
        else 
            info += "\nThe bliinder is not blended yet!";
        return info;
    }
}
