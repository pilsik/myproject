package by.IvkoS.db.service;


import by.IvkoS.db.entity.clients.Client;

import java.util.List;

public interface UserService {

    Client addClient(Client client);

    Client getClient(int id);

    Client removeClient(Client client);

    Client updateClient(Client client);

    List<Client> getClientList();

    Client removeClientById(int id);
}
