package control;

import model.AVLTree;
import model.Node;
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
        System.out.println(serviceOrders.getNodeList());

    }

    public void serviceOrderEdit(){
        System.out.println("------- Service Order Edit --------\n");

        serviceOrders.inorder();
        serviceOrders.showNodeList();

        System.out.print("Select an id of a service order to edit it: ");
        int choice = input.nextInt();

        Node chosen = serviceOrders.getNode(serviceOrders.getRoot(), choice);

        if(chosen != null){
            System.out.println();
        }

        System.out.println("[1] Id:" );
        System.out.println("[2] Name: ");
        System.out.println("[3] Client: ");
        System.out.println("[4] Description: ");
        System.out.println("[5] Deadline: ");

        System.out.println();
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
        serviceOrders.inorder();

        fileAcess.WriteFile("C:\\Users\\Rock\\IdeaProjects\\Cache-Eviction\\src\\file\\serviceOrders.txt", serviceOrders.getNodeList());

    }

    public void serviceOrderDelete(){
        System.out.println("------- Service Order Delete --------\n");

        System.out.println("Em implementação");

        System.out.println();
    }
}
