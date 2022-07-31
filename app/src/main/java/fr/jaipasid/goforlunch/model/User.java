package fr.jaipasid.goforlunch.model;

public class User {

    private String name;
    private String firestName;
    private String email;
    private String password;


    /** Constructor
     *
     * @param email
     * @param password
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


    /** Getter / Setter
     *
     * @return
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirestName() {
        return firestName;
    }

    public void setFirestName(String firestName) {
        this.firestName = firestName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
