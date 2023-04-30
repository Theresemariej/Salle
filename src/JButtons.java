import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JButtons extends JButton{
	
	   // private ArrayList<Plat> CLesEntrees;
	    private Plat p;
	    private int qtt;

    	public JButtons(Plat p) {
        	super(p.getDescription());
        	this.p=p;
        	this.qtt=0;
      
        	this.setBackground(Color.GRAY);//fond noir
        	this.setForeground(Color.WHITE);//ecriture blanche
        	
        //	setUp();
     	
    	}
    	
//    	private void setUp() {
//    		this.addActionListener(e ->{
//    			CLesEntrees.add(p);
//    			
//    		});
//   
//    	}
//    	public String genererJson() {
//    		JSONObject jsonObj = new JSONObject();
//    		JSONArray Array = new JSONArray();
//    		
//    		for(Plat p : CLesEntrees) {
//    			JSONObject jsonObj2 = new JSONObject();
//    			jsonObj2.put("id", p.getId());
//    			jsonObj2.put("qtt", p.getQtt());
//    			Array.add(jsonObj2);
//    	}
//    		jsonObj.put("Startres", Array);	
//    		return "coucou" + Array;
//    	}
    	
		/**
		 * @return the p
		 */
		public Plat getP() {//il retourne le nom et la quantité du plat qui correspond au bouton
			return p;
		}

		/**
		 * @return the qtt
		 */
		public int getQtt() {
			return qtt;
		}

		/**
		 * @param qtt the qtt to set
		 */
		public void setQtt(int qtt) {
			this.qtt = qtt;
		}
		
		
		/**
		 * @return the cLesEntrees
		 */
//		public ArrayList<Plat> getCLesEntrees() {
//			return CLesEntrees;
//		}

    }
