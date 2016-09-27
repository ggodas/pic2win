package br.com.promoscan;

import org.springframework.data.annotation.Id;

/**
 * Created by georgegodas on 01/09/16.
 */
public class Customer {
    @Id
    private String id;
    private String name;
    private String lastName;
    private String birthdayDate;
    private String email;
    private String phone;
    private String documentId;
    private String facebookToken;
    private String password;

    public Customer() {
    }

    public Customer(String id, String name, String lastName, String birthdayDate, String email, String phone, String documentId, String facebookToken, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthdayDate = birthdayDate;
        this.email = email;
        this.phone = phone;
        this.documentId = documentId;
        this.facebookToken = facebookToken;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getFacebookToken() {
        return facebookToken;
    }

    public void setFacebookToken(String facebookToken) {
        this.facebookToken = facebookToken;
    }

    public String getPassword() {
        return password;
    }

}
