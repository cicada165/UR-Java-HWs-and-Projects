/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 4:50pm - 6:05pm
 * I did not collaborate with anyone on this assignment.
 */
import java.util.Scanner;

public class Lab2<T> {
    public static <T> void printArrayGen(T[] inputArray) {
        for (T element : inputArray) {
            System.out.printf("%s", element);
        }
        System.out.println();
    }

    public static <T extends Comparable<T>> T getMaxGen(T[] inputArray) {
        T output = inputArray[0];
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].compareTo(output)>0) {
                output = inputArray [i];
            }
        }
        return output;
    }
    public static void printArrayNonGen(Object[] inputArray) {
        // display array elements
        for (Object element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static Comparable getMax(Comparable[] inputArray) {
        int output = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].compareTo(inputArray[output])>0) {
                output = i;
            }
        }
        return inputArray[output];
    }




    public static void printArray(Integer[] inputArray) {
        // display array elements
        for (Integer element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static void printArray(Double[] inputArray) {
        // display array elements
        for (Double element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
    public static void printArray(Character[] inputArray) {
        // display array elements
        for (Character element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
    public static void printArray(String[] inputArray) {
        // display array elements
        for (String element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }





    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] arrA = scanner.nextLine().split("\\s"); // input integers with white spaces between them (e.g. 1 2 3 4)
        String[] arrB = scanner.nextLine().split("\\s"); // input doubles with white spaces between them (e.g. 1.1 2.2 3.3 4.4)
        String[] arrC = scanner.nextLine().split("\\s"); // input characters with white spaces between them (e.g. H E L L O)
        String[] strArray = scanner.nextLine().split("\\s"); // input strings with white spaces between them (e.g. once upon a time)

        Integer[] intArray = new Integer[arrA.length];
        Double[] doubArray = new Double[arrB.length];
        Character[] charArray = new Character[arrC.length];

        for (int i = 0; i < arrA.length; i++) {intArray[i] = Integer.parseInt(arrA[i]);}
        for (int i = 0; i < arrB.length; i++) {doubArray[i] = Double.parseDouble(arrB[i]);}
        for (int i = 0; i < arrC.length; i++) {charArray[i] = arrC[i].charAt(0);}

        printArrayNonGen(intArray);
        printArrayNonGen(doubArray);
        printArrayNonGen(charArray);
        printArrayNonGen(strArray);

        printArray(intArray);
        printArray(doubArray);
        printArray(charArray);
        printArray(strArray);

        printArrayGen(intArray);
        printArrayGen(doubArray);
        printArrayGen(charArray);
        printArrayGen(strArray);

        System.out.println(getMax(intArray));
        System.out.println(getMax(doubArray));
        System.out.println(getMax(charArray));
        System.out.println(getMax(strArray));

        System.out.println(getMaxGen(intArray));
        System.out.println(getMaxGen(doubArray));
        System.out.println(getMaxGen(charArray));
        System.out.println(getMaxGen(strArray));
    }

}
