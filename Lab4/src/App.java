import service.TaskService;

public class App {
    public static void main(String[] args) throws Exception {
        double[] arr = { 2, 17, 13, 6, 22, 31, 45, 66, 100, -18 };

        TaskService taskService = new TaskService();

        taskService.fillArrays();
        taskService.arrayOperations();

        taskService.sumOfArray(arr);
        taskService.negateOddElements(arr);
    }
}
