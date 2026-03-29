package servece;

public class TaskService {
    public double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public double printAndReturnSmallest(double first, double second, double third) {
        double smallest = Math.min(first, Math.min(second, third));
        System.out.println("Найменше число: " + smallest);
        return smallest;
    }

    public void printArray(int[] array) {
        System.out.print("Масив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public int findMaximum(int[] array) {
        int maximum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maximum) {
                maximum = array[i];
            }
        }

        return maximum;
    }
}
