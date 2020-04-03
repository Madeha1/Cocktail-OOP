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
public class EmptyBlenderException extends Exception{

    public EmptyBlenderException() {
        super("The Blender is Empty , You Can't Pour ! ");
    }
    
    
}
