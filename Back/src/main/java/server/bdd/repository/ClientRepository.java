package server.bdd.repository;
import org.springframework.data.repository.Repository;
import server.bdd.model.Client;

import java.util.List;

public interface ClientRepository extends Repository<Client,Integer> {
        void save(Client e);
        List<Client> getAllByIdClientIsNotNull();
        boolean existsByNumTel(String numTel);

}
