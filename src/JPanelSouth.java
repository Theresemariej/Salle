//import java.awt.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import javax.swing.*;
//
//public class JPanelSouth extends JPanel {
//
//	private JLabel entree;
//	private JLabel plat;
//	private JLabel dessert;
//	private Json json;
//	
//
//	
//	public JPanelSouth(ArrayList<Plat> entreesChoisies) {
//		
//		this.entree=new JLabel();
//		this.plat=new JLabel();
//		this.dessert=new JLabel();
//		this.json= new Json(entreesChoisies);
//		
//		
//
//		setUp();
//	}
//	
//
//	private void setUp() {
//        
//		JPanel panelBouton= new JPanel();
//		
//		panelBouton.setLayout(new GridLayout(1, 2, 10, 10)); //grille dans laquelle on met les 2 boutons
//		this.setLayout(new GridLayout(4, 1, 10, 10)); //grille dans laquelle on met la grilleDesBoutons et les label héhéhéhéhéhéhéhéhééhéhéhééhéhéhéhéhéhééhéhéhé		
//		
//		JButton s = new JButton("annuler");//permet de tout annuler
//		s.addActionListener(l -> {
//			entree.setText(" ");
//			plat.setText(" ");
//			dessert.setText(" ");
//		});
//	
//
//		JButton c= new JButton("commander");//COMMANDE
//		c.addActionListener(l ->{
//			json.genererJson();//Sur le jason qui contient l'arrayList des entreesChoisie on exécute genererJson;
//			
//		});
//		panelBouton.add(s);
//		panelBouton.add(c);
//
//		this.add(panelBouton, BorderLayout.CENTER);
//		this.boutonSupp(entree," les entrees");//C'est les 3 boutons pour supprimer les entrées, ou les plats ou les desserts
//		this.boutonSupp(plat," les plats	");//Pour ça j'utilise la fonction boutonSupp définie plus loin
//		this.boutonSupp(dessert,"les desserts");
//		
//
//	
//		this.setBackground(Color.WHITE);
//		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE),
//				BorderFactory.createEmptyBorder(8, 3, 3, 8)));//cree un bordure autour de tout le panelSouth
//	}
//	public void boutonSupp(JLabel entree, String nom) {//Fonction pour les 3 boutons supprimer
//		JPanel panelDeLabel = new JPanel();
//		panelDeLabel.setLayout(new BoxLayout(panelDeLabel, BoxLayout.LINE_AXIS));//permet de fixer les bouton à l'est
//	
//	JButton e = new JButton("Supprimer"+ nom);//Nom bouton
//	e.addActionListener(l -> {
//		entree.setText(" ");//efface le texte qu'il y a dans le JLabel ( dans le JLabel entree par ex)
//	});
//	e.setMaximumSize(new Dimension(170,50));
//	panelDeLabel.add(e, BorderLayout.PAGE_START);
//	panelDeLabel.add(entree, BorderLayout.CENTER);
//	this.add(panelDeLabel);}
//		
//		
//
////	/**
////	 * @return the entree
////	 */
////	public JLabel getEntree() {
////		return entree;
////	}
////
////	/**
////	 * @param entree the entree to set
////	 */
////	public void setEntree(JLabel entree) {
////		this.entree = entree;
////	}
//
//	/**
//	 * @return the plat
//	 */
//	public JLabel getPlat() {
//		return plat;
//	}
//
//	/**
//	 * @param plat the plat to set
//	 */
//	public void setPlat(JLabel plat) {
//		this.plat = plat;
//	}
//
//	/**
//	 * @return the dessert
//	 */
//	public JLabel getDessert() {
//		return dessert;
//	}
//
//	/**
//	 * @param dessert the dessert to set
//	 */
//	public void setDessert(JLabel dessert) {
//		this.dessert = dessert;
//	}
//}