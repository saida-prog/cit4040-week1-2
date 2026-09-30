public class Calculator {

    public static double calculateTotal(double price, int quantity) {
        if (price < 0 || quantity < 0) {
            System.out.println("Warning: price and quantity must not be negative");
            return 0;
        }
        double total = price * quantity;
        if (quantity >= 10) {
            total = total * 0.9;
        }
        return total;
    }

    public static int countVowels(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

    public static void checkAccess(String role) {
        // "admin" is never null, so calling equals on it cannot throw NullPointerException
        if ("admin".equals(role)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }

    public static void main(String[] args) {
        int productId = 1024;
        double productPrice = 4.99;
        boolean inStock = true;
        char sizeCode = 'M';
        String productName = "Green Tea";
        System.out.println("Product #" + productId + ": " + productName + ", size " + sizeCode
                + ", price $" + productPrice + ", in stock: " + inStock);

        System.out.println("Total (4.99 x 3):   " + calculateTotal(4.99, 3));
        System.out.println("Total (4.99 x 10):  " + calculateTotal(4.99, 10));
        System.out.println("Total (100.0 x 12): " + calculateTotal(100.0, 12));
        System.out.println("Total (-5.0 x 2):   " + calculateTotal(-5.0, 2));
        System.out.println("Total (5.0 x -1):   " + calculateTotal(5.0, -1));

        System.out.print("Divisible by 3:");
        for (int i = 1; i <= 20; i++) {
            if (i % 3 == 0) {
                System.out.print(" " + i);
            }
        }
        System.out.println();

        System.out.print("Doubling:");
        int value = 1;
        while (value <= 1000) {
            System.out.print(" " + value);
            value = value * 2;
        }
        System.out.println(" " + value);

        String sentence = "Hello, backend development";
        System.out.println("Vowels in \"" + sentence + "\": " + countVowels(sentence));

        checkAccess("admin");
        checkAccess("guest");
        checkAccess(null);

        if (args.length > 0 && args[0].equals("npe")) {
            String missing = null;
            System.out.println(missing.length());
        }
    }
}
