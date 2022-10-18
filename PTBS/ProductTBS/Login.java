package SER515.ProductTBS;


import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class Login{

    public int login() throws IOException {
        System.out.println("Enter you name:");
        BufferedReader readerName = new BufferedReader(
                new InputStreamReader(System.in));
        String name = readerName.readLine();
        System.out.println("Enter you password:");
        BufferedReader readerPass = new BufferedReader(
                new InputStreamReader(System.in));
        String pass = readerPass.readLine();
        System.out.println(name);
        System.out.println(pass);


        // If buyer is the one logging

        File file = new File("PTBS/BuyerInfo.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String bt;

        while ((bt = br.readLine()) != null) {
            String[] arrOfStr = bt.split(":");
//			System.out.println(arrOfStr[0]);

            if(arrOfStr[0].equals(name)){
//				System.out.println(arrOfStr[1]);

                if (arrOfStr[1].equals(pass)){
                    return 0;
                }
                else{
                    System.out.println("Password doesn't match for the username as Buyer");
                    return login();
                }
            }
        }


        // If seller is the one logging

        File files = new File("PTBS/SellerInfo.txt");

        BufferedReader sr = new BufferedReader(new FileReader(files));

        String st;

        while ((st = sr.readLine()) != null) {
            String[] arrOfStr = st.split(":");

//			System.out.println(arrOfStr[0]);

            if(arrOfStr[0].equals(name)){
//				System.out.println(arrOfStr[1]);

                if (arrOfStr[1].equals(pass)){
                    return 1;
                }
                else{
                    System.out.println("Password doesn't match for the username as Seller");
                    return login();
                }
            }
        }


        System.out.println("Username couldn't be found");
        return login();
    }

}
