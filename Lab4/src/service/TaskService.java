package service;

public class TaskService {

    public void fillArrays() {
        int[] evenNumbers = new int[50];
        int value = 2;
        for (int i = 0; i < evenNumbers.length; i++) {
            evenNumbers[i] = value;
            value += 2;
        }

        int[] oddNumbers = new int[50];
        value = 1;
        for (int i = 0; i < oddNumbers.length; i++) {
            oddNumbers[i] = value;
            value += 2;
        }

        System.out.println("Парні числа:");
        for (int n : evenNumbers) {
            System.out.print(n + " ");
        }

        System.out.println("\nНепарні числа:");
        for (int n : oddNumbers) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public void arrayOperations() {
        int[] arr = { 2, 17, 13, 6, 22, 31, 45, 66, 100, -18 };

        System.out.println("While — всі елементи:");
        int i = 0;
        while (i < arr.length) {
            System.out.print(arr[i] + " ");
            i++;
        }

        System.out.println("\nFor — всі елементи:");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }

        System.out.println("\nWhile — непарні індекси:");
        int k = 1;
        while (k < arr.length) {
            System.out.print(arr[k] + " ");
            k += 2;
        }

        System.out.println("\nFor — парні індекси:");
        for (int j = 0; j < arr.length; j += 2) {
            System.out.print(arr[j] + " ");
        }

        System.out.println("\nМасив у зворотньому порядку:");
        for (int j = arr.length - 1; j >= 0; j--) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
    }

    public double sumOfArray(double[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("Сума елементів масиву: " + sum);
        return sum;
    }

    public void negateOddElements(double[] arr) {
        System.out.println("До зміни:");
        for (double v : arr)
            System.out.print(v + " ");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                arr[i] = -arr[i];
            }
        }

        System.out.println("\nПісля зміни знаку непарних елементів:");
        for (double v : arr)
            System.out.print(v + " ");
        System.out.println();
    }
}
