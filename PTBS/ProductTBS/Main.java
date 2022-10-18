package SER515.ProductTBS;

import java.io.IOException;

public class Main {
        public static void main(String[] args) {
            Facade facade = new Facade();
            try {
                if(facade.login()){
                    facade.createProductList();
                }
                else{
                    System.out.println("Should see");
                }

            } catch (IOException e) {
                System.out.println("Unable to read the input file");
            }


        }
}
