package helper;

import app.LoginApp;

public class checkSession {
    public static String Id;
    public static String name;
    public static String role;

    public static String getId() {
        return Id;
    }

    public static void setId(String Id) {
        checkSession.Id = Id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        checkSession.name = name;
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        checkSession.role = role;
    }
    
    public static boolean isLogin(){
        if(checkSession.getId() == null){
            LoginApp loginApp = new LoginApp();
            loginApp.setVisible(true);
            return false;
        }
        return true;
    }
   
}
