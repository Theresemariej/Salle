import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Json {
	private ArrayList<Plat> CLesEntrees;
	private ArrayList<Plat> CLesPlats;
	private ArrayList<Plat> CLesDesserts;
	private JSONObject jsonObj;

	
public Json(ArrayList e, ArrayList pl,ArrayList d) {
	this.CLesEntrees = e;
	this.CLesPlats = pl;
	this.CLesDesserts=d;
	this.jsonObj = new JSONObject();
	
	setUp();
}

public void setUp() {
	JSONArray Array = new JSONArray();
	
	for(Plat p : CLesEntrees) {
		JSONObject jsonObjBIS = new JSONObject();
		jsonObjBIS.put("id", p.getId());
		jsonObjBIS.put("qtt", p.getQtt());
		Array.add(jsonObjBIS);

	
	
		JSONArray Array2 = new JSONArray();
		
		for(Plat p2 : CLesPlats) {
			JSONObject jsonObjBIS2 = new JSONObject();
			jsonObjBIS2.put("id", p2.getId());
			jsonObjBIS2.put("qtt", p2.getQtt());
			Array2.add(jsonObjBIS2);
	
		
			JSONArray Array3 = new JSONArray();
			
			for(Plat p3 : CLesDesserts) {
				JSONObject jsonObjBIS3 = new JSONObject();
				jsonObjBIS3.put("id", p3.getId());
				jsonObjBIS3.put("qtt", p3.getQtt());
				Array3.add(jsonObjBIS3);
		}
				
			jsonObj.put("Startres", Array);	
			jsonObj.put("main_courses", Array2);
			jsonObj.put("desserts", Array3);	

	FileWriter file;
	try {
		file = new FileWriter("D:\\users\\Thérèse\\Downloads\\nom"+".jason");
		file.write(jsonObj.toJSONString());
		file.flush();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		

}}}}