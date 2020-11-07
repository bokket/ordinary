import java.util.*;

public class Array{
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);

       System.out.println("Enter list1:");
       int[][] list1 = new int[3][3];
       int i, j;
       for (i = 0; i < 3; i++) {
           for (j = 0; j < 3; j++)
               list1[i][j] = input.nextInt();
       }

       System.out.println("Enter list2:");
       int[][] list2 = new int[3][3];
       for (i = 0; i < 3; i++) {
           for (j = 0; j < 3; j++)
               list2[i][j] = input.nextInt();
       }

       boolean bool = equals(list1, list2);

       if (bool == true)
           System.out.println("The two arrays are identical");
       else
           System.out.println("The two arrays are not identical");
   }

    public static boolean equals(int[][] m1, int[][] m2){
        int[] l1 = new int[9];
        int[] l2 = new int[9];
        int i,j;
        int count = 0;
        for(i = 0; i < 3; ++i){
            for(j = 0; j < 3; ++j){
                l1[count] = m1[i][j];
                l2[count] = m2[i][j];
                ++count;
            }
        }

        Arrays.sort(l1);
        Arrays.sort(l2);


        for(i = 0; i < 9; ++i){
            if(l1[i] != l2[i]){
                return false;
            }
        }
        return true;
    }
}
/*import java.util.*;
public class Array {

    public static boolean equals(int[][] m1, int[][] m2) {
        int[] l1 = new int[9];
        int[] l2 = new int[9];

        int i, j;
        int cnt = 0;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                l1[cnt] = m1[i][j];
                l2[cnt] = m2[i][j];
                ++cnt;
            }
        }

        java.util.Arrays.sort(m1);
        java.util.Arrays.sort(m2);

        for (i = 0; i < 9; i++) {
            if (l1[i] != l2[i]) {
                return false;
            }
        }
        return true;
       /* if (java.util.Arrays.equals(m1, m2))
            return true;
        else
            return false;*/
    //}
/*
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter list1:");
        int[][] list1 = new int[3][3];
        int i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++)
                list1[i][j] = input.nextInt();
        }

        System.out.println("Enter list2:");
        int[][] list2 = new int[3][3];
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++)
                list2[i][j] = input.nextInt();
        }

        boolean bool = equals(list1, list2);

        if (bool == true)
            System.out.println("The two arrays are identical");
        else
            System.out.println("The two arrays are not identical");
    }
}*/




