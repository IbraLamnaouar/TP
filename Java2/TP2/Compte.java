import java.util.*;



public class Compte{
    private String NC;
    private int NCL;
    private Date DO;
    private double Solde;

    public void saisir() {
        Scanner obj = new Scanner(System.in);

        System.out.println("Numero du compte: ");
        this.NC = obj.nextLine();
        System.out.println("Numero du client: ");
        this.NCL = obj.nextInt();
        System.out.println("Donner La date A M J: ");
        int a = obj.nextInt();
        int m = obj.nextInt();
        int j = obj.nextInt();
        this.DO = new Date();
        this.DO.setYear()
        System.out.println("Solde: ");
        this.Solde = obj.nextDouble();
    }

    public void afficher() {
        System.out.println("----------------------------Comptes----------------------------");
        System.out.println("NC: " + this.NC);
        System.out.println("NCL: " + this.NCL);
        System.out.println("DO: " + this.DO.getDate());
        System.out.println("Solde: " + this.Solde);
    }


    public static int main(String[] Args) {
        Compte C1 = new Compte();
        Compte C2 = new Compte();
        C1.saisir();
        C1.afficher();
        C2.saisir();
        C2.afficher();

        return (0);
    }

}