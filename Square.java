public class Square extends Rectangle {
    public Square(Point p1, double side) {
        super(p1,new Point(p1.getX()+side, p1.getY()+side));
    }
}
