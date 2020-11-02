package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double t1, t2;
    private boolean t1In, t2In;

    public Interval(double t1, double t2, boolean t1In, boolean t2In) throws IllegalArgumentException {
        if (t1 > t2) throw new IllegalArgumentException("Krajnja tacka veca od pocetne");
        this.t1 = t1;
        this.t2 = t2;
        this.t1In = t1In;
        this.t2In = t2In;
    }

    public Interval() {
        t1 = 0;
        t2 = 0;
        t1In = false;
        t2In = false;
    }

    public boolean isNull() {
        return t1 == 0 && t2 == 0 && !t1In && !t2In;
    }

    public boolean isIn(double t) {
        return (t1In && t >= t1 && t2In && t <= t2) || (t1In && t >= t1 && t < t2) || (t > t1 && t2In && t <= t2) || (t > t1 && t < t2);
    }

    public static Interval intersect(Interval i1, Interval i2) {
        Interval i = new Interval();
        if (i2.t1 > i1.t2 || i1.t1 > i2.t2) return i;
        if (i1.t1 >= i2.t1) {
            i.t1 = i1.t1;
            i.t1In = i1.t1In;
        } else {
            i.t1 = i2.t1;
            i.t1In = i2.t1In;
        }
        if (i1.t2 <= i2.t2) {
            i.t2 = i1.t2;
            i.t2In = i1.t2In;
        } else {
            i.t2 = i2.t2;
            i.t2In = i2.t2In;
        }
        return i;
    }

    public Interval intersect(Interval i1) {
        Interval i = new Interval();
        if (t1 > i1.t2 || i1.t1 > t2) return i;
        if (i1.t1 >= t1) {
            i.t1 = i1.t1;
            i.t1In = i1.t1In;
        } else {
            i.t1 = t1;
            i.t1In = t1In;
        }
        if (i1.t2 <= t2) {
            i.t2 = i1.t2;
            i.t2In = i1.t2In;
        } else {
            i.t2 = t2;
            i.t2In = t2In;
        }
        return i;
    }
    @Override
    public String toString(){
        if(isNull())
            return "()";
        if(t1In && t2In){
            return "[" + t1 + "," + t2 + "]";
        }
        if(t1In){
            return "[" + t1 + "," + t2 + ")";
        }
        if(t2In){
            return "(" + t1 + "," + t2 + "]";
        }
        else
            return "(" + t1 + "," + t2 + ")";
    }
    @Override
    public boolean equals(Object o){
        if(o==this)
            return true;
        if(!(o instanceof Interval))
            return false;
        Interval i = (Interval) o;
        if(i.t1==t1 && i.t2==t2 && i.t1In==t1In && i.t2In==t2In)return true;
        return false;
    }
}
