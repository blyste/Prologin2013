import java.util.Scanner;

// This is the implementation of https://www.prologin.org/training/challenge/qcm2013/tour_de_magie
class Main
{
    private static void genererCartes(int N)
    {
        int n=0;
        int M;
        int P;

        while (Math.pow(2,n)<=N)
            n=n+1;

        if (N==1) {
            System.out.println(1);
        }
        else {

            for (int i = 0; i < n; i++){

                M = (int) Math.pow(2, i);
                P=0;
                do
                {
                    for (int j=0; j<=Math.pow(2, i)-1 && P<N; j++){
                        P=M+j;
                        System.out.print(" " +P );
                    }
                    M= M + (int) Math.pow(2,i+1);
                }while (M<=N);
                System.out.println();
            }
        }
    }

    public static void main(String args[]) throws java.io.IOException
    {
        Scanner scanner = new Scanner(System.in);
        int N;

        N = scanner.nextInt();
        scanner.nextLine();

        genererCartes(N);
    }
}
