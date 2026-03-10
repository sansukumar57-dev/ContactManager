package ContactNumber;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        1.⁠ ⁠CLI Contact Manager
//
//        Problem Statement:
//        People store many contacts and need a simple way to manage them. Build a CLI application to store and manage contact details.
//
//        Features
//
//        Add contact (name, phone number)
//
//        View all contacts
//
//        Search contact
//
//        Delete contact
        Scanner sc = new Scanner(System.in);
        UserInterface[] users = new User[10];
        int appChoice=1;

        while(appChoice==1){

            System.out.println("Welcome to Contact Manager ");
            boolean flag=false;
            while (!flag){


                System.out.println("1.Start 2.Close");
                try {
                    appChoice = new Integer(sc.nextLine());

                    if (appChoice > 2 || appChoice <= 0) {


                    throw new Exception();}

                } catch (Exception e) {
                    System.out.println("enter the 1 or 2 ");
                    continue;
                }

                if (appChoice == 2) {
                    flag = true;
                    continue;
                }

                System.out.println("Enter the userName  ");
                String username = sc.nextLine();
                System.out.println("Enter the Password");
                String password = sc.nextLine();
                UserInterface user=null;

                int userHasLogin=Utilities.login(users,username,password);
                if(userHasLogin==-1){
                    System.out.println("Created the New User ");
                    user=new User(username,password);
                    for (int i = 0; i < users.length; i++) {
                        if(users[i]==null){
                            users[i]=user;
                            userHasLogin=i;
                            break;
                        }
                    }
                }
             else   if(userHasLogin==-2){
                    System.out.println("Invalid Credintials ");
                    continue;
                }
             else {
                    System.out.println("Welcome Back " + username );
                    user = users[userHasLogin];
                }








        int choice = 0;



        while (choice != 5) {

            ContactInterface contact = null;
            System.out.println("=============== Contact Manager =============");
            System.out.println("1.Add Contact ");
            System.out.println("2.View all Contacts ");
            System.out.println("3.Search Contact ");
            System.out.println("4.Delete Contact");
            System.out.println("5.Exit ");
            System.out.println("Enter the Choice: ");
            try {
                choice = new Integer(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter the correct Number ");
                continue;
            }

            // add contact
            if (choice == 1) {
                boolean addContact = false;
                String name = null;
                String number = null;

                while (!addContact) {
                    System.out.println("Enter the  Name: ");
                    try {
                        name = sc.nextLine();
                        if (name.isEmpty()) {
                            throw new Exception();
                        }
                    } catch (Exception e) {

                        System.out.println("Enter the  Corrrect name");
                        continue;

                    }

                    System.out.println("Enter the phoneNumber: ");
                    try {
                        number = sc.nextLine();
                        if (name.isEmpty()) {
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        System.out.println("Enter the  Corrrect name");
                        continue;
                    }
                    contact = new Contact(name, number);
                    for (int i = 0; i < user.getContacts().length; i++) {
                        if (user.getContacts()[i] == null) {
                            user.getContacts()[i] = contact;
                            break;
                        }
                    }

                    for (int i = 0; i < user.getContacts().length; i++) {
                        if (user.getContacts()[i] != null) {

                            System.out.println("Name " + user.getContacts()[i].getName());
                            System.out.println("PhoneNumber " + user.getContacts()[i].getNumber());
                        }
                    }


//                    System.out.println("Name: " + contact.getName());
//                    System.out.println("Phone: " + contact.getNumber());


                    System.out.println("If you want new Contact [enter] or exit [yes]   ");
                    String exit = sc.nextLine();
                    if (exit.equals("yes")) {
                        addContact = true;
                    }
                }

            } else if (choice == 2) {
                boolean showContact=false;
                while(!showContact){
                System.out.println("======== Contacts ========");
                ContactInterface[] contacts = user.getContacts();
                boolean empty = true;

                for (int i = 0; i < user.getContacts().length; i++) {
                    if (user.getContacts()[i] != null) {
                        System.out.print(i+1+"] Name:" + user.getContacts()[i].getName() + " ");
                        System.out.println("PhoneNumber:" + user.getContacts()[i].getNumber());
                        empty = false;
                    }

                }
                if (empty) {
                    System.out.println("No contacts found.");
                }

                    System.out.println("If you want to exit [yes] continue [enter] ");
                String showContactExit=sc.nextLine();
                if(showContactExit.equals("yes")){
                    showContact=true;
                }

                }
            } else if (choice == 3) {
                boolean update=false;
                int updateChoice=0;
                int updateChoices=0;
                String newName=null;
                String newNumber=null;
                boolean ableToUpdateContact=false;
                while(!update) {
                    System.out.println("===== Update ======");
                    for (int i = 0; i < user.getContacts().length; i++) {
                        if(user.getContacts()[i]!=null){
                            System.out.print(i+1+"] Name:" + user.getContacts()[i].getName() + " ");
                            System.out.println("PhoneNumber:" + user.getContacts()[i].getNumber());
                            ableToUpdateContact=true;
                        }
                    }
                    if(ableToUpdateContact){
                    System.out.println("Pick Which contact you want to update ");
                    boolean updateNumber=false;
                    while(!updateNumber) {

                        try {
                            updateChoices = new Integer(sc.nextLine());
                            if (updateChoices <= 0 || updateChoices > user.getContacts().length) {
                                throw new Exception();
                            }
                        } catch (Exception e) {
                            System.out.println("Enter the correct option ");
                            continue;
                        }
                        updateNumber=true;
                    }



                    System.out.println("1.Update Name");
                    System.out.println("2.Update Number");
                    boolean nameOrNumber=false;
                    while (!nameOrNumber) {

                        try {
                            updateChoice = new Integer(sc.nextLine());
                            if (updateChoice <= 0 || updateChoice > 2) {
                                throw new Exception();
                            }
                        } catch (Exception e) {

                            System.out.println("Enter the  Corrrect number");
                            continue;

                        }
                        nameOrNumber=true;
                    }
                    if(updateChoice==1){
                        System.out.println("Enter  the New Name ");
                         newName=sc.nextLine();
                        user.getContacts()[updateChoices-1].setName(newName);
                    }
                    if(updateChoice==2){
                        System.out.println("Enter the New Number ");
                         newNumber=sc.nextLine();
                        user.getContacts()[updateChoices-1].setNumber(newNumber);
                    }
                    System.out.println(" Contact is Updated ");
                    System.out.println();

                    System.out.println("If you want to exit [yes] continue [enter] ");
                    String updateContactExit=sc.nextLine();
                    if(updateContactExit.equals("yes")){
                        update=true;
                    }



                }
                    if(ableToUpdateContact==false){
                        System.out.println("Not her a contact to update");
                        update=true;
                    }
                }


            } else if (choice == 4) {
                System.out.println("===== Delete ======");
                boolean deleteFlag=false;
                while(!deleteFlag) {
                    for (int i = 0; i < user.getContacts().length; i++) {
                        if (user.getContacts()[i] != null) {
                            System.out.print(i + 1 + "] Name:" + user.getContacts()[i].getName() + " ");
                            System.out.println("PhoneNumber :" + user.getContacts()[i].getNumber());
                        }
                    }
                    System.out.println("Pick Which contact you want to Delete ");
                    int deleteChoice = 0;

                    try{
                        deleteChoice = new  Integer(sc.nextLine());

                        if(deleteChoice <= 0 || deleteChoice > user.getContacts().length){
                            throw new Exception();
                        }

                    }catch(Exception e){
                        System.out.println("Enter correct number");
                        continue;
                    }


                    user.getContacts()[deleteChoice - 1] = null;
                    for (int i = 0; i < user.getContacts().length; i++) {
                        if (user.getContacts()[i] == null) {
                            for (int j = i + 1; j < user.getContacts().length; j++) {
                                if (user.getContacts()[j] != null) {
                                    ContactInterface tempContact = user.getContacts()[j];
                                    user.getContacts()[j] = user.getContacts()[i];
                                    user.getContacts()[i] = tempContact;
                                    break;
                                }
                            }
                        }
                    }
                    System.out.println("Contact Deleted Successfully");
                    System.out.println();
                    System.out.println("If you want to exit [yes] continue [enter] ");
                    String deleteContactExit=sc.nextLine();
                    if(deleteContactExit.equals("yes")){
                        deleteFlag=true;
                    }

                }


            } else if (choice == 5) {
                System.out.println("Exit ");
                break;

            } else {
                System.out.println("Enter the correct number ");
            }


        }
    }
    }
}
}