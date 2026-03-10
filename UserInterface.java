package ContactNumber;

public interface UserInterface {
    public ContactInterface[] getContacts();
    public String getUserName();
    public String getPassword();
    public void setContacts(ContactInterface[] contacts) ;
}
