import java.util.Scanner;
import java.math.BigInteger;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        BigInteger n = sc.nextBigInteger();
        BigInteger m = sc.nextBigInteger();
        
        BigInteger quotient = n.divide(m);
        
        BigInteger remainder = n.remainder(m);
        
        System.out.println(quotient);
        System.out.println(remainder);
        
        sc.close();
    }
    
}