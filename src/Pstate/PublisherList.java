package Pstate;
import Model.Publisher;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import tools.MyUtil;

public class PublisherList {
    List<Publisher> pL= new ArrayList();
    String fName = "src\\Data\\Publisher.dat";
    public void readFromFile(){
        File f= new File(fName);
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
                String ID = stk.nextToken().trim().toUpperCase();
                String name = stk.nextToken().trim().toUpperCase();
                String phone = stk.nextToken().trim().toUpperCase();
                Publisher p = new Publisher(ID, name, phone);
                pL.add(p);
            }
            bf.close();
            fr.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public void writeToFile() {
        if(pL.isEmpty())
            System.out.println("Empty list!");
        else {
            try{
            PrintWriter pw = new PrintWriter(fName);
            for(Publisher p: pL) pw.println(p);
            pw.close();
            System.out.println("Writng file: DONE.");
            } catch(Exception e){
                System.out.println("Error save.");
            }
        }
        
    }
    
    public void addPublisher() {
        String ID, name, phone;
        System.out.println("Data of new publisher: ");
        int pos;
        do{
            ID = MyUtil.readPattern("ID", "P[\\d]{5}");
            pos = pL.indexOf(new Publisher(ID));
            if(pos >= 0) System.out.println("ID is duplicated!");
        }
        while(pos >= 0);
        name = MyUtil.readString("Name", 5, 30);
        phone = MyUtil.readPattern("Phone", "[\\d]{10,12}");
        Publisher p = new Publisher(ID, name, phone);
        pL.add(p);
        System.out.println("Added.");
    }
    
    public void search() {
        String ID;
        System.out.println("ID of searched publisher: ");
        ID = MyUtil.sc.nextLine().trim().toUpperCase();
        int pos = pL.indexOf(new Publisher(ID));
        if(pos < 0) System.out.println("Not found!");
        else System.out.println("Found: " + pL.get(pos));
    }
    
    public void removePublisher() {
        String ID;
        System.out.println("ID of remove publisher: ");
        ID = MyUtil.sc.nextLine().trim().toUpperCase();
        int pos = pL.indexOf(new Publisher(ID));
        if(pos < 0) System.out.println("Publisher's ID does not exist!");
        else {
            pL.remove(pos);
            System.out.println("Removed.");
        }
    }
    
    public void updatePublisher() {
        String ID;
        String name;
        String phone;
        System.out.println("ID of update publisher: ");
        ID = MyUtil.sc.nextLine().trim().toUpperCase();
        int pos = pL.indexOf(new Publisher(ID));
        if(pos < 0) System.out.println("Publisher's ID does not exist!");
        else {
            Publisher p = pL.get(pos);
            name = MyUtil.readString("New name", 5, 30);
            phone = MyUtil.readPattern("New phone", "[\\d]{10,12}");
            p.setPublisherName(name);
            p.setPhone(phone);
            System.out.println("Updated.");
        }
    }
    
    public void print() {
        Collections.sort(pL);
        for(Publisher p : pL)
            System.out.println(p);
    }
    
    public List<Publisher> getAll() {
        return pL;
    }
}
