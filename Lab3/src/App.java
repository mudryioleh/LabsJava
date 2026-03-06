import servece.TaskService;

public class App {
    public static void main(String[] args) throws Exception {
        TaskService taskService = new TaskService();

        taskService.printWithFor();
        taskService.printWithWhile();
        taskService.printHoursFor();
        taskService.printHoursWhile();
        taskService.printHoursMinutesSeconds();
        taskService.tabulateWithFor(1, 2);
        taskService.tabulateWithWhile(1, 2);
    }
}
