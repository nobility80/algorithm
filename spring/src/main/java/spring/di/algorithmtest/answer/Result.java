package spring.di.algorithmtest.answer;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
    
    public int[] MaxCounters(int N, int[] A) {
    	int[] answer = new int[N];
    	int stan = 0;
    	
    	for (int i=0; i<A.length; i++) {
    		if (A[i] == N+1) {
    			// find max number
    			for (int j=0; j<N; j++) {
    				if (answer[j] > stan) stan = answer[j];
    			}
    			// save max number in all of array if A[i] == N+1
    			for (int j=0; j<N; j++) {
    				answer[j] = stan;
    			}
    		} else if ((A[i]>=1) && (A[i]<=N)) {
    			answer[A[i]-1]++;
    		}
    	}
    	
    	return answer;
    }
    
    public int MissingInteger(int[] A) {
    	int answer = 1;
    	Set<Integer> set = new HashSet<>();
    	for (int i=0; i<A.length; i++) {
    		set.add(A[i]);
    	}
    	
    	ArrayList<Integer> list = new ArrayList<>(set);
    	Collections.sort(list);

    	Iterator<Integer> it2 = list.iterator();
    	while(it2.hasNext()) {
    		if (it2.next() == answer) {
    			answer++;
    		}
    	}

    	return answer;
    }
    
    public int PermCheck(int[] A) {
    	ArrayList<Integer> list = new ArrayList<>();
    	int answer = 1;
    	
    	for (int i : A) {
    		list.add(i);
    	}
    	
    	Collections.sort(list);
    	
    	for (int i : list) {
    		if (answer == i) answer++;
    		else return 0;
    	}
    	
    	return 1;
    }
    
    public int CountDiv(int A, int B, int K) {
    	int answer = 0;
    	
    	int i = A;
    	while(i<=B) {
    		if (i%K == 0) {
    			answer++;
    			i+=K;
    		} else {
    			i++;
    		}
    	}
    	
    	return answer;
    }
    
    public int getSmallNumber(String S, int P, int Q) {
    	Set<Integer> set = new HashSet<>();
    	char[] charS = S.toCharArray();
    	int start = 0;
    	int end = 0;
    	int answer = 1;
    	
    	if (P>Q) { start=Q;end=P; }
    	else {start=P;end=Q;}
    	
    	for (int i=start; i<=end; i++ ) {
    		if (charS[i] == 'A') set.add(1);
    		else if (charS[i] == 'C') set.add(2);
    		else if (charS[i] == 'G') set.add(3);
    		else if (charS[i] == 'T') set.add(4);
    	}
    	
    	ArrayList<Integer> list = new ArrayList<>(set);
    	Collections.sort(list);
    	
    	return list.get(0);
    }
    
    public int[] GenomicRangeQuery(String S, int[] P, int[] Q) {
    	int [] answer = new int[P.length];
    	
    	for (int i=0; i<P.length; i++) {
    		answer[i] = getSmallNumber(S, P[i], Q[i]);
    		System.out.print("answer["+i+"]:" + answer[i]);
    	}
    	
    	return answer;
    	
    }
    
    public int MinAvgTwoSlice(int[] A) {
    	int position = 0;
    	double average = Double.MAX_VALUE;
    	
    	for (int i=0; i<A.length-2; i++) {
    		double avg2 = (A[i] + A[i+1])/2.0;
    		double avg3 = (A[i] + A[i+1] + A[i+2])/3.0;
    		if (average > Math.min(avg2, avg3)) {
    			average = Math.min(avg2, avg3);
    			position = i;
    		}
    	}
    	
    	if (average > (A[A.length-2]+A[A.length-1])/2.0 ) {
    		average = (A[A.length-2]+A[A.length-1])/2.0;
    		position = A.length-2;
    	}
    	
    	return position;
    }
    
    public int PassingCars(int[] A) {
    	int count_zero = 0;
    	int answer = 0;
    	
    	//if there is no car heading east at the beginning of the array
    	//if there is no car heading west at the end of the array
    	for (int i=0; i<A.length; i++) {
    		if (A[i] == 0) {
    			count_zero++;
    		} if (A[i] == 1) answer = answer+count_zero;
    	}
    	
    	if ( (answer > 1000000000) || (answer < 0)) return -1;
    	
    	return answer;
    }
    
    public int Distinct(int[] A) {
    	Set<Integer> set = new HashSet<>();
    	
    	for (int i=0; i<A.length; i++) {
    		set.add(A[i]);
    	}
    	
    	return set.size();
    }
    
    public int MaxProductOfThree(int[] A) {
    	int answer = 0;
    	ArrayList<Integer> list = new ArrayList<>();
    	
    	for (int i=0; i<A.length; i++) {
    		list.add(A[i]);
    	}
    	
    	Collections.sort(list);
    	
    	if (list.get(list.size()-1) < 0) {	// if all numbers are minus?
    		answer = list.get(list.size()-3) * list.get(list.size()-2) * list.get(list.size()-1);
    	} else if ((list.get(0) * list.get(1)) >= (list.get(list.size()-3) * list.get(list.size()-2))) {    	//best case is max numbers with (-) minus and (+) plus
    		answer = list.get(0) * list.get(1) * list.get(list.size()-1);
    	} else {
    		answer = list.get(list.size()-3) * list.get(list.size()-2) * list.get(list.size()-1);
    	}
    	
    	return answer;
    }
    
    public int NumberOfDiscIntersections(int[] A) {
    	int answer = 0;
    	
    	for (int i=0; i<A.length-1; i++) {
    		for (int j=i+1; j<A.length; j++ ) {
    			if ((j-A[j]) <= ((long)i+A[i])) {	// circle J is right closed at the edge of circle I
					answer++;
    			}
    		}
    	}
    	
    	if (answer>10000000) return -1;
    	
    	return answer;
    }
    
}