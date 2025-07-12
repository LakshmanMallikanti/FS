
/*
Design a product rating system for an e-commerce site.

Rating Logic:
-------------
- Quality Score = min(1, qualityRating / 5)
- Delivery Score = min(1, deliveryRating / 5)
- Return Rate Score = 1 - min(1, returnRate / 0.5)

Final Score = (0.5 × Quality) + (0.3 × Delivery) + (0.2 × Return Rate Score) × 100

Classification:
---------------
- ≥ 85 → Top Rated
- 60 - 85 → Average
- < 60 → Poor

Tasks to Complete:
------------------
1. POJO: Product (name, qualityRating, deliveryRating, returnRate)

2. POJO: RatingReport (Product, finalScore, classification)

3. Interface: RatingAnalyzer (RatingReport analyze(Product p);)

4. Implement RatingAnalyzerImpl

5. In main, analyze 3 products and print reports.
*/
import java.util.*;

class Product {
    private String name;
    private double qualityRating; // out of 5
    private double deliveryRating; // out of 5
    private double returnRate; // between 0 and 1

    public Product(String name, double qualityRating, double deliveryRating, double returnRate) {
        this.name = name;
        this.qualityRating = qualityRating;
        this.deliveryRating = deliveryRating;
        this.returnRate = returnRate;
    }

    public String getName() {
        return name;
    }

    public double getQualityRating() {
        return qualityRating;
    }

    public double getDeliveryRating() {
        return deliveryRating;
    }

    public double getReturnRate() {
        return returnRate;
    }
}

class RatingReport {
    private Product product;
    private double finalScore;
    private String classification;

    public RatingReport(Product product, double finalScore, String classification) {
        this.product = product;
        this.finalScore = finalScore;
        this.classification = classification;
    }

    @Override
    public String toString() {
        return "Rating Report for " + product.getName() + ":\n" +
                "Final Score: " + String.format("%.2f", finalScore) + "\n" +
                "Classification: " + classification + "\n";
    }
}

interface RatingAnalyzer {
    RatingReport analyze(Product p);
}

class RatingAnalyzerImpl implements RatingAnalyzer {
    @Override
    public RatingReport analyze(Product p) {
        double qualityScore = Math.min(1.0, p.getQualityRating() / 5.0);
        double deliveryScore = Math.min(1.0, p.getDeliveryRating() / 5.0);
        double returnRateScore = 1.0 - Math.min(1.0, p.getReturnRate() / 0.5);

        double finalScore = (0.5 * qualityScore + 0.3 * deliveryScore + 0.2 * returnRateScore) * 100;

        String classification;
        if (finalScore >= 85) {
            classification = "Top Rated";
        } else if (finalScore >= 60) {
            classification = "Average";
        } else {
            classification = "Poor";
        }

        return new RatingReport(p, finalScore, classification);
    }
}

public class Design5 {
    public static void main(String[] args) {
        RatingAnalyzer analyzer = new RatingAnalyzerImpl();

        Product p1 = new Product("Wireless Earbuds", 4.8, 4.5, 0.1);
        Product p2 = new Product("Laptop Bag", 3.5, 3.8, 0.3);
        Product p3 = new Product("Smart Watch", 2.2, 2.5, 0.6); // intentionally bad

        System.out.println(analyzer.analyze(p1));
        System.out.println(analyzer.analyze(p2));
        System.out.println(analyzer.analyze(p3));
    }
}
