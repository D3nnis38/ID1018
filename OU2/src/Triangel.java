public class Triangel {

    //Tar in längd och höjd och retunerar area
    public static double getArea(double length, double height) {
        return length * height / 2;
    }

    //Tar in alla sidor av triangeln och räknar ut omkretsen
    public static double getCircumference(double a, double b, double c) {
        return a + b + c;
    }

    // bisektris tar emot två sidor i en triangel och vinkeln (i radianer) mellan dessa sidor.
    // Metoden returnerar längden av den motsvarande bisektrisen - den som delar den givna vinkeln // i två lika delar.
    public static double[] getBisektris(double a, double b, double c, double alpha, double beta, double gama) {
        double[] sides = {a,b,c,a};
        double[] angles = {alpha, beta, gama};
        double[] bis = new double[3];
        //Går igenom listan och lägger alla längder av bisektriserna som finns i triangeln i listan bis[]
        for (int i = 0; i < 3; i++) {
            double p = 2 * sides[i] * sides[i+1] * Math.cos(angles[i] / 2);
            bis[i] = p / (sides[i] + sides[i+1]);
        }
        return bis;
    }
    /*
    // bisektris tar emot två sidor i en triangel och vinkeln (i radianer) mellan dessa sidor.
    // Metoden returnerar längden av den motsvarande bisektrisen - den som delar den givna vinkeln // i två lika delar.
    public static double bisektris(double b, double c, double alfa)
    {
        double p = 2 * b * c * Math.cos (alfa / 2);
        double bis = p / (b + c);
        return bis;
    }
*/
    //Tar in alla sidor va triangeln och retunerar radien av den yttre cirkeln
    public static double getRadiousOfOuterCirkle(double a, double b, double c){
       double semiP = getCircumference(a,b,c) / 2;
       return (a*b*c)/(4*Math.sqrt(semiP*(semiP-a)*(semiP-b)*(semiP-c)));
    }
    //Tar in alla sidor va triangeln och retunerar radien av den innre cirkeln
    public static double getRadiusOfInnerCirkle(double a, double b, double c){
        double semiP = getCircumference(a,b,c) / 2;
        return Math.sqrt(((semiP-a)*(semiP-b)*(semiP-c))/(semiP));
    }

}
