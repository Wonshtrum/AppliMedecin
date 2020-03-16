package server.controller;


import com.google.gson.Gson;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import server.bdd.model.Client;
import server.bdd.model.Offre;
import server.bdd.model.Remplacant;
import server.bdd.repository.ClientRepository;
import server.bdd.repository.OffreRepository;
import server.bdd.repository.PostulatRepository;
import server.bdd.repository.RemplacantRepository;
import server.json.SimpleResponse;
import server.json.TestJson;
import org.json.simple.*;

import java.util.List;

@Controller
@ResponseBody
public class Controllers {
    Gson gson = new Gson();
    JSONParser parser = new JSONParser();
    private BddService myBddService;

    public Controllers(ClientRepository clt, OffreRepository offre, PostulatRepository postu, RemplacantRepository remplacant){
        this.myBddService = new BddService(clt,offre,postu,remplacant);
    }

    @GetMapping("/test")
    public SimpleResponse view() {
        SimpleResponse res = new SimpleResponse();
        res.put("test", "yolo");
        return res;
    }

    public JSONObject lireJson(String obj) throws ParseException {
       Object obj2 =parser.parse(obj);
        return (JSONObject) obj2;
    }

    @GetMapping("/test2")
    public SimpleResponse view2() {
        int[] b = {1,2,3};
        return new SimpleResponse(new TestJson(1, b, 5.5));
    }

    @GetMapping("/test3")
    public String testJSon(@RequestParam(name="json", required=true) String json) throws ParseException {
        JSONObject jj = lireJson(json);
        myBddService.saveData(jj);
        return "bonjour";
    }

    @GetMapping("/connexion")
    public String connexion(@RequestParam(name="infoConnexion",required = true) String json) throws ParseException{
        JSONObject ja = lireJson(json);
        String mail = (String) ja.get("mail");
        String mdp = (String) ja.get("mdp");
        Pair<Integer,String> infos = myBddService.verifConnexion(mdp,mail);
        JSONObject jay = new JSONObject();
        jay.put("id",infos.getFirst());
        jay.put("type",infos.getSecond());
        return jay.toJSONString();
    }

    @GetMapping("/requeteInfoLiee")
    public String requeteInfoLiee(@RequestParam(name="infoLiee",required = true) String json) throws ParseException{
        JSONObject obj= lireJson(json);
        Pair<Integer,String> paire= myBddService.lireData(obj);
        switch (paire.getSecond()) {
            case "remplacant": {
                Remplacant r = myBddService.getRemplacantByid(paire.getFirst());
                JSONObject newData = new JSONObject();
                newData.put("idRemplacant", r.getIdRemplacant());
                newData.put("mail", r.getMail());
                newData.put("kmMax", r.getKmMax());
                newData.put("numTel", r.getNumTel());
                newData.put("dispo", r.getDispo());
                newData.put("zoneGeo", r.getZoneGeo());
                newData.put("spec", r.getSpec());
                newData.put("cvFilename", r.getCvFilename());
                newData.put("description", r.getDescription());
                newData.put("carteProFilename", r.getCarteProFilename());
                newData.put("mdp", r.getMdp());
                return newData.toJSONString();
            }
            case "client": {
                Client c = myBddService.getClientById(paire.getFirst());
                JSONObject newData = new JSONObject();
                newData.put("idClient", c.getIdClient());
                newData.put("typeOffre", c.getTypeOffre());
                newData.put("mail", c.getMail());
                newData.put("mdp", c.getMdp());
                newData.put("kmMax", c.getKmMax());
                newData.put("numTel", c.getNumTel());
                newData.put("zoneGeo", c.getZoneGeo());
                newData.put("adresse", c.getAdresse());
                newData.put("periode", c.getPeriode());
                return newData.toJSONString();
            }
            case "offre":
                Offre o = myBddService.getOffreByIdOffre(paire.getFirst());
                return gson.toJson(o);
        }
        return "erreur";
    }

    @GetMapping("/requeteOffreLiee")
    public String requeteOffreLiee(@RequestParam(name="infoLiee",required = true) String json) throws ParseException {
        JSONObject obj = lireJson(json);
        Pair<Integer, String> paire = myBddService.lireData(obj);
        if (paire.getSecond().equals("client")) {
            List<Offre> offres = myBddService.getOffreByIdClient(paire.getFirst());
            JSONObject newObj = new JSONObject();
            JSONArray jsOffres = new JSONArray();
            for (Offre o : offres){
                jsOffres.add(gson.toJson(o));
            }
            newObj.put("offres", jsOffres);
            return newObj.toJSONString();
        } else if (paire.getSecond().equals("remplacant")) {
            List<Offre> offres = myBddService.getByAllPostulat(myBddService.getPostulatByIdRemplacant(paire.getFirst()));
            JSONObject newObj = new JSONObject();
            JSONArray jsOffres = new JSONArray();
            for (Offre o : offres){
                jsOffres.add(gson.toJson(o));
            }
            newObj.put("offres", jsOffres);
            return newObj.toJSONString();
        }
        else {
            return "erreur";
        }
    }

    @GetMapping("/requeteOffres")
    public String requeteOffres() {
        List<Offre> offres = myBddService.getAllOffres();
        JSONObject newObj = new JSONObject();
        JSONArray jsOffres = new JSONArray();
        for (Offre o : offres){
            jsOffres.add(gson.toJson(o));
        }
        newObj.put("offres", jsOffres);
        return newObj.toJSONString();
    }

    @GetMapping("/supprimerChose")
    public String SupprimerChose(@RequestParam(name="info" ,required=true) String json)throws ParseException{
        JSONObject obj = lireJson(json);
        Pair<Integer,String>paire = myBddService.lireData(obj);
        switch (paire.getSecond()){
            case "offre":
                if (myBddService.deleteByIdOffre(paire.getFirst())){
                    return "true";
                }
                return "false";
            case "remplacant":
                if (myBddService.deleteByIdRemplacant(paire.getFirst())){
                    return "true";
                }
                return "false";
            case "client":
                if (myBddService.deleteByIdClient(paire.getFirst())){
                    return "true";
                }
                return "false";
            case "postulat":
                if (myBddService.deleteByIdPostulat(paire.getFirst())){
                    return "true";
                }
                return "false";
            default :
                return "mauvaise structure de données";
        }

    }

}
