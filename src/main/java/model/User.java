package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    private User() {}
    @Id @GeneratedValue
    private long id;
    private String email;
    private String name;
    private String  surname;
    private int age;
    private boolean isActive;
    private boolean sex;
    private UserDetails userDetails;
    private AccountLogger accountLogger;
    private Salary salary;
    private PhoneDetails phoneDetails;


    public User(String email, String name, String surname, int age, boolean isActive, boolean sex, UserDetails userDetails, AccountLogger accountLogger, Salary salary, PhoneDetails phoneDetails) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.isActive = isActive;
        this.sex = sex;
        this.userDetails = userDetails;
        this.accountLogger = accountLogger;
        this.salary = salary;
        this.phoneDetails = phoneDetails;
    }

    public long getId() { return id;}

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isSex() {
        return sex;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }



    @Override
    public String toString() {
        return "User{" + "id=" + getId() + '\'' +
                "email='" + getEmail() + '\'' +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", isActive=" + isActive() +
                ", sex=" + isSex() +
                ", userDetails=" + getUserDetails() +
                ", accountLogger=" + accountLogger.getCreateDate() +
                ", salary=" + salary.getAmount() +
                '}';
     }
}