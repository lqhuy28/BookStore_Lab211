import Pstate.BookList;
import Pstate.PublisherList;
import java.util.Scanner;

public class BookManager{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("---- BOOKSTORE MANAGEMENT ----");
            System.out.println("1 - Publisher Management");
            System.out.println("2 - Book Management");
            System.out.println("3 - Quit");
            System.out.print("Choose (1..3): ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    publisherManager();
                    break;
                case 2:
                    bookManager();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option, TRY AGAIN.");
                    break;
            }
        }
    }

    private static void publisherManager() {
        PublisherList pList = new PublisherList();
        pList.readFromFile();
    
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("---- PUBLISHER MANAGER ----");
            System.out.println("1 - Add Publisher");
            System.out.println("2 - Search Publisher");
            System.out.println("3 - Remove Publisher");
            System.out.println("4 - Update Publisher");
            System.out.println("5 - Print Publisher");
            System.out.println("6 - Save Publisher to file");
            System.out.println("7 - Back to main menu");
            System.out.println("8 - Quit");
            System.out.print("Choose (1..8): ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1: pList.addPublisher(); 
                    break;
                case 2: pList.search(); 
                    break;
                case 3: pList.removePublisher(); 
                    break;
                case 4: pList.updatePublisher();
                    break;
                case 5: pList.print(); 
                    break;
                case 6: pList.writeToFile();
                    break;
                case 7:
                    return;
                case 8:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option, TRY AGAIN.");
                    break;
            }
        }
    }

    private static void bookManager() {
        PublisherList pList = new PublisherList();
        pList.readFromFile();
        BookList bList = new BookList(pList);
        bList.readFromFile();
        
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("---- BOOK MANAGER ----");
            System.out.println("1 - Add Book");
            System.out.println("2 - Search Book");
            System.out.println("3 - Remove Book");
            System.out.println("4 - Update Book");
            System.out.println("5 - Print Book");
            System.out.println("6 - Save Book to file");
            System.out.println("7 - Back to main menu");
            System.out.println("8 - Quit");
            System.out.print("Choose (1..8): ");
            int choice = scan.nextInt();
            switch(choice) {
                case 1: bList.addBook();
                    break;
                case 2: bList.search(); 
                    break;
                case 3: bList.removeBook(); 
                    break;
                case 4: bList.updateBook();
                    break;
                case 5: bList.print();  
                    break;
                case 6: bList.writeToFile();   
                    break;
                case 7:
                    return;
                case 8:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option, TRY AGAIN.");
                    break;
            }
        }
    }
}