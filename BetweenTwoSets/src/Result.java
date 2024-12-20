import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    // calculate the GCD of two numbers
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // calculate the GCD of a list of numbers
    private static int gcdList(List<Integer> arr) {
        int result = arr.get(0);
        for (int num : arr) {
            result = gcd(result, num);
            if (result == 1) {
                break;
            }
        }
        return result;
    }

    // calculate the LCM of two numbers
    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    // calculate the LCM of a list of numbers
    private static int lcmList(List<Integer> arr) {
        int result = arr.get(0);
        for (int num : arr) {
            result = lcm(result, num);
        }
        return result;
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int lcmA = lcmList(a);
        int gcdB = gcdList(b);
        int count = 0;

        for (int multiple = lcmA; multiple <= gcdB; multiple += lcmA) {
            if (gcdB % multiple == 0) {
                count++;
            }
        }

        return count;

    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
