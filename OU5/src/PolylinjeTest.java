import java.util.Scanner;

public class PolylinjeTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Punkt p1 = new Punkt("A", 3, 4);
        Punkt p2 = new Punkt("B", 5, 6);
        Punkt p3 = new Punkt("C", 8, 2);
        Punkt p4 = new Punkt("D", 4, 1);
        Punkt p5 = new Punkt("E", 7, 9);
        System.out.println(p1 + " " + p2 + " " + p3);
        System.out.println();

        Punkt[] punktVektor = {p1, p2, p3};
        Polylinje pol1 = new Polylinje(punktVektor);

        System.out.println("Färgen är: " + pol1.getFarg());
        System.out.println("Skriv in den nya färgen: ");
        pol1.setFarg(in.next());
        System.out.println("Färgen är: " + pol1.getFarg());
        System.out.println();

        System.out.println("Bredden är: " + pol1.getBredd());
        System.out.print("Skriv in den nya bredden: ");
        pol1.setBredd(in.nextInt());
        System.out.println("Bredden är: " + pol1.getBredd());
        System.out.println();

        System.out.println("Polylinje längd är: " + pol1.langd());
        System.out.println();

        System.out.println("Lägger till punkt D på slutet");
        pol1.laggTill(p4);
        System.out.println(pol1);
        System.out.println();

        System.out.println("Lägger till punkt E innan C");
        pol1.laggTillFramfor(p5, "C");
        System.out.println(pol1);
        System.out.println();

        System.out.println("Tar bort punkt B");
        pol1.taBort("B");
        System.out.println(pol1);
        System.out.println();

        Polylinje.PolylinjeIterator polyIterator = pol1.new PolylinjeIterator();
        System.out.println("Skriver ut punkterna i polylinjen från PolylinjeIterator: ");
        while(polyIterator.finnsHorn()){
            System.out.println(polyIterator.horn());
            polyIterator.gaFram();
        }
    }
}
