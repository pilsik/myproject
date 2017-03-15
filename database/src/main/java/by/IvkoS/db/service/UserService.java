package by.IvkoS.db.service;


import by.IvkoS.db.entity.clients.Client;

import java.util.List;

public interface UserService {

    Client addClient(Client client);

    Client getClientById(int id);

    Client findClientByLogin(String login);

    Client removeClient(Client client);

    Client updateClient(Client client);

    List<Client> getClientList();

    Client removeClientById(int id);


}
