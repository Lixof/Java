package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int one;
        int two;
        String otv;
        Scanner vvod = new Scanner(System.in);
        String in = vvod.nextLine();
        String[] inraz = in.split(" ");

        Prov prov = new Prov(inraz);
        Conv convone = new Conv(inraz[0]);
        Conv convtwo = new Conv(inraz[2]);
        if(!prov.pr){

            System.out.println("incorrect input");
        }
        else {
            if(prov.rim1) {
                one = convone.j;
                two = convtwo.j;
            }
            else {
                one = Integer.parseInt(inraz[0]);
                two = Integer.parseInt(inraz[2]);
            }
            Calc calc = new Calc(inraz[1], one, two);
            int r = calc.r;
            if(prov.rim1) {
                Conv conv = new Conv(r);
                otv = conv.nr;
            }
            else {

                otv = Integer.toString(r);
            }

            System.out.println(otv);
        }

    }
}


class Conv {

    String nr;
    int j;
    String[] numa = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "24", "25", "27", "28", "30", "32", "35", "36", "40", "42", "45", "48", "49", "50", "54", "56", "60", "63", "64", "70", "72", "80", "81", "90", "100"};
    String[] numb = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXIV", "XXV", "XXVII", "XXVIII", "XXX", "XXXII", "XXXV", "XXXVI", "XL", "XLII", "XLV", "XLVIII", "XLIX", "L", "LIV", "LVI", "LX", "LXIII", "LXIV", "LXX", "LXXII", "LXXX", "LXXXI", "XC", "C"};

    Conv(String i) {

        for(int s = 0; s < 10; s++){
            if (numb[s].equals(i)){
                i = numa[s];
                break;
            }
        }
        j = Integer.parseInt(i);
    }

    Conv(int r){

        nr = Integer.toString(r);
        for(int s = 0; s < 46; s++){
            if (numa[s].equals(nr)){
                nr = numb[s];
                break;
            }
        }
    }
}

class Calc {

    int r;

    Calc(String zn, int one, int two) {
        switch (zn) {
            case "+":
                r = one + two;
                break;
            case "-":
                r = one - two;
                break;
            case "*":
                r = one * two;
                break;
            case "/":
                r = one / two;
                break;
            default:
                break;
        }
    }
}

class Prov{

    boolean pr = false;
    boolean ar1 = false;
    boolean ar2 = false;
    boolean zn = false;
    boolean rim1 = false;
    boolean rim2 = false;
    String[] z = {"+","-","*","/"};
    String[] r = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    String[] a = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    Prov(String[] vvod){

        for(int s = 0; s < 4; s++){
            if(z[s].equals(vvod[1])){

                zn = true;
                break;
            }
        }

        for(int s = 0; s < 10; s++){
            if(r[s].equals(vvod[0])){

                rim1 = true;
                break;
            }
        }

        for(int s = 0; s < 10; s++){
            if(r[s].equals(vvod[2])){

                rim2 = true;
                break;
            }
        }

        if(vvod.length == 3){

            if(zn) {

                if(rim1 == rim2){

                    pr = true;

                    if(!rim1){
                        for(int q = 0; q < 10; q++) {
                            if (a[q].equals(vvod[0])) {

                                ar1 = true;
                                break;
                            }
                        }
                        for(int q = 0; q < 10; q++) {
                            if (a[q].equals(vvod[2])) {

                                ar2 = true;
                                break;
                            }
                        }
                        if(!(ar1 & ar2)){
                            pr = false;
                        }

                    }

                }

            }

        }

    }
}
