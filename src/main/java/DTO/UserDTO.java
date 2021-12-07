/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author hoang
 */
public class UserDTO {
    private int id;
    private String userlogin;
    private String userpass;
    private String username;

    public UserDTO() {
    }

    public UserDTO(int id, String userlogin, String userpass, String username) {
        this.id = id;
        this.userlogin = userlogin;
        this.userpass = userpass;
        this.username = username;
    }
    //Getter
    public int getId() {
        return id;
    }

    public String getUserlogin() {
        return userlogin;
    }

    public String getUserpass() {
        return userpass;
    }

    public String getUsername() {
        return username;
    }
    
    //Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setUserlogin(String userlogin) {
        this.userlogin = userlogin;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
