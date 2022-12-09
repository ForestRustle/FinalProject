package com.example.springsecurityapplication.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Логин не может быть пустым")
    @Size(min = 5, max = 50, message = "Логин должен быть от 5 до 50 символов")
    @Column(name = "login")
    private String login;

    @NotEmpty(message = "Пароль не может быть пустым")
    @Column(name = "password")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$", message = "Пароль должен содержать не менее 6 символов, хотя бы одну цифру, спец символ, букву в верхнем и нижнем регистре ")
    private String password;

    @Column(name = "role")
    private String role;

    @NotEmpty(message = "Фамилия не может быть пустой")
    @Size(min = 2, max = 30, message = "Фамилия должна быть в диапазоне от 2 до 30 символов")
    @Column(name = "lastname", length = 30, nullable = false, unique = false, columnDefinition = "text")
    private String lastname;

    @NotEmpty(message = "Имя не может быть пустым")
    @Size(min = 2, max = 30, message = "Имя должно быть в диапазоне от 2 до 30 символов")
    @Column(name = "firstname", length = 30, nullable = false, unique = false, columnDefinition = "text")
    private String firstname;

    @Column(name = "patronymic", length = 30, nullable = true, unique = false, columnDefinition = "text")
    private String patronymic;

    @NotEmpty(message = "Дата рождения не может быть пустой")
    //@Past(message = "Дата рождения не может быть больше текущей даты")
    @Pattern(regexp = "(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d\\d)", message = "Дата рождения " +
            "должна быть в формате 01.01.1900")
    @Column(name = "birthday", length = 10, nullable = false, unique = false, columnDefinition = "text")
    private String birthday;

    @NotEmpty(message = "Email пользователя не может быть пустым")
    @Email(message = "Вы ввели не email")
    @Column(name = "email", length = 40, nullable = false, unique = true, columnDefinition = "text")
    private String email;

    @NotEmpty(message = "Номер телефона не может быть пустым")
    @Pattern(regexp = "^((\\+7|7|8)+([0-9]){10})$", message = "Норме телефона должен быть в формате +7/7/89159058431")
    @Column(name = "phoneNumber", length = 12, nullable = false, unique = true, columnDefinition = "text")
    private String phoneNumber;

    private LocalDateTime dateTimeOfCreated;

    // Будет заполняться дата и время при создании объекта класса
    @PrePersist
    private void init(){
        dateTimeOfCreated = LocalDateTime.now();
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public Person(String login, String password, String role, String lastname, String firstname,
                  String patronymic, String birthday, String email, String phoneNumber) {

        this.login = login;
        this.password = password;
        this.role = role;
        this.lastname = lastname;
        this.firstname = firstname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Person() {
    }

    public LocalDateTime getDateTimeOfCreated() {
        return dateTimeOfCreated;
    }

    public void setDateTimeOfCreated(LocalDateTime dateTimeOfCreated) {

        this.dateTimeOfCreated = dateTimeOfCreated;
    }


}




