public final class SpringModel {
    private SpringModel() {}

    // Hooke's law: F = k * x
    public static double force(double stiffnessNPerM, double compressionM) {
        return stiffnessNPerM * compressionM;
    }

    public static double stiffness(double forceN, double compressionM) {
        if (compressionM == 0.0) {
            throw new IllegalArgumentException("x має бути ненульовим для обчислення k");
        }
        return forceN / compressionM;
    }

    public static double compression(double forceN, double stiffnessNPerM) {
        if (stiffnessNPerM == 0.0) {
            throw new IllegalArgumentException("k має бути ненульовим для обчислення x");
        }
        return forceN / stiffnessNPerM;
    }
}
