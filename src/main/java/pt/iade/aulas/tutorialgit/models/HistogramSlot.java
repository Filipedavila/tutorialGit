package pt.iade.aulas.tutorialgit.models;

public class HistogramSlot {
    private double start;
    public double end;
    public int value;
    public HistogramSlot(double start, double end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public double getEnd() {
        return end;
    }

    public void setEnd(double end) {
        this.end = end;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    @Override
    public String toString(){
        StringBuilder build = new StringBuilder();
        build.append("[");
        build.append(" Start : ");
        build.append(this.getStart());
        build.append(" End : ");
        build.append(this.getEnd());
        build.append(" Value : ");
        build.append(this.getValue());
        build.append("]");
        return build.toString();
    }
}
