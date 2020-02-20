package PTP1;

import java.util.Scanner;

public class ProduitEnStock implements Cloneable{
    protected int Code;
    protected String Nom;
    protected double PU;
    protected int QS;
    protected static int NP = 0;
    protected double TR;


    public ProduitEnStock() {
        Scanner obj = new Scanner(System.in);

        System.out.println("");
        System.out.println("------------------ Saisir Un produit------------------ ");
        System.out.println("Nom: ");
        this.Nom = obj.nextLine();
        System.out.println("Code: ");
        this.Code = obj.nextInt();
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

    public double getPU() { return (this.PU); }

    public int getQS() { return (this.QS); }

    public String getNom() { return (this.Nom); }

    public int getCode() { return (this.Code); }

    public double getTR() { return (this.TR); }

    public void EntreEnStock(int Q) {
        this.QS += Q;
    }

    public void SortieDuStock(int Q) {
        if (Q > this.QS) {
            return;
        }
        this.QS -= Q;
    }

    public double ValeurEnStock() {
        return PU*QS;
    }

    public static int NombreDeProduit(){
        return ProduitEnStock.NP;
    }


}