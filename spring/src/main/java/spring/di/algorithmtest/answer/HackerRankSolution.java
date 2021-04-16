package spring.di.algorithmtest.answer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.math.BigInteger;

import static java.util.stream.Collectors.toList;

public class HackerRankSolution {
    /*
     * Complete the simpleArraySum function below.
     */
    static int simpleArraySum(int[] ar) {
        /*
         * Write your code here.
         */
        int answer = 0;
        for (int i =0; i< ar.length; i++) {
            answer += ar[i];
        }

        return answer;
    }

    public void processing_getting_array() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("please input how many number you want: ");
        int nCount = Integer.parseInt(bufferedReader.readLine().trim());
        System.out.print("please input array numbers ");
        String[] strArray = bufferedReader.readLine().split(" ");

        int[] ar = new int[nCount];
        for (int arItr = 0; arItr < nCount; arItr++) {
            int arItem = Integer.parseInt(strArray[arItr].trim());
            ar[arItr] = arItem;
        }

        int result = simpleArraySum(ar);
        System.out.println("the result " + result);

        bufferedReader.close();
    }

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        int[] answer = {0,0};
        final int fTeam = 0;
        final int sTeam = 1;

        if (a.size() != b.size())
            return null;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i))
                answer[fTeam]++;
            else if (a.get(i) == b.get(i))
                continue;
            else
                answer[sTeam]++;
        }

        for (int i = 0; i< answer.length; i++) {
            result.add(answer[i]);
        }

        return result;
    }

    public void processing_compareTriplets() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("input first num: ");
        String[] strArg = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        Stream<Integer> sample = Stream.of(strArg).map(Integer::parseInt);
        List<Integer> fList = sample.collect(toList());

        System.out.print("input second num: ");
        strArg = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        Stream<Integer> sample2 = Stream.of(strArg).map(Integer::parseInt);
        List<Integer> sList = sample2.collect(toList());

        List<Integer> answer = compareTriplets(fList, sList);

        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }

        bufferedReader.close();
    }

    static long aVeryBigSum(long[] ar) {
        long answer = 0;

        for (int i = 0; i<ar.length; i++) {
            answer += ar[i];
        }

        System.out.println("aVeryBigSum answer: " + answer);
        return answer;
    }

    public void process_aVeryBigSum() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] ar = new long[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            long arItem = Long.parseLong(arItems[i]);
            ar[i] = arItem;
        }

        long result = aVeryBigSum(ar);

        scanner.close();
    }

    public void process_diagonalDifference() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();
        IntStream.range(0, n).forEach(i-> {
            try {
                matrix.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Result cResult = new Result();
        int result = cResult.diagonalDifference(matrix);

        bufferedReader.close();
    }

    public void process_formingMagicSquare() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = bufferedReader.readLine().split(" ");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        Result cResult = new Result();
        int result = cResult.formingMagicSquare(s);

        System.out.println(result);

        bufferedReader.close();
    }

    public static void process_pickingNumbers() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int nCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());

        int result = Result.pickingNumbers(a);
        bufferedReader.close();
    }
    
    public void process_extraLongFactorials() throws IOException{
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("input: ");
    	String num = bufferedReader.readLine();

    	Result cResult = new Result();
        cResult.extraLongFactorials(Integer.parseInt(num));
    	BigInteger f = cResult.factorial(new BigInteger(num));
        System.out.printf("factorial(%2s) = %20s%n", num, f.toString());


    }
    
    /*
     * https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
     */
    public void process_MaxCounters() throws IOException {
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	String[] inputStr = bufferedReader.readLine().split(" ");
    	int[] inputInt = new int[inputStr.length];
    	int nCount = Integer.parseInt(bufferedReader.readLine());
    	
    	for (int i=0; i<inputStr.length; i++) {
    		inputInt[i] = Integer.parseInt(inputStr[i]);
    	}
    	
    	Result cResult = new Result();
    	int[] answer = cResult.MaxCounters(nCount, inputInt);
    	for ( int i=0; i<answer.length; i++) {
    		System.out.print(answer[i]);
    	}
    }
    
    /*
     * https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
     */
    public void process_MissingInteger() throws IOException {
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	String[] inputStr = bufferedReader.readLine().split(" ");
    	int[] inputInt = new int[inputStr.length];
    	
    	for (int i=0; i<inputStr.length; i++) {
    		inputInt[i] = Integer.parseInt(inputStr[i]);
    	}
    	
    	Result cResult = new Result();
    	int answer = cResult.MissingInteger(inputInt);
    	System.out.print(answer);
    }
    
    /*
     * https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
     */
    public void process_PermCheck() throws IOException {
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	String[] inputStr = bufferedReader.readLine().split(" ");
    	int[] inputInt = new int[inputStr.length];
    	
    	for (int i=0; i<inputStr.length; i++) {
    		inputInt[i] = Integer.parseInt(inputStr[i]);
    	}
    	
    	Result cResult = new Result();
    	int answer = cResult.PermCheck(inputInt);
    	System.out.print(answer);
    }
    
    /*
     * https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
     */
    public void process_CountDiv() throws IOException {
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	String[] inputStr = bufferedReader.readLine().split(" ");
    	
    	Result cResult = new Result();
    	int answer = cResult.CountDiv(Integer.parseInt(inputStr[0]), Integer.parseInt(inputStr[1]), 
    			Integer.parseInt(inputStr[2]));
    	System.out.print(answer);
    }
    
    /*
     * https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
     */
    public void process_GenomicRangeQuery() throws IOException {
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	String dna_seq = bufferedReader.readLine();
    	String[] firstStr = bufferedReader.readLine().split(" ");
    	String[] secondStr = bufferedReader.readLine().split(" ");
    	int[] firstInt = new int[firstStr.length];
    	int[] secondInt = new int[secondStr.length];
    	
    	for (int i=0; i<firstStr.length; i++) {
    		firstInt[i] = Integer.parseInt(firstStr[i]);
    		secondInt[i] = Integer.parseInt(secondStr[i]);
    	}
    	
    	Result cResult = new Result();
    	int[] answer = cResult.GenomicRangeQuery(dna_seq, firstInt, secondInt);
    	System.out.print(answer);
    }
    
    /*
     * https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
     */
    public void process_MinAvgTwoSlice() throws IOException {
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	String[] inputStr = bufferedReader.readLine().split(" ");
    	int[] inputInt = new int[inputStr.length];
    	
    	for (int i=0; i<inputStr.length; i++) {
    		inputInt[i] = Integer.parseInt(inputStr[i]);
    	}

    	Result cResult = new Result();
    	int answer = cResult.MinAvgTwoSlice(inputInt);
    	System.out.print(answer);
    }
    
    /*
     * https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
     */
    public void process_PassingCars() throws IOException {
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	String[] inputStr = bufferedReader.readLine().split(" ");
    	int[] inputInt = new int[inputStr.length];
    	
    	for (int i=0; i<inputStr.length; i++) {
    		inputInt[i] = Integer.parseInt(inputStr[i]);
    	}

    	Result cResult = new Result();
    	int answer = cResult.PassingCars(inputInt);
    	System.out.print(answer);
    }
    
    /*
     * https://app.codility.com/programmers/lessons/6-sorting/distinct/
     */
    public void process_Distinct() throws IOException {
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	String[] inputStr = bufferedReader.readLine().split(" ");
    	int[] inputInt = new int[inputStr.length];
    	
    	for (int i=0; i<inputStr.length; i++) {
    		inputInt[i] = Integer.parseInt(inputStr[i]);
    	}

    	Result cResult = new Result();
    	int answer = cResult.Distinct(inputInt);
    	System.out.print(answer);
    }
    
    /*
     * https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
     */
    public void process_MaxProductOfThree() throws IOException {
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	String[] inputStr = bufferedReader.readLine().split(" ");
    	int[] inputInt = new int[inputStr.length];
    	
    	for (int i=0; i<inputStr.length; i++) {
    		inputInt[i] = Integer.parseInt(inputStr[i]);
    	}

    	Result cResult = new Result();
    	int answer = cResult.MaxProductOfThree(inputInt);
    	System.out.print(answer);
    }
    
    /*
     * https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/
     */
    public void process_NumberOfDiscIntersections() throws IOException {
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	String[] inputStr = bufferedReader.readLine().split(" ");
    	int[] inputInt = new int[inputStr.length];
    	
    	for (int i=0; i<inputStr.length; i++) {
    		inputInt[i] = Integer.parseInt(inputStr[i]);
    	}

    	Result cResult = new Result();
    	int answer = cResult.NumberOfDiscIntersections(inputInt);
    	System.out.print(answer);
    }

    /*
     * https://app.codility.com/programmers/lessons/6-sorting/triangle/
     */
    public void process_Triangle() throws IOException {
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	String[] inputStr = bufferedReader.readLine().split(" ");
    	int[] inputInt = new int[inputStr.length];
    	
    	for (int i=0; i<inputStr.length; i++) {
    		inputInt[i] = Integer.parseInt(inputStr[i]);
    	}

    	Result cResult = new Result();
    	int answer = cResult.Triangle(inputInt);
    	System.out.print(answer);
    }
    
    /*
     * https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
     */
    public void process_Brackets() throws IOException {
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	String inputStr = bufferedReader.readLine();
    	
    	Result cResult = new Result();
    	int answer = cResult.Brackets("''");
    	//int answer = cResult.Brackets(inputStr);
    	System.out.print(answer);
    }
    
    public void process_Fish() throws IOException {
	    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	    String[] groupA = bufferedReader.readLine().split(" ");
	    String[] groupB = bufferedReader.readLine().split(" ");
	    int[] groupAInt = new int[groupA.length];
	    int[] groupBInt = new int[groupB.length];

	    for (int i=0; i<groupA.length; i++) {
		    groupAInt[i] = Integer.parseInt(groupA[i]);
		    groupBInt[i] = Integer.parseInt(groupB[i]);
	    }

    	Result cResult = new Result();
    	int answer = cResult.Fish(groupAInt, groupBInt);
    	System.out.print(answer);
    }

    
    /*
     * https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/
     */
    public void process_Nesting() throws IOException {
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	String inputStr = bufferedReader.readLine();
    	
    	Result cResult = new Result();
    	int answer = cResult.Brackets(inputStr);
    	System.out.print(answer);
    }
    
    /*
     * https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
     */
    public void process_stone_wall() throws IOException {
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	String[] inputStr = bufferedReader.readLine().split(" ");
    	int[] inputInt = new int[inputStr.length];
    	
    	for (int i=0; i<inputStr.length; i++) {
    		inputInt[i] = Integer.parseInt(inputStr[i]);
    	}

    	Result cResult = new Result();
    	int answer = cResult.stone_wall(inputInt);
    	System.out.print(answer);
    }
    
    /*
     * https://app.codility.com/programmers/lessons/8-leader/dominator/
     */
    public void process_dominator() throws IOException {
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	String[] inputStr = bufferedReader.readLine().split(" ");
    	int[] inputInt = new int[inputStr.length];
    	
    	for (int i=0; i<inputStr.length; i++) {
    		inputInt[i] = Integer.parseInt(inputStr[i]);
    	}

    	Result cResult = new Result();
    	int answer = cResult.dominator(inputInt);
    	System.out.print(answer);
    }
    
    /*
     * https://app.codility.com/programmers/lessons/8-leader/equi_leader/
     */
    public void process_equi_leader() throws IOException {
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	String[] inputStr = bufferedReader.readLine().split(" ");
    	int[] inputInt = new int[inputStr.length];
    	
    	for (int i=0; i<inputStr.length; i++) {
    		inputInt[i] = Integer.parseInt(inputStr[i]);
    	}

    	Result cResult = new Result();
    	int answer = cResult.equi_leader(inputInt);
    	System.out.print(answer);
    }
    
    /*
     * https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/
     */
    public void process_max_double_slice_sum() throws IOException {
//    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    	String[] inputStr = bufferedReader.readLine().split(" ");
//    	int[] inputInt = new int[inputStr.length];
//    	
//    	for (int i=0; i<inputStr.length; i++) {
//    		inputInt[i] = Integer.parseInt(inputStr[i]);
//    	}
//    	int[] inputInt = {3, 2, 6, -1, 4, 5, -1, 2};
//    	int[] inputInt = {0, 10, -5, -2, 0};
    	int[] inputInt = {-8, 10, 20, -5, -7, -4};

    	Result cResult = new Result();
    	int answer = cResult.max_double_slice_sum(inputInt);
    	System.out.print(answer);
    }
    
    /*
     * https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/
     */
    public void process_max_profit() throws IOException {
//    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    	String[] inputStr = bufferedReader.readLine().split(" ");
//    	int[] inputInt = new int[inputStr.length];
//    	
//    	for (int i=0; i<inputStr.length; i++) {
//    		inputInt[i] = Integer.parseInt(inputStr[i]);
//    	}

    	int[] inputInt = {23171, 21011, 21123, 21366, 21013, 21367}; 
    			
    	Result cResult = new Result();
    	int answer = cResult.max_profit(inputInt);
    	System.out.print(answer);
    }
    
    /*
     * https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/
     */
    public void process_max_slice_sum() throws IOException {
//    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    	String[] inputStr = bufferedReader.readLine().split(" ");
//    	int[] inputInt = new int[inputStr.length];
//    	
//    	for (int i=0; i<inputStr.length; i++) {
//    		inputInt[i] = Integer.parseInt(inputStr[i]);
//    	}

    	int[] inputInt = {3, 2, -6, 4, 0};
//    	int[] inputInt = {-2, 1}; 
//    	int[] inputInt = {1, 1};
//    	int[] inputInt = {1, 3};
//    	int[] inputInt = {-2, 1, 1};
//    	int[] inputInt = {1, 3, -5, 3, 7, 14, 29};
    			
    	Result cResult = new Result();
    	int answer = cResult.max_slice_sum(inputInt);
    	System.out.print(answer);
    }
    
    /*
     * https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/
     */
    public void process_count_factors() throws IOException {
//    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    	String inputStr = bufferedReader.readLine();
//    	int inputInt = Integer.parseInt(inputStr);

//    	int inputInt = 24;
//    	int inputInt = 27043111;
//    	int inputInt = 39916800;
    	int inputInt = 39992976;
    			
    	Result cResult = new Result();
    	int answer = cResult.max_count_factors(inputInt);
    	System.out.print(answer);
    }

    /*
     * https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/flags/
     */
    public void process_flags() throws IOException {
//    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    	String[] inputStr = bufferedReader.readLine().split(" ");
//    	int[] inputInt = new int[inputStr.length];
//    	
//    	for (int i=0; i<inputStr.length; i++) {
//    		inputInt[i] = Integer.parseInt(inputStr[i]);
//    	}

    	int[] inputInt = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
//    	int[] inputInt = {0, 0, 0, 0, 0, 1, 0, 1, 0, 1}; 
    			
    	Result cResult = new Result();
    	int answer = cResult.flags(inputInt);
    	System.out.print(answer);
    }
    
    /*
    * https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/
    */
    public void process_min_perimeter_rectangle() throws IOException {
    //     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    //     String inputStr = bufferedReader.readLine();
    //     int inputStr = 1;
    //     int inputStr = 30;
    	int inputStr = 982451653; 
    
    	Result cResult = new Result();
    	int answer = cResult.min_perimeter_rectangle(inputStr);
    	System.out.print(answer);
    }

}
