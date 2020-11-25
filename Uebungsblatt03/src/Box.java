public class Box {
    double width;
    double height;
    double depth;

    public Box( double w, double h, double d ) {
        width = w;
        height = h;
        depth = d;
    }

    private double getWidth() {
        return width;
    }

    private double getHeight() {
        return height;
    }

    private double getDepth() {
        return depth;
    }

    private double getVolumeSize() {
        return width*height*depth;
    }

    private double getAreaSize() {
        return 2*width*height + 2*height*depth + 2*width*depth;
    }

    private double getEdgesLength() {
        return 4*height + 4*depth + 4*width;
    }

    private boolean isCube() {
        return (width == height && width == depth);
    }

    private int compareTo( Box f ) {
        if(this.getVolumeSize() > f.getVolumeSize()) return 1;
        if(this.getVolumeSize() == f.getVolumeSize()) return 0;
        return -1;
    }

    private boolean encloses( Box f ) {
        return this.width > f.getWidth() && this.depth > f.getDepth() && this.height > f.getHeight();
    }

    public static void main(String[] args) {
        Box firstBox = new Box(12,12,12);
        Box secondBox = new Box(10, 8, 11);
        System.out.println(firstBox.isCube());
        System.out.println(secondBox.isCube());
        System.out.println(secondBox.encloses(firstBox));
        System.out.println(firstBox.compareTo(secondBox));
    }
}
