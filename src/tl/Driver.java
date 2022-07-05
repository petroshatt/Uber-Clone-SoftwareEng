
package tl;

import java.util.ArrayList;


public class Driver extends User{
    
    private String cartype;
    private String plate;
    private ArrayList<CreditCard> ccList = new ArrayList<>();
    
    public Driver(){
        
        super();
        cartype = " ";
        plate = " ";
        
    }
    
    public Driver(int i, String fn, String ln, String u, String p, String e, String ph, String ad, String ct, String pl){
        
        super(i, "Driver", fn, ln, u, p, e, ph, ad);
        cartype = ct;
        plate = pl;
        
    }
    
    public String getCarType(){
        return cartype;
    }
    
    public void setCarType(String c){
        cartype = c;
    }
    
    public String getPlate(){
        return plate;
    }
    
    public void setPlate(String p){
        plate = p;
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
    
    public void printCcList(){
        int index = 1;
        for(CreditCard cc : ccList){
            System.out.println(index);
            cc.printCc();
            index++;
        }
    }
    
    public void printDriver(){
        
        super.printUser();
        System.out.println("Car Type: " + cartype +
                           "\nPlate Number: " + plate + "\n");
        
    }
    
}
