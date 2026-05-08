public class App {
    public static void main(String[] args) throws Exception {
        javax.swing.SwingUtilities.invokeLater(() -> {
            SpringCalculatorView view = new SpringCalculatorView();
            new SpringCalculatorController(view);
            view.setVisible(true);
        });
    }
}
