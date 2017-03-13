package by.IvkoS.db.dao;

import by.IvkoS.db.entity.clients.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class ClientDaoImp extends GenericDaoJpaImpl<Client, Integer> implements ClientDao {

    public static final Logger loger = LoggerFactory.getLogger(ClientDaoImp.class);

    public ClientDaoImp() {
        super();
    }

    @Override
    public Client create(Client client) {
        loger.info("Client create: " + client);
        return super.create(client);
    }

    @Override
    public Client read(Integer id) {
        loger.info("Client read with id: " + id);
        return super.read(id);
    }

    @Override
    public Client update(Client client) {
        loger.info("Client update: " + client);
        return super.update(client);
    }

    @Override
    public void delete(Client client) {
        loger.info("Client delete: " + client);
        super.delete(client);
    }
}
