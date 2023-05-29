import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Triangle extends Polygon {
    public Triangle(Point p1, Point p2, Point p3) {
        super(List.of(p1,p2,p3));

    }
    @Override
    public double area() {
        Iterator<Line> it = super.lineIterator();
        double lato1 =it.next().lenght();
        double lato2=it.next().lenght();
        double lato3=it.next().lenght();
        double s = (lato1 + lato2 + lato3) / 2; // Calcolo del semiperimetro
        return Math.sqrt(s * (s - lato1) * (s - lato2) * (s - lato3));
    }
}
