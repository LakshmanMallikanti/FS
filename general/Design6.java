
/*You are building an E-Commerce Product Insights Engine for a marketplace like 
Amazon or Flipkart. The platform stores information about various products, 
their pricing history, and user ratings.

Your job is to:

    1. Accept data for multiple products.
    
    2. Each product has:
        🎯 Multiple price entries (date + price)
        🎯 Multiple ratings (user + stars out of 5)
        
    3. Calculate:
        🎯 Average price of the product
        🎯 Price volatility score: Standard deviation of prices
        🎯 Average rating

    4. Classify products into Insight Tiers:
        🟢 Stable & Loved: Volatility < 100 and Rating ≥ 4.0
        🟡 Unstable but Popular: Volatility ≥ 100 and Rating ≥ 4.0
        🔴 Unstable & Poorly Rated: Volatility ≥ 100 and Rating < 4.0
        ⚪ Stable but Low-Rated: Volatility < 100 and Rating < 4.0
        
Sample Input:
-------------
2               // Number of products
EchoDot         // ProductName
3               // Number of price entries
2024-06-01 3499 // priceDate priceAmount
2024-06-10 3299
2024-06-15 3599
2               // Number of ratings
Alice 5         // userName stars
Bob 4
OldTV           // ProductName
4               // Number of price entries
2024-05-01 9999 // priceDate priceAmount
2024-05-10 10999
2024-05-15 11999
2024-05-20 8999
3               // Number of ratings
Charlie 2       // userName stars
Diana 3
Eve 1

Sample Output:
--------------
Product: EchoDot, AvgPrice: 3465.7, Volatility: 124.7, AvgRating: 4.5, Tier: Unstable but Popular
Product: OldTV, AvgPrice: 10499.0, Volatility: 1118.0, AvgRating: 2.0, Tier: Unstable & Poorly Rated

 */

import java.util.*;

public class Design6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Product> products = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            int m = Integer.parseInt(sc.nextLine());

            List<PriceEntry> prices = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                String[] parts = sc.nextLine().split(" ");
                prices.add(new PriceEntry(parts[0], Double.parseDouble(parts[1])));
            }

            int k = Integer.parseInt(sc.nextLine());
            List<Rating> ratings = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                String[] parts = sc.nextLine().split(" ");
                ratings.add(new Rating(parts[0], Integer.parseInt(parts[1])));
            }

            products.add(new Product(name, prices, ratings));
        }

        InsightEngine engine = new InsightEngineImpl();
        System.out.println("=== Product Insights Summary ===");
        for (Product p : products) {
            ProductInsight insight = engine.analyze(p);
            System.out.println(insight);
        }
    }
}

// TODO: Complete this POJO
class PriceEntry {
    // String date; double amount
    private String date;
    private double amount;

    public PriceEntry(String date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    String getdate() {
        return this.date;
    }

    double getamount() {
        return this.amount;
    }
}

// TODO: Complete this POJO
class Rating {
    // String userName; int stars
    private String userName;
    private int stars;

    public Rating(String userName, int stars) {
        this.userName = userName;
        this.stars = stars;
    }

    String getname() {
        return this.userName;
    }

    int getstars() {
        return this.stars;
    }
}

// TODO: Complete this POJO
class Product {
    // String name; List<PriceEntry>; List<Rating>
    private String name;
    private List<PriceEntry> PriceEntries = new ArrayList<>();
    private List<Rating> Ratings = new ArrayList<>();

    public Product(String name, List<PriceEntry> PriceEntries, List<Rating> Ratings) {
        this.name = name;
        this.PriceEntries = PriceEntries;
        this.Ratings = Ratings;
    }

    String getname() {
        return this.name;
    }

    List<PriceEntry> getPriceEntry() {
        return this.PriceEntries;
    }

    List<Rating> getRatings() {
        return this.Ratings;
    }
}

// TODO: Complete this POJO
class ProductInsight {
    // Product; double avgPrice; double volatility; double avgRating; String
    // insightTier
    private String name;
    private double avgPrice;
    private double volatility;
    private double avgRating;
    private String insightTier;

    public ProductInsight(String name, double avgPrice, double volatility, double avgRating, String insightTier) {
        this.name = name;
        this.avgPrice = avgPrice;
        this.volatility = volatility;
        this.avgRating = avgRating;
        this.insightTier = insightTier;
    }

    // Override toString() for output
    public String toString() {
        return "Product: " + this.name + ", AvgPrice: " + String.format("%.1f", this.avgPrice) + ", Volatility: "
                + String.format("%.1f", this.volatility) + ", AvgRating: " + String.format("%.1f", this.avgRating)
                + ", Tier: " + this.insightTier;
    }
}

interface InsightEngine {
    ProductInsight analyze(Product p);
}

// TODO: Implement InsightEngineImpl using Math.pow and Math.sqrt for std
// deviation
class InsightEngineImpl implements InsightEngine {
    public ProductInsight analyze(Product p) {
        // Logic:
        // - Calculate avgPrice
        double sum = 0;
        for (PriceEntry pe : p.getPriceEntry())
            sum = sum + pe.getamount();
        double avgprice = sum / (p.getPriceEntry().size());
        // - Calculate standard deviation
        // sqrt(sigm(xi-avg)/n)
        sum = 0;
        for (PriceEntry pe : p.getPriceEntry())
            sum = sum + Math.pow((pe.getamount() - avgprice), 2);
        double volatility = Math.sqrt(sum / (p.getPriceEntry().size()));

        // - Calculate avgRating
        sum = 0;
        for (Rating r : p.getRatings())
            sum = sum + (double) r.getstars();
        double avgRating = sum / (p.getRatings().size());
        // - Tier assignment
        /*
         * 🟢 Stable & Loved: Volatility < 100 and Rating ≥ 4.0
         * 🟡 Unstable but Popular: Volatility ≥ 100 and Rating ≥ 4.0
         * 🔴 Unstable & Poorly Rated: Volatility ≥ 100 and Rating < 4.0
         * ⚪ Stable but Low-Rated: Volatility < 100 and Rating < 4.0
         */
        String tier = "";
        if (volatility < 100 && avgRating >= 4.0)
            tier = "Stable & Loved";
        else if (volatility >= 100 && avgRating >= 4.0)
            tier = "Unstable but Popular";
        else if (volatility >= 100 && avgRating < 4.0)
            tier = "Unstable & Poorly Rated";
        else
            tier = "stable but Low-Rated";

        return new ProductInsight(p.getname(), avgprice, volatility, avgRating, tier); // TODO
    }
}
