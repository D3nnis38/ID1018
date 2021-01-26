public class Punkt {
    private String namn;
    private int x;
    private int y;

    public Punkt(String namn, int x, int y) {
        this.namn = namn;
        this.x = x;
        this.y = y;
    }

    public Punkt(Punkt annan) {
        this.namn = annan.getNamn();
        this.x = annan.getX();
        this.y = annan.getY();
    }

    public String getNamn() {
        return namn;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int newCoord) {
        this.x = newCoord;
    }

    public void setY(int newCoord) {
        this.y = newCoord;
    }

    public double avstand(Punkt second) {
        return Math.sqrt(Math.pow((this.x - second.getX()), 2) + Math.pow((this.y - second.getY()), 2));
    }

    public boolean equals(Punkt andra) {
        boolean equal;
        equal = this.x == andra.getX() && this.y == andra.getY() && this.namn.equals(andra.getNamn());
        return equal;
    }

    public String toString() {
        return "(" + this.namn + " " + this.x + " " + this.y + ")";
    }
}
