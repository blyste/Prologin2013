import java.util.Scanner;
import java.util.ArrayList;

// This is the implamentation of https://www.prologin.org/training/challenge/qcm2013/grolopin
public class Main {
    private static int grolopin (int N, int M, ArrayList<String> pins) {
        int a = 0;
        int b = 1;

        for (int i=0; i<N-1 && b==1; i++) {
            for (int j=i+1; j<N && b==1; j++) {
                for (int k=0; k<M; k++) {
                    if (pins.get(i).charAt(k)==pins.get(j).charAt(k)) {
                        if (pins.get(i).charAt(k)=='o') {
                            a = a+1;
                        }
                    }
                }
                if (a!=1){
                    b=0;
                }
                a=0;
            }
        }
        return b ;
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        int M;

        N= scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine();

        ArrayList<String> pins = new ArrayList<String>();

        for (int i=1; i<=N; i++){
            String string = scanner.nextLine();
            pins.add(string);
        }

        scanner.close();
        System.out.println(grolopin(N,M,pins));
    }

}
