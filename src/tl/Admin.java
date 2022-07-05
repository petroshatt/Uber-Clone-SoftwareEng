
package tl;


public class Admin extends User{
    
    public Admin(){
    
        super();
    
    }
    
    public Admin(int i, String fn, String ln, String u, String p, String e, String ph, String ad){
        
        super(i, "Admin", fn, ln, u, p, e, ph, ad);
        
    }
    
    public void printAdmin(){
        
        super.printUser();
        
    }
    
}
