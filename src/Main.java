import java.awt.Color;
import java.io.*;

import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
	MyFrame salle = new MyFrame("D:\\Users\\Thérèse\\Downloads\\restaurant_exemple_menu.json");
salle.setSize(900, 500);//taille de ma fenetre


salle.getRootPane().setBorder(BorderFactory.createLineBorder(Color.gray, 3));//bordure

}
}