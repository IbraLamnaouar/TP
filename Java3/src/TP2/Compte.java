package TP2;

import java.time.LocalDate;
import java.util.*;

public class Compte{
    private String NC;
    private int NCL;
    private LocalDate DO;
    private double Solde;

    public Compte() { //old name: public void saisir();
        Scanner obj = new Scanner(System.in);

        System.out.println("----- Saisir le compte: ");
        System.out.println("Numero du compte: ");
        this.NC = obj.nextLine();
        System.out.println("Numero du client: ");
        this.NCL = obj.nextInt();
        System.out.println("Donner La date A M J: ");
        int a = obj.nextInt();
        int m = obj.nextInt();
        int j = obj.nextInt();
        this.DO = LocalDate.of(a, m, j);
        System.out.println("Solde: ");
        this.Solde = obj.nextDouble();
    }

    public Compte(String NC, int NCL, int a, int m, int j, double solde) {
        this.NC = NC;
        this.NCL = NCL;
        this.DO = LocalDate.of(a, m, j);
        this.Solde = solde;
    }

    public void afficher() {
        System.out.println("----------------------------Compte----------------------------");
        System.out.println("NC: " + this.NC);
        System.out.println("NCL: " + this.NCL);
        System.out.println("DO: " + this.DO.getYear() + "-" + this.DO.getMonth() + "-" + this.DO.getDayOfMonth());
        System.out.println("Solde: " + this.Solde);
    }

    public void Deposer(double amount){
        this.Solde += amount;
    }

    public boolean Retirer(double amount){
        if (amount > this.Solde) {
            return false;
        }
        this.Solde -= amount;
            return true;
    }

    public boolean Virer(Compte C, double amount) {
        if (this.Solde < amount) {
            return false;
        }
        this.Solde -= amount;
        C.Solde += amount;
        return true;
    }

    public static void main(String[] Args) {
        Compte C1 = new Compte();
        Compte C2 = new Compte("1204512", 17, 2017, 8, 29, 580.15);
        System.out.println("----------------------------Compte----------------------------");
        C1.afficher();
        C2.afficher();
        System.out.println("----------------------------Deposer 170 ----------------------------");
        C1.Deposer(170);
        C1.afficher();
        System.out.println("----------------------------Retirer 500----------------------------");
        C2.Retirer(500);
        C2.afficher();
        System.out.println("----------------------------Virer 170----------------------------");
        C1.Virer(C2, 170);
        C1.afficher();
        C2.afficher();
    }

}