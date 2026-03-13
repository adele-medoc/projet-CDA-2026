import java.util.Scanner;

class EstimationPrixVoiture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("******* Utilitaire estimation de voiture ***** ");
        System.out.println("Quelle est le prix neuf:");
        double prixNeufVoiture = sc.nextDouble();
        System.out.println("Quelle est le kilometrage:");
        double kilometrage = sc.nextDouble();
        System.out.println("Ancienneté (en année):");
        double anciennete = sc.nextDouble();

        double decote = 0.05*(kilometrage/10000) + 0.01*anciennete;
        double valeurVoitureActuelle = prixNeufVoiture * (1-decote);
        System.out.printf("Le prix estimé de votre voiture est de : %.2f", valeurVoitureActuelle);
        sc.close();
    }
}