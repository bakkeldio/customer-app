package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String firstName;
    private String lastName;
    private String emailAddress;
    private String jobTitle;
    private String mobilePhone;
    private String city;
    private String webPage;
    private String customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getCity() {
        return city;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
