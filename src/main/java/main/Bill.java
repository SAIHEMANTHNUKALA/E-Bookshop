package main;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Bill extends CustomerName{
    //bill no & date
    //methods like totalAmt ,printBill,discount
    String userEmail = "";
    public static String getRandomNumberString() {
        // It wishopTestll generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
    String billNo;
    String date;
    public void getBill(String name){
        Scanner in = new Scanner(System.in);
        System.out.println("Please type your EmailId:");
        String str = in.nextLine();
        billNo = getRandomNumberString();
//        System.out.print("test"+" "+name+" "+email);
        Date d = new Date();
        date = d.toString();
        System.out.println('\n');
        System.out.println("-------------------------------------------------------");
        System.out.println("             E-BookShop         ");
        System.out.println("             ----------         ");
        System.out.println("|  Bill No: "+billNo+" "+date+'\n');
        System.out.println("|  Customers Name: "+ name+'\n');
        System.out.println("|  Customers EmailId: "+ str+'\n');
    }
    public void getEmail(String email){
        userEmail = email;
    }
}