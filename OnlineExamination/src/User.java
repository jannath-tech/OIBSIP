public class User {
    private String username;
    private String password;
    private String name;

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public boolean login(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }

    public void updateProfile(String newName) {
        this.name = newName;
        System.out.println("Profile Updated Successfully!");
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Password Changed Successfully!");
    }

    public String getName() {
        return name;
    }
}
