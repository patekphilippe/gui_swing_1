package tb.soft;

import java.util.HashMap;

public class userDataBase {
    public HashMap<String, String> dataBase = new HashMap<String,String>();
    String correctPassword;
    MainWindow window;
    public void addUsers() {
        dataBase.put("test1", "haslo1");
        dataBase.put("test2", "haslo2");
        dataBase.put("test3", "haslo3");
        dataBase.put("test4", "haslo1");
    }
    public boolean checkIfUserExists(String userName, String currentPassword) {
        correctPassword = getPassword(userName);
//        System.out.println(correctPassword);
        if(correctPassword != null && correctPassword.equals(currentPassword))
        {
            return true;
        }
        return false;
    }

    public String getPassword(String userName) {
        if(dataBase.containsKey(userName)) {
            return dataBase.get(userName);
        }
        return null;
    }
}


