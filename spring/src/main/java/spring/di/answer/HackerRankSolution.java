package spring.di.answer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
}
