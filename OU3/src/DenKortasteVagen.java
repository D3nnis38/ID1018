public class DenKortasteVagen {
    // mellanstationer returnerar en vektor med de mellanstationer som finns på den kortaste
    // vägen. Ordningsnummer av den första mellanstationen finns på index 1, och ordningsnummer // av den andra mellanstationen på index 2 i vektorn.
    public static int[] mellanstationer(double[] a, double[][] b, double[] c) {
        // koden här
        int[] stationer = {0, 1, 1};
        double minLeng = a[1] + b[1][1] + c[1];

        // Gå igenom alla de möjliga vägar för att hitta den kortaste vägen
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < c.length; j++) {
                double curLeng = a[i] + b[i][j] + c[j];

                if (curLeng < minLeng) {
                    stationer[1] = i;
                    stationer[2] = j;
                    minLeng = curLeng;
                }
            }
        }
        return stationer;
    }

    // langd returnerar längden av den kortaste vägen.
    public static double langd(double[] a, double[][] b, double[] c) {
        // koden här
        int[] s = mellanstationer(a, b, c);
        return a[s[1]] + b[s[1]][s[2]] + c[s[2]];
    }
}
