package spring.di.answer;

import java.util.List;

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
            nRTToLB += arr.get(nHorizon-i-1).get(i);
        }

        System.out.println("nLTToRB: "+ nLTToRB);
        System.out.println("nRTToLB: "+ nRTToLB);

        result = nLTToRB - nRTToLB;
        if (result < 0) result = result * (-1);
        System.out.println("result: " + result);

        return result;
    }
}
