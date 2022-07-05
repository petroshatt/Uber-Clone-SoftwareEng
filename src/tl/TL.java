

package tl;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;




public class TL {

    static ArrayList<User> userList = new ArrayList<>();
    static ArrayList<Passenger> passList = new ArrayList<>();
    static ArrayList<Driver> driverList = new ArrayList<>();
    static ArrayList<Admin> adminList = new ArrayList<>();
    static ArrayList<Request> reqList = new ArrayList<>();
    static ArrayList<Request> openReqList = new ArrayList<>();
    static ArrayList<ContactForm> cfList = new ArrayList<>();
    static int[] appSettings = {0, 0, 0};
    static int passIDGen = 3003;
    static int driverIDGen = 6004;
    
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        Passenger p1 = new Passenger(3001, "John", "Burns", "p", "pp", "jb00@test.com", "6978675645", "High Av.");
        userList.add(p1);
        passList.add(p1);
        
        Passenger p2 = new Passenger(3002, "Peter", "Stewart", "p1", "pp1", "ps99@test.com", "6978675643", "Sunset Blvd.");
        userList.add(p2);
        passList.add(p2);
        
        Driver d1 = new Driver(6001, "Mark", "Lopez", "mark_lopez", "dd", "mlopez@test.com", "6978674643", "Paradise St.", "Citroen C5", "AHK6287");
        userList.add(d1);
        driverList.add(d1);
        
        Driver d2 = new Driver(6002, "Matt", "Helders", "mhelders", "dd", "matthelders@test.com", "6978235643", "Apple Av.", "Ford Fiesta", "AHN1230");
        userList.add(d2);
        driverList.add(d2);
        
        Driver d3 = new Driver(6003, "Kendrick", "Perkins", "perkinsken", "dd", "kperkins@test.com", "6978675000", "California Av.", "Kia Sportage", "AHM0898");
        userList.add(d3);
        driverList.add(d3);
        
        Admin a1 = new Admin(10001, "Russell", "Turner", "a", "aa", "rt00@test.com", "69786751111", "Captain Av.");
        userList.add(a1);
        adminList.add(a1);
        
        Request r1 = new Request("North Blvd.", "College St.", "Cash");
        r1.setReqPass(p1);
        r1.setReqDriver(d1);
        reqList.add(r1);
        
        Request r2 = new Request("Park Av.", "8th Street", "Cash");
        r2.setReqPass(p1);
        r2.setReqDriver(d2);
        reqList.add(r2);
        
        Request r3 = new Request("Cherry Av.", "Santiago Street", "Cash");
        r3.setReqPass(p2);
        r3.setReqDriver(d2);
        reqList.add(r3);
        
        Request r4 = new Request("Elm St.", "High Av.", "Cash");
        r4.setReqPass(p1);
        openReqList.add(r4);
        
        Request r5 = new Request("Laurel Lane", "Court St.", "Cash");
        r5.setReqPass(p1);
        openReqList.add(r5);
        
        CreditCard cc1 = new CreditCard("1423423454363498", 777);
        p1.addCc(cc1);
        
        CreditCard cc2 = new CreditCard("1907627724784523", 666);
        p2.addCc(cc2);
        
        CreditCard cc3 = new CreditCard("4519349988994568", 900);
        p1.addCc(cc3);
        
        CreditCard cc4 = new CreditCard("4590454580002355", 700);
        d1.addCc(cc4);
        
        ContactForm cf1 = new ContactForm(p1, "Please add option to pay with Apple Pay!");
        cfList.add(cf1);
        
        ContactForm cf2 = new ContactForm(p2, "Not enough drivers.");
        cfList.add(cf2);
        
        
        String continueans = "LI";
        do{

            User currentUser = welcome();
            if(currentUser.getId() != -1){
                
                System.out.println("\nYou are logged in as:");
                System.out.println(currentUser.getId());
                currentUser.printLessUser();

                System.out.println("------------------------------");


                do{

                    if(currentUser.getRole().equals("Passenger")){

                        Passenger currPass = (Passenger) currentUser;
    //                    currPass.printPassenger();
                        passMenu(currPass);

                    }
                    else if(currentUser.getRole().equals("Driver")){

                        Driver currDriver = (Driver) currentUser;
    //                    currDriver.printDriver();
                        driverMenu(currDriver);

                    }
                    else if(currentUser.getRole().equals("Admin")){

                        Admin currAdmin = (Admin) currentUser;
                        adminMenu(currAdmin);

                    }

                    System.out.print("\nWould you like to continue with another action (C) or log out (LO)?: ");
                    continueans = input.nextLine();

                    while(!continueans.equals("C") && !continueans.equals("LO")){
                        System.out.print("Try Again!\nWould you like to continue with another action (C) or log out (LO)?: ");
                        continueans = input.nextLine();
                    }

                } while(continueans.equals("C"));


                System.out.print("\nWould you like to log in as another user (LI) or exit (E)?: ");
                continueans = input.nextLine();
                
                while(!continueans.equals("LI") && !continueans.equals("E")){
                    System.out.print("Try Again!\nWould you like to log in as another user (LI) or exit (E)?: ");
                    continueans = input.nextLine();
                }
                
            }
            else
                System.out.println("Username or Password are incorrect. Try Again!");
        
        } while(continueans.equals("LI"));
        
        
    }

    private static User welcome(){
        
        Scanner input = new Scanner(System.in);
        Passenger p = new Passenger();
        Driver d = new Driver();
        
        System.out.print("\nWelcome!\nWould like to Log In (LI) or Create An Account (CA)?: ");
        String welcomeans = input.nextLine();
        
        
        while(!welcomeans.equals("LI") && !welcomeans.equals("CA")){
            System.out.print("Try Again!\nWould like to Log In (LI) or Create An Account (CA)?: ");
            welcomeans = input.nextLine();
        }
        
        if(welcomeans.equals("LI")){
            
            System.out.print("\nEnter your username: ");
            String username = input.nextLine();
            System.out.print("Enter your password: ");
            String password = input.nextLine();
            
            for(User u : userList){
                if(u.getUsername().equals(username) && u.getPassword().equals(password))
                    return u;
            }
            
        }
        else if(welcomeans.equals("CA")){
            
            System.out.print("Are you a passenger (P) or a driver (D)?: ");
            String roleans = input.nextLine();
            
            while(!roleans.equals("P") && !roleans.equals("D")){
                System.out.print("Try Again!\nAre you a passenger (P) or a driver (D)?: ");
                roleans = input.nextLine();
            }
            
            System.out.print("\nEnter your username: ");
            String username = input.nextLine();
            while(!username.matches(".*[a-z].*")){
                System.out.print("\nThe username must contain a character! Enter your username: ");
                username = input.nextLine();
            }
            
            System.out.print("Enter your password: ");
            String password = input.nextLine();
            while(!password.matches(".*[a-z].*")){
                System.out.print("\nThe password must contain a character! Enter your password: ");
                password = input.nextLine();
            }
            
            System.out.print("Enter your first name: ");
            String fname = input.nextLine();
            while(!fname.matches(".*[a-z].*")){
                System.out.print("\nThe first name must contain a character! Enter your first name: ");
                fname = input.nextLine();
            }
            
            System.out.print("Enter your last name: ");
            String lname = input.nextLine();
            while(!lname.matches(".*[a-z].*")){
                System.out.print("\nThe last name must contain a character! Enter your last name: ");
                lname = input.nextLine();
            }
            
            System.out.print("Enter your email: ");
            String em = input.nextLine();
            while(!em.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")){
                System.out.print("\nEmail not accepted! Enter email: ");
                em = input.nextLine();
            }
            
            System.out.print("Enter your phone number: ");
            String ph = input.nextLine();
            while(ph.matches(".*[a-z].*")){
                System.out.print("\nPhone Number cannot contain characters! Enter the phone number: ");
                ph = input.nextLine();
            }
            
            System.out.print("Enter your home address: ");
            String ad = input.nextLine();
            while(!ad.matches(".*[a-z].*")){
                System.out.print("\nThe address must contain a character! Enter your address: ");
                ad = input.nextLine();
            }
            
            if(roleans.equals("P")){
                
                p = new Passenger(passIDGen++, fname, lname, username, password, em, ph, ad);
                userList.add(p);
                passList.add(p);
                
                return p;
                
            }
            else if(roleans.equals("D")){
                
                System.out.print("\nEnter your car type: ");
                String ct = input.nextLine();
                System.out.print("Enter your plate number: ");
                String pn = input.nextLine();
                
                d = new Driver(driverIDGen++, fname, lname, username, password, em, ph, ad, ct, pn);
                userList.add(d);
                driverList.add(d);
                
                return d;
                
            }
            
        }
        
        return d;
        
    }

    
    
    // Passengers
    
    private static void passMenu(Passenger currUser){
        
        System.out.println("\n1. Create a Request");
        System.out.println("2. View History");
        System.out.println("3. Contact with an Administrator");
        System.out.println("4. Settings");
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("\nEnter the number of the action: ");
        int menuAns = input.nextInt();
        
        while(menuAns < 0 || menuAns > 4){
            System.out.print("\nTry Again! Enter a number between 1-4: ");
            menuAns = input.nextInt();
        }
        
        if(menuAns == 1){
            createRequest(currUser);
        }
        else if(menuAns == 2){
            viewPassHistory(currUser);
        }
        else if(menuAns == 3){
            createContactForm(currUser);
        }
        else if(menuAns == 4){
            passSettings(currUser);
        }
        
    }
    
    private static void createRequest(Passenger p){
        
        Scanner input = new Scanner(System.in);
        Request r = new Request();
        
        System.out.print("\n------------------------------\n\nCreate a Request\n");
        
        System.out.print("\nEnter your location: ");
        String location = input.nextLine();
        System.out.print("Enter the destination: ");
        String destination = input.nextLine();
        System.out.print("Enter the type of payment (Cash / Card): ");
        String typeOfPayment = input.nextLine();
        
        while(!typeOfPayment.equals("Cash") && !typeOfPayment.equals("Card")){
           System.out.print("Try Again! Enter the type of payment (Cash / Card): ");
           typeOfPayment = input.nextLine();
        }
        
        r = new Request(location, destination, typeOfPayment);
        r.setReqPass(p);
        reqList.add(r);
        
        if(typeOfPayment.equals("Card")){
            
            p.printCcList();
            
            System.out.print("\nChoose the number of the card\nor add a new card (N): ");
            String cardAns = input.nextLine();
            
            if(!cardAns.equals("N")){
                
                int cardAnsInt = Integer.parseInt(cardAns);
                
                // elegxos gia arithmous
                
                r.setCc(p.getCc((cardAnsInt - 1)));
            }
            else if(cardAns.equals("N")){
                
                System.out.print("\nEnter the card number: ");
                String cardNumber = input.nextLine();
                
                while(cardNumber.length() != 16){
                    System.out.print("\nCard Number must be 16 digits! Enter the card number: ");
                    cardNumber = input.nextLine();
                }
                
                while(cardNumber.matches(".*[a-z].*")){
                    System.out.print("\nCard Number cannot contain characters! Enter the card number: ");
                    cardNumber = input.nextLine();
                }
                
                System.out.print("Enter the CVV: ");
                int CVV = input.nextInt();
                input.nextLine();
                
                while(CVV >= 1000 || CVV <= 99){
                    System.out.print("CVV must be 3 digits! Enter the CVV: ");
                    CVV = input.nextInt();
                    input.nextLine();
                }
                
                CreditCard newCc = new CreditCard(cardNumber, CVV);
                p.addCc(newCc);
                
            }
            
        }
        
        System.out.print("\nPlease Wait. Matching you with a driver...");
        wait(3000);
        
        
        Driver matchedDriver;
        if(!driverList.isEmpty()){
            System.out.print("\nYour driver is:");
            matchedDriver = driverList.get(new Random().nextInt(driverList.size()));
            matchedDriver.printLessUser();
            r.setReqDriver(matchedDriver);
        }
        else{
            System.out.print("\nNo drivers available!");
            matchedDriver = new Driver();
        }
        
    }
    
    
    private static void viewPassHistory(Passenger p){
        
        System.out.print("\n------------------------------\n\nView History\n\n");
        
        Scanner input = new Scanner(System.in);
        int rating = -1;
        
        int reqIndex = 1;
        for(Request r : reqList){
            if(p.getId() == r.getReqPass().getId()){
                System.out.print(reqIndex);
                r.printRequestAfterAssignment();
                reqIndex++;
            }
        }
        
        System.out.print("\nEnter the number of the request you would like to rate\nor press (C) to continue: ");
        String rateAns = input.nextLine();
        
        if(!rateAns.equals("C")){
            
            int rateAnsInt = Integer.parseInt(rateAns);
            
            while(rateAnsInt < 1 || rateAnsInt > (reqIndex - 1)){
                System.out.print("\nEnter a correct number: ");
                rateAnsInt = input.nextInt();
            }
            
            for(Request r : reqList){
                
                if(p.getId() == r.getReqPass().getId()){

                    rateAnsInt--;

                    if(rateAnsInt == 0){
                        System.out.print("\nEnter your rating (1-5): ");
                        rating = input.nextInt();
                        
                        while(rating > 5 || rating < 1){
                            System.out.print("\nTry Again! Enter a number between 1-5: ");
                            rating = input.nextInt();
                        }
                        
                        if(rating != -1)
                        r.setPassRating(rating);
                        
                        r.printRequestAfterAssignment();
                        
                    }
                    
                }
            
            }
            
        }
    
    }
    
    
    private static void passSettings(Passenger p){
        
        System.out.print("\n------------------------------\n\nSettings\n\n");
        
        System.out.println("1. Edit Profile");
        System.out.println("2. Edit App Settings");
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("\nEnter the number of the action: ");
        int settAns = input.nextInt();
        
        while(settAns > 2 || settAns < 1){
            System.out.print("\nTry Again! Enter a number between 1-2: ");
            settAns = input.nextInt();
        }
        
        if(settAns == 1){
            editPassProfile(p);
        }
        else if(settAns == 2){
            editAppSettings();
        }
        
    }
    
    
    private static void editPassProfile(Passenger p){
        
        System.out.print("\n------------------------------\n\nEdit Profile\n\n");
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("1. First Name");
        System.out.println("2. Last Name");
        System.out.println("3. Username");
        System.out.println("4. Password");
        System.out.println("5. Email");
        System.out.println("6. Phone Number");
        System.out.println("7. Address");
        
        System.out.print("\nEnter the number of the field you would like to edit: ");
        int editAns = input.nextInt();
        input.nextLine();
        
        while(editAns < 1 || editAns > 7){
            System.out.print("\nTry Again! Enter a number between 1-7: ");
            editAns = input.nextInt();
            input.nextLine();
        }
        
        String newField = "";
        
        if(editAns == 1){
            System.out.print("\nEnter the new first name: ");
            newField = input.nextLine();
            
            while(!newField.matches(".*[a-z].*")){
                System.out.print("\nThe first name must contain a character! Enter your first name: ");
                newField = input.nextLine();
            }
            
            p.setFirstName(newField);
            
        }
        else if(editAns == 2){
            System.out.print("\nEnter the new last name: ");
            newField = input.nextLine();
            
            while(!newField.matches(".*[a-z].*")){
                System.out.print("\nThe last name must contain a character! Enter your last name: ");
                newField = input.nextLine();
            }
            
            p.setLastName(newField);
            
        }
        else if(editAns == 3){
            System.out.print("\nEnter the new username: ");
            newField = input.nextLine();
            
            while(!newField.matches(".*[a-z].*")){
                System.out.print("\nThe username must contain a character! Enter your username: ");
                newField = input.nextLine();
            }
            
            p.setUsername(newField);
            
        }
        else if(editAns == 4){
            System.out.print("\nEnter the new password: ");
            newField = input.nextLine();
            
            while(!newField.matches(".*[a-z].*")){
                System.out.print("\nThe password must contain a character! Enter your password: ");
                newField = input.nextLine();
            }
            
            p.setPassword(newField);
            
        }
        else if(editAns == 5){
            System.out.print("\nEnter the new email: ");
            newField = input.nextLine();
            
            while(!newField.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")){
                System.out.print("\nEmail not accepted! Enter email: ");
                newField = input.nextLine();
            }
            
            p.setEmail(newField);
            
        }
        else if(editAns == 6){
            System.out.print("\nEnter the new phone number: ");
            newField = input.nextLine();
            
            while(newField.matches(".*[a-z].*")){
                System.out.print("\nPhone Number cannot contain characters! Enter the phone number: ");
                newField = input.nextLine();
            }
            
            p.setPhoneNumber(newField);
            
        }
        else if(editAns == 7){
            System.out.print("\nEnter the new address: ");
            newField = input.nextLine();
            
            while(!newField.matches(".*[a-z].*")){
                System.out.print("\nThe address must contain a character! Enter your address: ");
                newField = input.nextLine();
            }
            
            p.setAddress(newField);
            
        }
        
    }
    
    
    
    
    
    // Drivers
    
    private static void driverMenu(Driver currUser){
        
        System.out.println("\n1. View Current Requests");
        System.out.println("2. View History");
        System.out.println("3. Contact with an Administrator");
        System.out.println("4. Settings");
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("\nEnter the number of the action: ");
        int menuAns = input.nextInt();
        
        if(menuAns == 1){
            viewRequests(currUser);
        }
        else if(menuAns == 2){
            viewDriverHistory(currUser);
        }
        else if(menuAns == 3){
            createContactForm(currUser);
        }
        else if(menuAns == 4){
            driverSettings(currUser);
        }
        
    }
    
    private static void viewRequests(Driver d){
        
        Scanner input = new Scanner(System.in);
        Request r = new Request();
        
        System.out.print("\n");
        
        int reqIndex = 1;
        for(Request re : openReqList){
            System.out.print(reqIndex);
            re.printRequestBeforeAssignment();
            reqIndex++;
        }
        
        System.out.print("\nEnter the request you would like to accept: ");
        int accReq = input.nextInt();
        
        while(accReq < 1 || accReq > openReqList.size()){
            System.out.print("\nEnter a correct number: ");
            accReq = input.nextInt();
        }
        
        r = openReqList.get((accReq - 1));
        r.setReqDriver(d);
        
        openReqList.remove((accReq - 1));
        
        reqList.add(r);
        
    }
    
    
    private static void viewDriverHistory(Driver d){
        
        System.out.print("\n------------------------------\n\nView History\n\n");
        
        Scanner input = new Scanner(System.in);
        int rating = -1;
        
        int reqIndex = 1;
        for(Request r : reqList){
            if(d.getId() == r.getReqDriver().getId()){
                System.out.print(reqIndex);
                r.printRequestAfterAssignment();
                reqIndex++;
            }
        }
        
        System.out.print("\nEnter the number of the request you would like to rate\nor press (C) to continue: ");
        String rateAns = input.nextLine();
        
        if(!rateAns.equals("C")){
            
            int rateAnsInt = Integer.parseInt(rateAns);
            
            while(rateAnsInt < 1 || rateAnsInt > (reqIndex - 1)){
                System.out.print("\nEnter a correct number: ");
                rateAnsInt = input.nextInt();
            }
            
            for(Request r : reqList){
                
                if(d.getId() == r.getReqDriver().getId()){

                    rateAnsInt--;

                    if(rateAnsInt == 0){
                        System.out.print("\nEnter your rating (1-5): ");
                        rating = input.nextInt();
                        
                        while(rating > 5 || rating < 1){
                            System.out.print("\nTry Again! Enter a number between 1-5: ");
                            rating = input.nextInt();
                        }
                        
                        if(rating != -1)
                        r.setDriverRating(rating);
                        
                        r.printRequestAfterAssignment();
                        
                    }
                    
                }
            
            }
            
        }
    
    }
    
    
    private static void driverSettings(Driver p){
        
        System.out.print("\n------------------------------\n\nSettings\n\n");
        
        System.out.println("1. Edit Profile");
        System.out.println("2. Edit App Settings");
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("\nEnter the number of the action: ");
        int settAns = input.nextInt();
        
        while(settAns > 2 || settAns < 1){
            System.out.print("\nTry Again! Enter a number between 1-2: ");
            settAns = input.nextInt();
        }
        
        if(settAns == 1){
            editDriverProfile(p);
        }
        else if(settAns == 2){
            editAppSettings();
        }
        
    }
    
    
    private static void editDriverProfile(Driver p){
        
        System.out.print("\n------------------------------\n\nEdit Profile\n\n");
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("1. First Name");
        System.out.println("2. Last Name");
        System.out.println("3. Username");
        System.out.println("4. Password");
        System.out.println("5. Email");
        System.out.println("6. Phone Number");
        System.out.println("7. Address");
        System.out.println("8. Car Type");
        System.out.println("9. Plate");
        
        System.out.print("\nEnter the number of the field you would like to edit: ");
        int editAns = input.nextInt();
        input.nextLine();
        
        while(editAns < 1 || editAns > 9){
            System.out.print("\nTry Again! Enter a number between 1-9: ");
            editAns = input.nextInt();
            input.nextLine();
        }
        
        String newField = "";
        
        if(editAns == 1){
            System.out.print("\nEnter the new first name: ");
            newField = input.nextLine();
            
            while(!newField.matches(".*[a-z].*")){
                System.out.print("\nThe first name must contain a character! Enter your first name: ");
                newField = input.nextLine();
            }
            
            p.setFirstName(newField);
        }
        else if(editAns == 2){
            System.out.print("\nEnter the new last name: ");
            newField = input.nextLine();
            
            while(!newField.matches(".*[a-z].*")){
                System.out.print("\nThe last name must contain a character! Enter your last name: ");
                newField = input.nextLine();
            }
            
            p.setLastName(newField);
        }
        else if(editAns == 3){
            System.out.print("\nEnter the new username: ");
            newField = input.nextLine();
            
            while(!newField.matches(".*[a-z].*")){
                System.out.print("\nThe username must contain a character! Enter your username: ");
                newField = input.nextLine();
            }
            
            p.setUsername(newField);
        }
        else if(editAns == 4){
            System.out.print("\nEnter the new password: ");
            newField = input.nextLine();
            
            while(!newField.matches(".*[a-z].*")){
                System.out.print("\nThe password must contain a character! Enter your password: ");
                newField = input.nextLine();
            }
            
            p.setPassword(newField);
        }
        else if(editAns == 5){
            System.out.print("\nEnter the new email: ");
            newField = input.nextLine();
            
            while(!newField.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")){
                System.out.print("\nEmail not accepted! Enter email: ");
                newField = input.nextLine();
            }
            
            p.setEmail(newField);
        }
        else if(editAns == 6){
            System.out.print("\nEnter the new phone number: ");
            newField = input.nextLine();
            
            while(newField.matches(".*[a-z].*")){
                System.out.print("\nPhone Number cannot contain characters! Enter the phone number: ");
                newField = input.nextLine();
            }
            
            p.setPhoneNumber(newField);
        }
        else if(editAns == 7){
            System.out.print("\nEnter the new address: ");
            newField = input.nextLine();
            
            while(!newField.matches(".*[a-z].*")){
                System.out.print("\nThe address must contain a character! Enter your address: ");
                newField = input.nextLine();
            }
            
            p.setAddress(newField);
        }
        else if(editAns == 8){
            System.out.print("\nEnter the new car type: ");
            newField = input.nextLine();
            
            while(!newField.matches(".*[a-z].*")){
                System.out.print("\nThe car type must contain a character! Enter your car type: ");
                newField = input.nextLine();
            }
            
            p.setCarType(newField);
        }
        else if(editAns == 9){
            System.out.print("\nEnter the new plate: ");
            newField = input.nextLine();
            
            while(!newField.matches(".*[a-z].*")){
                System.out.print("\nThe plate must contain a character! Enter your plate: ");
                newField = input.nextLine();
            }
            
            p.setPlate(newField);
        }
        
    }
    
    
    
    // Admin
    
    private static void adminMenu(Admin a){
        
        System.out.println("\n1. View Users");
        System.out.println("2. View Passengers");
        System.out.println("3. View Drivers");
        System.out.println("4. View Requests");
        System.out.println("5. View Contact Forms");
        System.out.println("6. Search User by ID");
        System.out.println("7. Edit Profile by ID");
        
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("\nEnter the number of the action: ");
        int menuAns = input.nextInt();
        
        while(menuAns < 1 || menuAns > 7){
            System.out.print("\nTry Again! Enter a number between 1-7: ");
            menuAns = input.nextInt();
            input.nextLine();
        }
        
        if(menuAns == 1){
            viewUsers();
        }
        else if(menuAns == 2){
            viewPass();
        }
        else if(menuAns == 3){
            viewDrivers();
        }
        else if(menuAns == 4){
            viewReq();
        }
        else if(menuAns == 5){
            viewAndReplyCf();
        }
        else if(menuAns == 6){
            viewById();
        }
        else if(menuAns == 7){
            editById();
        }
        
    }
    
    
    private static void viewUsers(){
        
        System.out.print("\n------------------------------\n\nView Users\n");
        
        int index = 1;
        for(User u : userList){
            System.out.println(index);
            u.printUser();
            index++;
        }
        
    }
    
    private static void viewPass(){
        
        System.out.print("\n------------------------------\n\nView Passengers\n");
        
        int index = 1;
        for(Passenger p : passList){
            System.out.println(index);
            p.printUser();
            index++;
        }
        
    }
    
    private static void viewDrivers(){
        
        System.out.print("\n------------------------------\n\nView Drivers\n");
        
        int index = 1;
        for(Driver d : driverList){
            System.out.println(index);
            d.printDriver();
            index++;
        }
        
    }
    
    private static void viewReq(){
        
        System.out.print("\n------------------------------\n\nView Requests\n");
        
        int index = 1;
        for(Request r : reqList){
            System.out.println(index);
            r.printRequestBeforeAssignment();
            index++;
        }
        
    }
    
    private static void viewAndReplyCf(){
        
        System.out.print("\n------------------------------\n\nView and Reply to Contact Forms\n");
        
        Scanner input = new Scanner(System.in);
        
        int index = 1;
        for(ContactForm cf : cfList){
            System.out.println(index);
            cf.printContactForm();
            index++;
        }
        
        System.out.print("\nEnter the number of the contact form you would like to reply to: ");
        int reqToReply = input.nextInt();
        input.nextLine();
        
        if(Integer.valueOf(reqToReply) < index){  
            System.out.print("Enter your reply: ");
            String reply = input.nextLine();
     
            cfList.get((reqToReply - 1)).setReply(reply);
            cfList.get((reqToReply - 1)).printContactForm();
        }
        else 
            System.out.print("\nNot a valid number!");
                  

    }
    
    private static void viewById(){
        
        System.out.print("\n------------------------------\n\nView User by ID search\n");
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("\nEnter the ID of the user you would like to view: ");
        int ID = input.nextInt();
        input.nextLine();
        
        boolean found = false;
        
        for(User u : userList){
            if(u.getId() == ID){
                found = true;
                u.printUser();
            }
        }
        
        if(found == false)
            System.out.println("\nNo users with this ID!");
        
    }
    
    private static void editById(){
        
        System.out.print("\n------------------------------\n\nEdit User by ID search\n");
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("\nEnter the ID of the user you would like to edit: ");
        int ID = input.nextInt();
        input.nextLine();
        
        boolean found = false;
        
        for(User u : userList){
            
            if(u.getId() == ID){
                
                found = true;
                u.printUser();
        
                System.out.println("1. First Name");
                System.out.println("2. Last Name");
                System.out.println("3. Username");
                System.out.println("4. Password");
                System.out.println("5. Email");
                System.out.println("6. Phone Number");
                System.out.println("7. Address");

                System.out.print("\nEnter the number of the field you would like to edit: ");
                int editAns = input.nextInt();
                input.nextLine();

                String newField = "";

                if(editAns == 1){
                    System.out.print("\nEnter the new first name: ");
                    newField = input.nextLine();

                    while(!newField.matches(".*[a-z].*")){
                        System.out.print("\nThe first name must contain a character! Enter your first name: ");
                        newField = input.nextLine();
                    }

                    u.setFirstName(newField);
                }
                else if(editAns == 2){
                    System.out.print("\nEnter the new last name: ");
                    newField = input.nextLine();

                    while(!newField.matches(".*[a-z].*")){
                        System.out.print("\nThe last name must contain a character! Enter your last name: ");
                        newField = input.nextLine();
                    }

                    u.setLastName(newField);
                }
                else if(editAns == 3){
                    System.out.print("\nEnter the new username: ");
                    newField = input.nextLine();

                    while(!newField.matches(".*[a-z].*")){
                        System.out.print("\nThe username must contain a character! Enter your username: ");
                        newField = input.nextLine();
                    }

                    u.setUsername(newField);
                }
                else if(editAns == 4){
                    System.out.print("\nEnter the new password: ");
                    newField = input.nextLine();

                    while(!newField.matches(".*[a-z].*")){
                        System.out.print("\nThe password must contain a character! Enter your password: ");
                        newField = input.nextLine();
                    }

                    u.setPassword(newField);
                }
                else if(editAns == 5){
                    System.out.print("\nEnter the new email: ");
                    newField = input.nextLine();

                    while(!newField.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")){
                        System.out.print("\nEmail not accepted! Enter email: ");
                        newField = input.nextLine();
                    }

                    u.setEmail(newField);
                }
                else if(editAns == 6){
                    System.out.print("\nEnter the new phone number: ");
                    newField = input.nextLine();

                    while(newField.matches(".*[a-z].*")){
                        System.out.print("\nPhone Number cannot contain characters! Enter the phone number: ");
                        newField = input.nextLine();
                    }

                    u.setPhoneNumber(newField);
                }
                else if(editAns == 7){
                    System.out.print("\nEnter the new address: ");
                    newField = input.nextLine();

                    while(!newField.matches(".*[a-z].*")){
                        System.out.print("\nThe address must contain a character! Enter your address: ");
                        newField = input.nextLine();
                    }

                    u.setAddress(newField);
                }
        
            }
            
        }
        
        if(found == false)
            System.out.println("\nNo users with this ID!");
        
    }
    
    
    
    
    // Extra Methods
    
    private static void editAppSettings(){
        
        System.out.print("\n------------------------------\n\nEdit App Settings\n\n");
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Current App Settings");
        
        if(appSettings[0] == 0)
            System.out.println("1. Light Mode On");
        else if(appSettings[0] == 1)
            System.out.println("1. Dark Mode On");
        
        if(appSettings[1] == 0)
            System.out.println("2. Push Notifications On");
        else if(appSettings[1] == 1)
            System.out.println("2. Push Notifications Off");
        
        if(appSettings[2] == 0)
            System.out.println("3. Email Promotions On");
        else if(appSettings[2] == 1)
            System.out.println("3. Email Promotions Off");
        
        System.out.print("\nEnter the number of the field you would like to edit: ");
        int editAns = input.nextInt();
        
        while(editAns < 1 || editAns > 3){
            System.out.print("\nTry Again! Enter a number between 1-3: ");
            editAns = input.nextInt();
        }
        
        if(editAns == 1){
            if(appSettings[0] == 0){
                appSettings[0] = 1;
            }
            else if(appSettings[0] == 1)
                appSettings[0] = 0;
        }
        else if(editAns == 2){
            if(appSettings[1] == 0)
                appSettings[1] = 1;
            else if(appSettings[1] == 1)
                appSettings[1] = 0;
        }
        else if(editAns == 3){
            if(appSettings[2] == 0)
                appSettings[2] = 1;
            else if(appSettings[2] == 1)
                appSettings[2] = 0;
        }
        
        if(appSettings[0] == 0)
            System.out.println("1. Light Mode On");
        else if(appSettings[0] == 1)
            System.out.println("1. Dark Mode On");
        
        if(appSettings[1] == 0)
            System.out.println("2. Push Notifications On");
        else if(appSettings[1] == 1)
            System.out.println("2. Push Notifications Off");
        
        if(appSettings[2] == 0)
            System.out.println("3. Email Promotions On");
        else if(appSettings[2] == 1)
            System.out.println("3. Email Promotions Off");
        
    }
    
    
    private static void createContactForm(User u){
        
        System.out.print("\n------------------------------\n\nContact with an Administrator\n\n");
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("\nEnter the message you would like to send to the administrators: ");
        String desc = input.nextLine();      
        
        ContactForm cf = new ContactForm(u, desc);
        cfList.add(cf);
        
    }
    
    
    public static void wait(int ms){
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
        
    
}
