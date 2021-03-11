package spring.di.algorithmtest;

import java.io.IOException;

import spring.di.algorithmtest.answer.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
//      Exam exam = new midExam();
//      ExamConsole console = new inlineEXamConsole(exam);
//      console.print();
//
//      Program program = new Program();
//      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//      System.out.print("input the int array: ");
//      String[] strArray = bufferedReader.readLine().split(" ");
//      int[] nArray = new int[strArray.length];
//      for (int i=0; i<strArray.length; i++) {
//          nArray[i] = Integer.parseInt(strArray[i]);
//      }
//
//      program.duplicated_number(nArray);
//
//      System.out.print("input the first val: ");
//      String input_val = bufferedReader.readLine();
//      long nFparam = Long.parseLong(input_val);
//      System.out.print("input the second val: ");
//      input_val = bufferedReader.readLine();
//      long nSparam = Long.parseLong(input_val);
//
//      long res = program.square_number(nFparam, nSparam);

      HackerRankSolution hackerRankSolution = new HackerRankSolution();
      //hackerRankSolution.processing_getting_array();
      //hackerRankSolution.processing_compareTriplets();
      //hackerRankSolution.process_aVeryBigSum();
      //hackerRankSolution.process_diagonalDifference();
      //hackerRankSolution.process_formingMagicSquare();
      hackerRankSolution.process_extraLongFactorials();

//      System.out.println("res: " + res);
    }
}
