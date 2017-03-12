package by.IvkoS.db.dao;

import by.IvkoS.db.models.clients.Address;
import by.IvkoS.db.models.clients.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context-db.xml"})
@TransactionConfiguration(defaultRollback = true, transactionManager = "txManager")
public class ClientDAOImplTest {

    @Autowired
    GenericDao clientDAO;

    @Test
    public void find() throws Exception {
    }

    @Test
    public void findAll() throws Exception {

    }

    @Test
    public void remove() throws Exception {

    }

    @Test
    public void removeById() throws Exception {

    }

    @Test
    public void save() throws Exception {
        Client client = new Client("test", "test", "test", "test",
                new Address(1, "test", "test", "test", "test"));
        clientDAO.create(client);
        Client client1 = (Client) clientDAO.read((Integer) (11));
        System.out.println(client1.toString());
        clientDAO.delete(client1);
    }

}