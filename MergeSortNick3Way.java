package sorting;

import java.util.Arrays;
import java.util.Random;

public class MergeSortNick3Way {

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
            //int middle = (begin + end) / 2;
        	int drittel = (end - begin) / 3;
        	int middle1 = begin + drittel;
        	int middle2 = middle1 + drittel;
            System.out.println("Aufruf von sortiere mit begin = " + begin + " und end = " + end);
            
            sortiere(a, begin, middle1);
            sortiere(a, middle1 + 1, middle2);
            
            // dritter Aufruf
            sortiere(a, middle2 + 1, end);
            
            
            System.out.println("Zu mergender Teil ist: " + Arrays.toString(Arrays.copyOfRange(a, begin, end + 1)));

            int[] left = Arrays.copyOfRange(a, begin, middle1 + 1);
            // drittes array
            int[] middle = Arrays.copyOfRange(a, middle1 + 1, middle2 + 1);
            int[] right = Arrays.copyOfRange(a, middle2 + 1, end + 1);

            int i = 0, j = 0, k = 0;
            int l = begin;

            while (i < left.length && j < middle.length && k < right.length) {
                if (left[i] >= middle[j] && left[i] >= right[k]) {
                    a[l++] = left[i++];
                } else if (middle[j] >= left[i] && middle[j] >= right[k]) {
                    a[l++] = middle[j++];
                } else {
                    a[l++] = right[k++];
                }
            }

            while (i < left.length && j < middle.length) {
                if (left[i] >= middle[j]) {
                    a[l++] = left[i++];
                } else {
                    a[l++] = middle[j++];
                }
            }

            while (j < middle.length && k < right.length) {
                if (middle[j] >= right[k]) {
                    a[l++] = middle[j++];
                } else {
                    a[l++] = right[k++];
                }
            }

            while (i < left.length && k < right.length) {
                if (left[i] >= right[k]) {
                    a[l++] = left[i++];
                } else {
                    a[l++] = right[k++];
                }
            }

            while (i < left.length) {
                a[l++] = left[i++];
            }

            while (j < middle.length) {
                a[l++] = middle[j++];
            }

            while (k < right.length) {
                a[l++] = right[k++];
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
