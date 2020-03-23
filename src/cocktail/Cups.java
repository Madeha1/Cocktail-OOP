package cocktail;

public class Cups implements GetInfo {
    
   private  int capacity;
    private int calory;

    public Cups(int capacity) {
        this.capacity = capacity;
      
    }

    public Cups() {
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCalory() {
        return calory;
    }

    public void setCalory(int calory) {
        this.calory = calory;
    }


    @Override
    public String getInfo()
    {
        return "ss";
    }
}
