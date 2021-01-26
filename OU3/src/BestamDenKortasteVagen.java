import java.util.Scanner;

public class BestamDenKortasteVagen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Läser in stationerna i mellanstationerna
        System.out.print("Antalet stationer i zon 2 (Z2): ");
        int numZ2 = scan.nextInt();
        System.out.println();
        System.out.print("Antalet stationer i zon 3 (Z3): ");
        int numZ3 = scan.nextInt();
        System.out.println();

        // Gör listor för alla sträckor
        double[] a = new double[numZ2 + 1];
        double[][] b = new double[numZ2 + 1][numZ3 + 1];
        double[] c = new double[numZ3 + 1];


        // Lägg in sträckorna på rätt plats
        System.out.println("Skriv in längderna mellan nedstående stationerd,");
        for (int i = 1; i <= numZ2; i++) {
            System.out.println("X - U" + i + ": ");
            a[i] = scan.nextDouble();
        }
        for (int i = 1; i <= numZ2; i++) {
            for (int j = 1; j <= numZ3; j++) {
                System.out.println("U" + i + " - V" + j + ": ");
                b[i][j] = scan.nextDouble();
            }
        }
        for (int j = 1; j <= numZ3; j++) {
            System.out.println("V" + j + " - Y: ");
            c[j] = scan.nextDouble();
        }
        System.out.println();

        // Skriver ut den kortaste vägen
        int[] path = DenKortasteVagen.mellanstationer(a, b, c);
        System.out.println("Den kortaste vägen är: X --> U" + path[1] + " --> V" + path[2] + " --> Y");

        // Skriver ut längden för vägen
        double length = DenKortasteVagen.langd(a, b, c);
        System.out.printf("Längden är: %.2f\n", length);
    }
}
