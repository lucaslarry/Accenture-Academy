import java.util.Scanner;
/**
 * @author Lucas Larry
 *
 */
public class StadiumRevenue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double aClass = 50.0;
        double bClass = 30.0;
        double cClass = 20.0;

        System.out.print("Enter the quantity of A Class tickets sold: ");
        int aQuantity = scanner.nextInt();

        System.out.print("Enter the quantity of B Class tickets sold: ");
        int bQuantity = scanner.nextInt();

        System.out.print("Enter the quantity of C Class tickets sold: ");
        int cQuantity = scanner.nextInt();

        double totalRevenue = (aQuantity * aClass) + (bQuantity * bClass) + (cQuantity * cClass);

        System.out.printf("The total revenue generated is: $ %.2f\n", totalRevenue);

        scanner.close();
    }
}