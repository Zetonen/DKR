package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int i,j,z,a,b,c,max,T;
        Boolean [] prov = new Boolean [99];
        for (i=0; i<prov.length; i++) {
             prov[i] = false;
        }
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите количество строк  ");
        int M = scan.nextInt();
        System.out.println("Введите количество столбцов  ");
        int N = scan.nextInt();
        int[][] MN = new int[M][N];
        int[][] MN1 = new int[M][N];
        int[][] MN2 = new int[M][N];

        System.out.println("Рандом массив");
        for ( i=0; i<M; i++){
            for( j=0; j<N; j++){
                do {
                    MN[i][j]= ((int)(Math.random() * 199) - 99);
                    a=Math.abs(MN[i][j]);
                     MN1[i][j]=MN[i][j];
                     MN2[i][j]=MN[i][j];
                }while (prov[a]==true);
                prov [a]=true;
            }
        }


        max=MN[0][0];
        b=Math.abs(max);

        for ( i=0; i<M; i++){
            for( j=0; j<N; j++){
                c=Math.abs(MN[i][j]);
                if(c>b){
                    max=MN[i][j];
                    b=c;
                }
            }
        }

        for ( z=0; z<M; z++) {
            T=MN[z][0];
            for (i = N-1; i >0; i--) {
                for (j = 0; j < i; j++) {
                    if (MN1[z][j]>MN1[z][j+1]){
                        T= MN1[z][j];
                        MN1[z][j]= MN1[z][j+1];
                        MN1[z][j+1]= T;
                    }
                }
            }
        }

        for ( z=0; z<N; z++) {
            T=MN[0][z];
            for (i = M-1; i >0; i--) {
                for (j = 0; j < i; j++) {
                    if (MN2[j][z]>MN2[j+1][z]){
                        T= MN2[j][z];
                        MN2[j][z]= MN2[j+1][z];
                        MN2[j+1][z]= T;
                    }
                }
            }
        }

        for ( i=0; i<M; i++){
            for( j=0; j<N; j++){
                System.out.print(MN[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Самое большое число по модулю : "+max);

        System.out.println("Массив по строкам : ");
        for ( i=0; i<M; i++){
            for( j=0; j<N; j++){
                System.out.print(MN1[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("Массив по столбцам : ");
        for ( i=0; i<M; i++){
            for( j=0; j<N; j++){
                System.out.print(MN2[i][j]+" ");
            }
            System.out.println();
        }
    }
}
