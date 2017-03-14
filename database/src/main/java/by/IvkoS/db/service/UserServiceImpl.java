package by.IvkoS.db.service;

import by.IvkoS.db.dao.ClientDao;
import by.IvkoS.db.entity.clients.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    ClientDao clientDao;

    @Override
    @Transactional
    public Client addClient(Client client) {
        logger.info("Client add :" + client);
        return this.clientDao.create(client);
    }

    @Override
    @Transactional
    public Client getClient(int id) {
        logger.info("Client get with id :" + id);
        return this.clientDao.read(id);
    }

    @Override
    @Transactional
    public Client removeClient(Client client) {
        logger.info("Client remove :" + client);
        return clientDao.delete(client);
    }

    @Override
    @Transactional
    public Client updateClient(Client client) {
        logger.info("Client update :" + client);
        return this.clientDao.update(client);
    }

    @Override
    public List<Client> getClientList() {
        return this.clientDao.readList();
    }

    @Override
    public Client removeClientById(int id) {
        return this.clientDao.deleteById(id);
    }
}
