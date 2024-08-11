package control;

import model.AVLTree;
import model.ServiceOrder;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ServiceOrderController {
    FileAcess fileAcess = new FileAcess();
    AVLTree serviceOrders = fileAcess.readSOFile("C:\\Users\\Rock\\IdeaProjects\\Cache-Eviction\\src\\file\\serviceOrders.txt");
    Scanner input = new Scanner(System.in);

    public ServiceOrderController() throws IOException { }

    public void serviceOrdersList(){
        System.out.println("------- Service Orders List --------\n");

        serviceOrders.inorder();

        System.out.println("\n");
    }

    public void serviceOrderForm() throws IOException {

        System.out.println("------- Service Order Form --------\n");

        System.out.print("Id:" );
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("Client: ");
        String client = input.nextLine();

        System.out.print("Description: ");
        String description = input.nextLine();

        System.out.print("Deadline: ");
        LocalDateTime deadline = LocalDateTime.parse(input.nextLine());

        ServiceOrder serviceOrder = new ServiceOrder(id, name, client, description, deadline);
        serviceOrders.insertNode(serviceOrder.getId(), serviceOrder);

        fileAcess.WriteFile("C:\\Users\\Rock\\IdeaProjects\\Cache-Eviction\\src\\file\\serviceOrders.txt", serviceOrders.inorderString());

    }


}
