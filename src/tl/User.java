
package tl;


public class User {
    
    private int id;
    private String role;
    private String fname;
    private String lname;
    private String username;
    private String password;
    private String email;
    private String phonenum;
    private String address;
    
    
    public User(){
        
        id = -1;
        role = "NA";
        fname = " ";
        lname = " ";
        username = " ";
        password = " ";
        email = " ";
        phonenum = " ";
        address = " ";
        
    }
    
    public User(int i, String r, String fn, String ln, String u, String p, String e, String ph, String ad){
        
        id = i;
        role = r;
        fname = fn;
        lname = ln;
        username = u;
        password = p;
        email = e;
        phonenum = ph;
        address = ad;
        
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int i){
        id = i;
    }
    
    public String getRole(){
        return role;
    }
    
    public void setRole(String r){
        role = r;
    }
    
    public String getFirstName(){
        return fname;
    }
    
    public void setFirstName(String fn){
        fname = fn;
    }
    
    public String getLastName(){
        return fname;
    }
    
    public void setLastName(String ln){
        lname = ln;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String u){
        username = u;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String p){
        password = p;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String e){
        email = e;
    }
    
    public String getPhoneNumber(){
        return phonenum;
    }
    
    public void setPhoneNumber(String ph){
        phonenum = ph;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String ad){
        address = ad;
    }
    
    public void printUser(){
        
        System.out.println("\nId: " + id +
                           "\nRole: " + role +
                           "\nFirst Name: " + fname +
                           "\nLast Name: " + lname +
                           "\nUsername: " + username +
                           "\nPassword: " + password +
                           "\nEmail: " + email +
                           "\nPhone Number: " + phonenum +
                           "\nAddress: " + address + "\n");
        
    }
    
    public void printLessUser(){
        
        System.out.println("\nUsername: " + username +
                           "\nRole: " + role +
                           "\nFirst Name: " + fname +
                           "\nLast Name: " + lname +
                           "\nEmail: " + email + "\n");
        
    }
    
}
