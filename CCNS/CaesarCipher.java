package CCNS;
import java.io.*;
import java.util.Scanner;
class CaesarCipher {
    public static String encrypt(String msg, int key){
        String cipher="";
        char [] text=new char[msg.length()];
        char c;
        for(int i=0;i<msg.length();i++){
            c=msg.charAt(i);
            if(c==' ')text[i]=' ';
            else if((int)c>='a' && (int)c<='z')text[i]=(char)((((c-97)+key)%26)+97);
            else text[i]=(char)((((c-65)+key)%26)+65);
            cipher=cipher+text[i];
        }
        return cipher;
    }   
    public static String decrypt(String msg, int key){
        int index;
        String cipher="";
        char [] text=new char[msg.length()];
        char c;
        for(int i=0;i<msg.length();i++){
            c=msg.charAt(i);
            if(c==' ')text[i]=' ';
            else if((int)c>='a' && (int)c<='z'){
                index=((c-97)-key)%26;
                if(index<0)index=26+index;
                text[i]=(char)(index+97);
            }else {
                index=((c-65)-key)%26;
                if(index<0)index=26+index;
                text[i]=(char)(index+65);
            }
            cipher=cipher+text[i];
        }
        return cipher;
    }   
    
    public static void bruteForce(String cipher){
        System.out.println("\nBRUTE FORCE RESULTS\n");
        for(int i=0;i<26;i++){
            System.out.println(decrypt(cipher, i));   
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int key, choice;
        String plainText, cipherText, resultText;
        
        do{
            System.out.print("1: Encryption  2:Decryption  3:Brute Force  4:Exit  Choice: ");
            choice=in.nextInt();
            switch(choice){
                case 1: System.out.print("Enter Plaintext: ");
                        plainText=br.readLine();
                        System.out.print("Enter Key: ");
                        key=in.nextInt();
                        cipherText=encrypt(plainText,key);
                        System.out.print("CIPHER TEXT: "+cipherText);
                        break;
                case 2: System.out.print("Enter Ciphertext: ");
                        cipherText=br.readLine();
                        System.out.print("Enter Key: ");
                        key=in.nextInt();
                        resultText=decrypt(cipherText,key);
                        System.out.print("ORIGINAL TEXT: "+resultText);
                        break;
                case 3: System.out.print("Enter Ciphertext: ");
                        cipherText=br.readLine();
                        bruteForce(cipherText);
                        break;
            }
            System.out.println("");
        }while(choice!=4);
    }
}
/*
1: Encryption  2:Decryption  3:Brute Force  4:Exit  Choice: 1
Enter Plaintext: Vishal S Robertson
Enter Key: 18
CIPHER TEXT: Nakzsd K Jgtwjlkgf
1: Encryption  2:Decryption  3:Brute Force  4:Exit  Choice: 2
Enter Ciphertext: Nakzsd K Jgtwjlkgf
Enter Key: 18
ORIGINAL TEXT: Vishal S Robertson
1: Encryption  2:Decryption  3:Brute Force  4:Exit  Choice: 3
Enter Ciphertext: Nakzsd K Jgtwjlkgf

BRUTE FORCE RESULTS

Nakzsd K Jgtwjlkgf
Mzjyrc J Ifsvikjfe
Lyixqb I Heruhjied
Kxhwpa H Gdqtgihdc
Jwgvoz G Fcpsfhgcb
Ivfuny F Eboregfba
Huetmx E Danqdfeaz
Gtdslw D Czmpcedzy
Fscrkv C Bylobdcyx
Erbqju B Axknacbxw
Dqapit A Zwjmzbawv
Cpzohs Z Yvilyazvu
Boyngr Y Xuhkxzyut
Anxmfq X Wtgjwyxts
Zmwlep W Vsfivxwsr
Ylvkdo V Urehuwvrq
Xkujcn U Tqdgtvuqp
Wjtibm T Spcfsutpo
Vishal S Robertson
Uhrgzk R Qnadqsrnm
Tgqfyj Q Pmzcprqml
Sfpexi P Olyboqplk
Reodwh O Nkxanpokj
Qdncvg N Mjwzmonji
Pcmbuf M Livylnmih
Oblate L Khuxkmlhg

1: Encryption  2:Decryption  3:Brute Force  4:Exit  Choice: 4

*/