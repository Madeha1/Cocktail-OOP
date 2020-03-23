package cocktail;

public class Blender implements GetInfo {
     
    private int capacity;
    private int volume;
    Ingredients ingredient[] = new Ingredients[5]; //3 fruits + milk + suger = 5;
    Cups cup ;
    Color color ;
    int calory;

   public Blender() {
        this.capacity = 2000;//2L always
        this.volume = 0;
        this.color = new Color(0 , 0 , 0);
        this.calory = 0;
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
    //?! what should I return ?!
    public Ingredients getIngredient() {
            return ingredient[0];

    }

    public Color getColor() {
        return color;
    }

    public int getCalory() {
        return calory;
    }

    //boolean because I want to Check if I added the ingrediants without errors

    
    public boolean add(Ingredients ingredient[])
    {
        for (Ingredients ing : ingredient)
        {
            volume += ing.getVolume();
        }
        if (volume > capacity) {
            System.out.println("The total Volume for the ingredient is larger than the capacity of the blinder (2L) re-enter the ingredients");
            return false;
        }
        else
            return true;
    }
public void blend() {
        for (Ingredients ing : ingredient) {
            this.color.setR(color.getR() + ing.getColor().getR());
            this.color.setG(color.getG() + ing.getColor().getG());
            this.color.setB(color.getB() + ing.getColor().getB());
            calory += ing.getCalory();
        }   
        calory /=5;
        color.setR(color.getR() / 5);
        color.setG(color.getG() / 5);
        color.setB(color.getB() / 5);
    
    }
    public void pour(Cups cup)
    {
if (this.volume == 0)
            System.out.println("The blinder is empty");
     else if (this.volume < cup.getCapacity())
     {
         cup.setCalory(calory);
         this.volume = 0;
         this.calory = 0;
     }   
     else 
     {
         this.volume -= cup.getCapacity();
         cup.setCalory(calory / cup.getCapacity());
         this.calory -= (calory / cup.getCapacity());

     }
    }
//calory , what contains , color.

    @Override
    public String getInfo()
    {
        return this.capacity + " " + this.volume + " "+ this.ingredient;
    }
}
