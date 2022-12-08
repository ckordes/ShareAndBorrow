package com.ckordes.ShareAndBorrow.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserCredentialsModifications {

    @NotBlank (message = "Password field may not be empty!")
    @Size(min = 8, max = 60, message = "Length of the password must be between 8 and 60 characters.")
    private String password;
    @NotBlank (message = "Reentered password field may not be empty!")
    @Size(min = 8, max = 60, message = "Length of the password must be between 8 and 60 characters.")
    private String password2;
    @NotBlank (message = "E-mail field may not be empty!")
    @Email
    private String email;

    public UserCredentialsModifications(String password, String password2, String email) {
        this.password = password;
        this.password2 = password2;
        this.email = email;
    }

    public Boolean checkPasswordsEqual(){
        return password.equals(password2);
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
