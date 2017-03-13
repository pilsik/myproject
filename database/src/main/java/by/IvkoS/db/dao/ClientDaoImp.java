package by.IvkoS.db.dao;

import by.IvkoS.db.entity.clients.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class ClientDaoImp extends GenericDaoJpaImpl<Client, Integer> implements ClientDao {

}
