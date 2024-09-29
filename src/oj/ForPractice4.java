package step4;

import java.util.Scanner;

public class ForPractice4 {
    public static void main(String[] args) {
        /*****start*****/
        int count = 0;
        int i =3;
        int j = 0;
        do{
            j = 1;
            while(j<3){
                count ++;
                j ++;
            }
            i--;
        }while(i>0);
        count += j;
        System.out.println(count);
        /*****end*****/
    }
}
