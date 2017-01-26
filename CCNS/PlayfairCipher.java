package CCNS;
import java.io.*;
import java.util.Scanner;

public class PlayfairCipher {
    static String[][] KeyMatrix;
    static public String formatInput(String text) {
        String returnText="";
        text=text.toUpperCase().replace(" ","");
        System.out.print("\nAdding Filter Character: "+text+" --> ");
        for(int i=0;i<text.length();) {
            if(i==text.length()-1){
                returnText+=text.charAt(i)+"X";
                break;
            }else if(text.charAt(i)!=text.charAt(i+1)){
                returnText+=""+text.charAt(i)+text.charAt(i+1);
                i+=2;
            }else{
                returnText+=text.charAt(i)+"X";
                i+=1;
            }
        }
        System.out.println(returnText);
        return returnText;
    }
    static public String formatOutput(String text) {
        String returnText="",temp=text;
        text=text.toUpperCase().replace(" ","");
        System.out.print("Removing Filter Character: "+text+" --> ");
        if(text.charAt(text.length()-1)=='X' && text.length()%2==0){
            text=text.substring(0, text.length()-1);
        }
        for(int i=0;i<temp.length();) {
            if(i==text.length()-1){
                returnText+=text.charAt(i);
                break;
            }else if(text.charAt(i+1)=='X' && text.charAt(i)==text.charAt(i+2)){
                returnText+=""+text.charAt(i);
                i+=2;
            }else if(text.charAt(i)!=text.charAt(i+1)){
                returnText+=""+text.charAt(i)+text.charAt(i+1);
                i+=2;
            }
        }
        System.out.println(returnText);
        return returnText;
    }
    static public String encrypt(String text, String key){
        String cipher="";
        int r1=0,r2=0,c1=0,c2=0;
        setKeyMatrix(key);
        for(int l=0; l<text.length();l+=2){
            for(int i=0;i<5;i++)
               for(int j=0;j<5;j++){
                   if(KeyMatrix[i][j].equals(text.charAt(l)+"")){r1=i;c1=j;}
                   if(KeyMatrix[i][j].equals(text.charAt(l+1)+"")){r2=i;c2=j;}
                }
            if(c1==c2){
                r1++;
                r2++;
                if(r1==5)r1=0;
                if(r2==5)r2=0;
            }else if(r1==r2){
                c1++;
                c2++;
                if(c1==5)c1=0;
                if(c2==5)c2=0;
            }else{
                c1=c1+c2;
                c2=c1-c2;
                c1=c1-c2;
            }   
            cipher+=KeyMatrix[r1][c1]+KeyMatrix[r2][c2];
        }
        return cipher;
    }
    static public String decrypt(String text, String key){
        String original="";
        int r1=0,r2=0,c1=0,c2=0;
        System.out.println("\nCiphertext: "+text);
        setKeyMatrix(key);
        for(int l=0; l<text.length();l+=2){
            for(int i=0;i<5;i++)
               for(int j=0;j<5;j++){
                   if(KeyMatrix[i][j].equals(text.charAt(l)+"")){r1=i;c1=j;}
                   if(KeyMatrix[i][j].equals(text.charAt(l+1)+"")){r2=i;c2=j;}
                }
            if(c1==c2){
                r1--;
                r2--;
                if(r1==-1)r1=4;
                if(r2==-1)r2=4;
            }else if(r1==r2){
                c1--;
                c2--;
                if(c1==-1)c1=4;
                if(c2==-1)c2=4;
            }else{
                c1=c1+c2;
                c2=c1-c2;
                c1=c1-c2;
            }   
            original+=KeyMatrix[r1][c1]+KeyMatrix[r2][c2];
        }
        return formatOutput(original);
    }
    static public void setKeyMatrix(String key){
        String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        KeyMatrix = new String[5][5];
        key=key.toUpperCase();
        key=key.replace("J","I");
        int c,i;
        for(c=0,i=0;i<key.length();i++) {
            String ch = key.charAt(i)+"";
            if(alphabet.contains(ch)) {
                KeyMatrix[c/5][c%5]=ch;
                alphabet=alphabet.replace(ch,"");
                c++;
            }
        }
        for(i=c;i<25;i++) {
            String ch = alphabet.charAt(0)+"";
            KeyMatrix[i/5][i%5]=ch;
            alphabet=alphabet.replace(ch,"");
        }
        System.out.println("Key Matrix for "+key);
        for(i=0;i<5;i++) {
            for(int j=0;j<5;j++)
                System.out.print(KeyMatrix[i][j]+"   ");
            System.out.println("");
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        String key, plainText, cipherText, resultText;
        do{
            System.out.print("1: Encryption  2:Decryption  3:Exit  Choice: ");
            choice=in.nextInt();
            switch(choice){
                case 1: System.out.print("Enter Plaintext: ");
                        plainText=br.readLine();
                        System.out.print("Enter Key: ");
                        key=br.readLine();
                        cipherText=encrypt(formatInput(plainText), key);
                        System.out.print("CIPHER TEXT: "+cipherText);
                        break;
                case 2: System.out.print("Enter Ciphertext: ");
                        cipherText=br.readLine();
                        System.out.print("Enter Key: ");
                        key=br.readLine();
                        resultText=decrypt(cipherText,key);
                        System.out.print("ORIGINAL TEXT: "+resultText);
                        break;
                default:System.out.print("Invalid Choice.");                        
            }
            System.out.println("\n");
        }while(choice!=3);  
    }
}
