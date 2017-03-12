package by.IvkoS.db.models.clients;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idclient")
    private Integer id;

    @Column
    @NotNull
    private String login;

    @Column
    @NotNull
    private String password;

    @Column
    @NotNull
    private String lastname;

    @Column
    @NotNull
    private String firstname;

    @Column
    @NotNull
    private Address address;

    @Column
    private String gender;

    @Column
    private Integer age;

    public Client() {
    }

    public Client(String login, String password, String lastname, String firstname, Address address) {
        this.login = login;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
    }

    public Client(String login, String password, String lastname, String firstname, Address address, String gender, Integer age) {
        this(login, password, lastname, firstname, address);
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", address=" + address +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
