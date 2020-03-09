package server.bdd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Postulat {
    private int idPostulat;

    @Id
    @Column(name = "id_postulat", nullable = false)
    public int getIdPostulat() {
        return idPostulat;
    }

    public void setIdPostulat(int idPostulat) {
        this.idPostulat = idPostulat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Postulat postulat = (Postulat) o;

        if (idPostulat != postulat.idPostulat) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idPostulat;
    }
}
