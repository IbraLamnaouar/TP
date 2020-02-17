package src;

public class Main() {
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
        System.out.println("----------------------------ReCompare----------------------------");
        if (P1.equals(P2)) {
        System.out.println("P1 = P2");
        } else {
        System.out.println("P1 != P2");
        }

        System.out.println("----------------------------New Produit En Stock----------------------------");
        System.out.println("Produits: " + ProduitEnStock.NP);
        }
        }