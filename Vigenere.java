import java.util.Scanner;
import java.io.*;


public class Vigenere {
    public static void main(String []args) throws IOException {
        FileInputStream fileIn = null;
        FileInputStream keyIn = null;
        FileOutputStream out = null;


        System.out.println("Welcome to Vigenere cypher \n Menu:\n 1 - encryption\n 2 - decryption\n 3 - cryptanalysis (crypt text only");
        Scanner input = new Scanner(System.in);
        
        int number;
        try {
            number = input.nextInt();
        } catch (Exception e) {
            System.out.println("Your input must be one of the menu options!");
        }
        if (number == 1) {
            String encryptedText = "";
            System.out.println("Encryption.\n Please enter filename to be encrypted\n followed by the filename for the key...");
            String file = input.next();
            String key = input.next();
            
            try {
                fileIn = new FileInputStream(file);
                keyIn = new FileInputStream(key);
                
                
                out = new FileOutputStream("output.txt");
                String encrypted = encryption(file, key);
                int x;
                while ((x = encrypted.read()) != -1) {
                    out.write(x);
                }
            }finally {
                if (fileIn != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }

        }else if (number == 2) {

        }else if (number == 3) {

        }else{
            System.out.prinln("Your input must be one of the menu options!");
        }
    }



    static String encryption(String text, final String key) {
        String encryptedText = "";
        
        for (int i = 0, j = 0; i < encryptedText.length(); i++){
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            encryptedText += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return encryptedText;
    }
}

