package server.controller;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import server.bdd.model.Client;
import server.bdd.repository.ClientRepository;
import server.bdd.repository.OffreRepository;
import server.bdd.repository.PostulatRepository;
import server.bdd.repository.RemplacantRepository;

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

    void saveData(JSONArray data){
        String categorie = (String) data.get(0);
        JSONObject obj = (JSONObject) data.get(0);
        System.out.println(categorie);
        switch (categorie){
            case "Client":
                Client c = new Client();
                if (!myClient.existsByNumTel((String) obj.get("numTel"))){
                    c.setNumTel((String) obj.get("numTel"));
                    System.out.println(c.getNumTel());
            }
                System.out.println("client");
                break;
            case "Offre":
                System.out.println("offre");
                break;
            case "Postulat":
                System.out.println("postulat");
                break;
            case "Remplacant":
                System.out.println("remplacant");
                break;
            default :
                System.out.println("defaut");
                break;
        }
        }
    }

