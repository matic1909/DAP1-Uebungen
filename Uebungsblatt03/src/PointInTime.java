public class PointInTime {
    int year;
    int day;
    int hour;

    public PointInTime(int y, int d, int h) {
        if(y > 9999 || y < 1000 || d < 1 || d > 365 || h < 0 || h > 23 ) {
            throw new IllegalArgumentException();
        } else {
            year = y;
            day = d;
            hour = h;
        }
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return year + "/" + "day" + "/" + hour;
    }

    public PointInTime clone() {
        return new PointInTime(year, day, hour);
    }

    public void change(int h) {
        if(h > 0) {
            hour += h;
            if(hour > 23) {
                day += hour / 24;
                hour = hour % 24;
            }
        }
    }
}
