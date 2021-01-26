import java.util.*;

public class Temperaturer {
    public static void main(String[] args) {
        System.out.println("TEMPERATURER\n");

        //inmatingsverktyg
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);

        //mata in uppgifter om antalet veckor och antalet mätningar
        System.out.print("antalet veckor: ");
        int antalVeckor = in.nextInt();
        System.out.print("antalet mätningar per vecka: ");
        int antalMatningarPerVecka = in.nextInt();

        // plats att lagra temperaturer
        double[][] t = new double[antalVeckor][antalMatningarPerVecka];

        //mata in temperaturerna
        for (int vecka = 0; vecka < antalVeckor; vecka++) {
            System.out.println("tempereaturer - vecka " + (vecka+1) + ":");
            for (int matning = 0; matning < antalMatningarPerVecka; matning++) {
                t[vecka][matning] = in.nextDouble();
            }
        }
        System.out.println();

        //visa tempereaturerna
        System.out.println("temperaturerna:");
        for (int vecka = 0; vecka < antalVeckor; vecka++) {
            for (int matning = 0; matning < antalMatningarPerVecka; matning++) {
                System.out.print(t[vecka][matning] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // den minsta, den största och meedeltemperaturen - veckovis
        double[] minT = getMinTempInWeek(t);
        double[] maxT = getMaxTempWeek(t);
        double[] sumT = getSumTempWeek(t);
        double[] medelT = getMedTempWeek(t);
        // visa det minsta, den största och medeltempeeraturen för varje vecka
        for (int i = 0; i < t.length; i++) {
            System.out.println("Vecka " + (i+1) + ": minT - " + minT[i] + ", maxT - " + maxT[i] + ", sumT - " + sumT[i] + ", medT - " + medelT[i]);
        }

        // den minsta, den största och medeltemperaturen - hela mätperiod
        double minTemp = getMinTemp(minT);
        double maxTemp = getMaxTemp(maxT);
        double sumTemp = getSumTemp(sumT);
        double medelTemp = getMedelTemp(medelT);
        // koden ska skrivas här
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("minTemp - " + minTemp +", maxTemp - " + maxTemp + ", sumTemp - " + sumTemp + ", medTemp - " + medelTemp);
        // visa den minsta, den största och medelteempeeraturen i heela mätperioden
        // koden ska skrivas här

    }

    //Hämtar minsta värden för varje vecka
    public static double[] getMinTempInWeek(double[][] t){
        double[] minT = new double[t.length];

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length ; j++) {
               if(t[i][j] < minT[i] || j == 0){
                   minT[i] = t[i][j];
                }
            }
        }

        return minT;
    }
    //Hämtar min-temperaturen
    public static double getMinTemp(double[] t){
        double minT = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] < minT || i == 0){
                minT = t[i];
            }
        }
        return minT;
    }
    //Hämtar största värden för varje vecka
    public static double[] getMaxTempWeek(double[][] t){
        double[] maxT = new double[t.length];

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length ; j++) {
                if(t[i][j] > maxT[i] || j == 0){
                    maxT[i] = t[i][j];
                }
            }
        }
        return maxT;
    }
    //Hämtar max-temperaturen
    public static double getMaxTemp(double[] t){
        double maxT = 0;
        for (int i = 0; i < t.length; i++) {
            if(t[i] > maxT || i == 0){
                maxT = t[i];
            }
        }
        return maxT;
    }
    //Hämtar summan för varje vecka
    public static double[] getSumTempWeek(double[][] t){
        double[] sum = new double[t.length];

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                sum[i] += t[i][j];
            }
        }
        return sum;
    }

    //Hämtar summan för alla veckor
    public static double getSumTemp(double[] t){
        double sum = 0;
        for (int i = 0; i < t.length; i++) {
            sum += t[i];
        }
        return sum;
    }

    //Hämtar medeltemperatur för alla veckor
    public static double[] getMedTempWeek(double[][] t){
        double[] medel = new double[t.length];

        for (int i = 0; i < t.length; i++) {
            double sum = 0;
            for (int j = 0; j < t[i].length; j++) {
                sum += t[i][j];
            }
            medel[i] = sum/t[i].length;
        }
        return medel;
    }

    //Hämtar totala medeltemperaturen
    public static double getMedelTemp(double[] t){
        double sum = 0;
        for (int i = 0; i < t.length; i++) {
            sum += t[i];
        }
        return sum/t.length;
    }
}
