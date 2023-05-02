import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.*;

import org.json.simple.parser.ParseException;

public class MyFrame extends JFrame {

	private String fichier;
	private JPanel pan;
	private Lire lire;
	//	private JPanels jp;
	private HashMap<String, Integer>a, b,d;
	
	private JLabel entrees,plat,dessert;
	private JPanel panelSud;
	//private ArrayList<Plat> entreesChoisies;


	public MyFrame(String fichier) throws FileNotFoundException, IOException, ParseException {
		super();
		this.fichier = fichier;// fichier qui se trouve dans le chemin absolu qu'on donne dans le main.HAHAHAHAHAHAHAAHAHAHAHAAHAHA
		this.pan=new JPanel();
		this.lire = new Lire();//c'est pour utiliser juste apres
	//	this.jp=new JPanels("Entree",lire.getListeEntrees());//l'arrayList des entrees est dans lire
		this.a= new HashMap<String, Integer>();
		this.b= new HashMap<String,Integer>();
		this.d= new HashMap<String, Integer>();
		
		this.entrees=new JLabel();
		this.plat=new JLabel();
		this.dessert=new JLabel();
		this.panelSud= new JPanel();
	//C'est la liste de toutes les entrées (nom et qtt) sur lesquelles on a cliqué.
	
	    
	
		setUp();
	}
//_________________________________________PUBLIC VOID SETUP_________________________________________________________________________
	public void setUp() throws FileNotFoundException, IOException, ParseException {
		

		Lire lire = new Lire();
	//	Vision vision= new Vision();
		this.setContentPane(pan);
	//	this.add(pan, BorderLayout.CENTER);
		pan.setLayout(new BorderLayout());

		// § aspect de MENU DU JOUR
		JLabel lb = new JLabel("MENU DU JOUR");
		lb.setOpaque(true);
		lb.setBackground(Color.GRAY);
		lb.setForeground(Color.WHITE);

		// placement de MENU DU JOUR
		lb.setHorizontalAlignment(JLabel.CENTER);
		lb.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE),
				BorderFactory.createEmptyBorder(8, 3, 3, 8)));

		pan.add(lb, BorderLayout.NORTH);

		// On lit les entrees
		
		JPanels w = new JPanels("Entrées", lire.ListeDesEntrees(fichier));
		JPanels ct = new JPanels("Plats", lire.ListeDesPlats(fichier));
		JPanels e = new JPanels("Desserts", lire.ListeDesDesserts(fichier));
		
		
		pan.add(w, BorderLayout.WEST);
		pan.add(ct, BorderLayout.CENTER);
		pan.add(e, BorderLayout.EAST);

		
		//_________________________________________PARTIE SUD__________________________________________________________________
		
//		a= recap(w,entrees);				//recap(JPanels w, JLabel texte)
//		b= recap(ct,plat);
//		d=recap(e,dessert);
//		
//		(ArrayList<Integer>) data[0];
//		convertHashMapToPlatList(a);
//		convertHashMapToPlatList(b);
//		convertHashMapToPlatList(d);
		
		

		Object[] data = recap(w,entrees);
		HashMap<String, Integer> a = (HashMap<String,Integer>) data[1];
		ArrayList<Plat> entreesChoisies = (ArrayList<Plat>) data[0];
		Object[] data2 = recap(ct,plat);
		HashMap<String, Integer> b = (HashMap<String,Integer>) data2[1];
		ArrayList<Plat> platsChoisis = (ArrayList<Plat>) data2[0];
		Object[] data3 = recap(e,dessert);
		HashMap<String, Integer> d = (HashMap<String,Integer>) data3[1];
		ArrayList<Plat> dessertsChoisis = (ArrayList<Plat>) data3[0];

	
				JPanel panelBouton= new JPanel();
				
				panelBouton.setLayout(new GridLayout(1, 2, 10, 10)); //grille dans laquelle on met les 2 boutons
				panelSud.setLayout(new GridLayout(4, 1, 10, 10)); //grille dans laquelle on met la grilleDesBoutons et les label héhéhéhéhéhéhéhéhééhéhéhééhéhéhéhéhéhééhéhéhé		
				
				JButton s = new JButton("annuler");//permet de tout annuler
				s.addActionListener(l -> {
					entrees.setText(" ");plat.setText(" ");dessert.setText(" ");
					a.clear();b.clear();d.clear();
					entreesChoisies.clear();platsChoisis.clear();dessertsChoisis.clear();
				});
	
				System.out.println("IMPORTANTTTTTTTTT"+entreesChoisies);

				Json json= new Json(entreesChoisies,platsChoisis, dessertsChoisis);//c'est w.getListPlat()
				JButton com= new JButton("commander");//COMMANDE
				com.addActionListener(l ->{
					json.setUp();//Sur le jason qui contient l'arrayList des entreesChoisie on exécute genererJson;
					
				});
				panelBouton.add(s);
				panelBouton.add(com);
				

				panelSud.add(panelBouton, BorderLayout.CENTER);
				boutonSupp(entrees," les entrees",a,entreesChoisies);//C'est les 3 boutons pour supprimer les entrées, ou les plats ou les desserts
				boutonSupp(plat," les plats	",b,platsChoisis);//Pour ça j'utilise la fonction boutonSupp définie plus loin
				boutonSupp(dessert," les desserts",d,dessertsChoisis);
				

			
				panelSud.setBackground(Color.WHITE);
				panelSud.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE),
						BorderFactory.createEmptyBorder(8, 3, 3, 8)));//cree un bordure autour de tout le panelSouth
				
		
			
		
		
		//________________________________________FIN PARTIE SUD________________________________________________________________

	
		this.add(panelSud, BorderLayout.SOUTH);

				
		// Redimensionnement optimal
		pack();
		// Gestion de la fermeture
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Positionnement au centre de l'écran
		setLocationRelativeTo(null);
		// Affichage
		setVisible(true);
		

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // quand on ferme la fenêtre (le cadre), on ferme aussi
																// le programme
		
//______________________________________________________________________________________________________________________________________
//______________________________________________________________________________________________________________________________________

	}
	public static Object[] recap(JPanels wst, JLabel texte) {
		HashMap<String, Integer> sauveMoi = new HashMap<String, Integer>();
		ArrayList<Plat> listPlat = new ArrayList<Plat>();
		Object[] result = new Object[2];
		
		for (JButtons b : wst.getListB()) {
			System.out.println("menuuu:-3 "+listPlat);


			b.addActionListener(l -> {// on ajoute une action au bouton b
				System.out.println("ActionListener called");
				 String nom = b.getP().getDescription();
	                if (sauveMoi.containsKey(nom)) {
	                    sauveMoi.put(nom, sauveMoi.get(nom) + 1);
	                } else {
	                    sauveMoi.put(nom, 1);
	                }
					System.out.println("menuuu: -2"+listPlat);


				// Parcours de la HashMap pour la convertir en chaîne de caractères
				StringBuilder sb = new StringBuilder();
				for (String key : sauveMoi.keySet()) {
				    sb.append(key).append(" : ").append(sauveMoi.get(key)).append("_");
				}


				// Définition du texte du JLabel avec la chaîne de caractères obtenue
				texte.setText(""+sb.toString());
				//texte.setText(sb.toString());
				
			//On crée un nouveau plat avec pour nom et id ce qu'y a écrit dans jb
						Plat entree = b.getP();//jb c'est un bouton et getP renvoie le plat contenu dans jb
						entree.setQtt(1);//On modifie la qtt
						listPlat.add(entree);
						
						System.out.println("menuuu: "+listPlat);
						
					});}
		    result[0] = listPlat;
		    result[1] = sauveMoi;
		
		return result;
	}

//__________________________________________________________________________________________________________________________________
//______________________________________________________________________________________________________________________________________


	public ArrayList<Plat> boutonSupp(JLabel entree, String nom, HashMap<String, Integer> a2, ArrayList<Plat> arraylist) {//Fonction pour les 3 boutons supprimer
		JPanel panelDeLabel = new JPanel();
		panelDeLabel.setLayout(new BoxLayout(panelDeLabel, BoxLayout.LINE_AXIS));//permet de fixer les bouton à l'est
	
	JButton e = new JButton("Supprimer"+ nom);//Nom bouton
	e.addActionListener(l -> {
				a2.clear();
				arraylist.clear();
		entree.setText(" ");//efface le texte qu'il y a dans le JLabel ( dans le JLabel entree par ex)
		
	
	});
	e.setMaximumSize(new Dimension(170,50));
	panelDeLabel.add(e, BorderLayout.PAGE_START);
	panelDeLabel.add(entree, BorderLayout.CENTER);
	panelSud.add(panelDeLabel);
	return arraylist;
	}
}