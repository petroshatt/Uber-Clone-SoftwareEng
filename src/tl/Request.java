
package tl;


public class Request{
    
    private String location;
    private String destination;
    private String typeOfPayment;
    private CreditCard cc;
    private User passenger;
    private User driver;
    private int passRating;
    private int driverRating;
    
    
    public Request(){
        
        location = " ";
        destination = " ";
        typeOfPayment = " ";
        passRating = -1;
        driverRating = -1;
        
    }
    
    public Request(String l, String d, String t){
        
        location = l;
        destination = d;
        typeOfPayment = t;
        
    }
    
    public String getLocation(){
        return location;
    }
    
    public void setLocation(String l){
        location = l;
    }
    
    public String getDest(){
        return destination;
    }
    
    public void setDest(String d){
        destination = d;
    }
    
    public String getPaym(){
        return typeOfPayment;
    }
    
    public void setPaym(String t){
        typeOfPayment = t;
    }
    
    public CreditCard getCc(){
        return cc;
    }
    
    public void setCc(CreditCard c){
        cc = c;
    }
    
    public User getReqPass(){
        return passenger;
    }
    
    public void setReqPass(User p){
        passenger = p;
    }
    
    public User getReqDriver(){
        return driver;
    }
    
    public void setReqDriver(User d){
        driver = d;
    }
    
    public int getPassRating(){
        return passRating;
    }
    
    public void setPassRating(int p){
        passRating = p;
    }
    
    public int getDriverRating(){
        return driverRating;
    }
    
    public void setDriverRating(int d){
        driverRating = d;
    }
    
    public void printRequestBeforeAssignment(){
        
        System.out.println("\nLocation: " + location +
                           "\nDestination: " + destination +
                           "\nType of Payment: " + typeOfPayment);
        
        System.out.print("\nPassenger");
        passenger.printLessUser();
        
    }
    
    public void printRequestAfterAssignment(){
        
        System.out.println("\nLocation: " + location +
                           "\nDestination: " + destination +
                           "\nType of Payment: " + typeOfPayment);
        
        if(passRating >= 1 && passRating <= 5)
            System.out.println("\nPassenger's Rating: " + passRating);
        if(driverRating >= 1 && driverRating <= 5)
            System.out.println("\nDriver's Rating: " + driverRating);
        
        System.out.print("\nPassenger");
        passenger.printLessUser();
        System.out.print("Driver");
        driver.printLessUser();
        
    }
    
//    public void printRequestAfterRatings(){
//        
//        System.out.println("\nLocation: " + location +
//                           "\nDestination: " + destination +
//                           "\nType of Payment: " + typeOfPayment);
//        
//        
//        
//        System.out.print("\nPassenger");
//        passenger.printLessUser();
//        System.out.print("Driver");
//        driver.printLessUser();
//        
//    }
    
}
