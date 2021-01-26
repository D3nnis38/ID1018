public class PolylineTest {

    public static void main(String[] args) {
        Polyline polylinje = null;
        Polyline polylinje2 = null;
        polylinje = new NPolyline(); // (1)
        polylinje2 = new VPolyline (); // (2)
        System.out.println(polylinje);

        polylinje2.add(new Point("A", 3, 4));
        polylinje2.add(new Point("B", 5, 1));
        polylinje2.add(new Point("C", 8, 12));
        polylinje2.add(new Point("Z", 2, 2));
        polylinje2.add(new Point("E", 14, 23));

        polylinje.add(new Point("A", 2, 4));
        polylinje.add(new Point("B", 6, 1));
        polylinje.add(new Point("C", 8, 12));
        polylinje.add(new Point("Z", 4, 2));
        polylinje.add(new Point("E", 14, 23));

        System.out.println(polylinje);

        System.out.println(polylinje.length());
        System.out.println(polylinje2.length());

        polylinje.remove("Z");
        polylinje.insertBefore(new Point("D", 5, 4), "E");

        polylinje.setColor("gul");

        System.out.println(polylinje);

        for (Point horn : polylinje)
            System.out.println(horn);

        System.out.println(Polylines.shortestYellow(new Polyline[]{polylinje, polylinje2}));

    }

}