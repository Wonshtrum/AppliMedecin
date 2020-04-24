package server.bdd.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Offre {
    private int idOffre;
    private int idClient;
    private Short typeOffre;
    private Integer visiteDomicile;
    private Integer archivage;
    private String horaire;
    private String logicielUtilise;
    private String retrocession;
    private String typePatient;
    private String description;
    private String periode;

    @Id
    @Column(name = "id_offre", nullable = false)
    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    @Basic
    @Column(name = "id_client", nullable = false)
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "archivage", nullable = false)
    public int getArchivage() {
        return archivage;
    }

    public void setArchivage(int archivage) {
        this.archivage = archivage;
    }

    @Basic
    @Column(name = "type_offre", nullable = true)
    public Short getTypeOffre() {
        return typeOffre;
    }

    public void setTypeOffre(Short typeOffre) {
        this.typeOffre = typeOffre;
    }

    @Basic
    @Column(name = "visite_domicile", nullable = true)
    public Integer getVisiteDomicile() {
        return visiteDomicile;
    }

    public void setVisiteDomicile(Integer visiteDomicile) {
        this.visiteDomicile = visiteDomicile;
    }


    @Basic
    @Column(name = "horaire", nullable = true, length = 255)
    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    @Basic
    @Column(name = "logiciel_utilise", nullable = true, length = 255)
    public String getLogicielUtilise() {
        return logicielUtilise;
    }

    public void setLogicielUtilise(String logicielUtilise) {
        this.logicielUtilise = logicielUtilise;
    }

    @Basic
    @Column(name = "retrocession", nullable = true, length = 255)
    public String getRetrocession() {
        return retrocession;
    }

    public void setRetrocession(String retrocession) {
        this.retrocession = retrocession;
    }


    @Basic
    @Column(name = "periode", nullable = true, length = 255)
    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    @Basic
    @Column(name = "type_patient", nullable = true, length = 255)
    public String getTypePatient() {
        return typePatient;
    }

    public void setTypePatient(String typePatient) {
        this.typePatient = typePatient;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 4096)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Offre offre = (Offre) o;

        if (idOffre != offre.idOffre) return false;
        if (typeOffre != null ? !typeOffre.equals(offre.typeOffre) : offre.typeOffre != null) return false;
        if (visiteDomicile != null ? !visiteDomicile.equals(offre.visiteDomicile) : offre.visiteDomicile != null)
            return false;

        if (horaire != null ? !horaire.equals(offre.horaire) : offre.horaire != null) return false;
        if (logicielUtilise != null ? !logicielUtilise.equals(offre.logicielUtilise) : offre.logicielUtilise != null)
            return false;
        if (retrocession != null ? !retrocession.equals(offre.retrocession) : offre.retrocession != null) return false;
        if (periode != null ? !periode.equals(offre.periode) : offre.periode != null) return false;
        if (typePatient != null ? !typePatient.equals(offre.typePatient) : offre.typePatient != null) return false;
        if (description != null ? !description.equals(offre.description) : offre.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOffre;
        result = 31 * result + (typeOffre != null ? typeOffre.hashCode() : 0);
        result = 31 * result + (visiteDomicile != null ? visiteDomicile.hashCode() : 0);
        result = 31 * result + (horaire != null ? horaire.hashCode() : 0);
        result = 31 * result + (logicielUtilise != null ? logicielUtilise.hashCode() : 0);
        result = 31 * result + (retrocession != null ? retrocession.hashCode() : 0);
        result = 31 * result + (typePatient != null ? typePatient.hashCode() : 0);
        result = 31 * result + (periode != null ? periode.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
