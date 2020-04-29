package server.bdd.repository;

import org.springframework.data.repository.Repository;
import server.bdd.model.Remplacant;

import java.util.List;

public interface RemplacantRepository extends Repository<Remplacant,Integer> {
    void save(Remplacant r);
    boolean existsByIdRemplacant(int id);
    Remplacant findByIdRemplacant(int id);
    Remplacant findByMdpAndMail(String mdp, String mail);
    boolean existsByMdpAndMail(String mdp, String mail);
    void deleteByIdRemplacant(int id);
    List<Remplacant> getDistinctByMdpIsNull();
    boolean existsByMail(String mail);
}
