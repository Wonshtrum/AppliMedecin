package server.bdd.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Postulat {
    private int idPostulat;
    private int idOffre;
    private int idRemplacant;

    @Id
    @Column(name = "id_postulat", nullable = false)
    public int getIdPostulat() {
        return idPostulat;
    }

    public void setIdPostulat(int idPostulat) {
        this.idPostulat = idPostulat;
    }

    @Basic
    @Column(name = "id_offre", nullable = false)
    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    @Basic
    @Column(name = "id_remplacant", nullable = false)
    public int getIdRemplacant() {
        return idRemplacant;
    }

    public void setIdRemplacant(int idRemplacant) {
        this.idRemplacant = idRemplacant;
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
