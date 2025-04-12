
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Comparison {

    public static void main(String[] args) {
        ArrayOperations arrayOps = new ArrayOperations();
        ArrayListOperations listOps = new ArrayListOperations();

        int[] array = {10, 20, 30, 40, 50};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int val : array) {
            arrayList.add(val);
        }

        // Traversal
        arrayOps.traverse(array);
        listOps.traverse(arrayList);

        // ========== LINEAR SEARCH ==========
        int key = 30;
        long start = System.nanoTime();
        int indexA = arrayOps.linearSearch(array, key);
        long end = System.nanoTime();
        System.out.println("Linear Search Array: index = " + indexA + ", waktu = " + (end - start) + " ns");

        start = System.nanoTime();
        int indexL = listOps.search(arrayList, key);
        end = System.nanoTime();
        System.out.println("Linear Search ArrayList: index = " + indexL + ", waktu = " + (end - start) + " ns");

        // ========== BINARY SEARCH ==========
        Arrays.sort(array); // Binary search butuh array terurut
        start = System.nanoTime();
        int binaryIndex = arrayOps.binarySearch(array, key);
        end = System.nanoTime();
        System.out.println("Binary Search Array: index = " + binaryIndex + ", waktu = " + (end - start) + " ns");

        // ========== INSERT ==========
        int[] insertedArray = arrayOps.insert(array, 2, 25);
        System.out.println("Array setelah insert 25 di index 2: " + Arrays.toString(insertedArray));

        listOps.insert(arrayList, 2, 25);
        System.out.println("ArrayList setelah insert 25 di index 2: " + arrayList);

        // ========== DELETE ==========
        int[] deletedArray = arrayOps.delete(insertedArray, 2);
        System.out.println("Array setelah hapus index 2: " + Arrays.toString(deletedArray));

        listOps.delete(arrayList, 2);
        System.out.println("ArrayList setelah hapus index 2: " + arrayList);

        // ========== SORT ==========
        arrayList.add(99);
        arrayList.add(3);
        System.out.println("ArrayList sebelum sort: " + arrayList);
        listOps.sort(arrayList);
        System.out.println("ArrayList setelah sort: " + arrayList);

        // ========== TEST DATA BESAR ==========
        int size = 1000;
        int[] bigArray = new int[size];
        ArrayList<Integer> bigList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            int val = rand.nextInt(10000);
            bigArray[i] = val;
            bigList.add(val);
        }

        int searchKey = bigArray[size / 2];

        start = System.nanoTime();
        arrayOps.linearSearch(bigArray, searchKey);
        end = System.nanoTime();
        System.out.println("Linear Search pada Array (1000 data): " + (end - start) + " ns");

        start = System.nanoTime();
        listOps.search(bigList, searchKey);
        end = System.nanoTime();
        System.out.println("Search pada ArrayList (1000 data): " + (end - start) + " ns");
    }
}
