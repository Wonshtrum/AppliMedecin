package server.bdd.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Remplacant {
    private int idRemplacant;
    private String mail;
    private String numTel;
    private String dispo;
    private String zoneGeo;
    private Integer kmMax;
    private String spec;
    private String description;
    private String cvFilename;
    private String cartePro_filename;
    private String mdp;

    @Id
    @Column(name = "id_remplacant", nullable = false)
    public int getIdRemplacant() {
        return idRemplacant;
    }

    public void setIdRemplacant(int idRemplacant) {
        this.idRemplacant = idRemplacant;
    }

    @Basic
    @Column(name = "mail", nullable = true, length = 255)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "mdp", nullable = true, length = 255)
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Basic
    @Column(name = "num_tel", nullable = true, length = 10)
    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    @Basic
    @Column(name = "dispo", nullable = true, length = 255)
    public String getDispo() {
        return dispo;
    }

    public void setDispo(String dispo) {
        this.dispo = dispo;
    }

    @Basic
    @Column(name = "zone_geo", nullable = true, length = 255)
    public String getZoneGeo() {
        return zoneGeo;
    }

    public void setZoneGeo(String zoneGeo) {
        this.zoneGeo = zoneGeo;
    }

    @Basic
    @Column(name = "km_max", nullable = true)
    public Integer getKmMax() {
        return kmMax;
    }

    public void setKmMax(Integer kmMax) {
        this.kmMax = kmMax;
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
    @Column(name = "description", nullable = true, length = 4095)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "cv_filename", nullable = true, length = 255)
    public String getCvFilename() {
        return cvFilename;
    }

    public void setCvFilename(String cvFilename) {
        this.cvFilename = cvFilename;
    }

    @Basic
    @Column(name = "cartePro_filename", nullable = true, length = 255)
    public String getCartePro_filename() {
        return cartePro_filename;
    }

    public void setCartePro_filename(String carteProFilename) {
        this.cartePro_filename = cartePro_filename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Remplacant that = (Remplacant) o;

        if (idRemplacant != that.idRemplacant) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (numTel != null ? !numTel.equals(that.numTel) : that.numTel != null) return false;
        if (dispo != null ? !dispo.equals(that.dispo) : that.dispo != null) return false;
        if (zoneGeo != null ? !zoneGeo.equals(that.zoneGeo) : that.zoneGeo != null) return false;
        if (kmMax != null ? !kmMax.equals(that.kmMax) : that.kmMax != null) return false;
        if (spec != null ? !spec.equals(that.spec) : that.spec != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (cvFilename != null ? !cvFilename.equals(that.cvFilename) : that.cvFilename != null) return false;
        if (cartePro_filename != null ? !cartePro_filename.equals(that.cartePro_filename) : that.cartePro_filename != null)
            return false;
        if (mdp != null ? !mdp.equals(that.mdp) : that.mdp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRemplacant;
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (numTel != null ? numTel.hashCode() : 0);
        result = 31 * result + (dispo != null ? dispo.hashCode() : 0);
        result = 31 * result + (zoneGeo != null ? zoneGeo.hashCode() : 0);
        result = 31 * result + (kmMax != null ? kmMax.hashCode() : 0);
        result = 31 * result + (spec != null ? spec.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (cvFilename != null ? cvFilename.hashCode() : 0);
        result = 31 * result + (cartePro_filename != null ? cartePro_filename.hashCode() : 0);
        return result;
    }
}
