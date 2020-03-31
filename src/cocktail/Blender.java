package cocktail;

import java.util.ArrayList;
import java.util.HashSet;

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


    
    public void add(Ingredients ingredients)
    {         
        if (this.volume + ingredients.getVolume() > capacity)
        {
         this.volume+= ingredients.getVolume();
        this.ingredients.add(ingredients);
        }
    }
    public void blend() {
       int totalRed = 0 , totalBlue = 0 , totalGreen = 0;
        for (Ingredients ing : ingredients) {
            totalRed +=  ing.getColor().getR();
            totalGreen += ing.getColor().getG();
            totalBlue += ing.getColor().getB();
            calory += ing.getCalories();
        }   
        calory /=ingredients.size();
        color.setR(totalRed /ingredients.size() );
        color.setG(totalGreen / ingredients.size());
        color.setB(totalBlue / ingredients.size());
    }
    

    public void pour(Cups cup)
    {
if (this.volume == 0)
            System.out.println("The blinder is empty");
     else if (this.volume < cup.getCapacity())
     {
         cup.setCalories(calory);
         this.volume = 0;
         this.calory = 0;
       ingredients.clear();
     }   
     else 
     {
        cup.setCalories(calory * cup.getCapacity() / this.volume);
         this.calory -= (this.calory - cup.getCalories());
         this.volume -= cup.getCapacity();

     }
    }

    public String contains ()
    {
        HashSet<String> component = new HashSet<>();
        for (Ingredients ing : ingredients)
        {
            component.add(ing.getName());
        }
        String str = "The ingredients used in the cocktail :";
        for (int i= 0 ; i< component.size() ;i++)
        str+= " "+component;
        
        return str;
    }

    @Override
    public String getInfo()
    {
 return "The capacity of the blender(gm):"+this.capacity + "\nThe volume of the blender contents(gm) :" +this.volume +"\nThe calories in the cocktail is : "+this.calory;
    }
}
