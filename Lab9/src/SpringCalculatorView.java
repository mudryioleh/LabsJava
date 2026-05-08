import javax.swing.*;
import java.awt.*;

public class SpringCalculatorView extends JFrame {
    private final JTextField stiffnessField;   // k
    private final JTextField compressionField; // x
    private final JTextField forceField;       // F

    private final JButton calculateButton;
    private final JLabel statusLabel;

    public SpringCalculatorView() {
        super("Лабораторна 9 — Закон Гука (пружина)");

        stiffnessField = new JTextField(12);
        compressionField = new JTextField(12);
        forceField = new JTextField(12);

        calculateButton = new JButton("Обчислити");
        statusLabel = new JLabel(" ");

        initLayout();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(560, 240));
        setLocationRelativeTo(null);
    }

    private void initLayout() {
        JPanel content = new JPanel(new GridBagLayout());
        content.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;

        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        content.add(new JLabel("Жорсткість k (Н/м):"), c);

        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1.0;
        content.add(stiffnessField, c);

        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0;
        content.add(new JLabel("Стиснення x (м):"), c);

        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1.0;
        content.add(compressionField, c);

        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0;
        content.add(new JLabel("Сила F (Н):"), c);

        c.gridx = 1;
        c.gridy = 2;
        c.weightx = 1.0;
        content.add(forceField, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.weightx = 0;
        c.anchor = GridBagConstraints.LINE_START;
        content.add(calculateButton, c);

        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        c.weightx = 1.0;
        content.add(statusLabel, c);

        setContentPane(content);
    }

    public JTextField getStiffnessField() {
        return stiffnessField;
    }

    public JTextField getCompressionField() {
        return compressionField;
    }

    public JTextField getForceField() {
        return forceField;
    }

    public JButton getCalculateButton() {
        return calculateButton;
    }

    public void setStatus(String text) {
        statusLabel.setText(text == null || text.isBlank() ? " " : text);
    }
}
