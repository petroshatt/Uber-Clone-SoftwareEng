
package tl;


public class CreditCard {
    
    private String cardNumber;
    private int CVV;
    
    
    public CreditCard(){
        cardNumber = " ";
        CVV = -1;
    }
    
    public CreditCard(String cn, int c){
        cardNumber = cn;
        CVV = c;
    }
    
    public String getCN(){
        return cardNumber;
    }
    
    public void setCN(String cn){
        cardNumber = cn;
    }
    
    public int getCVV(){
        return CVV;
    }
    
    public void setCVV(int c){
        CVV = c;
    }
    
    public void printCc(){
        
        System.out.println("\nCard Number: " + cardNumber +
                           "\nCVV: " + CVV + "\n");
        
    }
    
}
