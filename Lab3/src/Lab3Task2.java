/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 4:50pm - 6:05pm
 * I did not collaborate with anyone on this assignment.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Lab3Task2 {

    public static int[][] runningSum2DArray(int[][] array, int dir) {
        int[][] tempArray = new int[4][4];

        if (dir == 1) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    int element = 0;
                    for (int k = j; k < 4; k++) {
                        element += array[i][k];
                    }
                    tempArray[i][j] = element;
                }
            }
        }
        else if (dir == 2) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    int element = 0;
                    for (int k = j; k >= 0; k--) {
                        element += array[i][k];
                    }
                    tempArray[i][j] = element;
                }
            }
        }
        Lab3Task1.print2DArray(tempArray);
        return tempArray;
    }

    public static ArrayList<ArrayList<Integer>>
    runningSum2DArrayList(ArrayList<ArrayList<Integer>> list, int dir) {
        ArrayList<ArrayList<Integer>> tempList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < 4; i++) {
            tempList.add(i, new ArrayList<Integer>());
        }

        if (dir == 3) {
            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < 4; i++) {
                    int output = 0;
                    for (int k = i; k < 4; k++) {
                        output += list.get(k).get(j);
                    }
                    tempList.get(i).add(output);
                }
            }
        }
        else if (dir == 4) {
            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < 4; i++) {
                    int output = 0;
                    for (int k = i; k >= 0; k--) {
                        output += list.get(k).get(j);
                    }
                    tempList.get(i).add(output);
                }
            }
        }
        Lab3Task1.print2DList(tempList);
        return tempList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //input arrays with ";" between them
        String[] temp = scanner.nextLine().split(";");

        //input integers with white space between them
        int[][] arr = new int[4][4];
        for(int i = 0; i < 4; i++){
            String[] tempA = temp[i].split("\\s");
            for(int j = 0; j < 4; j++){
                arr[i][j] = Integer.parseInt(tempA[j]);
            }
        }

        //input integers with white space between them
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < 4; i++){
            String[] tempA = temp[i].split("\\s");
            list.add(i, new ArrayList<Integer>());
            for(int j = 0; j < 4; j++){
                list.get(i).add(j, Integer.parseInt(tempA[j]));
            }
        }

        arr = runningSum2DArray(arr, 1);
        arr = runningSum2DArray(arr, 2);
        list = runningSum2DArrayList(list, 3);
        list = runningSum2DArrayList(list, 4);
        scanner.close();
    }
}
