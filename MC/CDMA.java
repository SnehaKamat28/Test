package MC;
import java.io.IOException;
import java.util.Scanner;
public class CDMA {
    public static void main(String[] args) throws IOException{
        int Ar=0,Br=0,A_data,B_data,A_chip_code[],B_chip_code[],A_temp[],B_temp[],C_result[];
        Scanner in = new Scanner(System.in);
        A_chip_code=new int[8];
        B_chip_code=new int[8];
        A_temp=new int[8];
        B_temp=new int[8];
        C_result=new int[8];
        System.out.print("Enter A's data: ");
        A_data = in.nextInt();
        System.out.print("Enter B's data: ");
        B_data = in.nextInt();
        System.out.print("Enter A's Chip Code: ");
        for(int i=0;i<8;i++)
        {
            if(in.nextInt()==0)A_chip_code[i]=-1;
            else A_chip_code[i]=1;
        }
        System.out.print("Enter B's Chip Code: ");
        for(int i=0;i<8;i++)
        {
            if(in.nextInt()==0)B_chip_code[i]=-1;
            else B_chip_code[i]=1;
        }
        if(A_data==0)A_data=-1;
        if(B_data==0)B_data=-1;
        System.out.println("");
        System.out.print("A's Value: "+A_data);
        System.out.println("");
        System.out.print("B's Value: "+B_data);
        for(int i=0;i<8;i++)
        {
            A_temp[i]=A_data*A_chip_code[i];
            B_temp[i]=B_data*B_chip_code[i];
            C_result[i]=A_temp[i]+B_temp[i];
        }
        System.out.print("\nA's Spread Data :");
        for(int i:A_temp)
            System.out.print(i+" ");
        System.out.print("\nB's Spread Data :");
        for(int i:B_temp)
            System.out.print(i+" ");
        System.out.print("\nA + B :");
        for(int i:C_result)
            System.out.print(i+" ");
        for(int i=0;i<8;i++)
        {
            Ar+=A_chip_code[i]*C_result[i];
            Br+=B_chip_code[i]*C_result[i];
        }
        System.out.println("");
        System.out.println("A's Value: "+Ar);
        System.out.println("B's Value: "+Br);
        if(Ar>0)Ar=1;
        else Ar=0;
        if(Br>0)Br=1;
        else Br=0;
        System.out.println("A's Data: "+Ar);
        System.out.println("B's Data: "+Br);
    }
}
/*
Enter A's data: 1
Enter B's data: 0
Enter A's Chip Code: 1 0 1 0 1 0 1 0
Enter B's Chip Code: 0 1 0 1 0 1 0 1

A's Value: 1
B's Value: -1
A's Spread Data :1 -1 1 -1 1 -1 1 -1 
B's Spread Data :1 -1 1 -1 1 -1 1 -1 
A + B :2 -2 2 -2 2 -2 2 -2 
A's Value: 16
B's Value: -16
A's Data: 1
B's Data: 0
*/