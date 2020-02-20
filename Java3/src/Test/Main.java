package Test;

import PTP1.Commande;
import PTP1.ProduitAvecRemise;
import PTP1.ProduitEnStock;
import PTP1.LigneDeCommande;

public class Main{
    public static void mainProduitEnStock(String[] Args) {
        System.out.println("----------------------------Produit En Stock----------------------------");
        System.out.println("Produits: " + ProduitEnStock.NombreDeProduit());
        ProduitEnStock P1 = new ProduitEnStock(15, "Orange", 1, 20);
        ProduitEnStock P2 = new ProduitEnStock(10, "Apple", 1.5, 100);
        System.out.println("----------------------------Afficher----------------------------");
        System.out.println(P1.toString());
        System.out.println("Valeur: " + P1.ValeurEnStock());
        System.out.println(P2.toString());
        System.out.println("Valeur: " + P2.ValeurEnStock());
        System.out.println("----------------------------Compare----------------------------");
        if (P1.equals(P2)) {
            System.out.println("P1 = P2");
        } else {
            System.out.println("P1 != P2");
        }
        System.out.println("----------------------------Add And Remove----------------------------");
        P1.EntreEnStock(20);
        P2.SortieDuStock(40);
        System.out.println(P1.toString());
        System.out.println(P2.toString());
        System.out.println("--------------------------------ReCompare----------------------------");
        if (P1.equals(P2)) {
                System.out.println("P1 = P2");
        } else {
                System.out.println("P1 != P2");
        }

        System.out.println("----------------------------New Produit En Stock----------------------------");
        System.out.println("Produits: " + ProduitEnStock.NombreDeProduit());
    }

    public static void mainProduitAvecRemise(String[] Args) {
        System.out.println("----------------------------Produit En Stock Avec Remise----------------------------");
        System.out.println("Produits: " + ProduitEnStock.NombreDeProduit());

        ProduitEnStock P1 = new ProduitAvecRemise();
        ProduitEnStock P2 = new ProduitEnStock();

        System.out.println("----------------------------Afficher----------------------------");
        System.out.println("----------------------------P1----------------------------");
        System.out.println(P1.toString());
        System.out.println("Valeur: " + P1.ValeurEnStock());
        System.out.println("----------------------------P2----------------------------");
        System.out.println(P2.toString());
        System.out.println("Valeur: " + P2.ValeurEnStock());
        System.out.println("----------------------------Compare----------------------------");
        if (P1.equals(P2)) {
            System.out.println("P1 = P2");
        } else {
            System.out.println("P1 != P2");
        }
        System.out.println("----------------------------Add And Remove----------------------------");
        P1.EntreEnStock(20);
        P2.SortieDuStock(40);
        System.out.println(P1.toString());
        System.out.println(P2.toString());
        System.out.println("--------------------------------ReCompare----------------------------");
        if (P1.equals(P2)) {
                System.out.println("P1 = P2");
        } else {
                System.out.println("P1 != P2");
        }

        System.out.println("----------------------------New Produit En Stock----------------------------");
        System.out.println("Produits: " + ProduitEnStock.NombreDeProduit());
    }

    public static void mainLigneDeCommande(String[] Args) {
        System.out.println("----------------------------Ligne De Commande----------------------------");

        ProduitEnStock P1 = new ProduitAvecRemise(14214, "Apple", 5, 100, 1);
        ProduitEnStock P2 = new ProduitEnStock(12154, "Orange", 5, 100);

        LigneDeCommande L1 = new LigneDeCommande();
        LigneDeCommande L2 = new LigneDeCommande(10);

        L1.connecterProduit(P1);
        L2.connecterProduit(P2);

        System.out.println("----------------------------Afficher----------------------------");
        System.out.println("Cmd\tCode\tNom\tPU\tTR\tQC\tPrix\tRemise");
        System.out.println("L1\t" + L1.toString());
        System.out.println("L2\t" + L2.toString());
    }

    public static void main(String[] Args) {
        System.out.println("----------------------------Ligne De Commande----------------------------");

        ProduitEnStock P1 = new ProduitAvecRemise(14214, "Apple", 5, 100, 0.2);
        ProduitEnStock P2 = new ProduitEnStock(12154, "Orange", 5, 100);

        LigneDeCommande L1 = new LigneDeCommande(15);
        LigneDeCommande L2 = new LigneDeCommande(10);

        L1.connecterProduit(P1);
        L2.connecterProduit(P2);

        Commande C = new Commande();
        C.AjouterLigneCommande(L1);
        C.AjouterLigneCommande(L2);

        System.out.println("----------------------------Afficher----------------------------");
        System.out.println(C.toString());
    }


}