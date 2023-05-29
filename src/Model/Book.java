package Model;

public class Book implements Comparable<Book>{
    String bookId;
    String bookName;
    double price;
    int quantity;
    String publisherId;
    String status = "Available";

    public Book(String bookId, String bookName, double price, int quantity, String publisherId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.quantity = quantity;
        this.publisherId = publisherId;
        status = (quantity > 0)? "Available" : "Not Available";
    }
    
    public Book(String bookId) {
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        Book b = (Book)obj;
        return this.bookId.equalsIgnoreCase(b.bookId);
    }

    @Override
    public String toString() {
        return bookId + ", " + bookName + ", " + price + ", " + quantity + ", " + publisherId + ", " + status;
    }
    
    @Override
    public int compareTo(Book o) {
        if(this.getQuantity() > o.getQuantity()) return -1; 
        else if(this.getQuantity() < o.getQuantity()) return 1;
        else {
            if(o.getPrice() < this.getPrice()) return 1;
            else return -1;
        }
    }  
}
