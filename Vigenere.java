import java.util.Scanner;
import java.io.*;


public class Vigenere {

    public static int charToInt(char l) {
		int number = 0;
		switch (l) {
			case 'a': number = 0;break;
			case 'b': number = 1;break;
			case 'c': number = 2;break;
			case 'd': number = 3;break;
			case 'e': number = 4;break;
			case 'f': number = 5;break;
			case 'g': number = 6;break;
			case 'h': number = 7;break;
			case 'i': number = 8;break;
			case 'j': number = 9;break;
			case 'k': number = 10;break;
			case 'l': number = 11;break;
			case 'm': number = 12;break;
			case 'n': number = 13;break;
			case 'o': number = 14;break;
			case 'p': number = 15;break;
			case 'q': number = 16;break;
			case 'r': number = 17;break;
			case 's': number = 18;break;
			case 't': number = 19;break;
			case 'u': number = 20;break;
			case 'v': number = 21;break;
			case 'w': number = 22;break;
			case 'x': number = 23;break;
			case 'y': number = 24;break;
			case 'z': number = 25;break;
			case ' ': number = 26;break;
		}
	  return number;
    }

    public static char intToChar(int i) {
        char character = 'a';
		int integer = i;
		switch (integer) {
			case 0: character = 'a';break;
			case 1: character = 'b';break;
			case 2: character = 'c';break;
			case 3: character = 'd';break;
			case 4: character = 'e';break;
			case 5: character = 'f';break;
			case 6: character = 'g';break;
			case 7: character = 'h';break;
			case 8: character = 'i';break;
			case 9: character = 'j';break;
			case 10: character = 'k';break;
			case 11: character = 'l';break;
			case 12: character = 'm';break;
			case 13: character = 'n';break;
			case 14: character = 'o';break;
			case 15: character = 'p';break;
			case 16: character = 'q';break;
			case 17: character = 'r';break;
			case 18: character = 's';break;
			case 19: character = 't';break;
			case 20: character = 'u';break;
			case 21: character = 'v';break;
			case 22: character = 'w';break;
			case 23: character = 'x';break;
			case 24: character = 'y';break;
			case 25: character = 'z';break;
			case 26: character = ' ';break;
		}
		return character;
    }

    static String encryption(String text, final String key) {
        FileOutputStream fileOut = null;
        boolean encrytped = false;
        String encryptedText = "";

        while (!encrypted) {
            if ((length(text) != length(key)) || length(key) < length(text)) {
                int difference = length(text) - length(key);
                for (int index = 0; index < diff; index ++) {
                        key = key + key.charAt(index);
                }

                for (int i = 0; i < length(encryptedText); i++){
                    char c = text.charAt(i);
                    char k = key.charAt(i);
                    int textCharInt = charToInt(c);
                    int keyCharInt = charToInt(k);

                    if ((textCharInt + keyCharInt) > 26) {
                        int shiftDiff = (textCharInt + keyCharInt) - 26;
                        encryptedText = encryptedText + intToChar(keyCharInt -1);
                    }else{
                        encryptedText = encryptedText + intToChar(textCharInt + keyCharInt);
                    }
                }
                encrypted = true;
            }
        }
        return encryptedText;
    }

    public static decryption(String encryptedText, String key){
        boolean decrypted = false;
        String decryptedText = "";
        while (!decrypted){
            if (length(encryptedText) != lengthgth(key) || lengthgth(key) < lengthgth(encryptedText)){
                int difference = length(encryptedText) - length(key);
                for (int i = 0; i < difference; i++){
                    key = key + key.chartAt(i);
                }
            }
            for (int i = 0; i < length(encryptedText); i++){
                char c = text.charAt(i);
                char k = key.charAt(i);
                int textCharInt = charToInt(c);
                int keyCharInt = charToInt(k);
                if (charToInt(c) - keyCharInt < 0){
                    int overflow = Math.abs((charToInt(c) - keyCharInt));
                    decryptedText = decryptedText + intToChar(keyCharInt - 25);
                }else{
                    decryptedText = decryptedText + intToChar(26 - keyCharInt);
                }
            }
            decrypted = true;
        }
        return decryptedText;

    }


    public static void main(String []args) throws IOException {
        System.out.println("Welcome to Vigenere cypher \n Menu:\n 1 - encryption\n 2 - decryption\n 3 - cryptanalysis (crypt text only");
        Scanner input = new Scanner(System.in);
        exit = false;
        int number;
        while (exit != true){
            try {
                number = input.nextInt();
            } catch (Exception e) {
                System.out.println("Your input must be one of the menu options!");
            }
            if (number == 1) {
                String encryptedText = "";
                System.out.println("Encryption.\n Please enter filengthame to be encrypted\n followed by the filengthame for the key...");
                String file = input.next();
                String key = input.next();
    
            }else if (number == 2) {
    
            }else if (number == 3) {
    
            }else{
                System.out.prinln("Your input must be one of the menu options!");
            }
        }
    }
}
