
/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 4:50pm - 6:05pm
 * I did not collaborate with anyone on this assignment.
 */

import java.util.Arrays;
public class HeapTest {
	public static void main(String[] args) {
		int[] arr = new int[] {5,18,3,25,27,45,97,88,26,16,49,67};
		int[] arr2 = new int[] {15,99,3,77,27,45,7,88,26,5};
		
		Heap.heapify(arr);
		System.out.println(Arrays.toString(arr));
		
		Heap.heapSort(arr2);
		System.out.println(Arrays.toString(arr2));
	}
}
