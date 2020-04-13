package cocktail;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Cocktail {

    //We made the Scanner out of the main so we can reach it from other methods& static so we can reach it from main 
    static Scanner input = new Scanner(System.in);

    //This function is to check if the input used for number of Ingredient is an int.
    public static int getNumber() {
        boolean status;
        int num = 0; // it does not matter because it will change (just to make the reurn works)
        do {
            status = true;
            try {
                num = input.nextInt();
                return num;
            } catch (InputMismatchException ex) {
                input.next();// we use it because if we remove it it will enetr an infinite loop (it work as a cleaner for the console)
                System.out.print("That's not an integer. Try again:");
                status = false;
            }
        } while (!status);
        return num;
    }

    //This function is to check if the input used for (Y/N)is a valid
    public static char getChar() {
        boolean status;
        char yesOrNo = 'Y';
        do {
            status = true;

            yesOrNo = input.next().charAt(0);//it reades any thing I enter as a charachter so there won't be an exception
            if (yesOrNo != 'Y' && yesOrNo != 'N') {
                System.out.print("That's not a Y or N charachter. Try again :");
                status = false;
            }

        } while (!status);
        return yesOrNo;
    }

    public static void main(String[] args) {

        //fixed information about the ingredients that we will use in loop
        final int volumeArray[] = {152, 182, 118, 250, 0}; //str, apple , banana,milk ,  suger
        final int calArray[] = {49, 95, 100, 110, 50};
        final String fruitNames[] = {"Strawberry", "Apple", "Banana"};
        final int[][] colorArray = {{255, 54, 50}, {171, 255, 127}, {255, 253, 26}};
        Blender blender = new Blender();
        int number;
        int emptyVolume;
        int vol = 0;
        int i;

        //Add fruits
        //We decided to make a loop so the code can be more general and if we decided to add more fruits it will be better
        boolean success;
        for (i = 0; i < fruitNames.length; i++) {
            do {
                success = true;
                System.out.println("Do you want to add " + fruitNames[i] + " ? (Y/N)");
                if (getChar() == 'Y') {
                    System.out.println("How maney " + fruitNames[i] + "s you want to add ?(" + fruitNames[i] + " volume = " + volumeArray[i] + " )");
                    number = getNumber();
                    vol = number * volumeArray[i];
                    try {
                        blender.add(new Fruits(fruitNames[i], number * calArray[i], vol, new Color(colorArray[i][0], colorArray[i][1], colorArray[i][2])));
                    } catch (BlenderOverFlowException ex) {
                        System.out.println(ex.getMessage());
                        success = false;
                    }
                }
            } while (!success);
            System.out.println("You have " + blender.emptyVolume() + " gram left in the blinder");
        }

        //Adding Milk
       
        do {
            success = true;
            System.out.println("Do you want to add Milk ? (Y/N)");
            if (getChar() == 'Y') {
            System.out.println("How maney cups of milk do you want to add? (Milk  volume = " + volumeArray[i] + " )");
            try {
                number = getNumber();
                vol = number * volumeArray[i];
                blender.add(new Milk("milk", number * calArray[i], vol, new Color(255, 255, 255)));
            } catch (BlenderOverFlowException ex) {
                System.out.println(ex.getMessage());
                success = false;
            }
         }
        } while (!success);
        i++;
        
        System.out.println("You have " + blender.emptyVolume() + " gram left in the blinder");

        //Adding Suger
        //No do-while here because the suger does not have any volume.
        System.out.println("Do you want to add Sugar ? (Y/N)");
        if (getChar() == 'Y') {
            System.out.println("How maney spoons do you want to add ? (sugar volume = " + volumeArray[i] + " )");
            number = getNumber();
            try {
                blender.add(new Sugar(number * calArray[i]));
            } catch (BlenderOverFlowException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("You have " + blender.emptyVolume() + " gram left in the blinder");
        System.out.println("The ingredients was added successfully!\n");
        System.out.println(blender.containsInfo());
        
        //blend
        boolean status = true;
        try {
            blender.blend();
        } catch (EmptyBlenderException ex) {
            System.out.println(ex.getMessage());
            status = false;
        }
        if (status) {
            System.out.println("The ingredients was blend successfully!\n");
        }
        
    
        System.out.println(blender.getInfo());
        Cups cup = new Cups(250);

        
        status = true;
        //pour
        try {
            blender.pour(cup);
        } catch (EmptyBlenderException ex) {
            System.out.println(ex.getMessage());
            status = false;
        }
        catch(NotBlendedException ex)
        {
            System.out.println(ex.getMessage());
            status = false;
        }
        if (status) {
            System.out.println("the cocktail was poured successfully to the cup!\n ");
        }
        System.out.println(cup.getInfo());

    }
}