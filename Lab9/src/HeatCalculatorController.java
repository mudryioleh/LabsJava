import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class HeatCalculatorController {
    private enum Variable {
        MASS,
        DELTA,
        HEAT
    }

    private final HeatCalculatorView view;

    public HeatCalculatorController(HeatCalculatorView view) {
        this.view = view;
        wire();
        refreshSpecificHeatLabel();
        refreshLockingState();
    }

    private void wire() {
        view.getSubstanceCombo().addActionListener(e -> {
            refreshSpecificHeatLabel();
            refreshLockingState();
            view.setStatus(" ");
        });

        DocumentListener dl = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                onInputChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                onInputChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                onInputChanged();
            }
        };

        view.getMassField().getDocument().addDocumentListener(dl);
        view.getDeltaField().getDocument().addDocumentListener(dl);
        view.getHeatField().getDocument().addDocumentListener(dl);

        view.getCalculateButton().addActionListener(e -> calculate());
    }

    private void onInputChanged() {
        refreshLockingState();
        view.setStatus(" ");
    }

    private void refreshSpecificHeatLabel() {
        Substance substance = (Substance) view.getSubstanceCombo().getSelectedItem();
        if (substance == null) {
            view.getSpecificHeatLabel().setText("c = —");
            return;
        }
        view.getSpecificHeatLabel().setText(String.format("c = %.0f Дж/(кг·°C)", substance.getSpecificHeat()));
    }

    private void refreshLockingState() {
        Double mass = tryParse(view.getMassField().getText());
        Double delta = tryParse(view.getDeltaField().getText());
        Double heat = tryParse(view.getHeatField().getText());

        boolean hasMass = mass != null && mass > 0.0;
        boolean hasDelta = delta != null && delta > 0.0;
        boolean hasHeat = heat != null && heat > 0.0;

        Variable locked = getLockedVariable();

        // If one field is already locked (output), keep it locked as long as
        // the other two inputs are present and valid.
        if (locked != null) {
            boolean canKeepLocked = switch (locked) {
                case MASS -> hasDelta && hasHeat;
                case DELTA -> hasMass && hasHeat;
                case HEAT -> hasMass && hasDelta;
            };
            if (canKeepLocked) {
                lockOnly(locked);
                return;
            }
        }

        // Rule from assignment: when two fields have enough data,
        // the third (empty) becomes unavailable for output.
        if (hasMass && hasDelta && !hasHeat) {
            lockOnly(Variable.HEAT);
            view.setStatus("Готово: обчислюватимемо Q");
        } else if (hasMass && hasHeat && !hasDelta) {
            lockOnly(Variable.DELTA);
            view.setStatus("Готово: обчислюватимемо Δt");
        } else if (hasDelta && hasHeat && !hasMass) {
            lockOnly(Variable.MASS);
            view.setStatus("Готово: обчислюватимемо m");
        } else {
            unlockAll();
            if ((hasMass ? 1 : 0) + (hasDelta ? 1 : 0) + (hasHeat ? 1 : 0) >= 3) {
                view.setStatus("Очистіть одне поле, щоб розв’язати обернену задачу");
            } else {
                view.setStatus("Введіть будь-які 2 з 3 значень: m, Δt або Q");
            }
        }
    }

    private Variable getLockedVariable() {
        if (!view.getMassField().isEnabled()) {
            return Variable.MASS;
        }
        if (!view.getDeltaField().isEnabled()) {
            return Variable.DELTA;
        }
        if (!view.getHeatField().isEnabled()) {
            return Variable.HEAT;
        }
        return null;
    }

    private void lockOnly(Variable variable) {
        view.getMassField().setEnabled(variable != Variable.MASS);
        view.getDeltaField().setEnabled(variable != Variable.DELTA);
        view.getHeatField().setEnabled(variable != Variable.HEAT);

        // Keep the locked field not editable (disabled) and visually clear intent.
    }

    private void unlockAll() {
        view.getMassField().setEnabled(true);
        view.getDeltaField().setEnabled(true);
        view.getHeatField().setEnabled(true);
    }

    private void calculate() {
        Substance substance = (Substance) view.getSubstanceCombo().getSelectedItem();
        if (substance == null) {
            JOptionPane.showMessageDialog(view, "Оберіть речовину", "Помилка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Double mass = tryParse(view.getMassField().getText());
        Double delta = tryParse(view.getDeltaField().getText());
        Double heat = tryParse(view.getHeatField().getText());

        Variable locked = getLockedVariable();
        if (locked == null) {
            int count = (mass != null ? 1 : 0) + (delta != null ? 1 : 0) + (heat != null ? 1 : 0);
            if (count != 2) {
                JOptionPane.showMessageDialog(view, "Потрібно заповнити рівно 2 поля з 3: m, Δt, Q", "Підказка", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        double c = substance.getSpecificHeat();

        try {
            if (locked == Variable.HEAT || (locked == null && heat == null)) {
                validateMassAndDelta(mass, delta);
                double result = HeatModel.heat(c, mass, delta);
                view.getHeatField().setText(format(result));
                view.setStatus("Результат: Q обчислено");
            } else if (locked == Variable.DELTA || (locked == null && delta == null)) {
                validateMassAndHeat(mass, heat);
                double result = HeatModel.deltaC(c, heat, mass);
                view.getDeltaField().setText(format(result));
                view.setStatus("Результат: Δt обчислено");
            } else {
                validateDeltaAndHeat(delta, heat);
                double result = HeatModel.massKg(c, heat, delta);
                view.getMassField().setText(format(result));
                view.setStatus("Результат: m обчислено");
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Помилка", JOptionPane.ERROR_MESSAGE);
        }

        refreshLockingState();
    }

    private void validateMassAndDelta(Double mass, Double delta) {
        if (mass == null || delta == null) {
            throw new IllegalArgumentException("Заповніть m та Δt");
        }
        if (mass <= 0.0) {
            throw new IllegalArgumentException("m має бути > 0");
        }
        if (delta <= 0.0) {
            throw new IllegalArgumentException("Δt має бути > 0");
        }
    }

    private void validateMassAndHeat(Double mass, Double heat) {
        if (mass == null || heat == null) {
            throw new IllegalArgumentException("Заповніть m та Q");
        }
        if (mass <= 0.0) {
            throw new IllegalArgumentException("m має бути > 0");
        }
        if (heat <= 0.0) {
            throw new IllegalArgumentException("Q має бути > 0");
        }
    }

    private void validateDeltaAndHeat(Double delta, Double heat) {
        if (delta == null || heat == null) {
            throw new IllegalArgumentException("Заповніть Δt та Q");
        }
        if (delta <= 0.0) {
            throw new IllegalArgumentException("Δt має бути > 0");
        }
        if (heat <= 0.0) {
            throw new IllegalArgumentException("Q має бути > 0");
        }
    }

    private static Double tryParse(String text) {
        if (text == null) {
            return null;
        }
        String trimmed = text.trim();
        if (trimmed.isEmpty()) {
            return null;
        }
        String normalized = trimmed.replace(',', '.');
        try {
            double value = Double.parseDouble(normalized);
            if (Double.isNaN(value) || Double.isInfinite(value)) {
                return null;
            }
            return value;
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    private static String format(double value) {
        // Show up to 6 significant digits in a human-friendly way
        return String.format("%.6g", value);
    }
}
