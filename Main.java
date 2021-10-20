import java.math.BigDecimal;
import java.util.Scanner;
import java.lang.Math;




public class Main {
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);


        System.out.print("Enter the wire gauge: ");
        double wireGauge = user_input.nextDouble();
        //System.out.println(wireGauge);

        System.out.print("Enter the wire length in inches: ");
        double length = user_input.nextDouble();
        //System.out.println(wireGauge);

            if ( wireGauge > 0 ||  length > 0) {
                double diameter = computeDiameter(wireGauge);
                computeCopperWireResistance(length, diameter, wireGauge);
                computeAlumWireResistance(length, diameter, wireGauge);

            } else {
                System.out.println("Invalid Input");


        }
    }

    public static double computeDiameter(double wireGauge) {
        double exponent = (36 - wireGauge) / 39;
        
        double results = Math.pow(92, exponent);
        
        double d = (0.127 * results);
      
        return d;
    }

    public static void computeCopperWireResistance(double length, double diameter, double wireGauge) {


        double p = 1.678 * (Math.pow(10, -8));


        double R = ((4 * p * (length / 39.37)) / (Math.PI * (Math.pow(diameter, 2) * Math.pow(10, -8))) / 100);
        System.out.printf("The resistance of a %.0f inch piece of %.0f gauge copper wire is %.3f Ohms.\n ", length, wireGauge, R);
    }


    public static void computeAlumWireResistance(double length, double diameter, double wireGauge) {


        double p = 2.82 * (Math.pow(10, -8));
        double R = ((4 * p * (length / 39.37)) / (Math.PI * (Math.pow(diameter, 2) * Math.pow(10, -8))) / 100);

        System.out.printf("The resistance of a %.0f inch piece of %.0f gauge aluminum wire is %.3f Ohms. ", length, wireGauge, R);

    }
}
