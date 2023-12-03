package Day3;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Part {
    Point startPoint;
    int length;
    int value;
    boolean isAPart;

    List<Point> coordinates = new ArrayList<>();

    public Part(Point startPoint, int length, int value) {
        this.startPoint = startPoint;
        this.length = length;
        this.value = value;
        for(int x=0;x<length;x++){
            coordinates.add(new Point(startPoint.x+x,startPoint.y));
        }
    }
}
