import java.util.Scanner;
class Calculator {
    public static int add(int n1, int n2){
        return n1+n2;
    }
    public static int sub(int n1, int n2){
        return n1-n2;
    }
    public static int mul(int n1, int n2){
        return n1*n2;
    }
    public static int div(int n1, int n2){
        return n1/n2;
    }
    //this is a test comment aother
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice,n1,n2;
        do{
            System.out.println("1:+\t2:-\t3:*\t4:/\t0:Exit");
            choice=in.nextInt();
            System.out.print("Enter nos: ");
            n1=in.nextInt();
            n2=in.nextInt();
            switch(choice){
                case 1: System.out.println(add(n1, n2));  
                        break;
                case 2: System.out.println(sub(n1,n2));
                        break;
                /*the code didn't have case 2....now it's fixed :p*/    
                case 3: System.out.println(mul(n1, n2));  
                        break;
                case 4: System.out.println(div(n1, n2));  
                        break;
            }
        }while(choice!=0);
    }
    System.out.println("Edited at Github workshop");
}
