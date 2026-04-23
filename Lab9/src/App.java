public class App {
    public static void main(String[] args) throws Exception {
        javax.swing.SwingUtilities.invokeLater(() -> {
            HeatCalculatorView view = new HeatCalculatorView();
            new HeatCalculatorController(view);
            view.setVisible(true);
        });
    }
}
