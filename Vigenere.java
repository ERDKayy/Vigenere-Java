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
        boolean encrypted = false;
        String encryptedText = "";
        String encryptionKey = key;

        while (encrypted != true) {
            if (text.length() != encryptionKey.length() && encryptionKey.length() < text.length()) {
                int difference = text.length() - encryptionKey.length();
                for (int index = 0; index < difference; index ++) {
                    encryptionKey = encryptionKey + encryptionKey.charAt(index);
                }
            }
            for (int i = 0; i < encryptedText.length(); i++){
                char c = text.charAt(i);
                char k = encryptionKey.charAt(i);
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
        return encryptedText;
    }

    public static String decryption(String encryptedText, String key){
        boolean decrypted = false;
        String decryptedText = "";
        String decryptionKey = key;
        while (decrypted != true){
            if ((encryptedText.length() != decryptionKey.length()) && (decryptionKey.length() < encryptedText.length())){
                int difference = encryptedText.length() - decryptionKey.length();
                for (int i = 0; i < difference; i++){
                    key = decryptionKey + decryptionKey.charAt(i);
                }
            }
            for (int i = 0; i < encryptedText.length(); i++){
                char c = decryptionKey.charAt(i);
                char k = decryptionKey.charAt(i);
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
        Scanner input = new Scanner(System.in);
        String line = "";
        boolean exit = false;
        int number;
        System.out.println("Welcome to Vigenere cypher \n Menu:\n 1 - encryption\n 2 - decryption\n 3 - cryptanalysis (crypt text only\n 4 - exit");
        while (exit != true) {
            try {
                number = input.nextInt();
            }catch (Exception e) {
                System.out.println("Your input must be one of the menu options!");
            }
            if (number == 1) {
                System.out.println("Enter file to be encrypted...");
                String file = input.next();
                file += input.nextLine();
                System.out.println("Enter the filename for the encryption key...");
                String keyFile = input.next();
                keyFile += input.nextLine();
                System.out.println("Enter filename for encrypted message...");
                String encryptedFile = input.next();
                encryptedFile += input.nextLine();

                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    BufferedReader br2 = new BufferedReader(new FileReader(keyFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(encryptedFile));
                    String key = br2.readLine();
                    while ((line = br2.readLine()) != null){
                        line = encryption(line, key);
                        writer.write(line);
                    }
                    writer.close();
                }catch(Exception e){
                    System.out.println("file not found");
                }
            }else if (number == 2) {
                System.out.println("Enter file to be decrypted...");
                String encryptedFile = input.next();
                encryptedFile += input.nextLine();
                System.out.println("Enter filename for encryption key...");
                String keyFile = input.next();
                keyFile += input.nextLine();
                System.out.println("Enter file for decrypted message...");
                String file = input.next();
                file += input.nextLine();

                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    BufferedReader br2 = new BufferedReader(new FileReader(keyFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(encryptedFile));
                    String key = br2.readLine();
                    while ((line = br.readLine()) != null){
                        line = decryption(line, key);
                        writer.write(line);
                    }
                    writer.close();
                }catch(Exception e){
                    System.out.println("File not found");
                }
            }else if (number == 3) {
                System.out.println("Enter file for analysis...");
                String file = input.next();
                file += input.nextLine();
                int[] coincidences = new int[40];

                BufferedReader br = new BufferedReader(new FileReader(file));
                String text ="";
                String shifter ="";
                shifter = br.readLine();
                text = text + shifter;
                while ((shifter = br.readLine()) != null) {
                    text = text + " " + shifter;
                }
                String shifted = text;
                for (int i = 1; i <= coincidences.length; i++){
                    int coincidence = 0;
                    shifted = shifted.substring(1);
                    for (int j = 0; j < shifted.length(); j++){
                        if (text.charAt(i) == shifted.charAt(i)){
                            coincidence++;
                        }
                    }
                    coincidences[i-1] = coincidence;
                }

                int top = coincidences[0];
                int coincidencePeek = 0;
                for (int index = 1; index < coincidences.length(); index++){
                    if (coincidences[index] > top){
                        top = coincidences[index];
                        coincidencePeek = index;
                    }
                }
                System.out.println("Length of key: " + (coincidencePeek + 1));
            }else if (number == 4) {
                exit = true;
            }else{
                System.out.println("Your input must be one of the menu options!");
                exit = true;
            }
    
        }
    }
}
