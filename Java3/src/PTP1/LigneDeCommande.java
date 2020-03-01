package PTP1;

import java.util.Scanner;

public class LigneDeCommande {
    private ProduitEnStock PR;
    private int QC;

    public LigneDeCommande() {
        Scanner obj = new Scanner(System.in);

        System.out.println("Quantite Commandée:  ");
        this.QC = obj.nextInt();
    }

    public LigneDeCommande(int QC) {
        this.QC = QC;
    }

    public void connecterProduit(ProduitEnStock PR) {
        this.PR = PR;
    }

    public double getPrixTotalLigne() {
        return (this.QC * this.PR.getPU());
    }

    public String toString() {
        return (this.PR.toStringCommande() + "\t" + this.QC + "\t" + this.PR.getPU()*QC);
    }
}