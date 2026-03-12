package ContactNumber;

import java.util.Scanner;

public class User implements UserInterface {
    private  String userName;
    private String password;
    public  User(String userName, String password){

        this.userName = userName;
        this.password = password;
    }


  private ContactInterface[] contacts=new Contact[10];



    public String getUserName() {
        return userName;
    }


    public String  getPassword() {
        return password;
    }


    public ContactInterface[] getContacts() {
        return contacts;
    }

    public void setContacts(ContactInterface[] contacts) {
        this.contacts = contacts;
    }
    public boolean createContact(String name,Integer number){
      ContactInterface  contact = new Contact(name, number);

        for (int i = 0; i <this.contacts.length; i++) {
            if (this.contacts[i] == null) {
                this.contacts[i] = contact;
               return  true;
            }
        }
        return false;
    }

    public boolean diaplayContact(){
        boolean found=false;
        for (int i = 0; i < this.contacts.length; i++) {
            if (this.contacts[i] != null) {
                System.out.print(i+1+"] Name:" + this.contacts[i].getName() + " ");
                System.out.println("PhoneNumber:" + this.contacts[i].getNumber());
                found=true;
            }

        }
        return found;

    }

    public boolean updateContact(int updateChoices, Scanner sc){
        String newName=null;
        Integer newNumber=null;
        int updateChoice=0;

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

                System.out.println("Enter the  Correct number");
                continue;

            }
            nameOrNumber=true;
        }
        if(updateChoice==1){
            System.out.println("Enter  the New Name ");
            newName=sc.nextLine();
            contacts[updateChoices-1].setName(newName);
            return true;
        }
      else  if(updateChoice==2){
            System.out.println("Enter the New Number ");
            newNumber=new Integer(sc.nextLine());
           contacts[updateChoices-1].setNumber(newNumber);
            return true;
        }
      return false;

    }


    public void deleteContact(int deleteChoice){
        this.contacts[deleteChoice - 1] = null;
        for (int i = 0; i < this.contacts.length; i++) {
            if (this.contacts[i] == null) {
                for (int j = i + 1; j < this.contacts.length; j++) {
                    if (this.contacts[i] != null) {
                        ContactInterface tempContact = this.contacts[j];
                        this.contacts[j] = this.contacts[i] ;
                        this.contacts[i] = tempContact;
                        break;
                    }
                }
            }
        }
        System.out.println("Contact Deleted Successfully");
    }

    public boolean searchContact(String name,Integer number){
        boolean searching=false;

        for (int i = 0; i < contacts.length; i++) {
            if(contacts[i]!=null)
            {
             if(contacts[i].getName().equals(name)|| contacts[i].getNumber().equals(number))
             {
                 System.out.println("===== Found ! =====");
    System.out.print(i+1+ "] Name:" + contacts[i].getName() );
    System.out.println(" PhoneNumber:" + contacts[i].getNumber());

    searching = true;
}
            }
        }


        return  searching;
    }










}
