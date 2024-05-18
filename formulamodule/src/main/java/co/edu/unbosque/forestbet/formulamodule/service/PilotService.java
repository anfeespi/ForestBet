package co.edu.unbosque.forestbet.formulamodule.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.forestbet.formulamodule.model.Pilot;
import co.edu.unbosque.forestbet.formulamodule.model.Scuderia;
import co.edu.unbosque.forestbet.formulamodule.repository.PilotRepository;
import co.edu.unbosque.forestbet.formulamodule.repository.ScuderiaRepository;

@Service
public class PilotService {
	@Autowired
	private PilotRepository pilotRepository;
	@Autowired
	private ScuderiaRepository scuderiaRepository;

	public PilotService() {
		// TODO Auto-generated constructor stub
	}

	public void chargeAllPilots(String json) {
		deletePilots();

		json = json.substring(json.indexOf("\"Drivers\":"), json.indexOf("]"));
		json = json.replace("\"Drivers\":", "").replace("[", "");
		String pilots[] = json.replace("{", "").split("},");

		for (String string : pilots) {
			Pilot aux = new Pilot();
			String attributes[] = string.split(",");
			aux.setDriverId(attributes[0].replace("\"", "").replace("driverId:", ""));
			aux.setPermanentNumber(Long.parseLong(attributes[1].replace("\"", "").replace("permanentNumber:", "")));
			aux.setCode(attributes[2].replace("\"", "").replace("code:", ""));
			aux.setUrl(attributes[3].replace("\"", "").replace("url:", "").replace("\\/", "/"));
			aux.setName(attributes[4].replace("\"", "").replace("givenName:", ""));
			aux.setLastname(attributes[5].replace("\"", "").replace("familyName:", ""));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

			try {
				String[] dt = attributes[6].replace("\"", "").replace("dateOfBirth:", "").split("-");
				aux.setDateOfBirth(format.parse(dt[2] + "/" + dt[1] + "/" + dt[0]));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			aux.setNationality(attributes[7].replace("\"", "").replace("nationality:", ""));

			String scuderia = "";

			if (aux.getDriverId().equals("albon") || aux.getDriverId().equals("sargeant"))
				scuderia = "williams";
			if (aux.getDriverId().equals("alonso") || aux.getDriverId().equals("stroll"))
				scuderia = "aston_martin";
			if (aux.getDriverId().equals("bottas") || aux.getDriverId().equals("zhou"))
				scuderia = "sauber";
			if (aux.getDriverId().equals("gasly") || aux.getDriverId().equals("ocon"))
				scuderia = "alpine";
			if (aux.getDriverId().equals("hamilton") || aux.getDriverId().equals("russell"))
				scuderia = "mercedes";
			if (aux.getDriverId().equals("hulkenberg") || aux.getDriverId().equals("kevin_magnussen"))
				scuderia = "haas";
			if (aux.getDriverId().equals("leclerc") || aux.getDriverId().equals("sainz"))
				scuderia = "ferrari";
			if (aux.getDriverId().equals("norris") || aux.getDriverId().equals("piastri"))
				scuderia = "mclaren";
			if (aux.getDriverId().equals("perez") || aux.getDriverId().equals("max_verstappen"))
				scuderia = "red_bull";
			if (aux.getDriverId().equals("ricciardo") || aux.getDriverId().equals("tsunoda"))
				scuderia = "rb";

			if (aux.getLastname().equals("Bearman"))
				continue;
			
			Scuderia scuderiaaux = scuderiaRepository.findByConstructorId(scuderia);

			aux.setScuderia(scuderiaaux);

			pilotRepository.save(aux);
		}
	}

	public void createPilot(Pilot pilot) {
		pilotRepository.save(pilot);
	}

	public List<Pilot> showAllPilots() {
		return (List<Pilot>) pilotRepository.findAll();
	}

	public void deletePilots() {
		pilotRepository.deleteAll();
	}
}
