import java.util.Scanner;

import services.LogicTaskService;
import services.MathTaskService;
import services.SwitchTaskService;

import services.InputHelper;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        MathTaskService mathTaskService = new MathTaskService();
        LogicTaskService logicTaskService = new LogicTaskService();
        SwitchTaskService switchService = new SwitchTaskService();

        mathTaskService.solveQuadraticEquation(1, -3, 2);
        logicTaskService.findQuadrant(-2, 3);
        logicTaskService.checkNumber(24);

        int day = InputHelper.readInt(scanner, "\n Ведіть день (1, 2, 3): ");
        switchService.checkDayType(day);

        int month = InputHelper.readInt(scanner, "\n Ведіть місяць (1-12): ");
        switchService.checkMonthType(month);

        switchService.textMenu();

        int pairNumber = InputHelper.readInt(scanner, "\n Ведіть номер пари (1-4): ");
        switchService.getSubject(pairNumber);

        int min = InputHelper.readInt(scanner, "\n Ведіть хвилини (0-59): ");
        switchService.getQuarterOfHour(min);

        double x = InputHelper.readDouble(scanner, "\nВведіть x для обчислення f(x): ");
        mathTaskService.calculateFactorial(x);

        switchService.runMathMenu(scanner);

        scanner.close();
    }
}
