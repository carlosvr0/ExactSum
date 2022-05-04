import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {

		while (lector.hasNext()) {

			int numPrices = lector.nextInt();
			int[] prices = new int[numPrices];

			for (int n = 0; n < numPrices; n++) {
				prices[n] = lector.nextInt();
			}

			int money = lector.nextInt();

			lector.nextLine();
			lector.nextLine();

			Arrays.sort(prices); // ordenar los precios

			int a = -1;
			int b = -1;

			List<Integer> booksPrices = new ArrayList<Integer>();

			for (int m = 0; m < prices.length; m++) {

				int inicio = m + 1;
				int fin = numPrices - 1;
				int medio = -1;

				while (inicio <= fin) {
					medio = (inicio + fin) / 2;
					if (prices[m] + prices[medio] == money) {
						a = prices[m];
						booksPrices.add(a);
						b = prices[medio];
						booksPrices.add(b);
						break;
					} else if (money < prices[m] + prices[medio]) {
						fin = medio - 1;
					} else if (money > prices[m] + prices[medio]) {
						inicio = medio + 1;
					}
				}
			}

			int firstPriceToShow = booksPrices.get(0);
			int secondPriceToShow = booksPrices.get(1);

			for (int i = 0; i < booksPrices.size() - 1; i += 2) {
				if ((booksPrices.get(i + 1) - booksPrices.get(i)) < (secondPriceToShow - firstPriceToShow)) {
					firstPriceToShow = booksPrices.get(i);
					secondPriceToShow = booksPrices.get(i + 1);
				}
			}

			System.out.println(
					"Peter should buy books whose prices are " + firstPriceToShow + " and " + secondPriceToShow + ".");
			System.out.println("");
		}
	}
}
