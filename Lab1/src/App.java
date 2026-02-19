import services.TaskService;

public class App {
    public static void main(String[] args) throws Exception {
        TaskService service = new TaskService();

        service.solveTask1();
        service.solveTask2();
        service.solveTask3();
        service.solveTask4();
        service.solveTask5();
    }
}
