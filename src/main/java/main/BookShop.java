package main;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BookShop extends Bill{


        public static Item [] itemAvailable = new Item[50];
        private static Map<String,String> map = new LinkedHashMap<String,String>();
        private static int count=3;
        public static boolean forExecute = true;
        public static int registration_count = 0;
        public static File file;
        public static String fileName = "people.txt";

        public static void main(String args[]) throws IOException, InterruptedException {
                while(forExecute) {
                        executeTheStart();
                        System.out.print("Have you registered? Y/N?");
                        System.out.println("");
                }
        }

        static void executeTheStart() throws InterruptedException, IOException {
                map.put("saihemanth", "project755");
                Scanner in = new Scanner(System.in);
                if(registration_count==0)
                System.out.print("Have you registered? Y/N?");
                registration_count++;
                String reg = in.nextLine();
                if(reg.equals("Y") || reg.equals("y"))
                {
                System.out.print("Please enter the username");
                System.out.println("");
                String user = in.nextLine();
                System.out.print("Please enter the password");
                System.out.println("");
                String password = in.nextLine();

//                map.put(user,password);
//                        FileWriter fw = new FileWriter(fileName,true);
//                        BufferedWriter bw=new BufferedWriter(fw);
//                        PrintWriter pw=new PrintWriter(bw);
//                        String str = user + ","+ password;
//                        pw.println(str);
//                        pw.close();
//
                        BufferedReader br = new BufferedReader(new FileReader("C:\\Sai\\my Projects\\Book-Shop-Management-master\\Book-Shop-Management-master\\people.txt"));
                        String line;
                        String fin ="";
                        while((line = br.readLine())!= null)
                        {
                                fin +=line;
                                fin +=",";
                        }
                        br.close();
                        String div[] = fin.split(",");
                        for(int i=0;i<div.length-1;i++)
                        {
                                map.put(div[i],div[i+1]);
                        }



                        for (Map.Entry<String, String> entry : map.entrySet()) {
                                String allKeys = "";
                                String allValues = "";
                                Set keys = map.keySet();
                                Iterator i = keys.iterator();
                                while (i.hasNext()) {
                                        allKeys +=i.next();
                                }
                                Collection getValues = map.values();
                                i = getValues.iterator();
                                while (i.hasNext()) {
                                        allValues += i.next();
                                }


                                if (allKeys.contains(user) && allValues.contains(password)) {
                                        System.out.print("Login Successful!");
                                        System.out.println(" ");
                                        executeTheRest();
                                        forExecute = false;
                                        break;
                                } else {
                                        System.out.print("user entered the wrong credentials");
                                        System.out.println("");
                                        System.out.println("only " + (--count) + " chances left");
                                        System.out.println("Please click enter to continue");
                                        if (count == 0) {
                                                System.out.print("Due to wrong credentials User cannot login for one min! Please try after 1 min");
                                                System.out.println("");
                                                TimeUnit.MINUTES.sleep(1);
                                                count = 3;
                                                executeTheStart();
                                        }
                                        executeTheStart();

                                }
                        }

                }
                else if(reg.equals("N") || reg.equals("n"))
                {
                        System.out.println("Username");
                        String userName = in.nextLine();
                        System.out.println("Password");
                        String passWord = in.nextLine();
                        map.put(userName,passWord);
//                        System.out.println(map);

                        FileWriter fw = new FileWriter(fileName,true);
                        BufferedWriter bw=new BufferedWriter(fw);
                        PrintWriter pw=new PrintWriter(bw);
                        String str = userName + ","+ passWord;

                        pw.println(str);
                        pw.close();


                        BufferedReader br = new BufferedReader(new FileReader("C:\\Sai\\my Projects\\Book-Shop-Management-master\\Book-Shop-Management-master\\people.txt"));
                        String line;
                        String fin ="";
                        while((line = br.readLine())!= null)
                        {
                               fin +=line;
                               fin +=",";
                        }
                        br.close();
                        String div[] = fin.split(",");
                        for(int i=0;i<div.length-1;i++)
                        {
                                map.put(div[i],div[i+1]);
                        }


                        System.out.println("registration successful!");





                        System.out.println("Please enter the username");
                        String user = in.nextLine();
                        System.out.println("Please enter the password");
                        String password = in.nextLine();

                        for (Map.Entry<String, String> entry : map.entrySet()) {
                               String allKeys = "";
                               String allValues = "";
                                Set keys = map.keySet();
                                Iterator i = keys.iterator();
                                while (i.hasNext()) {
                                       allKeys +=i.next();
                                }
                                Collection getValues = map.values();
                                i = getValues.iterator();
                                while (i.hasNext()) {
                                        allValues += i.next();
                                }



                                if (allKeys.contains(user) && allValues.contains(password)) {
                                        System.out.print("Login Successful!");
                                        System.out.println(" ");
                                        executeTheRest();
//                                        forExecute = false;
//                                        break;
                                } else {
                                        System.out.print("user entered the wrong credentials");
                                        System.out.println("");
                                        System.out.println("only " + (--count) + " chances left");
                                        System.out.print("Please click enter to continue");
                                        executeTheStart();
                                        if (count == 0) {
                                                System.out.print("Please try after 1 min");
                                                System.out.println("");
                                                TimeUnit.MINUTES.sleep(1);
                                                count = 3;
                                                executeTheStart();
                                        }
                                }
                        }

                }
                else {
                        System.out.println("Have you registered? Y/N" +"");
                        executeTheStart();
                }

        }
        static void executeTheRest(){

                for (int i = 0; i < 50; i++) {
                        itemAvailable[i] = new Item();
                }

                itemAvailable[0].addItem("To kill a mockingbird", 40);
                itemAvailable[1].addItem("My experiment with truth", 156);
                itemAvailable[2].addItem("when breath becomes air", 70);
                itemAvailable[3].addItem("Into thin air", 16);
                itemAvailable[4].addItem("red notice", 19);
                itemAvailable[5].addItem("Boys in the Boat", 168);
                itemAvailable[6].addItem("Just mercy", 45);
                itemAvailable[7].addItem("red label", 140);
                itemAvailable[8].addItem("Mountain beyond mountains", 650);
                itemAvailable[9].addItem("Just kids", 77);
                itemAvailable[10].addItem("The Autobiography of Benjamin Franklin", 14);
                itemAvailable[11].addItem("Night", 36);
                itemAvailable[12].addItem("The Glass Castle", 87);
                itemAvailable[13].addItem("nuttella", 240);
                itemAvailable[14].addItem("Dove", 143);
                itemAvailable[15].addItem("Not Fade Away", 82);
                itemAvailable[16].addItem("Money Ball", 84);
                itemAvailable[17].addItem("Sai", 100);


                System.out.println("S.no" + "    " + "itemName" + "     " + "           MRP");
                for (int i = 0; i <= 17; i++) {
                        System.out.println((i + 1) + "    " + itemAvailable[i].itemName + "    " + itemAvailable[i].mrp + '\n');
                }
                addToCart();

                // System.out.println("Checkout? Enter your Name:");
        }
                public static void addToCart() {
                        System.out.println("Select from the above products and write its quantity[-1 to exit]:(ex- 3 6 , this means you want the 3rd product and the quantity should be 6. )");

                        int take1, take2;
                        int j = 0;
                        Scanner sc = new Scanner(System.in);
                        Cart c1 = new Cart();
                        take1 = sc.nextInt(); //product name
                        int previousTake = take1;
                        while (take1 != -1) {
                                take2 = sc.nextInt(); //quantity
                                c1.updateCart(itemAvailable[take1 - 1], take2);
                                take1 = sc.nextInt();
                                // previousTake=take1;
                        }
                        if (take1 == -1 && previousTake > 0) {
                                sc.nextLine();
                                System.out.println("Please type your name to generate the bill :");
                                String s = sc.nextLine();
                                CustomerName cn = new CustomerName();
                                cn.setName(s);
//                                System.out.println("Please type your EmailId:");
//                                String email = sc.nextLine();
//                                cn.setEmail(email);
                                c1.finalizeCart(cn.getName());

                                System.out.println("-------------------------------------------------------");
                                System.exit(0);

                        } else {
                                System.out.println("You did not select any books. Please select any books to proceed");
                                addToCart();
                        }
                }




}
