package spring.di;

import spring.di.answer.HackerRankSolution;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Program {
    public int[] duplicated_number(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i])+1);
            }
        }

        ArrayList<Integer> intList = new ArrayList<Integer>();
        for (int key : map.keySet()) {
            if (map.get(key) > 1) continue;
            else
                intList.add(key);
        }

        if (intList.isEmpty()) intList.add(-1);
        Collections.sort(intList);
        int[] res = new int[intList.size()];
        for (int i=0; i<intList.size(); i++) {
            res[i] = intList.get(i).intValue();
        }

        for (int i=0; i<res.length; i++) {
            System.out.print(res[i] + " ");
        }

        return res;
    }

    public long square_number(long a, long b) {
        DecimalFormat df = new DecimalFormat("####0");
        BigDecimal val = BigDecimal.valueOf(a);
        BigDecimal bdRes = BigDecimal.ONE;
        bdRes = bdRes.multiply(val);
        String str;
        long res = 0;

        for (int i=2; i< b+1; i++) {
            bdRes = bdRes.multiply(val);
        }

        if (bdRes.intValue() > 99999) {
            str = bdRes.toString();
            str.substring(str.length()-5, str.length());
            res = Long.parseLong(str);
            res = Long.parseLong(df.format(Long.parseLong(str)));
        } else {
            str = bdRes.toString();
            res = Long.parseLong(str);
            res = Long.parseLong(df.format(Long.parseLong(str)));
        }

        return res;
    }

    public static void main(String[] Args) throws IOException {
//        Exam exam = new midExam();
//        ExamConsole console = new inlineEXamConsole(exam);
//        console.print();
//
//        Program program = new Program();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("input the int array: ");
//        String[] strArray = bufferedReader.readLine().split(" ");
//        int[] nArray = new int[strArray.length];
//        for (int i=0; i<strArray.length; i++) {
//            nArray[i] = Integer.parseInt(strArray[i]);
//        }
//
//        program.duplicated_number(nArray);
//
//        System.out.print("input the first val: ");
//        String input_val = bufferedReader.readLine();
//        long nFparam = Long.parseLong(input_val);
//        System.out.print("input the second val: ");
//        input_val = bufferedReader.readLine();
//        long nSparam = Long.parseLong(input_val);
//
//        long res = program.square_number(nFparam, nSparam);

        HackerRankSolution hackerRankSolution = new HackerRankSolution();
        //hackerRankSolution.processing_getting_array();
        //hackerRankSolution.processing_compareTriplets();
        //hackerRankSolution.process_aVeryBigSum();
        hackerRankSolution.process_diagonalDifference();

//        System.out.println("res: " + res);
    }
}
