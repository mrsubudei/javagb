package javacore.lesson7;

public class Temperature {
    Minimum MinimumObject;
    Maximum MaximumObject;

    // Getter Methods

    public Minimum getMinimum() {
        return MinimumObject;
    }

    public Maximum getMaximum() {
        return MaximumObject;
    }

    // Setter Methods

    public void setMinimum(Minimum MinimumObject) {
        this.MinimumObject = MinimumObject;
    }

    public void setMaximum(Maximum MaximumObject) {
        this.MaximumObject = MaximumObject;
    }
}
