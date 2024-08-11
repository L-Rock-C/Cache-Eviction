package app;

import control.ServiceOrderController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        ServiceOrderController SOController = new ServiceOrderController();

        int choice;
        boolean on = true;

        while(on){

            menu();
            choice = input.nextInt();
            switch (choice){
                case 1:
                    SOController.serviceOrdersList();
                    break;
                case 3:
                    SOController.serviceOrderForm();
                    break;
                case 5:
                    on = false;
                    break;
                default:
                    System.out.println("Invalid value\n");
                    break;
            }

        }


    }

    public static void menu(){
        System.out.println("------- Service Order Menu --------\n");

        System.out.println("[1] - List Service Orders");
        System.out.println("[2] - Edit Service Order");
        System.out.println("[3] - Sign Service Order");
        System.out.println("[4] - Delete Service Order");
        System.out.println("[5] - Exit\n");

        System.out.print("Choice: ");
    }
}
