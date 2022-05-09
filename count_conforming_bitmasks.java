import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class codility_code_test {
    public static void main (String[] args) {
        int result = CountConformingBitmasks();
        System.out.println("result: " + result);
    }

    public static Map<Integer, Character> getMap (int a, char c) {
        Map<Integer, Character> map = new HashMap<>();
        map.put(a, c);
        return map;
    }

    static int CountConformingBitmasks() {
        int nA = 1073741727;
        int nB = 1073741631;
        int nC = 1073741679;
        String strA = Integer.toBinaryString(nA);
        String strB = Integer.toBinaryString(nB);
        String strC = Integer.toBinaryString(nC);
        System.out.println("strA: " + strA);
        System.out.println("strB: " + strB);
        System.out.println("strC: " + strC);
        System.out.println("bitCount of nC: " + Integer.bitCount(nC));

        int nBitCountA = Integer.bitCount(nA);
        int nBitCountB = Integer.bitCount(nB);
        int nBitCountC = Integer.bitCount(nC);

        int indexA = 0;
        int indexB = 0;
        int indexC = 0;

        // HashMap<Integer, Map<Integer, Character>> mapA = new HashMap<>();
        // HashMap<Integer, Map<Integer, Character>> mapB = new HashMap<>();
        // HashMap<Integer, Map<Integer, Character>> mapC = new HashMap<>();
        
        // //extract 0 digit from the numbers.
        // for (int i=0; i<30; i++) {
        //     if ((strA.charAt(i) == 0) && (nBitCountA > 0)) {
        //         nBitCountA--;
        //         mapA.put(indexA++, getMap(i, strA.charAt(i)));
        //     }

        //     if ((strB.charAt(i) == 0) && (nBitCountB > 0)) {
        //         nBitCountB--;
        //         mapB.put(indexB++, getMap(i, strB.charAt(i)));
        //     }

        //     if ((strC.charAt(i) == 0) && (nBitCountC > 0)) {
        //         nBitCountC--;
        //         mapC.put(indexC++, getMap(i, strC.charAt(i)));
        //     }
        // }

        Map<Integer, Character> mapA = new HashMap<>();
        Map<Integer, Character> mapB = new HashMap<>();
        Map<Integer, Character> mapC = new HashMap<>();
        
        //extract 0 digit from the numbers.
        for (int i=0; i<30; i++) {
            if ((strA.charAt(i) == 0) && (nBitCountA > 0)) {
                nBitCountA--;
                mapA.put(i, strA.charAt(i));
            }

            if ((strB.charAt(i) == 0) && (nBitCountB > 0)) {
                nBitCountB--;
                mapB.put(i, strB.charAt(i));
            }

            if ((strC.charAt(i) == 0) && (nBitCountC > 0)) {
                nBitCountC--;
                mapC.put(i, strC.charAt(i));
            }
        }

        ArrayList<Integer> listA = new ArrayList<>();
        listA.add(nA);

        Set<Entry<Integer, Character>> entryset = mapA.entrySet();
        for (Entry<Integer, Character> entry : entryset ) {
            nA |= (1<<entry.getKey());
            listA.add(nA);
        }
        // for (int i =0; char c = strA.charAt(i); i++) {

        // }
        int num = 0;
        return num;
    }
    
}

