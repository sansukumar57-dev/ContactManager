package ContactNumber;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        1.CLI Contact Manager
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
                    System.out.println("Invalid Credentials ");
                    continue;
                }
             else {
                    System.out.println("Welcome Back " + username );
                    user = users[userHasLogin];
                }
             int choice = 0;

             while (choice != 6) {

            ContactInterface contact = null;
            System.out.println("=============== Contact Manager =============");
            System.out.println("1. Add Contact ");
            System.out.println("2. View all Contacts ");
            System.out.println("3. Search Contacts ");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contacts");
            System.out.println("6. Exit ");
            System.out.println("Enter the Choice: ");
            try {
                choice = new Integer(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Enter the correct Number ");
                continue;
            }

            // add contact
            if (choice == 1) {
                boolean addContact = false;
                String name = null;
                Integer number = null;

                while (!addContact) {
                    System.out.println("Enter the  Name: ");
                    boolean nameCorrection=false;
                    while(!nameCorrection) {
                        try {
                            name = sc.nextLine();
                            if (name.isEmpty()) {
                                throw new Exception();
                            }
                        } catch (Exception e) {

                            System.out.println("Enter the  Correct name");
                            continue;

                        }
                        nameCorrection=true;
                    }

                    System.out.println("Enter the phoneNumber: ");
                    boolean numberCorrection=false;
                    while (!numberCorrection) {

                        try {
                            number = new Integer(sc.nextLine());

                        } catch (Exception e) {
                            System.out.println("Enter the  Correct PhoneNumber");
                            continue;
                        }
                        numberCorrection=true;
                    }

                    boolean createdContact=user.createContact(name,number);
                    if(createdContact==true){
                        System.out.println("Contact is created");
                    }
                   else {
                        System.out.println("Not here to create contact ");
                    }

//                    for (int i = 0; i < user.getContacts().length; i++) {
//                        if (user.getContacts()[i] != null) {
//
//                            System.out.println("Name " + user.getContacts()[i].getName());
//                            System.out.println("PhoneNumber " + user.getContacts()[i].getNumber());
//                        }
//                    }


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
                boolean empty = user.diaplayContact();

                if (empty==false) {
                    System.out.println("No contacts found To View.");
                }

                    System.out.println("If you want to exit [yes] continue [enter] ");
                String showContactExit=sc.nextLine();
                if(showContactExit.equals("yes")){
                    showContact=true;
                }

                }
            }else if (choice==3) {

                boolean search=false;
                String searchName=null;
                Integer searchNumbers=null;
                while(!search){
                    System.out.println("======= Search Contact =======");
                    System.out.println("1.Search Name ");
                    System.out.println("2.Number ");
                    int searchNumber=0;
                    boolean searched=false;
                    try {
                        searchNumber = new Integer(sc.nextLine());
                        if (searchNumber <= 0 || searchNumber > 2) {
                            throw new Exception();

                        }
                    } catch (Exception e) {
                        System.out.println("Enter the correct Number");
                        continue;
                    }
                    if(searchNumber==1){
                        System.out.println("Enter the Name: ");
                        searchName=sc.nextLine();
                        searched=user.searchContact(searchName,null);
                    }
                  else   if(searchNumber==2){
                        searchNumbers=new Integer(sc.nextLine());
                        searched=user.searchContact(null,searchNumbers);
                  }

                    if(searched==false)
                    {
                        System.out.println("No Contact Found");
                    }
                    System.out.println("If you want to exit [yes] continue [enter]");
                    String exit = sc.nextLine();

                    if(exit.equals("yes")){
                        search = true;
                    }
                }


            }

            else if (choice == 4) {
                boolean update=false;
                int updateChoice=0;
                int updateChoices=0;

                boolean ableToUpdateContact=false;
                while(!update) {
                    System.out.println("===== Update ======");
                     ableToUpdateContact = user.diaplayContact();

                    if (ableToUpdateContact==false) {
                        System.out.println("No contacts found To Update.");
                            update=true;

                    }
                    else
                    {
                    System.out.println("Pick Which contact you want to update ");
                    boolean updateNumber=false;
                    while(!updateNumber) {

                        try {
                            updateChoices = new Integer(sc.nextLine());
                            if (updateChoices <= 0 || updateChoices > user.getContacts().length||user.getContacts()[updateChoices-1]==null) {
                                throw new Exception();
                            }
                        } catch (Exception e) {
                            System.out.println("Enter the correct option ");
                            continue;
                        }
                        updateNumber=true;
                    }



                  boolean updated=user.updateContact(updateChoices,sc);
                    if(updated){
                        System.out.println("Contact is Updated ");
                    }
                    else if(updated==false){

                            System.out.println("No contact here to update");

                    }
                    System.out.println();

                    System.out.println("If you want to exit [yes] continue [enter] ");
                    String updateContactExit=sc.nextLine();
                    if(updateContactExit.equals("yes")){
                        update=true;
                    }



                }

                }


            } else if (choice == 5) {
                System.out.println("===== Delete ======");
                boolean deleteFlag=false;
                boolean deleteContact=false;
                while(!deleteFlag) {
                   deleteContact=user.diaplayContact();
                   if(deleteContact==false){
                       System.out.println("No contact Here to delete");
                       deleteFlag=true;
                       continue;
                   }

                    System.out.println("Pick Which contact you want to Delete ");
                    int deleteChoice = 0;

                    try{
                        deleteChoice = new  Integer(sc.nextLine());

                        if(deleteChoice <= 0 || deleteChoice > user.getContacts().length||user.getContacts()[deleteChoice-1]==null){
                            throw new Exception();
                        }

                    }catch(Exception e){
                        System.out.println("Enter correct number");
                        continue;
                    }
                    user.deleteContact(deleteChoice);
                    System.out.println();
                    System.out.println("If you want to exit [yes] continue [enter] ");
                    String deleteContactExit=sc.nextLine();
                    if(deleteContactExit.equals("yes")){
                        deleteFlag=true;
                    }

                }


            }  else if (choice == 6) {
                System.out.println("Exit ");
                flag=true;

            } else {
                System.out.println("Enter the correct number ");
            }


        }
    }
    }
}
}
/*




































 */