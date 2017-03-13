package by.IvkoS.db.service;


import by.IvkoS.db.entity.clients.Client;

public interface UserService {

    Client addClient(Client client);

    Client getClient(int id);

    void removeClient(Client client);

    Client updateClient(Client client);

}
