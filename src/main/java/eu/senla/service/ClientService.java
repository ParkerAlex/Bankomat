package eu.senla.service;

import eu.senla.api.dao.IClientDao;
import eu.senla.api.service.IClientService;
import eu.senla.dao.ClientDao;

public class ClientService implements IClientService {

    private IClientDao clientDao;

    public ClientService(IClientDao clientDao) {
        this.clientDao = clientDao;
    }
}
