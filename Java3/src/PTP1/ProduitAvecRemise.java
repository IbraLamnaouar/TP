package PTP1;

import java.util.Scanner;

public class ProduitAvecRemise extends ProduitEnStock {

    public ProduitAvecRemise() {
        super();
        Scanner obj = new Scanner(System.in);

        System.out.println("Remise: ");
        this.TR = obj.nextDouble();
    }

    public ProduitAvecRemise(int Code, String Nom, double PU, int QS, double TR) {
        super(Code, Nom, PU, QS);
        this.TR = TR;
    }

    public String toString() {
        return (super.toString() + "\t"+ this.TR*100 + "%");
    }



    public double getPU() {
        return (this.PU - this.PU*this.TR);
    }



    public double ValeurEnStock() {
        return (this.QS * this.getPU());
    }
}