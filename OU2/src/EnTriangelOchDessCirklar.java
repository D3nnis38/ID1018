import java.util.Scanner;

public class EnTriangelOchDessCirklar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Skriv in sidorna av trianglen: ");
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();

        System.out.println("Skriv in graderna mellan a och b: ");
        double alfa = in.nextDouble();
        System.out.println("Skriv in graderna mellan b och c: ");
        double beta = in.nextDouble();
        System.out.println("Skriv in graderna mellan c och a: ");
        double gama = in.nextDouble();

        System.out.println("Skriv in höjden av triangeln: ");
        double height = in.nextDouble();


        double[] bis = Triangel.getBisektris(a,b,c,alfa,beta,gama);
        for (int i = 0; i < bis.length; i++) {
            System.out.println("Längden på bisektris " + i + ": " + bis[i]);
        }

        //System.out.println(Triangel.bisektris(b,c,alfa));
        System.out.println("Omkretsen av triangeln är: " + Triangel.getCircumference(a,b,c));
        System.out.println("Arean h*l/2 av triangeln är: " + Triangel.getArea(a, height));
        System.out.println("Radien av den yttre cirekeln är: " + Triangel.getRadiousOfOuterCirkle(a,b,c));
        System.out.println("Radien av den innre cirkeln är: " + Triangel.getRadiusOfInnerCirkle(a,b,c));

    }
}
