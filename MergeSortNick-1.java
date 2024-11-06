package sorting;

import java.util.Arrays;
import java.util.Random;

public class MergeSortNick {

    public static void main(String[] args) {
        // Erzeugt ein zufälliges Array mit einer zufälligen Länge zwischen 1 und 100
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(0, 15);
        }

        System.out.println("OG array");
        printArray(arr);
        sortiere(arr, 0, arr.length - 1); // Sortiere den gesamten Bereich des Arrays
        System.out.println("Neu array");
        printArray(arr);
    }

    public static void sortiere(int[] a, int begin, int end) {
        if (begin < end) {
            int middle = (begin + end) / 2;

            System.out.println("Aufruf von sortiere mit begin = " + begin + " und end = " + end);

            sortiere(a, begin, middle);
            sortiere(a, middle + 1, end);

            System.out.println("Zu mergender Teil ist: " + Arrays.toString(Arrays.copyOfRange(a, begin, end + 1)));

            int[] left = Arrays.copyOfRange(a, begin, middle + 1);
            int[] right = Arrays.copyOfRange(a, middle + 1, end + 1);

            int i = 0, j = 0;
            int k = begin;

            while (i < left.length && j < right.length) {
                if (left[i] >= right[j]) {
                    a[k++] = left[i++];
                } else {
                    a[k++] = right[j++];
                }
            }

            while (i < left.length) {
                a[k++] = left[i++];
            }

            while (j < right.length) {
                a[k++] = right[j++];
            }

            System.out.println("Gemergter Teil ist nun: " + Arrays.toString(Arrays.copyOfRange(a, begin, end + 1)));
        }
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
