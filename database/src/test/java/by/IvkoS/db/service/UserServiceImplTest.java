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
        Client client = new Client("test","test","test","test",
                new Address(1,"test","test","test","test"));
        userService.addClient(client);
    }

    @Test
    public void getClient() throws Exception {
        Client client = new Client("test","test","test","test",
                new Address(1,"test","test","test","test"));
        userService.addClient(client);
        userService.getClient(client.getId());
    }

    @Test
    public void removeClient() throws Exception {
        Client client = new Client("test","test","test","test",
                new Address(1,"test","test","test","test"));
        userService.addClient(client);
        Client client1 = userService.getClient(client.getId());
        userService.removeClient(client1);
    }

    @Test
    public void updateClient() throws Exception {
        Client client = new Client("test","test","test","test",
                new Address(1,"test","test","test","test"));
        userService.addClient(client);
        Client client1 = userService.getClient(client.getId());
        client1.setAge(11);
        userService.updateClient(client1);
    }

}