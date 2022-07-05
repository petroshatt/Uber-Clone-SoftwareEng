
package tl;

import java.util.Date;


public class ContactForm {
    
    private User sender;
    private Date date;
    private String description;
    private String reply;
    
    public ContactForm(){
        
        date = new Date();
        description = " ";
        reply = " ";
        
    }
    
    public ContactForm(User u, String desc){
        
        sender = u;
        date = new Date();
        description = desc;
        reply = " ";
        
    }
    
    public User getSender(){
        return sender;
    }
    
    public void setSender(User u){
        sender = u;
    }
    
    public Date getDate(){
        return date;
    }
    
    public void setDate(Date d){
        date = new Date();
    }
    
    public String getDesc(){
        return description;
    }
    
    public void setDesc(String d){
        description = d;
    }
    
    public String getReply(){
        return reply;
    }
    
    public void setReply(String r){
        reply = r;
    }
    
    public void printContactForm(){
        
        sender.printUser();
        
        System.out.println("Date: " + date.toString() +
                           "\nDescription: " + description);
        
        if(!reply.equals(" "))
            System.out.println("Reply: " + reply);
        
        System.out.println();
        
    }
    
}
