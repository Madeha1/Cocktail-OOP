package cocktail;
import java.util.ArrayList;
import java.util.Scanner;


public class Cocktail {
       public static void main(String[] args) {
           
        //stuff that we will use in loop
         final  int volumeArray [] = {152,182,118,250,10}; //str, apple , banana,milk ,  suger
         final int calArray [] = {49 , 95 , 100 , 110 , 50};
         final String fruitNames[] ={"Strawberry" , "Apple" , "Banana"}; 
         final int[][] colorArray = { {255, 54, 50},{171, 255, 127} , {255, 253, 26}} ;
        
        Scanner input = new Scanner(System.in);
        //declare obj that I will use
        Blender blender = new Blender();

        int number;
        //if add method fail I will repeat adding ingrediants

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
                blender.add(new Fruits(fruitNames[i], number * calArray[i] , vol , new Color(colorArray[i][0],colorArray[i][1], colorArray[i][2])));
            } 
            else 
               vol = 0; 
            emptyVolume -= vol;
            System.out.println("You have " + emptyVolume + " gram left in the blinder");
                
            }
            
            //Adding Milk
            System.out.println("How maney cups of milk do you want to add?");
            number = input.nextInt();
            vol = number *volumeArray[i];
            blender.add (new Milk( "milk" , number * calArray[i], vol, new Color(255, 255, 255)));
            i++;
            emptyVolume -= vol;
            System.out.println("You have " + emptyVolume + " gram left in the blinder");

            //Adding Suger
            System.out.println("Do you want to add Sugar ? (Y/N)");
        if (input.next().charAt(0) == 'Y') 
        {
            System.out.println("How maney spoons do you want to add ?");
            number = input.nextInt();
            blender.add(new Sugar(number * calArray[i]));
        } 

        System.out.println("You have " + emptyVolume + " gram left in the blinder");

  
     System.out.println("The ingredients was added successfully\n");
     System.out.println(blender.contains());
     
        
     blender.blend();
     System.out.println("The ingredients was blend successfully");
     System.out.println(blender.getInfo());
     Cups cup = new Cups(250);
     
     blender.pour(cup);
     System.out.println("The calories in the cup are " +cup.getCalories());
     blender.getInfo();
     cup.getInfo();
       
        
     
    }
}