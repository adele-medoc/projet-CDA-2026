import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Morpion");
        String[][] grilleJeu = new String [3][3];
        Scanner sc = new Scanner(System.in);
        String numeroJoueur = "";
        String symboleJoueur;

        for (int i =0;i<grilleJeu.length;i++){
            for (int j=0;j< grilleJeu.length;j++){
                grilleJeu[i][j]= " ";
            }
        }
        afficherGrille(grilleJeu);

           for (int i =0; i<9;i++){
            if (i %2 ==0){
                numeroJoueur = "Joueur 1";
                symboleJoueur = "O";
            }else{
                numeroJoueur = "Joueur 2";
                symboleJoueur = "X";
            }
            System.out.println(numeroJoueur + ", saisir les coordonnés du symbole à placer :\n" +
                    "Quelle Colonne ? ");

            int coordonneColonne = sc.nextInt()-1;
//            System.out.println("coor C : "+coordonneColonne);
            System.out.println("Quelle ligne ?");

            int coordonneLigne = sc.nextInt()-1;
//            System.out.println("coor L : "+coordonneLigne);
            while (coordonneColonne >=3 || coordonneLigne>=3){

                System.out.println("impossible de placer un symbole en dehors de la grille");

                System.out.println("Quelle ligne ?");
                coordonneLigne = sc.nextInt()-1;

                System.out.println("Quelle Colonne ?");
                coordonneColonne = sc.nextInt()-1;

            }

            if (grilleJeu[coordonneLigne][coordonneColonne]==" "){
                grilleJeu[coordonneLigne][coordonneColonne] = symboleJoueur;
            }else {
                do {
                    System.out.println("impossible de placer un symbole sur une case déjà occupé");

                    System.out.println("Quelle ligne ?");
                    coordonneLigne = sc.nextInt()-1;
                    System.out.println("Quelle Colonne ?");
                    coordonneColonne = sc.nextInt()-1;

                }while (!grilleJeu[coordonneLigne][coordonneColonne].equals(" "));
                grilleJeu[coordonneLigne][coordonneColonne] = symboleJoueur;
            }
               boolean conditionVictoire1 = grilleJeu[0][0].equals(grilleJeu[1][1])&&grilleJeu[1][1].equals(grilleJeu[2][2])&& !grilleJeu[0][0].equals(" ");
               boolean conditionVictoire2 = grilleJeu[2][0].equals(grilleJeu[1][1])&&grilleJeu[1][1].equals(grilleJeu[0][2]) && !grilleJeu[2][0].equals(" ");

               boolean conditionVictoire3 = grilleJeu[0][0].equals(grilleJeu[0][1])&&grilleJeu[0][1].equals(grilleJeu[0][2]) && !grilleJeu[0][0].equals(" ");
               boolean conditionVictoire4 = grilleJeu[1][0].equals(grilleJeu[1][1])&&grilleJeu[1][1].equals(grilleJeu[1][2])&& !grilleJeu[1][0].equals(" ");
               boolean conditionVictoire5 = grilleJeu[2][0].equals(grilleJeu[2][1])&&grilleJeu[2][1].equals(grilleJeu[2][2])&& !grilleJeu[2][0].equals(" ");

               boolean conditionVictoire6 = grilleJeu[0][0].equals(grilleJeu[1][0])&&grilleJeu[1][0].equals(grilleJeu[2][0])&& !grilleJeu[0][0].equals(" ");
               boolean conditionVictoire7 = grilleJeu[0][1].equals(grilleJeu[1][1])&&grilleJeu[1][1].equals(grilleJeu[2][1])&& !grilleJeu[0][1].equals(" ");
               boolean conditionVictoire8 = grilleJeu[0][2].equals(grilleJeu[1][2])&&grilleJeu[1][2].equals(grilleJeu[2][2])&& !grilleJeu[0][2].equals(" ");
               boolean conditionVictoire = conditionVictoire1 || conditionVictoire2 || conditionVictoire3 || conditionVictoire4 || conditionVictoire5 || conditionVictoire6 || conditionVictoire7 || conditionVictoire8;

               afficherGrille(grilleJeu);

            if (conditionVictoire){
                System.out.println("FIN DE PARTIE    ");

                    System.out.print("le "+numeroJoueur + " a gagner avec le symbole " + symboleJoueur);
                    break;
            }
               if(i==8){
                   System.out.println("FIN DE PARTIE Match nul");
               }

        }
        sc.close();
    }

    public static void afficherGrille(String tab[][]){
        for (int i=0;i< tab.length;i++){
            for (int j=0;j< tab.length;j++){
                System.out.print("|"+tab[i][j]+"|");
            }
            System.out.println(" ");
        }
    }
}
