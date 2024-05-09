import java.util.Scanner;

// Class to represent a financial transaction
class Transaction {
    private String description;
    private double amount;

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    // Getters
    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
}

// Class to represent the AI-Powered Personal Finance Assistant
public class PersonalFinanceAssistant {
    // Method to analyze transactions and provide financial insights
    public static void analyzeTransactions(Transaction[] transactions) {
        double totalSpent = 0;
        double largestExpense = Double.MIN_VALUE;
        String largestExpenseDescription = "";

        for (Transaction transaction : transactions) {
            totalSpent += transaction.getAmount();
            if (transaction.getAmount() < 0 && Math.abs(transaction.getAmount()) > largestExpense) {
                largestExpense = Math.abs(transaction.getAmount());
                largestExpenseDescription = transaction.getDescription();
            }
        }

        System.out.println("Total spent: $" + totalSpent);
        if (largestExpenseDescription.isEmpty()) {
            System.out.println("No large expenses found.");
        } else {
            System.out.println("Largest expense: $" + largestExpense + " - " + largestExpenseDescription);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter transaction details
        System.out.println("Enter your transactions (format: description amount):");
        System.out.println("Enter 'done' to finish input.");

        // Store transactions in an array list
        java.util.ArrayList<Transaction> transactionsList = new java.util.ArrayList<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println("Invalid input format. Please try again.");
                continue;
            }
            String description = parts[0];
            double amount = Double.parseDouble(parts[1]);
            transactionsList.add(new Transaction(description, amount));
        }

        // Convert array list to an array
        Transaction[] transactions = transactionsList.toArray(new Transaction[transactionsList.size()]);

        // Analyze transactions and provide insights
        System.out.println("\nFinancial Insights:");
        analyzeTransactions(transactions);

        scanner.close();
    }
}
