package server.controller;


import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import server.bdd.model.Client;
import server.bdd.repository.ClientRepository;
import server.bdd.repository.OffreRepository;
import server.bdd.repository.PostulatRepository;
import server.bdd.repository.RemplacantRepository;
import server.json.SimpleResponse;
import server.json.TestJson;
import org.json.simple.*;

@Controller
@ResponseBody
public class Controllers {
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

    public JSONArray lireJson(String obj) throws ParseException {
       Object obj2 =parser.parse(obj);
        return (JSONArray) obj2;
    }

    @GetMapping("/test2")
    public SimpleResponse view2() {
        int[] b = {1,2,3};
        return new SimpleResponse(new TestJson(1, b, 5.5));
    }

    @GetMapping("/test3")
    public String testJSon(@RequestParam(name="json", required=true) String json) throws ParseException {
        JSONArray jj = lireJson(json);
        myBddService.saveData(jj);
        return "bonjour";
    }
}
