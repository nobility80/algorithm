package spring.di.algorithmtest.answer;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int result = 0;
        int nHorizon = arr.size();
        int nLTToRB = 0;
        int nRTToLB = 0;

        for (int i = 0; i < nHorizon; i++) {
            //Left Top to Right Bottom
            nLTToRB += arr.get(i).get(i);
            //Right Top to Left Bottom
            nRTToLB += arr.get(nHorizon - i - 1).get(i);
        }

        System.out.println("nLTToRB: " + nLTToRB);
        System.out.println("nRTToLB: " + nRTToLB);

        result = nLTToRB - nRTToLB;
        if (result < 0) result = result * (-1);
        System.out.println("result: " + result);

        return result;
    }

    //getting correct matrix
    //getting correct matrix
    static int[][][] correct_mat = {{{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
            {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
            {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
            {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
            {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
            {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
            {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
            {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}}};

    int formingMagicSquare(int[][] s) {
        int nOneLocation = 0;
        int result = 0;
        int differ = 0;
        int started = 0;

        //rotate the correct matrix in order to match the input
        for (int h = 0; h < correct_mat.length; h++) {
            for (int i = 0; i < correct_mat[h].length; i++) {    //row
                for (int j = 0; j < correct_mat[h][i].length; j++) { //column
                    differ += Math.abs(correct_mat[h][i][j] - s[i][j]);
                }

            }
            if (started == 0) {
                result = differ;
                started = 1;
            } else {
                if (result > differ)
                    result = differ;
            }
            differ = 0;
        }

        return result;
    }

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        int answer = 0;
        Map<Integer, Integer> pmap = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            if (!pmap.containsKey(a.get(i)))
                pmap.put(a.get(i), 1);
            else
                pmap.put(a.get(i), pmap.get(a.get(i)) + 1);
        }
        
        return answer;
    }
    
    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        else
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
    
    public static void extraLongFactorials(int n) {
    	BigInteger biResult = BigInteger.ONE;
    	BigInteger bi = new BigInteger(Integer.toString(n));
    	
    	if (n < -1)
    		return;

    	while(! bi.equals(BigInteger.ONE)) {
    		biResult = (biResult.multiply(bi));
    		bi = bi.subtract(BigInteger.ONE);
    	}
    	
    	System.out.println(biResult.toString());

    }
}