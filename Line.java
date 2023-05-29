public class Line<T extends Point> {

    private final T start,end;

    public Line(T start, T end){
        this.start=start;
        this.end=end;
    }

    public double lenght(){
        return Math.sqrt(Math.pow(start.getX()-end.getX(),2)+Math.pow(start.getY()- end.getY(),2));
    }
}
