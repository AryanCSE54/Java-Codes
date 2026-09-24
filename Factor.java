import java.util.Scanner;
public class Factor 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int count=0;
        System.out.println("Factor of given Number are: ");
        for (int i = 1; i*i <= n; i++) 
        {
            if (n%i==0) 
            {
                if(i==n/i){
                    count++;
                    System.out.println(i);
                }
                else{
                System.out.println(i);
                count=count+2;
                }
            }
        }
        System.out.println("The no. of factors are: "+ count);
        sc.close();
   }
}