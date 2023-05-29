import java.util.Iterator;
import java.util.List;

public abstract class Polygon  {
    protected final List<Point> points;
    protected Polygon(List<Point> points) {
        assert points.size() >= 3;
        this.points = points;
    }
    public Iterator<Line> lineIterator() {
        return new Iterator<Line>() {
            private int current=0;
            @Override
            public boolean hasNext() {
                return current<points.size();
            }
            @Override
            public Line next() {
                if(this.hasNext()){
                    return new Line(points.get(current), points.get(++current));
                }
                return null;
            }
        };
    }
    public double perimeter() {
        double x=0;
        for (Iterator<Line> it = lineIterator(); it.hasNext(); ) {
            Line l = it.next();
            x+= l.lenght();
        }
        return x;
    }
    public abstract double area();
}
