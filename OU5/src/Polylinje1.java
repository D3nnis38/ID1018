public class Polylinje1 {
    private Punkt[] horn;
    private String farg = "svart";
    private int bredd = 1;

    public Polylinje1() {
        this.horn = new Punkt[0];
    }

    public Polylinje1(Punkt[] horn) {
        this.horn = new Punkt[horn.length];
        for (int i = 0; i < this.horn.length; i++) {
            this.horn[i] = new Punkt(horn[i]);
        }
    }

    public String toString() {
        StringBuilder beskrivning = new StringBuilder();
        for (Punkt horn : this.horn) {
            beskrivning.append("(").append(horn.getNamn()).append(" ").append(horn.getX()).append(" ").append(horn.getY()).append(") ");
        }
        return beskrivning.toString();
    }

    public Punkt[] getHorn() {
        return this.horn;
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
        int i;
        for (i = 0; i < this.horn.length; i++)
            h[i] = this.horn[i];
        h[i] = new Punkt(horn);

        this.horn = h;
    }

    public void laggTillFramfor(Punkt horn, String hornNamn) {
        Punkt[] nyaPunketer = new Punkt[this.horn.length + 1];

        int i = 0;
        while (!((this.horn[i].getNamn()).equals(hornNamn))) {
            nyaPunketer[i] = this.horn[i];
            i++;
        }
        // Add newVertex
        nyaPunketer[i] = new Punkt(horn);
        // Complete the array with the remaining elements
        for (int j = i + 1; j <= this.horn.length; j++) {
            nyaPunketer[j] = this.horn[j + 1];
        }
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
}
