import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // === Saisie des informations de l'employé ===
        System.out.println("Calculateur de bulletin de salaire\n" +
                "Veuillez saisir le nom de l'employé : ");
        Scanner sc = new Scanner(System.in);
        String nom = sc.next();
        System.out.println("Veuillez saisir le prénom de l'employé : ");
        String prenom = sc.next();

        // === Choix du statut de l'employé ===
        System.out.println("Veuillez sélectionner le status de l'employé : \n" +
                "1.cadre\n" +
                "2.agent de maîtrise\n" +
                "3.employé de bureau\n");
        int choix = sc.nextInt();

        // Attribution du statut selon le choix
        String status = switch (choix) {
            case 1 -> "cadre";
            case 2 -> "agent de maîtrise";
            case 3 -> "employé de bureau";
            default -> "";
        };

        // === demande du nombre d'enfant de l'employé pour calculer la prime ===
        System.out.println("Veuillez saisir le Nombre d'enfants de l'employé ? ");
        int nbEnfant = sc.nextInt();

        // === demande info et Calcul du salaire de base ===
        System.out.println("Veuillez saisir le taux horaire de l'employé : ");
        float tauxHoraire = sc.nextFloat();

        System.out.println("Veuillez saisir nombre d’heures effectuées par l'employé ce mois ci : ");
        float salaireBase;
        float nbHeures = sc.nextFloat();


        if(nbHeures >=0 && nbHeures <169){
            salaireBase = nbHeures * tauxHoraire;


        } else if(nbHeures >=169 && nbHeures <180){
            salaireBase = (float) ((nbHeures * tauxHoraire)*1.5);

        }else{
            salaireBase = (float) ((nbHeures * tauxHoraire)*1.6);

        }
        // === Calcul des cotisations sociales ===
        float cotisations;
        float cotiSociale = (float) ((salaireBase * 3.49)/100);
        float cotiSocialeGeneral = (float) ((salaireBase * 6.15)/100);
        float cotiAssuMaladie = (float) ((salaireBase * 0.95)/100);
        float cotiAssuVieillesse = (float) ((salaireBase * 8.44)/100);
        float cotiAssuChomage = (float) ((salaireBase * 3.05)/100);
        float cotiRetraiteComple = (float) ((salaireBase * 3.81)/100);
        float cotiAGFF = (float) ((salaireBase * 1.02)/100);
        cotisations = cotiSociale + cotiSocialeGeneral + cotiAssuMaladie+cotiAssuVieillesse+cotiAssuChomage+cotiRetraiteComple+cotiAGFF;

        int prime;
        // === Calcul de la prime en fonction du nombre d'enfants ===
        switch (nbEnfant){
            case 0:
                prime = 0;
                break;
            case 1:
                prime = 20;
                break;
            case 2:
                prime = 50;
                break;
            default:
                prime = 70 + (20*(nbEnfant-2));
                break;
        }
        // === Calcul du salaire net à payer ===
        float netPayer = salaireBase - cotisations + prime;
        // === Affichage du bulletin de salaire ===
        System.out.println("Bulletin de salaire" +
                "\nnom : "+ nom +
                "\nprenom : " + prenom +
                "\nstatus : " + status +
                "\nTaux horaire : " + tauxHoraire+ "€"+
                "\nnombres d'heures effectuées ce mois ci :" +nbHeures+
                "\nSalaire de base : +" +salaireBase + "€"+
                "\ncotisations : -" + cotisations+ "€"+
                "\nPrime calculé en fonction du nombres d'enfant : +" + prime+"€"+
                "\nNet à payer : "+netPayer+"€");

        sc.close();
    }
}