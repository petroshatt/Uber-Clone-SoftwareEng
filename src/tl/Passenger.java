
package tl;

import java.util.ArrayList;


public class Passenger extends User{
    
    private ArrayList<CreditCard> ccList = new ArrayList<>();
    
    
    public Passenger(){
    
        super();
    
    }
    
    public Passenger(int i, String fn, String ln, String u, String p, String e, String ph, String ad){
        
        super(i, "Passenger", fn, ln, u, p, e, ph, ad);
        
    }
    
//    public CreditCard getCc(){
//        return cc;
//    }
//    
//    public void setCc(CreditCard c){
//        cc = c;
//    }
    
    public void addCc(CreditCard c){
        ccList.add(c);
    }
    
    public CreditCard getCc(int index){
        return ccList.get(index);
    }
    
    public void printCcList(){
        int index = 1;
        for(CreditCard cc : ccList){
            System.out.print(index);
            cc.printCc();
            index++;
        }
    }
    
    public void printPassenger(){
        
        super.printUser();
        
    }
    
}
