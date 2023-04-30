//import java.util.ArrayList;
//import java.util.HashMap;
//
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//public class Vision {
//	//public HashMap<String, Integer> sauveMoi;
//
//	public Vision() {
//
//		//this.sauveMoi = new HashMap<String, Integer>();
//
//	}
//
//	public HashMap<String, Integer> recap(JPanels w, JLabel texte) {
//		HashMap<String, Integer> sauveMoi = new HashMap<String, Integer>();
//
//		for (JButtons b : w.getListB()) {
//
//			b.addActionListener(ef -> {// on ajoute une action au bouton b
//				 String nom = b.getP().getDescription();
//	                if (sauveMoi.containsKey(nom)) {
//	                    sauveMoi.put(nom, sauveMoi.get(nom) + 1);
//	                } else {
//	                    sauveMoi.put(nom, 1);
//	                }
//
//				// Parcours de la HashMap pour la convertir en chaîne de caractères
//				StringBuilder sb = new StringBuilder();
//				for (String key : sauveMoi.keySet()) {
//				    sb.append(key).append(" : ").append(sauveMoi.get(key)).append("_");
//				}
//
//				// Définition du texte du JLabel avec la chaîne de caractères obtenue
//				texte.setText(""+sb.toString());
//				//texte.setText(sb.toString());
//			});
//		}
//		return sauveMoi;
//	}
//
//}
////for (JButtons b : w.getListB()) {
////	b.addActionListener(ef -> {// on ajoute une action au bouton b
////		b.getP().setQtt(b.getP().getQtt() + 1);// getP ça renvoie le plat qui correspond au bouton
////		// du coup on prend l'ecriture du bouton b et on modifie sa qtt; à chaque fois
////		// qu'on clique dessus, on ajoute 1.
////		texte.setText(// on modifie le texte contenu dans le label ENTREE
////				texte.getText() // du coup toujours dans le label qui est dans mon panel s on ecrit
////								// un texte
////						+ b.getP().getDescription()// dans le bouton b on prend la description et on l'écrit
////						+ "x" + b.getP().getQtt());
////
////	});