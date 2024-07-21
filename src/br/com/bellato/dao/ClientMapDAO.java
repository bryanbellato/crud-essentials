/**
 * @Author: Bryan Bellato
 */

package br.com.bellato.dao;

import br.com.bellato.domain.Client;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientMapDAO implements IClientDAO {

    private Map <Long, Client> map;
    public ClientMapDAO() {this.map = new HashMap<>();}

    @Override
    public boolean register(Client client) {
        if (this.map.containsKey(client.getCpf())) {
            return false;
        }
        this.map.put(client.getCpf(), client);
        return true;
    }

    @Override
    public Client search(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public void update(Client client) {
        Client clientRegistered = this.map.get(client.getCpf());
        if (clientRegistered != null) {
            clientRegistered.setName(client.getName());
            clientRegistered.setPhone_number(client.getPhone_number());
            clientRegistered.setAddress(client.getAddress());
            clientRegistered.setCity(client.getCity());
            clientRegistered.setState(client.getState());
        }
    }

    @Override
    public void remove(Long cpf) {
        Client clientRegistered = this.map.get(cpf);
        if (clientRegistered != null) {
            this.map.remove(clientRegistered.getCpf());
        }
    }

    @Override
    public Collection<Client> searchAll() {
        return this.map.values();
    }
}
