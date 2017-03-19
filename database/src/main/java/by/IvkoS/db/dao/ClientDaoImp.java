package by.IvkoS.db.dao;

import by.IvkoS.db.entity.clients.Client;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class ClientDaoImp extends GenericDaoJpaImpl<Client, Integer> implements ClientDao {

    private final int INDEX_FIRST_CLIENT_AT_LIST = 0;

    @Override
    public Client findByLogin(String login) {
        List<Client> client = (List<Client>) super.hibernateTemplate
                .findByNamedParam("from Client as client where client.login=:login", "login", new Object[]{login});
        return (client.size() != 0) ? client.get(INDEX_FIRST_CLIENT_AT_LIST) : Client.EMPTY_CLIENT;
    }
}
