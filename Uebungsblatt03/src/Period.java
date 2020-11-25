public class Period {
    int minutes;

    public Period(int m) {
        minutes = m;
    }

    public Period (int m, int h) {
        minutes = m + h * 60;
    }

    private int getMinutes() {
        return minutes;
    }

    private int getHours() {
        return minutes / 60;
    }

    private int getMinorMinutes() {
        return minutes % 60;
    }

    private String timeToString() {
        return getHours() + ":" + getMinorMinutes();
    }

    private Period clonePeriod() {
        return this;
    }

    private void change(int m) {
        if(m > 0) {
            minutes += m;
        }
    }

    public static void main(String[] args) {
        Period firstPeriod = new Period(1270);
        System.out.println(firstPeriod.timeToString());
        firstPeriod.change(90);
        System.out.println(firstPeriod.timeToString());
        Period secondPeriod = new Period(30, 4);
        Period thirdPeriod = secondPeriod.clonePeriod();
        System.out.println(thirdPeriod.timeToString());
    }
}
