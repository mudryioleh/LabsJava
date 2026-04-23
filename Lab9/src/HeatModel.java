public final class HeatModel {
    private HeatModel() {}

    // Q = c * m * Δt
    public static double heat(double specificHeat, double massKg, double deltaC) {
        return specificHeat * massKg * deltaC;
    }

    public static double massKg(double specificHeat, double heatJ, double deltaC) {
        if (specificHeat == 0.0 || deltaC == 0.0) {
            throw new IllegalArgumentException("c та Δt мають бути ненульові для обчислення m");
        }
        return heatJ / (specificHeat * deltaC);
    }

    public static double deltaC(double specificHeat, double heatJ, double massKg) {
        if (specificHeat == 0.0 || massKg == 0.0) {
            throw new IllegalArgumentException("c та m мають бути ненульові для обчислення Δt");
        }
        return heatJ / (specificHeat * massKg);
    }
}
