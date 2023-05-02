import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

public class JPanels extends JPanel {

	private String nom;
//	private String n1;
//	private String n2;
//	private String n3;
	private ArrayList<Plat> listeNourriture;
	private ArrayList<Plat> listPlat;
	private ArrayList<JButtons> listB;

	public JPanels(String nom, ArrayList<Plat> l) {

		this.nom = nom;
		this.listeNourriture = l;
		this.listB=new ArrayList<JButtons>();
		this.listPlat=new ArrayList<Plat>();

		

		setUp();
	}

	private void setUp() {
	    this.setPreferredSize(new Dimension(275, 0));
		this.setLayout(new BorderLayout()); 
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE),
				BorderFactory.createEmptyBorder(8, 3, 3, 8)));//cree une bordure de tout le JPanel

		
		JLabel titre = new JLabel(nom);//C'est là ou on écrit entree ou dessert ou plat.
		titre.setForeground(Color.GRAY);//ecriture blanche
		//titre.setHorizontalAlignment(JLabel.CENTER);
		
		//pour que le cadre soit tout autour du panel qui contient mon titre
		JPanel jp = new JPanel();
		jp.setPreferredSize(new Dimension(0,30));//hauteur de jp	
		jp.setBorder( BorderFactory.createLineBorder(Color.GRAY, 1) ); // ajoute une bordure tout autour de jp
		jp.add(titre);
		this.add(jp,BorderLayout.NORTH);
		
		JPanel jp2 = new JPanel();

		jp2.setLayout(new GridLayout(0, 1, 5, 5));
		for (Plat a : listeNourriture) {
			JButtons b = new JButtons(a);
			jp2.add(b);//Chaque Plat 'a' cree une nouvelle case dans ma grille (dans laquelle il exécute 'getDescription' qui donne le nom du plat)
			listB.add(b);
		}
		
		
		
		jp.setBackground(Color.WHITE);
		jp2.setBackground(Color.WHITE);
		this.setBackground(Color.WHITE);//on met tout le fond en blanc pasque c'est moins moche comme ça
		this.add(jp2,BorderLayout.CENTER);
		System.out.println("cc"+listB);
	}

	/**
	 * @return the listB
	 */
	public ArrayList<JButtons> getListB() {//c'est la liste de tous les boutons, on en a besoin dans vision pour afficher le menu commandé
		return listB;
	}

	public ArrayList<Plat> getListPlat() {//ça c'est tous les plats sur qui on a cliqué
		return listPlat;
		
	}

	
}