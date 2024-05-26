import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) { // constructor
        this.name = name;
        this.price = price;
    }

    public String getName() { // getter for name
        return name;
    }

    public double getPrice() { // getter for price
        return price;
    }

    @Override
    public String toString() {
        return name + " - $" + String.format("%.2f", price);
    }
}

class Order {
    private List<MenuItem> items;
    private double total;

    public Order() {
        items = new ArrayList<>();
        total = 0.0;
    }

    public void addItem(MenuItem item) {
        items.add(item);
        total += item.getPrice();
    }

    public double getTotal() {
        return total;
    }

    public void printOrder() {
        System.out.println("Order Summary:");
        for (MenuItem item : items) {
            System.out.println(item);
        }
        System.out.println("Total: $" + String.format("%.2f", total));
    }

    public void clear() {
        items.clear();
        total = 0.0;
    }
}

public class POS {
    private static MenuItem[] menu = {
        new MenuItem("Lemon Water", 1.45),
        new MenuItem("Salad", 4.48),
        new MenuItem("Lassi", 2.00),
        new MenuItem("Ice Cream", 3.21),
        new MenuItem("Bhel", 2.23)
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Select an item by number (or enter 0 to finish): ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                running = false;
                break;
            }

            if (choice < 1 || choice > menu.length) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            MenuItem selectedItem = menu[choice - 1];
            order.addItem(selectedItem);
            System.out.println("Added: " + selectedItem);
        }

        order.printOrder();
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i]);
        }
    }
}
