package server.bdd.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {
    private int idClient;
    private Short typeOffre;
    private String mail;
    private String numTel;
    private String adresse;
    private String periode;
    private String zoneGeo;
    private Integer kmMax;
    private String mdp;

    @Id
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
    @Column(name = "periode", nullable = true, length = 255)
    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
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
        if (typeOffre != null ? !typeOffre.equals(client.typeOffre) : client.typeOffre != null) return false;
        if (mail != null ? !mail.equals(client.mail) : client.mail != null) return false;
        if (numTel != null ? !numTel.equals(client.numTel) : client.numTel != null) return false;
        if (adresse != null ? !adresse.equals(client.adresse) : client.adresse != null) return false;
        if (periode != null ? !periode.equals(client.periode) : client.periode != null) return false;
        if (zoneGeo != null ? !zoneGeo.equals(client.zoneGeo) : client.zoneGeo != null) return false;
        if (kmMax != null ? !kmMax.equals(client.kmMax) : client.kmMax != null) return false;
        if (mdp != null ? !mdp.equals(client.mdp) : client.mdp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idClient;
        result = 31 * result + (typeOffre != null ? typeOffre.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (numTel != null ? numTel.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (periode != null ? periode.hashCode() : 0);
        result = 31 * result + (zoneGeo != null ? zoneGeo.hashCode() : 0);
        result = 31 * result + (kmMax != null ? kmMax.hashCode() : 0);
        return result;
    }
}
