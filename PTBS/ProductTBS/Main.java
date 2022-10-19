package SER515.ProductTBS;

import java.io.IOException;

public class Main {
        public static void main(String[] args) {
            System.out.println("Facade Design Pattern");
            Facade facade = new Facade();
            try {
                if(facade.login()){
                    facade.createProductList();
                    facade.AttachProductToUser();
//                    facade.SelectProduct();
                    System.out.println("Bridge Design Pattern");
                    facade.productOperation();
                }
                else{
                    System.out.println("Should see");
                }

            } catch (IOException e) {
                System.out.println("Unable to read the input file");
            }


        }
}
