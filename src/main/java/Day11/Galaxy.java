package Day11;

import java.awt.*;

public class Galaxy {
    Point originalPosition;
    Point expandedPosition;

    public int distanceTo(Galaxy g){
        return Math.abs(g.expandedPosition.x-this.expandedPosition.x)+Math.abs(g.expandedPosition.y-this.expandedPosition.y);
    }

    public Galaxy(int x, int y){
        this.originalPosition = new Point(x,y);
        this.expandedPosition = new Point(x,y) ;
    }
}
