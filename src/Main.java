import java.util.*;

/**
 * This program compares the efficiency of Merge Sort vs Bubble Sort
 */
public class Main
{

	public static void main(String[] args)

	{
		// generate array of random integers
		int[] nums= createNumArr(50001);

		// timer variables
		long start;
		long end;
		long time;
		

		System.out.printf("Sorting a number array of %d integers.\n", nums.length);

		// time mergeSort algorithm
		start = System.currentTimeMillis();
		mergeSort(nums);
		end = System.currentTimeMillis();
		time = (end - start);
		System.out.println("Merge Sort time: " + time + "ms.");

		// time bubbleSort algorithm
		start = System.currentTimeMillis();
		bubbleSort(nums);
		end = System.currentTimeMillis();
		time = (end - start);
		System.out.println("Bubble Sort time: " + time + "ms.");
		
	}

	/**
	 * Creates an array of random integers.
	 * @param len: The length of the array and the max range for generated integers.
	 * @return Unsorted array of random integers.
	 */
	private static int[] createNumArr(int len){
		int[] arr= new int[len];
		Random ran = new Random();
		int n;
		for (int i=0; i< len; i++){
			n = ran.nextInt(len);
			arr[i]=n;
		}
		
		return arr;
	}

	/**
	 * An implementation of Bubble Sort algorithm.
	 * @param arr: Integer array to be sorted.
	 * @return Sorted integer array.
	 */
	private static int[] bubbleSort(int[] arr){
		int temp;
		for (int i=0; i< arr.length-1; i++){
			for (int j=i+1; j< arr.length; j++){
				if (arr[i] > arr[j]){
					temp =arr[i];
					arr[i]= arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	/**
	 * An implementation of Merge Sort algorithm.
	 * @param arr: Integer array to be sorted.
	 * @return Sorted integer array.
	 */
	private static int[] mergeSort(int[] arr){
		// The function is called recursively. The base case occurs when arr.length is 1.
		if (arr.length == 1){
			return arr;
		} else{
			// get the mid-point of input array
			int mid = arr.length/2;

			// create two sub-arrays and call mergeSort on them
			int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
			int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

			// combine both arrays selecting the lowest element from either of them on each for loop iteration
			int[] combined = new int[left.length+right.length];
			int i =0;
			int j=0;
			for (int k=0; k < combined.length; k++){
				if (i == left.length){
					combined[k] = right[j];
					j++;
				}else if(j== right.length){
					combined[k] = left[i];
					i++;
				} else if (left[i] <= right[j]){
					combined[k] = left[i];
					i++;
				} else{
					combined[k] = right[j];
					j++;
				}
			}
			return combined;
		}
		
		
		
	}
}
