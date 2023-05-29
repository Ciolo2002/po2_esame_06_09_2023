import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Rectangle extends Polygon {
    public Rectangle(Point p1, Point p3) {
        super(List.of(p1, new Point(p1.getX(), p3.getY()), p3, new Point(p3.getX(), p1.getY())));
    }

    @Override
    public double area() {
        Iterator<Line> it = super.lineIterator();
        return it.next().lenght() * it.next().lenght();
    }

    public static <E> E max(Collection<? extends Polygon> c, Comparator<Polygon> cmp) {
        E x = null;
        for (Iterator it = c.iterator(); it.hasNext(); it.next()) {
            if (it.hasNext()) {
                Polygon next = (Polygon) it.next();
                int comp = cmp.compare((Polygon) it, next);
                if (comp >= 0) {
                    x= (E) it;
                }else if(comp<0){
                    x=(E) next;
                }
            }
        }
        return x;
    }

    public static void main(String[] args) {
        Square sq1 = new Square(new Point(10., -4.), 0.1),
                sq2 = new Square(new Point(1., 20.), 0.01);
        Collection<Square> squares = List.of(sq1, sq2);
        Rectangle r = max(squares, new Comparator<Polygon>() {
            @Override
            public int compare(Polygon a, Polygon b) {
                return (int) (a.area() - b.area());
            }
        });
    }
}
