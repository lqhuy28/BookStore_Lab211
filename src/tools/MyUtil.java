package tools;
import java.util.Scanner;

public class MyUtil {
    public static final Scanner sc = new Scanner(System.in);
    //Kiểm tra chuỗi có đúng dạng quy định trong regEx không
    public static boolean validStr(String str, String regEx) {
        return str.matches(regEx);
    }
    
    //Nhập chuỗi có độ dài min..max
    public static String readString(String message, int minL, int maxL) {
        if(minL > maxL) {
            int t = minL; minL = maxL; maxL = t;
        }
        String input = "";
        boolean OK;
        do{
            System.out.println(message + ": ");
            input = sc.nextLine().trim();
            int L = input.length();
            OK = (L >= minL && L <= maxL);
        }
        while(!OK);
        return input;
    }
    
    //Nhập 1 chuỗi theo mẫu pattern
    public static String readPattern(String message, String pattern) {
        String input;
        boolean OK;
        do{
            System.out.print(message + ": ");
            input = sc.nextLine().trim();
            OK = validStr(input, pattern);
        }
        while(!OK);
        return input;
    }
    
    //Đọc 1 int >= min
    public static int readInt(String message, int min) {
        String input;
        int result;
        boolean OK;
        do{
            System.out.println(message + ": ");
            input = sc.nextLine().trim();
            result = Integer.parseInt(input);
            OK = result >= min;
        }
        while(!OK);
        return result;
    }

    //Đọc 1 double >= min
    public static double readDouble(String message, double min) {
        String input;
        double result;
        boolean OK;
        do{
            System.out.println(message + ": ");
            input = sc.nextLine().trim();
            result = Double.parseDouble(input);
            OK = result >= min;
        }
        while(!OK);
        return result;
    }
}