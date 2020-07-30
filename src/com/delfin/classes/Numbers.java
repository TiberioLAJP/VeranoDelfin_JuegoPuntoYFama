/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.delfin.classes;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author tibe
 */
public class Numbers {
    
    private int numberOfDigits;
    private int randomNumber;
    private int[] digitos;
    private int famas;
    private int puntos;
    private boolean isWinner = false;
    
    
    public Numbers(){
   
    }
    
    //GETTER AND SETTERS
    public void setNumberOfDigits(int numberOfDigits)
    {
        this.numberOfDigits = numberOfDigits;
    }
    
    public int getNumberOfdigits(){
        return this.numberOfDigits;
    }
    
    public void setRandomNumber(int randomNumber)
    {
        this.randomNumber = randomNumber;
    }
    
    public int getRandomNumber(){
        return this.randomNumber;
    }
    
    public void setDigitos(int[] digitos)
    {
        this.digitos = digitos;
    }
    
    public int[] getDigitos(){
        return this.digitos;
    }

    public void setFamas(int famas)
    {
        this.famas = famas;
    }
    
    public int getFamas(){
        return this.famas;
    }
    
        public void setPuntos(int puntos)
    {
        this.puntos = puntos;
    }
    
    public int getPuntos(){
        return this.puntos;
    }
    
     public void setIsWinner(boolean isWinner)
    {
        this.isWinner = isWinner;
    }
    
    public boolean getIsWinner(){
        return this.isWinner;
    }
    
    

    //Methods
    public int generateRandomNumber(){
       
        int limitNumberCeil = numberCeil();
        int limitNumberFloor = numberFloor();
        
        int randomNumber = (int) (Math.random() * limitNumberCeil) + limitNumberFloor;
       
       return (ThreadLocalRandom.current().nextInt(limitNumberFloor, limitNumberCeil));
    
    }
    
    
    public int[] digitsRandomNumber(int randomNumber){
        int[] digitos= new int[numberOfDigits];
        int contadortotal = numberOfDigits -1;
        while(randomNumber>0){
        digitos[contadortotal--] = randomNumber % 10;
        randomNumber/=10;
        }
        return digitos;
    }
    
    
    public void validatePuntosYFamas(int[] combosValues){
        int famas = 0;
        int puntos = 0;
        
        String[] aux = new String[combosValues.length];
        
        for (int i = 0; i < combosValues.length ; i++) {
            if(combosValues[i] == digitos[i]){
                famas++;
                aux[i] = "fama";
                continue;
            }
            else{
                for (int j = 0; j < combosValues.length; j++) {
                    if(j == i){
                        continue;
                    }else{
                        if(combosValues[i] == digitos[j]){
                            if(aux[j] != "punto" || aux[j] !="fama"){
                                if(combosValues[j] != digitos[j]){
                                    puntos++;
                                    aux[i] = "punto";
                                    break; 
                                }
                                  
                            }
                        }
                    }
                }
            }
        }
   
        System.out.println("random" +randomNumber);
      
        this.famas = famas;
        this.puntos = puntos;
        
        if(famas == numberOfDigits){
            isWinner = true;
        }else{
            isWinner = false;
        }
       
    }
    
    
    // 9 * 1  9*11   9*111  9*1111 9* 11111
    public int numberCeil (){
        
        int aux = 0;
        int number = 0;
         
        for (int i = 0; i < numberOfDigits -1 ; i++) {
            
            if(i==0 ){
                aux = 10;
            }else{
                aux = aux * 10;
            }
            
            number = number + aux ;
        }
   
        return ((number + 1) * 9);
    }
    
    // 0 , 10 , 100, 1000 , 10000
    public int numberFloor() {
        int aux = 0;
   
        for (int i = 0; i < numberOfDigits -1 ; i++) {
            
            if(i==0 ){
                aux = 10;
            }else{
                aux = aux * 10;
            }
          
        }
   
        return (aux);
       
    }
}
