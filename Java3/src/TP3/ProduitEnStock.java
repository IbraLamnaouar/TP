package TP3;

import java.time.LocalDate;
import java.util.*;

public class ProduitEnStock {
    private int Code;
    private String Nom;
    private double PU;
    private int QS;
    private static int NP = 0;

    public ProduitEnStock() {
        Scanner obj = new Scanner(System.in);

        System.out.println("----- Saisir Un produit: ");
        System.out.println("Code: ");
        this.Code = obj.nextInt();
        System.out.println("Nom: ");
        this.Nom = obj.nextLine();
        System.out.println("Prix: ");
        this.PU = obj.nextDouble();
        System.out.println("Quantite: ");
        this.QS = obj.nextInt();
        ProduitEnStock.NP++;
    }

    public ProduitEnStock(int Code, String Nom, double PU, int QS) {
        this.Code = Code;
        this.Nom = Nom;
        this.PU = PU;
        this.QS = QS;
        ProduitEnStock.NP++;
    }

    public boolean equals(ProduitEnStock P) {
        return (P.Code == this.Code);
    }

    public String toString() {
        return ("Code: " + this.Code + "\nNom: "+ this.Nom + "\nPrix: "+ this.PU + "\nQuantite: "+ this.QS);
    }

    public void EntreEnStock(int Q) {
        this.QS += Q;
    }

    public boolean SortieDuStock(int Q) {
        if (Q > this.QS) {
            return false;
        }
        this.QS -= Q;
        return true;
    }

    public double ValeurEnStock() {
        return PU*QS;
    }

    public static int NombreDeProduit(){
        return ProduitEnStock.NP;
    }

    public static void main(String[] Args) {
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
        System.out.println("Produits: " + ProduitEnStock.NP);
    }

}