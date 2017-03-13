package by.IvkoS.db.service;

import by.IvkoS.db.dao.ClientDao;
import by.IvkoS.db.entity.clients.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    public static final Logger loger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    ClientDao clientDao;

    @Override
    @Transactional
    public Client addClient(Client client) {
        return this.clientDao.create(client);
    }

    @Override
    @Transactional
    public Client getClient(int id) {
        return this.clientDao.read(id);
    }

    @Override
    @Transactional
    public void removeClient(Client client) {
        clientDao.delete(client);
    }

    @Override
    @Transactional
    public Client updateClient(Client client) {
        return this.clientDao.update(client);
    }
}
