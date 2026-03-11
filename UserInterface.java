package ContactNumber;

import java.util.Scanner;

public interface UserInterface {
    public ContactInterface[] getContacts();
    public String getUserName();
    public String getPassword();
    public void setContacts(ContactInterface[] contacts) ;
    public boolean createContact(String name,Integer number);
    public boolean diaplayContact();
    public boolean updateContact(int updateChoices, Scanner sc);
    public void deleteContact(int deleteChoice);
    public boolean searchContact(String name,Integer number);
}
