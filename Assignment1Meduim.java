import java.util.*;

public class Assignment1Meduim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, List<String>> cards = new HashMap<>();

        while (true) {
            System.out.println("Card Collection System");
            System.out.println("1 Add Card");
            System.out.println("2 Find Cards by Symbol");
            System.out.println("3 Display All Cards");
            System.out.println("4 Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1: 
                    System.out.print("Enter Card Symbol (Hearts, Spades): ");
                    String symbol = scanner.nextLine();
                    System.out.print("Enter Card Name (Ace, King): ");
                    String name = scanner.nextLine();
                    cards.computeIfAbsent(symbol, k -> new ArrayList<>()).add(name);
                    System.out.println("Card added successfully!");
                    break;

                case 2: 
                    System.out.print("Enter Symbol to Search: ");
                    String searchSymbol = scanner.nextLine();
                    List<String> foundCards = cards.getOrDefault(searchSymbol, new ArrayList<>());
                    if (foundCards.isEmpty()) {
                        System.out.println("No cards found for symbol: " + searchSymbol);
                    } else {
                        System.out.println("Cards with symbol " + searchSymbol + ":" + foundCards);
                    }
                    break;

                case 3: 
                    System.out.println("Stored Cards:");
                    for (Map.Entry<String, List<String>> entry : cards.entrySet()) {
                        System.out.println(entry.getKey() + ":" + entry.getValue());
                    }
                    break;

                case 4:
                    System.out.println("Exit");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid Input");
            }
        }
    }
}