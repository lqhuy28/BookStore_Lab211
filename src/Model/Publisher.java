package Model;

public class Publisher implements Comparable<Publisher>{
    String publisherId;
    String publisherName;
    String phone;

    public Publisher(String publisherId, String publisherName, String phone) {
        this.publisherId = publisherId;
        this.publisherName = publisherName;
        this.phone = phone;
    }
    
    public Publisher(String PublisherId) {
        this.publisherId = PublisherId;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public boolean equals(Object obj) {
        Publisher p = (Publisher)obj;
        return this.publisherId.equalsIgnoreCase(p.publisherId);
    }

    @Override
    public String toString() {
        return this.publisherId +", " + this.publisherName + ", " + this.phone;
    }

    @Override
    public int compareTo(Publisher o) {
         return this.getPublisherName().compareTo(o.getPublisherName());
    }
    
    
}
