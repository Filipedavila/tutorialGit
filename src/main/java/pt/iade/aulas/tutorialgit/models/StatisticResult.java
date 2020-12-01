package pt.iade.aulas.tutorialgit.models;

public class StatisticResult {
    double max;
    double min;
    double average;
    double range;

    public StatisticResult(double max, double min, double average, double range) {
        this.max = max;
        this.min = min;
        this.average = average;
        this.range = range;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }
}
