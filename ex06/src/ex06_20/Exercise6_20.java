package ex06_20;

import java.util.Arrays;

public class Exercise6_20 {

	public static int[] shuffle(int[] original) {

		if (original != null) {

			for (int index = 0; index < original.length * 2; index++) {

				int changeTarget = (int) (Math.random() * original.length);

				int temp = 0;

				temp = original[0];
				original[0] = original[changeTarget];
				original[changeTarget] = temp;
			}

		}
		return original;
	}

	public static void main(String[] args) {
		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(Arrays.toString(original));
		int[] result = shuffle(original);
		System.out.println(Arrays.toString(result));
	}
}







