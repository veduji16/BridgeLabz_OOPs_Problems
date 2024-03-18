package OOPs_Practice_Problems;

import java.util.ArrayList;
import java.util.List;

class CompanyShares {
    private String symbol;
    private int numberOfShares;
    private double sharePrice;
    private String dateTime;

    public CompanyShares(String symbol, int numberOfShares, double sharePrice, String dateTime) {
        this.symbol = symbol;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
        this.dateTime = dateTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public double getSharePrice() {
        return sharePrice;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }
}

public class StockAccount {
    private List<CompanyShares> companySharesList;

    public StockAccount() {
        companySharesList = new ArrayList<>();
    }

    public double valueOf() {
        double totalValue = 0.0;
        for (CompanyShares shares : companySharesList) {
            totalValue += shares.getNumberOfShares() * shares.getSharePrice();
        }
        return totalValue;
    }

    public void buy(int amount, String symbol, double sharePrice, String dateTime) {
        boolean shareFound = false;
        for (CompanyShares shares : companySharesList) {
            if (shares.getSymbol().equals(symbol)) {
                shares.setNumberOfShares(shares.getNumberOfShares() + amount);
                shareFound = true;
                break;
            }
        }
        if (!shareFound) {
            CompanyShares newShares = new CompanyShares(symbol, amount, sharePrice, dateTime);
            companySharesList.add(newShares);
        }
    }

    public void sell(int amount, String symbol, String dateTime) {
        for (CompanyShares shares : companySharesList) {
            if (shares.getSymbol().equals(symbol)) {
                if (shares.getNumberOfShares() >= amount) {
                    shares.setNumberOfShares(shares.getNumberOfShares() - amount);
                } else {
                    System.out.println("Not enough shares to sell!");
                }
                break;
            }
        }
    }

    public void printReport() {
        for (CompanyShares shares : companySharesList) {
            System.out.println("Symbol: " + shares.getSymbol() + ", Number of Shares: " + shares.getNumberOfShares() +
                    ", Share Price: $" + shares.getSharePrice() + ", Date Time: " + shares.getDateTime());
        }
    }

    public static void main(String[] args) {
        StockAccount stockAccount = new StockAccount();

        stockAccount.buy(100, "AAPL", 150.0, "2024-03-15 10:30:00");
        stockAccount.buy(50, "GOOGL", 2500.0, "2024-03-15 11:00:00");
        stockAccount.buy(75, "AAPL", 160.0, "2024-03-15 11:30:00");
        stockAccount.printReport();
        System.out.println("Total value of stocks: $" + stockAccount.valueOf());

        stockAccount.sell(30, "AAPL", "2024-03-15 12:00:00");
        stockAccount.printReport();
        System.out.println("Total value of stocks: $" + stockAccount.valueOf());
    }
}
