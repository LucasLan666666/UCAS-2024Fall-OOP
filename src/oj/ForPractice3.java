package step3;

public class ForPractice3 {
    public static void main(String[] args) {
        /*****start*****/
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i*j + "\t");
            }
            System.out.println();
        }
        /*****end*****/
    }
}