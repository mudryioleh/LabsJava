import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SpringCalculatorController {
    private enum Variable {
        STIFFNESS,  // k
        COMPRESSION, // x
        FORCE       // F
    }

    private final SpringCalculatorView view;

    public SpringCalculatorController(SpringCalculatorView view) {
        this.view = view;
        wire();
        refreshLockingState();
    }

    private void wire() {
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

        view.getStiffnessField().getDocument().addDocumentListener(dl);
        view.getCompressionField().getDocument().addDocumentListener(dl);
        view.getForceField().getDocument().addDocumentListener(dl);

        view.getCalculateButton().addActionListener(e -> calculate());
    }

    private void onInputChanged() {
        refreshLockingState();
    }

    private void refreshLockingState() {
        Double stiffness = tryParse(view.getStiffnessField().getText());
        Double compression = tryParse(view.getCompressionField().getText());
        Double force = tryParse(view.getForceField().getText());

        boolean hasK = stiffness != null && stiffness > 0.0;
        boolean hasX = compression != null && compression > 0.0;
        boolean hasF = force != null && force > 0.0;

        Variable locked = getLockedVariable();

        // Keep previously locked output field locked if the other two inputs are still valid.
        if (locked != null) {
            boolean canKeepLocked = switch (locked) {
                case STIFFNESS -> hasX && hasF;
                case COMPRESSION -> hasK && hasF;
                case FORCE -> hasK && hasX;
            };
            if (canKeepLocked) {
                lockOnly(locked);
                view.setStatus(statusForLocked(locked));
                return;
            }
        }

        if (hasK && hasX && !hasF) {
            lockOnly(Variable.FORCE);
            view.setStatus("Готово: обчислюватимемо F");
        } else if (hasK && hasF && !hasX) {
            lockOnly(Variable.COMPRESSION);
            view.setStatus("Готово: обчислюватимемо x");
        } else if (hasX && hasF && !hasK) {
            lockOnly(Variable.STIFFNESS);
            view.setStatus("Готово: обчислюватимемо k");
        } else {
            unlockAll();
            if ((hasK ? 1 : 0) + (hasX ? 1 : 0) + (hasF ? 1 : 0) >= 3) {
                view.setStatus("Очистіть одне поле, щоб розв’язати обернену задачу");
            } else {
                view.setStatus("Введіть будь-які 2 з 3 значень: k, x або F");
            }
        }
    }

    private static String statusForLocked(Variable locked) {
        return switch (locked) {
            case FORCE -> "Готово: обчислюватимемо F";
            case COMPRESSION -> "Готово: обчислюватимемо x";
            case STIFFNESS -> "Готово: обчислюватимемо k";
        };
    }

    private Variable getLockedVariable() {
        if (!view.getStiffnessField().isEnabled()) {
            return Variable.STIFFNESS;
        }
        if (!view.getCompressionField().isEnabled()) {
            return Variable.COMPRESSION;
        }
        if (!view.getForceField().isEnabled()) {
            return Variable.FORCE;
        }
        return null;
    }

    private void lockOnly(Variable variable) {
        view.getStiffnessField().setEnabled(variable != Variable.STIFFNESS);
        view.getCompressionField().setEnabled(variable != Variable.COMPRESSION);
        view.getForceField().setEnabled(variable != Variable.FORCE);
    }

    private void unlockAll() {
        view.getStiffnessField().setEnabled(true);
        view.getCompressionField().setEnabled(true);
        view.getForceField().setEnabled(true);
    }

    private void calculate() {
        Double k = tryParse(view.getStiffnessField().getText());
        Double x = tryParse(view.getCompressionField().getText());
        Double f = tryParse(view.getForceField().getText());

        Variable locked = getLockedVariable();

        if (locked == null) {
            int count = (k != null ? 1 : 0) + (x != null ? 1 : 0) + (f != null ? 1 : 0);
            if (count != 2) {
                JOptionPane.showMessageDialog(view, "Потрібно заповнити рівно 2 поля з 3: k, x, F", "Підказка", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        try {
            if (locked == Variable.FORCE || (locked == null && f == null)) {
                validateKAndX(k, x);
                double result = SpringModel.force(k, x);
                view.getForceField().setText(format(result));
                view.setStatus("Результат: F обчислено");
            } else if (locked == Variable.COMPRESSION || (locked == null && x == null)) {
                validateKAndF(k, f);
                double result = SpringModel.compression(f, k);
                view.getCompressionField().setText(format(result));
                view.setStatus("Результат: x обчислено");
            } else {
                validateXAndF(x, f);
                double result = SpringModel.stiffness(f, x);
                view.getStiffnessField().setText(format(result));
                view.setStatus("Результат: k обчислено");
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Помилка", JOptionPane.ERROR_MESSAGE);
        }

        refreshLockingState();
    }

    private void validateKAndX(Double k, Double x) {
        if (k == null || x == null) {
            throw new IllegalArgumentException("Заповніть k та x");
        }
        if (k <= 0.0) {
            throw new IllegalArgumentException("k має бути > 0");
        }
        if (x <= 0.0) {
            throw new IllegalArgumentException("x має бути > 0");
        }
    }

    private void validateKAndF(Double k, Double f) {
        if (k == null || f == null) {
            throw new IllegalArgumentException("Заповніть k та F");
        }
        if (k <= 0.0) {
            throw new IllegalArgumentException("k має бути > 0");
        }
        if (f <= 0.0) {
            throw new IllegalArgumentException("F має бути > 0");
        }
    }

    private void validateXAndF(Double x, Double f) {
        if (x == null || f == null) {
            throw new IllegalArgumentException("Заповніть x та F");
        }
        if (x <= 0.0) {
            throw new IllegalArgumentException("x має бути > 0");
        }
        if (f <= 0.0) {
            throw new IllegalArgumentException("F має бути > 0");
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
        return String.format("%.6g", value);
    }
}
