import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String pali;
        int wordlen, fin = 0;
        char string [], revstring [];

        System.out.print("Enter word: ");
        pali = sc.nextLine().toLowerCase().replace(" ", "");

        string = pali.toCharArray();
        revstring = new char [string.length];

        wordlen = string.length;
        for (int i = 0; i < string.length; i++){
            revstring [wordlen-1] = string [i];
            wordlen -= 1;
        }
        for (int i = 0; i < string.length; i++){
            if (!(string[i] == revstring[i]) ){
                System.out.println("NOT PALINDROME");
                break;
            }
            else {
                fin += 1 ;
                if (fin == string.length){
                    System.out.println("PALINDROME");
                }
            }
        }
        sc.close();
    }
}
