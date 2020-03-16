package server.controller;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.data.util.Pair;
import server.bdd.model.Client;
import server.bdd.model.Offre;
import server.bdd.model.Postulat;
import server.bdd.model.Remplacant;
import server.bdd.repository.ClientRepository;
import server.bdd.repository.OffreRepository;
import server.bdd.repository.PostulatRepository;
import server.bdd.repository.RemplacantRepository;

import java.util.ArrayList;
import java.util.List;

public class BddService {
    private final ClientRepository myClient;
    private final OffreRepository myOffre;
    private final PostulatRepository myPostulat;
    private final RemplacantRepository myRemplacant;

    BddService(ClientRepository myClient, OffreRepository myOffre, PostulatRepository myPostulat, RemplacantRepository myRemplacant) {
        this.myClient = myClient;
        this.myOffre = myOffre;
        this.myPostulat = myPostulat;
        this.myRemplacant= myRemplacant;
    }


    Remplacant getRemplacantByid(int id) {
        return myRemplacant.findByIdRemplacant(id);
    }

    Client getClientById(int id){
        return  myClient.findByIdClient(id);
    }

    List<Offre> getOffreByIdClient(int id){
        return myOffre.getAllByIdClient(id);
    }

    List<Postulat> getPostulatByIdRemplacant(int id){
        return myPostulat.getAllByIdRemplacant(id);
    }

    List<Offre> getAllOffres(){
        return myOffre.getAllByIdOffreIsNotNull();
    }

    List<Offre> getByAllPostulat(List<Postulat> pos){
        ArrayList<Offre> liste= new ArrayList<>();
        for (Postulat p : pos){
            liste.add(myOffre.findByIdOffre(p.getIdOffre()));
        }
        return liste;
    }
    Pair<Integer,String> verifConnexion(String mdp, String mail){
        if (myRemplacant.existsByMdpAndMail(mdp, mail)){
            Remplacant r = myRemplacant.findByMdpAndMail(mdp,mail);
            return Pair.of(r.getIdRemplacant(),"remplacant");
        }
        else if (myClient.existsByMdpAndMail(mdp,mail)){
            Client c = myClient.findByMdpAndMail(mdp, mail);
            return Pair.of(c.getIdClient(),"client");
        }
        else{
            return Pair.of(-1,"none");
        }
    }

    boolean deleteByIdOffre(int id){
        myOffre.deleteByIdOffre(id);
        return myOffre.existsByIdOffre(id);
    }

    boolean deleteByIdRemplacant(int id){
        myRemplacant.deleteByIdRemplacant(id);
        return myRemplacant.existsByIdRemplacant(id);
    }

    boolean deleteByIdClient(int id){
        myClient.deleteByIdClient(id);
        return myClient.existsByIdClient(id);
    }

    boolean deleteByIdPostulat(int id){
        myPostulat.deleteByIdPostulat(id);
        return myPostulat.existsByIdPostulat(id);
    }

    Pair<Integer,String> lireData(JSONObject obj){
        Integer id = Integer.parseInt((String) obj.get("id"));
        String type = (String) obj.get("type");
        return Pair.of(id,type);
    }

    Offre getOffreByIdOffre(int id ){
        return myOffre.findByIdOffre(id);
    }

    void saveData(JSONObject obj){
        String type = (String) obj.get("type");
        switch (type){
            case "client":
                Client c = new Client();
                if (myClient.existsByIdClient(Integer.parseInt((String)obj.get("idClient")))) {
                    c = myClient.findByIdClient(Integer.parseInt((String)obj.get("idClient")));
                }
                c.setNumTel((String) obj.get("numTel"));
                c.setAdresse((String) obj.get("adresse"));
                c.setKmMax( Integer.parseInt((String)obj.get("kmMax")));
                c.setMail((String) obj.get("mail"));
                c.setPeriode((String) obj.get("periode"));
                c.setTypeOffre(Short.parseShort((String) obj.get("typeOffre")));
                c.setZoneGeo((String) obj.get("zoneGeo"));
                myClient.save(c);
                break;
            case "offre":
                Offre o = new Offre();
                if (myOffre.existsByIdOffre(Integer.parseInt((String)obj.get("idOffre")))){
                    o = myOffre.findByIdOffre(Integer.parseInt((String)obj.get("idOffre")));
                }
                o.setIdClient((Integer.parseInt((String) obj.get("idClient"))));
                o.setActivite(Byte.parseByte((String) obj.get("activite")));
                o.setCarteProFilename((String) obj.get("carteProFilename"));
                o.setDescription((String) obj.get("description"));
                o.setDispoSec((String) obj.get("dispoSec"));
                o.setHoraire((String) obj.get("horaire"));
                o.setLogicielUtilise((String) obj.get("logicielUtilise"));
                o.setRetrocession((String) obj.get("retrocession"));
                o.setSecretariat(Byte.parseByte((String) obj.get("secretariat")));
                o.setSpec((String) obj.get("spec"));
                o.setTypeOffre(Short.parseShort((String) obj.get("typeOffre")));
                o.setTypePatient((String) obj.get("typePatient"));
                o.setVisiteDomicile(Integer.parseInt((String) obj.get("visiteDomicile")));
                myOffre.save(o);
                break;
            case "postulat":
                Postulat p = new Postulat();
                if (myPostulat.existsByIdPostulat(Integer.parseInt((String)obj.get("idPostulat")))){
                    p = myPostulat.findByIdPostulat(Integer.parseInt((String)obj.get("idPostulat")));
                }
                p.setIdOffre(Integer.parseInt((String) obj.get("idOffre")));
                p.setIdRemplacant(Integer.parseInt((String) obj.get("idRemplacant")));
                myPostulat.save(p);
                break;
            case "remplacant":
                Remplacant r = new Remplacant();
                if (myRemplacant.existsByIdRemplacant(Integer.parseInt((String)obj.get("idRemplacant")))){
                    myRemplacant.findByIdRemplacant(Integer.parseInt((String)obj.get("idRemplacant")));
                }
                r.setCarteProFilename((String) obj.get("carteProFilename"));
                r.setCvFilename((String) obj.get("cvFilename"));
                r.setDescription((String) obj.get("description"));
                r.setDispo((String) obj.get("dispo"));
                r.setKmMax(Integer.parseInt((String) obj.get("kmMax")));
                r.setMail((String) obj.get("mail"));
                r.setNumTel((String) obj.get("numTel"));
                r.setSpec((String) obj.get("spec"));
                r.setZoneGeo((String) obj.get("zoneGeo"));
                myRemplacant.save(r);
                break;
            default :
                System.out.println("defaut");
                break;
        }
        }
    }

