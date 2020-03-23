package cocktail;
import java.util.Scanner;

public class Cocktail {

    //to know what colorArray should I use
    java.awt.Color str = new java.awt.Color (255, 253, 26);
   
    public static void main(String[] args) {
        
       
        
        //stuff that I will use
         final  int volumeArray [] = {152,182,118,250,10}; //str, apple , banana,milk ,  suger
         final int calArray [] = {49 , 95 , 100 , 110 , 50};
         final String fruitNames[] ={"Strawberry" , "Apple" , "Banana"}; 
         final int[][] colorArray = { {255, 54, 50},{171, 255, 127} , {255, 253, 26}} ;
         //intro
        System.out.println("cocktail Project \nMade By : Lana qawasmy & Madeha Tahboub\n");
        System.out.println("Welcome to cocktail maker");
        System.out.println("Just to know the capacaty of the blender is 2L");
        Scanner input = new Scanner(System.in);
        //declare obj that I will use
        Blender blender = new Blender();
        Ingredients ingredient[] = new Ingredients[5];

        int number;
        //if add method fail I will repeat adding ingrediants
        do{
           int emptyVolume = 2000;
            int vol = 0;
            int i;
            //We decided to make a loop so the code can be more general and if we decided to add more fruits it will be better
            //Add fruits
            for(i = 0 ; i < fruitNames.length ; i++)
            {
                System.out.println("Do you want to add "+fruitNames[i]+" ? (Y/N)");
            if (input.next().charAt(0) == 'Y') {
                System.out.println("How maney "+fruitNames[i]+"s you want to add");
                number = input.nextInt();
                vol = number * volumeArray[i];
                ingredient[i] = new Fruits(vol, fruitNames[i], number * calArray[i], new Color(colorArray[i][0],colorArray[i][1], colorArray[i][3]));
            } else
                ingredient[i] = new Fruits(0, fruitNames[i], 0, new Color(0, 0, 0)); 
            
            emptyVolume -= vol;
            System.out.println("You have " + emptyVolume + "gram left in the blinder");
                
            }
            
            //Adding Milk
            System.out.println("How maney cups of milk do you want to add?");
            number = input.nextInt();
            vol = number *volumeArray[i];
            ingredient[i] = new Milk(vol, "milk", number * calArray[i], new Color(0, 0, 0));

            i++;
            emptyVolume -= vol;
            System.out.println("You have " + emptyVolume + " gram left in the blinder");

            //Adding Suger
            System.out.println("Do you want to add Sugar ? (Y/N)");
        if (input.next().charAt(0) == 'Y') 
        {
            System.out.println("How maney spoons do you want to add ?");
            number = input.nextInt();
            vol = number * volumeArray[i];
            ingredient[i] = new Sugar(vol, "Sugar", number * calArray[i], new Color(0, 0, 0));
        } 
        else
            ingredient[i] = new Sugar(0, "Sugar", 0, new Color(0, 0, 0));

        emptyVolume -= vol;
        System.out.println("You have " + emptyVolume + " gram left in the blinder");

    }while( !blender.add(ingredient));
     System.out.println("The ingredient was added successfully");
        
     blender.blend();
     System.out.println("The ingredient was blend successfully");
     
     blender.pour(new Cups(250));
    }
    
}
