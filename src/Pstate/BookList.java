package Pstate;

import Model.Publisher;
import Model.Book;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import tools.MyUtil;

public class BookList {
    List<Book> bL= new ArrayList();
    String fName = "src\\data\\Book.dat";
    PublisherList pL;
    public BookList(PublisherList pL) {
        super();
        this.pL = pL;
    }
    
    public void readFromFile(){
        File f = new File(fName);
        if(!f.exists()) {
            System.out.println("File is not existed!");
            System.exit(0);
        }
        try{
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String line;
            while((line = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(line, ",");
                String bookId = stk.nextToken().trim().toUpperCase();
                String bookName = stk.nextToken().trim().toUpperCase();
                double bookPrice = Double.parseDouble(stk.nextToken().trim());
                int quantity = Integer.parseInt(stk.nextToken().trim());
                String publisherId = stk.nextToken().trim().toUpperCase();
                Book b = new Book(bookId, bookName, bookPrice, quantity, publisherId);
                bL.add(b);
            }
            bf.close();
            fr.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public void writeToFile()  {
        if(bL.isEmpty())
            System.out.println("Empty list!");
        else {
            try{
            PrintWriter pw = new PrintWriter(fName);
            for(Book b: bL) pw.println(b);
            pw.close();
            
            System.out.println("Writing file: DONE.");
            }catch(Exception e)
            {
                System.out.println("Error save.");
            }
        }
    }
    
    public void addBook() {
        String bookId;
        String bookName;
        double bookPrice;
        int quantity;
        String publisherId;
        System.out.println("Data of new book:");
        int pos;
        do{
            bookId = MyUtil.readPattern("BookId", "B[\\d]{5}");
            pos = bL.indexOf(new Book(bookId));
            if(pos>=0) System.out.println("ID is duplicated!");
        }
        while(pos>=0);
        bookName = MyUtil.readString("Book name", 5, 30);
        bookPrice = MyUtil.readDouble("Price", 0);
        quantity = MyUtil.readInt("Quantity", 0);
        do{
            publisherId = MyUtil.readString("Publisher ID", 5, 30);
        } while(pL.getAll().indexOf(new Publisher(publisherId)) < 0);
        Book newBook = new Book(bookId, bookName, bookPrice, quantity, publisherId);
        bL.add(newBook);
        System.out.println("Added.");
    }
    
    public void search() {
        if (bL.isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        List<Book> booklist = new ArrayList();
        String ID;
        System.out.println("ID Publisher of searched book:");
        ID = MyUtil.sc.nextLine().trim().toUpperCase();
        for (Book i : bL) {
            if (i.getPublisherId().equals(ID)) {
                booklist.add(i);
            }
        }
        if (booklist.isEmpty()) {
            System.out.println("Have no books had publisher id " + ID);
            return;
        } else {
            String name;
            System.out.println("Name field of searched book:");
            name = MyUtil.sc.nextLine().trim().toUpperCase();
            if (name.isEmpty()) {
                for (Book i : booklist) {
                    System.out.println(i.toString());
                }
                return;
            }
            
            List<Book> newB= new ArrayList();
            for (int i=0; i<booklist.size();i++) {
           
                if (booklist.get(i).getBookName().toUpperCase().contains(name)) {
                    newB.add(booklist.get(i));
                }
               
            }
            if (newB.isEmpty()) {
                System.out.println("Have no book");
            } else { 
                for (Book i : newB) {
                   
                    System.out.println(i.toString());
                }
            }
        }
    }
    
    public void removeBook() {
        String ID;
        System.out.println("ID of removed book:");
        ID = MyUtil.sc.nextLine().trim().toUpperCase();
        int pos = bL.indexOf(new Book(ID));
        if(pos < 0) System.out.println("Not found!");
        else{
            bL.remove(pos);
            System.out.println("Removed.");
        }
    }
    
    public void updateBook() {
        String bookId;
        String input;
        System.out.println("ID of updated book:");
        bookId = MyUtil.sc.nextLine().trim().toUpperCase();
        int pos = bL.indexOf(new Book(bookId));
        if(pos < 0 ) System.out.println("Not found!");
        else{
            Book b = bL.get(pos);
            System.out.println("New book attributes - Enter for skipping");
            boolean OK;
            int L;
            do{
                System.out.println("New name: ");
                input = MyUtil.sc.nextLine().trim().toUpperCase();
                L = input.length();
                OK = L==0 || (L>=5 && L<=30);
            }
            while(!OK);
            if(L>0) b.setBookName(input);
            double newPrice = -1.0;
            do{
                System.out.println("New price: ");
                input = MyUtil.sc.nextLine().trim();
                if(!input.isEmpty())
                    newPrice = Double.parseDouble(input);
                OK = input.isEmpty() || newPrice >= 0.0;
            }
            while(!OK);
            if(newPrice >= 0) b.setPrice(newPrice);
            int newQuantity = -1;
            do{
                System.out.println("New quantity: ");
                input = MyUtil.sc.nextLine().trim();
                if(!input.isEmpty())
                    newQuantity = Integer.parseInt(input);
                OK = input.isEmpty() || newQuantity >= 0;
            }
            while(!OK);
            if(newQuantity >= 0) {
                b.setQuantity(newQuantity);
                b.setStatus(newQuantity > 0? "Available" : "Not Available");
            }
            do{
                System.out.println("New Publisher ID: ");
                input = MyUtil.sc.nextLine().trim().toUpperCase();
                if(input.isEmpty()) break;
                else if(pL.getAll().indexOf(new Publisher(input)) >= 0) break;
            }
            while(true);
            if(!input.isEmpty()) b.setPublisherId(input);
            System.out.println("Updated.");
        }
    }
    
    public void print() {
        Collections.sort(bL);
        for(Book b: bL) System.out.println(b);
    }
    
    public boolean hasPublisher(String pubId) {
        for(Book b: bL)
            if(b.getPublisherId().equalsIgnoreCase(pubId))
                return true;
        return false;
    }
}
