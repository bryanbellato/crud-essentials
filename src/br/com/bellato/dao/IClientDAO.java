/**
 * @Author: Bryan Bellato
 */

package br.com.bellato.dao;

import br.com.bellato.domain.Client;
import java.util.Collection;

public interface IClientDAO {
    public boolean register(Client client);
    public Client search(Long cpf);
    public void update(Client client);
    public void remove(Long cpf);
    public Collection<Client> searchAll();
}
