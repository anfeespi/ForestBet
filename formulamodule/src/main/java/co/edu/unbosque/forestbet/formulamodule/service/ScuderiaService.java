package co.edu.unbosque.forestbet.formulamodule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.forestbet.formulamodule.model.Scuderia;
import co.edu.unbosque.forestbet.formulamodule.repository.ScuderiaRepository;

@Service
public class ScuderiaService {
	@Autowired
	private ScuderiaRepository scuderiaRepository;
	
	public ScuderiaService() {
		// TODO Auto-generated constructor stub
	}
	
	public void chargeAllScuderias(String json) {
		deleteScuderias();
		json = json.substring(json.indexOf("\"Constructors\":"), json.indexOf("]"));
		json = json.replace("\"Constructors\":", "").replace("[", "");
		String scuderias[] = json.replace("{", "").split("},");
		
		for (String string : scuderias) {
			Scuderia aux = new Scuderia();
			String attributes[] = string.split(",");
			aux.setConstructorId(attributes[0].replace("\"", "").replace("constructorId:", ""));
			aux.setUrl(attributes[1].replace("\"", "").replace("url:", "").replace("\\/", "/"));
			aux.setName(attributes[2].replace("\"", "").replace("name:", ""));
			aux.setNationality(attributes[3].replace("\"", "").replace("nationality:", "").replace("}", ""));
			createScuderia(aux);
		}
	}
	
	public void createScuderia(Scuderia scuderia) {
		scuderiaRepository.save(scuderia);
	}
	
	public List<Scuderia> showAllScuderias(){
		return (List<Scuderia>) scuderiaRepository.findAll();
	}
	
	public void deleteScuderias() {
		scuderiaRepository.deleteAll();
	}
}
