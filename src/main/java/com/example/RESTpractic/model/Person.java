package com.example.RESTpractic.model;




import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @NotEmpty(message = "имя не должно быть пустым")
    @Size(min = 2, max = 30, message = "имя должно быть от 2 до 3 символов")
    private String name;
    @Column(name = "age")
    @Min(value = 0, message = "возраст не может быть меньше 0")
    @Max(value = 160, message = "возраст не может быть больше 160")
    private int age;
    @Column(name = "email")
    @Email(message = "неверный формат почты")
    @NotEmpty(message = "email не может быть пустым")
    private String email;


    public Person() {
    }

    public Person( String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}