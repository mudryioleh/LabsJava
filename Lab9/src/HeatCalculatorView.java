import javax.swing.*;
import java.awt.*;

public class HeatCalculatorView extends JFrame {
    private final JComboBox<Substance> substanceCombo;
    private final JLabel specificHeatLabel;

    private final JTextField massField;
    private final JTextField deltaField;
    private final JTextField heatField;

    private final JButton calculateButton;
    private final JLabel statusLabel;

    public HeatCalculatorView() {
        super("Лабораторна 9 — Кількість теплоти");

        substanceCombo = new JComboBox<>(Substance.values());
        specificHeatLabel = new JLabel();

        massField = new JTextField(12);
        deltaField = new JTextField(12);
        heatField = new JTextField(12);

        calculateButton = new JButton("Обчислити");
        statusLabel = new JLabel(" ");

        initLayout();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(520, 260));
        setLocationRelativeTo(null);
    }

    private void initLayout() {
        JPanel content = new JPanel(new GridBagLayout());
        content.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;

        // Row 0: substance
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        content.add(new JLabel("Речовина:"), c);

        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1.0;
        content.add(substanceCombo, c);

        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0;
        content.add(specificHeatLabel, c);

        // Row 1: mass
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0;
        content.add(new JLabel("Маса m (кг):"), c);

        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1.0;
        content.add(massField, c);

        // Row 2: delta
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0;
        content.add(new JLabel("Підвищення температури Δt (°C):"), c);

        c.gridx = 1;
        c.gridy = 2;
        c.weightx = 1.0;
        content.add(deltaField, c);

        // Row 3: heat
        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 0;
        content.add(new JLabel("Кількість теплоти Q (Дж):"), c);

        c.gridx = 1;
        c.gridy = 3;
        c.weightx = 1.0;
        content.add(heatField, c);

        // Row 4: button
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        c.weightx = 0;
        c.anchor = GridBagConstraints.LINE_START;
        content.add(calculateButton, c);

        // Row 5: status
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 3;
        c.weightx = 1.0;
        content.add(statusLabel, c);

        setContentPane(content);
    }

    public JComboBox<Substance> getSubstanceCombo() {
        return substanceCombo;
    }

    public JLabel getSpecificHeatLabel() {
        return specificHeatLabel;
    }

    public JTextField getMassField() {
        return massField;
    }

    public JTextField getDeltaField() {
        return deltaField;
    }

    public JTextField getHeatField() {
        return heatField;
    }

    public JButton getCalculateButton() {
        return calculateButton;
    }

    public void setStatus(String text) {
        statusLabel.setText(text == null || text.isBlank() ? " " : text);
    }
}
