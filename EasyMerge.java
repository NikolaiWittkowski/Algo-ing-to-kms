package sorting;

import java.util.Arrays;

public class EasyMerge {
	public static void main(String[] args) {
		int[] array = { 10, 20, 15, 30, 99, 1, 2 };
		
		mergeSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void mergeSort(int[] array) {
		// Wenn Array nur aus einem Element besteht oder keinem dann Ende
		if (array.length < 2) {
			return;
		}
		
		// Array in zwei Hälften teilen
		int middle = array.length / 2;
		int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);
		
		// Rekursiv die Hälften sortieren
		mergeSort(left);
		mergeSort(right);
		
		// Die sortierten Hälften zusammenführen
		merge(array, left, right);
	}
	
	public static void merge(int[] array, int[] left, int[] right) {
		int i = 0, j = 0, k = 0;
		
		// Element sortiert ins output array sortieren
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				array[k] = left[i];
				k++;
				i++;
			}
			else {
				array[k] = right[j];
				k++;
				j++;
			}
		}
		
		// Wenn eine Seite noch nicht leer ist
		while (i < left.length) {
			array[k] = left[i];
			k++;
			i++;
		}
		while (j < right.length) {
			array[k] = right[j];
			k++;
			j++;
		}
	}
}
