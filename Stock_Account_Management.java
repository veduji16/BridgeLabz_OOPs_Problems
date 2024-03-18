package OOPs_Practice_Problems;

import java.util.*;

class Stock {
    private final String name;
    private final int numberOfShares;
    private final double sharePrice;

    public Stock(String name, int numberOfShares, double sharePrice) {
        this.name = name;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }

    public double calculateStockValue() {
        return numberOfShares * sharePrice;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public double getSharePrice() {
        return sharePrice;
    }
}

class StockPortfolio {
    private final Stock[] stocks;

    public StockPortfolio(int numberOfShares) {
        stocks = new Stock[numberOfShares];
    }

    public void addStock(int index, String name, int numberOfShares, double sharePrice) {
        stocks[index] = new Stock(name, numberOfShares, sharePrice);
    }

    public double calculateTotalPortfolioValue() {
        double totalValue = 0;

        for (Stock stock : stocks) {
            totalValue += stock.calculateStockValue();
        }
        return totalValue;
    }

    public void printStockReport() {
        System.out.println("Stock Report");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-15s %-15s %-15s %-15s\n", "Stock Name", "Number of Shares", "Share Price",
                "Total Value");
        System.out.println("------------------------------------------------------------------------");

        for (Stock stock : stocks) {
            System.out.printf("%-15s %-15d %-15.2f %-15.2f\n", stock.getName(), stock.getNumberOfShares(),
                    stock.getSharePrice(), stock.calculateStockValue());
        }
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Total Portfolio Value: " + calculateTotalPortfolioValue());

    }
}

public class Stock_Account_Management {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of stocks: ");
        int numberOfStocks = sc.nextInt();
        sc.nextLine();

        StockPortfolio portfolio = new StockPortfolio(numberOfStocks);

        for (int i = 0; i < numberOfStocks; i++) {
            System.out.println("\nEnter details for stock" + (i + 1) + ": ");
            System.out.print("Enter Stock Name: ");
            String name = sc.nextLine();
            System.out.print("Enter the number of shares: ");
            int numberOfShares = sc.nextInt();
            System.out.print("Enter Share Price: ");
            double sharePrice = sc.nextInt();
            sc.nextLine();

            portfolio.addStock(i, name, numberOfShares, sharePrice);
        }
        portfolio.printStockReport();
        sc.close();
    }
}
