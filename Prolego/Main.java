import java.util.Scanner;

// This is the implementation of https://www.prologin.org/training/challenge/qcm2013/prolego
public class Main {

    public static void tripliquerBriques(int[][] briques, int N)
    {
        int x;
        for (int i=0; i<N; i++)
        {
            if (briques[0][i] < briques[1][i])
            {
                x = briques[0][i];
                briques[0][i] = briques[1][i];
                briques[1][i] = x;
            }

            if (briques[0][i] < briques[2][i])
            {
                briques[0][N+i] = briques[2][i];
                briques[1][N+i] = briques[0][i];
            }
            else
            {
                briques[0][N+i] = briques[0][i];
                briques[1][N+i] = briques[2][i];
            }
            briques[2][N+i] = briques[1][i];

            if (briques[1][i] < briques[2][i])
            {
                briques[0][2*N+i] = briques[2][i];
                briques[1][2*N+i] = briques[1][i];
            }
            else
            {
                briques[0][2*N+i] = briques[1][i];
                briques[1][2*N+i] = briques[2][i];
            }
            briques[2][2*N+i] = briques[0][i];
        }
    }

    public static void echanger(int[][] briques, int i, int j) {
        int x = briques[0][i];
        int y = briques[1][i];
        int z = briques[2][i];
        briques[0][i] = briques[0][j];
        briques[1][i] = briques[1][j];
        briques[2][i] = briques[2][j];
        briques[0][j] = x;
        briques[1][j] = y;
        briques[2][j] = z;
    }

    public static int partition(int[][] briques, int a, int g, int d)
    {

        int cle = briques[a][g];
        int i = g+1;
        int j = d;

        while (i < j ) {
            while (briques[a][i] <= cle && i!= briques[0].length-1)
                i = i+1;
            while (briques[a][j] > cle && j!=0)
                j = j-1;
            if ( i < j ) {
                echanger(briques, i, j);
                i = i++;
                j = j--;
            }
        }
        if (cle > briques[a][j]) {
            echanger(briques, g , j);
        }
        return (j);
    }

    public static void quickSort(int[][] briques, int a, int g, int d) {

        int x=0;
        if (g < d)
        {
            x = partition(briques, a, g, d);
            quickSort(briques, a, g, x-1);
            quickSort(briques, a, x+1, d);
        }
    }

    public static int[][] tableauDesPossibles(int[][] briques, int N) {
        int[][] tableauDesPossibles = new int[3*N][3*N-1];
        int k =0;
        for (int i=1; i<3*N; i++){
            k = 0 ;
            for (int j= 0; j<i; j++){
                if (briques[0][i]> briques[0][j] && briques [1][i]> briques[1][j]){
                    tableauDesPossibles[i][k] = j+1;
                    k++ ;
                }

            }

        }
        return tableauDesPossibles;
    }

    public static int parcoursTableau(int[][] briques, int N, int[][]tableauDesPossibles,int hauteurTourMax, int hauteur,  int i) {
        hauteur = hauteur + briques[2][i];

        int compteur = 0;
        while ( compteur<(3*N-1) && tableauDesPossibles[i][compteur] != 0 ) {
            compteur = compteur +1 ;
        }

        if (compteur == 0 && hauteur>hauteurTourMax) {
            hauteurTourMax = hauteur;
        }
        else {
            for (int j=0; j<compteur; j++ ) {
                if (tableauDesPossibles[i][j] != 0 ) {
                    hauteurTourMax = parcoursTableau(briques, N, tableauDesPossibles, hauteurTourMax, hauteur, tableauDesPossibles[i][j]-1);
                }
                else if (hauteur>hauteurTourMax) {
                    hauteurTourMax = hauteur;
                }
            }
        }

        return hauteurTourMax;
    }

    public static int prolego(int[][] briques, int N){
        tripliquerBriques(briques, N);
        quickSort(briques, 0, 0, 3*N-1);
        int a = briques[0][0];
        int b = briques[0][3*N-1];
        int compteur = 0;
        int g;

        for (int i = a; i <= b ; i++) {

            if (compteur < 3*N && briques [0][compteur] == i){
                g = 0;
                while (compteur < 3*N && briques [0][compteur] == i) {
                    compteur = compteur +1;
                    g = g +1 ;
                }
                if (g != 1 ){
                    quickSort(briques, 1, compteur - g , compteur-1);
                }
            }


        }

        int[][] tableauDesPossibles = tableauDesPossibles(briques,N);
        int hauteur;
        int hauteurTourMax = 0;
        for (int i=0; i<3*N ; i++){
            hauteur=0;
            hauteurTourMax = parcoursTableau(briques, N,tableauDesPossibles,hauteurTourMax,hauteur, i);
        }

        return hauteurTourMax;

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();
        scanner.nextLine();
        int[][] briques = new int[3][3*N];

        for (int i=0; i<N; i++){
            briques[0][i]=scanner.nextInt();
            briques[1][i]=scanner.nextInt();
            briques[2][i]=scanner.nextInt();
        }

        int resultat = prolego(briques , N);
        System.out.println(resultat);

    }
}
