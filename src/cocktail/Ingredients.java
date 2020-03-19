/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cocktail;

/**
 *
 * @author lana-pc
 */
public class Ingredients  implements GetInfo {
    private String name;
    private int calory;
     Color color;

     
      public Ingredients (){}
      
    public Ingredients(String name, int calory, Color color) {
        this.name = name;
        this.calory = calory;
        this.color = color;
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

    @Override
    public String getInfo()
    {
        return this.getName() + " " + this.getCalory() ;
    }
}
