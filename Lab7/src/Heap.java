
/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 4:50pm - 6:05pm
 * I did not collaborate with anyone on this assignment.
 */

import java.util.Arrays;
import java.util.Random;
public class Heap {
	//Method for swapping elements
			public static void swap(int[] array, int i, int j) {
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
			
	    // methods to get index of the parent or left/right child
		@SuppressWarnings("unused")
		private static int parentIdx(int i) {
			return (i - 1) / 2;  
		}
		private static int leftIdx(int i) {
			return 2 * i + 1;
		}
		private static int rightIdx(int i) {
			return 2 * i + 2;
		}
		
		
		// restore max-heap property for the heap with parent node at index i 
		// Assuming children of A[i] are roots of max-heaps 
		public static void restore(int[] A, int i, int heapMaxIdx) {
			
			
			int L = leftIdx(i);
			int R = rightIdx(i);
			int largest = i;
			if (L <= heapMaxIdx && A[L] > A[i]) {
				largest = L;
			}
			if (R <= heapMaxIdx && A[R] > A[largest]) {
				largest = R;
			}
			if (largest != i) {
				swap(A, i, largest);
				restore(A, largest, heapMaxIdx);
			}	
			
				
		}
		
		// turn an arbitrary array into a max-heap
		public static void heapify(int[] A) {
			int heapMaxIdx = A.length - 1;
			for (int i = heapMaxIdx / 2; i >= 0; i--) {
				restore(A, i, heapMaxIdx);
			}
		}
		
		// Method heapsort: takes an array and sorts it in ascending order
		public static void heapSort(int[] A) {
			int heapMaxIdx = A.length - 1;
			heapify(A);
			for (int i = A.length - 1; i > 0; i--) {
				swap(A, 0, i);  // since A[0] is max element
				heapMaxIdx--;
				restore(A, 0, heapMaxIdx);
			}
		}
		
		
}
