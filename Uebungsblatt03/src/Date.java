public class Date {
    private final String title;
    private PointInTime pit;
    private Period p;

    public Date(String t, PointInTime point, Period period) {
        title = t;
        pit = point;
        p = period;
    }

    public Date clone() {
        return new Date(title, pit, p);
    }

    public Period getPeriod() {
        return p;
    }

    public PointInTime getPointInTime() {
        return pit;
    }

    public String getTitle() {
        return title;
    }

    public void set(PointInTime point, Period period) {
        pit = point;
        p = period;
    }

    public void change(int hours) {
        pit.change(hours);
    }

    public String toString() {
        return "Your Date: " + title + " starts at " + pit.toString() + " and lasts " + p.toString() + ".";
    }
}
