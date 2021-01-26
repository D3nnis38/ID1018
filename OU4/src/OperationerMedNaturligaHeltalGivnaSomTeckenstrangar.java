import java.util.Scanner;

public class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar {
    public static void main(String[] args) {
        System.out.println("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");

        // mata in två naturliga heltal
        Scanner in = new Scanner(System.in);
        System.out.println("två naturliga heltal:");
        String tal1 = in.next();
        String tal2 = in.next();
        // addera heltalen och visa resultatet
        // koden här
        String resultat = addera(tal1,tal2);
        visa(tal1, tal2, resultat, '+');
        System.out.println();
        // subtrahera heltalen och visa resultatet
        // koden här
        resultat = subtrahera(tal1, tal2);
        visa(tal1, tal2, resultat, '-');
        System.out.println();

    }

    // addera tar emot två naturliga heltal givna som teckensträngar, och retunerar deras
    // summa som en teckensträng
    public static String addera(String tal1, String tal2) {
        // koden ska skrivas här
        StringBuilder resultat = new StringBuilder();
        int over = 0;

        // Gör att båda talen har samma format, dvs att det mindre talet får '0'
        if (tal1.length() > tal2.length()) {
            tal2 = sammaLangd(tal1, tal2);
        } else if (tal1.length() < tal2.length()) {
            tal1 = sammaLangd(tal2, tal1);
        }

        // Gör addition med hänsyn till alla karaktärer till tal
        for (int i = tal1.length() - 1; i >= 0; i--) {
            int fig1 = Character.getNumericValue(tal1.charAt(i));
            int fig2 = Character.getNumericValue(tal2.charAt(i));
            int delSum = fig1 + fig2 + over;
            over = delSum / 10;
            delSum = delSum % 10;
            resultat.append(String.valueOf(delSum));
        }
        if (over == 1) {
            resultat.append(String.valueOf(over));
        }
        resultat.reverse();
        return resultat.toString();

    }

    // subtrahera tar emot två naturliga heltal givna som teckensträngar, och returnerar
    // deras differens som en teckensträng.
    // Det första heltalet är inte mindre än det andra heltalet.

    public static String subtrahera(String tal1, String tal2) {
        StringBuilder resultat = new StringBuilder();
        int over = 0;

        // Gör att båda talen har samma format, dvs att det mindre talet får '0'
        if (tal1.length() > tal2.length()) {
            tal2 = sammaLangd(tal1, tal2);
        }

        // Gör subrtraktion med hänsyn till alla karaktärer till tal
        for (int i = tal1.length() - 1; i >= 0; i--) {
            int fig1 = Character.getNumericValue(tal1.charAt(i)) - over;
            int fig2 = Character.getNumericValue(tal2.charAt(i));
            int delDiff;
            if (fig1 >= fig2) {
                delDiff = fig1 - fig2;
                over = 0;
            } else {
                delDiff = (fig1 + 10) - fig2;
                over = 1;
            }
            resultat.append(String.valueOf(delDiff));
        }
        resultat.reverse();
        return resultat.toString();
    }

    // visa visar två givna naturliga heltal, och resultatet av en aritmetisk operation
    // utförd i samband med hetalen
    public static void visa(String tal1, String tal2, String resultat, char operator) {
    // sätt en lämplig längd på heltalen och resultatet
        int len1 = tal1.length();
        int len2 = tal2.length();
        int len = resultat.length();
        int maxLen = Math.max(Math.max(len1, len2), len);
        tal1 = sattLen(tal1, maxLen - len1);
        tal2 = sattLen(tal2, maxLen - len2);
        resultat = sattLen(resultat, maxLen - len);

        // visa heltalen och resultatet
        System.out.println(" " + tal1);
        System.out.println("" + operator + "" + tal2);
        for (int i = 0; i < maxLen + 2; i++)
            System.out.print("-");
        System.out.println();
        System.out.println(" " + resultat + "\n");
    }

    // sattLen lägger till ett angivet antal mellanslag i början av en given sträng
    public static String sattLen(String s, int antal) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < antal; i++)
            sb.insert(0, " ");
        return sb.toString();
    }

    private static String sammaLangd(String storre, String mindre) {
        int diff = storre.length() - mindre.length();
        for (int i = 0; i < diff; i++) {
            mindre = "0" + mindre;
        }
        return mindre;
    }
}
