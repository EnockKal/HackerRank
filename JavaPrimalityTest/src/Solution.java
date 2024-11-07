import java.io.*;
import java.math.*;



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String n = bufferedReader.readLine();
        BigInteger m = new BigInteger(n);

        if(m.isProbablePrime(10)){
            System.out.println("prime");
        }else
            System.out.println("not prime");

        bufferedReader.close();
    }
}
