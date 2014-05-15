import java.util.Scanner;

// This is the implementation of https://www.prologin.org/training/challenge/qcm2013/cambriolage
public class Main {

    public static int nombrePassePartout(int N, int[][] passePartout, int M, int[][] serrure){

        int a=0;
        int b=0;
        int c=0;
        int sNewMax=0;
        int sOldMax=0;

        for (int i=0; i<M; i++) {
            if (serrure[0][i]==1){
                if (serrure[1][i]>sNewMax)
                    sNewMax=serrure[1][i];
            }
            else {
                if(serrure[1][i]>sOldMax)
                    sOldMax=serrure[1][i];
            }
        }

        for (int i=0; i<N && c!=1; i++) {
            if (passePartout[0][i]>= sOldMax){
                b=1;
                if (passePartout[1][i]>=sNewMax){
                    c=1;
                }
            }
            if (passePartout[1][i]>=sNewMax){
                a=1;
            }
        }

        if (a==1 && b==1) {
            if (c !=1){
                c=2;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        int M;

        N= scanner.nextInt();
        int passePartout[][]=new int[2][N];
        scanner.nextLine();

        for (int i=1; i<=N; i++){
            passePartout[0][i-1] = scanner.nextInt();
            passePartout[1][i-1] = scanner.nextInt();
            scanner.nextLine();
        }

        M=scanner.nextInt();
        int serrure[][]=new int[2][M];
        scanner.nextLine();

        for (int i=1; i<=M; i++){
            serrure[0][i-1]= scanner.nextInt();
            serrure[1][i-1]=scanner.nextInt();
            scanner.nextLine();
        }
        scanner.close();
        System.out.println(nombrePassePartout(N,passePartout,M,serrure));
    }
}
