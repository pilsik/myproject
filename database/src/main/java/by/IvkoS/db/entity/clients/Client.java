package by.IvkoS.db.entity.clients;


import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="client")
public class Client implements Serializable {

    public static final Client EMPTY_CLIENT = new Client();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idclient")
    private Integer id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String firstname;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "client_address", catalog = "webshoop", joinColumns = {
            @JoinColumn(name = "client_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "address_id",
                    nullable = false, updatable = false) })
    private Set<Address> addressSet = new HashSet<>();

   /* @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "houseNumber", column = @Column(name = "houseNumber")),
            @AttributeOverride(name = "streetAddress", column = @Column(name = "streetAddress")),
            @AttributeOverride(name = "city", column = @Column(name = "city")),
            @AttributeOverride(name = "state", column = @Column(name = "state")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "zipCode"))
    })
    private Address address;*/

    @Column
    private String gender;

    @Column
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Client() {
    }

    public Client(String login, String password, String lastname, String firstname, Set<Address> addressSet, String gender, Integer age) {
        this.login = login;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
        this.addressSet = addressSet;
        this.gender = gender;
        this.age = age;
    }

    public Set<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<Address> addressSet) {
        this.addressSet = addressSet;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", addressSet=" + addressSet +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
