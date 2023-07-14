package entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "humans")
public class Human {

    //    Поля ******************************************************
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "humanIddGenerator")
    @SequenceGenerator(name = "humanIdGenerator", sequenceName = "human_id_sequence", initialValue = 24, allocationSize = 1)
    @Column(name = "human_id")
    private int humanId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "otchestvo")
    private String otchestvo;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "age")
    private int age;

// Для избежания дублирования колонок в Human, связь c Client and Employee - Uni-directional
    //  Связи с другими таблицами **************************************
//    @OneToOne(mappedBy = "humanInfo")
//    private Client client;
//
//    @OneToOne(mappedBy = "humanInfo")
//    private Employee employee;

    public Human() {
    }

    public Human(String name, String surname, String otchestvo, String phoneNumber, String email, int age) {
        this.name = name;
        this.surname = surname;
        this.otchestvo = otchestvo;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
    }

    public int getHumanId() {
        return humanId;
    }

    public void setHumanId(int humanId) {
        this.humanId = humanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public Client getClient() {
//        return client;
//    }
//
//    public void setClient(Client client) {
//        this.client = client;
//    }
//
//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }

    @Override
    public String toString() {
        return "Human{" +
                "humanId=" + humanId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", otchestvo='" + otchestvo + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
