public class Sortera {
    public static void main(String[] args) {
        // 16 element i listan
        int[] lista1 = {2, 3, 2, 1, 32, 2, 1, 12, 3, 2, 1, 5, 2, 4, 6, 20};
        // 19 element
        int[] lista2 = {2, 132, 5, 3, 5, 24, 23, 12, 23, 20, 2, 3, 2, 8, 23, 4, 1, 123, 10};

        int min = minDennis(lista1);
        //int min = min(lista2);
        System.out.println(min);
    }

    public static int minDennis(int[] element)throws IllegalArgumentException{
        if(element.length == 0)
            throw new IllegalArgumentException("tom samling");
        int minstaTal = Integer.MAX_VALUE;

        for (int i = 0; i < element.length; i++)
            minstaTal = minstaTal > element[i] ? minstaTal = element[i]: minstaTal;

        return minstaTal;
    }

    public static int min(int[] element) throws IllegalArgumentException {
        if (element.length == 0)
            throw new IllegalArgumentException("tom samling");

        // hör ihop med spårutskriften 2:
        int antalVarv = 1;

        int[] sekvens = element;
        int antaletPar = sekvens.length / 2;
        int antaletOparadeElement = sekvens.length % 2;
        int antaletTankbaraElement = antaletPar + antaletOparadeElement;
        int[] delsekvens = new int[antaletTankbaraElement];
        int i = 0;
        int j = 0;

        //denna är fel ska vara antalet tankbara element
        //Fel 1, sekvens.length -> antaletTankbaraElement i while-loop
        while (antaletPar > 0) {

            for (int k = 0; k < sekvens.length; k++) {
                System.out.print(sekvens[k] + ", ");
            }
            System.out.println();
            // skilj ur en delsekvens med de tänkbara elementen
            i = 0;
            j = 0;
            while (j < antaletPar) {
                delsekvens[j++] = (sekvens[i] < sekvens[i + 1]) ? sekvens[i] : sekvens[i + 1];
                i += 2;
            }
            if (antaletOparadeElement == 1)
                delsekvens[j] = sekvens[antaletPar*2];

            //System.out.println(antaletTankbaraElement);
            // utgå nu ifrån delsekvensen
            //System.out.println(antaletPar);
            sekvens = delsekvens;
            antaletPar = antaletTankbaraElement / 2;
            antaletOparadeElement = antaletTankbaraElement % 2;
            antaletTankbaraElement = antaletPar + antaletOparadeElement;

            //Fel är att delsekvensen aldrig minskar i storlek och därför kopierar kodstycke från initieringen av delsekven.
            //delsekvens = new int[antaletTankbaraElement];

            // spårutskrift 1 – för att följa sekvensen
            //System.out.println (java.util.Arrays.toString (sekvens));
            // spårutskrift 2 - för att avsluta loopen i förväg
            // (för att kunna se vad som händer i början)
           /*if (antalVarv++ == 30)
             System.exit (0);*/
        }
        // sekvens[0] är det enda återstående tänkbara elementet
        // - det är det minsta elementet
        return sekvens[0];
    }
}
