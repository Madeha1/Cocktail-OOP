/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cocktail;

/**
 *
 * @author HP
 */
public class NotBlendedException extends Exception{

    public NotBlendedException() {
    super ("The Ingredients are not blended yet, you have to blend them before pour!");
    }
    
}
