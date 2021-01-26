import java.util.Arrays;

public class Polylinje {
    private Punkt[] horn;
    private String farg = "svart";
    private int bredd = 1;

    public Polylinje() {
        this.horn = new Punkt[0];
    }

    public Polylinje(Punkt[] horn) {
        this.horn = new Punkt[horn.length];
        for (int i = 0; i < horn.length; i++) {
            this.horn[i] = new Punkt(horn[i]);
        }
    }

    public String toString() {
        StringBuilder beskrivning = new StringBuilder();
        for (Punkt horn : this.horn) {
            beskrivning.append("(").append(horn.getNamn()).append(" ").append(horn.getX()).append(" ").append(horn.getY()).append(") ");
        }
        beskrivning.append("Färg = ").append(this.getFarg());
        return beskrivning.toString();
    }

    public Punkt[] getHorn() {
        return Arrays.copyOf(this.horn, this.horn.length);
    }

    public String getFarg() {
        return this.farg;
    }

    public int getBredd() {
        return this.bredd;
    }

    public void setFarg(String farg) {
        this.farg = farg;
    }

    public void setBredd(int bredd) {
        this.bredd = bredd;
    }

    public double langd() {
        double langd = 0;
        for (int i = 0; i < this.horn.length - 1; i++) {
            langd += this.horn[i].avstand(this.horn[i + 1]);
        }
        return langd;
    }


    public void laggTill(Punkt horn) {
        Punkt[] h = new Punkt[this.horn.length + 1];
        int i = 0;
        for (i = 0; i < this.horn.length; i++)
            h[i] = this.horn[i];
        h[i] = new Punkt(horn);

        this.horn = h;

    }

    public void laggTillFramfor(Punkt horn, String hornNamn) {
        Punkt nyPunkt = new Punkt(horn);
        Punkt[] nyaPunketer = new Punkt[this.horn.length + 1];

        int index = 0;
        for (int i = 0; i < this.horn.length; i++) {
            if (this.horn[i].getNamn().equals(hornNamn)) {
                index = i;
                break;
            }
        }
        for (int i = 0; i < nyaPunketer.length - 1; i++) {
            nyaPunketer[i < index ? i : i + 1] = this.horn[i];
        }
        nyaPunketer[index] = nyPunkt;

        this.horn = nyaPunketer;
    }

    public void taBort(String hornNamn) {
        Punkt[] nyaPunkter = new Punkt[this.horn.length - 1];

        int index = 0;
        for (int i = 0; i < this.horn.length; i++) {
            if (this.horn[i].getNamn().equals(hornNamn)) {
                index = i;
                break;
            }

        }
        for (int i = 0; i < index; i++) {
            nyaPunkter[i] = this.horn[i];
        }
        for (int i = index; i < nyaPunkter.length; i++) {
            nyaPunkter[i] = this.horn[i + 1];
        }
        this.horn = nyaPunkter;
    }
    public class PolylinjeIterator{
        private int aktuell = -1;

        public PolylinjeIterator(){
            if(Polylinje.this.horn.length > 0)
                aktuell=0;
        }

        public boolean finnsHorn(){
            return aktuell != -1;
        }

        public Punkt horn () throws java.util.NoSuchElementException{
            if(!this.finnsHorn())
                throw new java.util.NoSuchElementException("slut av iterationen");
            Punkt horn = Polylinje.this.horn[aktuell];
            return horn;
        }
        public void gaFram(){
            if(aktuell >= 0 && aktuell < Polylinje.this.horn.length - 1)
                aktuell++;
            else
                aktuell = -1;
        }
    }
}

