/******************************************************************************
 *  Compilation:  javac Sorting.java
 *  Execution:    java Sorting input.txt AlgorithmUsed
 *  Dependencies: StdOut.java In.java Stopwatch.java
 *  Data files:   http://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *
 *  A program to play with various sorting algorithms. 
 *
 *
 *  Example run:
 *  % java Sorting 2Kints.txt  2
 *
 ******************************************************************************/
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class Sorting {


 /**
     * 
     * Sorts the numbers present in the file based on the algorithm provided.
     * 0 = Arrays.sort() (Java Default)
     * 1 = Bubble Sort
     * 2 = Selection Sort 
     * 3 = Insertion Sort 
     * 4 = Mergesort
     * 5 = Quicksort
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args)  { 
        In in1 = new In(args[0]);
        In in2 = new In(args[0]);
        In in3 = new In(args[0]);
        In in4 = new In(args[0]);
        
		// Storing file input in an array
        int[] a = in1.readAllInts();
        // b contains sorted integers from a (You can use Java Arrays.sort() method)
        int[] b = in2.readAllInts();
        Arrays.sort(b);
        // c contains all integers stored in reverse order 
        // (you can have your own O(n) solution to get c from b
        int[] c = in3.readAllInts();
        Arrays.sort(c);
        for (int i = 0; i < c.length/2; i++) {
        	int temp = c[i];
        	c[i] = c[c.length-i-1];
        	c[c.length-i-1] = temp;
        }
        // d contains almost sorted array 
        //(You can copy b to a and then perform (0.1 * d.length)  many swaps to acheive this.   
        int[] d = in4.readAllInts();
        Arrays.sort(d);
        for (int i = 0; i < 0.1*c.length; i++) {
        	int p1 = StdRandom.uniform(d.length);
        	int p2 = StdRandom.uniform(d.length);
        	
        	int temp = d[p1];
        	d[p1] = d[p2];
        	d[p2] = temp;
        }
        // Read the second argument and based on input select the sorting algorithm
        //Scanner sc = new Scanner(System.in);
        //System.out.println("Please enter a number to select algorithm");
       // System.out.println("Enter number 0 for Arrays.sort()");
        //System.out.println("Enter number 1 for Bubble Sort");
        //System.out.println("Enter number 2 for Selection Sort ");
        //System.out.println("Enter number 3 for Insertion Sort ");
        //System.out.println("Enter number 4 for Mergesort");
        //System.out.println("Enter number 5 for Quicksort");
       
        //  * 0 = Arrays.sort() (Java Default)
        if (args[1].equals("0")) {
        	String netID = "yliu165";
        	String algorithmUsed = "Arrays.sort()";
        	
        	Stopwatch timer1 = new Stopwatch();
        	Arrays.sort(a);
        	double time1 = timer1.elapsedTimeMillis();
        	String timeStamp1 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	String arrayUsed1 = "a";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed1, time1, timeStamp1, netID, args[0]);
        	
        	Stopwatch timer2 = new Stopwatch();
        	Arrays.sort(b);
        	double time2 = timer2.elapsedTimeMillis();
        	String timeStamp2 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	String arrayUsed2 = "b";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed2, time2, timeStamp2, netID, args[0]);
        	
        	Stopwatch timer3 = new Stopwatch();
        	Arrays.sort(c);
        	double time3 = timer3.elapsedTimeMillis();
        	String timeStamp3 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	String arrayUsed3 = "c";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed3, time3, timeStamp3, netID, args[0]);
        	
        	Stopwatch timer4 = new Stopwatch();
        	Arrays.sort(d);
        	double time4 = timer4.elapsedTimeMillis();
        	String timeStamp4 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	String arrayUsed4 = "d";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed4, time4, timeStamp4, netID, args[0]);
        }
        //  * 1 = Bubble Sort
        if (args[1].equals("1")) {
        	String netID = "yliu165";
        	String algorithmUsed = "Bubble Sort";
        	
        	Stopwatch timer1 = new Stopwatch();
        	 int i1, j1, temp1;
        	 for (i1 = 0; i1 < a.length - 1; i1++) {
        		 for (j1 = 0; j1 < a.length - i1 - 1; j1++) {
        			 if (a[j1] > a[j1 + 1]) {
        				 temp1 = a[j1 + 1];
        				 a[j1 + 1] = a[j1];
        				 a[j1] = temp1;
        			 }
        		 }
        	 }
        	double time1 = timer1.elapsedTimeMillis();
        	 String timeStamp1 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	 String arrayUsed1 = "a";
        	 StdOut.printf("%s %s %8.1f %s %s %s\n", algorithmUsed, arrayUsed1, time1, timeStamp1, netID, args[0]);
////////////////////////////////////////////////////////////////////////////////////////////////////////////
        	 Stopwatch timer2 = new Stopwatch();
        	 int i2, j2, temp2;
        	 for (i2 = 0; i2 < b.length - 1; i2++) {
        		 for (j2 = 0; j2 < b.length - i2 - 1; j2++) {
        			 if (b[j2] > b[j2 + 1]) {
        				 temp2 = b[j2 + 1];
        				 b[j2 + 1] = b[j2];
        				 b[j2] = temp2;
        			 }
        		 }
        	 }
        	double time2 = timer2.elapsedTimeMillis();
        	 String timeStamp2 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	 String arrayUsed2 = "b";
        	 StdOut.printf("%s %s %8.1f %s %s %s\n", algorithmUsed, arrayUsed2, time2, timeStamp2, netID, args[0]);
////////////////////////////////////////////////////////////////////////////////////////////////////////////
        	 Stopwatch timer3 = new Stopwatch();
        	 int i3, j3, temp3;
        	 for (i3 = 0; i3 < c.length - 1; i3++) {
        		 for (j3 = 0; j3 < c.length - i3 - 1; j3++) {
        	 if (c[j3] > c[j3 + 1]) {
        		 temp3 = c[j3 + 1];
        		 c[j3 + 1] = c[j3];
        		 c[j3] = temp3;
        	 	}
        		 }
        	 }
        	double time3 = timer3.elapsedTimeMillis();
        	 String timeStamp3 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
////////////////////////////////////////////////////////////////////////////////////////////////////////////
        	 String arrayUsed3 = "c";
        	 StdOut.printf("%s %s %8.1f %s %s %s\n", algorithmUsed, arrayUsed3, time3, timeStamp3, netID, args[0]);
        	 Stopwatch timer4 = new Stopwatch();
        	 int i4, j4, temp4;
        	 for (i4 = 0; i4 < d.length - 1; i4++) {
        		 for (j4 = 0; j4 < d.length - i4 - 1; j4++) {
        			 if (d[j4] > d[j4 + 1]) {
        				 temp4 = d[j4 + 1];
        				 d[j4 + 1] = d[j4];
        				 d[j4] = temp4;
        			 }
        		 }
        	 }
        	double time4 = timer4.elapsedTimeMillis();
        	 String timeStamp4 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	 String arrayUsed4 = "d";
        	 StdOut.printf("%s %s %8.1f %s %s %s\n", algorithmUsed, arrayUsed4, time4, timeStamp4, netID, args[0]);
        	
        }
        //  * 2 = Selection Sort 
        if (args[1].equals("2")) {
        	String netID = "yliu165";
        	String algorithmUsed = "Selection Sort";
        	
        	Stopwatch timer1 = new Stopwatch();
        	int i1, j1, temp1, min1;
        	for (i1 = 0; i1<a.length-1; i1++) {
        		min1 = i1;
        		for(j1 = i1 + 1; j1<a.length; j1++) {
        			if(a[j1]<a[min1]) {
        				min1 = j1;
        			}
        		}
        		temp1 = a[i1];
        		a[i1] = a[min1];
        		a[min1] = temp1;	
        	}
        	
        	double time1 = timer1.elapsedTimeMillis();
        	String timeStamp1 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	String arrayUsed1 = "a";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed1, time1, timeStamp1, netID, args[0]);
        	////////////////////////////////////////////////////////////////////////////////////////////////////////////
        	Stopwatch timer2 = new Stopwatch();
        	int i2, j2, temp2, min2;
        	for (i2 = 0; i2<a.length-1; i2++) {
        		min2 = i2;
        		for(j2 = i2 + 1; j2<a.length; j2++) {
        			if(a[j2]<a[min2]) {
        				min2 = j2;
        			}
        		}
        		temp2 = a[i2];
        		a[i2] = a[min2];
        		a[min2] = temp2;	
        	}
        	double time2 = timer2.elapsedTimeMillis();
        	String timeStamp2 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	String arrayUsed2 = "b";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed2, time2, timeStamp2, netID, args[0]);
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        	Stopwatch timer3 = new Stopwatch();
        	int i3, j3, temp3, min3;
        	for (i3 = 0; i3<a.length-1; i3++) {
        		min3 = i3;
        		for(j3 = i3 + 1; j3<a.length; j3++) {
        			if(a[j3]<a[min3]) {
        				min3 = j3;
        			}
        		}
        		temp3 = a[i3];
        		a[i3] = a[min3];
        		a[min3] = temp3;	
        	}
        	double time3 = timer3.elapsedTimeMillis();
        	String timeStamp3 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	String arrayUsed3 = "c";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed3, time3, timeStamp3, netID, args[0]);      
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        	Stopwatch timer4 = new Stopwatch();
        	int i4, j4, temp4, min4;
        	for (i4 = 0; i4<a.length-1; i4++) {
        		min4 = i4;
        		for(j4 = i4 + 1; j4<a.length; j4++) {
        			if(a[j4]<a[min4]) {
        				min4 = j4;
        			}
        		}
        		temp4 = a[i4];
        		a[i4] = a[min4];
        		a[min4] = temp4;	
        	}
        	double time4 = timer4.elapsedTimeMillis();
        	String timeStamp4 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	String arrayUsed4 = "d";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed4, time4, timeStamp4, netID, args[0]);
        	
        }
        //  * 3 = Insertion Sort 
        if (args[1].equals("3")) {
        	String netID = "yliu165";
        	String algorithmUsed = "Insertion Sort";
        	
        	Stopwatch timer1 = new Stopwatch();
        	int i1, j1, key1;
			for (i1 = 1; i1 < a.length; i1++) {
				key1 = a[i1];
				j1 = i1 - 1;
				while (j1 >= 0 && a[j1] > key1) {
					a[j1 + 1] = a[j1];
					j1--;
				}
				a[j1 + 1] = key1;
			}
        	double time1 = timer1.elapsedTimeMillis();
        	String timeStamp1 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	String arrayUsed1 = "a";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed1, time1, timeStamp1, netID, args[0]);
        	////////////////////////////////////////////////////////////////////////////////////////////////////////////
        	Stopwatch timer2 = new Stopwatch();
        	int i2, j2, key2;
			for (i2 = 1; i2 < b.length; i2++) {
				key2 = b[i2];
				j2 = i2 - 1;
				while (j2 >= 0 && b[j2] > key2) {
					b[j2 + 1] = b[j2];
					j2--;
				}
				b[j2 + 1] = key2;
			}
        	double time2 = timer2.elapsedTimeMillis();
        	String timeStamp2 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	String arrayUsed2 = "b";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed2, time2, timeStamp2, netID, args[0]);
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        	Stopwatch timer3 = new Stopwatch();
        	int i3, j3, key3;
			for (i3 = 1; i3 < c.length; i3++) {
				key3 = c[i3];
				j3 = i3 - 1;
				while (j3 >= 0 && c[j3] > key3) {
					c[j3 + 1] = c[j3];
					j3--;
				}
				c[j3 + 1] = key3;
			}
        	double time3 = timer3.elapsedTimeMillis();
        	String timeStamp3 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	String arrayUsed3 = "c";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed3, time3, timeStamp3, netID, args[0]);      
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        	Stopwatch timer4 = new Stopwatch();
        	int i4, j4, key4;
			for (i4 = 1; i4 < d.length; i4++) {
				key4 = d[i4];
				j4 = i4 - 1;
				while (j4 >= 0 && d[j4] > key4) {
					d[j4 + 1] = d[j4];
					j4--;
				}
				d[j4 + 1] = key4;
			}
        	double time4 = timer4.elapsedTimeMillis();
        	String timeStamp4 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	String arrayUsed4 = "d";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed4, time4, timeStamp4, netID, args[0]);
        	
        	
        	
        }
        //  * 4 = Mergesort
        if (args[1].equals("4")) {
        	String netID = "yliu165";
        	String algorithmUsed = "Mergesort";
        	
        	Stopwatch timer1 = new Stopwatch();
        	mergeSort(a,0,a.length-1);
        	double time1 = timer1.elapsedTimeMillis();
        	String timeStamp1 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	String arrayUsed1 = "a";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed1, time1, timeStamp1, netID, args[0]);
        	
        	Stopwatch timer2 = new Stopwatch();
        	mergeSort(b,0,b.length-1);
        	double time2 = timer2.elapsedTimeMillis();
        	String timeStamp2 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	String arrayUsed2 = "b";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed2, time2, timeStamp2, netID, args[0]);
        	
        	Stopwatch timer3 = new Stopwatch();
        	mergeSort(c,0,c.length-1);
        	double time3 = timer3.elapsedTimeMillis();
        	String timeStamp3 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	String arrayUsed3 = "c";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed3, time3, timeStamp3, netID, args[0]);
        	
        	Stopwatch timer4 = new Stopwatch();
        	mergeSort(c,0,c.length-1);
        	double time4 = timer4.elapsedTimeMillis();
        	String timeStamp4 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	String arrayUsed4 = "d";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed4, time4, timeStamp4, netID, args[0]);
        	
        }
        //  * 5 = Quicksort
        if (args[1].equals("5")) {
        	String netID = "yliu165";
        	String algorithmUsed = "Quicksort";
        	
        	Stopwatch timer1 = new Stopwatch();
        	quickSort(a,0,a.length-1);
        	double time1 = timer1.elapsedTimeMillis();
        	String timeStamp1 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	String arrayUsed1 = "a";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed1, time1, timeStamp1, netID, args[0]);
        	
        	Stopwatch timer2 = new Stopwatch();
        	quickSort(b,0,b.length-1);
        	double time2 = timer2.elapsedTimeMillis();
        	String timeStamp2 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	String arrayUsed2 = "b";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed2, time2, timeStamp2, netID, args[0]);
        	
        	Stopwatch timer3 = new Stopwatch();
        	quickSort(c,0,c.length-1);
        	double time3 = timer3.elapsedTimeMillis();
        	String timeStamp3 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	String arrayUsed3 = "c";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed3, time3, timeStamp3, netID, args[0]);
        	
        	Stopwatch timer4 = new Stopwatch();
        	quickSort(c,0,c.length-1);
        	double time4 = timer4.elapsedTimeMillis();
        	String timeStamp4 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	String arrayUsed4 = "d";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed4, time4, timeStamp4, netID, args[0]);
        	
        }
        
        //Print
        PrintWriter printWriter1;
        PrintWriter printWriter2;
        PrintWriter printWriter3;
        PrintWriter printWriter4;
        try {
			printWriter1 = new PrintWriter("a.txt");

			for (int i = 0; i < a.length; i++) {
				printWriter1.println(a[i]);
			}
			printWriter1.close();
			printWriter2 = new PrintWriter("b.txt");

			for (int i = 0; i < b.length; i++) {
				printWriter2.println(b[i]);
			}
			printWriter2.close();
			printWriter3 = new PrintWriter("c.txt");

			for (int i = 0; i < c.length; i++) {
				printWriter3.println(c[i]);
			}
			printWriter3.close();
			printWriter4 = new PrintWriter("d.txt");

			for (int i = 0; i < d.length; i++) {
				printWriter4.println(d[i]);
			}
			printWriter4.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
  } 
	public static void mergeSort(int[] array, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			mergeSort(array, l, m);
			mergeSort(array, m + 1, r);
			mergeArray(array, l, m, r);
		}
	}

	public static void mergeArray(int[] array, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		int L[] = new int[n1];
		int R[] = new int[n2];
		for (int i = 0; i < n1; ++i)
			L[i] = array[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = array[m + 1 + j];
		int i = 0, j = 0, k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			array[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			array[k] = R[j];
			j++;
			k++;
		}
	}

	public static void quickSort(int arr[], int i, int j) {//a,0,a.length-1
		int pivotindex = (i + j) / 2;
		int v1 = arr[pivotindex];
		int v2 = arr[j];
		arr[pivotindex] = v2;
		arr[j] = v1;
		int k = partition(arr, i - 1, j, arr[j]);
		int v3 = arr[k];
		int v4 = arr[j];
		arr[k] = v4;
		arr[j] = v3;
		if ((k - i) > 1)
			quickSort(arr, i, k - 1);
		if ((j - k) > 1)
			quickSort(arr, k + 1, j);
	}

	public static int partition(int arr[], int l, int r, int pivotindex) {
		do {
			while (arr[++l] < pivotindex);
			while ((r != 0) && (arr[--r] > pivotindex));
			int v1 = arr[l];
			int v2 = arr[r];
			arr[l] = v2;
			arr[r] = v1;
		} while (l < r);
		int v3 = arr[l];
		int v4 = arr[r];
		arr[l] = v4;
		arr[r] = v3;
		return l;
	}
} 


