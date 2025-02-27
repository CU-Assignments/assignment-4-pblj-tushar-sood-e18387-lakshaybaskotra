import java.util.*;

class CardCollection {
    private final Map<String, List<String>> cards;

    public CardCollection() {
        cards = new HashMap<>();
    }

    public void addCard(String symbol, String value) {
        cards.computeIfAbsent(symbol, k -> new ArrayList<>()).add(value);
    }

    public List<String> getCardsBySymbol(String symbol) {
        return cards.getOrDefault(symbol, new ArrayList<>());
    }

    public void displayAllCards() {
        if (cards.isEmpty()) {
            System.out.println("No cards in the collection.");
        } else {
            System.out.println("\nCard Collection:");
            for (Map.Entry<String, List<String>> entry : cards.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}

public class CardCollectionSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CardCollection collection = new CardCollection();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nCard Collection System");
            System.out.println("1. Add Card");
            System.out.println("2. Find Cards by Symbol");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addCard();
                    break;
                case 2:
                    findCardsBySymbol();
                    break;
                case 3:
                    collection.displayAllCards();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addCard() {
        System.out.print("Enter card symbol (e.g., Hearts, Spades): ");
        String symbol = scanner.nextLine();
        System.out.print("Enter card value (e.g., Ace, King, 10): ");
        String value = scanner.nextLine();
        collection.addCard(symbol, value);
        System.out.println("Card added successfully!");
    }

    private static void findCardsBySymbol() {
        System.out.print("Enter symbol to search: ");
        String symbol = scanner.nextLine();
        List<String> cards = collection.getCardsBySymbol(symbol);
        if (cards.isEmpty()) {
            System.out.println("No cards found for symbol: " + symbol);
        } else {
            System.out.println("Cards for " + symbol + ": " + cards);
        }
    }
}
