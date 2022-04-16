
/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 4:50pm - 6:05pm
 * I did not collaborate with anyone on this assignment.
 */
import java.util.Random;

public class RadixSort {
	public static void main(String[] args) {
		//Create arrays
		Random myRandom = new Random();
		int[] array1 = new int[5000000];
		int[] array2 = new int[5000000];
		int[] array3 = new int[10000000];
		int[] array4 = new int[10000000];
		int[] array5 = new int[30000000];
		int[] array6 = new int[30000000];
		//Generate and fill in random nummbers to the arrays
		int k;
		for (int i = 0; i < 5000000; i++) {
			k = myRandom.nextInt(50000000);
			array1[i] = k;
			array2[i] = k;
		}
		for (int i = 0; i < 10000000; i++) {
			k = myRandom.nextInt(90000000);
			array3[i] = k;
			array4[i] = k;
		}
		for (int i = 0; i < 30000000; i++) {
			k = myRandom.nextInt(30000000);
			array5[i] = k;
			array6[i] = k;
		}
		//Rum time with timers
		double t1 = System.currentTimeMillis();
		divisionRadixSort(array1);
		double t2 = System.currentTimeMillis();
		bitShiftingRadixSort(array2);
		double t3 = System.currentTimeMillis();
		divisionRadixSort(array3);
		double t4 = System.currentTimeMillis();
		bitShiftingRadixSort(array4);
		double t5 = System.currentTimeMillis();
		divisionRadixSort(array5);
		double t6 = System.currentTimeMillis();
		bitShiftingRadixSort(array6);
		double t7 = System.currentTimeMillis();
		divisionRadixSort(array1);
		double t8 = System.currentTimeMillis();
		bitShiftingRadixSort(array2);
		double t9 = System.currentTimeMillis();
		divisionRadixSort(array3);
		double t10 = System.currentTimeMillis();
		bitShiftingRadixSort(array4);
		double t11 = System.currentTimeMillis();
		divisionRadixSort(array5);
		double t12 = System.currentTimeMillis();
		bitShiftingRadixSort(array6);
		double t13 = System.currentTimeMillis();
		//Print out the run time for each operation
		System.out.println("Old Radix Sort 1: " + (t2 - t1));
		System.out.println("New Radix Sort 1: " + (t3 - t2));
		System.out.println("Old Radix Sort 2: " + (t4 - t3));
		System.out.println("New Radix Sort 2: " + (t5 - t4));
		System.out.println("Old Radix Sort 3: " + (t6 - t5));
		System.out.println("New Radix Sort 3: " + (t7 - t6));
		System.out.println("Old Radix Sort 4: " + (t8 - t7));
		System.out.println("New Radix Sort 4: " + (t9 - t8));
		System.out.println("Old Radix Sort 5: " + (t10 - t9));
		System.out.println("New Radix Sort 5: " + (t11 - t10));
		System.out.println("Old Radix Sort 6: " + (t12 - t11));
		System.out.println("New Radix Sort 6: " + (t13 - t12));
		//Print first 30 elements of Array1
		System.out.print("Array1: ");
		for (int i = 0; i < 30; i++) {
			System.out.print(array1[i] + " ");
		}
		System.out.print("......");
		System.out.println();
		//Print first 30 elements of Array2
		System.out.print("Array2: ");
		for (int i = 0; i < 30; i++) {
			System.out.print(array2[i] + " ");
		}
		System.out.print("......");
		System.out.println();
		//Print first 30 elements of Array3
		System.out.print("Array3: ");
		for (int i = 0; i < 30; i++) {
			System.out.print(array3[i] + " ");
		}
		System.out.print("......");
		System.out.println();
		//Print first 30 elements of Array4
		System.out.print("Array4: ");
		for (int i = 0; i < 30; i++) {
			System.out.print(array4[i] + " ");
		}
		System.out.print("......");
		System.out.println();
		//Print first 30 elements of Array5
		System.out.print("Array5: ");
		for (int i = 0; i < 30; i++) {
			System.out.print(array5[i] + " ");
		}
		System.out.print("......");
		System.out.println();
		//Print first 30 elements of Array6
		System.out.print("Array6: ");
		for (int i = 0; i < 30; i++) {
			System.out.print(array6[i] + " ");
		}
		System.out.print("......");
	}

	public static void divisionRadixSort(int[] array) {
		int[] assist = new int[array.length];
		int[] count = new int[16];
		//Base 16
		int i, j, rtok;
		for (i = 0, rtok = 1; i < 8; i++, rtok *= 16) {
			//First inner for loop initialize the count
			for (j = 0; j < 16; j++)
				count[j] = 0;
			//Count the number of records for each bin on this pass
			for (j = 0; j < array.length; j++)
				count[(array[j] / rtok) % 16]++;
			//Count[j] will be index in assist for last slot of bin j
			for (j = 1; j < 16; j++)
				count[j] += count[j - 1];
			//Since bin fills from bottom, j counts downwards
			for (j = array.length - 1; j >= 0; j--)
				assist[--count[(array[j] / rtok) % 16]] = array[j];
			//Copy back
			for (j = 0; j < array.length; j++)
				array[j] = assist[j];
		}
	}

	public static void bitShiftingRadixSort(int[] array) {		
		int[] assist = new int[array.length];
		int[] count = new int[16];
		int i, j;
		for (i = 0; i < 8; i++) {
			for (j = 0; j < 16; j++)
				count[j] = 0;
			for (j = 0; j < array.length; j++)
				//Bit Shifting in place of division
				count[(array[j] >>> 4*i) % 16]++;
			for (j = 1; j < 16; j++)
				count[j] += count[j - 1];
			for (j = array.length - 1; j >= 0; j--)
				//Bit Shifting in place of division
				assist[--count[(array[j] >>> 4*i) % 16]] = array[j];
			for (j = 0; j < array.length; j++)
				array[j] = assist[j];
		}
	}
}
