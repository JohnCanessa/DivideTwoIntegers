import java.math.BigInteger;
import java.util.Scanner;

/**
 * LeetCode 29. Divide Two Integers
 * https://leetcode.com/problems/divide-two-integers/
 */
public class Solution {

    
    /**
     * Given two integers dividend and divisor, 
     * divide two integers without using multiplication, 
     * division and mod operator.
     */
    static int divide(int dividend, int divisor) {
     
       // **** check for overflow ****
        if ((dividend == Integer.MIN_VALUE) && (divisor == -1))
            return Integer.MAX_VALUE;

        // **** check if dividing by 1 ****
        if (divisor == 1)
            return dividend;

        // **** check if dividend equals divisor ****
        if (dividend == divisor)
            return 1;

        // **** keep track of sign for the quotient ****
        int sign = 1;

        // **** check sign on dividend ****
        if (dividend < 0)
            sign *= -1;

        // **** check sign on divisor ****
        if (divisor < 0)
            sign *= -1;

        // **** make both values positive ****
        dividend    = Math.abs(dividend);
        divisor     = Math.abs(divisor);

        // **** initialize the quotient ****
        int quotient = 0;


        // **** loop subtracting divisor from dividend ****
        while (dividend - divisor >= 0) {

            // **** update quotient ****
            quotient++;

            // **** update dividend ****
            dividend -= divisor;
        }

        // **** loop subtracting divisor from dividend ****
        // while (dividend - divisor >= 0) {

        //     // **** exponent ****
        //     int x = 0;

        //     // **** how many times we can subtract (divisor ^ 2) ****
        //     while (dividend - (divisor << 1 << x) >= 0) {
        //         x++;
        //     }

        //     // **** update quotient (2 ^ x) ****
        //     quotient += (1 << x);

        //     // **** update dividend (divisor ^ x) ****
        //     dividend -= (divisor << x);
        // }


        // **** return quotient with proper sign ****
        return sign * quotient;
    }


    /**
     * Given two integers dividend and divisor, 
     * divide two integers without using multiplication, 
     * division and mod operator.
     * 
     * !!!! WORK IN PROGRESS - RUN OUT OF TIME !!!!
     */
    static int divide1(int dividend, int divisor) {
 
        // **** ****
        BigInteger a = new BigInteger(Integer.toString(dividend), 10);
        BigInteger b = new BigInteger(Integer.toString(divisor), 10);

        // ???? ????
        System.out.println("divide1 <<< a: 0x" + a.toString(2));
        System.out.println("divide1 <<< b: 0x" + b.toString(2));

        // **** c = a / b ****
        BigInteger c = a.divide(b);

        // ???? ????
        System.out.println("divide1 <<< c: 0x" + c.toString(2));

        // **** divide the numbers ****
        double d = (double)dividend / (double)divisor;

        // ???? ????
        System.out.println("divide1 <<<          d: " + d);

        // **** get integral part of double ****
        int integral = (int)d;

        // ???? ????
        System.out.println("divide1 <<<   integral: " + integral);

        // **** get fractional part of double ****
        double fractional = d - integral;

        // ???? ????
        System.out.println("divide1 <<< fractional: " + fractional);

        // **** convert and display fractional to binary (seems to have an issue) ****
        System.out.println("divide1 <<< fractional: " + Long.toBinaryString(Double.doubleToRawLongBits(fractional)));

        // **** convert and display fractional to binary ****
        String lStr = "";
        double f = fractional;
        System.out.print("divide1 <<<          f: ");
        for (int i = 0; i < 54; i++) {
            f *= 2;
            System.out.print((int)f);
            lStr += "" + (int)f;
            f -= (int)f;
        }
        System.out.println();

        // ???? ????
        System.out.println("divide1 <<<       lStr: " + lStr);




        // **** ****
        return 0;
    }


    /**
     * Test scaffolding.
     */
    public static void main(String[] args) {

        // **** display max and min integer values ****
        // System.out.println("main <<< MAX_VALUE: " + Integer.MAX_VALUE);
        // System.out.println("main <<< MIN_VALUE: " + Integer.MIN_VALUE);

        // **** open scanner ****
        Scanner sc = new Scanner(System.in);

        // **** read dividend & divisor ****
        String[] dd = sc.nextLine().split(",");

        // **** close scanner ****
        sc.close();

        // **** convert to integer ****
        int dividend    = Integer.parseInt(dd[0]);
        int divisor     = Integer.parseInt(dd[1]);

        // ????? ????
        System.out.println("main <<< dividend: " + dividend + " divisor: " + divisor);

        // **** generate and display result ****
        System.out.println("main <<<  divide: " + divide(dividend, divisor));
    }
}