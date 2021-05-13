/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

/**
 *
 * @author Nips
 */
public class Sting_Striper {
    public static void main(String args[]){
    
    String name="Alvin Mwaniki";
    String f_name=name.substring(name.indexOf("A"), name.indexOf("M"));
    String l_name=name.substring(name.indexOf("M"));
    System.out.println(f_name);
    
    }
}
