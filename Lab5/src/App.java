import servece.TaskService;

public class App {
    public static void main(String[] args) throws Exception {
        TaskService taskService = new TaskService();

        double area = taskService.calculateCircleArea(2);
        System.out.println("Circle area: " + area);

        double smallest = taskService.printAndReturnSmallest(5, 3, 8);
        System.out.println("Returned smallest: " + smallest);

        int[] array = { 1, 2, 10, 4, 5 };
        taskService.printArray(array);

        int max = taskService.findMaximum(array);
        System.out.println("Найбільше число масиву: " + max);
    }
}
