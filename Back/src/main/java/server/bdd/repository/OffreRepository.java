package server.bdd.repository;
import org.springframework.data.repository.Repository;
import server.bdd.model.Offre;

import java.util.List;

public interface OffreRepository extends Repository<Offre,Integer> {
    void save(Offre o);
    List<Offre> getAllByIdOffreIsNotNull();
    boolean existsByIdOffre(int id);
    Offre findByIdOffre(int id);
    List<Offre> getAllByIdClient(int id);
    void deleteByIdOffre(int id);


}