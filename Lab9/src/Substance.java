public enum Substance {
    WATER("Вода", 4200.0),
    ALUMINUM("Алюміній", 900.0),
    COPPER("Мідь", 385.0),
    IRON("Залізо", 460.0),
    LEAD("Свинець", 130.0);

    private final String displayName;
    private final double specificHeat; // J/(kg·°C)

    Substance(String displayName, double specificHeat) {
        this.displayName = displayName;
        this.specificHeat = specificHeat;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getSpecificHeat() {
        return specificHeat;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
