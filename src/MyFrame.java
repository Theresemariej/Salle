import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.*;

import org.json.simple.parser.ParseException;

public class MyFrame extends JFrame {

	private String fichier;
	private JPanel pan;
	private Lire lire;
//	private JPanels jp;
	private Json json;
	private HashMap<String, Integer> a,b,d;
	private JPanels w,ct,e;
	
	private JLabel entree,plat,dessert;
	private JPanel panelSud;
	//private ArrayList<Plat> entreesChoisies;


	public MyFrame(String fichier) throws FileNotFoundException, IOException, ParseException {
		super();
		this.fichier = fichier;// fichier qui se trouve dans le chemin absolu qu'on donne dans le main.HAHAHAHAHAHAHAAHAHAHAHAAHAHA
		this.pan=new JPanel();
		this.lire = new Lire();//c'est pour utiliser juste apres
	//	this.jp=new JPanels("Entree",lire.getListeEntrees());//l'arrayList des entrees est dans lire
		this.a= new HashMap<String, Integer>();
		this.b= new HashMap<String, Integer>();
		this.d= new HashMap<String, Integer>();
		this.w = new JPanels("Entrées", lire.ListeDesEntrees(fichier));
		this.ct = new JPanels("Plats", lire.ListeDesPlats(fichier));
		this.e = new JPanels("Desserts", lire.ListeDesDesserts(fichier));
		
		this.entree=new JLabel();
		this.plat=new JLabel();
		this.dessert=new JLabel();
		this.panelSud= new JPanel();
		//this.json= new Json(entreesChoisies);c'estw.getListPlat()
	//	this.entreesChoisies=new ArrayList<Plat>();//C'est la liste de toutes les entrées (nom et qtt) sur lesquelles on a cliqué.
	
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
		
		pan.add(w, BorderLayout.WEST);
		pan.add(ct, BorderLayout.CENTER);
		pan.add(e, BorderLayout.EAST);
		
		w.getListPlat();

		
		//_________________________________________PARTIE SUD__________________________________________________________________
		
		a= recap(w,entree);//recap(JPanels w, JLabel texte)
		b= recap(ct,plat);
		d=recap(e,dessert);
	
				JPanel panelBouton= new JPanel();
				
				panelBouton.setLayout(new GridLayout(1, 2, 10, 10)); //grille dans laquelle on met les 2 boutons
				panelSud.setLayout(new GridLayout(4, 1, 10, 10)); //grille dans laquelle on met la grilleDesBoutons et les label héhéhéhéhéhéhéhéhééhéhéhééhéhéhéhéhéhééhéhéhé		
				
				JButton s = new JButton("annuler");//permet de tout annuler
				s.addActionListener(l -> {
					entree.setText(" ");
					plat.setText(" ");
					dessert.setText(" ");
					a.clear();
					b.clear();
					d.clear();
				});
			

				JButton com= new JButton("commander");//COMMANDE
				com.addActionListener(l ->{
					json.genererJson();//Sur le jason qui contient l'arrayList des entreesChoisie on exécute genererJson;
					
				});
				panelBouton.add(s);
				panelBouton.add(com);
				


				panelSud.add(panelBouton, BorderLayout.CENTER);
				boutonSupp(entree," les entrees",w);//C'est les 3 boutons pour supprimer les entrées, ou les plats ou les desserts
				boutonSupp(plat," les plats	",ct);//Pour ça j'utilise la fonction boutonSupp définie plus loin
				boutonSupp(dessert," les desserts",e);
				

			
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
		System.out.println("menu: "+w.getListPlat());

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // quand on ferme la fenêtre (le cadre), on ferme aussi
																// le programme
		
//______________________________________________________________________________________________________________________________________
//______________________________________________________________________________________________________________________________________

	}
	public HashMap<String, Integer> recap(JPanels w, JLabel texte) {
		HashMap<String, Integer> sauveMoi = new HashMap<String, Integer>();

		for (JButtons b : w.getListB()) {

			b.addActionListener(ef -> {// on ajoute une action au bouton b
				 String nom = b.getP().getDescription();
	                if (sauveMoi.containsKey(nom)) {
	                    sauveMoi.put(nom, sauveMoi.get(nom) + 1);
	                } else {
	                    sauveMoi.put(nom, 1);
	                }

				// Parcours de la HashMap pour la convertir en chaîne de caractères
				StringBuilder sb = new StringBuilder();
				for (String key : sauveMoi.keySet()) {
				    sb.append(key).append(" : ").append(sauveMoi.get(key)).append("_");
				}

				// Définition du texte du JLabel avec la chaîne de caractères obtenue
				texte.setText(""+sb.toString());
				//texte.setText(sb.toString());
			});
		}
		return sauveMoi;
	}


//______________________________________________________________________________________________________________________________________
//______________________________________________________________________________________________________________________________________


	public void boutonSupp(JLabel entree, String nom, JPanels jpp) {//Fonction pour les 3 boutons supprimer
		JPanel panelDeLabel = new JPanel();
		panelDeLabel.setLayout(new BoxLayout(panelDeLabel, BoxLayout.LINE_AXIS));//permet de fixer les bouton à l'est
	
	JButton e = new JButton("Supprimer"+ nom);//Nom bouton
	e.addActionListener(l -> {
		HashMap<String, Integer> a=recap(jpp,entree);
				a.clear();
		entree.setText(" ");//efface le texte qu'il y a dans le JLabel ( dans le JLabel entree par ex)
		//hashmap.clear();HashMap<String, Integer> hashmap
		jpp.getListPlat().clear();
	
	});
	e.setMaximumSize(new Dimension(170,50));
	panelDeLabel.add(e, BorderLayout.PAGE_START);
	panelDeLabel.add(entree, BorderLayout.CENTER);
	panelSud.add(panelDeLabel);}
}