package PTP1;


import java.time.LocalDate;
import java.util.Vector;

public class Commande {
    private static int ID = 1;
    private int NC;
    private LocalDate DC;
    private Vector<LigneDeCommande> TLC;

    public Commande() {
        this.NC = this.ID++;
        this.DC = LocalDate.now();
        this.TLC = new Vector<>();
    }

    public void AjouterLigneCommande(LigneDeCommande LDC) {
        this.TLC.add(LDC);
    }

    public double getPrixTotalCommande() {
        double P = 0;
        for (int i = 0; i < this.TLC.size(); i++) {
            P += this.TLC.get(i).getPrixTotalLigne();
        }
        return P;
    }

    public String toString() {
        String out = "Numero Commande: " + this.NC + "\n";
        out += "Date: " + this.DC.getDayOfMonth() + " " + this.DC.getMonth() + " " + this.DC.getYear() + "\n";
        out += "Produits Commandées: \n";
        out += "Code\tNom\tPU\tRemise\tQC\tPrix\n";
        for (int i = 0; i < this.TLC.size(); i++) {
            out += this.TLC.get(i).toString() + "\n";
        }
        out += "\n\n\t\t\tPrix Total: " + this.getPrixTotalCommande();
        return out;
    }



}