import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Lire {
	private ArrayList<Plat> listeEntrees;
	
	public Lire() {
	this.listeEntrees=new ArrayList<Plat>();
	}
	
	public ArrayList<Plat> ListeDesEntrees(String file) throws FileNotFoundException, IOException, ParseException{
		
		//ArrayList<Plat> listeEntrees = new ArrayList<Plat>();
		
		JSONParser jsonP = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonP.parse(new FileReader(file));//utilise jsonP
		JSONArray starters =(JSONArray)jsonObject.get("starters");//utilise jsonObject //Quand object = starter, on lit ce que cet object contient.
		
		
		Iterator liste= starters.iterator();//permet de parcourir tous les objects qui sont contenus dans starters
		while ( liste.hasNext()) {//tant qu'il y a une ligne apres
			JSONObject entree = (JSONObject) liste.next();//on appelle l'object entree et cet object est compose d'une liste avec le nom, l'id et les qtt des differentes entrees
			Long id = (Long) entree.get("id");//id = la partie qui s'appelle id qui est contenue dans l'object entree
			String description = (String) entree.get("description");
			listeEntrees.add(new Plat(id, description));
			
		}
		return listeEntrees;
		
	}
	
public ArrayList<Plat> ListeDesPlats(String file) throws FileNotFoundException, IOException, ParseException{
		
		ArrayList<Plat> ListePlats = new ArrayList<Plat>();
		
		JSONParser jsonP = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonP.parse(new FileReader(file));
		JSONArray starters =(JSONArray)jsonObject.get("main_courses");
		
		
		Iterator liste= starters.iterator();
		while ( liste.hasNext()) {
			JSONObject plats = (JSONObject) liste.next();
			Long id = (Long) plats.get("id");
			String description = (String) plats.get("description");
			ListePlats.add(new Plat(id, description));
			
		}
		return ListePlats;
		
	}

public ArrayList<Plat> ListeDesDesserts(String file) throws FileNotFoundException, IOException, ParseException{
	
	ArrayList<Plat> ListeDesserts = new ArrayList<Plat>();
	
	JSONParser jsonP = new JSONParser();
	JSONObject jsonObject = (JSONObject) jsonP.parse(new FileReader(file));
	JSONArray starters =(JSONArray)jsonObject.get("desserts");
	
	
	Iterator liste= starters.iterator();
	while ( liste.hasNext()) {
		JSONObject dessert = (JSONObject) liste.next();
		Long id = (Long) dessert.get("id");
		String description = (String) dessert.get("description");
		ListeDesserts.add(new Plat(id, description));
		
	}
	return ListeDesserts;
	
}

/**
 * @return the listeEntrees
 */
public ArrayList<Plat> getListeEntrees() {
	return listeEntrees;
}

	
}