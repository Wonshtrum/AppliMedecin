package server.bdd.repository;
import org.springframework.data.repository.Repository;
import server.bdd.model.Client;

import java.util.List;

public interface ClientRepository extends Repository<Client,Integer> {
        void save(Client e);
        List<Client> getAllByIdClientIsNotNull();
        boolean existsByNumTel(String numTel);
        Client findByNumTel(String numTel);
        boolean existsByIdClient(int id);
        Client findByIdClient(int id);
        Client findByMdpAndMail(String mdp, String mail);
        boolean existsByMdpAndMail(String mdp, String mail);

}
