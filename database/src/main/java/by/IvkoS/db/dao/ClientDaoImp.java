package by.IvkoS.db.dao;

import by.IvkoS.db.models.clients.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class ClientDaoImp extends GenericDaoJpaImpl<Client,Integer> implements ClientDao{

}
