package server;

import org.json.simple.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import server.bdd.repository.ClientRepository;
import server.bdd.repository.OffreRepository;
import server.bdd.repository.PostulatRepository;
import server.bdd.repository.RemplacantRepository;
import server.controller.BddService;
import server.controller.Controllers;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
}
