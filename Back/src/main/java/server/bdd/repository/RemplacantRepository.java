package server.bdd.repository;

import org.springframework.data.repository.Repository;
import server.bdd.model.Remplacant;

public interface RemplacantRepository extends Repository<Remplacant,Integer> {
    void save(Remplacant r);
}
