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
    private Byte activite;
    private String horaire;
    private String logicielUtilise;
    private String retrocession;
    private Byte secretariat;
    private String dispoSec;
    private String typePatient;
    private String spec;
    private String description;
    private String carteProFilename;

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
    @Column(name = "activite", nullable = true)
    public Byte getActivite() {
        return activite;
    }

    public void setActivite(Byte activite) {
        this.activite = activite;
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
    @Column(name = "secretariat", nullable = true)
    public Byte getSecretariat() {
        return secretariat;
    }

    public void setSecretariat(Byte secretariat) {
        this.secretariat = secretariat;
    }

    @Basic
    @Column(name = "dispo_sec", nullable = true, length = 255)
    public String getDispoSec() {
        return dispoSec;
    }

    public void setDispoSec(String dispoSec) {
        this.dispoSec = dispoSec;
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
    @Column(name = "spec", nullable = true, length = 255)
    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 4096)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "carte_pro_filename", nullable = true, length = 255)
    public String getCarteProFilename() {
        return carteProFilename;
    }

    public void setCarteProFilename(String carteProFilename) {
        this.carteProFilename = carteProFilename;
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
        if (activite != null ? !activite.equals(offre.activite) : offre.activite != null) return false;
        if (horaire != null ? !horaire.equals(offre.horaire) : offre.horaire != null) return false;
        if (logicielUtilise != null ? !logicielUtilise.equals(offre.logicielUtilise) : offre.logicielUtilise != null)
            return false;
        if (retrocession != null ? !retrocession.equals(offre.retrocession) : offre.retrocession != null) return false;
        if (secretariat != null ? !secretariat.equals(offre.secretariat) : offre.secretariat != null) return false;
        if (dispoSec != null ? !dispoSec.equals(offre.dispoSec) : offre.dispoSec != null) return false;
        if (typePatient != null ? !typePatient.equals(offre.typePatient) : offre.typePatient != null) return false;
        if (spec != null ? !spec.equals(offre.spec) : offre.spec != null) return false;
        if (description != null ? !description.equals(offre.description) : offre.description != null) return false;
        if (carteProFilename != null ? !carteProFilename.equals(offre.carteProFilename) : offre.carteProFilename != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOffre;
        result = 31 * result + (typeOffre != null ? typeOffre.hashCode() : 0);
        result = 31 * result + (visiteDomicile != null ? visiteDomicile.hashCode() : 0);
        result = 31 * result + (activite != null ? activite.hashCode() : 0);
        result = 31 * result + (horaire != null ? horaire.hashCode() : 0);
        result = 31 * result + (logicielUtilise != null ? logicielUtilise.hashCode() : 0);
        result = 31 * result + (retrocession != null ? retrocession.hashCode() : 0);
        result = 31 * result + (secretariat != null ? secretariat.hashCode() : 0);
        result = 31 * result + (dispoSec != null ? dispoSec.hashCode() : 0);
        result = 31 * result + (typePatient != null ? typePatient.hashCode() : 0);
        result = 31 * result + (spec != null ? spec.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (carteProFilename != null ? carteProFilename.hashCode() : 0);
        return result;
    }
}
