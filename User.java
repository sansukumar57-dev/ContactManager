package ContactNumber;

public class User implements UserInterface {
    private  String userName;
    private String password;
    public  User(String userName,String password){

        this.userName = userName;
        this.password = password;
    }


  private ContactInterface[] contacts=new Contact[10];



    public String getUserName() {
        return userName;
    }


    public String getPassword() {
        return password;
    }


    public ContactInterface[] getContacts() {
        return contacts;
    }

    public void setContacts(ContactInterface[] contacts) {
        this.contacts = contacts;
    }
}
