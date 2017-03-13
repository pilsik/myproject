package by.IvkoS.db.service;

import by.IvkoS.db.entity.clients.Address;
import by.IvkoS.db.entity.clients.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context-db.xml")
@TransactionConfiguration(transactionManager="txManager", defaultRollback = true)
@Transactional
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void addClient() throws Exception {
        Address address = new Address(1,"test","test","test","test");
        Address address2 = new Address(1,"test","test","test","test");
        Set<Address> addressSet = new HashSet<>();
        addressSet.add(address);
        addressSet.add(address2);
        Client client = new Client("test","test","test","test",
               addressSet,"test",23);
        userService.addClient(client);
    }

    @Test
    public void getClient() throws Exception {
        Address address = new Address(1,"test","test","test","test");
        Address address2 = new Address(1,"test","test","test","test");
        Set<Address> addressSet = new HashSet<>();
        addressSet.add(address);
        addressSet.add(address2);
        Client client = new Client("test","test","test","test",
                addressSet,"test",23);
        userService.addClient(client);
        userService.getClient(client.getId());
    }

    @Test
    public void removeClient() throws Exception {
        Address address = new Address(1,"test","test","test","test");
        Address address2 = new Address(1,"test","test","test","test");
        Set<Address> addressSet = new HashSet<>();
        addressSet.add(address);
        addressSet.add(address2);
        Client client = new Client("test","test","test","test",
                addressSet,"test",23);
        userService.addClient(client);
        userService.removeClient(userService.getClient(client.getId()));
    }

    @Test
    public void updateClient() throws Exception {
        Address address = new Address(1,"test","test","test","test");
        Address address2 = new Address(1,"test","test","test","test");
        Set<Address> addressSet = new HashSet<>();
        addressSet.add(address);
        addressSet.add(address2);
        Client client = new Client("test","test","test","test",
                addressSet,"test",23);
        userService.addClient(client);
        Client client1 = userService.getClient(client.getId());
        client1.setAge(30);
        userService.updateClient(client1);
    }

}