package ContactNumber;

public class Utilities {
    public static int login(UserInterface[] arr,String userName,String password){
        if(arr[0]!=null){
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]!=null){
                if(arr[i].getUserName().equals(userName)){
                    if(arr[i].getPassword().equals(password)){
                        return i;
                    }
                    else {
                        return -2;
                    }
                }
                }
            }
        }




        return -1;

    }
}
