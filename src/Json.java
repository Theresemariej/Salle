import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Json {
	protected ArrayList<Plat> CLesEntrees;
	protected ArrayList<Plat> CLesPlats;
	protected ArrayList<Plat> CLesDesserts;

	
public Json(ArrayList e, ArrayList p,ArrayList d) {
	this.CLesEntrees = e;
	this.CLesPlats = p;
	this.CLesDesserts=d;
}

public void genererEntree() {
	JSONObject jsonObj = new JSONObject();
	JSONArray Array = new JSONArray();
	
	for(Plat p : CLesEntrees) {
		JSONObject jsonObj2 = new JSONObject();
		jsonObj2.put("id", p.getId());
		jsonObj2.put("qtt", p.getQtt());
		Array.add(jsonObj2);
}}
	
	
	public void genererPlat() {
		JSONObject jsonObj = new JSONObject();
		JSONArray Array = new JSONArray();
		
		for(Plat p : CLesPlats) {
			JSONObject jsonObj2 = new JSONObject();
			jsonObj2.put("id", p.getId());
			jsonObj2.put("qtt", p.getQtt());
			Array.add(jsonObj2);
	}}


		
		public void genererDessert() {
			JSONObject jsonObj = new JSONObject();
			JSONArray Array = new JSONArray();
			
			for(Plat p : CLesDesserts) {
				JSONObject jsonObj2 = new JSONObject();
				jsonObj2.put("id", p.getId());
				jsonObj2.put("qtt", p.getQtt());
				Array.add(jsonObj2);
		}
			jsonObj.put("desserts", Array);	
			jsonObj.put("main_courses", Array);	
			jsonObj.put("Startres", Array);	
			

	FileWriter file;
	try {
		file = new FileWriter("D:\\users\\Thérèse\\Downloads\\nom"+".jason");
		file.write(jsonObj.toJSONString());
		file.flush();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		

}}