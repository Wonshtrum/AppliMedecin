package server.bdd.repository;
import org.springframework.data.repository.Repository;
import server.bdd.model.Postulat;

import java.util.List;

public interface PostulatRepository extends Repository<Postulat,Integer> {
    void save(Postulat p);
    boolean existsByIdPostulat(int id);
    Postulat findByIdPostulat(int id);
    List<Postulat> getAllByIdRemplacant(int id);

}
