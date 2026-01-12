import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /** initialisation du plateau de jeu avec des ? dans toute les cases, compteur de coups et msg accueil**/
        String[][] plateauJeu = new String[4][4];
        int longueurPlateauJeu = plateauJeu.length;
        int cmpNbCoup=0;
        System.out.println("Micro bataille navale !");

        for (int i =0;i < longueurPlateauJeu;i++){
            for (int j=0;j<longueurPlateauJeu;j++ ){
                plateauJeu[i][j]="?";
            }
        }

        /** initialisation des coordonnées du bateau de façon aléatoire **/
        Random randomGeneretor = new Random();
        int randomNumbers1 = randomGeneretor.nextInt(longueurPlateauJeu);
        int randomNumbers2 = randomGeneretor.nextInt(longueurPlateauJeu);
        //System.out.println("  nb ramdom colonne : "+randomNumbers2+" ligne : " + randomNumbers1);

        System.out.println("saisir les coordonnées de tir\n");
        int inputColonne=5;
        int inputLigne=5;
        Scanner sc = new Scanner(System.in);

        /** boucle de jeu : le jeu continue tant que le bateau n'est pas touché **/
        while (randomNumbers1!=inputLigne && randomNumbers2!=inputColonne){
            System.out.print("Quelle colonne ?");
            inputColonne = (sc.nextInt()-1);
            System.out.print("Quelle ligne ?");
            inputLigne= (sc.nextInt()-1);
            //System.out.println("input ligne : " + inputLigne + " input colonne : " + inputColonne);
            cmpNbCoup++;
            if(randomNumbers1!=inputLigne && randomNumbers2!=inputColonne){
                System.out.println("Plouf ! A l'eau ! \n");
                plateauJeu[inputLigne][inputColonne] = String.valueOf('~');
            }else {plateauJeu[inputLigne][inputColonne] = String.valueOf('*');}

            afficherPlateau(plateauJeu);

        }

        System.out.println("Boom ! Touché coulé \n" +
                "Bravo, vous avez gagné en " +cmpNbCoup+ " coups !");
    }
    
    public static void afficherPlateau(String tab[][]){
        for (int i =0;i < tab.length;i++){
            for (int j=0;j<tab.length;j++ ){
                System.out.print(tab[i][j]);
            }
            System.out.println(' ');
        }
    }
}