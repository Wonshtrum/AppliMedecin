package server.bdd.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {
    private int idClient;
    private String mail;
    private String numTel;
    private String adresse;
    private String zoneGeo;
    private Integer kmMax;
    private Short secretariat;
    private Short dispoSec;
    private String specialite;
    private String mdp;
    private String cartePro_filename;

    @Id
    @Column(name = "id_client", nullable = false)
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "secretariat", nullable = true)
    public Short getSecretariat() {
        return secretariat;
    }

    public void setSecretariat(Short secretariat) {
        this.secretariat = secretariat;
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
    @Column(name = "mail", nullable = true, length = 255)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
    @Column(name = "adresse", nullable = true, length = 255)
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Basic
    @Column(name = "dispoSec", nullable = true, length = 255)
    public Short getDispoSec() {
        return dispoSec;
    }

    public void setDispoSec(Short dispoSec) {
        this.dispoSec = dispoSec;
    }

    @Basic
    @Column(name = "specialite", nullable = true, length = 255)
    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @Basic
    @Column(name = "cartePro_filename", nullable = true, length = 255)
    public String getCartePro_filename() {
        return cartePro_filename;
    }

    public void setCartePro_filename(String cartePro_filename) {
        this.cartePro_filename = cartePro_filename;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (idClient != client.idClient) return false;
        if (secretariat != null ? !secretariat.equals(client.secretariat) : client.secretariat != null) return false;
        if (mail != null ? !mail.equals(client.mail) : client.mail != null) return false;
        if (numTel != null ? !numTel.equals(client.numTel) : client.numTel != null) return false;
        if (adresse != null ? !adresse.equals(client.adresse) : client.adresse != null) return false;
        if (dispoSec != null ? !dispoSec.equals(client.dispoSec) : client.dispoSec != null) return false;
        if (specialite != null ? !specialite.equals(client.specialite) : client.specialite != null) return false;
        if (cartePro_filename != null ? !cartePro_filename.equals(client.cartePro_filename) : client.cartePro_filename != null) return false;
        if (zoneGeo != null ? !zoneGeo.equals(client.zoneGeo) : client.zoneGeo != null) return false;
        if (kmMax != null ? !kmMax.equals(client.kmMax) : client.kmMax != null) return false;
        if (mdp != null ? !mdp.equals(client.mdp) : client.mdp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idClient;
        result = 31 * result + (secretariat != null ? secretariat.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (numTel != null ? numTel.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (dispoSec != null ? dispoSec.hashCode() : 0);
        result = 31 * result + (zoneGeo != null ? zoneGeo.hashCode() : 0);
        result = 31 * result + (kmMax != null ? kmMax.hashCode() : 0);
        result = 31 * result + (specialite != null ? specialite.hashCode() : 0);
        result = 31 * result + (cartePro_filename != null ? cartePro_filename.hashCode() : 0);
        return result;
    }
}
