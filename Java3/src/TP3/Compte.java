package TP3;

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

    public Compte(String NC, int NCL, LocalDate date, double solde) {
        this.NC = NC;
        this.NCL = NCL;
        this.DO = date;
        this.Solde = solde;
    }

    public void afficher() {
        System.out.println("----------------------------Afficher----------------------------");
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

    public boolean equals(Compte C) {
        return (this.NC == C.NC);
    }

    public String toString(){
        return "NC: " + this.NC + "\nNCL: " + this.NCL + "\nDate: " + this.DO.getYear() + "-" + this.DO.getMonth() + "-" + this.DO.getDayOfMonth() + "\nSolder: " + this.Solde;
    }

    public static void main(String[] Args) {
        LocalDate date = LocalDate.of(2019, 10, 18);
        Compte C1 = new Compte("1204512", 17, date, 580.15);
        Compte C2 = new Compte("1204512", 17, date, 580.15);
        System.out.println("----------------------------==----------------------------");
        if (C1 == C2) {
            System.out.println("C1 = C2");
        } else {
            System.out.println("C1 != C2");
        }
        System.out.println("----------------------------Equals----------------------------");
        if (C1.equals(C2)) {
            System.out.println("C1 equals C2");
        } else {
            System.out.println("C1 differs C2");
        }
        C1.afficher();
        System.out.println("----------------------------ToString----------------------------");
        System.out.println(C1.toString());

    }

}