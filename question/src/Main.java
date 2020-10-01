import java.util.*;

import java.util.*;

class Main1{

    public static void main(String[] args){

        double fah,speed,wind;


        Scanner input = new Scanner(System.in);
        fah= input.nextDouble();


        speed =input.nextDouble();


        wind= 35.74 + 0.6215 * fah- 35.75 * Math.pow(speed,0.16)+ 0.4275 * fah * Math.pow(speed,0.16);
        System.out.println("The wind chill index is "+ wind);

    }
}